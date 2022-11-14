package com.aplicaciones13.ride.comprobanteretencion.impresion;


import com.aplicaciones13.impresion.ImpresionBaseElementos;
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
 * @author o.velez@13aplicaciones.com
 *
 */
public class ImpresionComprobanteRetencion extends ImpresionBaseIText {

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
    public void ejecutar(DatosComprobanteRetencion datosComprobanteRetencion) {
        Document documento = new Document();
        documento.setPageSize(PageSize.A4);
        documento.setMargins(36, 28, 28, 28);
        try {
            setPdfWriter(PdfWriter.getInstance(documento, getByteArrayOutputStream()));
            getPdfWriter().setBoxSize(BOX_SIZE_NOMBRE, new Rectangle(36, 54, 559, 788));
        } catch (DocumentException e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING, e.toString());
            return;
        }
        documento.open();
        
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
    private synchronized void imprimirSRI(DatosComprobanteRetencion datosComprobanteRetencion, Document documento) {
        setImpresionBaseElementos(new com.aplicaciones13.ride.comprobanteretencion.impresion.ImpresionElementosComprobanteRetencion());
        getImpresionBaseElementos().setDocumento(documento);
        getImpresionBaseElementos().setPdfWriter(getPdfWriter());

        ((ImpresionElementosComprobanteRetencion) getImpresionBaseElementos())
            .setDatosComprobanteRetencion(datosComprobanteRetencion);

        getImpresionBaseElementos().elementosAImprimir(ImpresionBaseElementos.ELEMENTO_PIE, "10", "11", "12", "13", "9", ImpresionBaseElementos.ELEMENTO_FIRMA);
        getImpresionBaseElementos().escribir();
    }
}
