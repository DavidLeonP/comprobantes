package com.aplicaciones13.ride.facturaexportacion.impresion;

import com.aplicaciones13.impresion.DatosDocumentosElectronicos;
import com.aplicaciones13.ride.facturaexportacion.Factura;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 * Clase para tener los datos de la factura de exportacion.
 * 
 * @author o.velez@13aplicaciones.com
 * 
 */
public class DatosFactura extends DatosDocumentosElectronicos {

    private Factura facturaXML;

    public DatosFactura() {
        super();
    }

    @Override
    public void setPathSource(String pathSource) {
        super.setPathSource(pathSource);

        if (pathSource != null && !pathSource.isEmpty()) {
            try {
                JAXBContext jc = JAXBContext.newInstance(Factura.class);
                Unmarshaller unmarshaller = jc.createUnmarshaller();
                File file = new File(pathSource);
                this.facturaXML = (Factura) unmarshaller.unmarshal(file);
            } catch (JAXBException e) {
                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING, e.toString());
            }
        }
    }

    public Factura getFacturaXML() {
        return this.facturaXML;
    }

    public void setFacturaXML(Factura facturaXML) {
        this.facturaXML = facturaXML;
    }
}
