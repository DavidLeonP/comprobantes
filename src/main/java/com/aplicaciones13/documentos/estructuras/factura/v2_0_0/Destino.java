//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.04.25 at 09:04:24 p. m. ECT 
//


package com.aplicaciones13.documentos.estructuras.factura.v2_0_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Contiene la informacion del destinatario
 * 
 * <p>Java class for destino complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="destino">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="motivoTraslado" type="{}motivoTraslado"/>
 *         &lt;element name="docAduaneroUnico" type="{}docAduaneroUnico" minOccurs="0"/>
 *         &lt;element name="codEstabDestino" type="{}establecimiento" minOccurs="0"/>
 *         &lt;element name="ruta" type="{}ruta" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "destino", propOrder = {
    "motivoTraslado",
    "docAduaneroUnico",
    "codEstabDestino",
    "ruta"
})
public class Destino {

    @XmlElement(required = true)
    protected String motivoTraslado;
    protected String docAduaneroUnico;
    protected String codEstabDestino;
    protected String ruta;

    /**
     * Gets the value of the motivoTraslado property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMotivoTraslado() {
        return motivoTraslado;
    }

    /**
     * Sets the value of the motivoTraslado property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMotivoTraslado(String value) {
        this.motivoTraslado = value;
    }

    /**
     * Gets the value of the docAduaneroUnico property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocAduaneroUnico() {
        return docAduaneroUnico;
    }

    /**
     * Sets the value of the docAduaneroUnico property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocAduaneroUnico(String value) {
        this.docAduaneroUnico = value;
    }

    /**
     * Gets the value of the codEstabDestino property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodEstabDestino() {
        return codEstabDestino;
    }

    /**
     * Sets the value of the codEstabDestino property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodEstabDestino(String value) {
        this.codEstabDestino = value;
    }

    /**
     * Gets the value of the ruta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRuta() {
        return ruta;
    }

    /**
     * Sets the value of the ruta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRuta(String value) {
        this.ruta = value;
    }

}
