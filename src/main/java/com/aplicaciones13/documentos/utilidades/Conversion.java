package com.aplicaciones13.documentos.utilidades;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import lombok.extern.slf4j.Slf4j;

import java.io.File;

@Slf4j
public class Conversion {

    /**
     * Metodo para obtener el documento parseado sobre los objetos de la estructura.
     * 
     * @param <T>
     * @param documentoXml
     * @param type
     * @return
     */
    public static <T> T obtenerDocumentoParseado(File documentoXml, Class<T> type) {
        try {
            JAXBContext jc = JAXBContext.newInstance(type);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            return type.cast(unmarshaller.unmarshal(documentoXml));
        } catch (JAXBException e) {
            log.error("Error al obtener documento parseado", e);
        }
        return null;
    }
}
