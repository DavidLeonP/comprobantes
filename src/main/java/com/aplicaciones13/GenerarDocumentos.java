package com.aplicaciones13;

import com.aplicaciones13.ride.Ejecutor;

/** Objeto de test de Impresiones Factura
 *
 * @author omar velez omargo33@jeremiassoft.com
 *
 */
public class GenerarDocumentos {

    /** Metodo para ejecutar un main.
     *
     * @param args
     */
    public static void main(String[] args) {
        Ejecutor ejecutor = new Ejecutor();
        if(ejecutor.ejecutarFactura(
            "/home/omarv/Documentos/java/DocumentosElectronicos/archivosPruebas/facturaExportacion.xml",
            "/home/omarv/Documentos/java/DocumentosElectronicos/archivosPruebas/facturaProdigy.pdf",
            "/home/omarv/Documentos/java/DocumentosElectronicos/archivosPruebas/logoTest.jpg",             
            "/home/omarv/Documentos/java/DocumentosElectronicos/archivosPruebas/firmaFisica.jpg", 
            "1001 PRODUCCION", 
            "20022015123453139170166700130440000",
             "AUTORIZADO", 
            "2015-02-20T12:34:53.685-05:00",
             "2002201512345313917016670013044764367", 
             false)) {
            System.out.println("Ejecucion exitosa");
        } else {
            System.out.println("Ejecucion fallida");
        }
    }
}
