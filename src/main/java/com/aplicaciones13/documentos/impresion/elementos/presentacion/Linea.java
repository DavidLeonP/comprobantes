/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplicaciones13.documentos.impresion.elementos.presentacion;

import com.itextpdf.kernel.pdf.canvas.draw.DottedLine;
import com.itextpdf.kernel.pdf.canvas.draw.SolidLine;
import com.itextpdf.layout.element.LineSeparator;
import com.aplicaciones13.documentos.impresion.elementos.texto.Elemento;

/**
 * Objeto para escribir lineas .
 *
 * @author omargo33
 *
 *
 */
public class Linea extends Elemento {

    public static final boolean LINEA_SOLIDA = true; //Presenta una linea solida
    public static final boolean LINEA_PUNTEADA = false; // Presenta una linea Punteada
    private boolean tipoLinea;

    /**
     * Metodo para crear el objeto.
     *
     */
    public Linea() {
        this(true);
    }

    /**
     * Metodo para crear el objeto.
     *
     * @param tipoLinea
     */
    public Linea(boolean tipoLinea) {
        super();
        setTipoLinea(tipoLinea);
    }

    /**
     * Escribir linea solida.
     *
     */
    @Override
    public void escribir() {
        if (tipoLinea) {
            SolidLine solidLine = new SolidLine();
            solidLine.setLineWidth(0.5f);
            getDocumento().add(new LineSeparator(solidLine));
        } else {
            getDocumento().add(new LineSeparator(new DottedLine()));
        }
    }

    /**
     * @param tipoLinea the tipoLinea to set
     */
    public void setTipoLinea(boolean tipoLinea) {
        this.tipoLinea = tipoLinea;
    }

}
