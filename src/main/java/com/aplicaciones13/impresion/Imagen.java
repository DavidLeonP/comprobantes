package com.aplicaciones13.impresion;

import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfPCell;
import java.awt.Color;

import java.net.MalformedURLException;
import java.net.URL;


import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;


import java.util.logging.Level;
import java.util.logging.Logger;

import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.impl.code128.Code128Constants;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.krysalis.barcode4j.tools.UnitConv;


/**Metodo para mostrar un titulo
 *
 * @author o.velez@13aplicaciones.com
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
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING,
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
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING,
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
        Code128Bean barcode128Bean = new Code128Bean();
        barcode128Bean.setCodeset(Code128Constants.CODESET_B);
        final int dpi = 600;

        // Configure the barcode generator
        // adjust barcode width here
        barcode128Bean.setModuleWidth(UnitConv.in2mm(5.0f / dpi));
        barcode128Bean.doQuietZone(false);

        // Open output file
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            
            BitmapCanvasProvider canvasProvider = new BitmapCanvasProvider(
                baos, "image/x-png", dpi, BufferedImage.TYPE_BYTE_BINARY, false, 0);

            barcode128Bean.generateBarcode(canvasProvider, code);
            canvasProvider.finish();

            this.imagenTrabajo = Image.getInstance(baos.toByteArray());
        }catch(Exception e){
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING,e.toString());
        }
        
        finally {            
            try{
                baos.close();
            }catch(Exception e){
                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING,e.toString());
            }
        }
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
                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING,
                                                                e.toString());
                return null;
            }
        }

        if (getUrl() != null) {
            try {
                if (imagenTrabajo == null)
                    imagenTrabajo = Image.getInstance(getUrl());

            } catch (Exception e) {
                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING,
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
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING,
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
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING,e.toString());
        }
    }

    public void setUrl(URL url) {
        this.url = url;
    }
}
