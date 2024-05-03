package com.aplicaciones13.documentos.impresion.ensamble.ride;

import com.aplicaciones13.documentos.impresion.elementos.texto.Elemento;
import com.aplicaciones13.documentos.impresion.elementos.texto.P;
import com.aplicaciones13.documentos.impresion.ensamble.ImpresionElementosBase;
import com.aplicaciones13.documentos.utilidades.Bundle;
import com.itextpdf.barcodes.Barcode128;
import com.itextpdf.kernel.pdf.xobject.PdfFormXObject;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.HorizontalAlignment;
import com.itextpdf.layout.properties.TextAlignment;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Objeto para crear un documento de factura.
 *
 * @author omargo33
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ImpresionElementosRide extends ImpresionElementosBase {

    private static Bundle bundle = new Bundle("elementos-ride");
    
    Border border = new SolidBorder(1f);
    String razonSocial;
    String direccionMatriz;
    String direccionEstablecimiento;
    String contribuyenteEspecial;
    String obligadoContabilidad;
    String claveAccesoAutorizacion;
    String agenteRetencion;
    String contribuyenteRimpe;
    List<InformacionAdicional> listaInformacionAdicional;
    private Totales totales;
    private FormasPago formasPago;

    /**
     * Constructor para el objeto.
     */
    public ImpresionElementosRide(){
        setListaInformacionAdicional(null);
    }

    /**
     * Metodo para generar el panel superior en un formato semejante al SRI.
     *
     */
    public synchronized void elemento2() {
        getPanel().setListaDimensiones(50f);
        getPanel().getMapaAlineamiento().put(1, TextAlignment.CENTER);
        getPanel().setListaCeldas(informacionEmpresa().toArray());
        getPanel().procesar();
        Table tableIzq = getPanel().getTabla();
        tableIzq.setBorderRight(border);

        getPanel().setListaDimensiones(50f);
        getPanel().getMapaAlineamiento().put(1, TextAlignment.LEFT);
        getPanel().setListaCeldas(informacionDocumento().toArray());
        getPanel().procesar();
        Table tableDer = getPanel().getTabla();

        getPanel().setListaDimensiones(52f, 48f);
        getPanel().setListaCeldas(tableIzq, tableDer);
        getPanel().procesar();
        getPanel().escribir();
    }

    /**
     * Metodo para generar el panel superior con la informacion de la empresa.
     * 
     * @return
     */
    private synchronized List<Object> informacionEmpresa() {
        List<Object> listaLadoIzquerdo = new ArrayList<>();

        // Agregar imagen a la lista
        getImagen().setPathImagen(getParametrosBusqueda().get("pathImagen"));
        getImagen().setMaximoAncho(140);
        getImagen().setMaximoAlto(80);
        getImagen().procesar();
        getImagen().getImagen().setHorizontalAlignment(HorizontalAlignment.CENTER);

        Cell cellimg = new Cell();
        cellimg.setPaddingBottom(5f);
        cellimg.add(getImagen().getImagen());
        listaLadoIzquerdo.add(cellimg);

        // Nombre de la empresa
        getH2().setTexto(getRazonSocial());
        listaLadoIzquerdo.add(getH2().getParagraph());

        // Informacion de la empresa
        getForm().setListaTitulos(bundle.getMessages("fac_001", "fac_002"));
        getForm().setListaValores(getDireccionMatriz(), getDireccionEstablecimiento());
        getForm().setListaFormatos(Elemento.FORMATO_STRING, Elemento.FORMATO_STRING);
        getForm().setListaDimensiones(18.0f, 82.0f);
        getForm().procesar();
        listaLadoIzquerdo.add(getForm().getTabla());
        getForm().reset();

        // Informacion de contabilidad
        if (getContribuyenteEspecial() != null && !getContribuyenteEspecial().isEmpty()) {
            getForm().getListaTitulos().add(bundle.getMessage("fac_003"));
            getForm().getListaValores().add(getContribuyenteEspecial());
            getForm().getListaFormatos().add(Elemento.FORMATO_STRING);
        }

        if (getObligadoContabilidad() != null && !getObligadoContabilidad().isEmpty()) {
            getForm().getListaTitulos().add(bundle.getMessage("fac_004"));
            getForm().getListaValores().add(getObligadoContabilidad());
            getForm().getListaFormatos().add(Elemento.FORMATO_STRING);
        }

        if (getAgenteRetencion() != null && !getAgenteRetencion().isEmpty()) {
            getForm().getListaTitulos().add(bundle.getMessage("fac_014"));
            getForm().getListaValores().add(getAgenteRetencion());
            getForm().getListaFormatos().add(Elemento.FORMATO_STRING);
        }

        getForm().setListaDimensiones(70f, 30f);
        getForm().procesar();
        listaLadoIzquerdo.add(getForm().getTabla());
        getForm().reset();

        // Contribuyente Rimpe
        if (getContribuyenteRimpe() != null && !getContribuyenteRimpe().isEmpty()) {
            getTexto().setParagraph(getContribuyenteRimpe());
            getTexto().getParagraph().setFontSize(P.TEXTO);
            listaLadoIzquerdo.add(getTexto().getParagraph());
        }

        return listaLadoIzquerdo;
    }

    /**
     * Metodo para generar el panel superior en un formato semejante al SRI.
     *
     */
    private List<Object> informacionDocumento() {
        List<Object> listaLado = new ArrayList<>();
        if (getClaveAccesoAutorizacion() == null || getClaveAccesoAutorizacion().isEmpty()) {
            return listaLado;
        }

        String tipoComprobante = getClaveAccesoAutorizacion().substring(8, 10);
        String ruc = getClaveAccesoAutorizacion().substring(10, 23);
        String ambiente = getClaveAccesoAutorizacion().substring(23, 24);
        String establecimiento = getClaveAccesoAutorizacion().substring(24, 27);
        String puntoEmision = getClaveAccesoAutorizacion().substring(27, 30);
        String serie = getClaveAccesoAutorizacion().substring(30, 39);
        String emision = getClaveAccesoAutorizacion().substring(47, 48);

        // Ruc
        getH3().setTexto(bundle.getMessage("fac_005", ruc));
        listaLado.add(getH3().getParagraph());

        // Nombre del documento
        getH3().setTexto(bundle.getMessage("tabla3_" + tipoComprobante));
        listaLado.add(getH3().getParagraph());

        // Numero del documento
        getH3().setTexto(bundle.getMessage("fac_007", establecimiento, puntoEmision, serie));
        listaLado.add(getH3().getParagraph());

        // Numero de autorizacion
        getH3().setTexto(bundle.getMessage("fac_008"));
        listaLado.add(getH3().getParagraph());

        getTexto().setParagraph(getParametrosBusqueda().get("numeroAutorizacion"));
        getTexto().getParagraph().setFontSize(P.TEXTO);
        listaLado.add(getTexto().getParagraph());

        //Autorizacion, Ambiente y Emision
        getForm().setListaTitulos(bundle.getMessages("fac_006", "fac_010", "fac_011"));
        getForm().setListaValores(
                getParametrosBusqueda().get("fechaAutorizacion"),
                bundle.getMessage("tabla4_" + ambiente),
                bundle.getMessage("tabla2_" + emision));
        getForm().setListaFormatos(
                Elemento.FORMATO_STRING,
                Elemento.FORMATO_STRING,
                Elemento.FORMATO_STRING);
        getForm().setListaDimensiones(50f, 50f);
        getForm().procesar();
        listaLado.add(getForm().getTabla());
        getForm().reset();

        // Clave de acceso + codigo de barras
        getH3().setTexto(bundle.getMessage("fac_012"));
        listaLado.add(getH3().getParagraph());

        Barcode128 barcode = new Barcode128(getDocumento().getPdfDocument());
        barcode.setCodeType(Barcode128.CODE128);
        barcode.setCode(getClaveAccesoAutorizacion());

        PdfFormXObject barcodeObject = barcode.createFormXObject(null, null, getDocumento().getPdfDocument());
        Image imagenBarcode = new Image(barcodeObject);
        imagenBarcode.setHorizontalAlignment(HorizontalAlignment.CENTER);

        Cell cell = new Cell().add(imagenBarcode);
        listaLado.add(cell);

        return listaLado;
    }

    /**
     * Metodo para agregar la informacion simple para la informacion del cliente.
     * 
     * @param campo
     * @param bundleKey
     */
    public void escribirCamposSimples(String campo, String bundleKey) {
        if (campo == null || campo.isEmpty()) {
            return;
        }

        getForm().setListaTitulos(bundle.getMessage(bundleKey));
        getForm().setListaValores(campo);
        getForm().setListaFormatos(Elemento.FORMATO_STRING);
        getForm().setListaDimensiones(15f, 85f);
        getForm().procesar();
        getForm().escribir();
        getForm().reset();
    }

    /**
     * Metodo para cargar inforamcion adicional.
     * 
     * @param nombre
     * @param valor
     */
    public void cargarInformacionAdicional(String nombre, String valor) {
        if (listaInformacionAdicional == null) {
            listaInformacionAdicional = new ArrayList<>();
        }

        InformacionAdicional informacion = new InformacionAdicional();
        informacion.setNombre(nombre);
        informacion.setValor(valor);
        listaInformacionAdicional.add(informacion);
    }

    /**
     * Metodo para agregar informacion adicional.
     *
     */
    public synchronized void elementoInformacionAdicional() {
        if (isInformacionAdicional()) {
            getEspacio().escribir(1);
            getLineaSolida().escribir();

            int size = 0;
            getH2().setTexto(bundle.getMessage("gen_002"));
            getH2().escribir();

            for (InformacionAdicional a : getListaInformacionAdicional()) {
                getForm().getListaTitulos().add(a.getNombre());
                getForm().getListaValores().add((a.getValor() == null) ? "" : String.valueOf(a.getValor()));
                getForm().getListaFormatos().add(Elemento.FORMATO_STRING);
                size++;
            }

            if (size > 0) {
                int total = 74 + (12 * size);
                if (getCurrentPosition().getY() < total) {
                    getDocumento().add(new AreaBreak());
                }
                getForm().setListaDimensiones(30f, 70f);
                getForm().procesar();
                getForm().escribir();
                getForm().reset();
            }
        }
    }

    /**
     * Metodo para conocer si la factura tiene informacion adicional.
     * 
     * @return
     */
    public boolean isInformacionAdicional() {
        return (getListaInformacionAdicional() != null && getListaInformacionAdicional().size() > 0);
    }

    /** 
     * Clase para presentear la informacion adicional 
     * 
     */
    @Data    
    public class InformacionAdicional {
        private String nombre;
        private String valor;
    }
}
