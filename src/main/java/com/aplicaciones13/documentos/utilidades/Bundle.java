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
public class Bundle {

    ResourceBundle resource;

    /*
     * Constructor que carga el archivo de propiedades
     */
    public Bundle() {
        resource = ResourceBundle.getBundle("messages");
    }

/*
     * Constructor que carga el archivo de propiedades
     */
    public Bundle(String archivoPropiedades) {
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

    /**
     * Metodo que obtiene los mensajes del archivo de propiedades sin parametros
     * 
     * @param keys
     * @return
     */
    public String[] getMessages(String ...keys) {        
        String[] messages = new String[keys.length];

        for (int i = 0; i < keys.length; i++) {
            messages[i] = getMessage(keys[i]);
        }

        return messages;
    }
}