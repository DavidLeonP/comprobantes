package com.aplicaciones13.ride.guiaremision.impresion;


import com.aplicaciones13.impresion.DatosDocumentosElectronicos;
import com.aplicaciones13.ride.guiaremision.GuiaRemision;
import com.aplicaciones13.utilidades.MainFiles;

import java.io.File;

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

        try {
            JAXBContext jc =
                JAXBContext.newInstance("com.aplicaciones13.ride.guiaremision1");

            Unmarshaller unmarshaller = jc.createUnmarshaller();
            File file = new File(getPathSource());
            setGuiaRemisionXML((GuiaRemision)unmarshaller.unmarshal(file));

        } catch (JAXBException e) {
            MainFiles.escribirLogDefault(this.getClass().getName(),
                                         ".ImpresionElementos() ",
                                         e.toString());
        }
    }

    public GuiaRemision getGuiaRemisionXML() {
        return guiaRemisionXML;
    }

    public void setGuiaRemisionXML(GuiaRemision guiaRemisionXML) {
        this.guiaRemisionXML = guiaRemisionXML;
    }
}
