package com.aplicaciones13.documentos.utilidades;

import java.io.File;

import lombok.extern.slf4j.Slf4j;

/**
 * Clase para enrutar los documentos.
 * 
 * @author omargo33
 * @since 2024-04-22
 * 
 */
@Slf4j
public class Route {

    private Route() {
        super();
    }

    /**
     * Metodo para obtener la autorizacion.
     * 
     * @param pathFile
     * @return
     */
    public static com.aplicaciones13.documentos.estructuras.autorizacion.Autorizacion getAutorizacion(String pathFile) {
        com.aplicaciones13.documentos.estructuras.autorizacion.Autorizacion autorizacion = new com.aplicaciones13.documentos.estructuras.autorizacion.Autorizacion();
        File documentoXml = new File(pathFile);

        try {
            autorizacion = Conversion.xmlToPojo(documentoXml,
                    com.aplicaciones13.documentos.estructuras.autorizacion.Autorizacion.class);

            if (autorizacion != null) {
                return autorizacion;
            }
        } catch (Exception e) {
            log.warn("Error al leer el archivo autorizacion {} {}", pathFile, e.toString());
        }

        try {
            return mapearAutorizacionXml(buscarAutorizacionRespuestaXml(documentoXml));
        } catch (Exception e) {
            log.warn("Error al leer el archivo autorizacionResponse {} {}", pathFile, e.toString());

        }
        return null;
    }

    /**
     * Metodo para mapear la autorizacion del xml a la estructura de respuesta.
     * 
     * @param autorizacionXml
     * @return
     */
    private static com.aplicaciones13.documentos.estructuras.autorizacion.Autorizacion mapearAutorizacionXml(
            com.aplicaciones13.documentos.estructuras.autorizacioncomprobanteresponse.RespuestaAutorizacionComprobante.Autorizaciones.Autorizacion autorizacionXml) {
        com.aplicaciones13.documentos.estructuras.autorizacion.Autorizacion autorizacion = new com.aplicaciones13.documentos.estructuras.autorizacion.Autorizacion();

        autorizacion.setComprobante(autorizacionXml.getComprobante());
        autorizacion.setEstado(autorizacionXml.getEstado());
        autorizacion.setFechaAutorizacion(autorizacionXml.getFechaAutorizacion());
        autorizacion.setNumeroAutorizacion(autorizacionXml.getNumeroAutorizacion());

        return autorizacion;
    }

    /**
     * Metodo para buscar la autorizacion en el xml.
     * 
     * @param pathFile
     * @return
     */
    private static com.aplicaciones13.documentos.estructuras.autorizacioncomprobanteresponse.RespuestaAutorizacionComprobante.Autorizaciones.Autorizacion buscarAutorizacionRespuestaXml(
            File file) {

        com.aplicaciones13.documentos.estructuras.autorizacioncomprobanteresponse.Envelope envelope = Conversion
                .xmlToPojo(file,
                        com.aplicaciones13.documentos.estructuras.autorizacioncomprobanteresponse.Envelope.class);

        for (com.aplicaciones13.documentos.estructuras.autorizacioncomprobanteresponse.RespuestaAutorizacionComprobante.Autorizaciones.Autorizacion autorizacion : envelope
                .getBody().getAutorizacionComprobanteResponse().getRespuestaAutorizacionComprobante()
                .getAutorizaciones().getAutorizacion()) {
            if (autorizacion.getEstado().equals("AUTORIZADO")) {
                return autorizacion;
            }
        }
        return null;
    }
}
