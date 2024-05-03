package com.aplicaciones13.documentos.impresion.ensamble.ride;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import java.util.Map;

import com.aplicaciones13.documentos.utilidades.Bundle;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Clase para soportar los totales de los documentos.
 * 
 * @author omargo33
 * @since 202-05-01
 */
@Data
public class Totales {
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    LinkedHashMap<String, String> listaElementosTotales = new LinkedHashMap<>();

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    List<UnidadValor> listaUnidadesValor = new ArrayList<>();

    String subTotal = "0";
    String totalDescuento = "0";
    String propina = "0";
    String[] arregloTitulos;
    Object[] arregloValores;
    List<String> listaTitulosNoRequeridos;
    
    private static Bundle bundle = new Bundle("elementos-ride");

    /**
     * Metodo para leer los valores de los subtotales.
     * 
     * Crea una entrada para cada uno de los valores en la lsita de elementos a
     * ejecutar.
     * 
     */
    private void leerValores() {
        listaElementosTotales.put("tabla21_2_2",
                buscarCodigoUnidadValorYCodigoPorcentaje("2", "2").getBaseImponible());
        listaElementosTotales.put("tabla21_2_10",
                buscarCodigoUnidadValorYCodigoPorcentaje("2", "10").getBaseImponible());
        listaElementosTotales.put("tabla21_2_3",
                buscarCodigoUnidadValorYCodigoPorcentaje("2", "3").getBaseImponible());
        listaElementosTotales.put("tabla21_2_4",
                buscarCodigoUnidadValorYCodigoPorcentaje("2", "4").getBaseImponible());
        listaElementosTotales.put("tabla21_2_5",
                buscarCodigoUnidadValorYCodigoPorcentaje("2", "5").getBaseImponible());
        listaElementosTotales.put("tabla21_2_0",
                buscarCodigoUnidadValorYCodigoPorcentaje("2", "0").getBaseImponible());
        listaElementosTotales.put("tabla21_2_6",
                buscarCodigoUnidadValorYCodigoPorcentaje("2", "6").getBaseImponible());
        listaElementosTotales.put("tabla21_2_7",
                buscarCodigoUnidadValorYCodigoPorcentaje("2", "7").getBaseImponible());
        listaElementosTotales.put("tabla21_2_8",
                buscarCodigoUnidadValorYCodigoPorcentaje("2", "8").getBaseImponible());
        listaElementosTotales.put("tabla21_200", subTotal);
        listaElementosTotales.put("tabla21_210", totalDescuento);
        listaElementosTotales.put("tabla21_3",
                buscarCodigoUnidadValor("3").getValor());
        listaElementosTotales.put("tabla21_5",
                buscarCodigoUnidadValor("5").getValor());
        listaElementosTotales.put("tabla21_20_2",
                buscarCodigoUnidadValorYCodigoPorcentaje("2", "2").getValor());
        listaElementosTotales.put("tabla21_20_10",
                buscarCodigoUnidadValorYCodigoPorcentaje("2", "10").getValor());
        listaElementosTotales.put("tabla21_20_3",
                buscarCodigoUnidadValorYCodigoPorcentaje("2", "3").getValor());
        listaElementosTotales.put("tabla21_20_4",
                buscarCodigoUnidadValorYCodigoPorcentaje("2", "4").getValor());
        listaElementosTotales.put("tabla21_20_5",
                buscarCodigoUnidadValorYCodigoPorcentaje("2", "5").getValor());
        listaElementosTotales.put("tabla21_20_8",
                buscarCodigoUnidadValorYCodigoPorcentaje("2", "8").getValor());
        listaElementosTotales.put("tabla21_9", propina);
    }

    /**
     * Metodo para procesar los valores y los subtotales para la impresion.
     * 
     * Si los Titulos no son requeridos se eliminan de la lista de elementos si
     * tienen valor cero.
     * 
     * Luego se llena los dato de titulos y valores al barrer la lista de elementos
     * 
     */
    public void procesar() {
        String valorEvaluar = "";
        leerValores();

        for (String a : listaTitulosNoRequeridos) {
            valorEvaluar = listaElementosTotales.get(a);
            if (valorEvaluar == null || valorEvaluar.equals("0.00") || valorEvaluar.equals("0")) {
                listaElementosTotales.remove(a);
            }
        }

        arregloTitulos = new String[listaElementosTotales.size()];
        arregloValores = new Object[listaElementosTotales.size()];

        int i = 0;
        for (Map.Entry<String, String> entry : listaElementosTotales.entrySet()) {
            arregloTitulos[i] = bundle.getMessage(entry.getKey());
            arregloValores[i] = entry.getValue();
            i++;
        }
    }

    /**
     * Metodo para cargar inforamcion adicional.
     * 
     * @param codigo
     * @param codigoPorcentaje
     * @param tarifa
     * @param baseImponible
     * @param valor
     */
    public void cargarData(String codigo, String codigoPorcentaje, String tarifa, String baseImponible,
            String valor) {
        if (listaUnidadesValor == null) {
            listaUnidadesValor = new ArrayList<>();
        }

        UnidadValor impuesto = new UnidadValor(codigo, codigoPorcentaje, tarifa, baseImponible, valor);
        listaUnidadesValor.add(impuesto);
    }

    /**
     * Metodo para buscar un codigo de impuesto
     * 
     * @param codigo
     * @return
     */
    private UnidadValor buscarCodigoUnidadValor(String codigo) {
        for (UnidadValor unidadValor : listaUnidadesValor) {
            if (unidadValor.getCodigo().equals(codigo)) {
                return unidadValor;
            }
        }
        return new UnidadValor();
    }

    /**
     * Metodo para buscar codigo de impuesto y concepto
     */
    private UnidadValor buscarCodigoUnidadValorYCodigoPorcentaje(String codigo, String codigoPorcentaje) {
        for (UnidadValor unidadValor : listaUnidadesValor) {
            if (unidadValor.getCodigo().equals(codigo) &&
                    unidadValor.getCodigoPorcentaje().equals(codigoPorcentaje)) {
                return unidadValor;
            }
        }
        return new UnidadValor();
    }

    /**
     * Metodo para asignar los titulos no requeridos.
     * 
     * @param columnas
     */
    public void setListaTitulosNoRequeridos(String... columnas) {
        this.listaTitulosNoRequeridos = new ArrayList<>();
        this.listaTitulosNoRequeridos.addAll(Arrays.asList(columnas));
    }

    @Data
    public class ElementoTotal {
        String titulo;
        String valor;

        public ElementoTotal(String titulo, String valor) {
            setTitulo(titulo);
            setValor(valor);
        }
    }

    @Data
    @AllArgsConstructor
    public class UnidadValor {
        String codigo;
        String codigoPorcentaje;
        String tarifa;
        String baseImponible;
        String valor;

        /**
         * Metodo para crear el obteto vacio.
         */
        public UnidadValor() {
            setCodigo("");
            setCodigoPorcentaje("");
            setTarifa("0");
            setBaseImponible("0");
            setValor("0");
        }
    }
}
