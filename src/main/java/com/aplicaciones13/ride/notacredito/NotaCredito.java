
package com.aplicaciones13.ride.notacredito;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


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
 *         &lt;element name="infoTributaria" type="{}infoTributaria"/>
 *         &lt;element name="infoNotaCredito">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="fechaEmision" type="{}fechaEmision"/>
 *                   &lt;element name="dirEstablecimiento" type="{}dirEstablecimiento" minOccurs="0"/>
 *                   &lt;element name="tipoIdentificacionComprador" type="{}tipoIdentificacionComprador"/>
 *                   &lt;element name="razonSocialComprador" type="{}razonSocialComprador"/>
 *                   &lt;element name="identificacionComprador" type="{}identificacionComprador"/>
 *                   &lt;element name="contribuyenteEspecial" type="{}contribuyenteEspecial" minOccurs="0"/>
 *                   &lt;element name="obligadoContabilidad" type="{}obligadoContabilidad" minOccurs="0"/>
 *                   &lt;element name="rise" type="{}rise" minOccurs="0"/>
 *                   &lt;element name="codDocModificado" type="{}codDocModificado"/>
 *                   &lt;element name="numDocModificado" type="{}numDocModificado"/>
 *                   &lt;element name="fechaEmisionDocSustento" type="{}fechaEmisionDocSustento"/>
 *                   &lt;element name="totalSinImpuestos" type="{}totalSinImpuestos"/>
 *                   &lt;element name="valorModificacion" type="{}valorModificacion"/>
 *                   &lt;element name="moneda" type="{}moneda" minOccurs="0"/>
 *                   &lt;element ref="{}totalConImpuestos"/>
 *                   &lt;element name="motivo" type="{}motivo"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="detalles">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="detalle" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="codigoInterno" type="{}codigoInterno"/>
 *                             &lt;element name="codigoAdicional" type="{}codigoAdicional" minOccurs="0"/>
 *                             &lt;element name="descripcion" type="{}descripcion"/>
 *                             &lt;element name="cantidad" type="{}cantidad"/>
 *                             &lt;element name="precioUnitario" type="{}precioUnitario"/>
 *                             &lt;element name="descuento" type="{}descuento" minOccurs="0"/>
 *                             &lt;element name="precioTotalSinImpuesto" type="{}precioTotalSinImpuesto"/>
 *                             &lt;element name="detallesAdicionales" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="detAdicional" maxOccurs="3">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;attribute name="nombre">
 *                                                 &lt;simpleType>
 *                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                                     &lt;minLength value="1"/>
 *                                                     &lt;maxLength value="300"/>
 *                                                   &lt;/restriction>
 *                                                 &lt;/simpleType>
 *                                               &lt;/attribute>
 *                                               &lt;attribute name="valor">
 *                                                 &lt;simpleType>
 *                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                                     &lt;pattern value="([A-Z]|[a-z]|[0-9]|�|�)+([\w]|[\S]|[^\n])*"/>
 *                                                     &lt;minLength value="1"/>
 *                                                     &lt;maxLength value="300"/>
 *                                                   &lt;/restriction>
 *                                                 &lt;/simpleType>
 *                                               &lt;/attribute>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="impuestos">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="impuesto" type="{}impuesto" maxOccurs="unbounded" minOccurs="0"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="infoAdicional" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="campoAdicional" maxOccurs="15">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;>campoAdicional">
 *                           &lt;attribute name="nombre" type="{}nombre" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="comprobante"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="version" use="required" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "",
         propOrder = { "infoTributaria", "infoNotaCredito", "detalles",
                       "infoAdicional" })
@XmlRootElement(name = "notaCredito")
public class NotaCredito {

    @XmlElement(required = true)
    protected InfoTributaria infoTributaria;
    @XmlElement(required = true)
    protected NotaCredito.InfoNotaCredito infoNotaCredito;
    @XmlElement(required = true)
    protected NotaCredito.Detalles detalles;
    protected NotaCredito.InfoAdicional infoAdicional;
    @XmlAttribute(name = "id", required = true)
    protected String id;
    @XmlAttribute(name = "version", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NMTOKEN")
    protected String version;

    /**
     * Gets the value of the infoTributaria property.
     *
     * @return
     *     possible object is
     *     {@link InfoTributaria }
     *
     */
    public InfoTributaria getInfoTributaria() {
        return infoTributaria;
    }

    /**
     * Sets the value of the infoTributaria property.
     *
     * @param value
     *     allowed object is
     *     {@link InfoTributaria }
     *
     */
    public void setInfoTributaria(InfoTributaria value) {
        this.infoTributaria = value;
    }

    /**
     * Gets the value of the infoNotaCredito property.
     *
     * @return
     *     possible object is
     *     {@link NotaCredito.InfoNotaCredito }
     *
     */
    public NotaCredito.InfoNotaCredito getInfoNotaCredito() {
        return infoNotaCredito;
    }

    /**
     * Sets the value of the infoNotaCredito property.
     *
     * @param value
     *     allowed object is
     *     {@link NotaCredito.InfoNotaCredito }
     *
     */
    public void setInfoNotaCredito(NotaCredito.InfoNotaCredito value) {
        this.infoNotaCredito = value;
    }

    /**
     * Gets the value of the detalles property.
     *
     * @return
     *     possible object is
     *     {@link NotaCredito.Detalles }
     *
     */
    public NotaCredito.Detalles getDetalles() {
        return detalles;
    }

    /**
     * Sets the value of the detalles property.
     *
     * @param value
     *     allowed object is
     *     {@link NotaCredito.Detalles }
     *
     */
    public void setDetalles(NotaCredito.Detalles value) {
        this.detalles = value;
    }

    /**
     * Gets the value of the infoAdicional property.
     *
     * @return
     *     possible object is
     *     {@link NotaCredito.InfoAdicional }
     *
     */
    public NotaCredito.InfoAdicional getInfoAdicional() {
        return infoAdicional;
    }

    /**
     * Sets the value of the infoAdicional property.
     *
     * @param value
     *     allowed object is
     *     {@link NotaCredito.InfoAdicional }
     *
     */
    public void setInfoAdicional(NotaCredito.InfoAdicional value) {
        this.infoAdicional = value;
    }

    /**
     * Gets the value of the id property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the version property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setVersion(String value) {
        this.version = value;
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
     *         &lt;element name="detalle" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="codigoInterno" type="{}codigoInterno"/>
     *                   &lt;element name="codigoAdicional" type="{}codigoAdicional" minOccurs="0"/>
     *                   &lt;element name="descripcion" type="{}descripcion"/>
     *                   &lt;element name="cantidad" type="{}cantidad"/>
     *                   &lt;element name="precioUnitario" type="{}precioUnitario"/>
     *                   &lt;element name="descuento" type="{}descuento" minOccurs="0"/>
     *                   &lt;element name="precioTotalSinImpuesto" type="{}precioTotalSinImpuesto"/>
     *                   &lt;element name="detallesAdicionales" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="detAdicional" maxOccurs="3">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;attribute name="nombre">
     *                                       &lt;simpleType>
     *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                           &lt;minLength value="1"/>
     *                                           &lt;maxLength value="300"/>
     *                                         &lt;/restriction>
     *                                       &lt;/simpleType>
     *                                     &lt;/attribute>
     *                                     &lt;attribute name="valor">
     *                                       &lt;simpleType>
     *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                           &lt;pattern value="([A-Z]|[a-z]|[0-9]|�|�)+([\w]|[\S]|[^\n])*"/>
     *                                           &lt;minLength value="1"/>
     *                                           &lt;maxLength value="300"/>
     *                                         &lt;/restriction>
     *                                       &lt;/simpleType>
     *                                     &lt;/attribute>
     *                                   &lt;/restriction>
     *                                 &lt;/complexContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="impuestos">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="impuesto" type="{}impuesto" maxOccurs="unbounded" minOccurs="0"/>
     *                           &lt;/sequence>
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
    @XmlType(name = "", propOrder = { "detalle" })
    public static class Detalles {

        @XmlElement(required = true)
        protected List<NotaCredito.Detalles.Detalle> detalle;

        /**
         * Gets the value of the detalle property.
         *
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the detalle property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDetalle().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link NotaCredito.Detalles.Detalle }
         *
         *
         */
        public List<NotaCredito.Detalles.Detalle> getDetalle() {
            if (detalle == null) {
                detalle = new ArrayList<NotaCredito.Detalles.Detalle>();
            }
            return this.detalle;
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
         *         &lt;element name="codigoInterno" type="{}codigoInterno"/>
         *         &lt;element name="codigoAdicional" type="{}codigoAdicional" minOccurs="0"/>
         *         &lt;element name="descripcion" type="{}descripcion"/>
         *         &lt;element name="cantidad" type="{}cantidad"/>
         *         &lt;element name="precioUnitario" type="{}precioUnitario"/>
         *         &lt;element name="descuento" type="{}descuento" minOccurs="0"/>
         *         &lt;element name="precioTotalSinImpuesto" type="{}precioTotalSinImpuesto"/>
         *         &lt;element name="detallesAdicionales" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="detAdicional" maxOccurs="3">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;attribute name="nombre">
         *                             &lt;simpleType>
         *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                                 &lt;minLength value="1"/>
         *                                 &lt;maxLength value="300"/>
         *                               &lt;/restriction>
         *                             &lt;/simpleType>
         *                           &lt;/attribute>
         *                           &lt;attribute name="valor">
         *                             &lt;simpleType>
         *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                                 &lt;pattern value="([A-Z]|[a-z]|[0-9]|�|�)+([\w]|[\S]|[^\n])*"/>
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
         *         &lt;element name="impuestos">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="impuesto" type="{}impuesto" maxOccurs="unbounded" minOccurs="0"/>
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
        @XmlType(name = "",
                 propOrder = { "codigoInterno", "codigoAdicional", "descripcion",
                               "cantidad", "precioUnitario", "descuento",
                               "precioTotalSinImpuesto", "detallesAdicionales",
                               "impuestos" })
        public static class Detalle {

            @XmlElement(required = true)
            protected String codigoInterno;
            protected String codigoAdicional;
            @XmlElement(required = true)
            protected String descripcion;
            @XmlElement(required = true)
            protected BigDecimal cantidad;
            @XmlElement(required = true)
            protected BigDecimal precioUnitario;
            protected BigDecimal descuento;
            @XmlElement(required = true)
            protected BigDecimal precioTotalSinImpuesto;
            protected NotaCredito.Detalles.Detalle.DetallesAdicionales detallesAdicionales;
            @XmlElement(required = true)
            protected NotaCredito.Detalles.Detalle.Impuestos impuestos;

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
             * Gets the value of the precioUnitario property.
             *
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *
             */
            public BigDecimal getPrecioUnitario() {
                return precioUnitario;
            }

            /**
             * Sets the value of the precioUnitario property.
             *
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *
             */
            public void setPrecioUnitario(BigDecimal value) {
                this.precioUnitario = value;
            }

            /**
             * Gets the value of the descuento property.
             *
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *
             */
            public BigDecimal getDescuento() {
                return descuento;
            }

            /**
             * Sets the value of the descuento property.
             *
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *
             */
            public void setDescuento(BigDecimal value) {
                this.descuento = value;
            }

            /**
             * Gets the value of the precioTotalSinImpuesto property.
             *
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *
             */
            public BigDecimal getPrecioTotalSinImpuesto() {
                return precioTotalSinImpuesto;
            }

            /**
             * Sets the value of the precioTotalSinImpuesto property.
             *
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *
             */
            public void setPrecioTotalSinImpuesto(BigDecimal value) {
                this.precioTotalSinImpuesto = value;
            }

            /**
             * Gets the value of the detallesAdicionales property.
             *
             * @return
             *     possible object is
             *     {@link NotaCredito.Detalles.Detalle.DetallesAdicionales }
             *
             */
            public NotaCredito.Detalles.Detalle.DetallesAdicionales getDetallesAdicionales() {
                return detallesAdicionales;
            }

            /**
             * Sets the value of the detallesAdicionales property.
             *
             * @param value
             *     allowed object is
             *     {@link NotaCredito.Detalles.Detalle.DetallesAdicionales }
             *
             */
            public void setDetallesAdicionales(NotaCredito.Detalles.Detalle.DetallesAdicionales value) {
                this.detallesAdicionales = value;
            }

            /**
             * Gets the value of the impuestos property.
             *
             * @return
             *     possible object is
             *     {@link NotaCredito.Detalles.Detalle.Impuestos }
             *
             */
            public NotaCredito.Detalles.Detalle.Impuestos getImpuestos() {
                return impuestos;
            }

            /**
             * Sets the value of the impuestos property.
             *
             * @param value
             *     allowed object is
             *     {@link NotaCredito.Detalles.Detalle.Impuestos }
             *
             */
            public void setImpuestos(NotaCredito.Detalles.Detalle.Impuestos value) {
                this.impuestos = value;
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
             *         &lt;element name="detAdicional" maxOccurs="3">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;attribute name="nombre">
             *                   &lt;simpleType>
             *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *                       &lt;minLength value="1"/>
             *                       &lt;maxLength value="300"/>
             *                     &lt;/restriction>
             *                   &lt;/simpleType>
             *                 &lt;/attribute>
             *                 &lt;attribute name="valor">
             *                   &lt;simpleType>
             *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *                       &lt;pattern value="([A-Z]|[a-z]|[0-9]|�|�)+([\w]|[\S]|[^\n])*"/>
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

                @XmlElement(required = true)
                protected List<NotaCredito.Detalles.Detalle.DetallesAdicionales.DetAdicional> detAdicional;

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
                 * {@link NotaCredito.Detalles.Detalle.DetallesAdicionales.DetAdicional }
                 *
                 *
                 */
                public List<NotaCredito.Detalles.Detalle.DetallesAdicionales.DetAdicional> getDetAdicional() {
                    if (detAdicional == null) {
                        detAdicional =
                                new ArrayList<NotaCredito.Detalles.Detalle.DetallesAdicionales.DetAdicional>();
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
                 *           &lt;/restriction>
                 *         &lt;/simpleType>
                 *       &lt;/attribute>
                 *       &lt;attribute name="valor">
                 *         &lt;simpleType>
                 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
                 *             &lt;pattern value="([A-Z]|[a-z]|[0-9]|�|�)+([\w]|[\S]|[^\n])*"/>
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
             *         &lt;element name="impuesto" type="{}impuesto" maxOccurs="unbounded" minOccurs="0"/>
             *       &lt;/sequence>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             *
             *
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = { "impuesto" })
            public static class Impuestos {

                protected List<Impuesto> impuesto;

                /**
                 * Gets the value of the impuesto property.
                 *
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the impuesto property.
                 *
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getImpuesto().add(newItem);
                 * </pre>
                 *
                 *
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link Impuesto }
                 *
                 *
                 */
                public List<Impuesto> getImpuesto() {
                    if (impuesto == null) {
                        impuesto = new ArrayList<Impuesto>();
                    }
                    return this.impuesto;
                }

            }

        }

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
     *         &lt;element name="campoAdicional" maxOccurs="15">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;>campoAdicional">
     *                 &lt;attribute name="nombre" type="{}nombre" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
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
    @XmlType(name = "", propOrder = { "campoAdicional" })
    public static class InfoAdicional {

        @XmlElement(required = true)
        protected List<NotaCredito.InfoAdicional.CampoAdicional> campoAdicional;

        /**
         * Gets the value of the campoAdicional property.
         *
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the campoAdicional property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCampoAdicional().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link NotaCredito.InfoAdicional.CampoAdicional }
         *
         *
         */
        public List<NotaCredito.InfoAdicional.CampoAdicional> getCampoAdicional() {
            if (campoAdicional == null) {
                campoAdicional =
                        new ArrayList<NotaCredito.InfoAdicional.CampoAdicional>();
            }
            return this.campoAdicional;
        }


        /**
         * <p>Java class for anonymous complex type.
         *
         * <p>The following schema fragment specifies the expected content contained within this class.
         *
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;>campoAdicional">
         *       &lt;attribute name="nombre" type="{}nombre" />
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         *
         *
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = { "value" })
        public static class CampoAdicional {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "nombre")
            protected String nombre;

            /**
             * Gets the value of the value property.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setValue(String value) {
                this.value = value;
            }

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

        }

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
     *         &lt;element name="fechaEmision" type="{}fechaEmision"/>
     *         &lt;element name="dirEstablecimiento" type="{}dirEstablecimiento" minOccurs="0"/>
     *         &lt;element name="tipoIdentificacionComprador" type="{}tipoIdentificacionComprador"/>
     *         &lt;element name="razonSocialComprador" type="{}razonSocialComprador"/>
     *         &lt;element name="identificacionComprador" type="{}identificacionComprador"/>
     *         &lt;element name="contribuyenteEspecial" type="{}contribuyenteEspecial" minOccurs="0"/>
     *         &lt;element name="obligadoContabilidad" type="{}obligadoContabilidad" minOccurs="0"/>
     *         &lt;element name="rise" type="{}rise" minOccurs="0"/>
     *         &lt;element name="codDocModificado" type="{}codDocModificado"/>
     *         &lt;element name="numDocModificado" type="{}numDocModificado"/>
     *         &lt;element name="fechaEmisionDocSustento" type="{}fechaEmisionDocSustento"/>
     *         &lt;element name="totalSinImpuestos" type="{}totalSinImpuestos"/>
     *         &lt;element name="valorModificacion" type="{}valorModificacion"/>
     *         &lt;element name="moneda" type="{}moneda" minOccurs="0"/>
     *         &lt;element ref="{}totalConImpuestos"/>
     *         &lt;element name="motivo" type="{}motivo"/>
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
             propOrder = { "fechaEmision", "dirEstablecimiento", "tipoIdentificacionComprador",
                           "razonSocialComprador", "identificacionComprador",
                           "contribuyenteEspecial", "obligadoContabilidad",
                           "rise", "codDocModificado", "numDocModificado",
                           "fechaEmisionDocSustento", "totalSinImpuestos",
                           "valorModificacion", "moneda", "totalConImpuestos",
                           "motivo" })
    public static class InfoNotaCredito {

        @XmlElement(required = true)
        protected String fechaEmision;
        protected String dirEstablecimiento;
        @XmlElement(required = true)
        protected String tipoIdentificacionComprador;
        @XmlElement(required = true)
        protected String razonSocialComprador;
        @XmlElement(required = true)
        protected String identificacionComprador;
        protected String contribuyenteEspecial;
        protected String obligadoContabilidad;
        protected String rise;
        @XmlElement(required = true)
        protected String codDocModificado;
        @XmlElement(required = true)
        protected String numDocModificado;
        @XmlElement(required = true)
        protected String fechaEmisionDocSustento;
        @XmlElement(required = true)
        protected BigDecimal totalSinImpuestos;
        @XmlElement(required = true)
        protected BigDecimal valorModificacion;
        protected String moneda;
        @XmlElement(required = true)
        protected TotalConImpuestos totalConImpuestos;
        @XmlElement(required = true)
        protected String motivo;

        /**
         * Gets the value of the fechaEmision property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getFechaEmision() {
            return fechaEmision;
        }

        /**
         * Sets the value of the fechaEmision property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setFechaEmision(String value) {
            this.fechaEmision = value;
        }

        /**
         * Gets the value of the dirEstablecimiento property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getDirEstablecimiento() {
            return dirEstablecimiento;
        }

        /**
         * Sets the value of the dirEstablecimiento property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setDirEstablecimiento(String value) {
            this.dirEstablecimiento = value;
        }

        /**
         * Gets the value of the tipoIdentificacionComprador property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getTipoIdentificacionComprador() {
            return tipoIdentificacionComprador;
        }

        /**
         * Sets the value of the tipoIdentificacionComprador property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setTipoIdentificacionComprador(String value) {
            this.tipoIdentificacionComprador = value;
        }

        /**
         * Gets the value of the razonSocialComprador property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getRazonSocialComprador() {
            return razonSocialComprador;
        }

        /**
         * Sets the value of the razonSocialComprador property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setRazonSocialComprador(String value) {
            this.razonSocialComprador = value;
        }

        /**
         * Gets the value of the identificacionComprador property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getIdentificacionComprador() {
            return identificacionComprador;
        }

        /**
         * Sets the value of the identificacionComprador property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setIdentificacionComprador(String value) {
            this.identificacionComprador = value;
        }

        /**
         * Gets the value of the contribuyenteEspecial property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getContribuyenteEspecial() {
            return contribuyenteEspecial;
        }

        /**
         * Sets the value of the contribuyenteEspecial property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setContribuyenteEspecial(String value) {
            this.contribuyenteEspecial = value;
        }

        /**
         * Gets the value of the obligadoContabilidad property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getObligadoContabilidad() {
            return obligadoContabilidad;
        }

        /**
         * Sets the value of the obligadoContabilidad property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setObligadoContabilidad(String value) {
            this.obligadoContabilidad = value;
        }

        /**
         * Gets the value of the rise property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getRise() {
            return rise;
        }

        /**
         * Sets the value of the rise property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setRise(String value) {
            this.rise = value;
        }

        /**
         * Gets the value of the codDocModificado property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getCodDocModificado() {
            return codDocModificado;
        }

        /**
         * Sets the value of the codDocModificado property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setCodDocModificado(String value) {
            this.codDocModificado = value;
        }

        /**
         * Gets the value of the numDocModificado property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getNumDocModificado() {
            return numDocModificado;
        }

        /**
         * Sets the value of the numDocModificado property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setNumDocModificado(String value) {
            this.numDocModificado = value;
        }

        /**
         * Gets the value of the fechaEmisionDocSustento property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getFechaEmisionDocSustento() {
            return fechaEmisionDocSustento;
        }

        /**
         * Sets the value of the fechaEmisionDocSustento property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setFechaEmisionDocSustento(String value) {
            this.fechaEmisionDocSustento = value;
        }

        /**
         * Gets the value of the totalSinImpuestos property.
         *
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *
         */
        public BigDecimal getTotalSinImpuestos() {
            return totalSinImpuestos;
        }

        /**
         * Sets the value of the totalSinImpuestos property.
         *
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *
         */
        public void setTotalSinImpuestos(BigDecimal value) {
            this.totalSinImpuestos = value;
        }

        /**
         * Gets the value of the valorModificacion property.
         *
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *
         */
        public BigDecimal getValorModificacion() {
            return valorModificacion;
        }

        /**
         * Sets the value of the valorModificacion property.
         *
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *
         */
        public void setValorModificacion(BigDecimal value) {
            this.valorModificacion = value;
        }

        /**
         * Gets the value of the moneda property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getMoneda() {
            return moneda;
        }

        /**
         * Sets the value of the moneda property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setMoneda(String value) {
            this.moneda = value;
        }

        /**
         * Gets the value of the totalConImpuestos property.
         *
         * @return
         *     possible object is
         *     {@link TotalConImpuestos }
         *
         */
        public TotalConImpuestos getTotalConImpuestos() {
            return totalConImpuestos;
        }

        /**
         * Sets the value of the totalConImpuestos property.
         *
         * @param value
         *     allowed object is
         *     {@link TotalConImpuestos }
         *
         */
        public void setTotalConImpuestos(TotalConImpuestos value) {
            this.totalConImpuestos = value;
        }

        /**
         * Gets the value of the motivo property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getMotivo() {
            return motivo;
        }

        /**
         * Sets the value of the motivo property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setMotivo(String value) {
            this.motivo = value;
        }

    }

}
