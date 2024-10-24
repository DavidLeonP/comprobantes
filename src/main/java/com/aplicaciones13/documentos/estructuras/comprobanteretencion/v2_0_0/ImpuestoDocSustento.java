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
 * <p>Java class for impuestoDocSustento complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="impuestoDocSustento">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codImpuestoDocSustento" type="{}codImpuestoDocSustento"/>
 *         &lt;element name="codigoPorcentaje" type="{}codigoPorcentaje"/>
 *         &lt;element name="baseImponible" type="{}baseImponible"/>
 *         &lt;element name="tarifa" type="{}tarifa"/>
 *         &lt;element name="valorImpuesto" type="{}valorImpuesto"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "impuestoDocSustento", propOrder = {
    "codImpuestoDocSustento",
    "codigoPorcentaje",
    "baseImponible",
    "tarifa",
    "valorImpuesto"
})
public class ImpuestoDocSustento {

    @XmlElement(required = true)
    protected String codImpuestoDocSustento;
    @XmlElement(required = true)
    protected String codigoPorcentaje;
    @XmlElement(required = true)
    protected BigDecimal baseImponible;
    @XmlElement(required = true)
    protected BigDecimal tarifa;
    @XmlElement(required = true)
    protected BigDecimal valorImpuesto;

    /**
     * Gets the value of the codImpuestoDocSustento property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodImpuestoDocSustento() {
        return codImpuestoDocSustento;
    }

    /**
     * Sets the value of the codImpuestoDocSustento property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodImpuestoDocSustento(String value) {
        this.codImpuestoDocSustento = value;
    }

    /**
     * Gets the value of the codigoPorcentaje property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoPorcentaje() {
        return codigoPorcentaje;
    }

    /**
     * Sets the value of the codigoPorcentaje property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoPorcentaje(String value) {
        this.codigoPorcentaje = value;
    }

    /**
     * Gets the value of the baseImponible property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getBaseImponible() {
        return baseImponible;
    }

    /**
     * Sets the value of the baseImponible property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setBaseImponible(BigDecimal value) {
        this.baseImponible = value;
    }

    /**
     * Gets the value of the tarifa property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTarifa() {
        return tarifa;
    }

    /**
     * Sets the value of the tarifa property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTarifa(BigDecimal value) {
        this.tarifa = value;
    }

    /**
     * Gets the value of the valorImpuesto property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValorImpuesto() {
        return valorImpuesto;
    }

    /**
     * Sets the value of the valorImpuesto property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValorImpuesto(BigDecimal value) {
        this.valorImpuesto = value;
    }

}
