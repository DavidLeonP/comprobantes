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

    protected static final String ELEMENTO_1 = "1";
    protected static final String ELEMENTO_2 = "2";
    protected static final String ELEMENTO_3 = "3";
    protected static final String ELEMENTO_4 = "4";
    protected static final String ELEMENTO_5 = "5";
    protected static final String ELEMENTO_6 = "6";
    protected static final String ELEMENTO_7 = "7";
    protected static final String ELEMENTO_8 = "8";
    protected static final String ELEMENTO_9 = "9";
    protected static final String ELEMENTO_10 = "10";
    protected static final String ELEMENTO_11 = "11";
    protected static final String ELEMENTO_12 = "12";
    protected static final String ELEMENTO_13 = "13";
    protected static final String ELEMENTO_14 = "14";
    protected static final String ELEMENTO_15 = "15";
    protected static final String ELEMENTO_16 = "16";
    protected static final String ELEMENTO_17 = "17";
    protected static final String ELEMENTO_18 = "18";

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

    /**
     * Metodo para limpiar los datos.
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
        
        this.elementos = new ArrayList<>();        
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
        try {
            switch (valor) {
                case ELEMENTO_1:
                    elemento1();
                    break;
                case ELEMENTO_2:
                    elemento2();
                    break;
                case ELEMENTO_3:
                    elemento3();
                    break;
                case ELEMENTO_4:
                    elemento4();
                    break;
                case ELEMENTO_5:
                    elemento5();
                    break;
                case ELEMENTO_6:
                    elemento6();
                    break;
                case ELEMENTO_7:
                    elemento7();
                    break;
                case ELEMENTO_8:
                    elemento8();
                    break;
                case ELEMENTO_9:
                    elemento9();
                    break;
                default:
                    imprimirElemento1(valor);
                    break;
            }
        } catch (Exception e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, valor);
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, e.toString());
        }
    }

    /**
     * Metodo para imprimir los elementos en el orden solicitado.
     * 
     * @param valor
     */
    private void imprimirElemento1(String valor) {
        try {
            switch (valor) {
                case ELEMENTO_10:
                    elemento10();
                    break;
                case ELEMENTO_11:
                    elemento11();
                    break;
                case ELEMENTO_12:
                    elemento12();
                    break;
                case ELEMENTO_13:
                    elemento13();
                    break;
                case ELEMENTO_14:
                    elemento14();
                    break;
                case ELEMENTO_15:
                    elemento15();
                    break;
                case ELEMENTO_16:
                    elemento16();
                    break;
                case ELEMENTO_17:
                    elemento17();
                    break;
                case ELEMENTO_18:
                    elemento18();
                    break;
                default:
                    elemento1();
                    break;
            }
        } catch (Exception e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, valor);
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, e.toString());
        }
    }
    
    private synchronized void elemento1() {
        Pie pie = new Pie();
        getPdfWriter().setPageEvent(pie);
    }

    protected void elemento2() {
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, "elemento 2");
    }

    protected void elemento3() {
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, "elemento 3");
    }

    protected void elemento4() {
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, "elemento 4");
    }

    protected void elemento5() {
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, "elemento 5");
    }

    protected void elemento6() {
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, "elemento 6");
    }

    protected void elemento7() {
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, "elemento 7");
    }

    protected void elemento8() {
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, "elemento 8");
    }

    protected void elemento9() {
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, "elemento 9");
    }

    protected void elemento10() {
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, "elemento 10");
    }

    protected void elemento11() {
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, "elemento 11");
    }

    protected void elemento12() {
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, "elemento 12");
    }

    protected void elemento13() {
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, "elemento 13");
    }

    protected void elemento14() {
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, "elemento 14");
    }

    protected void elemento15() {
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, "elemento 15");
    }

    protected void elemento16() {
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, "elemento 16");
    }

    protected void elemento17() {
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, "elemento 17");
    }

    protected void elemento18() {
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, "elemento 18");
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
