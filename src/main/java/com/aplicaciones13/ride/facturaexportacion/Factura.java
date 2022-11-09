
package com.aplicaciones13.ride.facturaexportacion;

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
 *         &lt;element name="infoFactura">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="fechaEmision" type="{}fechaEmision"/>
 *                   &lt;element name="dirEstablecimiento" type="{}dirEstablecimiento" minOccurs="0"/>
 *                   &lt;element name="contribuyenteEspecial" type="{}contribuyenteEspecial" minOccurs="0"/>
 *                   &lt;element name="obligadoContabilidad" type="{}obligadoContabilidad" minOccurs="0"/>
 *                   &lt;element name="comercioExterior" type="{}comercioExterior" minOccurs="0"/>
 *                   &lt;element name="incoTermFactura" type="{}incoTermFactura" minOccurs="0"/>
 *                   &lt;element name="lugarIncoTerm" type="{}lugarIncoTerm" minOccurs="0"/>
 *                   &lt;element name="paisOrigen" type="{}paisOrigen" minOccurs="0"/>
 *                   &lt;element name="puertoEmbarque" type="{}puertoEmbarque" minOccurs="0"/>
 *                   &lt;element name="puertoDestino" type="{}puertoDestino" minOccurs="0"/>
 *                   &lt;element name="paisDestino" type="{}paisDestino" minOccurs="0"/>
 *                   &lt;element name="paisAdquisicion" type="{}paisAdquisicion" minOccurs="0"/>
 *                   &lt;element name="tipoIdentificacionComprador" type="{}tipoIdentificacionComprador"/>
 *                   &lt;element name="guiaRemision" type="{}guiaRemision" minOccurs="0"/>
 *                   &lt;element name="razonSocialComprador" type="{}razonSocialComprador"/>
 *                   &lt;element name="identificacionComprador" type="{}identificacionComprador"/>
 *                   &lt;element name="direccionComprador" type="{}direccionComprador" minOccurs="0"/>
 *                   &lt;element name="totalSinImpuestos" type="{}totalSinImpuestos"/>
 *                   &lt;element name="incoTermTotalSinImpuestos" type="{}incoTermTotalSinImpuestos" minOccurs="0"/>
 *                   &lt;element name="totalDescuento" type="{}totalDescuentos"/>
 *                   &lt;element name="codDocReembolso" type="{}codigoDocumentoReembolso" minOccurs="0"/>
 *                   &lt;element name="totalComprobantesReembolso" type="{}totalComprobantesReembolso" minOccurs="0"/>
 *                   &lt;element name="totalBaseImponibleReembolso" type="{}totalBaseImponibleReembolso" minOccurs="0"/>
 *                   &lt;element name="totalImpuestoReembolso" type="{}totalImpuestoReembolso" minOccurs="0"/>
 *                   &lt;element name="totalConImpuestos">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="totalImpuesto" maxOccurs="unbounded">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="codigo" type="{}codigo"/>
 *                                       &lt;element name="codigoPorcentaje" type="{}codigoPorcentaje"/>
 *                                       &lt;element name="descuentoAdicional" type="{}descuentoAdicional" minOccurs="0"/>
 *                                       &lt;element name="baseImponible" type="{}baseImponible"/>
 *                                       &lt;element name="tarifa" type="{}tarifa" minOccurs="0"/>
 *                                       &lt;element name="valor" type="{}valor"/>
 *                                       &lt;element name="valorDevolucionIva" type="{}valorDevolucionIva" minOccurs="0"/>
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
 *                   &lt;element name="propina" type="{}propina"/>
 *                   &lt;element name="fleteInternacional" type="{}fleteInternacional" minOccurs="0"/>
 *                   &lt;element name="seguroInternacional" type="{}seguroInternacional" minOccurs="0"/>
 *                   &lt;element name="gastosAduaneros" type="{}gastosAduaneros" minOccurs="0"/>
 *                   &lt;element name="gastosTransporteOtros" type="{}gastosTransporteOtros" minOccurs="0"/>
 *                   &lt;element name="importeTotal" type="{}importeTotal"/>
 *                   &lt;element name="moneda" type="{}moneda" minOccurs="0"/>
 *                   &lt;element name="pagos" type="{}pagos" minOccurs="0"/>
 *                   &lt;element name="valorRetIva" type="{}valorRetIva" minOccurs="0"/>
 *                   &lt;element name="valorRetRenta" type="{}valorRetRenta" minOccurs="0"/>
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
 *                             &lt;element name="codigoPrincipal" type="{}codigoPrincipal" minOccurs="0"/>
 *                             &lt;element name="codigoAuxiliar" type="{}codigoAuxiliar" minOccurs="0"/>
 *                             &lt;element name="descripcion" type="{}descripcion"/>
 *                             &lt;element name="unidadMedida" type="{}unidadMedida" minOccurs="0"/>
 *                             &lt;element name="cantidad" type="{}cantidad"/>
 *                             &lt;element name="precioUnitario" type="{}precioUnitario"/>
 *                             &lt;element name="descuento" type="{}descuento"/>
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
 *                                                     &lt;pattern value="[^\n]*"/>
 *                                                     &lt;minLength value="1"/>
 *                                                     &lt;maxLength value="300"/>
 *                                                   &lt;/restriction>
 *                                                 &lt;/simpleType>
 *                                               &lt;/attribute>
 *                                               &lt;attribute name="valor">
 *                                                 &lt;simpleType>
 *                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                                     &lt;pattern value="[^\n]*"/>
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
 *                                       &lt;element name="impuesto" type="{}impuesto" maxOccurs="unbounded"/>
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
 *         &lt;element name="reembolsos" type="{}reembolsos" minOccurs="0"/>
 *         &lt;element name="retenciones" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="retencion" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="codigo" type="{}codigoRetencion"/>
 *                             &lt;element name="codigoPorcentaje" type="{}codigoPorcentajeRetencion"/>
 *                             &lt;element name="tarifa" type="{}tarifaRetencion"/>
 *                             &lt;element name="valor" type="{}valorRetencion"/>
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
 *       &lt;attribute name="id">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="comprobante"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="version" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "",
         propOrder = { "infoTributaria", "infoFactura", "detalles", "reembolsos",
                       "retenciones", "infoAdicional" })
@XmlRootElement(name = "factura")
public class Factura {

    @XmlElement(required = true)
    protected InfoTributaria infoTributaria;
    @XmlElement(required = true)
    protected Factura.InfoFactura infoFactura;
    @XmlElement(required = true)
    protected Factura.Detalles detalles;
    protected Reembolsos reembolsos;
    protected Factura.Retenciones retenciones;
    protected Factura.InfoAdicional infoAdicional;
    @XmlAttribute
    protected String id;
    @XmlAttribute
    @XmlSchemaType(name = "anySimpleType")
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
     * Gets the value of the infoFactura property.
     *
     * @return
     *     possible object is
     *     {@link Factura.InfoFactura }
     *
     */
    public Factura.InfoFactura getInfoFactura() {
        return infoFactura;
    }

    /**
     * Sets the value of the infoFactura property.
     *
     * @param value
     *     allowed object is
     *     {@link Factura.InfoFactura }
     *
     */
    public void setInfoFactura(Factura.InfoFactura value) {
        this.infoFactura = value;
    }

    /**
     * Gets the value of the detalles property.
     *
     * @return
     *     possible object is
     *     {@link Factura.Detalles }
     *
     */
    public Factura.Detalles getDetalles() {
        return detalles;
    }

    /**
     * Sets the value of the detalles property.
     *
     * @param value
     *     allowed object is
     *     {@link Factura.Detalles }
     *
     */
    public void setDetalles(Factura.Detalles value) {
        this.detalles = value;
    }

    /**
     * Gets the value of the reembolsos property.
     *
     * @return
     *     possible object is
     *     {@link Reembolsos }
     *
     */
    public Reembolsos getReembolsos() {
        return reembolsos;
    }

    /**
     * Sets the value of the reembolsos property.
     *
     * @param value
     *     allowed object is
     *     {@link Reembolsos }
     *
     */
    public void setReembolsos(Reembolsos value) {
        this.reembolsos = value;
    }

    /**
     * Gets the value of the retenciones property.
     *
     * @return
     *     possible object is
     *     {@link Factura.Retenciones }
     *
     */
    public Factura.Retenciones getRetenciones() {
        return retenciones;
    }

    /**
     * Sets the value of the retenciones property.
     *
     * @param value
     *     allowed object is
     *     {@link Factura.Retenciones }
     *
     */
    public void setRetenciones(Factura.Retenciones value) {
        this.retenciones = value;
    }

    /**
     * Gets the value of the infoAdicional property.
     *
     * @return
     *     possible object is
     *     {@link Factura.InfoAdicional }
     *
     */
    public Factura.InfoAdicional getInfoAdicional() {
        return infoAdicional;
    }

    /**
     * Sets the value of the infoAdicional property.
     *
     * @param value
     *     allowed object is
     *     {@link Factura.InfoAdicional }
     *
     */
    public void setInfoAdicional(Factura.InfoAdicional value) {
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
     *                   &lt;element name="codigoPrincipal" type="{}codigoPrincipal" minOccurs="0"/>
     *                   &lt;element name="codigoAuxiliar" type="{}codigoAuxiliar" minOccurs="0"/>
     *                   &lt;element name="descripcion" type="{}descripcion"/>
     *                   &lt;element name="unidadMedida" type="{}unidadMedida" minOccurs="0"/>
     *                   &lt;element name="cantidad" type="{}cantidad"/>
     *                   &lt;element name="precioUnitario" type="{}precioUnitario"/>
     *                   &lt;element name="descuento" type="{}descuento"/>
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
     *                                           &lt;pattern value="[^\n]*"/>
     *                                           &lt;minLength value="1"/>
     *                                           &lt;maxLength value="300"/>
     *                                         &lt;/restriction>
     *                                       &lt;/simpleType>
     *                                     &lt;/attribute>
     *                                     &lt;attribute name="valor">
     *                                       &lt;simpleType>
     *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                           &lt;pattern value="[^\n]*"/>
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
     *                             &lt;element name="impuesto" type="{}impuesto" maxOccurs="unbounded"/>
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
        protected List<Factura.Detalles.Detalle> detalle;

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
         * {@link Factura.Detalles.Detalle }
         *
         *
         */
        public List<Factura.Detalles.Detalle> getDetalle() {
            if (detalle == null) {
                detalle = new ArrayList<Factura.Detalles.Detalle>();
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
         *         &lt;element name="codigoPrincipal" type="{}codigoPrincipal" minOccurs="0"/>
         *         &lt;element name="codigoAuxiliar" type="{}codigoAuxiliar" minOccurs="0"/>
         *         &lt;element name="descripcion" type="{}descripcion"/>
         *         &lt;element name="unidadMedida" type="{}unidadMedida" minOccurs="0"/>
         *         &lt;element name="cantidad" type="{}cantidad"/>
         *         &lt;element name="precioUnitario" type="{}precioUnitario"/>
         *         &lt;element name="descuento" type="{}descuento"/>
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
         *                                 &lt;pattern value="[^\n]*"/>
         *                                 &lt;minLength value="1"/>
         *                                 &lt;maxLength value="300"/>
         *                               &lt;/restriction>
         *                             &lt;/simpleType>
         *                           &lt;/attribute>
         *                           &lt;attribute name="valor">
         *                             &lt;simpleType>
         *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                                 &lt;pattern value="[^\n]*"/>
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
         *                   &lt;element name="impuesto" type="{}impuesto" maxOccurs="unbounded"/>
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
                 propOrder = { "codigoPrincipal", "codigoAuxiliar", "descripcion",
                               "unidadMedida", "cantidad", "precioUnitario",
                               "descuento", "precioTotalSinImpuesto",
                               "detallesAdicionales", "impuestos" })
        public static class Detalle {

            protected String codigoPrincipal;
            protected String codigoAuxiliar;
            @XmlElement(required = true)
            protected String descripcion;
            protected String unidadMedida;
            @XmlElement(required = true)
            protected BigDecimal cantidad;
            @XmlElement(required = true)
            protected BigDecimal precioUnitario;
            @XmlElement(required = true)
            protected BigDecimal descuento;
            @XmlElement(required = true)
            protected BigDecimal precioTotalSinImpuesto;
            protected Factura.Detalles.Detalle.DetallesAdicionales detallesAdicionales;
            @XmlElement(required = true)
            protected Factura.Detalles.Detalle.Impuestos impuestos;

            /**
             * Gets the value of the codigoPrincipal property.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getCodigoPrincipal() {
                return codigoPrincipal;
            }

            /**
             * Sets the value of the codigoPrincipal property.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setCodigoPrincipal(String value) {
                this.codigoPrincipal = value;
            }

            /**
             * Gets the value of the codigoAuxiliar property.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getCodigoAuxiliar() {
                return codigoAuxiliar;
            }

            /**
             * Sets the value of the codigoAuxiliar property.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setCodigoAuxiliar(String value) {
                this.codigoAuxiliar = value;
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
             * Gets the value of the unidadMedida property.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getUnidadMedida() {
                return unidadMedida;
            }

            /**
             * Sets the value of the unidadMedida property.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setUnidadMedida(String value) {
                this.unidadMedida = value;
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
             *     {@link Factura.Detalles.Detalle.DetallesAdicionales }
             *
             */
            public Factura.Detalles.Detalle.DetallesAdicionales getDetallesAdicionales() {
                return detallesAdicionales;
            }

            /**
             * Sets the value of the detallesAdicionales property.
             *
             * @param value
             *     allowed object is
             *     {@link Factura.Detalles.Detalle.DetallesAdicionales }
             *
             */
            public void setDetallesAdicionales(Factura.Detalles.Detalle.DetallesAdicionales value) {
                this.detallesAdicionales = value;
            }

            /**
             * Gets the value of the impuestos property.
             *
             * @return
             *     possible object is
             *     {@link Factura.Detalles.Detalle.Impuestos }
             *
             */
            public Factura.Detalles.Detalle.Impuestos getImpuestos() {
                return impuestos;
            }

            /**
             * Sets the value of the impuestos property.
             *
             * @param value
             *     allowed object is
             *     {@link Factura.Detalles.Detalle.Impuestos }
             *
             */
            public void setImpuestos(Factura.Detalles.Detalle.Impuestos value) {
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
             *                       &lt;pattern value="[^\n]*"/>
             *                       &lt;minLength value="1"/>
             *                       &lt;maxLength value="300"/>
             *                     &lt;/restriction>
             *                   &lt;/simpleType>
             *                 &lt;/attribute>
             *                 &lt;attribute name="valor">
             *                   &lt;simpleType>
             *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *                       &lt;pattern value="[^\n]*"/>
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
                protected List<Factura.Detalles.Detalle.DetallesAdicionales.DetAdicional> detAdicional;

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
                 * {@link Factura.Detalles.Detalle.DetallesAdicionales.DetAdicional }
                 *
                 *
                 */
                public List<Factura.Detalles.Detalle.DetallesAdicionales.DetAdicional> getDetAdicional() {
                    if (detAdicional == null) {
                        detAdicional =
                                new ArrayList<Factura.Detalles.Detalle.DetallesAdicionales.DetAdicional>();
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
                 *             &lt;pattern value="[^\n]*"/>
                 *             &lt;minLength value="1"/>
                 *             &lt;maxLength value="300"/>
                 *           &lt;/restriction>
                 *         &lt;/simpleType>
                 *       &lt;/attribute>
                 *       &lt;attribute name="valor">
                 *         &lt;simpleType>
                 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
                 *             &lt;pattern value="[^\n]*"/>
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

                    @XmlAttribute
                    protected String nombre;
                    @XmlAttribute
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
             *         &lt;element name="impuesto" type="{}impuesto" maxOccurs="unbounded"/>
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

                @XmlElement(required = true)
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
        protected List<Factura.InfoAdicional.CampoAdicional> campoAdicional;

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
         * {@link Factura.InfoAdicional.CampoAdicional }
         *
         *
         */
        public List<Factura.InfoAdicional.CampoAdicional> getCampoAdicional() {
            if (campoAdicional == null) {
                campoAdicional =
                        new ArrayList<Factura.InfoAdicional.CampoAdicional>();
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
            @XmlAttribute
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
     *         &lt;element name="contribuyenteEspecial" type="{}contribuyenteEspecial" minOccurs="0"/>
     *         &lt;element name="obligadoContabilidad" type="{}obligadoContabilidad" minOccurs="0"/>
     *         &lt;element name="comercioExterior" type="{}comercioExterior" minOccurs="0"/>
     *         &lt;element name="incoTermFactura" type="{}incoTermFactura" minOccurs="0"/>
     *         &lt;element name="lugarIncoTerm" type="{}lugarIncoTerm" minOccurs="0"/>
     *         &lt;element name="paisOrigen" type="{}paisOrigen" minOccurs="0"/>
     *         &lt;element name="puertoEmbarque" type="{}puertoEmbarque" minOccurs="0"/>
     *         &lt;element name="puertoDestino" type="{}puertoDestino" minOccurs="0"/>
     *         &lt;element name="paisDestino" type="{}paisDestino" minOccurs="0"/>
     *         &lt;element name="paisAdquisicion" type="{}paisAdquisicion" minOccurs="0"/>
     *         &lt;element name="tipoIdentificacionComprador" type="{}tipoIdentificacionComprador"/>
     *         &lt;element name="guiaRemision" type="{}guiaRemision" minOccurs="0"/>
     *         &lt;element name="razonSocialComprador" type="{}razonSocialComprador"/>
     *         &lt;element name="identificacionComprador" type="{}identificacionComprador"/>
     *         &lt;element name="direccionComprador" type="{}direccionComprador" minOccurs="0"/>
     *         &lt;element name="totalSinImpuestos" type="{}totalSinImpuestos"/>
     *         &lt;element name="incoTermTotalSinImpuestos" type="{}incoTermTotalSinImpuestos" minOccurs="0"/>
     *         &lt;element name="totalDescuento" type="{}totalDescuentos"/>
     *         &lt;element name="codDocReembolso" type="{}codigoDocumentoReembolso" minOccurs="0"/>
     *         &lt;element name="totalComprobantesReembolso" type="{}totalComprobantesReembolso" minOccurs="0"/>
     *         &lt;element name="totalBaseImponibleReembolso" type="{}totalBaseImponibleReembolso" minOccurs="0"/>
     *         &lt;element name="totalImpuestoReembolso" type="{}totalImpuestoReembolso" minOccurs="0"/>
     *         &lt;element name="totalConImpuestos">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="totalImpuesto" maxOccurs="unbounded">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="codigo" type="{}codigo"/>
     *                             &lt;element name="codigoPorcentaje" type="{}codigoPorcentaje"/>
     *                             &lt;element name="descuentoAdicional" type="{}descuentoAdicional" minOccurs="0"/>
     *                             &lt;element name="baseImponible" type="{}baseImponible"/>
     *                             &lt;element name="tarifa" type="{}tarifa" minOccurs="0"/>
     *                             &lt;element name="valor" type="{}valor"/>
     *                             &lt;element name="valorDevolucionIva" type="{}valorDevolucionIva" minOccurs="0"/>
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
     *         &lt;element name="propina" type="{}propina"/>
     *         &lt;element name="fleteInternacional" type="{}fleteInternacional" minOccurs="0"/>
     *         &lt;element name="seguroInternacional" type="{}seguroInternacional" minOccurs="0"/>
     *         &lt;element name="gastosAduaneros" type="{}gastosAduaneros" minOccurs="0"/>
     *         &lt;element name="gastosTransporteOtros" type="{}gastosTransporteOtros" minOccurs="0"/>
     *         &lt;element name="importeTotal" type="{}importeTotal"/>
     *         &lt;element name="moneda" type="{}moneda" minOccurs="0"/>
     *         &lt;element name="pagos" type="{}pagos" minOccurs="0"/>
     *         &lt;element name="valorRetIva" type="{}valorRetIva" minOccurs="0"/>
     *         &lt;element name="valorRetRenta" type="{}valorRetRenta" minOccurs="0"/>
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
             propOrder = { "fechaEmision", "dirEstablecimiento", "contribuyenteEspecial",
                           "obligadoContabilidad", "comercioExterior",
                           "incoTermFactura", "lugarIncoTerm", "paisOrigen",
                           "puertoEmbarque", "puertoDestino", "paisDestino",
                           "paisAdquisicion", "tipoIdentificacionComprador",
                           "guiaRemision", "razonSocialComprador",
                           "identificacionComprador", "direccionComprador",
                           "totalSinImpuestos", "incoTermTotalSinImpuestos",
                           "totalDescuento", "codDocReembolso",
                           "totalComprobantesReembolso",
                           "totalBaseImponibleReembolso",
                           "totalImpuestoReembolso", "totalConImpuestos",
                           "propina", "fleteInternacional",
                           "seguroInternacional", "gastosAduaneros",
                           "gastosTransporteOtros", "importeTotal", "moneda",
                           "pagos", "valorRetIva", "valorRetRenta" })
    public static class InfoFactura {

        @XmlElement(required = true)
        protected String fechaEmision;
        protected String dirEstablecimiento;
        protected String contribuyenteEspecial;
        protected ObligadoContabilidad obligadoContabilidad;
        protected String comercioExterior;
        protected String incoTermFactura;
        protected String lugarIncoTerm;
        protected String paisOrigen;
        protected String puertoEmbarque;
        protected String puertoDestino;
        protected String paisDestino;
        protected String paisAdquisicion;
        @XmlElement(required = true)
        protected String tipoIdentificacionComprador;
        protected String guiaRemision;
        @XmlElement(required = true)
        protected String razonSocialComprador;
        @XmlElement(required = true)
        protected String identificacionComprador;
        protected String direccionComprador;
        @XmlElement(required = true)
        protected BigDecimal totalSinImpuestos;
        protected String incoTermTotalSinImpuestos;
        @XmlElement(required = true)
        protected BigDecimal totalDescuento;
        protected String codDocReembolso;
        protected BigDecimal totalComprobantesReembolso;
        protected BigDecimal totalBaseImponibleReembolso;
        protected BigDecimal totalImpuestoReembolso;
        @XmlElement(required = true)
        protected Factura.InfoFactura.TotalConImpuestos totalConImpuestos;
        @XmlElement(required = true)
        protected BigDecimal propina;
        protected BigDecimal fleteInternacional;
        protected BigDecimal seguroInternacional;
        protected BigDecimal gastosAduaneros;
        protected BigDecimal gastosTransporteOtros;
        @XmlElement(required = true)
        protected BigDecimal importeTotal;
        protected String moneda;
        protected Pagos pagos;
        protected BigDecimal valorRetIva;
        protected BigDecimal valorRetRenta;

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
         *     {@link ObligadoContabilidad }
         *
         */
        public ObligadoContabilidad getObligadoContabilidad() {
            return obligadoContabilidad;
        }

        /**
         * Sets the value of the obligadoContabilidad property.
         *
         * @param value
         *     allowed object is
         *     {@link ObligadoContabilidad }
         *
         */
        public void setObligadoContabilidad(ObligadoContabilidad value) {
            this.obligadoContabilidad = value;
        }

        /**
         * Gets the value of the comercioExterior property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getComercioExterior() {
            return comercioExterior;
        }

        /**
         * Sets the value of the comercioExterior property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setComercioExterior(String value) {
            this.comercioExterior = value;
        }

        /**
         * Gets the value of the incoTermFactura property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getIncoTermFactura() {
            return incoTermFactura;
        }

        /**
         * Sets the value of the incoTermFactura property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setIncoTermFactura(String value) {
            this.incoTermFactura = value;
        }

        /**
         * Gets the value of the lugarIncoTerm property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getLugarIncoTerm() {
            return lugarIncoTerm;
        }

        /**
         * Sets the value of the lugarIncoTerm property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setLugarIncoTerm(String value) {
            this.lugarIncoTerm = value;
        }

        /**
         * Gets the value of the paisOrigen property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getPaisOrigen() {
            return paisOrigen;
        }

        /**
         * Sets the value of the paisOrigen property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setPaisOrigen(String value) {
            this.paisOrigen = value;
        }

        /**
         * Gets the value of the puertoEmbarque property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getPuertoEmbarque() {
            return puertoEmbarque;
        }

        /**
         * Sets the value of the puertoEmbarque property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setPuertoEmbarque(String value) {
            this.puertoEmbarque = value;
        }

        /**
         * Gets the value of the puertoDestino property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getPuertoDestino() {
            return puertoDestino;
        }

        /**
         * Sets the value of the puertoDestino property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setPuertoDestino(String value) {
            this.puertoDestino = value;
        }

        /**
         * Gets the value of the paisDestino property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getPaisDestino() {
            return paisDestino;
        }

        /**
         * Sets the value of the paisDestino property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setPaisDestino(String value) {
            this.paisDestino = value;
        }

        /**
         * Gets the value of the paisAdquisicion property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getPaisAdquisicion() {
            return paisAdquisicion;
        }

        /**
         * Sets the value of the paisAdquisicion property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setPaisAdquisicion(String value) {
            this.paisAdquisicion = value;
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
         * Gets the value of the guiaRemision property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getGuiaRemision() {
            return guiaRemision;
        }

        /**
         * Sets the value of the guiaRemision property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setGuiaRemision(String value) {
            this.guiaRemision = value;
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
         * Gets the value of the direccionComprador property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getDireccionComprador() {
            return direccionComprador;
        }

        /**
         * Sets the value of the direccionComprador property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setDireccionComprador(String value) {
            this.direccionComprador = value;
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
         * Gets the value of the incoTermTotalSinImpuestos property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getIncoTermTotalSinImpuestos() {
            return incoTermTotalSinImpuestos;
        }

        /**
         * Sets the value of the incoTermTotalSinImpuestos property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setIncoTermTotalSinImpuestos(String value) {
            this.incoTermTotalSinImpuestos = value;
        }

        /**
         * Gets the value of the totalDescuento property.
         *
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *
         */
        public BigDecimal getTotalDescuento() {
            return totalDescuento;
        }

        /**
         * Sets the value of the totalDescuento property.
         *
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *
         */
        public void setTotalDescuento(BigDecimal value) {
            this.totalDescuento = value;
        }

        /**
         * Gets the value of the codDocReembolso property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getCodDocReembolso() {
            return codDocReembolso;
        }

        /**
         * Sets the value of the codDocReembolso property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setCodDocReembolso(String value) {
            this.codDocReembolso = value;
        }

        /**
         * Gets the value of the totalComprobantesReembolso property.
         *
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *
         */
        public BigDecimal getTotalComprobantesReembolso() {
            return totalComprobantesReembolso;
        }

        /**
         * Sets the value of the totalComprobantesReembolso property.
         *
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *
         */
        public void setTotalComprobantesReembolso(BigDecimal value) {
            this.totalComprobantesReembolso = value;
        }

        /**
         * Gets the value of the totalBaseImponibleReembolso property.
         *
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *
         */
        public BigDecimal getTotalBaseImponibleReembolso() {
            return totalBaseImponibleReembolso;
        }

        /**
         * Sets the value of the totalBaseImponibleReembolso property.
         *
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *
         */
        public void setTotalBaseImponibleReembolso(BigDecimal value) {
            this.totalBaseImponibleReembolso = value;
        }

        /**
         * Gets the value of the totalImpuestoReembolso property.
         *
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *
         */
        public BigDecimal getTotalImpuestoReembolso() {
            return totalImpuestoReembolso;
        }

        /**
         * Sets the value of the totalImpuestoReembolso property.
         *
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *
         */
        public void setTotalImpuestoReembolso(BigDecimal value) {
            this.totalImpuestoReembolso = value;
        }

        /**
         * Gets the value of the totalConImpuestos property.
         *
         * @return
         *     possible object is
         *     {@link Factura.InfoFactura.TotalConImpuestos }
         *
         */
        public Factura.InfoFactura.TotalConImpuestos getTotalConImpuestos() {
            return totalConImpuestos;
        }

        /**
         * Sets the value of the totalConImpuestos property.
         *
         * @param value
         *     allowed object is
         *     {@link Factura.InfoFactura.TotalConImpuestos }
         *
         */
        public void setTotalConImpuestos(Factura.InfoFactura.TotalConImpuestos value) {
            this.totalConImpuestos = value;
        }

        /**
         * Gets the value of the propina property.
         *
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *
         */
        public BigDecimal getPropina() {
            return propina;
        }

        /**
         * Sets the value of the propina property.
         *
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *
         */
        public void setPropina(BigDecimal value) {
            this.propina = value;
        }

        /**
         * Gets the value of the fleteInternacional property.
         *
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *
         */
        public BigDecimal getFleteInternacional() {
            return fleteInternacional;
        }

        /**
         * Sets the value of the fleteInternacional property.
         *
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *
         */
        public void setFleteInternacional(BigDecimal value) {
            this.fleteInternacional = value;
        }

        /**
         * Gets the value of the seguroInternacional property.
         *
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *
         */
        public BigDecimal getSeguroInternacional() {
            return seguroInternacional;
        }

        /**
         * Sets the value of the seguroInternacional property.
         *
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *
         */
        public void setSeguroInternacional(BigDecimal value) {
            this.seguroInternacional = value;
        }

        /**
         * Gets the value of the gastosAduaneros property.
         *
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *
         */
        public BigDecimal getGastosAduaneros() {
            return gastosAduaneros;
        }

        /**
         * Sets the value of the gastosAduaneros property.
         *
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *
         */
        public void setGastosAduaneros(BigDecimal value) {
            this.gastosAduaneros = value;
        }

        /**
         * Gets the value of the gastosTransporteOtros property.
         *
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *
         */
        public BigDecimal getGastosTransporteOtros() {
            return gastosTransporteOtros;
        }

        /**
         * Sets the value of the gastosTransporteOtros property.
         *
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *
         */
        public void setGastosTransporteOtros(BigDecimal value) {
            this.gastosTransporteOtros = value;
        }

        /**
         * Gets the value of the importeTotal property.
         *
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *
         */
        public BigDecimal getImporteTotal() {
            return importeTotal;
        }

        /**
         * Sets the value of the importeTotal property.
         *
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *
         */
        public void setImporteTotal(BigDecimal value) {
            this.importeTotal = value;
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
         * Gets the value of the pagos property.
         *
         * @return
         *     possible object is
         *     {@link Pagos }
         *
         */
        public Pagos getPagos() {
            return pagos;
        }

        /**
         * Sets the value of the pagos property.
         *
         * @param value
         *     allowed object is
         *     {@link Pagos }
         *
         */
        public void setPagos(Pagos value) {
            this.pagos = value;
        }

        /**
         * Gets the value of the valorRetIva property.
         *
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *
         */
        public BigDecimal getValorRetIva() {
            return valorRetIva;
        }

        /**
         * Sets the value of the valorRetIva property.
         *
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *
         */
        public void setValorRetIva(BigDecimal value) {
            this.valorRetIva = value;
        }

        /**
         * Gets the value of the valorRetRenta property.
         *
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *
         */
        public BigDecimal getValorRetRenta() {
            return valorRetRenta;
        }

        /**
         * Sets the value of the valorRetRenta property.
         *
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *
         */
        public void setValorRetRenta(BigDecimal value) {
            this.valorRetRenta = value;
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
         *         &lt;element name="totalImpuesto" maxOccurs="unbounded">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="codigo" type="{}codigo"/>
         *                   &lt;element name="codigoPorcentaje" type="{}codigoPorcentaje"/>
         *                   &lt;element name="descuentoAdicional" type="{}descuentoAdicional" minOccurs="0"/>
         *                   &lt;element name="baseImponible" type="{}baseImponible"/>
         *                   &lt;element name="tarifa" type="{}tarifa" minOccurs="0"/>
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
        @XmlType(name = "", propOrder = { "totalImpuesto" })
        public static class TotalConImpuestos {

            @XmlElement(required = true)
            protected List<Factura.InfoFactura.TotalConImpuestos.TotalImpuesto> totalImpuesto;

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
             * {@link Factura.InfoFactura.TotalConImpuestos.TotalImpuesto }
             *
             *
             */
            public List<Factura.InfoFactura.TotalConImpuestos.TotalImpuesto> getTotalImpuesto() {
                if (totalImpuesto == null) {
                    totalImpuesto =
                            new ArrayList<Factura.InfoFactura.TotalConImpuestos.TotalImpuesto>();
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
             *         &lt;element name="descuentoAdicional" type="{}descuentoAdicional" minOccurs="0"/>
             *         &lt;element name="baseImponible" type="{}baseImponible"/>
             *         &lt;element name="tarifa" type="{}tarifa" minOccurs="0"/>
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
            @XmlType(name = "",
                     propOrder = { "codigo", "codigoPorcentaje", "descuentoAdicional",
                                   "baseImponible", "tarifa", "valor",
                                   "valorDevolucionIva" })
            public static class TotalImpuesto {

                @XmlElement(required = true)
                protected String codigo;
                @XmlElement(required = true)
                protected String codigoPorcentaje;
                protected BigDecimal descuentoAdicional;
                @XmlElement(required = true)
                protected BigDecimal baseImponible;
                protected BigDecimal tarifa;
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
                 * Gets the value of the descuentoAdicional property.
                 *
                 * @return
                 *     possible object is
                 *     {@link BigDecimal }
                 *
                 */
                public BigDecimal getDescuentoAdicional() {
                    return descuentoAdicional;
                }

                /**
                 * Sets the value of the descuentoAdicional property.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link BigDecimal }
                 *
                 */
                public void setDescuentoAdicional(BigDecimal value) {
                    this.descuentoAdicional = value;
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
     *         &lt;element name="retencion" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="codigo" type="{}codigoRetencion"/>
     *                   &lt;element name="codigoPorcentaje" type="{}codigoPorcentajeRetencion"/>
     *                   &lt;element name="tarifa" type="{}tarifaRetencion"/>
     *                   &lt;element name="valor" type="{}valorRetencion"/>
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
    @XmlType(name = "", propOrder = { "retencion" })
    public static class Retenciones {

        @XmlElement(required = true)
        protected List<Factura.Retenciones.Retencion> retencion;

        /**
         * Gets the value of the retencion property.
         *
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the retencion property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getRetencion().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Factura.Retenciones.Retencion }
         *
         *
         */
        public List<Factura.Retenciones.Retencion> getRetencion() {
            if (retencion == null) {
                retencion = new ArrayList<Factura.Retenciones.Retencion>();
            }
            return this.retencion;
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
         *         &lt;element name="codigo" type="{}codigoRetencion"/>
         *         &lt;element name="codigoPorcentaje" type="{}codigoPorcentajeRetencion"/>
         *         &lt;element name="tarifa" type="{}tarifaRetencion"/>
         *         &lt;element name="valor" type="{}valorRetencion"/>
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
                 propOrder = { "codigo", "codigoPorcentaje", "tarifa",
                               "valor" })
        public static class Retencion {

            @XmlElement(required = true)
            protected String codigo;
            @XmlElement(required = true)
            protected String codigoPorcentaje;
            @XmlElement(required = true)
            protected BigDecimal tarifa;
            @XmlElement(required = true)
            protected BigDecimal valor;

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

        }

    }

}
