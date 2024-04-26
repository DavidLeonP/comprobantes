package com.aplicaciones13.documentos.impresion.ensamble;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.EncryptionConstants;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfVersion;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.StampingProperties;
import com.itextpdf.kernel.pdf.WriterProperties;
import com.itextpdf.layout.Document;
import com.itextpdf.signatures.BouncyCastleDigest;
import com.itextpdf.signatures.DigestAlgorithms;
import com.itextpdf.signatures.IExternalDigest;
import com.itextpdf.signatures.IExternalSignature;
import com.itextpdf.signatures.PdfSignatureAppearance;
import com.itextpdf.signatures.PdfSigner;
import com.itextpdf.signatures.PrivateKeySignature;
import com.aplicaciones13.documentos.impresion.elementos.presentacion.Cenefa;
import com.aplicaciones13.documentos.impresion.elementos.presentacion.CenefaEstructura;
import com.aplicaciones13.documentos.utilidades.Bundle;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.Security;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/**
 * Objeto con los datos de impresiones base de itext.
 *
 * @author omargo33
 *
 */
@Slf4j
@Data
public class ImpresionITextBase {

    /**
     * Manejo de mensajes.
     */
    Bundle bundle = new Bundle("elementos-base");

    Cenefa cenefaSuperior;
    Cenefa cenefaInferior;
    Document document;
    PageSize pageSize;
    PdfDocument pdfDocument;

    SecureRandom random = new SecureRandom();
    int i = random.nextInt();

    private final String pahtTemporal = System.getProperty("user.home") + System.getProperty("file.separator") + new Date().getTime() + i;
    private CenefaEstructura cenefaEstructuraSuperior;
    private CenefaEstructura cenefaEstructuraInferior;
    private ImpresionElementosBase impresionElementosBase;
    private ByteArrayOutputStream byteArrayOutputStream;

    /**
     * Metodo para crear el objeto.
     *
     * @param impresionBaseElementos
     */
    public ImpresionITextBase(ImpresionElementosBase impresionElementosBase) {
        init(impresionElementosBase);
    }

    /**
     * Metodo para inicialiar el objeto.
     *
     */
    private void init(ImpresionElementosBase impresionElementosBase) {
        this.impresionElementosBase = impresionElementosBase;
        setByteArrayOutputStream(new ByteArrayOutputStream());
        cenefaEstructuraSuperior = new CenefaEstructura(false, false, false, false, false, null);
        cenefaEstructuraInferior = new CenefaEstructura(false, false, false, false, false, null);
        pageSize = PageSize.A4;

        cenefaSuperior = new Cenefa(true, pageSize) {
            @Override
            public Document getDocumentoPadre() {
                return document;
            }

            @Override
            public PdfDocument getPdfDocument() {
                return pdfDocument;
            }
        };

        cenefaInferior = new Cenefa(false, pageSize) {
            @Override
            public Document getDocumentoPadre() {
                return document;
            }

            @Override
            public PdfDocument getPdfDocument() {
                return pdfDocument;
            }
        };
    }

    /**
     * Metodo para crear un path temporal.
     *
     * @return
     */
    private OutputStream crearFilePathTemporal() {
        try {
            return new FileOutputStream(pahtTemporal);
        } catch (FileNotFoundException ex) {
            log.warn(".crearFilePathTemporal() {}", ex.toString());
        }
        return null;
    }

    /**
     * Metodo para crear un FileImput.
     *
     * @param mapaParametros
     * @return
     */
    private InputStream crearFileInputArchivo12(Map<String, String> mapaParametros) {
        try {
            return new FileInputStream(mapaParametros.get("documentoArchivoP12"));
        } catch (FileNotFoundException ex) {
            log.warn(".crearFileInputArchivo12() {}", ex.toString());
        }
        return null;
    }

    /**
     * Metodo para guardar agregando una firma electronica.
     *
     * @param currentPosition
     * @param mapaParametros
     */
    public void guardar(ImpresionElementosBase.CurrentPosition currentPosition, Map<String, String> mapaParametros) {
        try {
            String alias = "";
            String clave = mapaParametros.get("documentoArchivoP12Clave");
            PrivateKey pk = null;

            //Proveedor de seguridades
            BouncyCastleProvider provider = new BouncyCastleProvider();
            Security.addProvider(provider);

            //Certificado del archivo p12
            KeyStore ks = KeyStore.getInstance("pkcs12", provider.getName());
            ks.load(crearFileInputArchivo12(mapaParametros), clave.toCharArray());

            for (String str : Collections.list(ks.aliases())) {
                pk = (PrivateKey) ks.getKey(str, clave.toCharArray());                
                if (pk != null) {
                    alias = str;
                    break;
                }
            }

            Certificate[] chain = ks.getCertificateChain(alias);

            //Firma del documento digital
            InputStream inputStream = new ByteArrayInputStream(getByteArrayOutputStream().toByteArray());
            PdfReader pdfReader = new PdfReader(inputStream);
            PdfSigner signer = new PdfSigner(pdfReader, crearFilePathTemporal(), new StampingProperties());
            signer.setFieldName("Firma");

            //Asentar la firma en el archivo
            firmarArchivo(provider, pk, chain, currentPosition, mapaParametros, signer);
        } catch (IOException | GeneralSecurityException e) {
            log.warn(".guardar() {}", e.toString());
            guardar();
        }
    }

    /**
     * Metodo para firmar el archivo.
     *
     * @param provider
     * @param pk
     * @param chain
     * @param currentPosition
     * @param mapaParametros
     * @param signer
     * @throws IOException
     * @throws GeneralSecurityException
     */
    private void firmarArchivo(BouncyCastleProvider provider, PrivateKey pk, Certificate[] chain, ImpresionElementosBase.CurrentPosition currentPosition, Map<String, String> mapaParametros, PdfSigner signer) throws IOException, GeneralSecurityException {
        //Presentacion de la firma electrionica 
        PdfSignatureAppearance pdfSignatureAppearance = signer.getSignatureAppearance();
        pdfSignatureAppearance.setReason(getNombreDocumento(mapaParametros));
        pdfSignatureAppearance.setLocation(String.valueOf(mapaParametros.get("documentoSucursal")));
        pdfSignatureAppearance.setReuseAppearance(false);
        pdfSignatureAppearance.setPageRect(new Rectangle(currentPosition.getX(), currentPosition.getY(), currentPosition.getAncho(), 60));
        pdfSignatureAppearance.setPageNumber(currentPosition.getPagina());
        pdfSignatureAppearance.setRenderingMode(PdfSignatureAppearance.RenderingMode.DESCRIPTION);
        pdfSignatureAppearance.setLayer2Font(impresionElementosBase.getP().getFontTitulos());
        pdfSignatureAppearance.setLayer2FontSize(8);

        //Firma
        IExternalSignature iExternalSignature = new PrivateKeySignature(pk, DigestAlgorithms.SHA256, provider.getName());
        IExternalDigest iExternalDigest = new BouncyCastleDigest();
        signer.signDetached(iExternalDigest, iExternalSignature, chain, null, null, null, 0, PdfSigner.CryptoStandard.CMS);
    }

    /**
     * Metodo para guardar el documento del sistema.
     *
     */
    public void guardar() {
        try {
            try ( OutputStream outputStream = new FileOutputStream(pahtTemporal)) {
                getByteArrayOutputStream().writeTo(outputStream);
            }
        } catch (IOException e) {
            log.warn(".guardar() 1 {}", e.toString());
        }
    }

    /**
     * Metodo para realizar la impresion de cualquier documento o orden del
     * mismo.Sole ejecuta si hay datos a imprimir Configura la pagina Prepara
     * documento sobre el Sream de salida Abre el documento De acuerdo al tipo
     * de impresion ejecuta Cierra el documento (contiene el Stream).
     *
     * @param margenSuperior
     * @param margenDerecho
     * @param margenInferior
     * @param margenIzquierdo
     * @param mapaParametros
     */
    public void ejecutar(float margenSuperior, float margenDerecho, float margenInferior, float margenIzquierdo, Map<String, String> mapaParametros) {
        try {
            PdfWriter pdfWriter = new PdfWriter(getByteArrayOutputStream(), new WriterProperties().setPdfVersion(PdfVersion.PDF_2_0));
            pdfDocument = new PdfDocument(pdfWriter);
            document = new Document(pdfDocument, pageSize, false);
            document.setMargins(margenSuperior, margenDerecho, margenInferior, margenIzquierdo);
            impresionElementosBase.setDocumento(document);
            impresionElementosBase.setMargenSuperiorOriginal(margenSuperior);
            getCenefaEstructuraSuperior().setNombreDocumento(getNombreDocumento(mapaParametros));
            cenefaSuperior.setCenefaEstructura(getCenefaEstructuraSuperior());
            cenefaSuperior.calibrarHoja();

            getCenefaEstructuraInferior().setNombreDocumento(getNombreDocumento(mapaParametros));

            cenefaInferior.setCenefaEstructura(getCenefaEstructuraInferior());
            cenefaInferior.calibrarHoja();
            impresionElementosBase.setParametrosBusqueda(mapaParametros);
            impresionElementosBase.escribir();
            cenefaSuperior.procesar();
            cenefaInferior.procesar();

            document.flush();
            document.close();
            if (mapaParametros.get("documentoArchivoP12") == null) {
                guardar();
            } else {
                guardar(impresionElementosBase.getCurrentPosition(), mapaParametros);
            }            
            encriptar(mapaParametros);
        } catch (Exception e) {
            log.warn(".ejecutar() {}", e.toString());
        }
    }

    /**
     * Metodo para obtener el nombre del documento para la firma
     *
     * @param mapaParametros
     * @return
     */
    private String getNombreDocumento(Map<String, String> mapaParametros) {
        return bundle.getMessage("txt_000_06",
                String.valueOf(mapaParametros.get("documentoNombre")),
                String.valueOf(mapaParametros.get("documentoCodigo"))
        );
    }

    /**
     * Metodo para encritar los archivos PDF.
     *
     * @throws IOException
     */
    private void encriptar(Map<String, String> mapaParametros) throws IOException {
        try (PdfDocument pdfDoc = new PdfDocument(
                new PdfReader(pahtTemporal),
                new PdfWriter(
                        String.valueOf(mapaParametros.get("documentoDestino")), 
                        new WriterProperties().setStandardEncryption(
                            null,
                            pahtTemporal.getBytes(),
                            EncryptionConstants.ALLOW_PRINTING,
                            EncryptionConstants.ENCRYPTION_AES_256 | EncryptionConstants.DO_NOT_ENCRYPT_METADATA)
                        )
            )) {            
            Path pathAbsolute = Paths.get(pahtTemporal);        
            Files.deleteIfExists(pathAbsolute);        
        }        
    }    


    /**
     * Metodo para agregar autenticacion para ver el archivo.
     * 
     * @param mapaParametros
     * @throws IOException
     */
    public void agregarAutenticacion(Map<String, String> mapaParametros) throws IOException{
        String archivoDestino = String.valueOf(mapaParametros.get("documentoDestino"));
        byte[] userPassword = String.valueOf(mapaParametros.get("usuarioPassword")).getBytes();
        byte[] ownerPassword = String.valueOf(mapaParametros.get("ownerPassword")).getBytes();
        
        WriterProperties writerProperties = new WriterProperties();        
        writerProperties.setStandardEncryption(userPassword, ownerPassword, EncryptionConstants.DO_NOT_ENCRYPT_METADATA, EncryptionConstants.ENCRYPTION_AES_128);        
        try (PdfWriter pdfWriter = new PdfWriter(new FileOutputStream(archivoDestino), writerProperties)) {
            try (PdfDocument pdfDoc = new PdfDocument(new PdfReader(pahtTemporal), pdfWriter)){            
                Path pathAbsolute = Paths.get(pahtTemporal);        
                Files.deleteIfExists(pathAbsolute);        
            }
        }        
    }
}
