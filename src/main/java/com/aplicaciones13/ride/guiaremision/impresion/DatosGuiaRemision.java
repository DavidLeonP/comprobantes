package com.aplicaciones13.ride.guiaremision.impresion;

import com.aplicaciones13.impresion.DatosDocumentosElectronicos;
import com.aplicaciones13.ride.guiaremision.GuiaRemision;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class DatosGuiaRemision extends DatosDocumentosElectronicos {

    private GuiaRemision guiaRemisionXML;

    public DatosGuiaRemision() {
        super();
    }

    @Override
    public void setPathSource(String pathSource) {
        super.setPathSource(pathSource);

        if (pathSource != null && !pathSource.isEmpty()) {
            try {
                JAXBContext jc = JAXBContext.newInstance(GuiaRemision.class);

                Unmarshaller unmarshaller = jc.createUnmarshaller();
                File file = new File(getPathSource());
                setGuiaRemisionXML((GuiaRemision) unmarshaller.unmarshal(file));
            } catch (JAXBException e) {
                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, e.toString());
            }
        }
    }

    public GuiaRemision getGuiaRemisionXML() {
        return guiaRemisionXML;
    }

    public void setGuiaRemisionXML(GuiaRemision guiaRemisionXML) {
        this.guiaRemisionXML = guiaRemisionXML;
    }
}
