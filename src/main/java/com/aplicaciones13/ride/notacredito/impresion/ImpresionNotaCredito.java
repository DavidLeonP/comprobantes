package com.aplicaciones13.ride.notacredito.impresion;


import com.aplicaciones13.impresion.ImpresionBaseElementos;
import com.aplicaciones13.impresion.ImpresionBaseIText;

import com.itextpdf.text.Document;

/**
 * Objeto para armar la nota de credito.
 * 
 * @author o.velez@13aplicaciones.com
 * 
 */
public class ImpresionNotaCredito extends ImpresionBaseIText {

    /**Metodo para iniciar el objeto.
     *
     */
    public ImpresionNotaCredito() {
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
     * @param datosNotaCredito
     */
    public void ejecutar(DatosNotaCredito datosNotaCredito) {       
        Document documento = crearDocumento();
        documento.open();

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
    private synchronized void imprimirSRI(DatosNotaCredito datosNotaCredito,
                                          Document documento) {
        setImpresionBaseElementos(new ImpresionElementosNotaCredito());
        getImpresionBaseElementos().setDocumento(documento);
        getImpresionBaseElementos().setPdfWriter(getPdfWriter());

        ((ImpresionElementosNotaCredito)getImpresionBaseElementos()).setDatosNotaCredito(datosNotaCredito);

        getImpresionBaseElementos().elementosAImprimir(ImpresionBaseElementos.ELEMENTO_PIE, "10", "11",
                                                       "12", "13", "9",ImpresionBaseElementos.ELEMENTO_FIRMA);

        getImpresionBaseElementos().escribir();
    }
}
