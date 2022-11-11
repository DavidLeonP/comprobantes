package com.aplicaciones13.impresion;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Objeto Para escribir en forma de un formulario
 *
 * @author omarv omargo33@JeremiasSoft.com
 *
 */
public class Form extends Elemento {
    private List<String> listaPaneles;    
    private List<String> listaCamposAlineadosDerecha;
    private List<String> listaTitulos;
    private List<String> listaValores;
    private List<PdfPTable> listaPdfPTable;

    /**
     * Metodo que crea la clase.
     *
     */
    public Form() {
        super();        
        getFontDatos().setSize(8);
        getFontTitulos().setSize(8);
        getFontTitulos().setStyle(Font.BOLD);
        setAncho(100);
        listaPaneles = new ArrayList<>();
        listaCamposAlineadosDerecha = new ArrayList<>();
    }

    /**
     * Metodo que escribe en el documento la form o su conjunto.
     *
     * Si hay tabla la escribe.
     *
     * Reinicia los valores de paneles y alineamiento.
     *
     */
    public void escribe() {
        try {
            PdfPTable tablaTemporal = escribeForm();
            if (tablaTemporal != null)
                getDocumento().add(tablaTemporal);

        } catch (DocumentException e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE,
                    e.toString());
        }

        listaPaneles = new ArrayList<>();
        listaCamposAlineadosDerecha = new ArrayList<>();
        setListaValores(new ArrayList<>());
        setListaTitulos(new ArrayList<>());
        setListaFormatos(new ArrayList<>());
    }

    /**
     * Metodo que escribe en el documento la form o su conjunto.
     *
     * Si hay tabla la escribe.
     *
     * Reinicia los valores de paneles y alineamiento.
     *
     */
    public PdfPCell escribeCelda() {
        PdfPCell pdfPCell = new PdfPCell();
        pdfPCell.setBorder(Rectangle.NO_BORDER);
        PdfPTable tablaTemporal = escribeForm();

        if (tablaTemporal != null)
            pdfPCell.addElement(tablaTemporal);

        listaPaneles = new ArrayList<>();
        listaCamposAlineadosDerecha = new ArrayList<>();
        setListaValores(new ArrayList<>());
        setListaTitulos(new ArrayList<>());
        setListaFormatos(new ArrayList<>());

        return pdfPCell;
    }

    /**
     * Listado de campos que marcan fin de panel
     *
     * @param paneles
     */
    public void setListaPaneles(Object... paneles) {
        listaPaneles = new ArrayList<>();
        for (int i = 0; i < paneles.length; i++){
            listaPaneles.add(paneles[i].toString());
        }
    }

    /**
     * Listado de campos que marcan fin de panel
     *
     * @param campos
     */
    public void setListaCamposAlineadosDerecha(Object... campos) {
        listaCamposAlineadosDerecha = new ArrayList<>();
        for (int i = 0; i < campos.length; i++){
            listaCamposAlineadosDerecha.add(campos[i].toString());
        }
    }

    public List<String> getListaCamposAlineadosDerecha() {
        return listaCamposAlineadosDerecha;
    }

    /**
     * Metodo para saber si un campo esta alineado a la derecha o la izquierda
     *
     * @param columna
     * @return
     */
    private boolean esDerecha(int columna) {
        for (String a : listaCamposAlineadosDerecha){
            if (a.equalsIgnoreCase( String.valueOf(columna))){
                return true;
            }
        }

        return false;
    }

    /**
     * Metodo de escritura de un form.
     * Si no esta formateados todas las columnas
     * Informa
     * Retorna
     * Si no estan dimencionados los dos columnas
     * Informa
     * Retorna
     * Si no es una unica fila
     * Informa
     * Retorna
     * Escribe la tabla
     *
     */
    public PdfPTable escribeForm() {
        try {
            if (getListaFormatos().size() != getListaTitulos().size()) {
                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE,
                        "No estan formateadas todas las columnas\"");
                return null;
            }

            if (getListaDimensiones().size() != 2) {
                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE,
                        "No estan dimensionadas todas las columnas");
                return null;
            }

            if (getListaValores().isEmpty()) {
                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE,
                        "Consulta no devuelve una unica fila");
                return null;
            }

            if (getListaFormatos().size() != getListaValores().size()) {
                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE,
                        "El numero de titulos y de valores no coincide");
                return null;
            }

            generaTablas();

            for (int i = 0; i < getListaFormatos().size(); i++) {
                setParagraphCapital(getListaTitulos().get(i),
                        getFontTitulos());
                Paragraph titulo = getParagraph();

                setParagraph(datoFormato(getListaValores().get(i),
                        getListaFormatos().get(i)),
                        getFontDatos());

                Paragraph dato = getParagraph();
                ingresaDatosTabla(i, titulo, dato);
            }
            return generaRespuesta();
        } catch (DocumentException e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE,
                    e.toString());
        }
        return null;
    }

    public List<String> getListaTitulos() {
        return listaTitulos;
    }

    public void setListaTitulos(List<String> listaTitulos) {
        this.listaTitulos = listaTitulos;
    }

    public void setListaTitulos(Object... formatos) {
        this.listaTitulos = new ArrayList<>();
        for (int i = 0; i < formatos.length; i++){
            this.listaTitulos.add(formatos[i].toString());
        }
    }

    public List<String> getListaValores() {
        return listaValores;
    }

    public void setListaValores(List<String> listaValores) {
        this.listaValores = listaValores;
    }

    public void setListaValores(Object... formatos) {
        this.listaValores = new ArrayList<>();
        for (int i = 0; i < formatos.length; i++)
            this.listaValores.add((formatos[i] == null) ? "" : formatos[i].toString());
    }

    /**
     * Metodo para generar la respuesta ya sea para una sola form o para un conjunto
     * de forms
     *
     * @return
     */
    private PdfPTable generaRespuesta() throws DocumentException {
        if (listaPaneles.isEmpty())
            return listaPdfPTable.get(0);

        PdfPTable tablaRespuesta = new PdfPTable(listaPaneles.size());
        tablaRespuesta.setWidthPercentage(100);
        if (listaPaneles.size() == 2)
            tablaRespuesta.setTotalWidth(new float[] { 50, 50 });
        if (listaPaneles.size() == 3)
            tablaRespuesta.setTotalWidth(new float[] { 33, 33, 34 });
        if (listaPaneles.size() == 4)
            tablaRespuesta.setTotalWidth(new float[] { 25, 25, 25, 25 });
        if (listaPaneles.size() == 5)
            tablaRespuesta.setTotalWidth(new float[] { 20, 20, 20, 20, 20 });
        if (listaPaneles.size() == 6)
            tablaRespuesta.setTotalWidth(new float[] { 16, 16, 16, 16, 16, 20 });

        tablaRespuesta.setHorizontalAlignment(Element.ALIGN_LEFT);

        for (PdfPTable a : listaPdfPTable) {
            PdfPCell cell = new PdfPCell(a);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell.setVerticalAlignment(Element.ALIGN_TOP);
            cell.setBorder(0);
            tablaRespuesta.addCell(cell);
        }
        return tablaRespuesta;
    }

    /**
     * Metodo para generar las tablas que van a soportar las forms dividadas.
     *
     * @throws DocumentException
     */
    private void generaTablas() throws DocumentException {
        listaPdfPTable = new ArrayList<>();

        if (listaPaneles.isEmpty()) {
            PdfPTable table = new PdfPTable(2);
            table.setWidthPercentage(getAncho());
            table.setTotalWidth(getArrayDimensiones());
            table.setHorizontalAlignment(Element.ALIGN_LEFT);
            listaPdfPTable.add(table);
        } else{            
            for (int i=0; i< listaPaneles.size(); i++) {            
                PdfPTable table = new PdfPTable(2);
                table.setTotalWidth(getArrayDimensiones());
                table.setHorizontalAlignment(Element.ALIGN_LEFT);
                listaPdfPTable.add(table);
            }
        }
    }

    /**
     * Metodo para ingresar los datos en la tabla correcta.
     *
     * Pone el formato al nombre del campo.
     * Pone el alineamiento al dato.
     * Pone el formato al dato.
     *
     */
    private void ingresaDatosTabla(int columna, Paragraph titulo,
            Paragraph dato) {
        int panel = buscaPanel(columna);

        PdfPCell cell = new PdfPCell(titulo);
        cell.setBorder(0);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        listaPdfPTable.get(panel).addCell(cell);

        cell = new PdfPCell(dato);
        cell.setBorder(0);
        if (!esDerecha(columna))
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        else
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        listaPdfPTable.get(panel).addCell(cell);
    }

    /**
     * Metodo para buscar un panel ingresado en la lista de panels.
     *
     */
    private int buscaPanel(int columna) {
        int i = 0;
        int j = 0;
        for (String a : listaPaneles) {
            if (columna >  Integer.parseInt(a)){
                j = i + 1;
            }
            i++;
        }
        return j;
    }
}
