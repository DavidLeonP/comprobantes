package com.aplicaciones13.documentos.impresion.ensamble.ride;

import com.aplicaciones13.documentos.estruturas.factura.v2_1_0.Pagos.Pago;
import com.aplicaciones13.documentos.impresion.elementos.texto.Elemento;
import com.aplicaciones13.documentos.impresion.ensamble.ImpresionElementosBase;
import com.aplicaciones13.documentos.estruturas.factura.v2_1_0.Factura;

import com.aplicaciones13.documentos.utilidades.BundleMessages;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.layout.property.TextAlignment;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import java.io.File;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import org.jbars.Barcode;

/**
 * Objeto para crear un documento de factura.
 *
 * @author omargo33
 *
 */
@Slf4j
@Data
@EqualsAndHashCode(callSuper = false)
public class ImpresionElementosFactura extends ImpresionElementosBase {

    private static BundleMessages bundle = new BundleMessages("elementos-ride");

    protected static String ELEMENTO_1 = "1";
    protected static String ELEMENTO_2 = "2";
    protected static String ELEMENTO_3 = "3";
    protected static String ELEMENTO_4 = "4";
    protected static String ELEMENTO_5 = "5";
    protected static String ELEMENTO_6 = "6";
    protected static String ELEMENTO_7 = "7";
    protected static String ELEMENTO_8 = "8";
    protected static String ELEMENTO_9 = "9";
    protected static String ELEMENTO_10 = "10";
    protected static String ELEMENTO_11 = "11";
    protected static String ELEMENTO_12 = "12";
    protected static String ELEMENTO_13 = "13";
    protected static String ELEMENTO_14 = "14";
    protected static String ELEMENTO_15 = "15";
    protected static String ELEMENTO_16 = "16";
    protected static String ELEMENTO_17 = "17";
    protected static String ELEMENTO_18 = "18";

    private static String TXT_3_1 = "Factura";
    private static String TXT_3_2 = "No. %s-%s-%s";
    private static String TXT_3_3[] = {
            "No.: Autorizaci\u00f3n", "Fecha Autorizaci\u00f3n", "Ambiente", "Emisi\u00f3n" };
    private static String TXT_4_1 = "Clave de Acceso";
    private static String TXT_5_1[] = {
            "RUC", "Direcci\u00f3n Matriz", "Direcci\u00f3n Establecimiento", "Contribuyente especial Nro.",
            "Obligado a llevar contabilidad"
    };

    private static String TXT_5_2[] = {
            "RUC", "Direcci\u00f3n Matriz", "Direcci\u00f3n Establecimiento", "Contribuyente especial Nro.", ""
    };

    private static String TXT_6_1[] = {
            "Raz\u00f3n Social", "RUC / CI.", "Fecha Emisi\u00f3n", "Gu\u00eda Remisi\u00f3n" };
    private static String TXT_7_1[] = { "Cod.", "Descripci\u00f3n", "Cant.", "Precio Uni.", "Desc.", "Total" };

    private static String TOTALES[] = {
            "SUBTOTAL 15%", "SUBTOTAL 0%", "SUBTOTAL No Sujeto de IVA", "SUBTOTAL", "DESCUENTO", "ICE", "IVA 15%",
            "PROPINA",
            "FLETE INTERNACIONAL", "SEGURO INTERNACIONAL", "GASTOS ADUANEROS", "OTROS GASTOS DE TRANSPORTE",
            "VALOR TOTAL"
    };

    private static String TOTALES_EXPORTACION[] = {
            "", "", "IVA 0%", "TOTAL", "", "", "", "", "FLETE", "SEGURO", "GASTOS ADUANEROS",
            "OTROS GASTOS DE TRANSPORTE",
            "TOTAL"
    };

    private static String TOTALES_PRESENTACION[] = {
            "1", "1", "1 2", "1 2", "1", "1", "1", "1", "2", "2", "2", "2", "1 2" };

    private static String TXT_10_1 = "Informaci\u00f3n Adicional";

    private static String TXT_11_3[] = { "Direcci\u00f3n Matriz", "Direcci\u00f3n Establecimiento" };
    private static String TXT_11_4[] = { "Contribuyente especial Nro.", "Obligado a llevar contabilidad" };
    private static String TXT_11_5 = "RUC: ";
    private static String TXT_11_6 = "Factura";
    private static String TXT_11_7 = "No.: %s-%s-%s";
    private static String TXT_11_8 = "N\u00famero Autorizaci\u00f3n";
    private static String TXT_11_10 = "Ambiente";
    private static String TXT_11_11 = "Emisi\u00f3n";
    private static String TXT_11_12 = "Clave de Acceso";

    private static String TXT_14_1 = "Formas de Pago";

    private static String TXT_15_1 = "Informaci\u00f3n Exportaci\u00f3n";
    private static String TXT_15_2[] = {
            "T\u00e9rminos de negociaci\u00f3n", "Lugar de negociaci\u00f3n", "Pa\u00eds Origen", "Puerto Embarque",
            "Pa\u00eds Destino", "Puerto Destino", "Pa\u00eds Adquisici\u00f3n"
    };

    private Factura factura;
    List<TotalDocumentoFactura> totales;
   

    /* 
    public synchronized void elemento_1() {
        Pie pie = new Pie(TXT_3_1);
        pie.setNumeroDocumento(getFactura().getInfoTributaria()
                .getEstab() + "-"
                + getFactura().getInfoTributaria()
                        .getPtoEmi()
                + "-" +
                getFactura()
                        .getInfoTributaria()
                        .getSecuencial());
        getPdfWriter().setPageEvent(pie);
    }*/

    /**
     * Metodo para generar el logo del documento.
     *
     * Si el archivo no existe
     * Agrega un logo temporal
     * Imprime el logo.
     *
     */
    public synchronized void elemento_2() throws Exception {

        if (new File(getPathLogo()).isFile()) {
            throw new Exception("No se encontro el archivo de logo");
        }
        getImagen().setPath(getPathLogo());
        getImagen().setEscala(50f);
        getImagen().setX(400);
        getImagen().setY(690);
        getImagen().escribir();
    }

    /**
     * Metodo para generar el panel superior en un formato semejante al SRI.
     *
     */
    public synchronized void elemento_10() throws Exception {
        PdfPTable table = new PdfPTable(2);

        table.setWidthPercentage(100);

        // Lado Izquierdo
        PdfPTable tableIzquierda = new PdfPTable(1);

        // Logotipo lado Izquierdo

        if (new File(getPathLogo()).isFile()) {
            throw new Exception("No se encontro el archivo de logo");
        }

        getImagen().setPath(getPathLogo());
        getImagen().setEscala(50f);
        tableIzquierda.addCell(getImagen().escribeCelda());

        // Nombre de la empresa
        getH1().setTexto(getFactura()
                .getInfoTributaria()
                .getRazonSocial());
        tableIzquierda.addCell(getH1().escribeCelda());

        // Informacion de la empresa
        getForm().setListaTitulos((Object[]) TXT_11_3);
        getForm().setListaValores(getFactura()
                .getInfoTributaria()
                .getDirMatriz(),
                getFactura()
                        .getInfoFactura()
                        .getDirEstablecimiento());
        getForm().setListaFormatos(Elemento.FORMATO_STRING, Elemento.FORMATO_STRING);
        getForm().setListaDimensiones(30.0f, 70.0f);
        getForm().setListaPaneles(2);
        tableIzquierda.addCell(getForm().escribeCelda());

        // Informacion de contabilidad
        getForm().setListaTitulos((Object[]) TXT_11_4);
        getForm()
                .setListaValores(getFactura()
                        .getInfoFactura()
                        .getContribuyenteEspecial(),
                        getFactura()
                                .getInfoFactura()
                                .getObligadoContabilidad());
        getForm().setListaFormatos(Elemento.FORMATO_STRING, Elemento.FORMATO_STRING);
        getForm().setListaDimensiones(50f, 50f);
        getForm().setListaPaneles("2");
        tableIzquierda.addCell(getForm().escribeCelda());

        // Lado Derecho
        PdfPTable tableDerecha = new PdfPTable(1);

        // Ruc
        getH2().setTexto(TXT_11_5 + getFactura()
                .getInfoTributaria()
                .getRuc());
        tableDerecha.addCell(getH2().escribeCelda());

        // Nombre del documento
        getH1().setTexto(TXT_11_6);
        tableDerecha.addCell(getH1().escribeCelda());

        // Numero del documento
        getH1()
                .setTexto(String.format(TXT_11_7, getFactura()
                        .getInfoTributaria()
                        .getEstab(),
                        getFactura()
                                .getInfoTributaria()
                                .getPtoEmi(),
                        getFactura().getInfoTributaria()
                                .getSecuencial()));
        tableDerecha.addCell(getH1().escribeCelda());

        // Numero de autorizacion
        getH2().setTexto(TXT_11_8);
        tableDerecha.addCell(getH2().escribeCelda());

        getP().setTexto(getNumeroAutorizacion());

        tableDerecha.addCell(getP().escribeCelda());

        // Ambiente
        getForm().setListaTitulos(TXT_11_10);
        getForm().setListaValores(getAmbienteAutorizacion());
        getForm().setListaFormatos(Elemento.FORMATO_STRING);
        getForm().setListaDimensiones(40f, 60f);
        getForm().setListaPaneles("1");
        tableDerecha.addCell(getForm().escribeCelda());

        // Emision
        getForm().setListaTitulos(TXT_11_11);
        getForm().setListaValores(getEmisionAutorizacion());
        getForm().setListaFormatos(Elemento.FORMATO_STRING);
        getForm().setListaDimensiones(40f, 60f);
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
        code128.setCode(getClaveAccesoAutorizacion());
        code128.placeBarcode(imagenBarras, Color.black, Color.blue);

        getImagen().setImagen(imagenBarras);
        getImagen().setEscala(35f);
        tableDerecha.addCell(getImagen().escribeCelda());

        table.addCell(tableIzquierda);
        table.addCell(tableDerecha);
        try {
            getDocumento().add(table);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    /**
     * Metodo para escribir la informacion del cliente.
     *
     */
    public synchronized void elemento_11() throws Exception {
        getEspacio().escribir(2);

        informacionCliente();

        PdfPTable table = new PdfPTable(1);
        table.setWidthPercentage(100f);
        PdfPCell pdfPCell = getForm().escribeCelda();
        pdfPCell.setBorder(Rectangle.BOX);

        table.addCell(pdfPCell);

        try {
            getDocumento().add(table);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    /**
     * Metodo para escribir la informacion del cliente.
     *
     */
    public synchronized void elemento_12() throws Exception {
        getEspacio().escribir(2);

        if (getFactura().getDetalles() != null && getFactura()
                .getDetalles()
                .getDetalle()
                .size() > 0) {

            detalleFacturaCompleta();

            PdfPTable table = new PdfPTable(1);
            table.setWidthPercentage(100f);
            PdfPCell pdfPCell = getTabla().escribeCelda();
            pdfPCell.setBorder(Rectangle.BOX);

            table.addCell(pdfPCell);

            try {
                getDocumento().add(table);
            } catch (Exception e) {
                throw new Exception(e);
            }

            if (getPdfWriter().getVerticalPosition(true) < 140)
                getDocumento().newPage();
        }
    }

    /**
     * Metodo para agregar la informaci\u00f3n del documento
     *
     */
    public synchronized void elemento_3() {
        getH1().setTexto(TXT_3_1);
        getH1().escribir();

        getH1()
                .setTexto(String.format(TXT_3_2, getFactura()
                        .getInfoTributaria()
                        .getEstab(),
                        getFactura()
                                .getInfoTributaria()
                                .getPtoEmi(),
                        getFactura()
                                .getInfoTributaria()
                                .getSecuencial()));
        getH1().escribir();

        getEspacio().escribir(1);
        getForm().setListaTitulos((Object[]) TXT_3_3);

        getForm()
                .setListaValores(getNumeroAutorizacion(), getFechaAutorizacion(),
                        getAmbienteAutorizacion(), getEmisionAutorizacion());
        getForm()
                .setListaFormatos(Elemento.FORMATO_STRING, Elemento.FORMATO_STRING, Elemento.FORMATO_STRING,
                        Elemento.FORMATO_STRING);
        getForm().setListaDimensiones(25f, 75f);
        getForm().setListaPaneles("4");
        getForm().escribir();
    }

    /**
     * Metodo para escribir el codigo de barras de la clave de acceso.
     *
     */
    public synchronized void elemento_4() {

        getForm().setListaTitulos(TXT_4_1);

        getForm().setListaValores("");
        getForm().setListaFormatos(Elemento.FORMATO_STRING);
        getForm().setListaDimensiones(25f, 75f);
        getForm().setListaPaneles("1");
        getForm().escribir();

        BufferedImage imagenBarras = new BufferedImage(640, 100, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = imagenBarras.createGraphics();
        g.setPaint(Color.WHITE);
        g.fillRect(0, 0, 640, 100);

        org.jbars.Barcode128 code128 = new org.jbars.Barcode128();
        code128.setCodeType(Barcode.CODE128);
        code128.setCode(getClaveAccesoAutorizacion());
        code128.placeBarcode(imagenBarras, Color.black, Color.blue);

        getImagen().setImagen(imagenBarras);
        getImagen().setEscala(35f);
        getImagen().setX(165);
        getImagen().setY(680);
        getImagen().escribir();
    }

    /**
     * Metodo para escribir la informacion de la empresa
     *
     * @throws Exception
     */
    public synchronized void elemento_5() throws Exception {
        getEspacio().escribir(5);
        getLineaSolida().escribir();
        getH2().setTexto(getFactura()
                .getInfoTributaria()
                .getRazonSocial());
        getH2().escribir();

        getEspacio().escribir(1);

        if (getFactura()
                .getInfoFactura()
                .getObligadoContabilidad() == null
                || getFactura()
                        .getInfoFactura()
                        .getObligadoContabilidad()
                        .value()
                        .trim()
                        .length() == 0)
            getForm().setListaTitulos(TXT_5_2);
        else
            getForm().setListaTitulos(TXT_5_1);

        getForm()
                .setListaValores(getFactura()
                        .getInfoTributaria()
                        .getRuc(),
                        getFactura()
                                .getInfoTributaria()
                                .getDirMatriz(),
                        getFactura().getInfoFactura()
                                .getDirEstablecimiento(),
                        getFactura()
                                .getInfoFactura()
                                .getContribuyenteEspecial(),
                        getFactura()
                                .getInfoFactura()
                                .getObligadoContabilidad());
        getForm()
                .setListaFormatos(Elemento.FORMATO_STRING, Elemento.FORMATO_STRING, Elemento.FORMATO_STRING,
                        Elemento.FORMATO_STRING, Elemento.FORMATO_STRING);
        getForm().setListaDimensiones(25f, 75f);
        getForm().setListaPaneles("5");
        getForm().escribir();
    }

    /**
     * Metodo para escribir la informacion del cliente.
     *
     */
    public synchronized void elemento_6() throws Exception {
        getEspacio().escribir(2);
        getLineaSolida().escribir();

        informacionCliente();

        getForm().escribir();
    }

    /**
     * Metodo para crear la informacion del cliente
     *
     */
    private void informacionCliente() {
        getForm().setListaTitulos(TXT_6_1);
        getForm()
                .setListaValores(getFactura()
                        .getInfoFactura()
                        .getRazonSocialComprador(),
                        getFactura()
                                .getInfoFactura()
                                .getIdentificacionComprador(),
                        getFactura()
                                .getInfoFactura()
                                .getFechaEmision(),
                        getFactura()
                                .getInfoFactura()
                                .getGuiaRemision());
        getForm()
                .setListaFormatos(Elemento.FORMATO_STRING, Elemento.FORMATO_STRING, Elemento.FORMATO_STRING,
                        Elemento.FORMATO_STRING);
        getForm().setListaDimensiones(25f, 75f);
        getForm().setListaPaneles("7");
    }

    /**
     * Metodo para imprimir el detalle de la factura
     *
     * Si los datos en la factura existen
     * Llena el vector de datos a ser recorridos
     * Si existe codigo auxiliar
     * Agrega los datos para la ubicacion en pantalla
     * Caso contrario
     * Agrega los datos para la ubicacion en pantalla sin el codigo auxiliar
     *
     */
    public synchronized void elemento_7() throws Exception {
        getEspacio().escribir(2);

        if (getFactura().getDetalles() != null && getFactura()
                .getDetalles()
                .getDetalle()
                .size() > 0) {

            getLineaSolida().escribir();

            detalleFacturaCompleta();

            getTabla().escribir();

            getLineaSolida().escribir();
            if (getPdfWriter().getVerticalPosition(true) < 140)
                getDocumento().newPage();
        }
    }

    /**
     * Metodo para detalle Factura completa.
     *
     */
    public void detalleFacturaCompleta() {
        Vector vector = new Vector();
        List<String> listaValores = new ArrayList<String>();

        for (Factura.Detalles.Detalle a : getFactura()
                .getDetalles()
                .getDetalle()) {
            listaValores = new ArrayList<String>();
            listaValores.add(0, a.getCodigoPrincipal());
            listaValores.add(1, a.getDescripcion());
            listaValores.add(2, a.getCantidad().toString());
            listaValores.add(3, a.getPrecioUnitario().toString());
            listaValores.add(4, a.getDescuento().toString());
            listaValores.add(5, a.getPrecioTotalSinImpuesto().toString());
            vector.add(listaValores);

            if (a.getCodigoAuxiliar() != null && a.getCodigoAuxiliar()
                    .trim()
                    .length() > 0) {
                listaValores = new ArrayList<String>();
                listaValores.add(0, "");
                listaValores.add(1, "Cod.: " + a.getCodigoAuxiliar());
                listaValores.add(2, "");
                listaValores.add(3, "");
                listaValores.add(4, "");
                listaValores.add(5, "");
                vector.add(listaValores);
            }

            if (a.getDetallesAdicionales() != null && a.getDetallesAdicionales()
                    .getDetAdicional()
                    .size() > 0) {
                for (Factura.Detalles.Detalle.DetallesAdicionales.DetAdicional b : a.getDetallesAdicionales()
                        .getDetAdicional()) {
                    listaValores = new ArrayList<String>();
                    listaValores.add(0, "");
                    listaValores.add(1, b.getNombre() + ": " + b.getValor());
                    listaValores.add(2, "");
                    listaValores.add(3, "");
                    listaValores.add(4, "");
                    listaValores.add(5, "");
                    vector.add(listaValores);
                }
            }

            getTabla().setListaTitulos(TXT_7_1);
            getTabla()
                    .setListaFormatos(Elemento.FORMATO_STRING, Elemento.FORMATO_STRING, Elemento.FORMATO_STRING,
                            Elemento.FORMATO_STRING, Elemento.FORMATO_STRING, Elemento.FORMATO_STRING);
            getTabla().setListaDimensiones(10f, 10f, 35f, 10f, 10f, 10f, 15f);
            getTabla().getMapaAlineamiento().put(1, TextAlignment.LEFT);
            getTabla().getMapaAlineamiento().put(2, TextAlignment.LEFT);
            getTabla().getMapaAlineamiento().put(3, TextAlignment.RIGHT);
            getTabla().getMapaAlineamiento().put(4, TextAlignment.RIGHT);
            getTabla().getMapaAlineamiento().put(5, TextAlignment.RIGHT);
            getTabla().getMapaAlineamiento().put(6, TextAlignment.RIGHT);
        }
        getTabla().setListaTitulos(TXT_7_1);

        getTabla()
                .setListaFormatos(Elemento.FORMATO_STRING, Elemento.FORMATO_STRING, Elemento.FORMATO_STRING,
                        Elemento.FORMATO_STRING, Elemento.FORMATO_STRING, Elemento.FORMATO_STRING);
        getTabla().setListaDimensiones(15f, 40f, 10f, 10f, 10f, 15f);
        
        getTabla().getMapaAlineamiento().put(1, TextAlignment.LEFT);
        getTabla().getMapaAlineamiento().put(2, TextAlignment.LEFT);
        getTabla().getMapaAlineamiento().put(3, TextAlignment.RIGHT);
        getTabla().getMapaAlineamiento().put(4, TextAlignment.RIGHT);
        getTabla().getMapaAlineamiento().put(5, TextAlignment.RIGHT);
        getTabla().getMapaAlineamiento().put(6, TextAlignment.RIGHT);

        getTabla().setVectorDatos(vector);
        getTabla().setAncho(100);
    }

    /**
     * Metodo para agregar los totales de la factura
     *
     */
    public synchronized void elemento_8() throws Exception {
        getEspacio().escribir(2);

        subTotales();
        getForm().escribir();

        //getLineaSolida().setWidthPercentage(34);
        getLineaSolida().escribir();

        totales();
        getForm().escribir();
    }

    /**
     * Metodo para agregar los totales de la factura
     *
     */
    public synchronized void elemento_13() throws Exception {
        getEspacio().escribir(2);

        PdfPTable tableTotales = new PdfPTable(1);
        tableTotales.getDefaultCell().setBorder(0);
        tableTotales.setWidthPercentage(100f);

        subTotales();

        PdfPCell pdfPCell1SubTotales = getForm().escribeCelda();
        pdfPCell1SubTotales.setBorderWidthBottom(0f);
        tableTotales.addCell(pdfPCell1SubTotales);

        PdfPCell pdfPCellLinea = new PdfPCell();
        PdfPTable tableLinea = new PdfPTable(1);
        tableLinea.setWidthPercentage(100f);
        tableLinea.getDefaultCell().setBorder(0);
        tableTotales.addCell(getLineaSolida().escribeCelda());

        pdfPCellLinea.addElement(tableLinea);
        tableTotales.addCell(pdfPCellLinea);

        totales();
        PdfPCell pdfPCellSumatoria = getForm().escribeCelda();
        pdfPCellSumatoria.setBorderWidthTop(0f);
        tableTotales.addCell(pdfPCellSumatoria);

        PdfPTable tableCompleta = new PdfPTable(2);
        tableCompleta.setWidthPercentage(100f);

        PdfPCell pdfPCellTotales = new PdfPCell();
        pdfPCellTotales.setBorderWidthTop(0f);
        pdfPCellTotales.addElement(tableTotales);

        if (isExportacion()) {
            int size = informacionAdicional();
            if (size > 0) {

                PdfPTable tableAdicionales = new PdfPTable(1);
                tableAdicionales.getDefaultCell().setBorder(0);
                tableAdicionales.setWidthPercentage(100f);

                getH2().setTexto(TXT_10_1);
                tableAdicionales.addCell(getH2().escribeCelda());
                tableAdicionales.addCell(getForm().escribeCelda());
                tableCompleta.addCell(tableAdicionales);
            } else
                tableCompleta.addCell("");
        } else
            tableCompleta.addCell("");

        tableCompleta.addCell(tableTotales);
        float[] columnWidths = new float[] { 70f, 30f };
        tableCompleta.setWidths(columnWidths);

        tableCompleta.getDefaultCell().setBorder(1);

        try {
            getDocumento().add(tableCompleta);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    /**
     * Metodo para ejecutar los totales.
     *
     */
    private void subTotales() {
        setTotales(new ArrayList<TotalDocumentoFactura>());
        inicializaTotales();

        cargarTotales(getFactura());

        if (isExportacion()) {

            int i = 0;
            int j = 0;
            while (i < getTotales().size() - 1) {
                TotalDocumentoFactura a = getTotales().get(i);

                if (TOTALES_PRESENTACION[i].indexOf("2") >= 0) {

                    getForm().getListaTitulos().add(TOTALES_EXPORTACION[i].trim());
                    getForm().getListaValores().add((a.getValor() == null) ? "" : a.getValor().toString());
                    getForm().getListaFormatos().add(Elemento.FORMATO_MONEDA);
                    getForm().getListaCamposAlineadosDerecha().add(j++ + "");
                }
                i++;
            }

            String tiuloPivot = getForm().getListaTitulos().get(0);
            String valorPivot = getForm().getListaValores().get(0);
            getForm().getListaTitulos().remove(0);
            getForm().getListaValores().remove(0);
            getForm().getListaTitulos().add(tiuloPivot);
            getForm().getListaValores().add(valorPivot);

            getForm().setListaDimensiones(22f, 11f);
            getForm().setListaPaneles(i + "");
        } else {
            int i = 0;
            int j = 0;
            while (i < getTotales().size() - 1) {
                TotalDocumentoFactura a = getTotales().get(i);
                String valorString = (a.getValor() == null) ? "0" : a.getValor().toString();
                double valor = Double.parseDouble(valorString);

                if (i < 3)
                    valor = 1f;

                if (valor > 0) {

                    if (TOTALES_PRESENTACION[i].indexOf("1") >= 0) {
                        getForm().getListaTitulos().add(a.getTitulo());
                        getForm().getListaValores().add((a.getValor() == null) ? "" : a.getValor().toString());
                        getForm().getListaFormatos().add(Elemento.FORMATO_MONEDA);
                        getForm().getListaCamposAlineadosDerecha().add(j++ + "");
                    }
                }
                i++;
            }
            getForm().setListaDimensiones(22f, 11f);
            getForm().setListaPaneles(i + "");
        }
    }

    /**
     * Metodo para ejecutar los totales.
     *
     */
    private void totales() {
        if (isExportacion())
            getForm().getListaTitulos().add(TOTALES_EXPORTACION[12]);
        else
            getForm().getListaTitulos().add(getTotales().get(getTotales().size() - 1).getTitulo());

        getForm().getListaValores()
                .add((getTotales().get(getTotales().size() - 1).getValor() == null) ? ""
                        : getTotales().get(getTotales().size() - 1)
                                .getValor()
                                .toString());
        getForm().getListaFormatos().add(Elemento.FORMATO_MONEDA);
        getForm().getListaCamposAlineadosDerecha().add("0");
        getForm().setListaDimensiones(22f, 11f);
        getForm().setListaPaneles("1");
    }

    /**
     * Metodo para agregar Formas de pago exportaciones.
     *
     */
    public synchronized void elemento_14() throws Exception {
        int size = 0;

        if (getFactura()
                .getInfoFactura()
                .getPagos() != null
                && getFactura()
                        .getInfoFactura()
                        .getPagos()
                        .getPago()
                        .size() > 0) {

            for (Pago a : getFactura()
                    .getInfoFactura()
                    .getPagos()
                    .getPago()) {

                getForm().getListaTitulos().add((size + 1) + ".- Forma pago");
                getForm().getListaValores().add(
                        String.format("%s a %s %s por un valor de %s",
                                bundle.getMessage("tabla24_" + a.getFormaPago()),
                                a.getPlazo(),
                                a.getUnidadTiempo(),
                                a.getTotal()));
                getForm().getListaFormatos().add(Elemento.FORMATO_STRING);
                size++;
            }

            if (size > 0) {
                int total = 74 + (12 * size);

                if (getPdfWriter().getVerticalPosition(true) < total)
                    getDocumento().newPage();

                getEspacio().escribir(2);
                //getLineaSolida().setWidthPercentage(100);
                getLineaSolida().escribir();
                getH2().setTexto(TXT_14_1);
                getH2().escribir();
                getEspacio().escribir(2);

                getForm().setListaDimensiones(15f, 85f);
                getForm().setListaPaneles(size + "");
                getForm().escribir();
            }
        }
    }

    /**
     * Metodo para agregar informaci\u00f3n de la exportacion.
     *
     */
    public synchronized void elemento_15() throws Exception {
        if (isExportacion()) {
            getEspacio().escribir(2);
            //getLineaSolida().setWidthPercentage(100);
            getLineaSolida().escribir();
            getH2().setTexto(TXT_15_1);
            getH2().escribir();
            getEspacio().escribir(2);

            informacionExportacion();

            getForm().escribir();
        }
    }

    /**
     * Metodo para agregar informaci\u00f3n de la exportacion SRI.
     *
     */
    public synchronized void elemento_17() throws Exception {
        if (isExportacion()) {
            
            getEspacio().escribir(2);

            PdfPTable table = new PdfPTable(1);
            table.getDefaultCell().setBorder(0);

            table.setWidthPercentage(100f);

            getH2().setTexto(TXT_15_1);
            PdfPCell pdfPCell1 = getH2().escribeCelda();
            pdfPCell1.setBorder(Rectangle.BOX);
            pdfPCell1.setBorderWidthBottom(0f);
            table.addCell(pdfPCell1);

            PdfPCell pdfPCell2 = new PdfPCell();
            pdfPCell2.setBorder(Rectangle.BOX);
            pdfPCell2.setBorderWidthTop(0f);
            pdfPCell2.setBorderWidthBottom(0f);

            PdfPTable table3 = new PdfPTable(3);
            table3.setWidthPercentage(100f);
            table3.getDefaultCell().setBorder(0);

            table3.addCell(" ");
            table3.addCell(" ");

            pdfPCell2.addElement(table3);
            table.addCell(pdfPCell2);

            informacionExportacion();
            PdfPCell pdfPCell3 = getForm().escribeCelda();
            pdfPCell3.setBorder(Rectangle.BOX);
            pdfPCell3.setBorderWidthTop(0f);
            table.addCell(pdfPCell3);

            try {
                getDocumento().add(table);
            } catch (DocumentException e) {
                throw new Exception(e);
            }
        }
    }

    /**
     * Metodo para agregar Formas de pago exportaciones SRI
     *
     */
    public synchronized void elemento_16() throws Exception {
        int size = 0;

        if (getFactura()
                .getInfoFactura()
                .getPagos() != null
                && getFactura().getInfoFactura()
                        .getPagos()
                        .getPago()
                        .size() > 0) {

            for (Pago a : getFactura().getInfoFactura()
                    .getPagos()
                    .getPago()) {

                getForm().getListaTitulos().add((size + 1) + ".- Forma pago");
                getForm().getListaValores().add(
                        String.format("%s a %s %s por un valor de %s",
                                bundle.getMessage("tabla24_" + a.getFormaPago()),
                                a.getPlazo(),
                                a.getUnidadTiempo(),
                                a.getTotal()));
                getForm().getListaFormatos().add(Elemento.FORMATO_STRING);
                size++;
            }

            if (size > 0) {

                int total = 74 + (12 * size);

                if (getPdfWriter().getVerticalPosition(true) < total)
                    getDocumento().newPage();

                getEspacio().escribir(2);

                PdfPTable table = new PdfPTable(1);
                table.getDefaultCell().setBorder(0);

                table.setWidthPercentage(100f);

                getH2().setTexto(TXT_14_1);
                PdfPCell pdfPCell1 = getH2().escribeCelda();
                pdfPCell1.setBorder(Rectangle.BOX);
                pdfPCell1.setBorderWidthBottom(0f);
                table.addCell(pdfPCell1);

                PdfPCell pdfPCell2 = new PdfPCell();
                pdfPCell2.setBorder(Rectangle.BOX);
                pdfPCell2.setBorderWidthTop(0f);
                pdfPCell2.setBorderWidthBottom(0f);

                PdfPTable table3 = new PdfPTable(3);
                table3.setWidthPercentage(100f);
                table3.getDefaultCell().setBorder(0);

                table3.addCell(" ");
                table3.addCell(" ");

                pdfPCell2.addElement(table3);
                table.addCell(pdfPCell2);

                getForm().setListaDimensiones(15f, 85f);
                getForm().setListaPaneles(size + "");
                PdfPCell pdfPCell3 = getForm().escribeCelda();
                pdfPCell3.setBorder(Rectangle.BOX);
                pdfPCell3.setBorderWidthTop(0f);
                table.addCell(pdfPCell3);

                try {
                    getDocumento().add(table);
                } catch (DocumentException e) {
                    throw new Exception(e);
                }

            }
        }
    }

    /**
     * Metodo para conocer si la factura es de exportacion.
     * @return
     */
    private boolean isExportacion() {
        if (getFactura().getInfoFactura()
                .getComercioExterior() != null
                && getFactura().getInfoFactura()
                        .getComercioExterior()
                        .trim()
                        .length() > 0)
            return true;

        return false;
    }

    /**
     * Metodo para agregar informaci\u00f3n de la exportacion.
     *
     */
    private void informacionExportacion() {
        getForm().setListaTitulos(TXT_15_2);
        getForm().setListaValores(
                getFactura().getInfoFactura().getIncoTermFactura(),
                getFactura().getInfoFactura().getLugarIncoTerm(),
                bundle.getMessage("tabla25_" + getFactura().getInfoFactura().getPaisOrigen()),
                getFactura().getInfoFactura().getPuertoEmbarque(),
                bundle.getMessage("tabla25_" + getFactura().getInfoFactura().getPaisDestino()),
                getFactura().getInfoFactura().getPuertoDestino(),
                bundle.getMessage("tabla25_" + getFactura().getInfoFactura().getPaisAdquisicion()));
        getForm().setListaFormatos(
                Elemento.FORMATO_STRING, Elemento.FORMATO_STRING, Elemento.FORMATO_STRING,
                Elemento.FORMATO_STRING, Elemento.FORMATO_STRING, Elemento.FORMATO_STRING,
                Elemento.FORMATO_STRING);
        getForm().setListaDimensiones(45f, 55f);
        getForm().setListaPaneles("3", "7");
    }

    /**
     * Metodo para agregar informaci\u00f3n adicional.
     *
     */
    public synchronized void elemento_9() throws Exception {
        if (isExportacion())
            return;
        int size = informacionAdicional();

        if (size > 0) {
            getEspacio().escribir(2);
            getLineaSolida().escribir();
            getH2().setTexto(TXT_10_1);
            getH2().escribir();
            getEspacio().escribir(2);
            getForm().escribir();
        }
    }

    /**
     * Metodo para agregar informaci\u00f3n adicional.
     *
     */
    private int informacionAdicional() {
        int size = 0;

        if (getFactura().getInfoAdicional() != null && getFactura()
                .getInfoAdicional()
                .getCampoAdicional()
                .size() > 0) {

            for (Factura.InfoAdicional.CampoAdicional a : getFactura()
                    .getInfoAdicional()
                    .getCampoAdicional()) {

                if (!a.getNombre().startsWith("js")) {
                    getForm().getListaTitulos().add(a.getNombre());
                    getForm().getListaValores().add((a.getValue() == null) ? "" : a.getValue().toString());
                    getForm().getListaFormatos().add(Elemento.FORMATO_STRING);
                    size++;
                }
            }

            if (size > 0) {
                int total = 74 + (12 * size);

                if (getPdfWriter().getVerticalPosition(true) < total)
                    getDocumento().newPage();
                getForm().setListaDimensiones(25f, 75f);
                getForm().setListaPaneles(size + "");
            }
        }
        return size;
    }

    /**
     * Metodo para inicializar los totales.
     *
     */
    public void inicializaTotales() {
        TotalDocumentoFactura totalFactura = new TotalDocumentoFactura();
        totalFactura.setTitulo(TOTALES[0]); // subtotal 12%
        getTotales().add(0, totalFactura);

        totalFactura = new TotalDocumentoFactura();
        totalFactura.setTitulo(TOTALES[1]);
        getTotales().add(1, totalFactura);

        totalFactura = new TotalDocumentoFactura();
        totalFactura.setTitulo(TOTALES[2]);
        getTotales().add(2, totalFactura);

        totalFactura = new TotalDocumentoFactura();
        totalFactura.setTitulo(TOTALES[3]);
        getTotales().add(3, totalFactura);

        totalFactura = new TotalDocumentoFactura();
        totalFactura.setTitulo(TOTALES[4]);
        getTotales().add(4, totalFactura);

        totalFactura = new TotalDocumentoFactura();
        totalFactura.setTitulo(TOTALES[5]);
        getTotales().add(5, totalFactura);

        totalFactura = new TotalDocumentoFactura();
        totalFactura.setTitulo(TOTALES[6]); // IVA 12%
        getTotales().add(6, totalFactura);

        totalFactura = new TotalDocumentoFactura();
        totalFactura.setTitulo(TOTALES[7]);
        getTotales().add(7, totalFactura);

        totalFactura = new TotalDocumentoFactura();
        totalFactura.setTitulo(TOTALES[8]);
        getTotales().add(8, totalFactura);

        totalFactura = new TotalDocumentoFactura();
        totalFactura.setTitulo(TOTALES[9]);
        getTotales().add(9, totalFactura);

        totalFactura = new TotalDocumentoFactura();
        totalFactura.setTitulo(TOTALES[10]);
        getTotales().add(10, totalFactura);

        totalFactura = new TotalDocumentoFactura();
        totalFactura.setTitulo(TOTALES[11]);
        getTotales().add(11, totalFactura);

        totalFactura = new TotalDocumentoFactura();
        totalFactura.setTitulo(TOTALES[12]);
        getTotales().add(12, totalFactura);
    }

    /**
     * Metodo para cargar los totales que el sistema tiene.
     *
     * @param bus
     */
    public void cargarTotales(Factura bus) {

        if (bus.getInfoFactura().getTotalConImpuestos() != null && bus.getInfoFactura()
                .getTotalConImpuestos()
                .getTotalImpuesto()
                .size() > 0) {

            for (Factura.InfoFactura.TotalConImpuestos.TotalImpuesto a : bus.getInfoFactura()
                    .getTotalConImpuestos()
                    .getTotalImpuesto()) {
                if (a.getCodigo().compareTo("2") == 0) {
                    if (a.getCodigoPorcentaje().compareTo("0") == 0) {
                        getTotales().get(1).setValor(a.getBaseImponible());
                    }

                    if (a.getCodigoPorcentaje().compareTo("2") == 0) {
                        getTotales().get(0).setTitulo("SUBTOTAL 12%");
                        getTotales().get(6).setTitulo("IVA 12%");
                        getTotales().get(0).setValor(a.getBaseImponible());
                        getTotales().get(6).setValor(a.getValor());
                    }

                    if (a.getCodigoPorcentaje().compareTo("3") == 0) {
                        getTotales().get(0).setTitulo("SUBTOTAL 14%");
                        getTotales().get(6).setTitulo("IVA 14%");
                        getTotales().get(0).setValor(a.getBaseImponible());
                        getTotales().get(6).setValor(a.getValor());
                    }

                    if (a.getCodigoPorcentaje().compareTo("4") == 0) {
                        getTotales().get(0).setTitulo("SUBTOTAL 15%");
                        getTotales().get(6).setTitulo("IVA 15%");
                        getTotales().get(0).setValor(a.getBaseImponible());
                        getTotales().get(6).setValor(a.getValor());
                    }

                    if (a.getCodigoPorcentaje().compareTo("5") == 0) {
                        getTotales().get(0).setTitulo("SUBTOTAL 5%");
                        getTotales().get(6).setTitulo("IVA 5%");
                        getTotales().get(0).setValor(a.getBaseImponible());
                        getTotales().get(6).setValor(a.getValor());
                    }

                    if (a.getCodigoPorcentaje().compareTo("6") == 0) {
                        getTotales().get(2).setValor(a.getBaseImponible());
                    }
                }

                if (a.getCodigo().compareTo("3") == 0) {
                    getTotales().get(5).setValor(a.getValor());
                }
            }
        }

        getTotales().get(3).setValor(bus.getInfoFactura().getTotalSinImpuestos());
        getTotales().get(4).setValor(bus.getInfoFactura().getTotalDescuento());
        getTotales().get(7).setValor(bus.getInfoFactura().getPropina());
        getTotales().get(8).setValor(bus.getInfoFactura().getFleteInternacional());

        getTotales().get(9).setValor(bus.getInfoFactura().getSeguroInternacional());
        getTotales().get(10).setValor(bus.getInfoFactura().getGastosAduaneros());
        getTotales().get(11).setValor(bus.getInfoFactura().getGastosTransporteOtros());
        getTotales().get(12).setValor(bus.getInfoFactura().getImporteTotal());
    }
}
