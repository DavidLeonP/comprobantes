package com.aplicaciones13;

import java.util.logging.Level;
import java.util.logging.Logger;
import com.aplicaciones13.ride.Ejecutor;
import com.aplicaciones13.sri.contenedores.InfoEjecutor;


/**
 * Objeto de test de Impresiones Factura
 *
 * @author o.velez@13aplicaciones.com
 *
 */
public class GenerarDocumentos {
    /**
     * Metodo para ejecutar un main.
     *
     * @param args
     */
    public static void main(String[] args) {
        String path = args[0];

        if (path == null) {            
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.INFO, "Debe ingresar el path del archivo de configuracion");
            return;
        }

        Ejecutor ejecutor = new Ejecutor();
        InfoEjecutor infoEjecutor = new InfoEjecutor();
        infoEjecutor.setPathLogo(path + "logoTest.jpg");
        infoEjecutor.setPathFirmaGrafica(path + "firmaFisica.jpg");
        infoEjecutor.setAmbienteAutorizacion("PRODDUCCION");
        infoEjecutor.setClaveAccesoAutorizacion("20022015123453139170166700130440000");
        infoEjecutor.setEmisionAutorizacion("AUTORIZADO");
        infoEjecutor.setFechaAutorizacion("2014-01-17T00:00:00.000-05:00");
        infoEjecutor.setNumeroAutorizacion("2002201512345313917016670013044764367");
        infoEjecutor.setOffline(false);

        infoEjecutor.setPathXML(path + "factura001.xml");
        infoEjecutor.setPathPDF(path + "factura001.pdf");
        if (!ejecutor.ejecutarFactura(infoEjecutor)) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.INFO, "Factura 001 Ejecucion fallida");
        }

        infoEjecutor.setPathXML(path + "factura002.xml");
        infoEjecutor.setPathPDF(path + "factura002.pdf");
        if (!ejecutor.ejecutarFactura(infoEjecutor)) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.INFO, "Factura 002 Ejecucion fallida");
        }

        infoEjecutor.setPathXML(path + "factura003.xml");
        infoEjecutor.setPathPDF(path + "factura003.pdf");
        if (!ejecutor.ejecutarFactura(infoEjecutor)) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.INFO, "Factura 003 Ejecucion fallida");
        }

        infoEjecutor.setPathXML(path + "comprobanteRetencion001.xml");
        infoEjecutor.setPathPDF(path + "comprobanteRetencion001.pdf");
        if (!ejecutor.ejecutarComprobanteRetencion(infoEjecutor)) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.INFO, "Comprobante Retencion 001 Ejecucion fallida");
        }

        infoEjecutor.setPathXML(path + "comprobanteRetencion002.xml");
        infoEjecutor.setPathPDF(path + "comprobanteRetencion002.pdf");
        if (!ejecutor.ejecutarComprobanteRetencion(infoEjecutor)) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.INFO, "Comprobante Retencion 002 Ejecucion fallida");
        }

        infoEjecutor.setPathXML(path + "guiaRemision001.xml");
        infoEjecutor.setPathPDF(path + "guiaRemision001.pdf");
        if (!ejecutor.ejecutarGuiaRemision(infoEjecutor)) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.INFO, "Guia Remision 001 Ejecucion fallida");
        }

        infoEjecutor.setPathXML(path + "notaDebito001.xml");
        infoEjecutor.setPathPDF(path + "notaDebito001.pdf");
        if (!ejecutor.ejecutarNotaDebito(infoEjecutor)) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.INFO, "Nota Debito 001 Ejecucion fallida");
        }

        infoEjecutor.setPathXML(path + "notaDebito002.xml");
        infoEjecutor.setPathPDF(path + "notaDebito002.pdf");
        if (!ejecutor.ejecutarNotaDebito(infoEjecutor)) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.INFO, "Nota Debito 002 Ejecucion fallida");
        }

        infoEjecutor.setPathXML(path + "notaCredito001.xml");
        infoEjecutor.setPathPDF(path + "notaCredito001.pdf");
        if (!ejecutor.ejecutarNotaCredito(infoEjecutor)) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.INFO, "Nota Credito 001 Ejecucion fallida");
        }
    }
}
