package com.aplicaciones13.impresion;


import com.itextpdf.text.pdf.PdfWriter;

import java.io.ByteArrayOutputStream;

import java.util.logging.Level;
import java.util.logging.Logger;


public class ImpresionBaseIText {

    public static final  String BOX_SIZE_NOMBRE = "ART_BOX_SIZE";

    private ImpresionBaseElementos impresionBaseElementos;
    private ByteArrayOutputStream byteArrayOutputStream;
    private PdfWriter pdfWriter;


    public ImpresionBaseIText() {
        setByteArrayOutputStream(new ByteArrayOutputStream());
        setImpresionBaseElementos(new ImpresionBaseElementos());
    }

    /**Metodo para ejecutar la impresión
     *
     * @param codigoConsulta
     */
    public void ejecutar(String codigoConsulta) {
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE,codigoConsulta);
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE,
                                                        "Falta sobrecargar el mentodo");
    }

    //propiedades

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
