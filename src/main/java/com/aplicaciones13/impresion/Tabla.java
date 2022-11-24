package com.aplicaciones13.impresion;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase de escribir una tabla
 *
 * @author o.velez@13aplicaciones.com
 *
 */
public class Tabla extends Elemento {

    private int columnaTextoSumatoria;
    private boolean titulos;
    private double[] listaTotales;
    private String textoSumatoria;
    private List<String> listaAlineacion;
    private List<String> listaSumatorias;
    private List<String> listaTitulos;
    private List<Object> listaDatos;

    /**
     * Metodo para crear la clase.
     * Inicializa MainSQL
     * Limpia datos de la tabla.
     */
    public Tabla() {
        super();
        limpiarTabla();
    }

    /**
     * Metodo para limpiar los datos del sitema.
     *
     */
    public void limpiarTabla() {
        getFontDatos().setSize(8);
        getFontTitulos().setSize(8);
        getFontTitulos().setStyle(Font.BOLD);
        setListaSumatorias(new ArrayList<>());
        setAncho(100);
        setTextoSumatoria("");
        setTitulos(true);
        setColumnaTextoSumatoria(0);
        setListaTitulos(new ArrayList<>());
        setListaDatos(new ArrayList<>());
    }

    /**
     * Metodo para escribir la tabla con un metodo comun.
     *
     */
    public void escribe() {
        PdfPTable tablaTemporal = escribeTabla();
        try {
            if (tablaTemporal != null)
                getDocumento().add(tablaTemporal);
        } catch (DocumentException e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING,
                    e.toString());
        }
    }

    /**
     * Metodo para escribir la tabla con un metodo comun.
     *
     */
    public PdfPCell escribeCelda() {
        PdfPCell pdfPCell = new PdfPCell();
        PdfPTable tablaTemporal = escribeTabla();

        if (tablaTemporal != null)
            pdfPCell.addElement(tablaTemporal);
        return pdfPCell;

    }

    /**
     * Metodo de escritura de una tabla.
     *
     * Obtiene en numero de columnas
     * Si no estan formateadas todas las columnas
     * Notifica
     * Retorna
     * Si no estan dimensionadas todas las columnas
     * Notifica
     * Retorna
     * Si no hay datos
     * Retorna
     * Se agrega las columnas que puede totalizar
     * Se crea la tabla, se pone dimesiones, alineamiento y encabezado
     * Se verifica si hay encabezados
     * De haber encabezados se los escribe
     * Se llena los datos de las tablas
     * Si hay sumatorias se las realiza.
     * Se muestra las sumatorias de haberlas
     *
     */
    public PdfPTable escribeTabla() {
        try {
            if (getListaFormatos().size() != getListaTitulos().size()) {
                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.INFO,
                        "No estan formateadas todas las columnas");
                return null;
            }

            if (getListaDimensiones().size() != getListaTitulos().size()) {
                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.INFO,
                        "No estan dimensionadas todas las columnas");
                return null;
            }

            setListaTotales(getListaTitulos().size());
            final PdfPTable table = new PdfPTable(getListaTitulos().size());
            table.setWidthPercentage(getAncho());
            table.setTotalWidth(getArrayDimensiones());
            table.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.setHeaderRows(1);
            // imprime los encabezados de una columna
            if (isTitulos())
                for (String a : getListaTitulos()) {
                    setParagraphCapital(a, getFontTitulos());
                    PdfPCell cell = new PdfPCell(getParagraph());
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setBorderWidthLeft(0);
                    cell.setBorderWidthRight(0);
                    cell.setBorderWidthTop(0);
                    table.addCell(cell);
                }
            // Se llena los datos
            for (Object a : getListaDatos()) {
                for (int j = 0; j < getListaTitulos().size(); j++) {
                    setParagraphCapital(datoFormato(((List<String>)a).get(j),
                            getListaFormatos().get(j),
                            j + 1), getFontDatos());
                    PdfPCell cell = new PdfPCell(getParagraph());
                    cell.setBorder(0);
                    alinear(getListaTitulos().size(), cell, j);
                    table.addCell(cell);
                }
            }

            return table;
        } catch (DocumentException e2) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING,
                    e2.toString());            
        }
        return null;
    }

    /**
     * Metodo para dar formato a la sumatoria de forma automática
     *
     * @param tipoFormato
     * @param dato
     * @return
     */
    public String datoFormatoSumatoria(String tipoFormato, String dato) {
        if (tipoFormato.equalsIgnoreCase(FORMATO_ENTERO))
            return formatearInt(dato);
        if (tipoFormato.equalsIgnoreCase(FORMATO_DOUBLE))
            return formatearDouble(dato);
        if (tipoFormato.equalsIgnoreCase(FORMATO_MONEDA))
            return formatearDinero(dato);
        if (tipoFormato.equalsIgnoreCase(FORMATO_MONEDA_SIGNO))
            return formatearDineroSigno(dato);
        return "";
    }

    /**
     * Formato del texto a poner, dependiendo del texto que se pone, hace
     * sumatorias.
     *
     * @param valores
     * @param tipoFormato
     * @param indice
     * @return
     */
    public String datoFormato(String valores, String tipoFormato, int indice) {
        String dato = super.datoFormato(valores, tipoFormato);
        if (dato.trim().length() == 0) {
            return "";
        }

        if (tipoFormato.equalsIgnoreCase(FORMATO_ENTERO)) {
            getListaTotales()[indice - 1] = getListaTotales()[indice - 1]
                    + Double.parseDouble(valores.replace(".", ","));
        }
        if (tipoFormato.equalsIgnoreCase(FORMATO_DOUBLE)) {
            getListaTotales()[indice - 1] = getListaTotales()[indice - 1]
                    + Double.parseDouble(valores.replace(".", ","));
        }
        if (tipoFormato.equalsIgnoreCase(FORMATO_MONEDA)) {
            getListaTotales()[indice - 1] = getListaTotales()[indice - 1]
                    + Double.parseDouble(valores.replace(".", ","));
        }
        if (tipoFormato.equalsIgnoreCase(FORMATO_MONEDA_SIGNO)) {
            getListaTotales()[indice - 1] = getListaTotales()[indice - 1]
                    + Double.parseDouble(valores.replace(".", ","));
        }
        return dato;
    }

    /**
     * Alinear los datos del sistema.
     *
     * @param columnas
     * @param cell
     * @param indice
     */
    public void alinear(int columnas, PdfPCell cell, int indice) {
        if (getListaAlineacion().size() == columnas)
            cell.setHorizontalAlignment(Integer.parseInt(getListaAlineacion().get(indice)));
        else
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
    }

    // Propiedades
    public List<String> getListaAlineacion() {
        return this.listaAlineacion;
    }

    public void setListaAlineacion(List<String> listaAlineacion) {
        this.listaAlineacion = listaAlineacion;
    }

    public void setListaAlineacion(Object... formatos) {
        this.listaAlineacion = new ArrayList<>();
        for (int i = 0; i < formatos.length; i++) {
            this.listaAlineacion.add(formatos[i].toString());
        }
    }

    public List<String> getListaSumatorias() {
        if (this.listaSumatorias == null) {
            this.listaSumatorias = new ArrayList<>();
        }
        return this.listaSumatorias;
    }

    public void setListaSumatorias(List<String> listaSumatorias) {
        this.listaSumatorias = listaSumatorias;
    }

    public void setListaSumatorias(Object... formatos) {
        this.listaSumatorias = new ArrayList<>();
        for (int i = 0; i < formatos.length; i++) {
            this.listaSumatorias.add(formatos[i].toString());
        }
    }

    public double[] getListaTotales() {
        return this.listaTotales;
    }

    public void setListaTotales(double[] listaTotales) {
        this.listaTotales = listaTotales;
    }

    public void setListaTotales(int celdas) {
        this.listaTotales = new double[celdas];
        for (int i = 0; i < celdas; i++) {
            this.listaTotales[i] = 0;
        }
    }

    public boolean esVisible(int i) {
        for (String valor : this.listaSumatorias) {
            if (valor.equalsIgnoreCase(String.valueOf(i))) {
                return true;
            }
        }
        return false;
    }

    public String getTextoSumatoria() {
        return this.textoSumatoria;
    }

    public void setTextoSumatoria(String textoSumatoria) {
        this.textoSumatoria = textoSumatoria;
    }

    public boolean isTitulos() {
        return this.titulos;
    }

    public void setTitulos(boolean titulos) {
        this.titulos = titulos;
    }

    public int getColumnaTextoSumatoria() {
        return this.columnaTextoSumatoria;
    }

    public void setColumnaTextoSumatoria(int columnaTextoSumatoria) {
        this.columnaTextoSumatoria = columnaTextoSumatoria;
    }

    public List<String> getListaTitulos() {
        return this.listaTitulos;
    }

    public void setListaTitulos(List<String> listaTitulos) {
        this.listaTitulos = listaTitulos;
    }

    public void setListaTitulos(Object... formatos) {
        this.listaTitulos = new ArrayList<>();
        for (int i = 0; i < formatos.length; i++) {
            this.listaTitulos.add(formatos[i].toString());
        }
    }

    public void setListaTitulos(String[] formatos) {
        this.listaTitulos = new ArrayList<>();
        for (int i = 0; i < formatos.length; i++) {
            this.listaTitulos.add(String.valueOf(formatos[i]));
        }
    }

    public List<Object> getListaDatos() {
        return this.listaDatos;
    }

    public void setListaDatos(List<Object> listaDatos) {
        this.listaDatos = listaDatos;
    }
}
