//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.04.28 at 10:44:45 a. m. ECT 
//


package com.aplicaciones13.documentos.estructuras.comprobanteretencion.v2_0_0;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dividendos complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dividendos">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fechaPagoDiv" type="{}fecha"/>
 *         &lt;element name="imRentaSoc" type="{}imRentaSoc"/>
 *         &lt;element name="ejerFisUtDiv" type="{}ejerFisUtDiv"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dividendos", propOrder = {
    "fechaPagoDiv",
    "imRentaSoc",
    "ejerFisUtDiv"
})
public class Dividendos {

    @XmlElement(required = true)
    protected String fechaPagoDiv;
    @XmlElement(required = true)
    protected BigDecimal imRentaSoc;
    @XmlElement(required = true)
    protected String ejerFisUtDiv;

    /**
     * Gets the value of the fechaPagoDiv property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaPagoDiv() {
        return fechaPagoDiv;
    }

    /**
     * Sets the value of the fechaPagoDiv property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaPagoDiv(String value) {
        this.fechaPagoDiv = value;
    }

    /**
     * Gets the value of the imRentaSoc property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getImRentaSoc() {
        return imRentaSoc;
    }

    /**
     * Sets the value of the imRentaSoc property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setImRentaSoc(BigDecimal value) {
        this.imRentaSoc = value;
    }

    /**
     * Gets the value of the ejerFisUtDiv property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEjerFisUtDiv() {
        return ejerFisUtDiv;
    }

    /**
     * Sets the value of the ejerFisUtDiv property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEjerFisUtDiv(String value) {
        this.ejerFisUtDiv = value;
    }

}
