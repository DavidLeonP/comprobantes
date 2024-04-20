package com.aplicaciones13.documentos.impresion.ensamble.ride;

import com.aplicaciones13.documentos.estruturas.factura.v2_1_0.Pagos.Pago;
import com.aplicaciones13.documentos.impresion.elementos.texto.Elemento;
import com.aplicaciones13.documentos.impresion.elementos.texto.P;
import com.aplicaciones13.documentos.impresion.ensamble.ImpresionElementosBase;
import com.aplicaciones13.documentos.estruturas.factura.v2_1_0.Factura;

import com.aplicaciones13.documentos.utilidades.BundleMessages;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import com.itextpdf.barcodes.Barcode128;
import com.itextpdf.kernel.pdf.xobject.PdfFormXObject;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

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

    Border bordeSolido = new SolidBorder(1f);

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
    private static String TXT_11_10[] = { "Ambiente", "Emisi\u00f3n" };
    private static String TXT_11_12 = "Clave de Acceso";

    private static String TXT_14_1 = "Formas de Pago";

    private static String TXT_15_1 = "Informaci\u00f3n Exportaci\u00f3n";
    private static String TXT_15_2[] = {
            "T\u00e9rminos de negociaci\u00f3n", "Lugar de negociaci\u00f3n", "Pa\u00eds Origen", "Puerto Embarque",
            "Pa\u00eds Destino", "Puerto Destino", "Pa\u00eds Adquisici\u00f3n"
    };

    private Factura factura;
    List<TotalDocumentoFactura> totales;

    public ImpresionElementosFactura() {
        factura = new Factura();
        totales = new ArrayList<TotalDocumentoFactura>();
    }

    /*
     * public synchronized void elemento1() {
     * Pie pie = new Pie(TXT_3_1);
     * pie.setNumeroDocumento(getFactura().getInfoTributaria()
     * .getEstab() + "-"
     * + getFactura().getInfoTributaria()
     * .getPtoEmi()
     * + "-" +
     * getFactura()
     * .getInfoTributaria()
     * .getSecuencial());
     * getPdfWriter().setPageEvent(pie);
     * }
     */

    /**
     * Metodo para generar el panel superior en un formato semejante al SRI.
     *
     */
    public synchronized void elemento2() {
        // Lado Izquierdo
        Table tableIzquierda = new Table(1);

        int anchoImagen = (int) (getCurrentPosition().getAncho() * 0.2);
        int margenes = (int) (getCurrentPosition().getAncho() / 2 - anchoImagen) / 2;

        getImagen().setPathImagen(getParametrosBusqueda().get("pathImagen"));
        getImagen().setMaximoAncho(anchoImagen);
        getImagen().procesar();

        // Celda para imagen en el centro en el eje horizontal
        Cell cellimg = new Cell();
        cellimg.setPaddingLeft(margenes);
        cellimg.add(getImagen().getImagen());

        tableIzquierda.addCell(cellimg);

        // Nombre de la empresa
        getH1().setParagraph(getFactura()
                .getInfoTributaria()
                .getRazonSocial());

        tableIzquierda.addCell(getH1().getParagraph());

        // Informacion de la empresa
        getForm().setListaTitulos(TXT_11_3);
        getForm().setListaValores(getFactura()
                .getInfoTributaria()
                .getDirMatriz(),
                getFactura()
                        .getInfoFactura()
                        .getDirEstablecimiento());
        getForm().setListaFormatos(Elemento.FORMATO_STRING, Elemento.FORMATO_STRING);
        getForm().setListaDimensiones(30.0f, 70.0f);
        getForm().procesar();
        tableIzquierda.addCell(getForm().getTabla());

        // Informacion de contabilidad
        getForm().setListaTitulos(TXT_11_4);
        getForm()
                .setListaValores(getFactura()
                        .getInfoFactura()
                        .getContribuyenteEspecial(),
                        getFactura()
                                .getInfoFactura()
                                .getObligadoContabilidad());
        getForm().setListaFormatos(Elemento.FORMATO_STRING, Elemento.FORMATO_STRING);
        getForm().setListaDimensiones(50f, 50f);
        getForm().procesar();
        tableIzquierda.addCell(getForm().getTabla());

        // Lado Derecho
        Table tableDerecha = new Table(1);
        tableDerecha.setBorder(Border.NO_BORDER);
        // Ruc
        getH2().setParagraph(TXT_11_5 + getFactura()
                .getInfoTributaria()
                .getRuc());
        tableDerecha.addCell(getH2().getParagraph());

        // Nombre del documento
        getH1().setParagraph(TXT_11_6);
        tableDerecha.addCell(getH1().getParagraph());

        // Numero del documento
        getH1().setParagraph(String.format(TXT_11_7, getFactura()
                .getInfoTributaria()
                .getEstab(),
                getFactura()
                        .getInfoTributaria()
                        .getPtoEmi(),
                getFactura().getInfoTributaria()
                        .getSecuencial()));
        tableDerecha.addCell(getH1().getParagraph());

        // Numero de autorizacion
        getH2().setParagraph(TXT_11_8);
        tableDerecha.addCell(getH2().getParagraph());

        getNota().setParagraph(getParametrosBusqueda().get("numeroAutorizacion"));
        getNota().getParagraph().setFontSize(P.NOTA);
        tableDerecha.addCell(getNota().getParagraph());

        // Ambiente
        getForm().setListaTitulos(TXT_11_10);
        getForm().setListaValores(getParametrosBusqueda().get("ambienteAutorizacion"),
                getParametrosBusqueda().get("emisionAutorizacion"));
        getForm().setListaFormatos(Elemento.FORMATO_STRING, Elemento.FORMATO_STRING);
        getForm().setListaDimensiones(25f, 75f);
        getForm().procesar();
        tableDerecha.addCell(getForm().getTabla());

        // Clave de acceso
        getH2().setParagraph(TXT_11_12);
        tableDerecha.addCell(getH2().getParagraph());

        Barcode128 barcode = new Barcode128(getDocumento().getPdfDocument());
        barcode.setCodeType(Barcode128.CODE128);
        barcode.setCode(getParametrosBusqueda().get("claveAccesoAutorizacion"));

        PdfFormXObject barcodeObject = barcode.createFormXObject(null, null, getDocumento().getPdfDocument());
        Cell cell = new Cell().add(new Image(barcodeObject));
        tableDerecha.addCell(cell);

        getPanel().setListaDimensiones(50f, 50f);
        getPanel().getMapaAlineamiento().put(1, TextAlignment.LEFT);
        getPanel().getMapaAlineamiento().put(2, TextAlignment.LEFT);
        getPanel().setListaCeldas(tableIzquierda, tableDerecha);
        getPanel().getTabla().setBorder(Border.NO_BORDER);
        getPanel().procesarEscribir();
    }

    /**
     * Metodo para escribir la informacion del cliente.
     *
     */
    public synchronized void elemento11() {
        getEspacio().escribir(2);

        informacionCliente();

        Table table = new Table(1);
        // table.setWidthPercentage(100f);
        table.setWidth(UnitValue.createPercentValue(100f));
        Cell cell = new Cell();
        cell.add(getForm().getTabla());
        cell.setBorder(bordeSolido);
        // cell.setBorder(Rectangle.BOX);

        table.addCell(cell);

        try {
            getDocumento().add(table);
        } catch (Exception e) {
            new Exception(e);
        }
    }

    /**
     * Metodo para escribir la informacion del cliente.
     *
     */
    public synchronized void elemento12() {
        getEspacio().escribir(2);

        if (getFactura().getDetalles() != null && getFactura()
                .getDetalles()
                .getDetalle()
                .size() > 0) {

            detalleFacturaCompleta();

            Table table = new Table(1);
            table.setWidth(UnitValue.createPercentValue(100f));
            // table.setWidthPercentage(100f);
            Cell cell = new Cell();
            cell.add(getTabla().getTabla());
            // getTabla().escribeCelda();
            cell.setBorder(Border.NO_BORDER);

            table.addCell(cell);

            try {
                getDocumento().add(table);
            } catch (Exception e) {
                new Exception(e);
            }

            if (getCurrentPosition().getY() < 140) {
                getDocumento().add(new AreaBreak());
            }

        }
    }

    /**
     * Metodo para escribir el codigo de barras de la clave de acceso.
     *
     */
    public synchronized void elemento4() {

        getForm().setListaTitulos(TXT_4_1);

        getForm().setListaValores("");
        getForm().setListaFormatos(Elemento.FORMATO_STRING);
        getForm().setListaDimensiones(25f, 75f);

        // TODO revisar paneles
        // getForm().setListaPaneles("1");
        getForm().escribir();

        BufferedImage imagenBarras = new BufferedImage(640, 100, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = imagenBarras.createGraphics();
        g.setPaint(Color.WHITE);
        g.fillRect(0, 0, 640, 100);

        org.jbars.Barcode128 code128 = new org.jbars.Barcode128();
        code128.setCodeType(Barcode.CODE128);
        code128.setCode(getParametrosBusqueda().get("claveAccesoAutorizacion"));
        code128.placeBarcode(imagenBarras, Color.black, Color.blue);

        // TODO no se imprime el codigo de barras
        /*
         * getImagen().setImagen(imagenBarras);
         * getImagen().setEscala(35f);
         * getImagen().setX(165);
         * getImagen().setY(680);
         * getImagen().escribir();
         */
    }

    /**
     * Metodo para escribir la informacion de la empresa
     *
     * @throws Exception
     */
    public synchronized void elemento5() {
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

        // TODO revisar paneles
        // getForm().setListaPaneles("5");
        getForm().escribir();
    }

    /**
     * Metodo para escribir la informacion del cliente.
     *
     */
    public synchronized void elemento6() {
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
        // TODO revisar paneles
        // getForm().setListaPaneles("7");
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
    public synchronized void elemento7() {
        getEspacio().escribir(2);

        if (getFactura().getDetalles() != null && getFactura()
                .getDetalles()
                .getDetalle()
                .size() > 0) {

            getLineaSolida().escribir();

            detalleFacturaCompleta();

            getTabla().escribir();

            getLineaSolida().escribir();
            if (getCurrentPosition().getY() < 140) {
                getDocumento().add(new AreaBreak());
            }
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

        // TODO se tiene que cambiar el metodo setVectorDatos
        // getTabla().setVectorDatos(vector);
        getTabla().getTabla().setWidth(UnitValue.createPercentValue(100f));
        // getTabla().setWidthPercent(100f);
    }

    /**
     * Metodo para agregar los totales de la factura
     *
     */
    public synchronized void elemento8() {
        getEspacio().escribir(2);

        subTotales();
        getForm().escribir();

        // getLineaSolida().setWidthPercentage(34);
        getLineaSolida().escribir();

        totales();
        getForm().escribir();
    }

    /**
     * Metodo para agregar los totales de la factura
     *
     */
    public synchronized void elemento13() {
        getEspacio().escribir(2);

        Table tableTotales = new Table(1);
        tableTotales.setBorder(Border.NO_BORDER);
        tableTotales.setWidth(UnitValue.createPercentValue(100f));
        // tableTotales.getDefaultCell().setBorder(0);
        // tableTotales.setWidthPercentage(100f);

        subTotales();

        Cell cell1SubTotales = new Cell();
        cell1SubTotales.add(getForm().getTabla());
        cell1SubTotales.setBorderBottom(Border.NO_BORDER);
        // cell1SubTotales.setBorderWidthBottom(0f);
        tableTotales.addCell(cell1SubTotales);

        Cell cellLinea = new Cell();
        Table tableLinea = new Table(1);
        tableLinea.setWidth(UnitValue.createPercentValue(100f));
        tableLinea.setBorder(Border.NO_BORDER);

        // tableLinea.setWidthPercentage(100f);
        // tableLinea.getDefaultCell().setBorder(0);
        // tableTotales.addCell(getLineaSolida().escribeCelda());

        // TODO Revisar si se necesita linea solida!!
        /*
         * tableTotales.add(getLineaSolida());
         * 
         * cellLinea.addElement(tableLinea);
         * tableTotales.addCell(cellLinea);
         */

        totales();
        // Cell cellSumatoria = getForm().escribeCelda();
        Cell cellSumatoria = new Cell();
        cellSumatoria.add(getForm().getTabla());

        cellSumatoria.setBorder(Border.NO_BORDER);
        // cellSumatoria.setBorderWidthTop(0f);
        tableTotales.addCell(cellSumatoria);

        Table tableCompleta = new Table(2);
        tableCompleta.setWidth(UnitValue.createPercentValue(100f));
        // tableCompleta.setWidthPercentage(100f);

        Cell cellTotales = new Cell();
        cellTotales.setBorder(Border.NO_BORDER);
        cellTotales.add(tableTotales);
        // cellTotales.setBorderWidthTop(0f);
        // cellTotales.addElement(tableTotales);

        if (isExportacion()) {
            int size = informacionAdicional();
            if (size > 0) {

                Table tableAdicionales = new Table(1);
                tableAdicionales.setBorder(bordeSolido);
                tableAdicionales.setWidth(UnitValue.createPercentValue(100f));
                // tableAdicionales.getDefaultCell().setBorder(0);
                // tableAdicionales.setWidthPercentage(100f);

                getH2().setTexto(TXT_10_1);
                tableAdicionales.addCell(getH2().getParagraph());
                tableAdicionales.addCell(getForm().getTabla());
                tableCompleta.addCell(tableAdicionales);
            } else
                tableCompleta.addCell("");
        } else
            tableCompleta.addCell("");

        tableCompleta.addCell(tableTotales);
        // TODO colomnas
        /*
         * float[] columnWidths = new float[] { 70f, 30f };
         * tableCompleta.setWidths(columnWidths);
         */

        tableCompleta.setBorder(bordeSolido);

        try {
            getDocumento().add(tableCompleta);
        } catch (Exception e) {
            new Exception(e);
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
                    getForm().getMapaAlineamiento().put(j++, TextAlignment.RIGHT);
                    // getForm().getListaCamposAlineadosDerecha().add(j++ + "");

                }
                i++;
            }

            String tiuloPivot = getForm().getListaTitulos().get(0);
            String valorPivot = String.valueOf(getForm().getListaValores().get(0));
            // String valorPivot = getForm().getListaValores().get(0);

            getForm().getListaTitulos().remove(0);
            getForm().getListaValores().remove(0);
            getForm().getListaTitulos().add(tiuloPivot);
            getForm().getListaValores().add(valorPivot);

            getForm().setListaDimensiones(22f, 11f);
            // TODO revisar paneles
            // getForm().setListaPaneles(i + "");
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
                        // getForm().getListaCamposAlineadosDerecha().add(j++ + "");
                        getForm().getMapaAlineamiento().put(j++, TextAlignment.RIGHT);
                    }
                }
                i++;
            }
            getForm().setListaDimensiones(22f, 11f);
            // TODO revisar paneles
            // getForm().setListaPaneles(i + "");
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
        // getForm().getListaCamposAlineadosDerecha().add("0");
        getForm().getMapaAlineamiento().put(0, TextAlignment.RIGHT);
        getForm().setListaDimensiones(22f, 11f);
        // TODO revisar paneles
        // getForm().setListaPaneles("1");
    }

    /**
     * Metodo para agregar Formas de pago exportaciones.
     *
     */
    public synchronized void elemento14() {
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

                if (getCurrentPosition().getY() < total) {
                    getDocumento().add(new AreaBreak());
                }

                getEspacio().escribir(2);
                // getLineaSolida().setWidthPercentage(100);
                getLineaSolida().escribir();
                getH2().setTexto(TXT_14_1);
                getH2().escribir();
                getEspacio().escribir(2);

                getForm().setListaDimensiones(15f, 85f);
                // TODO revisar paneles
                // getForm().setListaPaneles(size + "");
                getForm().escribir();
            }
        }
    }

    /**
     * Metodo para agregar informaci\u00f3n de la exportacion.
     *
     */
    public synchronized void elemento15() {
        if (isExportacion()) {
            getEspacio().escribir(2);
            // getLineaSolida().setWidthPercentage(100);
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
    public synchronized void elemento17() {
        if (isExportacion()) {

            getEspacio().escribir(2);

            Table table = new Table(1);
            table.setBorder(Border.NO_BORDER);
            table.setWidth(UnitValue.createPercentValue(100f));

            getH2().setTexto(TXT_15_1);
            Cell cell1 = new Cell();
            cell1.add(getH2().getParagraph());
            cell1.setBorder(bordeSolido);
            // cell1.setBorderWidthBottom(0f);
            cell1.setMarginBottom(0);
            table.addCell(cell1);

            Cell cell2 = new Cell();
            // cell2.setBorder(Rectangle.BOX);
            cell2.setBorder(bordeSolido);

            // cell2.setBorderWidthTop(0f);
            // cell2.setBorderWidthBottom(0f);

            Table table3 = new Table(3);
            table3.setWidth(UnitValue.createPercentValue(100));
            // table3.setWidthPercentage(100f);
            // table3.getDefaultCell().setBorder(0);
            table3.setBorder(Border.NO_BORDER);

            table3.addCell(" ");
            table3.addCell(" ");

            cell2.add(table3);
            table.addCell(cell2);

            informacionExportacion();
            Cell cell3 = new Cell();
            cell3.add(getForm().getTabla());
            cell3.setBorder(bordeSolido);
            // cell3.setBorderWidthTop(0f);
            table.addCell(cell3);

            try {
                getDocumento().add(table);
            } catch (Exception e) {
                new Exception(e);
            }
        }
    }

    /**
     * Metodo para agregar Formas de pago exportaciones SRI
     *
     */
    public synchronized void elemento16() {
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
                if (getCurrentPosition().getY() < total) {
                    getDocumento().add(new AreaBreak());
                }

                getEspacio().escribir(2);

                Table table = new Table(1);

                // TODO revisar
                // table.getDefaultCell().setBorder(0);
                // table.setWidthPercentage(100f);
                table.setBorder(Border.NO_BORDER);

                getH2().setTexto(TXT_14_1);
                Cell cell1 = new Cell();
                cell1.add(getH2().getParagraph());

                cell1.setBorder(bordeSolido);
                table.addCell(cell1);

                Cell cell2 = new Cell();
                cell2.setBorderLeft(bordeSolido);
                cell2.setBorderRight(bordeSolido);

                Table table3 = new Table(3);

                table.setWidth(UnitValue.createPercentValue(100));
                // TODO Revisar
                // table3.getDefaultCell().setBorder(0);
                table3.setBorder(Border.NO_BORDER);

                table3.addCell(" ");
                table3.addCell(" ");

                cell2.add(table3);
                table.addCell(cell2);

                getForm().setListaDimensiones(15f, 85f);
                // TODO revisar
                // getForm().setListaPaneles(size + "");
                Cell cell3 = new Cell();
                cell3.add(getForm().getTabla());
                // getForm().escribeCelda();
                cell3.setBorder(bordeSolido);
                // cell3.setBorderWidthTop(0f);
                table.addCell(cell3);

                try {
                    getDocumento().add(table);
                } catch (Exception e) {
                    new Exception(e);
                }
            }
        }
    }

    /**
     * Metodo para conocer si la factura es de exportacion.
     * 
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
        // TODO revisar paneles
        // getForm().setListaPaneles("3", "7");

    }

    /**
     * Metodo para agregar informaci\u00f3n adicional.
     *
     */
    public synchronized void elemento9() {
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
                if (getCurrentPosition().getY() < total) {
                    getDocumento().add(new AreaBreak());
                }
                getForm().setListaDimensiones(25f, 75f);
                // TODO revisar paneles
                // getForm().setListaPaneles(size + "");
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
        totalFactura.setTitulo(TOTALES[0]);
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
        totalFactura.setTitulo(TOTALES[6]);
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
