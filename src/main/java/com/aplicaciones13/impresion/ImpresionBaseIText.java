package com.aplicaciones13.impresion;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.ByteArrayOutputStream;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase para tener los elementos de configuracion base.
 * 
 * @author o.velez@13aplicaciones.com
 * 
 */
public class ImpresionBaseIText {

    public static final String BOX_SIZE_NOMBRE = "ART_BOX_SIZE";

    private ImpresionBaseElementos impresionBaseElementos;
    private ByteArrayOutputStream byteArrayOutputStream;
    private PdfWriter pdfWriter;

    /**
     * Constructor.
     */
    public ImpresionBaseIText() {
        setByteArrayOutputStream(new ByteArrayOutputStream());
        setImpresionBaseElementos(new ImpresionBaseElementos());
    }

    /**
     * Metodo para crear el documento vertical en pagina A4.
     * @return
     */
    public Document crearDocumento() {
        Document documento = new Document();
        documento.setPageSize(PageSize.A4);
        documento.setMargins(36, 28, 28, 28);
        try {
            setPdfWriter(PdfWriter.getInstance(documento, getByteArrayOutputStream()));
            getPdfWriter().setBoxSize(BOX_SIZE_NOMBRE, new Rectangle(36, 54, 559, 788));
        } catch (DocumentException e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING, e.toString());
            return null;
        }

        return documento;
    }

    /**
     * Metodo para ejecutar la impresión
     *
     * @param codigoConsulta
     */
    public void ejecutar(String codigoConsulta) {
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.INFO, codigoConsulta);
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.INFO,
                "Falta sobrecargar el mentodo");
    }

    // propiedades

    public ImpresionBaseElementos getImpresionBaseElementos() {
        return impresionBaseElementos;
    }

    public void setImpresionBaseElementos(ImpresionBaseElementos impresionBaseElementos) {
        this.impresionBaseElementos = impresionBaseElementos;
    }

    public PdfWriter getPdfWriter() {
        return this.pdfWriter;
    }

    public void setPdfWriter(PdfWriter pdfWriter) {
        this.pdfWriter = pdfWriter;
    }

    public ByteArrayOutputStream getByteArrayOutputStream() {
        return this.byteArrayOutputStream;
    }

    public void setByteArrayOutputStream(ByteArrayOutputStream byteArrayOutputStream) {
        this.byteArrayOutputStream = byteArrayOutputStream;
    }
}
