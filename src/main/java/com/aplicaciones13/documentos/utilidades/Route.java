package com.aplicaciones13.documentos.utilidades;

import java.io.File;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Route {

    private Route() {
        super();
    }

    public static com.aplicaciones13.documentos.estructuras.autorizacion.Autorizacion getAutorizacion(String pathFile) {
        com.aplicaciones13.documentos.estructuras.autorizacion.Autorizacion autorizacion = new com.aplicaciones13.documentos.estructuras.autorizacion.Autorizacion();
        File documentoXml = new File(pathFile);

        try {
            autorizacion = Conversion.xmlToPojo(documentoXml,
                    com.aplicaciones13.documentos.estructuras.autorizacion.Autorizacion.class);
             
            if(autorizacion!=null){
                return autorizacion;
            }
        } catch (Exception e) {
            log.warn("Error al leer el archivo autorizacion {} {}", pathFile, e);
        }

        try {
            return mapearAutorizacionXml(buscarAutorizacionRespuestaXml(documentoXml));
        } catch (Exception e) {
            log.warn("Error al leer el archivo autorizacionResponse {} {}", pathFile, e);

        }
        return null;
    }

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

                        log.info(String.valueOf(envelope.getBody()));

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
