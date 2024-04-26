/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplicaciones13.documentos.impresion.elementos.imagen;

import com.itextpdf.barcodes.BarcodeQRCode;
import com.itextpdf.barcodes.qrcode.EncodeHintType;
import com.itextpdf.barcodes.qrcode.ErrorCorrectionLevel;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.layout.element.Image;

import lombok.extern.slf4j.Slf4j;

import java.awt.Color;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Objeto para crear una imange QR .
 *
 * @author omargo33
 *
 *
 */
@Slf4j
public class ImagenCodigoQR extends Imagen{

    private float ancho = 0f;

    /**
     * Metodo para crear el objeto.
     *
     */
    public ImagenCodigoQR() {
        init();
    }

    /**
     * Metodo para inicializar el objeto.
     *
     */
    private void init() {
        ancho = 0f;
    }

    /**
     * Procesa la imagen en el pdf
     * 
     */
    @Override    
    public void procesar() {
        try {
            setImagen(new Image(ImageDataFactory.create(imagenQR(getTexto().getText()), Color.BLUE)));
            getImagen().setWidth(ancho);
        } catch (IOException ex) {            
            log.warn(".procesar() 1 {}", ex.toString());
        }
    }

    /**
     * Metodo para generar el codigo QR
     *
     * @param direccion
     * @return
     */
    private java.awt.Image imagenQR(String direccion) {
        Map<EncodeHintType, Object> qrParam = new HashMap<>();

        qrParam.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        qrParam.put(EncodeHintType.CHARACTER_SET, "UTF-8");

        BarcodeQRCode qrcode = new BarcodeQRCode(direccion);
        qrcode.setHints(qrParam);
        return qrcode.createAwtImage(Color.BLACK, Color.WHITE);
    }

    /**
     * @param ancho the ancho to set
     */
    public void setAncho(float ancho) {
        this.ancho = ancho;
    }
}
