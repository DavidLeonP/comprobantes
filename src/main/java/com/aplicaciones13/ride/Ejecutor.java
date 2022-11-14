package com.aplicaciones13.ride;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.aplicaciones13.ride.comprobanteretencion.impresion.DatosComprobanteRetencion;
import com.aplicaciones13.ride.comprobanteretencion.impresion.ImpresionComprobanteRetencion;
import com.aplicaciones13.ride.facturaexportacion.impresion.DatosFactura;
import com.aplicaciones13.ride.facturaexportacion.impresion.ImpresionFactura;
import com.aplicaciones13.ride.guiaremision.impresion.DatosGuiaRemision;
import com.aplicaciones13.ride.guiaremision.impresion.ImpresionGuiaRemision;
import com.aplicaciones13.ride.notacredito.impresion.DatosNotaCredito;
import com.aplicaciones13.ride.notacredito.impresion.ImpresionNotaCredito;
import com.aplicaciones13.ride.notadebito.impresion.DatosNotaDebito;
import com.aplicaciones13.ride.notadebito.impresion.ImpresionNotaDebito;
import com.aplicaciones13.sri.contenedores.InfoEjecutor;

/**
 * Objeto ejecutar los pdf del sistema
 * 
 * @author o.velez@13aplicaciones.com
 * 
 */
public class Ejecutor {
    FileOutputStream fileOutputStream = null;
    BufferedOutputStream responseOut = null;

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
     * @param infoEjecutor
     */
    public boolean ejecutarFactura(InfoEjecutor infoEjecutor) {
        ImpresionFactura impresionFactura = new ImpresionFactura();
        DatosFactura datosFactura = new DatosFactura();

        datosFactura.setPathSource(infoEjecutor.getPathXML());
        datosFactura.setPathLogo(infoEjecutor.getPathLogo());
        datosFactura.setPathFirmaGrafica(infoEjecutor.getPathFirmaGrafica());
        datosFactura.setAmbienteAutorizacion(infoEjecutor.getAmbienteAutorizacion());
        datosFactura.setClaveAccesoAutorizacion(infoEjecutor.getClaveAccesoAutorizacion());
        datosFactura.setEmisionAutorizacion(infoEjecutor.getEmisionAutorizacion());
        datosFactura.setFechaAutorizacion(infoEjecutor.getFechaAutorizacion());
        datosFactura.setNumeroAutorizacion(infoEjecutor.getNumeroAutorizacion());
        datosFactura.setOffline(infoEjecutor.isOffline());

        impresionFactura.ejecutar(datosFactura);

        try {
            fileOutputStream = new FileOutputStream(infoEjecutor.getPathPDF());
            responseOut = new BufferedOutputStream(fileOutputStream);
            impresionFactura.getByteArrayOutputStream().writeTo(responseOut);
        } catch (IOException e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING, e.toString());
            return false;
        } finally {
            try {
                impresionFactura.getByteArrayOutputStream().close();
                cerrarFlujos();
            } catch (IOException e) {
                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING, e.toString());
            }
        }
        return true;
    }

    /**
     * Metodo para ejecutar la creacion del compronante de retencion
     * 
     * @param infoEjecutor
     */
    public boolean ejecutarComprobanteRetencion(InfoEjecutor infoEjecutor) {
        ImpresionComprobanteRetencion impresionComprobanteRetencion = new ImpresionComprobanteRetencion();
        DatosComprobanteRetencion datosComprobanteRetencion = new DatosComprobanteRetencion();

        datosComprobanteRetencion.setPathSource(infoEjecutor.getPathXML());
        datosComprobanteRetencion.setPathLogo(infoEjecutor.getPathLogo());
        datosComprobanteRetencion.setPathFirmaGrafica(infoEjecutor.getPathFirmaGrafica());
        datosComprobanteRetencion.setAmbienteAutorizacion(infoEjecutor.getAmbienteAutorizacion());
        datosComprobanteRetencion.setClaveAccesoAutorizacion(infoEjecutor.getClaveAccesoAutorizacion());
        datosComprobanteRetencion.setEmisionAutorizacion(infoEjecutor.getEmisionAutorizacion());
        datosComprobanteRetencion.setFechaAutorizacion(infoEjecutor.getFechaAutorizacion());
        datosComprobanteRetencion.setNumeroAutorizacion(infoEjecutor.getNumeroAutorizacion());
        datosComprobanteRetencion.setOffline(infoEjecutor.isOffline());

        impresionComprobanteRetencion.ejecutar(datosComprobanteRetencion);

        try {
            fileOutputStream = new FileOutputStream(infoEjecutor.getPathPDF());
            responseOut = new BufferedOutputStream(fileOutputStream);
            impresionComprobanteRetencion.getByteArrayOutputStream().writeTo(responseOut);
        } catch (IOException e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING, e.toString());
            return false;
        } finally {
            try {
                impresionComprobanteRetencion.getByteArrayOutputStream().close();
                cerrarFlujos();
            } catch (IOException e) {
                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING, e.toString());
            }
        }
        return true;
    }

    /**
     * Metodo para ejecutar la creacion de la nota credito
     * 
     * @param infoEjecutor
     */
    public boolean ejecutarNotaCredito(InfoEjecutor infoEjecutor) {
        ImpresionNotaCredito impresionNotaCredito = new ImpresionNotaCredito();
        DatosNotaCredito datosNotaCredito = new DatosNotaCredito();

        datosNotaCredito.setPathSource(infoEjecutor.getPathXML());
        datosNotaCredito.setPathLogo(infoEjecutor.getPathLogo());
        datosNotaCredito.setPathFirmaGrafica(infoEjecutor.getPathFirmaGrafica());
        datosNotaCredito.setAmbienteAutorizacion(infoEjecutor.getAmbienteAutorizacion());
        datosNotaCredito.setClaveAccesoAutorizacion(infoEjecutor.getClaveAccesoAutorizacion());
        datosNotaCredito.setEmisionAutorizacion(infoEjecutor.getEmisionAutorizacion());
        datosNotaCredito.setFechaAutorizacion(infoEjecutor.getFechaAutorizacion());
        datosNotaCredito.setNumeroAutorizacion(infoEjecutor.getNumeroAutorizacion());
        datosNotaCredito.setOffline(infoEjecutor.isOffline());

        impresionNotaCredito.ejecutar(datosNotaCredito);

        try {
            fileOutputStream = new FileOutputStream(infoEjecutor.getPathPDF());
            responseOut = new BufferedOutputStream(fileOutputStream);
            impresionNotaCredito.getByteArrayOutputStream().writeTo(responseOut);
        } catch (IOException e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING, e.toString());
            return false;
        } finally {
            try {
                impresionNotaCredito.getByteArrayOutputStream().close();
                cerrarFlujos();
            } catch (IOException e) {
                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING, e.toString());
            }
        }
        return true;
    }

    /**
     * Metodo para ejecutar la creacion de la nota debito
     * 
     * @param infoEjecutor
     */
    public boolean ejecutarNotaDebito(InfoEjecutor infoEjecutor) {
        ImpresionNotaDebito impresionNotaDebito = new ImpresionNotaDebito();
        DatosNotaDebito datosNotasDebito = new DatosNotaDebito();

        datosNotasDebito.setPathSource(infoEjecutor.getPathXML());
        datosNotasDebito.setPathLogo(infoEjecutor.getPathLogo());
        datosNotasDebito.setPathFirmaGrafica(infoEjecutor.getPathFirmaGrafica());
        datosNotasDebito.setAmbienteAutorizacion(infoEjecutor.getAmbienteAutorizacion());
        datosNotasDebito.setClaveAccesoAutorizacion(infoEjecutor.getClaveAccesoAutorizacion());
        datosNotasDebito.setEmisionAutorizacion(infoEjecutor.getEmisionAutorizacion());
        datosNotasDebito.setFechaAutorizacion(infoEjecutor.getFechaAutorizacion());
        datosNotasDebito.setNumeroAutorizacion(infoEjecutor.getNumeroAutorizacion());
        datosNotasDebito.setOffline(infoEjecutor.isOffline());

        impresionNotaDebito.ejecutar(datosNotasDebito);

        try {
            fileOutputStream = new FileOutputStream(infoEjecutor.getPathPDF());
            responseOut = new BufferedOutputStream(fileOutputStream);
            impresionNotaDebito.getByteArrayOutputStream().writeTo(responseOut);
        } catch (IOException e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING, e.toString());
            return false;
        } finally {
            try {
                impresionNotaDebito.getByteArrayOutputStream().close();
                cerrarFlujos();
            } catch (IOException e) {
                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING, e.toString());
            }
        }
        return true;
    }

    /**
     * Metodo para ejecutar la creacion de la guia remision
     * 
     * @param infoEjecutor
     */
    public boolean ejecutarGuiaRemision(InfoEjecutor infoEjecutor) {
        ImpresionGuiaRemision impresionGuiaRemision = new ImpresionGuiaRemision();
        DatosGuiaRemision datosGuiaRemision = new DatosGuiaRemision();

        datosGuiaRemision.setPathSource(infoEjecutor.getPathXML());
        datosGuiaRemision.setPathLogo(infoEjecutor.getPathLogo());
        datosGuiaRemision.setPathFirmaGrafica(infoEjecutor.getPathFirmaGrafica());
        datosGuiaRemision.setAmbienteAutorizacion(infoEjecutor.getAmbienteAutorizacion());
        datosGuiaRemision.setClaveAccesoAutorizacion(infoEjecutor.getClaveAccesoAutorizacion());
        datosGuiaRemision.setEmisionAutorizacion(infoEjecutor.getEmisionAutorizacion());
        datosGuiaRemision.setFechaAutorizacion(infoEjecutor.getFechaAutorizacion());
        datosGuiaRemision.setNumeroAutorizacion(infoEjecutor.getNumeroAutorizacion());
        datosGuiaRemision.setOffline(infoEjecutor.isOffline());

        impresionGuiaRemision.ejecutar(datosGuiaRemision);

        try {
            fileOutputStream = new FileOutputStream(infoEjecutor.getPathPDF());
            responseOut = new BufferedOutputStream(fileOutputStream);
            impresionGuiaRemision.getByteArrayOutputStream().writeTo(responseOut);
        } catch (IOException e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING, e.toString());
            return false;
        } finally {
            try {
                impresionGuiaRemision.getByteArrayOutputStream().close();
                cerrarFlujos();
            } catch (IOException e) {
                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING, e.toString());
            }
        }
        return true;
    }

    /**
     * Metodo para cerrar los flujos de salida
     * 
     */
    private void cerrarFlujos() {
        try {
            if (responseOut != null) {
                responseOut.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        } catch (IOException e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING, e.toString());
        }
    }
}
