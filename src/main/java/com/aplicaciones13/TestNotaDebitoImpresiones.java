package com.aplicaciones13;


import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.aplicaciones13.ride.notadebito.impresion.DatosNotaDebito;
import com.aplicaciones13.ride.notadebito.impresion.ImpresionNotaDebito;


public class TestNotaDebitoImpresiones {
    /** Metodo para crear el objeto.
     *
     */
    public TestNotaDebitoImpresiones() {
        super();
    }

    /** Metodo para ejecutar un main.
     *
     * @param args
     */
    public static void main(String[] args) {
        TestNotaDebitoImpresiones testImpresiones =
            new TestNotaDebitoImpresiones();

        DatosNotaDebito datosNotaDebito = new DatosNotaDebito();
        datosNotaDebito.setPathSource("/home/respaldo/Descargas/002-001-000000001Out45.xml");
        datosNotaDebito.setPathLogo("/home/respaldo/Descargas/");
        datosNotaDebito.setAmbienteAutorizacion("ambiente :p");
        datosNotaDebito.setClaveAccesoAutorizacion("12345678911234567892123456789312345678941234567895");
        datosNotaDebito.setEmisionAutorizacion("emision");
        datosNotaDebito.setFechaAutorizacion("fecha autori 2014");
        datosNotaDebito.setNumeroAutorizacion("12345678911234567892123456789312345678941234567895");

        ImpresionNotaDebito impresionNotaDebito = new ImpresionNotaDebito();
        impresionNotaDebito.ejecutar(datosNotaDebito, impresionNotaDebito.FORMATO_SRI);
        impresionNotaDebito.getByteArrayOutputStream();

        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream =
                    new FileOutputStream("/home/respaldo/Descargas/" + datosNotaDebito.getNotaDebitoXML().getInfoTributaria().getEstab() +
                                         "-" +
                                         datosNotaDebito.getNotaDebitoXML().getInfoTributaria().getPtoEmi() +
                                         "-" +
                                         datosNotaDebito.getNotaDebitoXML().getInfoTributaria().getSecuencial() +
                                         ".pdf");
        } catch (FileNotFoundException e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE,
                                                            e.toString());
        }

        BufferedOutputStream responseOut =
            new BufferedOutputStream(fileOutputStream);

        try {
            impresionNotaDebito.getByteArrayOutputStream().writeTo(responseOut);
            impresionNotaDebito.getByteArrayOutputStream().close();
            responseOut.close();
            fileOutputStream.close();
        } catch (IOException e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE,
                                                            e.toString());
        }
    }
}
