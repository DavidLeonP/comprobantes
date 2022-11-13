package com.aplicaciones13.ride.facturaexportacion.impresion;

import com.aplicaciones13.impresion.ImpresionBaseElementos;
import com.aplicaciones13.impresion.ImpresionBaseIText;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Objeto para armar la impresion.
 *
 * @author omarv omargo33@JeremiasSoft.com
 *
 */
public class ImpresionFactura extends ImpresionBaseIText {

    /**
     * Metodo para iniciar el objeto.
     *
     */
    public ImpresionFactura() {
        super();
    }

    /**
     * Metodo para ejecutar la impresión
     *
     * @param datosFactura
     */
    public void ejecutar(DatosFactura datosFactura) {
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

        imprimirSRI(datosFactura, documento);

        documento.close();
    }

    /**
     * Formato de impresion completo.
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
     * @param datosFactura
     * @param documento
     */
    private synchronized void imprimirSRI(DatosFactura datosFactura,
            Document documento) {
        setImpresionBaseElementos(new ImpresionElementosFactura());
        getImpresionBaseElementos().setDocumento(documento);
        getImpresionBaseElementos().setPdfWriter(getPdfWriter());

        ((ImpresionElementosFactura) getImpresionBaseElementos()).setDatosFactura(datosFactura);

        getImpresionBaseElementos().elementosAImprimir(ImpresionBaseElementos.ELEMENTO_PIE, "10", "11",
                "12", "13", "17", "16",
                "9", ImpresionBaseElementos.ELEMENTO_FIRMA);

        getImpresionBaseElementos().escribir();
    }
}
