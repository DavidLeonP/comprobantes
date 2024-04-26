/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplicaciones13.documentos.impresion.elementos.imagen;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.layout.element.Image;
import com.aplicaciones13.documentos.impresion.elementos.compuestos.ConjuntoInterface;
import com.aplicaciones13.documentos.impresion.elementos.texto.Elemento;
import lombok.extern.slf4j.Slf4j;

import java.net.MalformedURLException;
/**
 * Objeto metodo para contener imagnes con escalas a partir de una direccion.
 *
 * @author omargo33
 *
 *
 */
@Slf4j
public class Imagen extends Elemento implements ConjuntoInterface {

    private String pathImagen;
    private float escala;
    private float maximoAncho;
    private float maximoAlto;
    private Image image;
    private static final String IMAGE_NOT_FOUND = "src/main/resources/iconfinder_gallery_3855631.png";

    /**
     * Metodo para crear el objeto.
     *
     */
    public Imagen()  {
        initImagen();
    }

    /**
     * Metodo para inicializar el objeto.
     *
     */
    private void initImagen() {
        setEscala(100f);
        setMaximoAncho(0f);
        setMaximoAlto(0f);
    }

    /**
     * Escribir objeto.
     *
     */
    @Override
    public void escribir() {
        getDocumento().add(getImagen());
    }

    /**
     *
     * @return
     */
    public Image getImagen() {
        return this.image;
    }

    
    /**
     * Metodo para procesar las escalas del sistemas.
     *
     */
    private void procesarEscala() {
        if (this.escala == 1.0f) {
            setImagen(escalaAbsoluta(image));
        } else {
            setImagen(image.scale(escala, escala));
        }
        initImagen();
    }

    /**
     * Metodo para presentar una imangen de caso de que no exista una imagen
     * solicitada y de esta manera controlar errores de presentacion.
     *
     */
    private void procesarImagenNotFound() {
        try {
            setImagen(new Image(ImageDataFactory.create(IMAGE_NOT_FOUND)));
        } catch (MalformedURLException ex) {            
            log.warn(".procesarImagenNotFound() {}", ex.toString());
        }
    }

    /**
     * Metodo para calcular la escala absoluta proporcional para no perder
     * proporcion.
     *
     * @param image
     * @return
     */
    private Image escalaAbsoluta(Image image) {
        float maximoAltoTemp = image.getImageHeight();
        float maximoAnchoTemp = image.getImageWidth();

        if (maximoAncho > 0 && maximoAncho < maximoAnchoTemp) {
            float escalaCalculada = maximoAncho * 100 / maximoAnchoTemp;
            maximoAltoTemp = maximoAltoTemp / 100 * escalaCalculada;
            maximoAnchoTemp = maximoAncho;
        }

        if (maximoAlto > 0 && maximoAlto < maximoAltoTemp) {
            float escalaCalculada = maximoAlto * 100 / maximoAltoTemp;
            maximoAnchoTemp = maximoAnchoTemp / 100 * escalaCalculada;
            maximoAltoTemp = maximoAlto;
        }
        return image.scaleAbsolute(maximoAnchoTemp, maximoAltoTemp);
    }

    /**
     * @param pathImagen the pathImagen to set
     */
    public void setPathImagen(String pathImagen) {
        this.pathImagen = pathImagen;
    }

    /**
     * @param escala the escala to set
     */
    public void setEscala(float escala) {
        this.escala = escala / 100;
    }

    /**
     * @param maximoAncho the maximoAncho to set
     */
    public void setMaximoAncho(float maximoAncho) {
        this.maximoAncho = maximoAncho;
    }

    /**
     * @param maximoAlto the maximoAlto to set
     */
    public void setMaximoAlto(float maximoAlto) {
        this.maximoAlto = maximoAlto;
    }

    /**
     * @param image the image to set
     */
    public void setImagen(Image image) {
        this.image = image;
    }

/**
     * Procesa la imagen en el pdf
     * 
     */
    @Override
    public void procesar() {
        try {
            setImagen(new Image(ImageDataFactory.create(this.pathImagen)));
            procesarEscala();
        } catch (MalformedURLException ex) {
            procesarImagenNotFound();
        }
    }

    @Override
    public void reset() {
        initImagen();
    }
}
