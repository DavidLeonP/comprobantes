package com.aplicaciones13.utilidades;

import java.text.SimpleDateFormat;

import java.util.Date;


/** Objeto para dar formato a la fecha
 *
 * @author omarv omargo33@JeremiasSoft.com
 *
 */
public class FechasFormato {

    /** Metodo para crear el objeto.
     *
     */
    public FechasFormato() {
        super();
    }

    /** Metodo para obtener un formato de fecha de este momento.
     *
     * @return
     */
    public static String nowFormat() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
    
    /** Metodo para obtener un formato de fecha de este momento.
     *
     * @return
     */
    public static String format() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    /** Metodo para obtener un formato de fecha.
     *
     * @param date fecha a partir de la cual se va a realizar el formato.
     * @return
     */
    public static String format(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    }
}
