package com.aplicaciones13.ride;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.aplicaciones13.ride.facturaexportacion.impresion.DatosFactura;
import com.aplicaciones13.ride.facturaexportacion.impresion.ImpresionFactura;

/**
 * Objeto ejecutar Impresiones Factura
 */
public class Ejecutor {

    /**
     * Clase para crear el objeto.
     * 
     */
    public Ejecutor() {
        super();
    }

    /**
     * Metodo para ejecutar la creacion de la factura
     * 
     * @param pathXML
     * @param pathPDF
     * @param pathLogo
     * @param pathFirmaGrafica
     * @param ambienteAutorizacion
     * @param claveAccesoAutorizacion
     * @param emisionAutorizacion
     * @param fechaAutorizacion
     * @param numeroAutorizacion
     * @param offline
     */
    public  boolean ejecutarFactura(String pathXML, String pathPDF, String pathLogo, String pathFirmaGrafica,
            String ambienteAutorizacion, String claveAccesoAutorizacion, String emisionAutorizacion,
            String fechaAutorizacion, String numeroAutorizacion, boolean offline) {
        FileOutputStream fileOutputStream = null;
        BufferedOutputStream responseOut = null;
        ImpresionFactura impresionFactura = new ImpresionFactura();
        DatosFactura datosFactura = new DatosFactura();

        datosFactura.setPathSource(pathXML);
        datosFactura.setPathLogo(pathLogo);
        datosFactura.setPathFirmaGrafica(pathFirmaGrafica);
        datosFactura.setAmbienteAutorizacion(ambienteAutorizacion);
        datosFactura.setClaveAccesoAutorizacion(claveAccesoAutorizacion);
        datosFactura.setEmisionAutorizacion(emisionAutorizacion);
        datosFactura.setFechaAutorizacion(fechaAutorizacion);
        datosFactura.setNumeroAutorizacion(numeroAutorizacion);
        datosFactura.setOffline(offline);

        impresionFactura.ejecutar(datosFactura);
        
        try {
            fileOutputStream = new FileOutputStream(pathPDF);        
            responseOut = new BufferedOutputStream(fileOutputStream);
            impresionFactura.getByteArrayOutputStream().writeTo(responseOut);
        } catch (IOException e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, e.toString());
            return false;
        } finally {
            try {
                impresionFactura.getByteArrayOutputStream().close();                                
                if (responseOut != null) {
                    responseOut.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, e.toString());
            }
        }
        return true;
    }
}
