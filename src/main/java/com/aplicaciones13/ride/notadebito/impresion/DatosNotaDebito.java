package com.aplicaciones13.ride.notadebito.impresion;

import com.aplicaciones13.impresion.DatosDocumentosElectronicos;
import com.aplicaciones13.ride.notadebito.NotaDebito;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class DatosNotaDebito extends DatosDocumentosElectronicos {
    private NotaDebito notaDebitoXML;

    public DatosNotaDebito() {
        super();
    }

    @Override
    public void setPathSource(String pathSource) {
        super.setPathSource(pathSource);

        if (pathSource != null && !pathSource.isEmpty()) {
            try {
                JAXBContext jc = JAXBContext.newInstance(NotaDebito.class);

                Unmarshaller unmarshaller = jc.createUnmarshaller();
                File file = new File(getPathSource());
                setNotaDebitoXML((NotaDebito) unmarshaller.unmarshal(file));

            } catch (JAXBException e) {
                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, e.toString());

            }
        }
    }

    public NotaDebito getNotaDebitoXML() {
        return notaDebitoXML;
    }

    public void setNotaDebitoXML(NotaDebito notaDebitoXML) {
        this.notaDebitoXML = notaDebitoXML;
    }
}
