package com.aplicaciones13.utilidades;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.net.URL;

/** Objeto para validar la licencia del sistema
 *
 * @author omar velez omargo33@hotmail.com
 *
 */
public class ValidarIdentificador {

    /** Metodo para crear el objeto.
     *
     */
    public ValidarIdentificador() {
        super();
    }

    /** Genera el archivo de validación de ser necesario.
     *
     * Instancia url de identificacion.
     * Toma la respuesta
     * La guarda en un archivo
     *
     * @param identificacion
     * @param path
     */
    private void generarArchivoIdentificacion(String identificacion, String path) {
        String response = "";
        String direccionURL =
            String.format("http://www.jeremiassoft.com/js_sri/SRI/validaRUC.php?identificacion=%s", identificacion);

        try {
            URL url = new URL(direccionURL);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));

            response = bufferedReader.readLine();
            bufferedReader.close();

            MainFiles mainFiles = new MainFiles(path);
            mainFiles.setText(response);

        } catch (Exception e) {
            MainFiles.escribirLogDefault(this.getClass().getName() + ".generarArchivoIdentificacion()" + e.toString());
            MainFiles mainFiles = new MainFiles(path);
            mainFiles.setText("ycBcT6NK4Vr/YqkU3qvYkf9fXyjEwi43gKOmOI7ogWM=");
        }
    }
}
