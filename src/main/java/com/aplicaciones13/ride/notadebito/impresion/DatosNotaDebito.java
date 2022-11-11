package com.aplicaciones13.ride.notadebito.impresion;


import com.aplicaciones13.impresion.DatosDocumentosElectronicos;
import com.aplicaciones13.ride.notadebito.NotaDebito;
import com.aplicaciones13.utilidades.MainFiles;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;


public class DatosNotaDebito extends DatosDocumentosElectronicos {
    private NotaDebito notaDebitoXML;

    public DatosNotaDebito() {
        super();
    }

    public void setPathSource(String pathSource) {
        super.setPathSource(pathSource);

        try {
            JAXBContext jc =
                JAXBContext.newInstance("com.aplicaciones13.ride.notadebito");

            Unmarshaller unmarshaller = jc.createUnmarshaller();
            File file = new File(getPathSource());
            setNotaDebitoXML((NotaDebito)unmarshaller.unmarshal(file));

        } catch (JAXBException e) {
            MainFiles.escribirLogDefault(this.getClass().getName(),
                                         ".ImpresionElementos() ",
                                         e.toString());
        }
    }

    public NotaDebito getNotaDebitoXML() {
        return notaDebitoXML;
    }

    public void setNotaDebitoXML(NotaDebito notaDebitoXML) {
        this.notaDebitoXML = notaDebitoXML;
    }
}
