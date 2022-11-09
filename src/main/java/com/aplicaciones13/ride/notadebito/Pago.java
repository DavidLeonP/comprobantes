
package com.aplicaciones13.ride.notadebito;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Contiene la informacion de los pagos
 *
 * <p>Java class for pago complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="pago">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="formaPago" type="{}formaPago"/>
 *         &lt;element name="total" type="{}total"/>
 *         &lt;element name="plazo" type="{}plazo" minOccurs="0"/>
 *         &lt;element name="unidadTiempo" type="{}unidadTiempo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pago",
         propOrder = { "formaPago", "total", "plazo", "unidadTiempo" })
public class Pago {

    @XmlElement(required = true)
    protected String formaPago;
    @XmlElement(required = true)
    protected BigDecimal total;
    protected BigDecimal plazo;
    protected String unidadTiempo;

    /**
     * Gets the value of the formaPago property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getFormaPago() {
        return formaPago;
    }

    /**
     * Sets the value of the formaPago property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setFormaPago(String value) {
        this.formaPago = value;
    }

    /**
     * Gets the value of the total property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getTotal() {
        return total;
    }

    /**
     * Sets the value of the total property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setTotal(BigDecimal value) {
        this.total = value;
    }

    /**
     * Gets the value of the plazo property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getPlazo() {
        return plazo;
    }

    /**
     * Sets the value of the plazo property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setPlazo(BigDecimal value) {
        this.plazo = value;
    }

    /**
     * Gets the value of the unidadTiempo property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getUnidadTiempo() {
        return unidadTiempo;
    }

    /**
     * Sets the value of the unidadTiempo property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setUnidadTiempo(String value) {
        this.unidadTiempo = value;
    }

}
