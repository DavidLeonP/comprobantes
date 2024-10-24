//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.04.28 at 10:44:46 a. m. ECT 
//


package com.aplicaciones13.documentos.estructuras.guiaremision.v1_0_0;

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
 *         &lt;element name="infoGuiaRemision">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="dirEstablecimiento" type="{}dirEstablecimiento" minOccurs="0"/>
 *                   &lt;element name="dirPartida" type="{}dirPartida"/>
 *                   &lt;element name="razonSocialTransportista" type="{}razonSocialTransportista"/>
 *                   &lt;element name="tipoIdentificacionTransportista" type="{}tipoIdentificacionTransportista"/>
 *                   &lt;element name="rucTransportista" type="{}rucTranportista"/>
 *                   &lt;element name="rise" type="{}rise" minOccurs="0"/>
 *                   &lt;element name="obligadoContabilidad" type="{}obligadoContabilidad" minOccurs="0"/>
 *                   &lt;element name="contribuyenteEspecial" type="{}contribuyenteEspecial" minOccurs="0"/>
 *                   &lt;element name="fechaIniTransporte" type="{}fechaIniTRansporte"/>
 *                   &lt;element name="fechaFinTransporte" type="{}fechaFinTransporte"/>
 *                   &lt;element name="placa" type="{}placa"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="destinatarios">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence maxOccurs="unbounded">
 *                   &lt;element name="destinatario" type="{}destinatario"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="maquinaFiscal" type="{}maquinaFiscal" minOccurs="0"/>
 *         &lt;element name="infoAdicional" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="campoAdicional" maxOccurs="15">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;>campoAdicional">
 *                           &lt;attribute name="nombre" use="required" type="{}nombre" />
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
@XmlType(name = "", propOrder = {
    "infoTributaria",
    "infoGuiaRemision",
    "destinatarios",
    "maquinaFiscal",
    "infoAdicional"
})
@XmlRootElement(name = "guiaRemision")
public class GuiaRemision {

    @XmlElement(required = true)
    protected InfoTributaria infoTributaria;
    @XmlElement(required = true)
    protected GuiaRemision.InfoGuiaRemision infoGuiaRemision;
    @XmlElement(required = true)
    protected GuiaRemision.Destinatarios destinatarios;
    protected MaquinaFiscal maquinaFiscal;
    protected GuiaRemision.InfoAdicional infoAdicional;
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
     * Gets the value of the infoGuiaRemision property.
     * 
     * @return
     *     possible object is
     *     {@link GuiaRemision.InfoGuiaRemision }
     *     
     */
    public GuiaRemision.InfoGuiaRemision getInfoGuiaRemision() {
        return infoGuiaRemision;
    }

    /**
     * Sets the value of the infoGuiaRemision property.
     * 
     * @param value
     *     allowed object is
     *     {@link GuiaRemision.InfoGuiaRemision }
     *     
     */
    public void setInfoGuiaRemision(GuiaRemision.InfoGuiaRemision value) {
        this.infoGuiaRemision = value;
    }

    /**
     * Gets the value of the destinatarios property.
     * 
     * @return
     *     possible object is
     *     {@link GuiaRemision.Destinatarios }
     *     
     */
    public GuiaRemision.Destinatarios getDestinatarios() {
        return destinatarios;
    }

    /**
     * Sets the value of the destinatarios property.
     * 
     * @param value
     *     allowed object is
     *     {@link GuiaRemision.Destinatarios }
     *     
     */
    public void setDestinatarios(GuiaRemision.Destinatarios value) {
        this.destinatarios = value;
    }

    /**
     * Gets the value of the maquinaFiscal property.
     * 
     * @return
     *     possible object is
     *     {@link MaquinaFiscal }
     *     
     */
    public MaquinaFiscal getMaquinaFiscal() {
        return maquinaFiscal;
    }

    /**
     * Sets the value of the maquinaFiscal property.
     * 
     * @param value
     *     allowed object is
     *     {@link MaquinaFiscal }
     *     
     */
    public void setMaquinaFiscal(MaquinaFiscal value) {
        this.maquinaFiscal = value;
    }

    /**
     * Gets the value of the infoAdicional property.
     * 
     * @return
     *     possible object is
     *     {@link GuiaRemision.InfoAdicional }
     *     
     */
    public GuiaRemision.InfoAdicional getInfoAdicional() {
        return infoAdicional;
    }

    /**
     * Sets the value of the infoAdicional property.
     * 
     * @param value
     *     allowed object is
     *     {@link GuiaRemision.InfoAdicional }
     *     
     */
    public void setInfoAdicional(GuiaRemision.InfoAdicional value) {
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
     *       &lt;sequence maxOccurs="unbounded">
     *         &lt;element name="destinatario" type="{}destinatario"/>
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
        "destinatario"
    })
    public static class Destinatarios {

        @XmlElement(required = true)
        protected List<Destinatario> destinatario;

        /**
         * Gets the value of the destinatario property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the destinatario property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDestinatario().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Destinatario }
         * 
         * 
         */
        public List<Destinatario> getDestinatario() {
            if (destinatario == null) {
                destinatario = new ArrayList<Destinatario>();
            }
            return this.destinatario;
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
     *                 &lt;attribute name="nombre" use="required" type="{}nombre" />
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
    @XmlType(name = "", propOrder = {
        "campoAdicional"
    })
    public static class InfoAdicional {

        @XmlElement(required = true)
        protected List<GuiaRemision.InfoAdicional.CampoAdicional> campoAdicional;

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
         * {@link GuiaRemision.InfoAdicional.CampoAdicional }
         * 
         * 
         */
        public List<GuiaRemision.InfoAdicional.CampoAdicional> getCampoAdicional() {
            if (campoAdicional == null) {
                campoAdicional = new ArrayList<GuiaRemision.InfoAdicional.CampoAdicional>();
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
         *       &lt;attribute name="nombre" use="required" type="{}nombre" />
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class CampoAdicional {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "nombre", required = true)
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
     *         &lt;element name="dirEstablecimiento" type="{}dirEstablecimiento" minOccurs="0"/>
     *         &lt;element name="dirPartida" type="{}dirPartida"/>
     *         &lt;element name="razonSocialTransportista" type="{}razonSocialTransportista"/>
     *         &lt;element name="tipoIdentificacionTransportista" type="{}tipoIdentificacionTransportista"/>
     *         &lt;element name="rucTransportista" type="{}rucTranportista"/>
     *         &lt;element name="rise" type="{}rise" minOccurs="0"/>
     *         &lt;element name="obligadoContabilidad" type="{}obligadoContabilidad" minOccurs="0"/>
     *         &lt;element name="contribuyenteEspecial" type="{}contribuyenteEspecial" minOccurs="0"/>
     *         &lt;element name="fechaIniTransporte" type="{}fechaIniTRansporte"/>
     *         &lt;element name="fechaFinTransporte" type="{}fechaFinTransporte"/>
     *         &lt;element name="placa" type="{}placa"/>
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
        "dirEstablecimiento",
        "dirPartida",
        "razonSocialTransportista",
        "tipoIdentificacionTransportista",
        "rucTransportista",
        "rise",
        "obligadoContabilidad",
        "contribuyenteEspecial",
        "fechaIniTransporte",
        "fechaFinTransporte",
        "placa"
    })
    public static class InfoGuiaRemision {

        protected String dirEstablecimiento;
        @XmlElement(required = true)
        protected String dirPartida;
        @XmlElement(required = true)
        protected String razonSocialTransportista;
        @XmlElement(required = true)
        protected String tipoIdentificacionTransportista;
        @XmlElement(required = true)
        protected String rucTransportista;
        protected String rise;
        protected ObligadoContabilidad obligadoContabilidad;
        protected String contribuyenteEspecial;
        @XmlElement(required = true)
        protected String fechaIniTransporte;
        @XmlElement(required = true)
        protected String fechaFinTransporte;
        @XmlElement(required = true)
        protected String placa;

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
         * Gets the value of the dirPartida property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDirPartida() {
            return dirPartida;
        }

        /**
         * Sets the value of the dirPartida property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDirPartida(String value) {
            this.dirPartida = value;
        }

        /**
         * Gets the value of the razonSocialTransportista property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRazonSocialTransportista() {
            return razonSocialTransportista;
        }

        /**
         * Sets the value of the razonSocialTransportista property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRazonSocialTransportista(String value) {
            this.razonSocialTransportista = value;
        }

        /**
         * Gets the value of the tipoIdentificacionTransportista property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTipoIdentificacionTransportista() {
            return tipoIdentificacionTransportista;
        }

        /**
         * Sets the value of the tipoIdentificacionTransportista property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTipoIdentificacionTransportista(String value) {
            this.tipoIdentificacionTransportista = value;
        }

        /**
         * Gets the value of the rucTransportista property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRucTransportista() {
            return rucTransportista;
        }

        /**
         * Sets the value of the rucTransportista property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRucTransportista(String value) {
            this.rucTransportista = value;
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
         * Gets the value of the fechaIniTransporte property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFechaIniTransporte() {
            return fechaIniTransporte;
        }

        /**
         * Sets the value of the fechaIniTransporte property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFechaIniTransporte(String value) {
            this.fechaIniTransporte = value;
        }

        /**
         * Gets the value of the fechaFinTransporte property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFechaFinTransporte() {
            return fechaFinTransporte;
        }

        /**
         * Sets the value of the fechaFinTransporte property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFechaFinTransporte(String value) {
            this.fechaFinTransporte = value;
        }

        /**
         * Gets the value of the placa property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPlaca() {
            return placa;
        }

        /**
         * Sets the value of the placa property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPlaca(String value) {
            this.placa = value;
        }

    }

}
