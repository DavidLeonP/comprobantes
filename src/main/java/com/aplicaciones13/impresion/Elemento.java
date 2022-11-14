package com.aplicaciones13.impresion;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.GrayColor;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;
import javax.swing.text.InternationalFormatter;

/**
 * Clase con los datos esenciales para la escritura del archivo PDF.
 *
 * @author o.velez@13aplicaciones.com
 *
 */
public class Elemento {
    private int x; 
    private int y;
    private int largo;
    private int ancho;
    private String texto;

    public static final String FORMATO_STRING = "1";
    public static final String FORMATO_FECHA = "2";
    public static final String FORMATO_MONEDA = "3";
    public static final String FORMATO_MONEDA_SIGNO = "4";
    public static final String FORMATO_DOUBLE = "5";
    public static final String FORMATO_FECHA_HORA = "6";
    public static final String FORMATO_ENTERO = "7";

    private Document documento;

    private List<String> listaFormatos;
    private List<String> listaDimensiones;

    private Font fontTitulos;
    private Font fontDatos;
    private Font fontMarcaAgua;
    private Paragraph paragraph;
    private Phrase phrase;

    /**
     * Metodo para crear el objeto.
     *
     */
    public Elemento() {
        limpiar();
    }

    /**
     * Metodo para dar formato de muestra a los datos basicos que el sistema
     * utiliza.
     *
     * @param valores
     * @param tipoFormato
     * @return
     */
    public String datoFormato(String valores, String tipoFormato) {
        if (valores == null)
            return "";
        if (tipoFormato.equalsIgnoreCase(FORMATO_ENTERO))
            return formatearInt(valores.trim());
        if (tipoFormato.equalsIgnoreCase(FORMATO_DOUBLE))
            return formatearDouble(valores.trim());
        if (tipoFormato.equalsIgnoreCase(FORMATO_FECHA))
            return valores.trim();
        if (tipoFormato.equalsIgnoreCase(FORMATO_FECHA_HORA))
            return valores.trim();
        if (tipoFormato.equalsIgnoreCase(FORMATO_MONEDA))
            return formatearDinero(valores.trim());
        if (tipoFormato.equalsIgnoreCase(FORMATO_MONEDA_SIGNO))
            return formatearDineroSigno(valores.trim());
        if (tipoFormato.equalsIgnoreCase(FORMATO_STRING))
            return valores.trim();
        return "";
    }

    /**
     * Formato para las fechas.
     *
     * @param formato
     * @param fecha
     * @return
     */
    protected static final String fechaFormateada(String formato, Date fecha) {
        SimpleDateFormat miFechaFormato = new SimpleDateFormat(formato);
        return miFechaFormato.format(fecha);
    }

    /**
     * Formato del dinero o moneda que se esta utilizando.
     *
     * @param importe
     * @return
     */
    protected static final String formatearDinero(String importe) {
        try {
            DecimalFormat df2 = new DecimalFormat("###,##0.00;(###,##0.00)",
                    new DecimalFormatSymbols(new Locale("US")));
            return df2.format(Double.parseDouble(importe));
        } catch (Exception e) {
            return null;
        }
    }

    /**
     *
     * @param importe
     * @return
     */
    protected static final String formatearDineroSigno(String importe) {
        try {
            DecimalFormat df2 = new DecimalFormat("'$' ###,##0.00;('$' ###,##0.00)",
                    new DecimalFormatSymbols(new Locale("US")));

            return df2.format(Double.parseDouble(importe));
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Formato de un valor decimal que se este utilizando.
     *
     * @param importe
     * @return
     */
    protected static final String formatearDouble(String importe) {
        InternationalFormatter format = new InternationalFormatter(new java.text.DecimalFormat("##0.00"));
        try {
            return format.valueToString(Double.parseDouble(importe));
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * Formato de un valor decimal que se este utilizando.
     *
     * @param importe
     * @return
     */
    protected static final String formatearInt(String importe) {
        InternationalFormatter format = new InternationalFormatter(new java.text.DecimalFormat("###"));
        try {
            return format.valueToString(Double.parseDouble(importe));
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * Metodo para inicializar los objetos utilizados.
     *
     */
    public void limpiar() {
        setAncho(0);
        setLargo(0);
        setX(0);
        setY(0);
        setDocumento(new Document());
        setFontDatos(FontFactory.getFont("SansSerif"));

        setFontTitulos(FontFactory.getFont("SansSerif"));

        setParagraph(new Paragraph("", getFontTitulos()));
        setTexto("");

        setFontMarcaAgua(FontFactory.getFont("Helvetica"));
        getFontMarcaAgua().setStyle(Font.BOLD);
        getFontMarcaAgua().setColor(new GrayColor(0.67f));

        setPhrase(new Phrase("", getFontDatos()));
    }

    public List<String> getListaFormatos() {
        return this.listaFormatos;
    }

    public void setListaFormatos(List<String> listaFormatos) {
        if (listaFormatos == null) {
            this.listaFormatos = new ArrayList<>();
        } else {
            this.listaFormatos = listaFormatos;
        }
    }

    public void setListaFormatos(Object... formatos) {
        this.listaFormatos = new ArrayList<>();
        for (int i = 0; i < formatos.length; i++) {
            this.listaFormatos.add(formatos[i].toString());
        }
    }

    public List<String> getListaDimensiones() {
        return this.listaDimensiones;
    }

    public float[] getArrayDimensiones() {
        float[] arreglo = new float[this.listaDimensiones.size()];
        float dato = 0;
        for (int i = 0; i < this.listaDimensiones.size(); i++) {
            arreglo[i] = Float.parseFloat(String.valueOf(this.listaDimensiones.get(i))) / 100;
            dato = dato + arreglo[i];
        }

        return arreglo;
    }

    /**
     * Metodo para ingresar dimesions
     *
     * @param listaDimensiones
     */
    public void setListaDimensiones(List<String> listaDimensiones) {
        if (listaDimensiones == null) {
            this.listaDimensiones = new ArrayList<>();
        }

        this.listaDimensiones = listaDimensiones;
    }

    /**
     * Metododo para asignar las dimensiones.
     *
     * @param dimensiones
     */
    public void setListaDimensiones(Object... dimensiones) {
        this.listaDimensiones = new ArrayList<>();
        for (int i = 0; i < dimensiones.length; i++) {
            this.listaDimensiones.add(dimensiones[i].toString());
        }
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getLargo() {
        return this.largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    public int getAncho() {
        return this.ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public Document getDocumento() {
        return this.documento;
    }

    public void setDocumento(Document documento) {
        this.documento = documento;
    }

    public Font getFontTitulos() {
        return this.fontTitulos;
    }

    public void setFontTitulos(Font fontTitulos) {
        this.fontTitulos = fontTitulos;
    }

    public Font getFontDatos() {
        return this.fontDatos;
    }

    public void setFontDatos(Font fontDatos) {
        this.fontDatos = fontDatos;
    }

    public Paragraph getParagraph() {
        return this.paragraph;
    }

    public void setParagraph(Paragraph paragraph) {
        this.paragraph = paragraph;
    }

    public void setParagraph(String texto, Font font) {
        this.paragraph = new Paragraph(texto, font);
    }

    public void setParagraphCapital(String texto, Font font) {
        this.paragraph = new Paragraph(titulo(texto), font);
    }

    /**
     * Metodo para convertir JUAN PEREZ a Juan Perez y/o Juan_perez a Juan Perez.
     *
     * @param nombre
     * @return
     */
    private String titulo(String nombre) {
        if (nombre != null && nombre.trim().length() > 1) {
            String respuesta = "";
            nombre = nombre.replace("_", " ");
            StringTokenizer tokens = new StringTokenizer(nombre);
            while (tokens.hasMoreTokens())
                respuesta = respuesta.concat(" " + tokens.nextToken());
            return respuesta.trim();
        }
        return (nombre == null) ? "." : nombre.trim().toUpperCase();
    }

    public String getTexto() {
        return this.texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Phrase getPhrase() {
        return this.phrase;
    }

    public void setPhrase(Phrase phrase) {
        this.phrase = phrase;
    }

    public void setPhrase(String texto, Font font) {
        this.phrase = new Phrase(texto, font);
    }

    public Font getFontMarcaAgua() {
        this.fontMarcaAgua.setSize(getFontTitulos().getSize() + 7);
        return this.fontMarcaAgua;
    }

    public void setFontMarcaAgua(Font fontMarcaAgua) {
        this.fontMarcaAgua = fontMarcaAgua;
    }
}