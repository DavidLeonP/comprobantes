package com.aplicaciones13.documentos.impresion.elementos.texto;

import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.layout.Style;
import com.itextpdf.layout.element.Text;

/**
 * Objeto para imprimir parrafo.
 *
 * @author omargo33
 *
 *
 */
public class P extends Elemento {

    public static final float NOTA = 6f; //Tamaño 6 px
    public static final float PARRAFO = 10f; //Tamaño 10 px
    public static final float TEXTO = 8f; //Tamaño 8 px
    
    private float tamano;

    /**
     * Metodo para crear el objeto.
     *
     * @param tamano
     */
    public P(float tamano) {
        this("", tamano);
        this.tamano=tamano;
    }

    /**
     * @param texto
     * @param tamano
     */
    public P(String texto, float tamano) {
        super();
        this.tamano=tamano;
        init(texto, tamano);
    }

    /**
     * Metodo para inicialiar el objeto.
     *
     */
    private void init(String texto, float tamano) {
        setTexto(texto);
        getTexto().setFontSize(tamano);
        setParagraph(getTexto(),getFontDatos());
        getParagraph().setMultipliedLeading(1.1f);
    }

    /**
     * Metodo para convertir el texto en negritas.
     *
     */
    public void negrita() {
        setParagraph(getTexto(), getFontTitulos());
    }

    /**
     * Metodo para convertir el texto en regular.
     *
     */
    public void regularTexto() {
        setParagraph(getTexto(), getFontDatos());
    }
    
    
    public void addTexto(String titulo, String texto){        
        PdfFont pdfFontTitulo = getFontTitulos();        
        Style estiloTitulo = new Style();
        estiloTitulo.setFont(pdfFontTitulo);                
        estiloTitulo.setFontSize(this.tamano);
        
        PdfFont pdfFontNormal = getFontDatos();        
        Style estiloNormal = new Style();
        estiloNormal.setFont(pdfFontNormal);                
        estiloNormal.setFontSize(this.tamano);
        
        getParagraph().add(new Text(titulo).addStyle(estiloTitulo));
        getParagraph().add(new Text(" ").addStyle(estiloNormal));
        getParagraph().add(new Text(texto).addStyle(estiloNormal));
    }    
}
