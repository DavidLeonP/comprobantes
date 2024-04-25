/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplicaciones13.documentos.impresion.elementos.texto;

import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.properties.TextAlignment;

/**
 * Objeto para mostrar un titulo .
 *
 * @author omargo33
 *
 */
public class Titulo extends Elemento {

    public static final float H1 = 14f; //Tamaño 14 px
    public static final float H2 = 12f; //Tamaño 12 px
    public static final float H3 = 10f; //Tamaño 10 px

    private float tamano;

    /**
     * Metodo para crear el objeto.
     *
     * @param tamano
     */
    public Titulo(float tamano) {        
        this("", tamano);
        this.tamano = tamano;
    }

    /**
     * Metodo para crear el objeto.
     *
     * @param texto
     * @param tamano
     */
    public Titulo(String texto, float tamano) {
        super();
        init(texto, tamano);
    }

    /**
     * Metodo para inicialiar el objeto.
     *
     * @param texto
     * @param tamano
     */
    private void init(String texto, float tamano) {
        setTexto(texto);
        getTexto().setFontSize(tamano);
        setParagraph(getTexto(),getFontTitulos());    
    }

    /**
     * @param texto
     */
    @Override
    public void setTexto(String texto) {
        super.setTexto(texto.toUpperCase());
        setParagraph(new Paragraph(texto));
        getParagraph().setFont(getFontTitulos());
        getParagraph().setTextAlignment(TextAlignment.LEFT);        
        getParagraph().setFontSize(tamano);
    }

    /**
     * @param texto
     */
    public void setTextoCentro(String texto) {
        super.setTexto(texto.toUpperCase());
        setParagraph(new Paragraph(texto));
        getParagraph().setFont(getFontTitulos());
        getParagraph().setTextAlignment(TextAlignment.CENTER);
        getParagraph().setFontSize(tamano);
    }
    
    /**
     * @param texto
     */
    public void setTextoDerecha(String texto) {
        super.setTexto(texto.toUpperCase());
        setParagraph(new Paragraph(texto));
        getParagraph().setFont(getFontTitulos());
        getParagraph().setTextAlignment(TextAlignment.RIGHT);
        getParagraph().setFontSize(tamano);
    } 
}