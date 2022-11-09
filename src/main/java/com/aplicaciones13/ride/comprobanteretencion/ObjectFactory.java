
package com.aplicaciones13.ride.comprobanteretencion;


import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the com.aplicaciones13.ride.comprobanteRetencion package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 *
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.aplicaciones13.ride.comprobanteRetencion
     *
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ComprobanteRetencion }
     *
     */
    public ComprobanteRetencion createComprobanteRetencion() {
        return new ComprobanteRetencion();
    }

    /**
     * Create an instance of {@link ComprobanteRetencion.InfoAdicional }
     *
     */
    public ComprobanteRetencion.InfoAdicional createComprobanteRetencionInfoAdicional() {
        return new ComprobanteRetencion.InfoAdicional();
    }

    /**
     * Create an instance of {@link InfoTributaria }
     *
     */
    public InfoTributaria createInfoTributaria() {
        return new InfoTributaria();
    }

    /**
     * Create an instance of {@link ComprobanteRetencion.InfoCompRetencion }
     *
     */
    public ComprobanteRetencion.InfoCompRetencion createComprobanteRetencionInfoCompRetencion() {
        return new ComprobanteRetencion.InfoCompRetencion();
    }

    /**
     * Create an instance of {@link ComprobanteRetencion.Impuestos }
     *
     */
    public ComprobanteRetencion.Impuestos createComprobanteRetencionImpuestos() {
        return new ComprobanteRetencion.Impuestos();
    }

    /**
     * Create an instance of {@link Impuesto }
     *
     */
    public Impuesto createImpuesto() {
        return new Impuesto();
    }

    /**
     * Create an instance of {@link ComprobanteRetencion.InfoAdicional.CampoAdicional }
     *
     */
    public ComprobanteRetencion.InfoAdicional.CampoAdicional createComprobanteRetencionInfoAdicionalCampoAdicional() {
        return new ComprobanteRetencion.InfoAdicional.CampoAdicional();
    }

}
