//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.04.22 at 06:58:16 p. m. ECT 
//


package com.aplicaciones13.documentos.estructuras.comprobanteretencion.v2_0_0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for impuestosDocSustento complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="impuestosDocSustento">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="impuestoDocSustento" type="{}impuestoDocSustento" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "impuestosDocSustento", propOrder = {
    "impuestoDocSustento"
})
public class ImpuestosDocSustento {

    @XmlElement(required = true)
    protected List<ImpuestoDocSustento> impuestoDocSustento;

    /**
     * Gets the value of the impuestoDocSustento property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the impuestoDocSustento property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getImpuestoDocSustento().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ImpuestoDocSustento }
     * 
     * 
     */
    public List<ImpuestoDocSustento> getImpuestoDocSustento() {
        if (impuestoDocSustento == null) {
            impuestoDocSustento = new ArrayList<ImpuestoDocSustento>();
        }
        return this.impuestoDocSustento;
    }

}
