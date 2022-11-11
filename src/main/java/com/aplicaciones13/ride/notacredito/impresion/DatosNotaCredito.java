package com.aplicaciones13.ride.notacredito.impresion;


import com.aplicaciones13.impresion.DatosDocumentosElectronicos;
import com.aplicaciones13.ride.notacredito.NotaCredito;
import com.aplicaciones13.utilidades.MainFiles;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;


public class DatosNotaCredito extends DatosDocumentosElectronicos {
    private NotaCredito notaCreditoXML;

    public DatosNotaCredito() {
        super();
    }

    @Override
    public void setPathSource(String pathSource) {
        super.setPathSource(pathSource);

        try {
            JAXBContext jc =
                JAXBContext.newInstance("com.aplicaciones13.ride.notacredito");

            Unmarshaller unmarshaller = jc.createUnmarshaller();
            File file = new File(getPathSource());
            setNotaCreditoXML((NotaCredito)unmarshaller.unmarshal(file));

        } catch (JAXBException e) {
            MainFiles.escribirLogDefault(this.getClass().getName(),
                                         ".ImpresionElementos() ",
                                         e.toString());
        }
    }

    public NotaCredito getNotaCreditoXML() {
        return notaCreditoXML;
    }

    public void setNotaCreditoXML(NotaCredito notaCreditoXML) {
        this.notaCreditoXML = notaCreditoXML;
    }
}
