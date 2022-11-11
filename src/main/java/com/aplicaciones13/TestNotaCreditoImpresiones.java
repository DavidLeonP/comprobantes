package com.aplicaciones13;


import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.aplicaciones13.ride.notacredito.impresion.DatosNotaCredito;
import com.aplicaciones13.ride.notacredito.impresion.ImpresionNotaCredito;


public class TestNotaCreditoImpresiones {
    /** Metodo para crear el objeto.
     *
     */
    public TestNotaCreditoImpresiones() {
        super();
    }

    /** Metodo para ejecutar un main.
     *
     * @param args
     */
    public static void main(String[] args) {
        TestNotaCreditoImpresiones testImpresiones =
            new TestNotaCreditoImpresiones();

        DatosNotaCredito datosNotaCredito = new DatosNotaCredito();
        datosNotaCredito.setPathSource("/home/omarv/Descargas/002-001-000000109.xml");
        datosNotaCredito.setPathLogo("/home/omarv/Descargas/");
        datosNotaCredito.setAmbienteAutorizacion("ambiente :p");
        datosNotaCredito.setClaveAccesoAutorizacion("12345678911234567892123456789312345678941234567895");
        datosNotaCredito.setEmisionAutorizacion("emision");
        datosNotaCredito.setFechaAutorizacion("fecha autori 2014");
        datosNotaCredito.setNumeroAutorizacion("12345678911234567892123456789312345678941234567895");

        ImpresionNotaCredito impresionNotaCredito = new ImpresionNotaCredito();
        impresionNotaCredito.ejecutar(datosNotaCredito);
        impresionNotaCredito.getByteArrayOutputStream();

        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream =
                    new FileOutputStream("/home/omarv/Descargas/" + datosNotaCredito.getNotaCreditoXML().getInfoTributaria().getEstab() +
                                         "-" +
                                         datosNotaCredito.getNotaCreditoXML().getInfoTributaria().getPtoEmi() +
                                         "-" +
                                         datosNotaCredito.getNotaCreditoXML().getInfoTributaria().getSecuencial() +
                                         ".pdf");
        } catch (FileNotFoundException e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE,
                                                            e.toString());
        }

        BufferedOutputStream responseOut =
            new BufferedOutputStream(fileOutputStream);

        try {
            impresionNotaCredito.getByteArrayOutputStream().writeTo(responseOut);
            impresionNotaCredito.getByteArrayOutputStream().close();
            responseOut.close();
            fileOutputStream.close();
        } catch (IOException e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE,
                                                            e.toString());
        }
    }
}
