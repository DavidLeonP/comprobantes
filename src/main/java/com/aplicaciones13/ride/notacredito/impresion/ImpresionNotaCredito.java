package com.aplicaciones13.ride.notacredito.impresion;


import com.aplicaciones13.impresion.ImpresionBaseIText;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ImpresionNotaCredito extends ImpresionBaseIText {

    public static int FORMATO_JEREMIAS = 1;
    public static int FORMATO_SRI = 2;

    /**Metodo para iniciar el objeto.
     *
     */
    public ImpresionNotaCredito() {
        super();
    }

    /**Metodo para ejecutar la impresión
     *
     * @param datosNotaCredito
     */
    public void ejecutar(DatosNotaCredito datosNotaCredito, int formato) {
        imprimirGenerico(datosNotaCredito, formato);
    }

    /** Metodo para realizar la impresion de cualquier documento o orden del mismo.
     *
     *  Configura la pagina
     *  Prepara documento sobre el Sream de salida
     *  Abre el documento
     *  De acuerdo al tipo de impresion ejecuta
     *  Cierra el documento (contiene el Stream).
     *
     * @param datosNotaCredito
     */
    private void imprimirGenerico(DatosNotaCredito datosNotaCredito, int formato) {
        Document documento = new Document();
        documento.setPageSize(PageSize.A4);
        documento.setMargins(36, 28, 28, 28);
        try {
            setPdfWriter(PdfWriter.getInstance(documento,
                                               getByteArrayOutputStream()));
            getPdfWriter().setBoxSize(BOX_SIZE_NOMBRE,
                                      new Rectangle(36, 54, 559, 788));
        } catch (DocumentException e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE,
                                                            e.toString());
            return;
        }
        documento.open();


        if (FORMATO_JEREMIAS == formato)
            imprimirJeremias(datosNotaCredito, documento);

        if (FORMATO_SRI == formato)
            imprimirSRI(datosNotaCredito, documento);

        documento.close();
    }

    /** Formato de impresion completo.
     *
     * Inicializa un nuevo objeto de impresion de elementos
     * Inicializa el documento (contiene Stream)
     * Inicializa el PDFWriter
     * Inicializa la conexion a la base de datos
     * Inicializa el codigo que va ha consultar
     * Configurar los elementos a ser impresos
     * Ingresa el titulo
     * Escribe la impresion
     *
     *
     * @param datosNotaCredito
     * @param documento
     */
    private synchronized void imprimirJeremias(DatosNotaCredito datosNotaCredito,
                                               Document documento) {
        setImpresionBaseElementos(new ImpresionElementosNotaCredito());
        getImpresionBaseElementos().setDocumento(documento);
        getImpresionBaseElementos().setPdfWriter(getPdfWriter());

        ((ImpresionElementosNotaCredito)getImpresionBaseElementos()).setDatosNotaCredito(datosNotaCredito);

        getImpresionBaseElementos().elementosAImprimir("0", "1", "2", "3", "4",
                                                       "5", "6", "7", "8",
                                                       "9","14");
        getImpresionBaseElementos().escribir();
    }

    /** Formato de impresion completo.
     *
     * Inicializa un nuevo objeto de impresion de elementos
     * Inicializa el documento (contiene Stream)
     * Inicializa el PDFWriter
     * Inicializa la conexion a la base de datos
     * Inicializa el codigo que va ha consultar
     * Configurar los elementos a ser impresos
     * Ingresa el titulo
     * Escribe la impresion
     *
     *
     * @param datosNotaCredito
     * @param documento
     */
    private synchronized void imprimirSRI(DatosNotaCredito datosNotaCredito,
                                          Document documento) {
        setImpresionBaseElementos(new ImpresionElementosNotaCredito());
        getImpresionBaseElementos().setDocumento(documento);
        getImpresionBaseElementos().setPdfWriter(getPdfWriter());

        ((ImpresionElementosNotaCredito)getImpresionBaseElementos()).setDatosNotaCredito(datosNotaCredito);

        getImpresionBaseElementos().elementosAImprimir("0", "1", "10", "11",
                                                       "12", "13", "15", "9","14");

        getImpresionBaseElementos().escribir();
    }
}
