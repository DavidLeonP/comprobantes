package com.aplicaciones13.sri.contenedores;

import java.sql.Timestamp;

/** Clase para escribir los datos del objeto
 *
 */
public class DePasos {

    private String codigoDocumentoElectronico;
    private int codigoPasos;
    private String mensaje1;
    private String mensaje2;
    private String descripcion3;
    private String codigoUsuario;
    private Timestamp fechaUsuario;
    private Timestamp fechaUSJR;
    private double decimalUSJR;
    private String programaUSJR;
    private int maximoTexto;

    public DePasos() {
        super();
        limpiar();
    }

    /** Metodo para escribir un paso que se dio.
     *
     */
    public String escribir() {
        String mensaje =
            String.format("\nCodigo Documento Electronico: %s\nMensaje 1: %s\nMensaje 2: %s\nDescripcion: %s\nCodigo Usuario: %s\nFecha Usuario: %s\nFecha Sistema: %s\nValor Decimal: %s\nPrograma: %s\n\n",
                          getCodigoDocumentoElectronico(), getMensaje1(),
                          getMensaje2(), getDescripcion3(), getCodigoUsuario(),
                          getFechaUsuario(), getFechaUSJR(), getDecimalUSJR(),
                          getProgramaUSJR());
        return mensaje;
    }

    public void limpiar() {
        setCodigoDocumentoElectronico("");
        setCodigoPasos(-1);
        setMensaje1("");
        setMensaje2("");
        setDescripcion3("");
        setCodigoUsuario("");
        setFechaUsuario(null);
        setFechaUSJR(null);
        setDecimalUSJR(0f);
        setProgramaUSJR("");
        setMaximoTexto(1024);
    }

    public String getCodigoDocumentoElectronico() {
        return codigoDocumentoElectronico;
    }

    public void setCodigoDocumentoElectronico(String codigoDocumentoElectronico) {
        this.codigoDocumentoElectronico = codigoDocumentoElectronico;
    }

    public int getCodigoPasos() {
        return codigoPasos;
    }

    public void setCodigoPasos(int codigoPasos) {
        this.codigoPasos = codigoPasos;
    }

    public String getMensaje1() {
        mensaje1 = mensaje1.trim();
        if (mensaje1.length() > getMaximoTexto())
            mensaje1 = mensaje1.substring(0, getMaximoTexto());

        return mensaje1;
    }

    public void setMensaje1(String mensaje1) {
        this.mensaje1 = mensaje1;
    }

    public String getMensaje2() {
        mensaje2 = mensaje2.trim();
        if (mensaje2.length() > getMaximoTexto())
            mensaje2 = mensaje2.substring(0, getMaximoTexto());

        return mensaje2;
    }

    public void setMensaje2(String mensaje2) {
        this.mensaje2 = mensaje2;
    }

    public String getDescripcion3() {
        descripcion3 = descripcion3.trim();
        if (descripcion3.length() > (getMaximoTexto() * 2))
            descripcion3 = descripcion3.substring(0, (getMaximoTexto() * 2));

        return descripcion3;
    }

    public void setDescripcion3(String descripcion3) {
        this.descripcion3 = descripcion3;
    }

    public String getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public Timestamp getFechaUsuario() {
        return new Timestamp(new java.util.Date().getTime());
    }

    public void setFechaUsuario(Timestamp fechaUsuario) {
        this.fechaUsuario = fechaUsuario;
    }

    public Timestamp getFechaUSJR() {
        return new Timestamp(new java.util.Date().getTime());
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

    public int getMaximoTexto() {
        return maximoTexto;
    }

    public void setMaximoTexto(int maximoTexto) {
        this.maximoTexto = maximoTexto;
    }
}
