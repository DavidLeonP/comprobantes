package com.aplicaciones13.impresion;


/** Objeto para soportar los datos de los documeentos electronicos
 *
 * @author o.velez@13aplicaciones.com
 *
 */
public class DatosDocumentosElectronicos {

    private String pathLogo;
    private String pathSource;
    private String numeroAutorizacion;
    private String fechaAutorizacion;
    private String ambienteAutorizacion;
    private String emisionAutorizacion;
    private String claveAccesoAutorizacion;
    private String pathFirmaGrafica;
    private boolean offline;

    /** Metodo para crear el objeto.
     *
     */
    public DatosDocumentosElectronicos() {
        super();
        setPathLogo("");
        setPathSource("");
        setNumeroAutorizacion("");
        setFechaAutorizacion("");
        setAmbienteAutorizacion("");
        setEmisionAutorizacion("");
        setClaveAccesoAutorizacion("");
        setPathFirmaGrafica("");
        setOffline(false);

    }

    //Propiedades

    public String getPathLogo() {
        return this.pathLogo;
    }

    public void setPathLogo(String pathLogo) {
        this.pathLogo = pathLogo;
    }

    public String getPathSource() {
        return this.pathSource;
    }

    public void setPathSource(String pathSource) {
        this.pathSource = pathSource;
    }

    public String getNumeroAutorizacion() {
        return this.numeroAutorizacion;
    }

    public void setNumeroAutorizacion(String numeroAutorizacion) {
        this.numeroAutorizacion = numeroAutorizacion;
    }

    public String getFechaAutorizacion() {
        return this.fechaAutorizacion;
    }

    public void setFechaAutorizacion(String fechaAutorizacion) {
        this.fechaAutorizacion = fechaAutorizacion;
    }

    public String getAmbienteAutorizacion() {
        if (this.ambienteAutorizacion != null && this.ambienteAutorizacion.toUpperCase().startsWith("PRODUCC")){
            return "PRODUCCION";            
        }

        return ambienteAutorizacion;
    }

    public void setAmbienteAutorizacion(String ambienteAutorizacion) {
        this.ambienteAutorizacion = ambienteAutorizacion;
    }

    public String getEmisionAutorizacion() {
        return this.emisionAutorizacion;
    }

    public void setEmisionAutorizacion(String emisionAutorizacion) {
        this.emisionAutorizacion = emisionAutorizacion;
    }

    public String getClaveAccesoAutorizacion() {
        return this.claveAccesoAutorizacion;
    }

    public void setClaveAccesoAutorizacion(String claveAccesoAutorizacion) {
        this.claveAccesoAutorizacion = claveAccesoAutorizacion;
    }

    public boolean isOffline() {
        return this.offline;
    }

    public void setOffline(boolean offline) {
        this.offline = offline;
    }

    public void setPathFirmaGrafica(String pathFirmaGrafica) {
        this.pathFirmaGrafica = pathFirmaGrafica;
    }

    public String getPathFirmaGrafica() {
        return this.pathFirmaGrafica;
    }
}
