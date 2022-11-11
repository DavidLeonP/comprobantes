package com.aplicaciones13.utilidades;


/** Clase para comprobar el modulo 11
 *
 * @author omarv omargo33@JeremiasSoft.com
 *
 */
public class Mod11Ck {

    /** Metodo para invertir la cadena.
     *
     * @param cadena
     * @return
     */
    private String invertirCadena(String cadena) {
        String cadenaInvertida = "";
        for (int x = cadena.length() - 1; x >= 0; x--) {
            cadenaInvertida = cadenaInvertida + cadena.charAt(x);
        }
        return cadenaInvertida;
    }

    /** Metodo para obtener la suma de digitos.
     *
     * @param cadena
     * @return
     */
    private int obtenerSumaPorDigitos(String cadena) {
        int pivote = 2;
        int longitudCadena = cadena.length();
        int cantidadTotal = 0;
        int b = 1;
        for (int i = 0; i < longitudCadena; i++) {
            if (pivote == 8) {
                pivote = 2;
            }
            int temporal = Integer.parseInt("" + cadena.substring(i, b));
            b++;
            temporal *= pivote;
            pivote++;
            cantidadTotal += temporal;
        }
        cantidadTotal = 11 - cantidadTotal % 11;
        return cantidadTotal;
    }

    /** Metodo para obtener el digito verificador.
     *
     * @param valorCalcular
     * @return
     */
    public String digitoVerificador(String valorCalcular) {
        int i = obtenerSumaPorDigitos(invertirCadena(valorCalcular));
        if (i == 11)
            return "0";
        if (i == 10)
            return "1";
        return String.valueOf(i);
    }
}
