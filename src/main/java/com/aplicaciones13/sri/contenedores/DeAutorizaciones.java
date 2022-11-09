package com.aplicaciones13.sri.contenedores;

import java.sql.Timestamp;

public class DeAutorizaciones {

    private String codigoAutorizacion;
    private String ruc;
    private String claveAcceso;
    private String fechaSRI;
    private String ambiente;
    private String numeroAutorizacion;
    private String emision;
    private String tipoDocumento;
    private String codigoUsuario;
    private Timestamp fechaUsuario;
    private Timestamp fechaUSJR;
    private String varcharUSJR;
    private double decimalUSJR;
    private String programaUSJR;

    public DeAutorizaciones() {
        super();
        limpiar();
    }

    /** Metodo para escribir los datos de actualizacion en caso de ser autorizado
     *
     */
    public void insertar() {
        System.out.println(String.format("\nClave de Acceso: %s " +            
            "\nFecha SRI: %s " +
            "\nAmbiente: %s " +
            "\nNumero Autorizacion: %s " +
            "\nEmision: %s " +
            "\nC�digo Usuario: %s" +
            "\nFecha Usuario: %s" +
            "\nFecha Sistema: %s" +
            "\nValor Decimal: %s" +
            "\nValor Varchar: %s" +
            "\nPrograma: %s\n",
                                         getClaveAcceso(), 
                                         getFechaSRI(),
                                         getAmbiente(),
                                         getNumeroAutorizacion(), 
                                         getEmision(),
                                         getCodigoUsuario(), 
                                         getFechaUsuario(),
                                         getFechaUSJR(), 
                                         getDecimalUSJR(), 
                                         getVarcharUSJR(),                                         
                                         getProgramaUSJR()));
    }

    public void limpiar() {
        setCodigoAutorizacion("");
        setRuc("");
        setClaveAcceso("");
        setFechaSRI("");
        setAmbiente("");
        setNumeroAutorizacion("");
        setEmision("");
        setTipoDocumento("");
        setCodigoUsuario("");
        setCodigoUsuario("");
        setFechaUsuario(null);
        setFechaUSJR(null);
        setVarcharUSJR("");
        setDecimalUSJR(0f);
        setProgramaUSJR("");
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

    public String getFechaSRI() {
        return fechaSRI;
    }

    public void setFechaSRI(String fechaSRI) {
        this.fechaSRI = fechaSRI;
    }

    public String getAmbiente() {
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

    public Timestamp getFechaUsuario() {
        return fechaUsuario;
    }

    public void setFechaUsuario(Timestamp fechaUsuario) {
        this.fechaUsuario = fechaUsuario;
    }

    public Timestamp getFechaUSJR() {
        return fechaUSJR;
    }

    public void setFechaUSJR(Timestamp fechaUSJR) {
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

    public String getVarcharUSJR() {
        return varcharUSJR;
    }

    public void setVarcharUSJR(String varcharUSJR) {
        this.varcharUSJR = varcharUSJR;
    }

    public String getCodigoAutorizacion() {
        return codigoAutorizacion;
    }

    public void setCodigoAutorizacion(String codigoAutorizacion) {
        this.codigoAutorizacion = codigoAutorizacion;
    }
}
