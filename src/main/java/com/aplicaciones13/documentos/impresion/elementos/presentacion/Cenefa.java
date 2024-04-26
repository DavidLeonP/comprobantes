/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplicaciones13.documentos.impresion.elementos.presentacion;

import com.aplicaciones13.documentos.impresion.elementos.texto.Elemento;
import com.aplicaciones13.documentos.impresion.elementos.texto.P;
import com.aplicaciones13.documentos.impresion.elementos.imagen.Imagen;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Canvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import java.util.Date;

/**
 * Objeto sobrecargar el evento de encabezado del archivo.
 *
 * @author omargo33
 *
 */
public class Cenefa{

    /**
     * Indicador si es cenefa superior o inferior
     */
    boolean superior;
    private static final int SIZE_INFORMACION_PAGINA = 16;
    Document documentoPadre = null;
    PageSize pageSize;
    PdfDocument pdfDocument = null;
    
    
    private CenefaEstructura cenefaEstructura;
    private Image image;
    private Rectangle rectanguloImagen;
    private Rectangle rectanguloInformacionPagina;

    /**
     * Metodo para crear el objeto.
     *
     * @param superior
     * @param pageSize
     */
    public Cenefa(boolean superior, PageSize pageSize) {
        super();
        this.cenefaEstructura = new CenefaEstructura(false, false, false, false, false, null);
        this.superior = superior;
        this.pageSize = pageSize;
    }

    /**
     * Metodo para ejecutar la cenefa superior.
     *
     * Crea el rectangulo de imagen en base a la imagen. Crea el rectangulo de
     * informacion en base a la configuracion.
     *
     */
    private void ejecutarCenefaSuperior() {
        float margenOriginal = getDocumentoPadre().getTopMargin();
        float margenSugerido = 0;
        if (cenefaEstructura.isImagenVisible()) {
            float anchoImagen = pageSize.getWidth() - (getDocumentoPadre().getLeftMargin() + getDocumentoPadre().getRightMargin());
            image = crearImagen(cenefaEstructura.getPathImagen(), anchoImagen);
            margenSugerido = image.getImageScaledHeight() + margenOriginal;
            getDocumentoPadre().setTopMargin(margenSugerido);
            float y = (pageSize.getHeight() - (image.getImageScaledHeight() + margenOriginal));
            rectanguloImagen = new Rectangle(getDocumentoPadre().getLeftMargin(), y, anchoImagen, image.getImageScaledHeight());
        }

        if (cenefaEstructura.isVisibleInformacionPagina()) {
            margenOriginal = getDocumentoPadre().getTopMargin();
            float anchoTexto = pageSize.getWidth() - (getDocumentoPadre().getLeftMargin() + getDocumentoPadre().getRightMargin());
            margenSugerido = margenOriginal + SIZE_INFORMACION_PAGINA;
            getDocumentoPadre().setTopMargin(margenSugerido);
            float y = (pageSize.getHeight() - (SIZE_INFORMACION_PAGINA + margenOriginal));
            rectanguloInformacionPagina = new Rectangle(getDocumentoPadre().getLeftMargin(), y, anchoTexto, SIZE_INFORMACION_PAGINA);
        }
    }

    /**
     * Metodo para ejecutar la cenefa inferior.
     *
     * Crea el rectangulo de imagen en base a la imagen. Crea el rectangulo de
     * informacion en base a la configuracion.
     *
     */
    private void ejecutarCenefaInferior() {
        float margenOriginal = getDocumentoPadre().getBottomMargin();
        float margenSugerido = 0;
        if (cenefaEstructura.isImagenVisible()) {
            float anchoImagen = pageSize.getWidth() - (getDocumentoPadre().getLeftMargin() + getDocumentoPadre().getRightMargin());
            image = crearImagen(cenefaEstructura.getPathImagen(), anchoImagen);
            margenSugerido = image.getImageScaledHeight() + margenOriginal;
            getDocumentoPadre().setBottomMargin(margenSugerido);
            rectanguloImagen = new Rectangle(getDocumentoPadre().getLeftMargin(), margenOriginal, anchoImagen, image.getImageScaledHeight());
        }

        if (cenefaEstructura.isVisibleInformacionPagina()) {
            margenOriginal = getDocumentoPadre().getBottomMargin();
            float anchoTexto = pageSize.getWidth() - (getDocumentoPadre().getLeftMargin() + getDocumentoPadre().getRightMargin());
            margenSugerido = margenOriginal + SIZE_INFORMACION_PAGINA;
            getDocumentoPadre().setBottomMargin(margenSugerido);
            rectanguloInformacionPagina = new Rectangle(getDocumentoPadre().getLeftMargin(), margenOriginal, anchoTexto, SIZE_INFORMACION_PAGINA);
        }
    }

    /**
     * Metodo para crear una imagen con los datos proporcionados y dentro de la
     * hoja seleccionada.
     *
     * @param pathImagen
     * @param anchoImagen
     * @return
     */
    private Image crearImagen(String pathImagen, float anchoImagen) {
        Imagen imagen = new Imagen();
        imagen.setPathImagen(pathImagen);
        imagen.setMaximoAncho(anchoImagen);
        imagen.procesar();
        return imagen.getImagen();
    }

    /**
     * Metodo para calibrar la hoja.
     *
     * Crea los datos para ser puestos de pies o cabeza y tambien las dimesiones
     * de la hoja.
     *
     */
    public void calibrarHoja() {
        if (superior) {
            ejecutarCenefaSuperior();
        } else {
            ejecutarCenefaInferior();
        }
    }

    /**
     * Metodo para procesar la escritura de las cenefas.
     *
     * Recorre el documento y va insertando los canvas de imagen/informacion.
     *
     */    
    public void procesar() {        
        int n = getPdfDocument().getNumberOfPages();
        for (int i = 1; i <= n; i++) {
            PdfPage pdfPage = getPdfDocument().getPage(i);
            PdfCanvas pdfCanvas = new PdfCanvas(pdfPage);

            if (cenefaEstructura.isImagenVisible()) {
                try (Canvas canvasImagen = new Canvas(pdfCanvas, rectanguloImagen)) {
                    canvasImagen.add(image);
                }
            }

            if (cenefaEstructura.isVisibleInformacionPagina()) {
                try (Canvas canvasInformacionPagina = new Canvas(pdfCanvas, rectanguloInformacionPagina)) {
                    canvasInformacionPagina.add(creaInformacionPagina(i, n));
                }
            }
        }
    }

    /**
     * Metodo para generar la información del documento.
     *
     * @param pagina
     * @param totalPaginas
     * @return
     */
    private Paragraph creaInformacionPagina(int pagina, int totalPaginas) {
        String informacionPaginaTexto = "";

        if (cenefaEstructura.isNombreDocumentoVisible()) {
            informacionPaginaTexto = cenefaEstructura.getNombreDocumento();
        }

        if (cenefaEstructura.isFechaCreacionVisible()) {
            informacionPaginaTexto = informacionPaginaTexto + " Creado el " + Elemento.formatearFecha("yyyy-MM-dd HH:mm:ss", new Date());
        }

        if (cenefaEstructura.isNumeroPaginaVisible()) {
            informacionPaginaTexto = informacionPaginaTexto + " Pag. " + pagina;

            if (cenefaEstructura.isTotalPaginasVisible()) {
                informacionPaginaTexto = informacionPaginaTexto + " de " + totalPaginas;
            }
        }

        P p = new P(informacionPaginaTexto.trim(), P.NOTA);
        p.negrita();
        return p.getParagraph();
    }

    /**
     * @return the documento
     */
    public Document getDocumentoPadre() {
        return this.documentoPadre;
    }

    /**
     *
     * @return pdf Document
     */
    public PdfDocument getPdfDocument() {
        return this.pdfDocument;
    }

    /**
     * @param cenefaEstructura the cenefaEstructura to set
     */
    public void setCenefaEstructura(CenefaEstructura cenefaEstructura) {
        this.cenefaEstructura = cenefaEstructura;
    } 
}