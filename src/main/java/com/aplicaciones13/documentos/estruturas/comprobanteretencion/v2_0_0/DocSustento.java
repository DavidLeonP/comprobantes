//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.04.07 at 09:34:27 p. m. ECT 
//


package com.aplicaciones13.documentos.estruturas.comprobanteretencion.v2_0_0;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Informacion de los documentos que originan la retenciones.
 * 
 * <p>Java class for docSustento complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="docSustento">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codSustento" type="{}codSustento"/>
 *         &lt;element name="codDocSustento" type="{}codDocSustento"/>
 *         &lt;element name="numDocSustento" type="{}numDocSustento"/>
 *         &lt;element name="fechaEmisionDocSustento" type="{}fecha"/>
 *         &lt;element name="fechaRegistroContable" type="{}fecha" minOccurs="0"/>
 *         &lt;element name="numAutDocSustento" type="{}numAutDocSustento" minOccurs="0"/>
 *         &lt;element name="pagoLocExt" type="{}pagoLocExt"/>
 *         &lt;element name="tipoRegi" type="{}tipoRegi" minOccurs="0"/>
 *         &lt;element name="paisEfecPago" type="{}paisEfecPago" minOccurs="0"/>
 *         &lt;element name="aplicConvDobTrib" type="{}afirmacion" minOccurs="0"/>
 *         &lt;element name="pagExtSujRetNorLeg" type="{}afirmacion" minOccurs="0"/>
 *         &lt;element name="pagoRegFis" type="{}afirmacion" minOccurs="0"/>
 *         &lt;element name="totalComprobantesReembolso" type="{}totalComprobantesReembolso" minOccurs="0"/>
 *         &lt;element name="totalBaseImponibleReembolso" type="{}totalBaseImponibleReembolso" minOccurs="0"/>
 *         &lt;element name="totalImpuestoReembolso" type="{}totalImpuestoReembolso" minOccurs="0"/>
 *         &lt;element name="totalSinImpuestos" type="{}totalSinImpuestos"/>
 *         &lt;element name="importeTotal" type="{}importeTotal"/>
 *         &lt;element name="impuestosDocSustento" type="{}impuestosDocSustento"/>
 *         &lt;element name="retenciones" type="{}retenciones"/>
 *         &lt;element name="reembolsos" type="{}reembolsos" minOccurs="0"/>
 *         &lt;element name="pagos" type="{}pagos"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "docSustento", propOrder = {
    "codSustento",
    "codDocSustento",
    "numDocSustento",
    "fechaEmisionDocSustento",
    "fechaRegistroContable",
    "numAutDocSustento",
    "pagoLocExt",
    "tipoRegi",
    "paisEfecPago",
    "aplicConvDobTrib",
    "pagExtSujRetNorLeg",
    "pagoRegFis",
    "totalComprobantesReembolso",
    "totalBaseImponibleReembolso",
    "totalImpuestoReembolso",
    "totalSinImpuestos",
    "importeTotal",
    "impuestosDocSustento",
    "retenciones",
    "reembolsos",
    "pagos"
})
public class DocSustento {

    @XmlElement(required = true)
    protected String codSustento;
    @XmlElement(required = true)
    protected String codDocSustento;
    @XmlElement(required = true)
    protected String numDocSustento;
    @XmlElement(required = true)
    protected String fechaEmisionDocSustento;
    protected String fechaRegistroContable;
    protected String numAutDocSustento;
    @XmlElement(required = true)
    protected String pagoLocExt;
    protected String tipoRegi;
    protected String paisEfecPago;
    protected String aplicConvDobTrib;
    protected String pagExtSujRetNorLeg;
    protected String pagoRegFis;
    protected BigDecimal totalComprobantesReembolso;
    protected BigDecimal totalBaseImponibleReembolso;
    protected BigDecimal totalImpuestoReembolso;
    @XmlElement(required = true)
    protected BigDecimal totalSinImpuestos;
    @XmlElement(required = true)
    protected BigDecimal importeTotal;
    @XmlElement(required = true)
    protected ImpuestosDocSustento impuestosDocSustento;
    @XmlElement(required = true)
    protected Retenciones retenciones;
    protected Reembolsos reembolsos;
    @XmlElement(required = true)
    protected Pagos pagos;

    /**
     * Gets the value of the codSustento property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodSustento() {
        return codSustento;
    }

    /**
     * Sets the value of the codSustento property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodSustento(String value) {
        this.codSustento = value;
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

    /**
     * Gets the value of the fechaRegistroContable property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaRegistroContable() {
        return fechaRegistroContable;
    }

    /**
     * Sets the value of the fechaRegistroContable property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaRegistroContable(String value) {
        this.fechaRegistroContable = value;
    }

    /**
     * Gets the value of the numAutDocSustento property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumAutDocSustento() {
        return numAutDocSustento;
    }

    /**
     * Sets the value of the numAutDocSustento property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumAutDocSustento(String value) {
        this.numAutDocSustento = value;
    }

    /**
     * Gets the value of the pagoLocExt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPagoLocExt() {
        return pagoLocExt;
    }

    /**
     * Sets the value of the pagoLocExt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPagoLocExt(String value) {
        this.pagoLocExt = value;
    }

    /**
     * Gets the value of the tipoRegi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoRegi() {
        return tipoRegi;
    }

    /**
     * Sets the value of the tipoRegi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoRegi(String value) {
        this.tipoRegi = value;
    }

    /**
     * Gets the value of the paisEfecPago property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaisEfecPago() {
        return paisEfecPago;
    }

    /**
     * Sets the value of the paisEfecPago property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaisEfecPago(String value) {
        this.paisEfecPago = value;
    }

    /**
     * Gets the value of the aplicConvDobTrib property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAplicConvDobTrib() {
        return aplicConvDobTrib;
    }

    /**
     * Sets the value of the aplicConvDobTrib property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAplicConvDobTrib(String value) {
        this.aplicConvDobTrib = value;
    }

    /**
     * Gets the value of the pagExtSujRetNorLeg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPagExtSujRetNorLeg() {
        return pagExtSujRetNorLeg;
    }

    /**
     * Sets the value of the pagExtSujRetNorLeg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPagExtSujRetNorLeg(String value) {
        this.pagExtSujRetNorLeg = value;
    }

    /**
     * Gets the value of the pagoRegFis property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPagoRegFis() {
        return pagoRegFis;
    }

    /**
     * Sets the value of the pagoRegFis property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPagoRegFis(String value) {
        this.pagoRegFis = value;
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
     * Gets the value of the impuestosDocSustento property.
     * 
     * @return
     *     possible object is
     *     {@link ImpuestosDocSustento }
     *     
     */
    public ImpuestosDocSustento getImpuestosDocSustento() {
        return impuestosDocSustento;
    }

    /**
     * Sets the value of the impuestosDocSustento property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImpuestosDocSustento }
     *     
     */
    public void setImpuestosDocSustento(ImpuestosDocSustento value) {
        this.impuestosDocSustento = value;
    }

    /**
     * Gets the value of the retenciones property.
     * 
     * @return
     *     possible object is
     *     {@link Retenciones }
     *     
     */
    public Retenciones getRetenciones() {
        return retenciones;
    }

    /**
     * Sets the value of the retenciones property.
     * 
     * @param value
     *     allowed object is
     *     {@link Retenciones }
     *     
     */
    public void setRetenciones(Retenciones value) {
        this.retenciones = value;
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

}
