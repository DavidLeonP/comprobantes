package com.aplicaciones13.ride.notadebito.impresion;


import com.aplicaciones13.impresion.ImpresionBaseElementos;
import com.aplicaciones13.impresion.ImpresionBaseIText;

import com.itextpdf.text.Document;

/**
 * Objeto para armar la impresion de nota de debito.
 * 
 * @author o.velez@13aplicaciones.com
 * 
 */
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
        Document documento = crearDocumento();
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

        getImpresionBaseElementos().elementosAImprimir(ImpresionBaseElementos.ELEMENTO_PIE, "10", "11",
                                                       "12",  "13",  "9", "14", ImpresionBaseElementos.ELEMENTO_FIRMA);

        getImpresionBaseElementos().escribir();
    }
}
