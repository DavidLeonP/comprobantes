package com.aplicaciones13.ride.comprobanteretencion.impresion;

import com.aplicaciones13.impresion.DatosDocumentosElectronicos;
import com.aplicaciones13.ride.comprobanteretencion.ComprobanteRetencion;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 * Clase para tener los datos del comprobante de retencion.
 * 
 * @author o.velez@13aplicaciones.com
 * 
 */
public class DatosComprobanteRetencion extends DatosDocumentosElectronicos {

    private ComprobanteRetencion comprobanteRetencionXML;

    public DatosComprobanteRetencion() {
        super();
    }

    @Override
    public void setPathSource(String pathSource) {
        super.setPathSource(pathSource);

        if (pathSource != null && !pathSource.isEmpty()) {
            try {
                JAXBContext jc = JAXBContext.newInstance(ComprobanteRetencion.class);
                Unmarshaller unmarshaller = jc.createUnmarshaller();
                File file = new File(getPathSource());
                setComprobanteRetencionXML((ComprobanteRetencion) unmarshaller.unmarshal(file));

            } catch (JAXBException e) {
                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING, e.toString());
            }
        }
    }

    public ComprobanteRetencion getComprobanteRetencionXML() {
        return comprobanteRetencionXML;
    }

    public void setComprobanteRetencionXML(ComprobanteRetencion comprobanteRetencionXML) {
        this.comprobanteRetencionXML = comprobanteRetencionXML;
    }
}
