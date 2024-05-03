package com.aplicaciones13.documentos.impresion.ensamble.ride;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import com.aplicaciones13.documentos.utilidades.Bundle;

import java.util.ArrayList;

import lombok.AccessLevel;

/**
 * Clase para soportar las formas de pago.
 * 
 * @autor omargo33
 * @since 2021-05-02
 * 
 */
@Data
public class FormasPago {

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    List<Pago> listaFormaPagos = new ArrayList<>();

    String[] arregloTitulos;
    Object[] arregloValores;

    private static Bundle bundle = new Bundle("elementos-ride");
    
    /**
     * Metodo para cargar la data de las formas de pago.
     * 
     * @param formaPago
     * @param total
     * @param plazo
     * @param unidadTiempo
     */
    public void cargarData(String formaPago, String total, String plazo, String unidadTiempo) {
        if (listaFormaPagos == null) {
            listaFormaPagos = new ArrayList<>();
        }

        Pago pago = new Pago(formaPago, total, plazo, unidadTiempo);
        listaFormaPagos.add(pago);
    }

    /**
     * Metodo para procesar la data de las formas de pago.
     * 
     */
    public void procesar(){
        int i=0;
        String formaPagoDinamica = "";

        arregloTitulos = new String[listaFormaPagos.size()];
        arregloValores = new Object[listaFormaPagos.size()];

        
            for (Pago a : listaFormaPagos) {
                if (a.getPlazo() == null || a.getPlazo().length() == 0 || a.getPlazo().equals("null")) {
                    formaPagoDinamica = bundle.getMessage("fac_061",
                            bundle.getMessage("tabla24_" + a.getFormaPago()),
                            a.getTotal());
                } else {
                    formaPagoDinamica = bundle.getMessage("fac_059",
                            bundle.getMessage("tabla24_" + a.getFormaPago()),
                            a.getPlazo(),
                            a.getUnidadTiempo(),
                            a.getTotal());
                }

                arregloTitulos[i] = bundle.getMessage("fac_058", (i + 1));
                arregloValores[i] = formaPagoDinamica;
                i++;
            }
        }

    /**
     * Clase para manejar la data de los pagos.
     *
     */
    @Data
    @AllArgsConstructor
    public class Pago {
        protected String formaPago;
        protected String total;
        protected String plazo;
        protected String unidadTiempo;
    }
}
