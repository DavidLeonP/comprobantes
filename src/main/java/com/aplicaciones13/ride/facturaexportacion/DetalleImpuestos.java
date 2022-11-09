
package com.aplicaciones13.ride.facturaexportacion;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for detalleImpuestos complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="detalleImpuestos">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="detalleImpuesto" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="codigo" type="{}codigoReembolso"/>
 *                   &lt;element name="codigoPorcentaje" type="{}codigoPorcentajeReembolso"/>
 *                   &lt;element name="tarifa" type="{}tarifaReembolso"/>
 *                   &lt;element name="baseImponibleReembolso" type="{}baseImponibleReembolso"/>
 *                   &lt;element name="impuestoReembolso" type="{}impuestoReembolso"/>
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
@XmlType(name = "detalleImpuestos", propOrder = { "detalleImpuesto" })
public class DetalleImpuestos {

    @XmlElement(required = true)
    protected List<DetalleImpuestos.DetalleImpuesto> detalleImpuesto;

    /**
     * Gets the value of the detalleImpuesto property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the detalleImpuesto property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDetalleImpuesto().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DetalleImpuestos.DetalleImpuesto }
     *
     *
     */
    public List<DetalleImpuestos.DetalleImpuesto> getDetalleImpuesto() {
        if (detalleImpuesto == null) {
            detalleImpuesto =
                    new ArrayList<DetalleImpuestos.DetalleImpuesto>();
        }
        return this.detalleImpuesto;
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
     *         &lt;element name="codigo" type="{}codigoReembolso"/>
     *         &lt;element name="codigoPorcentaje" type="{}codigoPorcentajeReembolso"/>
     *         &lt;element name="tarifa" type="{}tarifaReembolso"/>
     *         &lt;element name="baseImponibleReembolso" type="{}baseImponibleReembolso"/>
     *         &lt;element name="impuestoReembolso" type="{}impuestoReembolso"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "",
             propOrder = { "codigo", "codigoPorcentaje", "tarifa", "baseImponibleReembolso",
                           "impuestoReembolso" })
    public static class DetalleImpuesto {

        @XmlElement(required = true)
        protected String codigo;
        @XmlElement(required = true)
        protected String codigoPorcentaje;
        @XmlElement(required = true)
        protected String tarifa;
        @XmlElement(required = true)
        protected BigDecimal baseImponibleReembolso;
        @XmlElement(required = true)
        protected BigDecimal impuestoReembolso;

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
         * Gets the value of the tarifa property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getTarifa() {
            return tarifa;
        }

        /**
         * Sets the value of the tarifa property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setTarifa(String value) {
            this.tarifa = value;
        }

        /**
         * Gets the value of the baseImponibleReembolso property.
         *
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *
         */
        public BigDecimal getBaseImponibleReembolso() {
            return baseImponibleReembolso;
        }

        /**
         * Sets the value of the baseImponibleReembolso property.
         *
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *
         */
        public void setBaseImponibleReembolso(BigDecimal value) {
            this.baseImponibleReembolso = value;
        }

        /**
         * Gets the value of the impuestoReembolso property.
         *
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *
         */
        public BigDecimal getImpuestoReembolso() {
            return impuestoReembolso;
        }

        /**
         * Sets the value of the impuestoReembolso property.
         *
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *
         */
        public void setImpuestoReembolso(BigDecimal value) {
            this.impuestoReembolso = value;
        }

    }

}
