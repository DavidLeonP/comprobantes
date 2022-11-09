
package com.aplicaciones13.ride.notadebito;

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
 *         &lt;element name="infoNotaDebito">
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
 *                   &lt;element name="compensaciones" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="compensacion" type="{}compensacion" maxOccurs="unbounded"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="valorTotal" type="{}valorTotal"/>
 *                   &lt;element name="pagos" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="pago" type="{}pago" maxOccurs="unbounded"/>
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
 *         &lt;element name="motivos">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence maxOccurs="unbounded">
 *                   &lt;element name="motivo">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="razon" type="{}razon"/>
 *                             &lt;element name="valor" type="{}valor"/>
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
 *                         &lt;extension base="&lt;>nombre">
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
 *       &lt;attribute name="id">
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
         propOrder = { "infoTributaria", "infoNotaDebito", "motivos",
                       "infoAdicional" })
@XmlRootElement(name = "notaDebito")
public class NotaDebito {

    @XmlElement(required = true)
    protected InfoTributaria infoTributaria;
    @XmlElement(required = true)
    protected NotaDebito.InfoNotaDebito infoNotaDebito;
    @XmlElement(required = true)
    protected NotaDebito.Motivos motivos;
    protected NotaDebito.InfoAdicional infoAdicional;
    @XmlAttribute
    protected String id;
    @XmlAttribute(required = true)
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
     * Gets the value of the infoNotaDebito property.
     *
     * @return
     *     possible object is
     *     {@link NotaDebito.InfoNotaDebito }
     *
     */
    public NotaDebito.InfoNotaDebito getInfoNotaDebito() {
        return infoNotaDebito;
    }

    /**
     * Sets the value of the infoNotaDebito property.
     *
     * @param value
     *     allowed object is
     *     {@link NotaDebito.InfoNotaDebito }
     *
     */
    public void setInfoNotaDebito(NotaDebito.InfoNotaDebito value) {
        this.infoNotaDebito = value;
    }

    /**
     * Gets the value of the motivos property.
     *
     * @return
     *     possible object is
     *     {@link NotaDebito.Motivos }
     *
     */
    public NotaDebito.Motivos getMotivos() {
        return motivos;
    }

    /**
     * Sets the value of the motivos property.
     *
     * @param value
     *     allowed object is
     *     {@link NotaDebito.Motivos }
     *
     */
    public void setMotivos(NotaDebito.Motivos value) {
        this.motivos = value;
    }

    /**
     * Gets the value of the infoAdicional property.
     *
     * @return
     *     possible object is
     *     {@link NotaDebito.InfoAdicional }
     *
     */
    public NotaDebito.InfoAdicional getInfoAdicional() {
        return infoAdicional;
    }

    /**
     * Sets the value of the infoAdicional property.
     *
     * @param value
     *     allowed object is
     *     {@link NotaDebito.InfoAdicional }
     *
     */
    public void setInfoAdicional(NotaDebito.InfoAdicional value) {
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
     *         &lt;element name="campoAdicional" maxOccurs="15">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;>nombre">
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
    @XmlType(name = "", propOrder = { "campoAdicional" })
    public static class InfoAdicional {

        @XmlElement(required = true)
        protected List<NotaDebito.InfoAdicional.CampoAdicional> campoAdicional;

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
         * {@link NotaDebito.InfoAdicional.CampoAdicional }
         *
         *
         */
        public List<NotaDebito.InfoAdicional.CampoAdicional> getCampoAdicional() {
            if (campoAdicional == null) {
                campoAdicional =
                        new ArrayList<NotaDebito.InfoAdicional.CampoAdicional>();
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
         *     &lt;extension base="&lt;>nombre">
         *       &lt;attribute name="nombre" use="required" type="{}nombre" />
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
            @XmlAttribute(required = true)
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
     *         &lt;element name="compensaciones" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="compensacion" type="{}compensacion" maxOccurs="unbounded"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="valorTotal" type="{}valorTotal"/>
     *         &lt;element name="pagos" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="pago" type="{}pago" maxOccurs="unbounded"/>
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
             propOrder = { "fechaEmision", "dirEstablecimiento", "tipoIdentificacionComprador",
                           "razonSocialComprador", "identificacionComprador",
                           "contribuyenteEspecial", "obligadoContabilidad",
                           "rise", "codDocModificado", "numDocModificado",
                           "fechaEmisionDocSustento", "totalSinImpuestos",
                           "impuestos", "compensaciones", "valorTotal",
                           "pagos" })
    public static class InfoNotaDebito {

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
        protected ObligadoContabilidad obligadoContabilidad;
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
        protected NotaDebito.InfoNotaDebito.Impuestos impuestos;
        protected NotaDebito.InfoNotaDebito.Compensaciones compensaciones;
        @XmlElement(required = true)
        protected BigDecimal valorTotal;
        protected List<NotaDebito.InfoNotaDebito.Pagos> pagos;

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
         * Gets the value of the impuestos property.
         *
         * @return
         *     possible object is
         *     {@link NotaDebito.InfoNotaDebito.Impuestos }
         *
         */
        public NotaDebito.InfoNotaDebito.Impuestos getImpuestos() {
            return impuestos;
        }

        /**
         * Sets the value of the impuestos property.
         *
         * @param value
         *     allowed object is
         *     {@link NotaDebito.InfoNotaDebito.Impuestos }
         *
         */
        public void setImpuestos(NotaDebito.InfoNotaDebito.Impuestos value) {
            this.impuestos = value;
        }

        /**
         * Gets the value of the compensaciones property.
         *
         * @return
         *     possible object is
         *     {@link NotaDebito.InfoNotaDebito.Compensaciones }
         *
         */
        public NotaDebito.InfoNotaDebito.Compensaciones getCompensaciones() {
            return compensaciones;
        }

        /**
         * Sets the value of the compensaciones property.
         *
         * @param value
         *     allowed object is
         *     {@link NotaDebito.InfoNotaDebito.Compensaciones }
         *
         */
        public void setCompensaciones(NotaDebito.InfoNotaDebito.Compensaciones value) {
            this.compensaciones = value;
        }

        /**
         * Gets the value of the valorTotal property.
         *
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *
         */
        public BigDecimal getValorTotal() {
            return valorTotal;
        }

        /**
         * Sets the value of the valorTotal property.
         *
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *
         */
        public void setValorTotal(BigDecimal value) {
            this.valorTotal = value;
        }

        /**
         * Gets the value of the pagos property.
         *
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the pagos property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPagos().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link NotaDebito.InfoNotaDebito.Pagos }
         *
         *
         */
        public List<NotaDebito.InfoNotaDebito.Pagos> getPagos() {
            if (pagos == null) {
                pagos = new ArrayList<NotaDebito.InfoNotaDebito.Pagos>();
            }
            return this.pagos;
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
         *         &lt;element name="compensacion" type="{}compensacion" maxOccurs="unbounded"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         *
         *
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = { "compensacion" })
        public static class Compensaciones {

            @XmlElement(required = true)
            protected List<Compensacion> compensacion;

            /**
             * Gets the value of the compensacion property.
             *
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the compensacion property.
             *
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getCompensacion().add(newItem);
             * </pre>
             *
             *
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Compensacion }
             *
             *
             */
            public List<Compensacion> getCompensacion() {
                if (compensacion == null) {
                    compensacion = new ArrayList<Compensacion>();
                }
                return this.compensacion;
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
         *         &lt;element name="pago" type="{}pago" maxOccurs="unbounded"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         *
         *
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = { "pago" })
        public static class Pagos {

            @XmlElement(required = true)
            protected List<Pago> pago;

            /**
             * Gets the value of the pago property.
             *
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the pago property.
             *
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getPago().add(newItem);
             * </pre>
             *
             *
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Pago }
             *
             *
             */
            public List<Pago> getPago() {
                if (pago == null) {
                    pago = new ArrayList<Pago>();
                }
                return this.pago;
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
     *       &lt;sequence maxOccurs="unbounded">
     *         &lt;element name="motivo">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="razon" type="{}razon"/>
     *                   &lt;element name="valor" type="{}valor"/>
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
    @XmlType(name = "", propOrder = { "motivo" })
    public static class Motivos {

        @XmlElement(required = true)
        protected List<NotaDebito.Motivos.Motivo> motivo;

        /**
         * Gets the value of the motivo property.
         *
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the motivo property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMotivo().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link NotaDebito.Motivos.Motivo }
         *
         *
         */
        public List<NotaDebito.Motivos.Motivo> getMotivo() {
            if (motivo == null) {
                motivo = new ArrayList<NotaDebito.Motivos.Motivo>();
            }
            return this.motivo;
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
         *         &lt;element name="razon" type="{}razon"/>
         *         &lt;element name="valor" type="{}valor"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         *
         *
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = { "razon", "valor" })
        public static class Motivo {

            @XmlElement(required = true)
            protected String razon;
            @XmlElement(required = true)
            protected BigDecimal valor;

            /**
             * Gets the value of the razon property.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getRazon() {
                return razon;
            }

            /**
             * Sets the value of the razon property.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setRazon(String value) {
                this.razon = value;
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
