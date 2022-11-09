package com.aplicaciones13.utilidades;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


/** Objeto para conocer el documento que se esta subiendo y desmenbrar parte de sus datos
 *
 */
public class IdentificarDocumento {
    public IdentificarDocumento() {
        super();
    }


    private int codigoTipoDocumento;
    private String nombreTipoDocumento;
    private String identicacion;
    private String tipoIdentificacion;
    private String secuencia;
    private String claveAcesso;
    private String correo;
    private String identificacionCliente;
    private String direccionCliente;
    private String correoCliente;
    private String telefonoCliente;
    private String nombreCliente;
    private String nombreEmpresa;
    private String valor;
    private boolean XMLValido = true;

    private List<String> identidadesGuia;

    private Autorizacion autorizacionOk;
    private Document documento;

    /**Contructor para donde inicializa las variables.
     *
     * @param direccion
     */

    public IdentificarDocumento(String direccion) {
        setIdenticacion("");
        setIdentificacionCliente("");
        setClaveAcesso("");
        setCodigoTipoDocumento(0);
        setCorreo("");
        setCorreoCliente("");
        setDireccionCliente("");
        setNombreCliente("");
        setSecuencia("");
        setTelefonoCliente("");
        setTipoIdentificacion("");
        setValor("");
        setNombreTipoDocumento("");
        setNombreEmpresa("");

        setAutorizacionOk(new Autorizacion());
        setIdentidadesGuia(new ArrayList<String>());
        documento = parseXmlFile(direccion);
    }

    /** Metodo que permite cargar un Document a partir de un archivo xml.
     *
     * @param direccion
     *
     */
    private Document parseXmlFile(String direccion) {
        XMLValido = false;
        try {
            File fXmlFile = new File(direccion);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document documentoTemporal = dBuilder.parse(fXmlFile);

            XMLValido = true;
            return documentoTemporal;
        } catch (Exception e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, e.toString());
            MainFiles.escribirLogDefault(this.getClass().getName() + ".parseXmlFile() " + e.toString());
            XMLValido = false;
        }
        return null;
    }

    /** Metodo que permite cargar un Document a partir de un archivo xml.
     *
     * @param direccion
     *
     */
    private Document parseXmlString(String texto) {
        texto = texto.replaceAll("&lt;", "<")
                     .replaceAll("&gt;", ">")
                     .replaceAll("\"", "'")
                     .replaceAll("UTF-8", "ISO-8859-1")
                     .replaceAll("utf-8", "ISO-8859-1");
        XMLValido = false;
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            InputStream stream = new ByteArrayInputStream(texto.trim().getBytes());
            Document documentoTemporal = dBuilder.parse(stream);

            XMLValido = true;
            return documentoTemporal;
        } catch (Exception e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, e.toString());
            MainFiles.escribirLogDefault(this.getClass().getName() + ".parseXmlString() " + e.toString());
            XMLValido = false;
        }
        return null;
    }

    /**Metodo que permite extrer informacion del archivo xml.
     *
     * @return
     */
    public String descuartizaXMLOriginal() {
        if (!isXMLValido())
            return "XML invalido";

        String tipoDocumento = documento.getDocumentElement().getNodeName();
        getInfoTributaria();
        if (tipoDocumento.equalsIgnoreCase("factura")) {
            informacionComprador("infoFactura");
            valorDocumento("infoFactura", "importeTotal");
            setCodigoTipoDocumento(1);
            setNombreTipoDocumento("Factura");
        }
        if (tipoDocumento.equalsIgnoreCase("notaDebito")) {
            informacionComprador("infoNotaDebito");
            valorDocumento("infoNotaDebito", "valorTotal");
            setCodigoTipoDocumento(2);
            setNombreTipoDocumento("Nota de Débito");
        }
        if (tipoDocumento.equalsIgnoreCase("notaCredito")) {
            informacionComprador("infoNotaCredito");
            valorDocumento("infoNotaCredito", "valorModificacion");
            setCodigoTipoDocumento(3);
            setNombreTipoDocumento("Nota de Crédito");
        }
        if (tipoDocumento.equalsIgnoreCase("comprobanteRetencion")) {
            infoCompRetencion();
            valorDocumento("impuesto", "valorRetenido");
            setCodigoTipoDocumento(5);
            setNombreTipoDocumento("Comprobante Retención");
        }
        if (tipoDocumento.equalsIgnoreCase("guiaRemision")) {
            infoGuiaRemision();
            setCodigoTipoDocumento(4);
            setNombreTipoDocumento("Guía de remisión");
        }
        infoAdicional();

        return null;
    }

    /** Metodo para cargar el valor de documentos.
     *
     * @param informacionDocumento
     * @param nodoValor
     */
    private void valorDocumento(String informacionDocumento, String nodoValor) {
        double valor = 0f;

        NodeList nodeList = documento.getElementsByTagName(informacionDocumento);
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node nodo = nodeList.item(i);
            for (int k = 0; k < nodeList.item(i)
                                        .getChildNodes()
                                        .getLength(); k++) {
                if (nodo.getChildNodes()
                        .item(k)
                        .getNodeName()
                        .equalsIgnoreCase(nodoValor))
                    try {
                        valor = new Double(nodo.getChildNodes()
                                               .item(k)
                                               .getTextContent()).doubleValue() + valor;
                    } catch (Exception e) {
                        valor = 0;
                    }
            }
        }
        setValor(String.format("%.2f", valor));
    }

    /** Metodo para desensamblar el archivo recibido.
     *
     * @param direccion
     */
    public String descuartizaXMLAutorizado() {
        NodeList nodeLst = documento.getElementsByTagName("autorizacion");

        for (int i = 0; i < nodeLst.getLength(); i++) {
            Node nodo = nodeLst.item(i);
            Autorizacion autorizacion = new Autorizacion();

            for (int k = 0; k < nodo.getChildNodes().getLength(); k++) {
                if (nodo.getChildNodes()
                        .item(k)
                        .getNodeName()
                        .equalsIgnoreCase("ambiente"))
                    autorizacion.setAmbiente(nodo.getChildNodes()
                                                 .item(k)
                                                 .getTextContent());
                if (nodo.getChildNodes()
                        .item(k)
                        .getNodeName()
                        .equalsIgnoreCase("fechaAutorizacion"))
                    autorizacion.setFechaAutorizacion(nodo.getChildNodes()
                                                          .item(k)
                                                          .getTextContent());
                if (nodo.getChildNodes()
                        .item(k)
                        .getNodeName()
                        .equalsIgnoreCase("numeroAutorizacion"))
                    autorizacion.setNumeroAutorizacion(nodo.getChildNodes()
                                                           .item(k)
                                                           .getTextContent());
                if (nodo.getChildNodes()
                        .item(k)
                        .getNodeName()
                        .equalsIgnoreCase("estado"))
                    autorizacion.setEstado(nodo.getChildNodes()
                                               .item(k)
                                               .getTextContent());
                if (nodo.getChildNodes()
                        .item(k)
                        .getNodeName()
                        .equalsIgnoreCase("comprobante"))
                    autorizacion.setComprobante(nodo.getChildNodes()
                                                    .item(k)
                                                    .getTextContent());

                if (autorizacion.getEstado().equalsIgnoreCase("AUTORIZADO") && (autorizacion.getComprobante()
                                                                                            .trim()
                                                                                            .length() > 0)) {
                    documento = parseXmlString(autorizacion.getComprobante());
                    descuartizaXMLOriginal();
                    setAutorizacionOk(autorizacion);
                    return null;
                }
            }
        }

        return null;
    }

    /**Metodo que permite obtener informacion tributaria de los diferentes documentos xml.
     * Obtine el ruc
     * Obtiene la clave de Acesso
     * Obtien estab
     *
     */
    private void getInfoTributaria() {
        NodeList nodeList = documento.getElementsByTagName("infoTributaria");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node nodo = nodeList.item(i);
            for (int k = 0; k < nodeList.item(i)
                                        .getChildNodes()
                                        .getLength(); k++) {

                if (nodo.getChildNodes()
                        .item(k)
                        .getNodeName()
                        .equalsIgnoreCase("razonSocial"))
                    setNombreEmpresa(nodo.getChildNodes()
                                         .item(k)
                                         .getTextContent());
                if (nodo.getChildNodes()
                        .item(k)
                        .getNodeName()
                        .equalsIgnoreCase("ruc"))
                    setIdenticacion(nodo.getChildNodes()
                                        .item(k)
                                        .getTextContent());
                if (nodo.getChildNodes()
                        .item(k)
                        .getNodeName()
                        .equalsIgnoreCase("claveAcceso"))
                    setClaveAcesso(nodo.getChildNodes()
                                       .item(k)
                                       .getTextContent());
                if (nodo.getChildNodes()
                        .item(k)
                        .getNodeName()
                        .equalsIgnoreCase("estab"))
                    setSecuencia(nodo.getChildNodes()
                                     .item(k)
                                     .getTextContent());
                if (nodo.getChildNodes()
                        .item(k)
                        .getNodeName()
                        .equalsIgnoreCase("ptoEmi"))
                    setSecuencia(getSecuencia() + "-" + nodo.getChildNodes()
                                                            .item(k)
                                                            .getTextContent());
                if (nodo.getChildNodes()
                        .item(k)
                        .getNodeName()
                        .equalsIgnoreCase("secuencial"))
                    setSecuencia(getSecuencia() + "-" + nodo.getChildNodes()
                                                            .item(k)
                                                            .getTextContent());
            }
        }
    }

    /**Metodo que permite obtener informacion de un documento xml de tipo guia de Remicion.
     * Obtine la identifiacion del comprador
     * Obtiene el tipo de identificacion del comprador
     * Obtien la direccion del Establecimiento.
     *
     */
    private void infoGuiaRemision() {
        NodeList nodeList = documento.getElementsByTagName("infoGuiaRemision");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node nodo = nodeList.item(i);
            for (int k = 0; k < nodeList.item(i)
                                        .getChildNodes()
                                        .getLength(); k++) {
                if (nodo.getChildNodes()
                        .item(k)
                        .getNodeName()
                        .equalsIgnoreCase("rucTransportista"))
                    setIdentificacionCliente(nodo.getChildNodes()
                                                 .item(k)
                                                 .getTextContent());
                if (nodo.getChildNodes()
                        .item(k)
                        .getNodeName()
                        .equalsIgnoreCase("tipoIdentificacionTransportista"))
                    setTipoIdentificacion(nodo.getChildNodes()
                                              .item(k)
                                              .getTextContent());
                if (nodo.getChildNodes()
                        .item(k)
                        .getNodeName()
                        .equalsIgnoreCase("dirEstablecimiento"))
                    setDireccionCliente(nodo.getChildNodes()
                                            .item(k)
                                            .getTextContent());
                if (nodo.getChildNodes()
                        .item(k)
                        .getNodeName()
                        .equalsIgnoreCase("razonSocialTransportista"))
                    setNombreCliente(nodo.getChildNodes()
                                         .item(k)
                                         .getTextContent());
            }
        }

        nodeList = documento.getElementsByTagName("destinatario");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node nodo = nodeList.item(i);
            for (int k = 0; k < nodeList.item(i)
                                        .getChildNodes()
                                        .getLength(); k++) {
                if (nodo.getChildNodes()
                        .item(k)
                        .getNodeName()
                        .equalsIgnoreCase("identificacionDestinatario"))
                    addLista(nodo.getChildNodes()
                                 .item(k)
                                 .getTextContent());
            }
        }
    }

    /**Metodo que permite obtener informacion de un documento xml de tipo Comprobante de Retencion.
     * Obtine la identifiacion del comprador
     * Obtiene el tipo de identificacion del comprador
     * Obtien la direccion del Establecimiento.
     *
     */
    private void infoCompRetencion() {
        NodeList nodeList = documento.getElementsByTagName("infoCompRetencion");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node nodo = nodeList.item(i);
            for (int k = 0; k < nodeList.item(i)
                                        .getChildNodes()
                                        .getLength(); k++) {
                if (nodo.getChildNodes()
                        .item(k)
                        .getNodeName()
                        .equalsIgnoreCase("identificacionSujetoRetenido"))
                    setIdentificacionCliente(nodo.getChildNodes()
                                                 .item(k)
                                                 .getTextContent());
                if (nodo.getChildNodes()
                        .item(k)
                        .getNodeName()
                        .equalsIgnoreCase("tipoIdentificacionSujetoRetenido"))
                    setIdentificacionCliente(nodo.getChildNodes()
                                                 .item(k)
                                                 .getTextContent());
                if (nodo.getChildNodes()
                        .item(k)
                        .getNodeName()
                        .equalsIgnoreCase("dirEstablecimiento"))
                    setDireccionCliente(nodo.getChildNodes()
                                            .item(k)
                                            .getTextContent());
                if (nodo.getChildNodes()
                        .item(k)
                        .getNodeName()
                        .equalsIgnoreCase("razonSocialSujetoRetenido"))
                    setNombreCliente(nodo.getChildNodes()
                                         .item(k)
                                         .getTextContent());
            }
        }
    }

    /**Metodo que permite obtener informacion del comprador de un documento xml.
     * Par los documentos factura, notaDebito y notaCredito
     * Obtine la identifiacion del comprador
     * Obtiene el tipo de identificacion del comprador
     * Obtien la direccion del Establecimiento.
     *
     *@param tipoInformacion
     */
    private void informacionComprador(String tipoInformacion) {
        NodeList nodeList = documento.getElementsByTagName(tipoInformacion);
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node nodo = nodeList.item(i);
            for (int k = 0; k < nodeList.item(i)
                                        .getChildNodes()
                                        .getLength(); k++) {
                if (nodo.getChildNodes()
                        .item(k)
                        .getNodeName()
                        .equalsIgnoreCase("identificacionComprador"))
                    setIdentificacionCliente(nodo.getChildNodes()
                                                 .item(k)
                                                 .getTextContent());
                if (nodo.getChildNodes()
                        .item(k)
                        .getNodeName()
                        .equalsIgnoreCase("tipoIdentificacionComprador"))
                    setTipoIdentificacion(nodo.getChildNodes()
                                              .item(k)
                                              .getTextContent());
                if (nodo.getChildNodes()
                        .item(k)
                        .getNodeName()
                        .equalsIgnoreCase("dirEstablecimiento"))
                    setDireccionCliente(nodo.getChildNodes()
                                            .item(k)
                                            .getTextContent());
                if (nodo.getChildNodes()
                        .item(k)
                        .getNodeName()
                        .equalsIgnoreCase("razonSocialComprador"))
                    setNombreCliente(nodo.getChildNodes()
                                         .item(k)
                                         .getTextContent());
            }
        }
    }

    /**Metodo que permite obtener informacion adicional de un documento xml.
     * Obtiene el telefono del cliente
     * Obtiene el Correo del Cliente
     * Obtiene los correos de los destinatarios.
     */
    private void infoAdicional() {
        NodeList nodeList = documento.getElementsByTagName("infoAdicional");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node nodo = nodeList.item(i);
            for (int k = 0; k < nodeList.item(i)
                                        .getChildNodes()
                                        .getLength(); k++) {
                if (nodo.getChildNodes()
                        .item(k)
                        .hasAttributes()) {
                    Node nodoHijo = nodo.getChildNodes()
                                        .item(k)
                                        .getAttributes()
                                        .getNamedItem("nombre");
                    if (nodoHijo.getNodeValue().equalsIgnoreCase("Teléfono Cliente") ||
                        nodoHijo.getNodeValue().equalsIgnoreCase("Telefono Cliente"))
                        setTelefonoCliente(nodo.getChildNodes()
                                               .item(k)
                                               .getTextContent());
                    if (nodoHijo.getNodeValue().equalsIgnoreCase("Correo Cliente"))
                        setCorreoCliente(nodo.getChildNodes()
                                             .item(k)
                                             .getTextContent());
                    if (nodoHijo.getNodeValue().indexOf("Correo") > -1)
                        setCorreo(getCorreo() + " " + nodo.getChildNodes()
                                                          .item(k)
                                                          .getTextContent());
                }
            }
        }
    }

    /** Metodo para subir un unico identificación, y evitar duplicados.
     *
     * @param identificacion
     */
    private void addLista(String identificacion) {
        for (String a : getIdentidadesGuia())
            if (a.compareTo(identificacion) == 0)
                return;
        getIdentidadesGuia().add(identificacion);
    }

    /**Metodo que permite hacer tun toString.
     *
     * @return
     */
    public String toString() {
        String listadoGuias = "";

        for (String a : getIdentidadesGuia())
            listadoGuias = a + "\n" + listadoGuias;

        return String.format("Identificacion: %s, Codigo Tipo Documento: %s, Secuenca: %s, Clave de acceso: %s, Nombre Cliente: %s, Identificación Cliente : %s, Correos: %s,Direccion Cliente: %s, Tipo Identificacion: %s, Correo Cliente: %s,Telefono cliente: %s,Valor: %s\n%s",
                             getIdenticacion(), getCodigoTipoDocumento(), getSecuencia(), getClaveAcesso(),
                             getNombreCliente(), getIdentificacionCliente(), getCorreo(), getDireccionCliente(),
                             getTipoIdentificacion(), getCorreoCliente(), getTelefonoCliente(), getValor(),
                             listadoGuias) + autorizacionOk.toString();
    }


    /**Metodo que retorna la secuencia.
     * @return
     */
    public String getSecuencia() {
        return secuencia;
    }

    /**
     * @param secuencia
     */
    public void setSecuencia(String secuencia) {
        this.secuencia = secuencia;
    }

    /**Metodo que retorna la clave de acesso.
     * @return
     */
    public String getClaveAcesso() {
        return claveAcesso;
    }

    /**
     * @param claveAcesso
     */
    public void setClaveAcesso(String claveAcesso) {
        this.claveAcesso = claveAcesso;
    }

    /**Metodo que retorna el correo.
     * @return
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**Metodo que retorna la identificacion.
     * @return
     */
    public String getIdenticacion() {
        return identicacion;
    }

    /**
     * @param identicacion
     */
    public void setIdenticacion(String identicacion) {
        this.identicacion = identicacion;
    }

    /**Metodo que retonar el documento.
     * @return
     */
    public int getCodigoTipoDocumento() {
        return codigoTipoDocumento;
    }

    /**
     * @param codigoTipoDocumento
     */
    public void setCodigoTipoDocumento(int codigoTipoDocumento) {
        this.codigoTipoDocumento = codigoTipoDocumento;
    }

    /**Metodo que retorna la identificacion del cliente.
     * @return
     */
    public String getIdentificacionCliente() {
        return identificacionCliente;
    }

    /**
     * @param identificacionCliente
     */
    public void setIdentificacionCliente(String identificacionCliente) {
        this.identificacionCliente = identificacionCliente;
    }


    /**Metodo que permite retornar el correo del cliente.
     * @return
     */
    public String getCorreoCliente() {
        return correoCliente;
    }

    /**
     * @param correoCliente
     */
    public void setCorreoCliente(String correoCliente) {
        this.correoCliente = correoCliente;
    }

    /**Metodo que retorna el tipo de identificacion.
     * @return
     */
    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    /**
     * @param tipoIdentificacion
     */
    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    /**Metodo que retorna la direccion del cliente.
     * @return
     */
    public String getDireccionCliente() {
        return direccionCliente;
    }

    /**
     * @param direccionCliente
     */
    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    /**Metodo que retorna el telefono del cliente.
     * @return
     */
    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    /**
     * @param telefonoCliente
     */
    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    /**
     * @return
     */
    public String getNombreCliente() {
        return nombreCliente;
    }

    /**
     * @param nombreCliente
     */
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    /** Obtiene Lista de identificaciones de personas que reciben una guia.
     *
     * @return
     */
    public List<String> getIdentidadesGuia() {
        return identidadesGuia;
    }

    /** Pone la lista con las guias.
     *
     * @param identidadesGuia
     */
    public void setIdentidadesGuia(ArrayList<String> identidadesGuia) {
        this.identidadesGuia = identidadesGuia;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public void setXMLValido(boolean XMLValido) {
        this.XMLValido = XMLValido;
    }

    public boolean isXMLValido() {
        return XMLValido;
    }

    public IdentificarDocumento.Autorizacion getAutorizacionOk() {
        return autorizacionOk;
    }

    public void setAutorizacionOk(IdentificarDocumento.Autorizacion autorizacionOk) {
        this.autorizacionOk = autorizacionOk;
    }

    public String getNombreTipoDocumento() {
        return nombreTipoDocumento;
    }

    public void setNombreTipoDocumento(String nombreTipoDocumento) {
        this.nombreTipoDocumento = nombreTipoDocumento;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }


    /** Clase para contener las autorizaciones del SRI.
     *
     * @author omar velez - omargo33@hotmail.com
     *
     */
    public class Autorizacion {

        private String estado;
        private String fechaAutorizacion;
        private Date fecha;
        private String ambiente;
        private String comprobante;
        private String numeroAutorizacion;
        private List<MensajeAutorizacion> listaMensajeAutorizacion;

        /** Metodo para crear un objeto.
         *
         */
        public Autorizacion() {
            super();
            setAmbiente("");
            setComprobante("");
            setEstado("");
            setFechaAutorizacion("2000-07-15T18:00:05.752-05:00");
            setListaMensajeAutorizacion(new ArrayList<MensajeAutorizacion>());
            setNumeroAutorizacion("");
        }

        /** Metodo para sobrecargar un mensaje de error.
         *
         * @return
         */
        public String toString() {
            return String.format("Ambiente %s, comprobante %s, estado %s, no autorizacion %s, fecha autorizacion %s, mensajes: %s ",
                                 getAmbiente(), getComprobante(), getEstado(), getNumeroAutorizacion(),
                                 getFechaAutorizacion(), listaMensajesToString());


        }

        //propiedades

        /**
         * @return
         */
        public String getEstado() {
            return estado;
        }

        /**
         * @param estado
         */
        public void setEstado(String estado) {
            this.estado = estado;
        }

        /**
         * @return
         */
        public String getFechaAutorizacion() {
            return fechaAutorizacion;
        }

        /**
         * @param fechaAutorizacion
         */
        public void setFechaAutorizacion(String fechaAutorizacion) {
            this.fechaAutorizacion = fechaAutorizacion;
        }

        /**
         * @return
         */
        public String getAmbiente() {
            return ambiente;
        }

        /**
         * @param ambiente
         */
        public void setAmbiente(String ambiente) {
            this.ambiente = ambiente;
        }

        /**
         * @return
         */
        public String getComprobante() {
            return comprobante;
        }

        /**
         * @param comprobante
         */
        public void setComprobante(String comprobante) {
            this.comprobante = comprobante;
        }

        /**
         * @return
         */
        public List<MensajeAutorizacion> getListaMensajeAutorizacion() {
            return listaMensajeAutorizacion;
        }

        /**
         * @param listaMensajeAutorizacion
         */
        public void setListaMensajeAutorizacion(List<MensajeAutorizacion> listaMensajeAutorizacion) {
            this.listaMensajeAutorizacion = listaMensajeAutorizacion;
        }

        /**
         * @return
         */
        public String listaMensajesToString() {
            String respuesta = "";
            for (MensajeAutorizacion a : getListaMensajeAutorizacion())
                respuesta = respuesta + a.toString();
            return respuesta;
        }

        /** Metodo para obtener la fecha con un formato definido.
         *
         * @return
         */
        public Date getFecha() {
            try {
                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                String strFecha = getFechaAutorizacion().replaceAll("T", " ").substring(1, 19);
                Date fechaDate = formato.parse(strFecha);
                return fechaDate;
            } catch (Exception ex) {
                return new Date();
            }
        }

        /**
         * @param fecha
         */
        public void setFecha(Date fecha) {
            this.fecha = fecha;
        }

        public String getNumeroAutorizacion() {
            return numeroAutorizacion;
        }

        public void setNumeroAutorizacion(String numeroAutorizacion) {
            this.numeroAutorizacion = numeroAutorizacion;
        }
    }

    /** Objeto para soportar el mensaje de la autorización.
     *
     * @author omar velez - omargo33@hotmail.com
     *
     */
    public class MensajeAutorizacion {
        private String identificador;
        private String mensaje;
        private String tipo;
        private String informacionAdicional;

        /** Metodo para crear el objeto.
         *
         */
        public MensajeAutorizacion() {
            super();
            setIdentificador("");
            setMensaje("");
            setTipo("");
            setInformacionAdicional("");
        }

        /** Metodo para sobrecargar un mensaje de error.
         *
         * @return
         */
        public String toString() {
            return "\nidentificador: " + getIdentificador() + "\nmensaje: " + getMensaje() + "\ntipo: " + getTipo();
        }

        //Propiedades

        /**
         * @return
         */
        public String getIdentificador() {
            return identificador;
        }

        /**
         * @param identificador
         */
        public void setIdentificador(String identificador) {
            this.identificador = identificador;
        }

        /**
         * @return
         */
        public String getMensaje() {
            return mensaje;
        }

        /**
         * @param mensaje
         */
        public void setMensaje(String mensaje) {
            this.mensaje = mensaje;
        }

        /**
         * @return
         */
        public String getTipo() {
            return tipo;
        }

        /**
         * @param tipo
         */
        public void setTipo(String tipo) {
            this.tipo = tipo;
        }

        public String getInformacionAdicional() {
            return informacionAdicional;
        }

        public void setInformacionAdicional(String informacionAdicional) {
            this.informacionAdicional = informacionAdicional;
        }
    }
}
