package com.aplicaciones13.documentos.utilidades;

import java.text.MessageFormat;
import java.util.ResourceBundle;

/**
 * Clase que permite cargar un archivo de propiedades y obtener los mensajes
 * 
 * @author omargo33
 * @since 2024-04-03
 *
 */
public class BundleMessages {

    ResourceBundle resource;

    /*
     * Constructor que carga el archivo de propiedades
     */
    public BundleMessages() {
        resource = ResourceBundle.getBundle("messages");
    }

/*
     * Constructor que carga el archivo de propiedades
     */
    public BundleMessages(String archivoPropiedades) {
        resource = ResourceBundle.getBundle(archivoPropiedades);
    }

    /**
     * Metodo que obtiene el mensaje del archivo de propiedades
     * 
     * @param key
     * @param params
     * @return
     */
    public String getMessage(String key, Object... params) {
        try {
            String message = resource.getString(key);
            return MessageFormat.format(message, params);
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}