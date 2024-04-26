/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplicaciones13.documentos.impresion.elementos.compuestos;

import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.IBlockElement;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.HorizontalAlignment;
import com.itextpdf.layout.properties.TextAlignment;
import com.aplicaciones13.documentos.impresion.elementos.texto.P;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Objeto para generar paneles de presetacion lateral.
 *
 * @author omargo33
 *
 */
public class Panel extends Conjunto implements ConjuntoInterface{

    private List<Object> listaCeldas;

    /**
     * Metodo para crear el objeto.
     *
     */
    public Panel() {
        super();
        initPanel();
    }

    /**
     * Metodo para inicializar el objeto.
     *
     */
    private void initPanel() {
        this.listaCeldas = new ArrayList<>();
    }

    /**
     * Metodo para generar la tabla.
     *
     */
    @Override
    public void procesar() {
        
        setTabla(new Table(getArrayDimensiones()));

        for (String a : getListaTitulos()) {
            P pTitulo = new P(a, P.PARRAFO);
            pTitulo.negrita();
            Cell cell = new Cell();
            cell.add(pTitulo.getParagraph());
            cell.setHorizontalAlignment(HorizontalAlignment.CENTER);
            cell.setBorderLeft(Border.NO_BORDER);
            cell.setBorderRight(Border.NO_BORDER);
            getTabla().addHeaderCell(cell);
        }

        int columna = 0;
        for (Object celda : listaCeldas) {
            Cell cell = new Cell();
            cell.add((IBlockElement) celda);
            cell.setTextAlignment(getAlineamientoColumna(columna, TextAlignment.LEFT));
            cell.setBorder(Border.NO_BORDER);
            getTabla().addCell(cell);
            columna++;
        }
    }

    /**
     * Obtiene la lista de celdas.
     * 
     * @param celdas 
     */
    public void setListaCeldas(Object... celdas) {
        listaCeldas = new ArrayList<>();
        listaCeldas.addAll(Arrays.asList(celdas));
    }
}
