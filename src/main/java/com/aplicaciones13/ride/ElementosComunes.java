package com.aplicaciones13.ride;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.aplicaciones13.Constantes;
import com.aplicaciones13.impresion.Elemento;
import com.aplicaciones13.impresion.Espacio;
import com.aplicaciones13.impresion.Form;
import com.aplicaciones13.impresion.H1;
import com.aplicaciones13.impresion.H2;
import com.aplicaciones13.impresion.Imagen;
import com.aplicaciones13.impresion.P;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Clase para implementar elementos comunes en los RIDE.
 * 
 * @author omarv
 * 
 */
public class ElementosComunes {
    private static final String[] TXT_11_3 = { Constantes.DIRECCION_MATRIZ, Constantes.DIRECCION_ESTABLECIMIENTO };
    private static final String[] TXT_11_4 = { Constantes.CONTRIBUYENTE_ESPECIAL_NO, "Obligado a llevar contabilidad" };
    private static final String TXT_11_5 = "RUC: ";
    private static final String TXT_11_7 = "No.: %s";
    private static final String TXT_11_8 = "N\u00famero Autorizaci\u00f3n";
    private static final String TXT_11_9 = "Fecha Autorizaci\u00f3n";
    private static final String TXT_11_10 = Constantes.AMBIENTE;
    private static final String TXT_11_11 = "Emisi\u00f3n";
    private static final String TXT_11_12 = "Clave de Acceso";
    private static final String TXT_11_13 = "Normal";

    private Document documento;

    H1 h1 = new H1();
    H2 h2 = new H2();
    P p = new P();
    Espacio espacio = new Espacio();
    Form form = new Form();
    PdfWriter pdfWriter;

    public ElementosComunes() {
        super();
    }

    /**
     * Metodo para generalizar los encabezados.
     * 
     * @param pathLogo
     * @param nombreEmpresa
     * @param direccionMatriz
     * @param direccionEstablecimiento
     * @param contribuyenteEspecial
     * @param obligadoContabilidad
     * @param ruc
     * @param nombreDocumento
     * @param numeroDocumento
     * @param claveAccesoAutorizacion
     * @param numeroAutorizacion
     * @param fechaAutorizacion
     * @param ambienteAutorizacion
     * @param emisionAutorizacion
     * @param isOffline
     */
    public void encabezado(String pathLogo, String nombreEmpresa, String direccionMatriz, String direccionEstablecimiento, String contribuyenteEspecial, String obligadoContabilidad,
    String ruc, String nombreDocumento, String numeroDocumento, 
        String claveAccesoAutorizacion, String numeroAutorizacion, String fechaAutorizacion, String ambienteAutorizacion,
        String emisionAutorizacion, boolean isOffline
    
    ) {
        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100);

        table.addCell(
            encabezadoLadoIzquierdo(
                pathLogo, 
                nombreEmpresa,
                direccionMatriz,
                direccionEstablecimiento,
                contribuyenteEspecial, 
                obligadoContabilidad)
            );
        table.addCell(
            encabezadoLadoDerecho(
                ruc,
                nombreDocumento, 
                numeroDocumento, 
                claveAccesoAutorizacion, 
                numeroAutorizacion, 
                fechaAutorizacion,
                ambienteAutorizacion,
                emisionAutorizacion,  
                isOffline) 
        );
        try {
            getDocumento().add(table);
        } catch (DocumentException e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, e.toString());
        }
    }

    /**
     * Metodo para tener el encabezado del lado izquierdo
     * 
     * @param pathLogo
     * @param nombreEmpresa
     * @param direccionMatriz
     * @param direccionEstablecimiento
     * @param contribuyenteEspecial
     * @param obligadoContabilidad
     * @return
     */
    private PdfPTable encabezadoLadoIzquierdo(String pathLogo, String nombreEmpresa, String direccionMatriz,
            String direccionEstablecimiento,
            String contribuyenteEspecial, String obligadoContabilidad) {

        // Lado Izquierdo
        PdfPTable tableIzquierda = new PdfPTable(1);

        // Logotipo lado Izquierdo
        Imagen imagen = new Imagen();
        imagen.setPath(pathLogo);
        imagen.setDocumento(getDocumento());
        imagen.setScala(33f);
        tableIzquierda.addCell(imagen.escribeCelda());

        // Nombre de la empresa
        this.h1.setTexto(nombreEmpresa);
        tableIzquierda.addCell(this.h1.escribeCelda());

        // Informacion de la empresa
        this.form.setListaTitulos(TXT_11_3);
        this.form.setListaValores(direccionMatriz, direccionEstablecimiento);
        this.form.setListaFormatos(Elemento.FORMATO_STRING, Elemento.FORMATO_STRING);
        this.form.setListaDimensiones("30", "70");
        this.form.setListaPaneles("2");
        tableIzquierda.addCell(this.form.escribeCelda());

        // Informacion de contabilidad
        this.form.setListaTitulos(TXT_11_4);
        this.form.setListaValores(contribuyenteEspecial, obligadoContabilidad);
        this.form.setListaFormatos(Elemento.FORMATO_STRING, Elemento.FORMATO_STRING);
        this.form.setListaDimensiones("50", "50");
        this.form.setListaPaneles("2");
        tableIzquierda.addCell(this.form.escribeCelda());

        return tableIzquierda;
    }

    /**
     * Metodo para tener el encabezado del lado derecho
     * 
     * @param ruc
     * @param nombreDocumento
     * @param numeroDocumento
     * @param claveAccesoAutorizacion
     * @param numeroAutorizacion
     * @param fechaAutorizacion
     * @param ambienteAutorizacion
     * @param emisionAutorizacion
     * @param isOffline
     * @return
     */
    private PdfPTable encabezadoLadoDerecho(String ruc, String nombreDocumento, String numeroDocumento,
            String claveAccesoAutorizacion, String numeroAutorizacion, String fechaAutorizacion,
            String ambienteAutorizacion,
            String emisionAutorizacion, boolean isOffline) {

        // Lado Derecho
        PdfPTable tableDerecha = new PdfPTable(1);

        // Ruc
        this.h2.setTexto(TXT_11_5 + ruc);
        tableDerecha.addCell(h2.escribeCelda());

        /* */
        // Nombre del documento
        this.h1.setTexto(nombreDocumento);
        tableDerecha.addCell(this.h1.escribeCelda());

        // Numero del documento
        this.h1.setTexto(String.format(TXT_11_7, numeroDocumento));
        tableDerecha.addCell(this.h1.escribeCelda());

        // Numero de autorizacion
        this.h2.setTexto(TXT_11_8);
        tableDerecha.addCell(this.h2.escribeCelda());
        if (isOffline)
            this.p.setTexto(claveAccesoAutorizacion);
        else
            this.p.setTexto(numeroAutorizacion);

        tableDerecha.addCell(this.p.escribeCelda());

        // Fecha Autorizacion - modo offline
        if (!isOffline) {
            this.form.setListaTitulos(TXT_11_9);
            this.form.setListaValores(fechaAutorizacion);
            this.form.setListaFormatos(Elemento.FORMATO_STRING);
            this.form.setListaDimensiones("40", "60");
            this.form.setListaPaneles("1");
            tableDerecha.addCell(this.form.escribeCelda());
        }

        // Ambiente
        this.form.setListaTitulos(TXT_11_10);
        this.form.setListaValores(ambienteAutorizacion);
        this.form.setListaFormatos(Elemento.FORMATO_STRING);
        this.form.setListaDimensiones("40", "60");
        this.form.setListaPaneles("1");
        tableDerecha.addCell(this.form.escribeCelda());

        // Emision

        this.form.setListaTitulos(TXT_11_11);

        if (isOffline) {
            this.form.setListaValores(TXT_11_13);
        } else {
            this.form.setListaValores(emisionAutorizacion);
        }
        this.form.setListaFormatos(Elemento.FORMATO_STRING);
        this.form.setListaDimensiones("40", "60");
        this.form.setListaPaneles("1");
        tableDerecha.addCell(this.form.escribeCelda());

        // Clave de acceso
        this.h2.setTexto(TXT_11_12);
        tableDerecha.addCell(this.h2.escribeCelda());

        tableDerecha.addCell(espacio.escribeCelda());
        
        // Code 128        
        Imagen imagen = new Imagen();
        imagen.procesarCode128(claveAccesoAutorizacion);
        imagen.setDocumento(getDocumento());
        imagen.setScala(10f);
        tableDerecha.addCell(imagen.escribeCelda());

        return tableDerecha;
    }

    /**
     * Metodo para agregar la firma grafica.
     * 
     * @param firmaGrafica
     */
    public void firmarGraficamente(String firmaGrafica) {
        if (firmaGrafica != null && !firmaGrafica.isEmpty()) {
            Imagen imagenFirma = new Imagen();
            imagenFirma.setDocumento(getDocumento());
            if (this.pdfWriter.getVerticalPosition(true) < 105) {
                getDocumento().newPage();
            }

            PdfPTable table = new PdfPTable(1);
            table.setWidthPercentage(100);
            imagenFirma.setPath(firmaGrafica);
            imagenFirma.setScala(30f);

            PdfPCell celda = imagenFirma.escribeCelda();
            celda.setHorizontalAlignment(Element.ALIGN_RIGHT);
            celda.setVerticalAlignment(Element.ALIGN_MIDDLE);
            table.addCell(celda);

            try {
                espacios(1);
                getDocumento().add(table);
            } catch (DocumentException e) {
                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, e.toString());
            }
        }
    }
        /**
     * Metodo para saltar espacios
     *
     * @param j
     */
    public void espacios(int j) {
        while (j > 0) {
            this.espacio.escribe();
            j--;
        }
    }
    
    public void setPdfWriter(PdfWriter pdfWriter) {
        this.pdfWriter = pdfWriter;
    }

    public void setDocumento(Document documento) {
        this.documento = documento;
        h1.setDocumento(documento);
        h2.setDocumento(documento);
        p.setDocumento(documento);
        espacio.setDocumento(documento);
        form.setDocumento(documento);
    }

    public Document getDocumento() {
        return documento;
    }
}