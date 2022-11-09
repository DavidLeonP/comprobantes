package com.aplicaciones13.ride.comprobanteretencion.impresion;


import com.aplicaciones13.impresion.DatosDocumentosElectronicos;
import com.aplicaciones13.ride.comprobanteretencion.ComprobanteRetencion;
import com.aplicaciones13.utilidades.MainFiles;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;


public class DatosComprobanteRetencion extends DatosDocumentosElectronicos {

    private ComprobanteRetencion comprobanteRetencionXML;

    public DatosComprobanteRetencion() {
        super();
    }

    @Override
    public void setPathSource(String pathSource) {
        super.setPathSource(pathSource);

        try {
            JAXBContext jc =
                JAXBContext.newInstance("com.aplicaciones13.ride.comprobanteretencion");

            Unmarshaller unmarshaller = jc.createUnmarshaller();
            File file = new File(getPathSource());
            setComprobanteRetencionXML((ComprobanteRetencion)unmarshaller.unmarshal(file));

        } catch (JAXBException e) {
            MainFiles.escribirLogDefault(this.getClass().getName(),
                                         ".ImpresionElementos() ",
                                         e.toString());
        }
    }

    public ComprobanteRetencion getComprobanteRetencionXML() {
        return comprobanteRetencionXML;
    }

    public void setComprobanteRetencionXML(ComprobanteRetencion comprobanteRetencionXML) {
        this.comprobanteRetencionXML = comprobanteRetencionXML;
    }
}
