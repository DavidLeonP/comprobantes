package com.aplicaciones13.ride.notacredito.impresion;

import com.aplicaciones13.impresion.DatosDocumentosElectronicos;
import com.aplicaciones13.ride.notacredito.NotaCredito;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;


/**
 * Clase para tener los datos de la nota de credito.
 * 
 * @author o.velez@13aplicaciones.com
 * 
 */
public class DatosNotaCredito extends DatosDocumentosElectronicos {
    private NotaCredito notaCreditoXML;

    public DatosNotaCredito() {
        super();
    }

    @Override
    public void setPathSource(String pathSource) {
        super.setPathSource(pathSource);

        if (pathSource != null && !pathSource.isEmpty()) {
        try {
            JAXBContext jc = JAXBContext.newInstance(NotaCredito.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            File file = new File(getPathSource());
            setNotaCreditoXML((NotaCredito)unmarshaller.unmarshal(file));

        } catch (JAXBException e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING, e.toString());

        }
        }
    }

    public NotaCredito getNotaCreditoXML() {
        return notaCreditoXML;
    }

    public void setNotaCreditoXML(NotaCredito notaCreditoXML) {
        this.notaCreditoXML = notaCreditoXML;
    }
}
