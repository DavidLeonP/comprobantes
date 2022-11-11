package com.aplicaciones13.sri.contenedores;

import com.aplicaciones13.utilidades.BundleFactory;
import com.aplicaciones13.utilidades.Bundles;

/** Objeto para tener la tablas del SRI.
 *
 * @author omar velez omargo33@jeremiassoft.com
 *
 */
public class TablasSRI {

    private static final String TAB_ICE = "ICE";
    private static final String TAB_CERO = "0%";
    private static final String TAB_12 = "12%";
    private static final String TAB_NO_IMPUESTO = "No Objeto de impuesto";

    Bundles bundles = BundleFactory.crearBundle("tablasSRI");

    /** Metodo para crear el objeto.
     *
     */
    public TablasSRI() {
        super();
    }
   
    /** Metodo con la tablas 16 y 17 conjugados.
     *
     * @param codigo
     * @param codigoPorcentaje
     * @return
     */
    public static String tabla16a17(String codigo, String codigoPorcentaje) {
        codigo = (codigo == null) ? "" : codigo;

        if ((codigo + "-" + codigoPorcentaje).compareTo("2-0") == 0)
            return TAB_CERO;

        if ((codigo + "-" + codigoPorcentaje).compareTo("2-2") == 0)
            return TAB_12;

        if ((codigo + "-" + codigoPorcentaje).compareTo("2-6") == 0)
            return TAB_NO_IMPUESTO;

        if (codigo.compareTo("3") == 0)
            return TAB_ICE + "" + codigoPorcentaje;

        return "";
    }

    /**Metodo que permite generar la tabla 4.
     *
     */
    public String tabla4(String codigo) {
        return bundles.getString("tabla_4_"+codigo);
    }

    /**Metodo que permite generar la tabla 18.
     *
     */
    public String tabla18(String codigo) {
        return bundles.getString("tabla_18_"+codigo);       
    }

    /**Metodo que permite generar la tabla 19.
     *
     */
    public String tabla19(String codigo) {
        return bundles.getString("tabla_19_"+codigo);
    }

    /**Metodo que permite generar la tabla 24.
     *
     */
    public String tabla24(String codigo) {
        return bundles.getString("tabla_24_"+codigo);       
    }

    /**Metodo que permite generar la tabla 25.
     *
     */
    public String tabla25(String codigo) {
        return bundles.getString("tabla_25_"+codigo);        
    }
}
