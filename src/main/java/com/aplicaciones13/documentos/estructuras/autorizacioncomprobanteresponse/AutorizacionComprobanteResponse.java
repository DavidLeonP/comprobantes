//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.04.28 at 10:44:45 a. m. ECT 
//


package com.aplicaciones13.documentos.estructuras.autorizacioncomprobanteresponse;

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
 *         &lt;element ref="{}RespuestaAutorizacionComprobante"/>
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
    "respuestaAutorizacionComprobante"
})
@XmlRootElement(name = "autorizacionComprobanteResponse")
public class AutorizacionComprobanteResponse {

    @XmlElement(name = "RespuestaAutorizacionComprobante", required = true)
    protected RespuestaAutorizacionComprobante respuestaAutorizacionComprobante;

    /**
     * Gets the value of the respuestaAutorizacionComprobante property.
     * 
     * @return
     *     possible object is
     *     {@link RespuestaAutorizacionComprobante }
     *     
     */
    public RespuestaAutorizacionComprobante getRespuestaAutorizacionComprobante() {
        return respuestaAutorizacionComprobante;
    }

    /**
     * Sets the value of the respuestaAutorizacionComprobante property.
     * 
     * @param value
     *     allowed object is
     *     {@link RespuestaAutorizacionComprobante }
     *     
     */
    public void setRespuestaAutorizacionComprobante(RespuestaAutorizacionComprobante value) {
        this.respuestaAutorizacionComprobante = value;
    }

}
