package com.aplicaciones13.ride.guiaremision.impresion;

import com.aplicaciones13.sri.contenedores.TablasSRI;
import com.aplicaciones13.sri.contenedores.TotalDocumento;
import com.aplicaciones13.impresion.Elemento;
import com.aplicaciones13.impresion.ImpresionBaseElementos;
import com.aplicaciones13.impresion.MarcaAgua;
import com.aplicaciones13.impresion.Pie;
import com.aplicaciones13.ride.guiaremision.Detalle;
import com.aplicaciones13.ride.guiaremision.GuiaRemision;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import java.io.File;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jbars.Barcode;

/**
 * Objeto para crear un documento de guiaRemision.
 *
 * @author omarv omargo33@JeremiasSoft.com
 *
 */
public class ImpresionElementosGuiaRemision extends ImpresionBaseElementos {

    protected static final String ELEMENTO_0 = "0";
    protected static final String ELEMENTO_1 = "1";
    protected static final String ELEMENTO_2 = "2";
    protected static final String ELEMENTO_3 = "3";
    protected static final String ELEMENTO_4 = "4";
    protected static final String ELEMENTO_5 = "5";
    protected static final String ELEMENTO_6 = "6";
    protected static final String ELEMENTO_7 = "7";
    protected static final String ELEMENTO_8 = "8";
    protected static final String ELEMENTO_9 = "9";
    protected static final String ELEMENTO_10 = "10";
    protected static final String ELEMENTO_11 = "11";
    protected static final String ELEMENTO_12 = "12";
    protected static final String ELEMENTO_13 = "13";

    private static final String TXT_2_1 = "JeremiasLogo";
    private static final String TXT_2_2 = ".jpg";
    private static final String TXT_3_1 = "Guia Remisi\u00f3n";
    private static final String TXT_3_2 = "No. %s-%s-%s";
    private static final String[] TXT_3_3 = {
            "No.: Autorizaci\u00f3n", "Fecha Autorizaci\u00f3n", "Ambiente", "Emisi\u00f3n" };
    private static final String TXT_4_1 = "Clave de Acceso";
    private static final String[] TXT_5_1 = {
            "RUC", "Direcci\u00f3n Matriz", "Direcci\u00f3n Establecimiento", "Contribuyente especial Nro.",
            "Obligado a llevar contabilidad"
    };
    private static final String[] TXT_5_2 = {
            "RUC", "Direcci\u00f3n Matriz", "Direcci\u00f3n Establecimiento", "Contribuyente especial Nro.", ""
    };
    private static final String[] TXT_6_1 = {
            "Raz\u00f3n Social (Transportista)", "RUC/CI.", "Placa", "Direcci\u00f3n Partida", "Fecha Inicio Transorte",
            "Fecha Fin Transorte", "RISE"
    };

    private static final String[] TXT_7_10 = {
            "Documento Sustento ", "N\u00famero ", "Fecha Emision ", "N\u00famero autorizado ", "Motivo de Traslado "
    };

    private static final String[] TXT_7_11 = { "Raz\u00f3n Social (Destinatario)", "Identificaci\u00f3n", "Direccion" };

    private static final String[] TXT_7_12 = {
            "Documento Aduanero \u00fanico", "C\u00f3d. Establecimiento destino ", "Ruta" };

    private static final String[] TXT_7_2 = { "Cod.", "Cod. Alt.", "Descripci\u00f3n", "Cantidad" };

    private static final String TXT_10_1 = "Informaci\u00f3n Adicional";

    private static final String TXT_11_1 = "JeremiasLogo";
    private static final String TXT_11_2 = ".jpg";
    private static final String[] TXT_11_3 = { "Direcci\u00f3n Matriz", "Direcci\u00f3n Establecimiento" };
    private static final String[] TXT_11_4 = { "Contribuyente especial Nro.", "Obligado a llevar contabilidad" };
    private static final String TXT_11_5 = "RUC: ";
    private static final String TXT_11_6 = "Gu\u00eda Remisi\u00f3n";
    private static final String TXT_11_7 = "No.: %s-%s-%s";
    private static final String TXT_11_8 = "N\u00famero Autorizaci\u00f3n";
    private static final String TXT_11_9 = "Fecha Autorizaci\u00f3n";
    private static final String TXT_11_10 = "Ambiente";
    private static final String TXT_11_11 = "Emisi\u00f3n";
    private static final String TXT_11_12 = "Clave de Acceso";
    private static final String TXT_11_13 = "Normal";

    private DatosGuiaRemision datosGuiaRemision;
    List<TotalDocumento> totales;

    /**
     * Metod para imprimir los elementos en el orden solicitado.
     *
     * @param valor
     */
    @Override
    public void imprimirElemento(String valor) {
        if (valor.equalsIgnoreCase(ELEMENTO_0))
            try {
                elemento0();
            } catch (Exception e) {
                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, e.toString());
            }
        if (valor.equalsIgnoreCase(ELEMENTO_1))
            try {
                elemento1();
            } catch (Exception e) {
                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, e.toString());
            }
        if (valor.equalsIgnoreCase(ELEMENTO_2))
            try {
                elemento2();
            } catch (Exception e) {
                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, e.toString());
            }

        if (valor.equalsIgnoreCase(ELEMENTO_3))
            try {
                elemento3();
            } catch (Exception e) {
                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, e.toString());
            }
        if (valor.equalsIgnoreCase(ELEMENTO_4))
            try {
                elemento4();
            } catch (Exception e) {
                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, e.toString());
            }
        if (valor.equalsIgnoreCase(ELEMENTO_5))
            try {
                elemento5();
            } catch (Exception e) {
                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, e.toString());
            }

        if (valor.equalsIgnoreCase(ELEMENTO_6))
            try {
                elemento6();
            } catch (Exception e) {
                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, e.toString());
            }
        if (valor.equalsIgnoreCase(ELEMENTO_7))
            try {
                elemento7();
            } catch (Exception e) {
                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, e.toString());
            }
        if (valor.equalsIgnoreCase(ELEMENTO_9))
            try {
                elemento9();
            } catch (Exception e) {
                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, e.toString());
            }
        if (valor.equalsIgnoreCase(ELEMENTO_10))
            try {
                elemento10();
            } catch (Exception e) {
                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, e.toString());
            }
        if (valor.equalsIgnoreCase(ELEMENTO_11))
            try {
                elemento11();
            } catch (Exception e) {
                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, e.toString());
            }
        if (valor.equalsIgnoreCase(ELEMENTO_12))
            try {
                elemento12();
            } catch (Exception e) {
                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, e.toString());
            }
        if (valor.equalsIgnoreCase(ELEMENTO_13))
            try {
                elemento13();
            } catch (Exception e) {
                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, e.toString());
            }
    }

    /**
     * Metodo para agregar la marca de agua al sistema.
     *
     */
    private synchronized void elemento0() {
        getPdfWriter().setPageEvent(new MarcaAgua(getDatosGuiaRemision().getAmbienteAutorizacion()));
    }

    private synchronized void elemento1() {
        Pie pie = new Pie(TXT_3_1);
        pie.setNumeroDocumento(getDatosGuiaRemision().getGuiaRemisionXML()
                .getInfoTributaria()
                .getEstab() + "-"
                + getDatosGuiaRemision().getGuiaRemisionXML()
                        .getInfoTributaria()
                        .getPtoEmi()
                + "-" +
                getDatosGuiaRemision().getGuiaRemisionXML()
                        .getInfoTributaria()
                        .getSecuencial());
        getPdfWriter().setPageEvent(pie);
    }

    /**
     * Metodo para generar el logo del documento.
     *
     * Si el archivo no existe
     * Agrega un logo temporal
     * Imprime el logo.
     *
     */
    private synchronized void elemento2() {
        String logoFileName = TXT_2_1;

        if (new File(getDatosGuiaRemision().getPathLogo() + getDatosGuiaRemision().getGuiaRemisionXML()
                .getInfoTributaria()
                .getRuc() + TXT_2_2).isFile())
            logoFileName = getDatosGuiaRemision().getGuiaRemisionXML()
                    .getInfoTributaria()
                    .getRuc();

        getImagen().setPath(getDatosGuiaRemision().getPathLogo() + logoFileName + TXT_2_2);
        getImagen().setScala(50f);
        getImagen().setX(400);
        getImagen().setY(690);
        getImagen().escribe();
    }

    /**
     * Metodo para generar el panel superior en un formato semejante al SRI.
     *
     */
    private synchronized void elemento10() {
        PdfPTable table = new PdfPTable(2);

        table.setWidthPercentage(100);

        // Lado Izquierdo
        PdfPTable tableIzquierda = new PdfPTable(1);

        // Logotipo lado Izquierdo
        String logoFileName = TXT_11_1;
        if (new File(getDatosGuiaRemision().getPathLogo() + getDatosGuiaRemision().getGuiaRemisionXML()
                .getInfoTributaria()
                .getRuc() + TXT_11_2).isFile())
            logoFileName = getDatosGuiaRemision().getGuiaRemisionXML()
                    .getInfoTributaria()
                    .getRuc();

        getImagen().setPath(getDatosGuiaRemision().getPathLogo() + logoFileName + TXT_11_2);
        getImagen().setScala(50f);
        tableIzquierda.addCell(getImagen().escribeCelda());

        // Nombre de la empresa
        getH1().setTexto(getDatosGuiaRemision().getGuiaRemisionXML()
                .getInfoTributaria()
                .getRazonSocial());
        tableIzquierda.addCell(getH1().escribeCelda());

        // Informacion de la empresa
        getForm().setListaTitulos(TXT_11_3);
        getForm()
                .setListaValores(getDatosGuiaRemision().getGuiaRemisionXML()
                        .getInfoTributaria()
                        .getDirMatriz(),
                        getDatosGuiaRemision().getGuiaRemisionXML()
                                .getInfoGuiaRemision()
                                .getDirEstablecimiento());
        getForm().setListaFormatos(Elemento.FORMATO_STRING, Elemento.FORMATO_STRING);
        getForm().setListaDimensiones("30", "70");
        getForm().setListaPaneles("2");
        tableIzquierda.addCell(getForm().escribeCelda());

        // Informacion de contabilidad
        getForm().setListaTitulos(TXT_11_4);
        getForm()
                .setListaValores(getDatosGuiaRemision().getGuiaRemisionXML()
                        .getInfoGuiaRemision()
                        .getContribuyenteEspecial(),
                        getDatosGuiaRemision().getGuiaRemisionXML()
                                .getInfoGuiaRemision()
                                .getObligadoContabilidad());
        getForm().setListaFormatos(Elemento.FORMATO_STRING, Elemento.FORMATO_STRING);
        getForm().setListaDimensiones("50", "50");
        getForm().setListaPaneles("2");
        tableIzquierda.addCell(getForm().escribeCelda());

        // Lado Derecho
        PdfPTable tableDerecha = new PdfPTable(1);

        // Ruc
        getH2().setTexto(TXT_11_5 + getDatosGuiaRemision().getGuiaRemisionXML()
                .getInfoTributaria()
                .getRuc());
        tableDerecha.addCell(getH2().escribeCelda());

        // Nombre del documento
        getH1().setTexto(TXT_11_6);
        tableDerecha.addCell(getH1().escribeCelda());

        // Numero del documento
        getH1()
                .setTexto(String.format(TXT_11_7, getDatosGuiaRemision().getGuiaRemisionXML()
                        .getInfoTributaria()
                        .getEstab(),
                        getDatosGuiaRemision().getGuiaRemisionXML()
                                .getInfoTributaria()
                                .getPtoEmi(),
                        getDatosGuiaRemision().getGuiaRemisionXML()
                                .getInfoTributaria()
                                .getSecuencial()));
        tableDerecha.addCell(getH1().escribeCelda());

        // Numero de autorizacion
        getH2().setTexto(TXT_11_8);
        tableDerecha.addCell(getH2().escribeCelda());
        if (getDatosGuiaRemision().isOffline())
            getP().setTexto(getDatosGuiaRemision().getClaveAccesoAutorizacion());
        else
            getP().setTexto(getDatosGuiaRemision().getNumeroAutorizacion());

        tableDerecha.addCell(getP().escribeCelda());

        // Fecha Autorizacion - modo offline
        if (!getDatosGuiaRemision().isOffline()) {
            getForm().setListaTitulos(TXT_11_9);
            getForm().setListaValores(getDatosGuiaRemision().getFechaAutorizacion());
            getForm().setListaFormatos(Elemento.FORMATO_STRING);
            getForm().setListaDimensiones("40", "60");
            getForm().setListaPaneles("1");
            tableDerecha.addCell(getForm().escribeCelda());
        }

        // Ambiente
        getForm().setListaTitulos(TXT_11_10);
        getForm().setListaValores(getDatosGuiaRemision().getAmbienteAutorizacion());
        getForm().setListaFormatos(Elemento.FORMATO_STRING);
        getForm().setListaDimensiones("40", "60");
        getForm().setListaPaneles("1");
        tableDerecha.addCell(getForm().escribeCelda());

        // Emision
        if (getDatosGuiaRemision().isOffline())
            getDatosGuiaRemision().setEmisionAutorizacion(TXT_11_13);
        getForm().setListaTitulos(TXT_11_11);
        getForm().setListaValores(getDatosGuiaRemision().getEmisionAutorizacion());
        getForm().setListaFormatos(Elemento.FORMATO_STRING);
        getForm().setListaDimensiones("40", "60");
        getForm().setListaPaneles("1");
        tableDerecha.addCell(getForm().escribeCelda());

        // Clave de acceso
        getH2().setTexto(TXT_11_12);
        tableDerecha.addCell(getH2().escribeCelda());

        // Codigo barras
        BufferedImage imagenBarras = new BufferedImage(640, 100, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = imagenBarras.createGraphics();
        g.setPaint(Color.WHITE);
        g.fillRect(0, 0, 640, 100);

        org.jbars.Barcode128 code128 = new org.jbars.Barcode128();
        code128.setCodeType(Barcode.CODE128);
        code128.setCode(getDatosGuiaRemision().getClaveAccesoAutorizacion());
        code128.placeBarcode(imagenBarras, Color.black, Color.blue);

        getImagen().setImagen(imagenBarras);
        getImagen().setScala(35f);
        tableDerecha.addCell(getImagen().escribeCelda());

        table.addCell(tableIzquierda);
        table.addCell(tableDerecha);
        try {
            getDocumento().add(table);
        } catch (DocumentException e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, e.toString());
        }
    }

    /**
     * Metodo para escribir la informacion del Transportista.
     *
     */
    private synchronized void elemento11() throws Exception {
        espacios(2);

        informacionTransportista();

        PdfPTable table = new PdfPTable(1);
        table.setWidthPercentage(100f);
        PdfPCell pdfPCell = getForm().escribeCelda();
        pdfPCell.setBorder(Rectangle.BOX);

        table.addCell(pdfPCell);

        try {
            getDocumento().add(table);
        } catch (DocumentException e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, e.toString());
        }
    }

    /**
     * Metodo para imprimir el detalle de la guiaRemision
     *
     */
    private synchronized void elemento12() throws Exception {
        if (getDatosGuiaRemision().getGuiaRemisionXML().getDestinatarios() != null &&
                !getDatosGuiaRemision().getGuiaRemisionXML().getDestinatarios().getDestinatario().isEmpty()) {
            for (int i = 0; i < getDatosGuiaRemision().getGuiaRemisionXML()
                    .getDestinatarios()
                    .getDestinatario()
                    .size(); i++) {

                if (getPdfWriter().getVerticalPosition(true) < 176)
                    getDocumento().newPage();

                espacios(2);

                PdfPTable table1 = new PdfPTable(1);
                table1.setWidthPercentage(100f);

                informacionDestinanario1(i);
                PdfPCell pdfPCell = getForm().escribeCelda();
                table1.addCell(pdfPCell);

                informacionDestinanario2(i);
                pdfPCell = getForm().escribeCelda();
                table1.addCell(pdfPCell);

                informacionDestinanario3(i);
                pdfPCell = getForm().escribeCelda();
                table1.addCell(pdfPCell);

                informacionDetalleEnvio(i);

                PdfPTable table = new PdfPTable(1);
                table.setWidthPercentage(100f);
                table.addCell(table1);
                pdfPCell = getTabla().escribeCelda();
                pdfPCell.setBorder(Rectangle.BOX);

                table.addCell(pdfPCell);

                try {
                    getDocumento().add(table);
                } catch (DocumentException e) {
                    Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, e.toString());
                }
            }
            if (getPdfWriter().getVerticalPosition(true) < 140)
                getDocumento().newPage();
        }
    }

    /**
     * Metodo para agregar una imagen con la firma de un documento
     *
     * Esta firma no es legal ni optima para el SRI.
     *
     * @throws Exception
     */
    private synchronized void elemento13() throws Exception {
        String firmaGrafica = getDatosGuiaRemision().getPathFirmaGrafica();

        if (firmaGrafica != null && !firmaGrafica.isEmpty()) {
            if (getPdfWriter().getVerticalPosition(true) < 105) {
                getDocumento().newPage();
            }

            PdfPTable table = new PdfPTable(1);
            table.setWidthPercentage(100);
            getImagen1().setPath(firmaGrafica);
            getImagen1().setScala(30f);

            PdfPCell celda = getImagen1().escribeCelda();
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
     * Metodo para agregar la informaci\u00f3n del documento
     *
     */
    private synchronized void elemento3() {
        getH1().setTexto(TXT_3_1);
        getH1().escribe();

        getH1()
                .setTexto(String.format(TXT_3_2, getDatosGuiaRemision().getGuiaRemisionXML()
                        .getInfoTributaria()
                        .getEstab(),
                        getDatosGuiaRemision().getGuiaRemisionXML()
                                .getInfoTributaria()
                                .getPtoEmi(),
                        getDatosGuiaRemision().getGuiaRemisionXML()
                                .getInfoTributaria()
                                .getSecuencial()));
        getH1().escribe();

        espacios(1);
        getForm().setListaTitulos(TXT_3_3);

        getForm()
                .setListaValores(getDatosGuiaRemision().getNumeroAutorizacion(),
                        getDatosGuiaRemision().getFechaAutorizacion(),
                        getDatosGuiaRemision().getAmbienteAutorizacion(),
                        getDatosGuiaRemision().getEmisionAutorizacion());
        getForm()
                .setListaFormatos(Elemento.FORMATO_STRING, Elemento.FORMATO_STRING, Elemento.FORMATO_STRING,
                        Elemento.FORMATO_STRING);
        getForm().setListaDimensiones("25", "75");
        getForm().setListaPaneles("4");
        getForm().escribe();
    }

    /**
     * Metodo para escribir el codigo de barras de la clave de acceso.
     *
     */
    private synchronized void elemento4() {
        getForm().setListaTitulos(TXT_4_1);

        getForm().setListaValores("");
        getForm().setListaFormatos(Elemento.FORMATO_STRING);
        getForm().setListaDimensiones("25", "75");
        getForm().setListaPaneles("1");
        getForm().escribe();

        BufferedImage imagenBarras = new BufferedImage(640, 100, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = imagenBarras.createGraphics();
        g.setPaint(Color.WHITE);
        g.fillRect(0, 0, 640, 100);

        org.jbars.Barcode128 code128 = new org.jbars.Barcode128();
        code128.setCodeType(Barcode.CODE128);
        code128.setCode(getDatosGuiaRemision().getClaveAccesoAutorizacion());
        code128.placeBarcode(imagenBarras, Color.black, Color.blue);

        getImagen().setImagen(imagenBarras);
        getImagen().setScala(35f);
        getImagen().setX(165);
        getImagen().setY(680);
        getImagen().escribe();
    }

    /**
     * Metodo para escribir la informacion de la empresa
     *
     * @throws Exception
     */
    private synchronized void elemento5() throws Exception {
        espacios(5);
        getLinea().escribe();
        getH2().setTexto(getDatosGuiaRemision().getGuiaRemisionXML()
                .getInfoTributaria()
                .getRazonSocial());
        getH2().escribe();

        espacios(1);

        if (getDatosGuiaRemision().getGuiaRemisionXML()
                .getInfoGuiaRemision()
                .getObligadoContabilidad() == null
                || getDatosGuiaRemision().getGuiaRemisionXML()
                        .getInfoGuiaRemision()
                        .getObligadoContabilidad()
                        .trim()
                        .length() == 0)
            getForm().setListaTitulos(TXT_5_2);
        else
            getForm().setListaTitulos(TXT_5_1);
        getForm()
                .setListaValores(getDatosGuiaRemision().getGuiaRemisionXML()
                        .getInfoTributaria()
                        .getRuc(),
                        getDatosGuiaRemision().getGuiaRemisionXML()
                                .getInfoTributaria()
                                .getDirMatriz(),
                        getDatosGuiaRemision().getGuiaRemisionXML()
                                .getInfoGuiaRemision()
                                .getDirEstablecimiento(),
                        getDatosGuiaRemision().getGuiaRemisionXML()
                                .getInfoGuiaRemision()
                                .getContribuyenteEspecial(),
                        getDatosGuiaRemision().getGuiaRemisionXML()
                                .getInfoGuiaRemision()
                                .getObligadoContabilidad());
        getForm()
                .setListaFormatos(Elemento.FORMATO_STRING, Elemento.FORMATO_STRING, Elemento.FORMATO_STRING,
                        Elemento.FORMATO_STRING, Elemento.FORMATO_STRING);
        getForm().setListaDimensiones("25", "75");
        getForm().setListaPaneles("5");
        getForm().escribe();
    }

    /**
     * Metodo para escribir la informacion del Transportista.
     *
     */
    private synchronized void elemento6() throws Exception {
        espacios(2);
        getLinea().escribe();

        informacionTransportista();

        getForm().escribe();
    }

    /**
     * Metodo para crear la informacion del cliente
     *
     */
    private void informacionDestinanario1(int i) {
        getForm().setListaTitulos(TXT_7_10);
        getForm()
                .setListaValores(TablasSRI.Tabla4(getDatosGuiaRemision().getGuiaRemisionXML()
                        .getDestinatarios()
                        .getDestinatario()
                        .get(i)
                        .getCodDocSustento()),
                        getDatosGuiaRemision().getGuiaRemisionXML()
                                .getDestinatarios()
                                .getDestinatario()
                                .get(i)
                                .getNumDocSustento(),
                        getDatosGuiaRemision().getGuiaRemisionXML()
                                .getDestinatarios()
                                .getDestinatario()
                                .get(i)
                                .getFechaEmisionDocSustento(),
                        getDatosGuiaRemision().getGuiaRemisionXML()
                                .getDestinatarios()
                                .getDestinatario()
                                .get(i)
                                .getNumAutDocSustento(),
                        getDatosGuiaRemision().getGuiaRemisionXML()
                                .getDestinatarios()
                                .getDestinatario()
                                .get(i)
                                .getMotivoTraslado());
        getForm()
                .setListaFormatos(Elemento.FORMATO_STRING, Elemento.FORMATO_STRING, Elemento.FORMATO_STRING,
                        Elemento.FORMATO_STRING, Elemento.FORMATO_STRING);
        getForm().setListaDimensiones("25", "75");
        getForm().setListaPaneles("5");
    }

    /**
     * Metodo para crear la informacion del cliente
     *
     */
    private void informacionDestinanario2(int i) {
        getForm().setListaTitulos(TXT_7_11);
        getForm()
                .setListaValores(getDatosGuiaRemision().getGuiaRemisionXML()
                        .getDestinatarios()
                        .getDestinatario()
                        .get(i)
                        .getRazonSocialDestinatario(),
                        getDatosGuiaRemision().getGuiaRemisionXML()
                                .getDestinatarios()
                                .getDestinatario()
                                .get(i)
                                .getIdentificacionDestinatario(),
                        getDatosGuiaRemision().getGuiaRemisionXML()
                                .getDestinatarios()
                                .getDestinatario()
                                .get(i)
                                .getDirDestinatario());
        getForm().setListaFormatos(Elemento.FORMATO_STRING, Elemento.FORMATO_STRING, Elemento.FORMATO_STRING);
        getForm().setListaDimensiones("25", "75");
        getForm().setListaPaneles("3");
    }

    /**
     * Metodo para crear la informacion del cliente
     *
     */
    private void informacionDestinanario3(int i) {
        getForm().setListaTitulos(TXT_7_12);
        getForm()
                .setListaValores(getDatosGuiaRemision().getGuiaRemisionXML()
                        .getDestinatarios()
                        .getDestinatario()
                        .get(i)
                        .getDocAduaneroUnico(),
                        getDatosGuiaRemision().getGuiaRemisionXML()
                                .getDestinatarios()
                                .getDestinatario()
                                .get(i)
                                .getCodEstabDestino(),
                        getDatosGuiaRemision().getGuiaRemisionXML()
                                .getDestinatarios()
                                .getDestinatario()
                                .get(i)
                                .getRuta());
        getForm().setListaFormatos(Elemento.FORMATO_STRING, Elemento.FORMATO_STRING, Elemento.FORMATO_STRING);
        getForm().setListaDimensiones("25", "75");
        getForm().setListaPaneles("3");
    }

    /**
     * Crea la tabla de envios a de mercader\u00eda de la guia de remisi\u00f3n.
     *
     * @param i
     */
    private void informacionDetalleEnvio(int i) {
        Vector vector = new Vector();
        List<String> listaValores = new ArrayList();

        for (Detalle a : getDatosGuiaRemision().getGuiaRemisionXML()
                .getDestinatarios()
                .getDestinatario()
                .get(i)
                .getDetalles()
                .getDetalle()) {

            listaValores = new ArrayList<>();
            listaValores.add(0, a.getCodigoInterno());
            listaValores.add(1, a.getCodigoAdicional());
            listaValores.add(2, a.getDescripcion());
            listaValores.add(3, a.getCantidad() + "");
            vector.add(listaValores);

            if (a.getDetallesAdicionales() != null && !a.getDetallesAdicionales().getDetAdicional().isEmpty()) {
                for (Detalle.DetallesAdicionales.DetAdicional b : a.getDetallesAdicionales().getDetAdicional()) {
                    listaValores = new ArrayList<>();
                    listaValores.add(0, "");
                    listaValores.add(1, "");
                    listaValores.add(2, b.getNombre() + ": " + b.getValor());
                    listaValores.add(3, "");
                    vector.add(listaValores);
                }
            }
        }
        getTabla().setListaTitulos(TXT_7_2);
        getTabla()
                .setListaFormatos(Elemento.FORMATO_STRING, Elemento.FORMATO_STRING, Elemento.FORMATO_STRING,
                        Elemento.FORMATO_STRING);
        getTabla().setListaDimensiones("15", "15", "60", "10");
        getTabla().setListaAlineacion(Element.ALIGN_LEFT, Element.ALIGN_LEFT, Element.ALIGN_LEFT, Element.ALIGN_RIGHT);
        getTabla().setVectorDatos(vector);
        getTabla().setAncho(100);
    }

    /**
     * Metodo para informacion del transportista.
     *
     */
    private void informacionTransportista() {
        getForm().setListaTitulos(TXT_6_1);
        getForm()
                .setListaValores(getDatosGuiaRemision().getGuiaRemisionXML()
                        .getInfoGuiaRemision()
                        .getRazonSocialTransportista(),
                        getDatosGuiaRemision().getGuiaRemisionXML()
                                .getInfoGuiaRemision()
                                .getRucTransportista(),
                        getDatosGuiaRemision().getGuiaRemisionXML()
                                .getInfoGuiaRemision()
                                .getPlaca(),
                        getDatosGuiaRemision().getGuiaRemisionXML()
                                .getInfoGuiaRemision()
                                .getDirPartida(),
                        getDatosGuiaRemision().getGuiaRemisionXML()
                                .getInfoGuiaRemision()
                                .getFechaIniTransporte(),
                        getDatosGuiaRemision().getGuiaRemisionXML()
                                .getInfoGuiaRemision()
                                .getFechaFinTransporte(),
                        getDatosGuiaRemision().getGuiaRemisionXML()
                                .getInfoGuiaRemision()
                                .getRise());
        getForm()
                .setListaFormatos(Elemento.FORMATO_STRING, Elemento.FORMATO_STRING, Elemento.FORMATO_STRING,
                        Elemento.FORMATO_STRING, Elemento.FORMATO_STRING, Elemento.FORMATO_STRING,
                        Elemento.FORMATO_STRING);
        getForm().setListaDimensiones("25", "75");
        getForm().setListaPaneles("8");
    }

    /**
     * Metodo para imprimir el detalle de la guiaRemision
     *
     *
     */
    private synchronized void elemento7() throws Exception {
        if (getDatosGuiaRemision().getGuiaRemisionXML().getDestinatarios() != null &&
                !getDatosGuiaRemision().getGuiaRemisionXML()
                        .getDestinatarios()
                        .getDestinatario().isEmpty()) {

            for (int i = 0; i < getDatosGuiaRemision().getGuiaRemisionXML()
                    .getDestinatarios()
                    .getDestinatario()
                    .size(); i++) {

                if (getPdfWriter().getVerticalPosition(true) < 176)
                    getDocumento().newPage();

                espacios(2);
                getLinea().escribe();

                informacionDestinanario1(i);
                getForm().escribe();
                espacios(1);

                informacionDestinanario2(i);
                getForm().escribe();
                espacios(1);

                informacionDestinanario3(i);
                getForm().escribe();
                espacios(1);

                espacios(2);
                getLinea().escribe();
                informacionDetalleEnvio(i);
                getTabla().escribe();
            }
            if (getPdfWriter().getVerticalPosition(true) < 140)
                getDocumento().newPage();
        }
    }

    /**
     * Metodo para agregar informaci\u00f3n adicional.
     *
     */
    private synchronized void elemento9() throws Exception {
        int size = 0;

        if (getDatosGuiaRemision().getGuiaRemisionXML().getInfoAdicional() != null &&
                !getDatosGuiaRemision().getGuiaRemisionXML()
                        .getInfoAdicional()
                        .getCampoAdicional().isEmpty()) {

            for (GuiaRemision.InfoAdicional.CampoAdicional a : getDatosGuiaRemision().getGuiaRemisionXML()
                    .getInfoAdicional()
                    .getCampoAdicional()) {

                if (!a.getNombre().startsWith("js")) {
                    getForm().getListaTitulos().add(a.getNombre());
                    getForm().getListaValores().add((a.getValue() == null) ? "" : String.valueOf(a.getValue()));
                    getForm().getListaFormatos().add(Elemento.FORMATO_STRING);
                    size++;
                }
            }

            if (size > 0) {

                int total = 74 + (12 * size);

                if (getPdfWriter().getVerticalPosition(true) < total)
                    getDocumento().newPage();

                espacios(2);

                getH2().setTexto(TXT_10_1);
                getH2().escribe();
                espacios(2);

                getForm().setListaDimensiones("25", "75");
                getForm().setListaPaneles(size + "");
                getForm().escribe();
            }
        }
    }

    public DatosGuiaRemision getDatosGuiaRemision() {
        return datosGuiaRemision;
    }

    public void setDatosGuiaRemision(DatosGuiaRemision datosGuiaRemision) {
        this.datosGuiaRemision = datosGuiaRemision;
    }
}
