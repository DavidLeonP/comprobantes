/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplicaciones13.documentos.impresion.elementos.compuestos;

import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import com.aplicaciones13.documentos.impresion.elementos.texto.P;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

import java.util.List;
import com.itextpdf.kernel.colors.Color;
/**
 * Objeto presentar una tabla.
 *
 * @author omargo33
 *
 */

@Slf4j
@Data
@EqualsAndHashCode(callSuper = true)
public class Tabla extends Conjunto implements ConjuntoInterface {

    private List<Object[]> listaValores;
    private boolean sumatoria=false;
    private boolean bandasPresentacion=false;
    Color colorFondo = new DeviceRgb( 223, 224, 226  );

    /**
     * Metodo para crear la clase. Inicializa SQLBase Limpia datos de la tabla.
     */
    public Tabla() {
        super();
        initTabla();
    }

    /**
     * Metodo para inicializar el objeto.
     *
     */
    private void initTabla() {
        this.listaValores = new ArrayList<>();
        colorFondo = new DeviceRgb( 128, 128, 128  );
    }

    /**
     * Metodo de escritura de una tabla.Obtiene en numero de columnas Si no
     * estan formateadas todas las columnas Notifica Retorna Si no estan
     * dimensionadas todas las columnas Notifica Retorna Si no hay datos Retorna
     * Se agrega las columnas que puede totalizar Se crea la tabla, se pone
     * dimesiones, alineamiento y encabezado Se verifica si hay encabezados De
     * haber encabezados se los escribe Se llena los datos de las tablas Si hay
     * sumatorias se las realiza.
     *
     * Se muestra las sumatorias de haberlas
     *
     */
    @Override
    public void procesar() {
        boolean colorActivo = true;
        if (getListaDimensiones().size() != getListaFormatos().size()) {
            log.warn(".tabla()");
            return;
        }

        setTabla(new Table(getArrayDimensiones()));

        for (String a : getListaTitulos()) {
            P pTitulo = new P(a, P.TEXTO);
            pTitulo.negrita();
            Cell cell = new Cell();
            cell.add(pTitulo.getParagraph());
            cell.setTextAlignment(TextAlignment.CENTER);
            cell.setBorderLeft(Border.NO_BORDER);
            cell.setBorderRight(Border.NO_BORDER);
            cell.setBorderTop(Border.NO_BORDER);
            getTabla().addHeaderCell(cell);
        }

        for (Object[] fila : listaValores) {
            int columna = 0;
            colorActivo = !colorActivo;
            for (Object celda : fila) {
                P pValor = new P(darFormatoManual(celda, getListaFormatos().get(columna)), P.TEXTO);
                if (isSumatoria()) {
                    pValor.negrita();
                }
                Cell cell = new Cell();
                cell.add(pValor.getParagraph());
                cell.setBorder(Border.NO_BORDER);
            
                if(colorActivo && bandasPresentacion){
                    cell.setBackgroundColor(colorFondo);
                }
            
                cell.setTextAlignment(getAlineamientoColumna(columna, TextAlignment.LEFT));
                getTabla().addCell(cell);
                columna++;
            }
        }
    }    
}
