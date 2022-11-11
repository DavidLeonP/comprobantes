
package com.aplicaciones13.ride.guiaremision;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Detalle de una guia de remision.  Contiene los elementos de cada fila de la guia.
 *
 * <p>Java class for detalle complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="detalle">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codigoInterno" type="{}codigoInterno"/>
 *         &lt;element name="codigoAdicional" type="{}codigoAdicional" minOccurs="0"/>
 *         &lt;element name="descripcion" type="{}descripcion"/>
 *         &lt;element name="cantidad" type="{}cantidad"/>
 *         &lt;element name="detallesAdicionales" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="detAdicional" maxOccurs="3" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;attribute name="nombre">
 *                             &lt;simpleType>
 *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                 &lt;minLength value="1"/>
 *                                 &lt;maxLength value="300"/>
 *                                 &lt;pattern value="([A-Z]|[a-z]|[0-9]|Ñ|ñ)+([\w]|[\S]|[^\n])*"/>
 *                               &lt;/restriction>
 *                             &lt;/simpleType>
 *                           &lt;/attribute>
 *                           &lt;attribute name="valor">
 *                             &lt;simpleType>
 *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                 &lt;pattern value="([A-Z]|[a-z]|[0-9]|Ñ|ñ)+([\w]|[\S]|[^\n])*"/>
 *                                 &lt;minLength value="1"/>
 *                                 &lt;maxLength value="300"/>
 *                               &lt;/restriction>
 *                             &lt;/simpleType>
 *                           &lt;/attribute>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
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
@XmlType(name = "detalle",
         propOrder = { "codigoInterno", "codigoAdicional", "descripcion",
                       "cantidad", "detallesAdicionales" })
public class Detalle {

    @XmlElement(required = true)
    protected String codigoInterno;
    protected String codigoAdicional;
    @XmlElement(required = true)
    protected String descripcion;
    @XmlElement(required = true)
    protected BigDecimal cantidad;
    protected Detalle.DetallesAdicionales detallesAdicionales;

    /**
     * Gets the value of the codigoInterno property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCodigoInterno() {
        return codigoInterno;
    }

    /**
     * Sets the value of the codigoInterno property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCodigoInterno(String value) {
        this.codigoInterno = value;
    }

    /**
     * Gets the value of the codigoAdicional property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCodigoAdicional() {
        return codigoAdicional;
    }

    /**
     * Sets the value of the codigoAdicional property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCodigoAdicional(String value) {
        this.codigoAdicional = value;
    }

    /**
     * Gets the value of the descripcion property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Sets the value of the descripcion property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDescripcion(String value) {
        this.descripcion = value;
    }

    /**
     * Gets the value of the cantidad property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getCantidad() {
        return cantidad;
    }

    /**
     * Sets the value of the cantidad property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setCantidad(BigDecimal value) {
        this.cantidad = value;
    }

    /**
     * Gets the value of the detallesAdicionales property.
     *
     * @return
     *     possible object is
     *     {@link Detalle.DetallesAdicionales }
     *
     */
    public Detalle.DetallesAdicionales getDetallesAdicionales() {
        return detallesAdicionales;
    }

    /**
     * Sets the value of the detallesAdicionales property.
     *
     * @param value
     *     allowed object is
     *     {@link Detalle.DetallesAdicionales }
     *
     */
    public void setDetallesAdicionales(Detalle.DetallesAdicionales value) {
        this.detallesAdicionales = value;
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
     *         &lt;element name="detAdicional" maxOccurs="3" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;attribute name="nombre">
     *                   &lt;simpleType>
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                       &lt;minLength value="1"/>
     *                       &lt;maxLength value="300"/>
     *                       &lt;pattern value="([A-Z]|[a-z]|[0-9]|Ñ|ñ)+([\w]|[\S]|[^\n])*"/>
     *                     &lt;/restriction>
     *                   &lt;/simpleType>
     *                 &lt;/attribute>
     *                 &lt;attribute name="valor">
     *                   &lt;simpleType>
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                       &lt;pattern value="([A-Z]|[a-z]|[0-9]|Ñ|ñ)+([\w]|[\S]|[^\n])*"/>
     *                       &lt;minLength value="1"/>
     *                       &lt;maxLength value="300"/>
     *                     &lt;/restriction>
     *                   &lt;/simpleType>
     *                 &lt;/attribute>
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
    @XmlType(name = "", propOrder = { "detAdicional" })
    public static class DetallesAdicionales {

        protected List<Detalle.DetallesAdicionales.DetAdicional> detAdicional;

        /**
         * Gets the value of the detAdicional property.
         *
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the detAdicional property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDetAdicional().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Detalle.DetallesAdicionales.DetAdicional }
         *
         *
         */
        public List<Detalle.DetallesAdicionales.DetAdicional> getDetAdicional() {
            if (detAdicional == null) {
                detAdicional = new ArrayList<>();
            }
            return this.detAdicional;
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
         *       &lt;attribute name="nombre">
         *         &lt;simpleType>
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *             &lt;minLength value="1"/>
         *             &lt;maxLength value="300"/>
         *             &lt;pattern value="([A-Z]|[a-z]|[0-9]|Ñ|ñ)+([\w]|[\S]|[^\n])*"/>
         *           &lt;/restriction>
         *         &lt;/simpleType>
         *       &lt;/attribute>
         *       &lt;attribute name="valor">
         *         &lt;simpleType>
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *             &lt;pattern value="([A-Z]|[a-z]|[0-9]|Ñ|ñ)+([\w]|[\S]|[^\n])*"/>
         *             &lt;minLength value="1"/>
         *             &lt;maxLength value="300"/>
         *           &lt;/restriction>
         *         &lt;/simpleType>
         *       &lt;/attribute>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         *
         *
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class DetAdicional {

            @XmlAttribute(name = "nombre")
            protected String nombre;
            @XmlAttribute(name = "valor")
            protected String valor;

            /**
             * Gets the value of the nombre property.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getNombre() {
                return nombre;
            }

            /**
             * Sets the value of the nombre property.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setNombre(String value) {
                this.nombre = value;
            }

            /**
             * Gets the value of the valor property.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getValor() {
                return valor;
            }

            /**
             * Sets the value of the valor property.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setValor(String value) {
                this.valor = value;
            }

        }

    }

}
