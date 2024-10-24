//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.04.28 at 10:44:46 a. m. ECT 
//


package com.aplicaciones13.documentos.estructuras.notacredito.v1_0_0;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="totalImpuesto" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="codigo" type="{}codigo"/>
 *                   &lt;element name="codigoPorcentaje" type="{}codigoPorcentaje"/>
 *                   &lt;element name="baseImponible" type="{}baseImponible"/>
 *                   &lt;element name="valor" type="{}valor"/>
 *                   &lt;element name="valorDevolucionIva" type="{}valorDevolucionIva" minOccurs="0"/>
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
@XmlType(name = "", propOrder = {
    "totalImpuesto"
})
@XmlRootElement(name = "totalConImpuestos")
public class TotalConImpuestos {

    @XmlElement(required = true)
    protected List<TotalConImpuestos.TotalImpuesto> totalImpuesto;

    /**
     * Gets the value of the totalImpuesto property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the totalImpuesto property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTotalImpuesto().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TotalConImpuestos.TotalImpuesto }
     * 
     * 
     */
    public List<TotalConImpuestos.TotalImpuesto> getTotalImpuesto() {
        if (totalImpuesto == null) {
            totalImpuesto = new ArrayList<TotalConImpuestos.TotalImpuesto>();
        }
        return this.totalImpuesto;
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
     *         &lt;element name="codigo" type="{}codigo"/>
     *         &lt;element name="codigoPorcentaje" type="{}codigoPorcentaje"/>
     *         &lt;element name="baseImponible" type="{}baseImponible"/>
     *         &lt;element name="valor" type="{}valor"/>
     *         &lt;element name="valorDevolucionIva" type="{}valorDevolucionIva" minOccurs="0"/>
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
        "codigo",
        "codigoPorcentaje",
        "baseImponible",
        "valor",
        "valorDevolucionIva"
    })
    public static class TotalImpuesto {

        @XmlElement(required = true)
        protected String codigo;
        @XmlElement(required = true)
        protected String codigoPorcentaje;
        @XmlElement(required = true)
        protected BigDecimal baseImponible;
        @XmlElement(required = true)
        protected BigDecimal valor;
        protected BigDecimal valorDevolucionIva;

        /**
         * Gets the value of the codigo property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCodigo() {
            return codigo;
        }

        /**
         * Sets the value of the codigo property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCodigo(String value) {
            this.codigo = value;
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
         * Gets the value of the valor property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getValor() {
            return valor;
        }

        /**
         * Sets the value of the valor property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setValor(BigDecimal value) {
            this.valor = value;
        }

        /**
         * Gets the value of the valorDevolucionIva property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getValorDevolucionIva() {
            return valorDevolucionIva;
        }

        /**
         * Sets the value of the valorDevolucionIva property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setValorDevolucionIva(BigDecimal value) {
            this.valorDevolucionIva = value;
        }

    }

}
