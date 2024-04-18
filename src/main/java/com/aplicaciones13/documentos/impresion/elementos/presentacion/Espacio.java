package com.aplicaciones13.documentos.impresion.elementos.presentacion;

import com.aplicaciones13.documentos.impresion.elementos.texto.Elemento;

/**
 * Objeto para imprimir un espacio.
 *
 * @author omargo33
 *
 *
 */
public class Espacio extends Elemento {

    /**
     * Metodo para crear el objeto.
     *
     */
    public Espacio() {
        super();
        init();
    }

    /**
     * Metodo para inicialiar el objeto.
     *
     */
    private void init() {
        setTexto("");
        getTexto().setFontSize(4);
        setParagraph(getTexto());
    }

    /** Metodo para escribir las repeticiones para escribir.
     * 
     * @param repeticiones 
     */
    public void escribir(int repeticiones) {
        for (int i = repeticiones; i > 0; i--) {
            super.escribir();
        }
    }
}
