package com.aplicaciones13;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.aplicaciones13.ride.guiaremision1.impresion.DatosGuiaRemision;
import com.aplicaciones13.ride.guiaremision1.impresion.ImpresionGuiaRemision;


public class TestGuiaRemisionImpresiones {
    /** Metodo para crear el objeto.
     *
     */
    public TestGuiaRemisionImpresiones() {
        super();
    }

    /** Metodo para ejecutar un main.
     *
     * @param args
     */
    public static void main(String[] args) {
        TestGuiaRemisionImpresiones testImpresiones =
            new TestGuiaRemisionImpresiones();

        DatosGuiaRemision datosGuiaRemision = new DatosGuiaRemision();
        datosGuiaRemision.setPathSource("C:\\JDeveloper\\guiaRemision.xml");
        datosGuiaRemision.setPathLogo("C:\\JDeveloper\\");
        datosGuiaRemision.setAmbienteAutorizacion("ambiente :p");
        datosGuiaRemision.setClaveAccesoAutorizacion("12345678911234567892123456789312345678941234567895");
        datosGuiaRemision.setEmisionAutorizacion("emision");
        datosGuiaRemision.setFechaAutorizacion("fecha autori 2014");
        datosGuiaRemision.setNumeroAutorizacion("12345678911234567892123456789312345678941234567895");

        ImpresionGuiaRemision impresionGuiaRemision =
            new ImpresionGuiaRemision();
        impresionGuiaRemision.ejecutar(datosGuiaRemision);
        impresionGuiaRemision.getByteArrayOutputStream();

        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream =
                    new FileOutputStream("C:\\JDeveloper\\" + datosGuiaRemision.getGuiaRemisionXML().getInfoTributaria().getEstab() +
                                         "-" +
                                         datosGuiaRemision.getGuiaRemisionXML().getInfoTributaria().getPtoEmi() +
                                         "-" +
                                         datosGuiaRemision.getGuiaRemisionXML().getInfoTributaria().getSecuencial() +
                                         ".pdf");
        } catch (FileNotFoundException e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE,
                                                            e.toString());
        }

        BufferedOutputStream responseOut =
            new BufferedOutputStream(fileOutputStream);

        try {
            impresionGuiaRemision.getByteArrayOutputStream().writeTo(responseOut);
            impresionGuiaRemision.getByteArrayOutputStream().close();
            responseOut.close();
            fileOutputStream.close();
        } catch (IOException e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE,
                                                            e.toString());
        }
    }
}
