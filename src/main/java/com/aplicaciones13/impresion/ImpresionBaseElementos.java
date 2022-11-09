package com.aplicaciones13.impresion;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase base para la generación de elementos.
 *
 * @author omarv omargo33@JeremiasSoft.com
 *
 *
 */
public class ImpresionBaseElementos {

    private List<String> elementos;
    private Document documento;
    private Espacio espacio;
    private Form form;
    private H1 h1;
    private H2 h2;
    private H3 h3;
    private Imagen imagen;
    private Imagen imagen1;
    private Linea linea;
    private P p;
    private Tabla tabla;
    private PdfWriter pdfWriter;

    /**
     * Metodo para crear el objeto.
     *
     */
    public ImpresionBaseElementos() {
        limpiar();
    }

    /**Metodo para limpiar los datos.
     *
     */
    public void limpiar() {
        setEspacio(new Espacio());
        getEspacio().setDocumento(getDocumento());
        setForm(new Form());
        getForm().setDocumento(getDocumento());
        setH1(new H1());
        getH1().setDocumento(getDocumento());
        setH2(new H2());
        getH2().setDocumento(getDocumento());
        setH3(new H3());
        getH3().setDocumento(getDocumento());
        setImagen(new Imagen());
        getImagen().setDocumento(getDocumento());
        
        setImagen1(new Imagen());
        getImagen1().setDocumento(getDocumento());

        
        setLinea(new Linea());        
        getLinea().setDocumento(getDocumento());
        setP(new P());
        getP().setDocumento(getDocumento());
        setTabla(new Tabla());
        getTabla().setDocumento(getDocumento());
        setElementos(new ArrayList<String>());
        setPdfWriter(null);
    }

    /**
     * Escribir los datos en el documento.
     *
     * Fija los tamanos de la hoja
     * Fija los marjenes de la hoja
     * Fija el encabezado y pie de pagina membretado.
     * Pone el titulo del documento.
     *
     * Lla los elementos a ser impresos.
     *
     */
    public void escribir() {
        for (String e : getElementos()) {
            imprimirElemento(e);
        }
    }

    /**
     * Lista los elementos a imprimir.
     *
     * @param parametros
     */
    public void elementosAImprimir(Object... parametros) {
        for (int i = 0; i < parametros.length; i++) {
            getElementos().add(String.valueOf(parametros[i]));
        }
    }

    /**
     * Metod para imprimir los elementos en el orden solicitado.
     *
     * @param valor
     */
    public void imprimirElemento(String valor) {
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.INFO, valor);
    }

    // Propiedades
    public Document getDocumento() {
        return this.documento;
    }

    public void setDocumento(Document documento) {
        this.documento = documento;
        limpiar();
    }

    public Espacio getEspacio() {
        return espacio;
    }

    public void setEspacio(Espacio espacio) {
        this.espacio = espacio;
    }

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public H1 getH1() {
        return h1;
    }

    public void setH1(H1 h1) {
        this.h1 = h1;
    }

    public H2 getH2() {
        return h2;
    }

    public void setH2(H2 h2) {
        this.h2 = h2;
    }

    public H3 getH3() {
        return h3;
    }

    public void setH3(H3 h3) {
        this.h3 = h3;
    }

    public Imagen getImagen() {
        return imagen;
    }

    public Imagen getImagen1() {
        return imagen1;
    }

    public void setImagen(Imagen imagen) {
        this.imagen = imagen;
    }

    public void setImagen1(Imagen imagen1) {
        this.imagen1 = imagen1;
    }

    public Linea getLinea() {
        return linea;
    }

    public void setLinea(Linea linea) {
        this.linea = linea;
    }

    public P getP() {
        return p;
    }

    public void setP(P p) {
        this.p = p;
    }

    public Tabla getTabla() {
        return tabla;
    }

    public void setTabla(Tabla tabla) {
        this.tabla = tabla;
    }

    public List<String> getElementos() {
        return elementos;
    }

    public void setElementos(List<String> elementos) {
        this.elementos = elementos;
    }

    public PdfWriter getPdfWriter() {
        return pdfWriter;
    }

    public void setPdfWriter(PdfWriter pdfWriter) {
        this.pdfWriter = pdfWriter;
    }

    /**
     * Metodo para saltar espacios
     *
     * @param j
     */
    public void espacios(int j) {
        while (j > 0) {
            getEspacio().escribe();
            j--;
        }
    }
}
