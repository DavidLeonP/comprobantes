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
     *
     */
    private static final String PATH = "/home/omarv/Documentos/java/DocumentosElectronicos/archivosPruebas/";

    /**
     * Metodo para ejecutar un main.
     *
     * @param args
     */
    public static void main(String[] args) {

        Ejecutor ejecutor = new Ejecutor();
        InfoEjecutor infoEjecutor = new InfoEjecutor();
        infoEjecutor.setPathLogo(PATH + "logoTest.jpg");
        infoEjecutor.setPathFirmaGrafica(PATH + "firmaFisica.jpg");
        infoEjecutor.setAmbienteAutorizacion("PRODDUCCION");
        infoEjecutor.setClaveAccesoAutorizacion("20022015123453139170166700130440000");
        infoEjecutor.setEmisionAutorizacion("AUTORIZADO");
        infoEjecutor.setFechaAutorizacion("2014-01-17T00:00:00.000-05:00");
        infoEjecutor.setNumeroAutorizacion("2002201512345313917016670013044764367");
        infoEjecutor.setOffline(false);

        infoEjecutor.setPathXML(PATH + "factura001.xml");
        infoEjecutor.setPathPDF(PATH + "factura001.pdf");
        if (!ejecutor.ejecutarFactura(infoEjecutor)) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.INFO, "Factura 001 Ejecucion fallida");
        }

        infoEjecutor.setPathXML(PATH + "factura002.xml");
        infoEjecutor.setPathPDF(PATH + "factura002.pdf");
        if (!ejecutor.ejecutarFactura(infoEjecutor)) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.INFO, "Factura 002 Ejecucion fallida");
        }

        infoEjecutor.setPathXML(PATH + "factura003.xml");
        infoEjecutor.setPathPDF(PATH + "factura003.pdf");
        if (!ejecutor.ejecutarFactura(infoEjecutor)) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.INFO, "Factura 003 Ejecucion fallida");
        }

        infoEjecutor.setPathXML(PATH + "comprobanteRetencion001.xml");
        infoEjecutor.setPathPDF(PATH + "comprobanteRetencion001.pdf");
        if (!ejecutor.ejecutarComprobanteRetencion(infoEjecutor)) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.INFO, "Comprobante Retencion 001 Ejecucion fallida");
        }

        infoEjecutor.setPathXML(PATH + "comprobanteRetencion002.xml");
        infoEjecutor.setPathPDF(PATH + "comprobanteRetencion002.pdf");
        if (!ejecutor.ejecutarComprobanteRetencion(infoEjecutor)) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.INFO, "Comprobante Retencion 002 Ejecucion fallida");
        }

        infoEjecutor.setPathXML(PATH + "guiaRemision001.xml");
        infoEjecutor.setPathPDF(PATH + "guiaRemision001.pdf");
        if (!ejecutor.ejecutarGuiaRemision(infoEjecutor)) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.INFO, "Guia Remision 001 Ejecucion fallida");
        }

        infoEjecutor.setPathXML(PATH + "notaDebito001.xml");
        infoEjecutor.setPathPDF(PATH + "notaDebito001.pdf");
        if (!ejecutor.ejecutarNotaDebito(infoEjecutor)) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.INFO, "Nota Debito 001 Ejecucion fallida");
        }

        infoEjecutor.setPathXML(PATH + "notaDebito002.xml");
        infoEjecutor.setPathPDF(PATH + "notaDebito002.pdf");
        if (!ejecutor.ejecutarNotaDebito(infoEjecutor)) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.INFO, "Nota Debito 002 Ejecucion fallida");
        }

        infoEjecutor.setPathXML(PATH + "notaCredito001.xml");
        infoEjecutor.setPathPDF(PATH + "notaCredito001.pdf");
        if (!ejecutor.ejecutarNotaCredito(infoEjecutor)) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.INFO, "Nota Credito 001 Ejecucion fallida");
        }
    }
}
