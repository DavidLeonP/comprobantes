package com.aplicaciones13.ride.notadebito.impresion;


import com.aplicaciones13.impresion.ImpresionBaseIText;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ImpresionNotaDebito extends ImpresionBaseIText {

    /**Metodo para iniciar el objeto.
     *
     */
    public ImpresionNotaDebito() {
        super();
    }

    /**Metodo para ejecutar la impresión
     * 
     *  Configura la pagina
     *  Prepara documento sobre el Sream de salida
     *  Abre el documento
     *  De acuerdo al tipo de impresion ejecuta
     *  Cierra el documento (contiene el Stream).
     *
     * @param datosNotaDebito
     */
    public void ejecutar(DatosNotaDebito datosNotaDebito) {        
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

        imprimirSRI(datosNotaDebito, documento);

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
     * @param datosNotaDebito
     * @param documento
     */
    private synchronized void imprimirSRI(DatosNotaDebito datosNotaDebito,
                                          Document documento) {
        setImpresionBaseElementos(new ImpresionElementosNotaDebito());
        getImpresionBaseElementos().setDocumento(documento);
        getImpresionBaseElementos().setPdfWriter(getPdfWriter());
        ((ImpresionElementosNotaDebito)getImpresionBaseElementos()).setDatosNotaDebito(datosNotaDebito);

        getImpresionBaseElementos().elementosAImprimir("0", "1", "10", "11",
                                                       "12",  "13",  "9", "14");

        getImpresionBaseElementos().escribir();
    }
}
