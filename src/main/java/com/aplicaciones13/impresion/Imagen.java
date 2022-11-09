package com.aplicaciones13.impresion;


import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfPCell;

import com.aplicaciones13.utilidades.MainFiles;

import java.awt.Color;

import java.net.MalformedURLException;
import java.net.URL;

import java.util.logging.Level;
import java.util.logging.Logger;


/**Metodo para mostrar un titulo
 *
 * @author omarv omargo33@JeremiasSoft.com
 *
 */
public class Imagen extends Elemento {
    private byte _bites[];
    private String path;
    private URL url;
    private float scala;
    private Image imagen;

    /**Metodo para crear la imagen.
     *
     */
    public Imagen() {
        super();
        setScala(100);
    }

    /** Escribir objeto.
     *
     */
    public void escribe() {
        try {
            getImagen().scalePercent(getScala());
            getImagen().setAbsolutePosition(getX(), getY());
            getDocumento().add(getImagen());
            setScala(100);
            setX(0);
            setY(0);
            setPath(null);
            url = null;
        } catch (Exception e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE,
                                                            e.toString());
        }
    }

    /** Escribir objeto.
     *
     */
    public PdfPCell escribeCelda() {
        try {
            getImagen().scalePercent(getScala());
            getImagen().setAbsolutePosition(getX(), getY());

            PdfPCell celda = new PdfPCell(getImagen());
            celda.setHorizontalAlignment(Element.ALIGN_CENTER);
            celda.setBorderWidthLeft(0);
            celda.setBorderWidthRight(0);
            celda.setBorder(0);

            setScala(100);
            setX(0);
            setY(0);
            setPath(null);
            url = null;
            return celda;
        } catch (Exception e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE,
                                                            e.toString());
        }
        return null;
    }

    public byte[] getBites() {
        return _bites;
    }

    public void setBites(byte[] bites) {
        _bites = bites;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String URL) {
        path = URL;
    }

    public float getScala() {
        return scala;
    }

    public void setScala(float scala) {
        this.scala = scala;
    }

    public Image getImagen() {
        if (getPath() == null && getUrl() == null)
            return imagen;


        if (getPath() != null) {
            try {
                if (imagen == null)
                    imagen = Image.getInstance(getPath());

            } catch (Exception e) {
                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE,
                                                                e.toString());
                return null;
            }
        }

        if (getUrl() != null) {
            try {
                if (imagen == null)
                    imagen = Image.getInstance(getUrl());

            } catch (Exception e) {
                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE,
                                                                e.toString());
                return null;
            }
        }
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }

    public void setImagen(java.awt.Image i) {
        try {
            this.imagen = Image.getInstance(i, Color.WHITE);
        } catch (Exception e) {
            MainFiles.escribirLogDefault(this.getClass().getName(),
                                         ".setImagen()", e.toString());
        }
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(String stringUrl) {
        try {
            this.url = new URL(stringUrl);
        } catch (MalformedURLException e) {
            MainFiles.escribirLogDefault(this.getClass().getName(),
                                         ".setUrl(stringUrl)", e.toString());
        }
    }

    public void setUrl(URL url) {
        this.url = url;
    }
}
