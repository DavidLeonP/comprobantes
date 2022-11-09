package com.aplicaciones13;


import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.aplicaciones13.ride.Ejecutor;
import com.aplicaciones13.ride.facturaexportacion.impresion.DatosFactura;
import com.aplicaciones13.ride.facturaexportacion.impresion.ImpresionFactura;


/** Objeto de test de Impresiones Factura
 *
 * @author omar velez omargo33@jeremiassoft.com
 *
 */
public class TestFacturaImpresiones {

    /** Metodo para crear el objeto.
     *
     */
    public TestFacturaImpresiones() {
        super();
    }

    /** Metodo para ejecutar un main.
     *
     * @param args
     */
    public static void main(String[] args) {

        Ejecutor ejecutor = new Ejecutor();

        if(ejecutor.ejecutarFactura(
            "/home/omarv/Documentos/java/DocumentosElectronicos/archivosPruebas/EXP-002-001-000011599.XML",
            "/home/omarv/Documentos/java/DocumentosElectronicos/archivosPruebas/test.pdf",
            "/home/omarv/Documentos/java/DocumentosElectronicos/archivosPruebas/logoTest.jpg", 
            //"/home/omarv/jeremias/firmaCompleta.jpg",  
            null,
            "PRODUCCION", 
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
