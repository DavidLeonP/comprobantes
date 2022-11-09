package com.aplicaciones13.ride.facturaexportacion.impresion;

import com.aplicaciones13.impresion.DatosDocumentosElectronicos;
import com.aplicaciones13.ride.facturaexportacion.Factura;
import com.aplicaciones13.utilidades.MainFiles;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class DatosFactura extends DatosDocumentosElectronicos {

    private Factura facturaXML;

    public DatosFactura() {
        super();
    }

    @Override
    public void setPathSource(String pathSource) {
        super.setPathSource(pathSource);

        try {
            JAXBContext jc = JAXBContext.newInstance(Factura.class);
            
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            File file = new File(pathSource);
            setFacturaXML((Factura) unmarshaller.unmarshal(file));
        } catch (JAXBException e) {
            MainFiles.escribirLogDefault(this.getClass().getName(),
                    ".ImpresionElementos() ",
                    e.toString());
        }
    }

    public Factura getFacturaXML() {
        return facturaXML;
    }

    public void setFacturaXML(Factura facturaXML) {
        this.facturaXML = facturaXML;
    }
}
