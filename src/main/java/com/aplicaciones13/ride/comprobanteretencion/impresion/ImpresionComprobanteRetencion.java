package com.aplicaciones13.ride.comprobanteretencion.impresion;


import com.aplicaciones13.impresion.ImpresionBaseIText;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;

import java.util.logging.Level;
import java.util.logging.Logger;

/** Objeto para armar la impresion del comprobante de rentecion.
 *
 * @author omarv omargo33@JeremiasSoft.com
 *
 */
public class ImpresionComprobanteRetencion extends ImpresionBaseIText {

    public static final int FORMATO_JEREMIAS = 1;
    public static final int FORMATO_SRI = 2;

    /**Metodo para iniciar el objeto.
     *
     */
    public ImpresionComprobanteRetencion() {
        super();
    }

    /**Metodo para ejecutar la impresion
     *
     * @param datosComprobanteRetencion
     */
    public void ejecutar(DatosComprobanteRetencion datosComprobanteRetencion, int formato) {
        imprimirGenerico(datosComprobanteRetencion, formato);
    }

    /** Metodo para realizar la impresion de cualquier documento o orden del mismo.
     *
     *  Configura la pagina
     *  Prepara documento sobre el Sream de salida
     *  Abre el documento
     *  De acuerdo al tipo de impresion ejecuta
     *  Cierra el documento (contiene el Stream).
     *
     * @param datosComprobanteRetencion
     */
    private void imprimirGenerico(DatosComprobanteRetencion datosComprobanteRetencion, int formato) {
        Document documento = new Document();
        documento.setPageSize(PageSize.A4);
        documento.setMargins(36, 28, 28, 28);
        try {
            setPdfWriter(PdfWriter.getInstance(documento, getByteArrayOutputStream()));
            getPdfWriter().setBoxSize(BOX_SIZE_NOMBRE, new Rectangle(36, 54, 559, 788));
        } catch (DocumentException e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, e.toString());
            return;
        }
        documento.open();

        if (FORMATO_JEREMIAS == formato)
            imprimirJeremias(datosComprobanteRetencion, documento);

        if (FORMATO_SRI == formato)
            imprimirSRI(datosComprobanteRetencion, documento);

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
     * @param datosComprobanteRetencion
     * @param documento
     */
    private synchronized void imprimirJeremias(DatosComprobanteRetencion datosComprobanteRetencion,
                                               Document documento) {
        setImpresionBaseElementos(new com.aplicaciones13.ride.comprobanteretencion.impresion.ImpresionElementosComprobanteRetencion());
        getImpresionBaseElementos().setDocumento(documento);
        getImpresionBaseElementos().setPdfWriter(getPdfWriter());

        ((ImpresionElementosComprobanteRetencion) getImpresionBaseElementos())
            .setDatosComprobanteRetencion(datosComprobanteRetencion);

        getImpresionBaseElementos().elementosAImprimir("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "14");
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
     * @param datosComprobanteRetencion
     * @param documento
     */
    private synchronized void imprimirSRI(DatosComprobanteRetencion datosComprobanteRetencion, Document documento) {
        setImpresionBaseElementos(new com.aplicaciones13.ride.comprobanteretencion.impresion.ImpresionElementosComprobanteRetencion());
        getImpresionBaseElementos().setDocumento(documento);
        getImpresionBaseElementos().setPdfWriter(getPdfWriter());

        ((ImpresionElementosComprobanteRetencion) getImpresionBaseElementos())
            .setDatosComprobanteRetencion(datosComprobanteRetencion);

        getImpresionBaseElementos().elementosAImprimir("0", "1", "10", "11", "12", "13", "9", "14");
        getImpresionBaseElementos().escribir();
    }
}
