package com.aplicaciones13.sri.contenedores;

import java.sql.Date;

public class DeDocumentoElectronico {

    private String codigoDocumentoElectronico;
    private String codigoSolicitanteEmrpresa;
    private String ruc;
    private String claveAcceso;
    private String archivoOriginal;
    private String archivoFirmado;
    private String archivoRespuesta;
    private String archivoEstado;
    private int numeroProceso;
    private String fechaSRI;
    private String ambiente;
    private String numeroAutorizacion;
    private String emision;
    private String tipoDocumento;
    private String codigoUsuario;
    private Date fechaUsuario;
    private Date fechaUSJR;
    private double decimalUSJR;
    private String programaUSJR;

    public DeDocumentoElectronico() {
        super();
        limpiar();
    }

    /** Metodo para escribir los datos de actualizacion en caso de ser autorizado
     *
     */
    public String actualizar() {

        String respuesta =
            String.format("\nClave de Acceso: %s\nArchivo Original: %s\nArchivo Firmando: %s\nArchivo Respuesta: %s\nArchivo Estado: %s\nNumero Proceso: %s\nFecha SRI: %s\nAmbiente: %s\nNumero Autorizacion: %s\nEmision: %s\nC�digo Usuario: %s\nFecha Usuario: %s\nFecha Sistema: %s\nValor Decimal: %s\nPrograma: %s\n",
                          getClaveAcceso(), getArchivoOriginal(),
                          getArchivoFirmado(), getArchivoRespuesta(),
                          getArchivoEstado(), getNumeroProceso(),
                          getFechaSRI(), getAmbiente(),
                          getNumeroAutorizacion(), getEmision(),
                          getCodigoUsuario(), getFechaUsuario(),
                          getFechaUSJR(), getDecimalUSJR(), getProgramaUSJR());

        System.out.println(respuesta);

        return respuesta;
    }

    public void limpiar() {
        setCodigoDocumentoElectronico("");
        setCodigoSolicitanteEmrpresa("");
        setRuc("");
        setClaveAcceso("");
        setArchivoOriginal("");
        setArchivoFirmado("");
        setArchivoRespuesta("");
        setArchivoEstado("");
        setNumeroProceso(0);
        setFechaSRI("");
        setAmbiente("");
        setNumeroAutorizacion("");
        setEmision("");
        setTipoDocumento("");
        setCodigoUsuario("");
        setCodigoUsuario("");
        setFechaUsuario(null);
        setFechaUSJR(null);
        setDecimalUSJR(0f);
        setProgramaUSJR("");
    }


    public String getCodigoDocumentoElectronico() {
        return codigoDocumentoElectronico;
    }

    public void setCodigoDocumentoElectronico(String codigoDocumentoElectronico) {
        this.codigoDocumentoElectronico = codigoDocumentoElectronico;
    }

    public String getCodigoSolicitanteEmrpresa() {
        return codigoSolicitanteEmrpresa;
    }

    public void setCodigoSolicitanteEmrpresa(String codigoSolicitanteEmrpresa) {
        this.codigoSolicitanteEmrpresa = codigoSolicitanteEmrpresa;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getClaveAcceso() {
        return claveAcceso;
    }

    public void setClaveAcceso(String claveAcceso) {
        this.claveAcceso = claveAcceso;
    }

    public String getArchivoOriginal() {
        return archivoOriginal;
    }

    public void setArchivoOriginal(String archivoOriginal) {
        this.archivoOriginal = archivoOriginal;
    }

    public String getArchivoFirmado() {
        return archivoFirmado;
    }

    public void setArchivoFirmado(String archivoFirmado) {
        this.archivoFirmado = archivoFirmado;
    }

    public String getArchivoRespuesta() {
        return archivoRespuesta;
    }

    public void setArchivoRespuesta(String archivoRespuesta) {
        this.archivoRespuesta = archivoRespuesta;
    }

    public String getArchivoEstado() {
        return archivoEstado;
    }

    public void setArchivoEstado(String archivoEstado) {
        this.archivoEstado = archivoEstado;
    }

    public int getNumeroProceso() {
        return numeroProceso;
    }

    public void setNumeroProceso(int numeroProceso) {
        this.numeroProceso = numeroProceso;
    }

    public String getFechaSRI() {
        return fechaSRI;
    }

    public void setFechaSRI(String fechaSRI) {
        this.fechaSRI = fechaSRI;
    }

    public String getAmbiente() {
        if (ambiente != null)
            if (ambiente.toUpperCase().startsWith("PRODUCC"))
                return "PRODUCCION";
        return ambiente;
    }


    public void setAmbiente(String ambiente) {
        this.ambiente = ambiente;
    }

    public String getNumeroAutorizacion() {
        return numeroAutorizacion;
    }

    public void setNumeroAutorizacion(String numeroAutorizacion) {
        this.numeroAutorizacion = numeroAutorizacion;
    }

    public String getEmision() {
        return emision;
    }

    public void setEmision(String emision) {
        this.emision = emision;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public Date getFechaUsuario() {
        return fechaUsuario;
    }

    public void setFechaUsuario(Date fechaUsuario) {
        this.fechaUsuario = fechaUsuario;
    }

    public Date getFechaUSJR() {
        return fechaUSJR;
    }

    public void setFechaUSJR(Date fechaUSJR) {
        this.fechaUSJR = fechaUSJR;
    }

    public double getDecimalUSJR() {
        return decimalUSJR;
    }

    public void setDecimalUSJR(double decimalUSJR) {
        this.decimalUSJR = decimalUSJR;
    }

    public String getProgramaUSJR() {
        return programaUSJR;
    }

    public void setProgramaUSJR(String programaUSJR) {
        this.programaUSJR = programaUSJR;
    }
}
