//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.04.28 at 10:44:46 a. m. ECT 
//


package com.aplicaciones13.documentos.estructuras.liquidacioncompra.v1_0_0;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for pagos complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="pagos">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="pago" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="formaPago" type="{}formaPago"/>
 *                   &lt;element name="total" type="{}total"/>
 *                   &lt;element name="plazo" type="{}plazo" minOccurs="0"/>
 *                   &lt;element name="unidadTiempo" type="{}unidadTiempo" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pagos", propOrder = {
    "pago"
})
public class Pagos {

    @XmlElement(required = true)
    protected List<Pagos.Pago> pago;

    /**
     * Gets the value of the pago property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pago property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPago().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Pagos.Pago }
     * 
     * 
     */
    public List<Pagos.Pago> getPago() {
        if (pago == null) {
            pago = new ArrayList<Pagos.Pago>();
        }
        return this.pago;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
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
    @XmlType(name = "", propOrder = {
        "formaPago",
        "total",
        "plazo",
        "unidadTiempo"
    })
    public static class Pago {

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

}
