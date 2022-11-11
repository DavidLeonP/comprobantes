package com.aplicaciones13.impresion;


import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfPCell;
import java.awt.Color;

import java.net.MalformedURLException;
import java.net.URL;
import com.itextpdf.barcodes.Barcode128;
import com.itextpdf.kernel.pdf.PdfDocument;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import java.util.logging.Level;
import java.util.logging.Logger;


/**Metodo para mostrar un titulo
 *
 * @author omarv omargo33@JeremiasSoft.com
 *
 */
public class Imagen extends Elemento {
    private byte[] bites;
    private String path;
    private URL url;
    private float scala;
    private Image imagenTrabajo;

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
        return this.bites;
    }

    public void setBites(byte[] bites) {
        this.bites = bites;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public float getScala() {
        return scala;
    }

    public void setScala(float scala) {
        this.scala = scala;
    }

    /**
     * Metodo para procesar un code 128.
     * 
     * @param code
     */
    public void procesarCode128(String code){
        BufferedImage imagenBarras = new BufferedImage(640, 100, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = imagenBarras.createGraphics();
        g.setPaint(Color.WHITE);
        g.fillRect(0, 0, 640, 100);        
        org.jbars.Barcode128 code128 = new org.jbars.Barcode128();
        code128.setCodeType(org.jbars.Barcode.CODE128);
        code128.setCode(code );
        code128.placeBarcode(imagenBarras, Color.black, Color.blue);        
        setImagen(imagenBarras);
        setScala(40f);
    }
    
    /**
     * Metodo para obtener la imagen.
     * 
     * 
     * @return
     */
    public Image getImagen() {
        if (getPath() == null && getUrl() == null)
            return this.imagenTrabajo;

        if (getPath() != null) {
            try {
                if (imagenTrabajo == null)
                    imagenTrabajo = Image.getInstance(getPath());

            } catch (Exception e) {
                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE,
                                                                e.toString());
                return null;
            }
        }

        if (getUrl() != null) {
            try {
                if (imagenTrabajo == null)
                    imagenTrabajo = Image.getInstance(getUrl());

            } catch (Exception e) {
                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE,
                                                                e.toString());
                return null;
            }
        }
        return imagenTrabajo;
    }

    public void setImagenTrabajo(Image imagen) {
        this.imagenTrabajo = imagen;
    }

    public void setImagen(java.awt.Image i) {
        try {
            this.imagenTrabajo = Image.getInstance(i, Color.WHITE);
        } catch (Exception e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE,
                                                            e.toString());            
        }
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(String stringUrl) {
        try {
            this.url = new URL(stringUrl);
        } catch (MalformedURLException e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE,e.toString());
        }
    }

    public void setUrl(URL url) {
        this.url = url;
    }
}
