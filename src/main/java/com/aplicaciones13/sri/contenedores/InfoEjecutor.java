package com.aplicaciones13.sri.contenedores;

/**
 * Clase para crear pasar datos a la ejecucion de PDF.
 * 
 * @author o.velez@13aplicaciones.com
 * 
 */
public class InfoEjecutor {

    String pathXML;
    String pathPDF;
    String pathLogo;
    String pathFirmaGrafica;
    String ambienteAutorizacion;
    String claveAccesoAutorizacion;
    String emisionAutorizacion;
    String fechaAutorizacion;
    String numeroAutorizacion;
    boolean offline;

    public InfoEjecutor() {
        super();
    }

    public String getPathXML() {
        return pathXML;
    }

    public void setPathXML(String pathXML) {
        this.pathXML = pathXML;
    }

    public String getPathPDF() {
        return pathPDF;
    }

    public void setPathPDF(String pathPDF) {
        this.pathPDF = pathPDF;
    }

    public String getPathLogo() {
        return pathLogo;
    }

    public void setPathLogo(String pathLogo) {
        this.pathLogo = pathLogo;
    }

    public String getPathFirmaGrafica() {
        return pathFirmaGrafica;
    }

    public void setPathFirmaGrafica(String pathFirmaGrafica) {
        this.pathFirmaGrafica = pathFirmaGrafica;
    }

    public String getAmbienteAutorizacion() {
        return ambienteAutorizacion;
    }

    public void setAmbienteAutorizacion(String ambienteAutorizacion) {
        this.ambienteAutorizacion = ambienteAutorizacion;
    }

    public String getClaveAccesoAutorizacion() {
        return claveAccesoAutorizacion;
    }

    public void setClaveAccesoAutorizacion(String claveAccesoAutorizacion) {
        this.claveAccesoAutorizacion = claveAccesoAutorizacion;
    }

    public String getEmisionAutorizacion() {
        return emisionAutorizacion;
    }

    public void setEmisionAutorizacion(String emisionAutorizacion) {
        this.emisionAutorizacion = emisionAutorizacion;
    }

    public String getFechaAutorizacion() {
        return fechaAutorizacion;
    }

    public void setFechaAutorizacion(String fechaAutorizacion) {
        this.fechaAutorizacion = fechaAutorizacion;
    }

    public String getNumeroAutorizacion() {
        return numeroAutorizacion;
    }

    public void setNumeroAutorizacion(String numeroAutorizacion) {
        this.numeroAutorizacion = numeroAutorizacion;
    }

    public boolean isOffline() {
        return offline;
    }

    public void setOffline(boolean offline) {
        this.offline = offline;
    }

}
