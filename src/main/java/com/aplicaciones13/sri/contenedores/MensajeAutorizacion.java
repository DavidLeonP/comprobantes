package com.aplicaciones13.sri.contenedores;


/** Objeto para soportar el mensaje de la autorizaci�n.
 *
 * @author omarv omargo33@JeremiasSoft.com
 *
 */
public class MensajeAutorizacion {
    private String identificador;
    private String mensaje;
    private String tipo;
    private String informacionAdicional;

    /** M�todo para crear el objeto.
     *
     */
    public MensajeAutorizacion() {
        super();
        setIdentificador("");
        setMensaje("");
        setTipo("");
        setInformacionAdicional("");
    }

    /** M�todo para sobrecargar un mensaje de error.
     *
     * @return
     */
    public String toString() {
        return "\nidentificador: " + getIdentificador() + "\nmensaje: " +
            getMensaje() + "\ntipo: " + getTipo();
    }

    //Propiedades

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getTipo() {
        return tipo;
    }

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
