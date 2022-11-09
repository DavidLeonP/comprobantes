
package com.aplicaciones13.ride.comprobanteretencion;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Impuesto de un comprobante de retencion.  Contiene los elementos de cada fila del comprobante.
 *
 * <p>Java class for impuesto complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="impuesto">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codigo" type="{}codigo"/>
 *         &lt;element name="codigoRetencion" type="{}codigoRetencion"/>
 *         &lt;element name="baseImponible" type="{}baseImponible"/>
 *         &lt;element name="porcentajeRetener" type="{}porcentajeRetener"/>
 *         &lt;element name="valorRetenido" type="{}valorRetenido"/>
 *         &lt;element name="codDocSustento" type="{}codDocSustento"/>
 *         &lt;element name="numDocSustento" type="{}numDocSustento" minOccurs="0"/>
 *         &lt;element name="fechaEmisionDocSustento" type="{}fechaEmisionDocSustento" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "impuesto",
         propOrder = { "codigo", "codigoRetencion", "baseImponible",
                       "porcentajeRetener", "valorRetenido", "codDocSustento",
                       "numDocSustento", "fechaEmisionDocSustento" })
public class Impuesto {

    @XmlElement(required = true)
    protected String codigo;
    @XmlElement(required = true)
    protected String codigoRetencion;
    @XmlElement(required = true)
    protected BigDecimal baseImponible;
    @XmlElement(required = true)
    protected BigDecimal porcentajeRetener;
    @XmlElement(required = true)
    protected BigDecimal valorRetenido;
    @XmlElement(required = true)
    protected String codDocSustento;
    protected String numDocSustento;
    protected String fechaEmisionDocSustento;

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
     * Gets the value of the codigoRetencion property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCodigoRetencion() {
        return codigoRetencion;
    }

    /**
     * Sets the value of the codigoRetencion property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCodigoRetencion(String value) {
        this.codigoRetencion = value;
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
     * Gets the value of the porcentajeRetener property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getPorcentajeRetener() {
        return porcentajeRetener;
    }

    /**
     * Sets the value of the porcentajeRetener property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setPorcentajeRetener(BigDecimal value) {
        this.porcentajeRetener = value;
    }

    /**
     * Gets the value of the valorRetenido property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getValorRetenido() {
        return valorRetenido;
    }

    /**
     * Sets the value of the valorRetenido property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setValorRetenido(BigDecimal value) {
        this.valorRetenido = value;
    }

    /**
     * Gets the value of the codDocSustento property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCodDocSustento() {
        return codDocSustento;
    }

    /**
     * Sets the value of the codDocSustento property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCodDocSustento(String value) {
        this.codDocSustento = value;
    }

    /**
     * Gets the value of the numDocSustento property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getNumDocSustento() {
        return numDocSustento;
    }

    /**
     * Sets the value of the numDocSustento property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setNumDocSustento(String value) {
        this.numDocSustento = value;
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

}
