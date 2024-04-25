/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplicaciones13.documentos.impresion.elementos.presentacion;

/**
 * Objeto para mantener una estructura de cenefa.
 *
 * @author omargo33
 *
 *
 */
public class CenefaEstructura {

    private String nombreDocumento;
    private final String pathImagen;
    private final boolean nombreDocumentoVisible;
    private final boolean imagenVisible;
    private final boolean numeroPaginaVisible;
    private final boolean totalPaginasVisible;
    private final boolean fechaCreacionVisible;

    /**
     * Metodo para crear el objeto.
     * 
     * @param nombreDocumentoVisible
     * @param imagenVisible
     * @param numeroPaginaVisible
     * @param totalPaginasVisible
     * @param fechaCreacionVisible
     * @param pathImagen 
     */
    public CenefaEstructura(boolean nombreDocumentoVisible, boolean imagenVisible, boolean numeroPaginaVisible, boolean totalPaginasVisible, boolean fechaCreacionVisible,  String pathImagen) {
        this.nombreDocumento = "";
        this.pathImagen = pathImagen;
        this.nombreDocumentoVisible = nombreDocumentoVisible;
        this.imagenVisible = imagenVisible;
        this.numeroPaginaVisible = numeroPaginaVisible;
        this.totalPaginasVisible = totalPaginasVisible;
        this.fechaCreacionVisible = fechaCreacionVisible;
    }

    /**
     * @return the nombreDocumento
     */
    public String getNombreDocumento() {
        return nombreDocumento;
    }


    /**
     * @return the pathImagen
     */
    public String getPathImagen() {
        return pathImagen;
    }

    /**
     * @return the numeroPaginaVisible
     */
    public boolean isNumeroPaginaVisible() {
        return numeroPaginaVisible;
    }

    /**
     * @return the totalPaginasVisible
     */
    public boolean isTotalPaginasVisible() {
        return totalPaginasVisible;
    }

    /**
     * @return the fechaCreacionVisible
     */
    public boolean isFechaCreacionVisible() {
        return fechaCreacionVisible;
    }

    /**
     * @return the nombreDocumentoVisible
     */
    public boolean isNombreDocumentoVisible() {
        return nombreDocumentoVisible;
    }

    /**
     * @return the imagenVisible
     */
    public boolean isImagenVisible() {
        return imagenVisible;
    }

    /**
     * Si es visible la informacion de la pagina.
     * 
     * @return 
     */
    public boolean isVisibleInformacionPagina() {
        return nombreDocumentoVisible || fechaCreacionVisible || numeroPaginaVisible;
    }    

    /**
     * @param nombreDocumento the nombreDocumento to set
     */
    public void setNombreDocumento(String nombreDocumento) {
        this.nombreDocumento = nombreDocumento;
    }
}
