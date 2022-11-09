package com.aplicaciones13.utilidades;

import java.io.File;

import java.text.SimpleDateFormat;

import java.util.Date;


/** Objeto para especificar un directorio de salida basado en empresa y en fecha de emisión para impedir la saturación de una carpeta.
 *
 * @author omarv omargo33@JeremiasSoft.com
 *
 */
public class NombreDirectorio {

    private String empresa;
    private String path;
    private String mensaje;
    private String pathRespuesta;
    private String nombreArchivo;


    /** Metodo para crear el objeto.
     *
     * @param path path base para la ubicación
     * @param empresa directorio de a empresa a generar
     * @param nombreArchivo nombre del archivo
     */
    public NombreDirectorio(String path, String empresa, String nombreArchivo) {
        super();
        setEmpresa(empresa);
        setMensaje(null);
        setPath(path);
        setNombreArchivo(nombreArchivo);
        crearDirectorio();
    }

    /** Metodo para generar el nombre de una archivo a partir de la fecha de hoy.
     *
     * @return
     */
    private String directorioFecha() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(new Date());
    }

    /** Metodo para crear un directorio con la empresa y el directorio actual en el caso de ser necesario crearlo
     *
     * Acera el mensaje de error
     * Obtiene el separador de acuerdo al sistema operativo utilizado
     * Crea el archivo
     *  Si hay algun error lo pone en el mensaje.
     */
    private void crearDirectorio() {
        setMensaje(null);
        String separador = System.getProperty("file.separator");

        setPathRespuesta(getPath() + getEmpresa() + separador + directorioFecha());

        File stockDir = new File(getPathRespuesta());

        try {
            stockDir.mkdirs();
            stockDir.setExecutable(true, false);
            stockDir.setWritable(true, false);
            stockDir.setReadable(true, false);
        } catch (SecurityException e) {
            setMensaje(this.getClass().getName() + ".crearDirectorio() " + e);
        }

        setPathRespuesta(getPathRespuesta() + separador + getNombreArchivo());
    }

    /** Obtiene la empresa.
     *
     * @return directorio de la empresa
     */
    public String getEmpresa() {
        return empresa;
    }

    /** Pone la empresa.
     *
     * @param empresa directorio de la empresa
     */
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    /** Obtiene el path.
     *
     * @return path
     *
     */
    public String getPath() {
        return path;
    }

    /** Pone el Path.
     *
     * @param path path
     *
     */
    public void setPath(String path) {
        this.path = path;
    }

    /** Obtiene el mensaje.
     *
     * @return mensaje de error del proceo
     *
     */
    public String getMensaje() {
        return mensaje;
    }

    /** Pone el mensaje.
     *
     * @param mensaje de error del proceo
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /** Obtiene el path respuesta.
     *
     * @return path respuesta
     *
     */
    public String getPathRespuesta() {
        return pathRespuesta;
    }

    /** Pone el path de la repuesta.
     *
     * @param pathRespuesta path de la repuesta
     *
     */
    public void setPathRespuesta(String pathRespuesta) {
        this.pathRespuesta = pathRespuesta;
    }

    /** Obtiene el nombre del archivo.
     *
     * @return nombre del archivo
     *
     */
    public String getNombreArchivo() {
        return nombreArchivo;
    }

    /** Pone el nombre del archivo.
     *
     * @param nombreArchivo nombre del archivo
     *
     */
    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }
}
