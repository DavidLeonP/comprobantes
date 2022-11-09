
package com.aplicaciones13.ride.notadebito;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Contiene la informacion tributaria generica
 *
 * <p>Java class for infoTributaria complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="infoTributaria">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ambiente" type="{}ambiente"/>
 *         &lt;element name="tipoEmision" type="{}tipoEmision"/>
 *         &lt;element name="razonSocial" type="{}razonSocial"/>
 *         &lt;element name="nombreComercial" type="{}nombreComercial" minOccurs="0"/>
 *         &lt;element name="ruc" type="{}numeroRuc"/>
 *         &lt;element name="claveAcceso" type="{}claveAcceso"/>
 *         &lt;element name="codDoc" type="{}codDoc"/>
 *         &lt;element name="estab" type="{}establecimiento"/>
 *         &lt;element name="ptoEmi" type="{}puntoEmision"/>
 *         &lt;element name="secuencial" type="{}secuencial"/>
 *         &lt;element name="dirMatriz" type="{}dirMatriz"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "infoTributaria",
         propOrder = { "ambiente", "tipoEmision", "razonSocial",
                       "nombreComercial", "ruc", "claveAcceso", "codDoc",
                       "estab", "ptoEmi", "secuencial", "dirMatriz" })
public class InfoTributaria {

    @XmlElement(required = true)
    protected String ambiente;
    @XmlElement(required = true)
    protected String tipoEmision;
    @XmlElement(required = true)
    protected String razonSocial;
    protected String nombreComercial;
    @XmlElement(required = true)
    protected String ruc;
    @XmlElement(required = true)
    protected String claveAcceso;
    @XmlElement(required = true)
    protected String codDoc;
    @XmlElement(required = true)
    protected String estab;
    @XmlElement(required = true)
    protected String ptoEmi;
    @XmlElement(required = true)
    protected String secuencial;
    @XmlElement(required = true)
    protected String dirMatriz;

    /**
     * Gets the value of the ambiente property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAmbiente() {
        return ambiente;
    }

    /**
     * Sets the value of the ambiente property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAmbiente(String value) {
        this.ambiente = value;
    }

    /**
     * Gets the value of the tipoEmision property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getTipoEmision() {
        return tipoEmision;
    }

    /**
     * Sets the value of the tipoEmision property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTipoEmision(String value) {
        this.tipoEmision = value;
    }

    /**
     * Gets the value of the razonSocial property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getRazonSocial() {
        return razonSocial;
    }

    /**
     * Sets the value of the razonSocial property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setRazonSocial(String value) {
        this.razonSocial = value;
    }

    /**
     * Gets the value of the nombreComercial property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getNombreComercial() {
        return nombreComercial;
    }

    /**
     * Sets the value of the nombreComercial property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setNombreComercial(String value) {
        this.nombreComercial = value;
    }

    /**
     * Gets the value of the ruc property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getRuc() {
        return ruc;
    }

    /**
     * Sets the value of the ruc property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setRuc(String value) {
        this.ruc = value;
    }

    /**
     * Gets the value of the claveAcceso property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getClaveAcceso() {
        return claveAcceso;
    }

    /**
     * Sets the value of the claveAcceso property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setClaveAcceso(String value) {
        this.claveAcceso = value;
    }

    /**
     * Gets the value of the codDoc property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCodDoc() {
        return codDoc;
    }

    /**
     * Sets the value of the codDoc property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCodDoc(String value) {
        this.codDoc = value;
    }

    /**
     * Gets the value of the estab property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getEstab() {
        return estab;
    }

    /**
     * Sets the value of the estab property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setEstab(String value) {
        this.estab = value;
    }

    /**
     * Gets the value of the ptoEmi property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getPtoEmi() {
        return ptoEmi;
    }

    /**
     * Sets the value of the ptoEmi property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setPtoEmi(String value) {
        this.ptoEmi = value;
    }

    /**
     * Gets the value of the secuencial property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSecuencial() {
        return secuencial;
    }

    /**
     * Sets the value of the secuencial property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSecuencial(String value) {
        this.secuencial = value;
    }

    /**
     * Gets the value of the dirMatriz property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDirMatriz() {
        return dirMatriz;
    }

    /**
     * Sets the value of the dirMatriz property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDirMatriz(String value) {
        this.dirMatriz = value;
    }

}
