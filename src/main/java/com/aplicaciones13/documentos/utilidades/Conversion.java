package com.aplicaciones13.documentos.utilidades;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.StringReader;

/**
 * Clase para parsero de documentos
 * 
 * @author omargo33
 * @since 2024-04-22
 */
@Slf4j
public class Conversion {

    private Conversion(){
        super();
    }

    /**
     * Metodo para obtener el documento parseado sobre los objetos de la estructura.
     * 
     * @param <T>
     * @param documentoXml
     * @param type
     * @return
     */
    public static <T> T xmlToPojo(File fileXml, Class<T> type) {
        try {
            JAXBContext jc = JAXBContext.newInstance(type);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            return type.cast(unmarshaller.unmarshal(fileXml));
        } catch (JAXBException e) {
           // log.error("Error al obtener archivo parseado {}", e);
        }
        return null;
    }
    
    
    /**
     * Metodo para obtener el documento parseado sobre los objetos de la estructura.
     * 
     * @param <T>
     * @param xml
     * @param type
     * @return
     */
    public static <T> T xmlToPojo(String xml, Class<T> type) {
        try {
            StringReader readerXml = new StringReader(xml);
            JAXBContext jc = JAXBContext.newInstance(type);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            return type.cast(unmarshaller.unmarshal(readerXml));
        } catch (JAXBException e) {
          //  log.error("Error al obtener un xml (string) parseado {}", e);
        }
        return null;
    }
}
