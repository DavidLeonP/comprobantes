package com.aplicaciones13.ride.facturaexportacion.impresion;

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

    public static final int FORMATO_JEREMIAS = 1;
    public static final int FORMATO_SRI = 2;

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
    public void ejecutar(DatosFactura datosFactura, int formato) {
        imprimirGenerico(datosFactura, formato);
    }

    /**
     * Metodo para realizar la impresion de cualquier documento o orden del mismo.
     *
     * Configura la pagina
     * Prepara documento sobre el Sream de salida
     * Abre el documento
     * De acuerdo al tipo de impresion ejecuta
     * Cierra el documento (contiene el Stream).
     *
     * @param datosFactura
     */
    private void imprimirGenerico(DatosFactura datosFactura, int formato) {
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

        switch (formato) {
            case FORMATO_JEREMIAS:
                imprimirJeremias(datosFactura, documento);
                break;

            case FORMATO_SRI:
                imprimirSRI(datosFactura, documento);
                break;

            default:
                imprimirSRI(datosFactura, documento);
                break;
        }

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
    private synchronized void imprimirJeremias(DatosFactura datosFactura,
            Document documento) {
        setImpresionBaseElementos(new ImpresionElementosFactura());
        getImpresionBaseElementos().setDocumento(documento);
        getImpresionBaseElementos().setPdfWriter(getPdfWriter());

        ((ImpresionElementosFactura) getImpresionBaseElementos()).setDatosFactura(datosFactura);

        getImpresionBaseElementos().elementosAImprimir("0", "1", "2", "3", "4",
                "5", "6", "7", "8", "15",
                "14", "9", "18");
        getImpresionBaseElementos().escribir();
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

        getImpresionBaseElementos().elementosAImprimir("0", "1", "10", "11",
                "12", "13", "17", "16",
                "9", "18");

        getImpresionBaseElementos().escribir();
    }
}
