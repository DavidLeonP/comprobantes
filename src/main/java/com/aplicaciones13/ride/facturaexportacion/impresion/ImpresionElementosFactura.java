package com.aplicaciones13.ride.facturaexportacion.impresion;

import com.aplicaciones13.sri.contenedores.TablasSRI;
import com.aplicaciones13.sri.contenedores.TotalDocumento;
import com.aplicaciones13.impresion.Elemento;
import com.aplicaciones13.impresion.ImpresionBaseElementos;
import com.aplicaciones13.ride.facturaexportacion.Factura;
import com.aplicaciones13.ride.facturaexportacion.Pagos.Pago;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Objeto para crear un documento de factura.
 *
 * @author omarv omargo33@JeremiasSoft.com
 *
 */
public class ImpresionElementosFactura extends ImpresionBaseElementos {
    private static final String TXT_3_1 = "Factura";    

    private static final String[] TXT_6_1 = {
            "Raz\u00f3n Social", "RUC / CI.", "Fecha Emisi\u00f3n", "Gu\u00eda Remisi\u00f3n" };
    private static final String[] TXT_7_1 = { "Cod.", "Descripci\u00f3n", "Cant.", "Precio Uni.", "Desc.", "Total" };

    private static final String[] TOTALES = {
            "SUBTOTAL 12%", "SUBTOTAL 0%", "SUBTOTAL No Sujeto de IVA", "SUBTOTAL", "DESCUENTO", "ICE", "IVA 12%",
            "PROPINA", "FLETE INTERNACIONAL", "SEGURO INTERNACIONAL", "GASTOS ADUANEROS", "OTROS GASTOS DE TRANSPORTE",
            "VALOR TOTAL"
    };

    private static final String[] TOTALES_EXPORTACION = {
            "", "", "IVA 0%", "TOTAL", "", "", "", "", "FLETE", "SEGURO", "GASTOS ADUANEROS",
            "OTROS GASTOS DE TRANSPORTE",
            "TOTAL"
    };

    private static final String[] TOTALES_PRESENTACION = {
            "1", "1", "1 2", "1 2", "1", "1", "1", "1", "2", "2", "2", "2", "1 2" };

    private static final String TXT_10_1 = "Informaci\u00f3n Adicional";

    private static final String TXT_14_1 = "Formas de Pago";

    private static final String TXT_15_1 = "Informaci\u00f3n Exportaci\u00f3n";
    private static final String[] TXT_15_2 = {
            "T\u00e9rminos de negociaci\u00f3n", "Lugar de negociaci\u00f3n", "Pa\u00eds Origen", "Puerto Embarque",
            "Pa\u00eds Destino", "Puerto Destino", "Pa\u00eds Adquisici\u00f3n"
    };

    private DatosFactura datosFactura;
    List<TotalDocumento> totalesCalculo;

    /**
     * Metodo para generar el panel superior en un formato semejante al SRI.
     *
     */
    @Override
    protected synchronized void elemento10() {
        this.getElementosComunes().encabezado(
                getDatosFactura().getPathLogo(),
                getDatosFactura().getFacturaXML().getInfoTributaria().getRazonSocial(),
                getDatosFactura().getFacturaXML().getInfoTributaria().getDirMatriz(),
                getDatosFactura().getFacturaXML().getInfoFactura().getDirEstablecimiento(),
                getDatosFactura().getFacturaXML().getInfoFactura().getContribuyenteEspecial(),
                getDatosFactura().getFacturaXML().getInfoFactura().getObligadoContabilidad().value(),
                getDatosFactura().getFacturaXML().getInfoTributaria().getRuc(),
                TXT_3_1,
                getDatosFactura().getFacturaXML().getInfoTributaria().getEstab()
                        + "-" +
                        getDatosFactura().getFacturaXML().getInfoTributaria().getPtoEmi()
                        + "-" +
                        getDatosFactura().getFacturaXML().getInfoTributaria().getSecuencial(),
                getDatosFactura().getClaveAccesoAutorizacion(),
                getDatosFactura().getNumeroAutorizacion(),
                getDatosFactura().getFechaAutorizacion(),
                getDatosFactura().getAmbienteAutorizacion(),
                getDatosFactura().getEmisionAutorizacion(),
                getDatosFactura().isOffline());
    }

    /**
     * Metodo para escribir la informacion del cliente.
     *
     */
    @Override
    protected synchronized void elemento11() {
        getElementosComunes().espacios(2);

        informacionCliente();

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
     * Metodo para escribir la informacion del cliente.
     *
     */
    @Override
    protected synchronized void elemento12() {
        getElementosComunes().espacios(2);

        if (getDatosFactura().getFacturaXML().getDetalles() != null && !getDatosFactura().getFacturaXML()
                .getDetalles()
                .getDetalle().isEmpty()) {

            detalleFacturaCompleta();

            PdfPTable table = new PdfPTable(1);
            table.setWidthPercentage(100f);
            PdfPCell pdfPCell = getTabla().escribeCelda();
            pdfPCell.setBorder(Rectangle.BOX);

            table.addCell(pdfPCell);

            try {
                getDocumento().add(table);
            } catch (DocumentException e) {
                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, e.toString());
            }

            if (getPdfWriter().getVerticalPosition(true) < 140)
                getDocumento().newPage();
        }
    }

    /**
     * Metodo para crear la informacion del cliente
     *
     */
    private void informacionCliente() {
        getForm().setListaTitulos(TXT_6_1);
        getForm()
                .setListaValores(getDatosFactura().getFacturaXML()
                        .getInfoFactura()
                        .getRazonSocialComprador(),
                        getDatosFactura().getFacturaXML()
                                .getInfoFactura()
                                .getIdentificacionComprador(),
                        getDatosFactura().getFacturaXML()
                                .getInfoFactura()
                                .getFechaEmision(),
                        getDatosFactura().getFacturaXML()
                                .getInfoFactura()
                                .getGuiaRemision());
        getForm()
                .setListaFormatos(Elemento.FORMATO_STRING, Elemento.FORMATO_STRING, Elemento.FORMATO_STRING,
                        Elemento.FORMATO_STRING);
        getForm().setListaDimensiones("25", "75");
        getForm().setListaPaneles("7");
    }

    /**
     * Metodo para detalle Factura completa.
     *
     */
    public void detalleFacturaCompleta() {
        List<Object> listaDatos = new ArrayList<>();

        for (Factura.Detalles.Detalle a : getDatosFactura().getFacturaXML()
                .getDetalles()
                .getDetalle()) {
            List<String> listaValores = new ArrayList<>();
            listaValores.add(0, a.getCodigoPrincipal());
            listaValores.add(1, a.getDescripcion());
            listaValores.add(2, a.getCantidad().toString());
            listaValores.add(3, a.getPrecioUnitario().toString());
            listaValores.add(4, a.getDescuento().toString());
            listaValores.add(5, a.getPrecioTotalSinImpuesto().toString());
            listaDatos.add(listaValores);

            if (a.getCodigoAuxiliar() != null && a.getCodigoAuxiliar()
                    .trim()
                    .length() > 0) {
                listaValores = new ArrayList<>();
                listaValores.add(0, "");
                listaValores.add(1, "Cod.: " + a.getCodigoAuxiliar());
                listaValores.add(2, "");
                listaValores.add(3, "");
                listaValores.add(4, "");
                listaValores.add(5, "");
                listaDatos.add(listaValores);
            }

            if (a.getDetallesAdicionales() != null && !a.getDetallesAdicionales().getDetAdicional().isEmpty()) {
                for (Factura.Detalles.Detalle.DetallesAdicionales.DetAdicional b : a.getDetallesAdicionales()
                        .getDetAdicional()) {
                    listaValores = new ArrayList<>();
                    listaValores.add(0, "");
                    listaValores.add(1, b.getNombre() + ": " + b.getValor());
                    listaValores.add(2, "");
                    listaValores.add(3, "");
                    listaValores.add(4, "");
                    listaValores.add(5, "");
                    listaDatos.add(listaValores);
                }
            }

            getTabla().setListaTitulos(TXT_7_1);
            getTabla()
                    .setListaFormatos(Elemento.FORMATO_STRING, Elemento.FORMATO_STRING, Elemento.FORMATO_STRING,
                            Elemento.FORMATO_STRING, Elemento.FORMATO_STRING, Elemento.FORMATO_STRING);
            getTabla().setListaDimensiones("10", "10", "35", "10", "10", "10", "15");
            getTabla()
                    .setListaAlineacion(Element.ALIGN_LEFT, Element.ALIGN_LEFT, Element.ALIGN_RIGHT,
                            Element.ALIGN_RIGHT,
                            Element.ALIGN_RIGHT, Element.ALIGN_RIGHT);
        }
        getTabla().setListaTitulos(TXT_7_1);
        getTabla()
                .setListaFormatos(Elemento.FORMATO_STRING, Elemento.FORMATO_STRING, Elemento.FORMATO_STRING,
                        Elemento.FORMATO_STRING, Elemento.FORMATO_STRING, Elemento.FORMATO_STRING);
        getTabla().setListaDimensiones("15", "40", "10", "10", "10", "15");
        getTabla()
                .setListaAlineacion(Element.ALIGN_LEFT, Element.ALIGN_LEFT, Element.ALIGN_RIGHT, Element.ALIGN_RIGHT,
                        Element.ALIGN_RIGHT, Element.ALIGN_RIGHT);
        getTabla().setListaDatos(listaDatos);
        getTabla().setAncho(100);
    }

    /**
     * Metodo para agregar los totales de la factura
     *
     */
    @Override
    protected synchronized void elemento13() {
        getElementosComunes().espacios(2);

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
        tableTotales.addCell(getLinea().escribeCelda());

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
        try {
            tableCompleta.setWidths(columnWidths);
        } catch (Exception e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, e.toString());
        }

        tableCompleta.getDefaultCell().setBorder(1);

        try {
            getDocumento().add(tableCompleta);
        } catch (DocumentException e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, e.toString());
        }
    }

    /**
     * Metodo para ejecutar los totales.
     *
     */
    private void subTotales() {
        this.totalesCalculo = new ArrayList<>();
        inicializaTotales();

        cargarTotales(getDatosFactura().getFacturaXML());

        if (isExportacion()) {
            int i = 0;
            int j = 0;
            while (i < getTotales().size() - 1) {
                TotalDocumento a = getTotales().get(i);

                if (TOTALES_PRESENTACION[i].indexOf("2") >= 0) {
                    getForm().getListaTitulos().add(TOTALES_EXPORTACION[i].trim());
                    getForm().getListaValores().add((a.getValor() == null) ? "" : a.getValor().toString());
                    getForm().getListaFormatos().add(Elemento.FORMATO_MONEDA);
                    getForm().getListaCamposAlineadosDerecha().add(String.valueOf(j++));
                }
                i++;
            }

            String tiuloPivot = getForm().getListaTitulos().get(0);
            String valorPivot = getForm().getListaValores().get(0);
            getForm().getListaTitulos().remove(0);
            getForm().getListaValores().remove(0);
            getForm().getListaTitulos().add(tiuloPivot);
            getForm().getListaValores().add(valorPivot);

            getForm().setListaDimensiones("22", "11");
            getForm().setListaPaneles(String.valueOf(i));
        } else {
            int i = 0;
            int j = 0;
            while (i < getTotales().size() - 1) {
                TotalDocumento a = getTotales().get(i);
                double valor = Double.parseDouble((a.getValor() == null) ? "0" : a.getValor().toString());

                if (i < 3)
                    valor = 1f;

                if (valor > 0 && TOTALES_PRESENTACION[i].indexOf("1") >= 0) {
                    getForm().getListaTitulos().add(a.getTitulo());
                    getForm().getListaValores().add((a.getValor() == null) ? "" : a.getValor().toString());
                    getForm().getListaFormatos().add(Elemento.FORMATO_MONEDA);
                    getForm().getListaCamposAlineadosDerecha().add(String.valueOf(j++));
                }
                i++;
            }
            getForm().setListaDimensiones("22", "11");
            getForm().setListaPaneles(String.valueOf(i));
        }
    }

    /**
     * Metodo para ejecutar los totales.
     *
     */
    private void totales() {
        if (isExportacion()) {
            getForm().getListaTitulos().add(TOTALES_EXPORTACION[12]);
        } else {
            getForm().getListaTitulos().add(getTotales().get(getTotales().size() - 1).getTitulo());
        }

        getForm().getListaValores()
                .add((getTotales().get(getTotales().size() - 1).getValor() == null) ? ""
                        : getTotales().get(getTotales().size() - 1)
                                .getValor()
                                .toString());
        getForm().getListaFormatos().add(Elemento.FORMATO_MONEDA);
        getForm().getListaCamposAlineadosDerecha().add("0");
        getForm().setListaDimensiones("22", "11");
        getForm().setListaPaneles("1");
    }

    /**
     * Metodo para agregar una imagen con la firma de un documento
     *
     * Esta firma no es legal ni optima para el SRI.
     *
     * @throws Exception
     */
    @Override
    protected synchronized void elementoFirma() {
        String firmaGrafica = getDatosFactura().getPathFirmaGrafica();        
        getElementosComunes().firmarGraficamente(firmaGrafica);
    }

    /**
     * Metodo para agregar informaci\u00f3n de la exportacion SRI.
     *
     */
    @Override
    protected synchronized void elemento17() {
        if (isExportacion()) {
            getElementosComunes().espacios(2);

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
                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, e.toString());
            }
        }
    }

    /**
     * Metodo para agregar Formas de pago exportaciones SRI
     *
     */
    @Override
    protected synchronized void elemento16() {
        int size = 0;
        TablasSRI tablasSRI = new TablasSRI();

        if (getDatosFactura().getFacturaXML()
                .getInfoFactura()
                .getPagos() != null
                && !getDatosFactura().getFacturaXML()
                        .getInfoFactura()
                        .getPagos()
                        .getPago().isEmpty()) {

            for (Pago a : getDatosFactura().getFacturaXML()
                    .getInfoFactura()
                    .getPagos()
                    .getPago()) {

                getForm().getListaTitulos().add((size + 1) + ".- Forma pago");
                getForm().getListaValores()
                        .add(tablasSRI.tabla24(a.getFormaPago()) + " a " + a.getPlazo() + " " + a.getUnidadTiempo() +
                                " por un valor de " + a.getTotal());
                getForm().getListaFormatos().add(Elemento.FORMATO_STRING);
                size++;
            }

            if (size > 0) {
                int total = 74 + (12 * size);
                if (getPdfWriter().getVerticalPosition(true) < total) {
                    getDocumento().newPage();
                }
                getElementosComunes().espacios(2);

                PdfPTable table = new PdfPTable(1);
                table.getDefaultCell().setBorder(0);

                table.setWidthPercentage(100f);

                getH2().setTexto(TXT_14_1);
                PdfPCell pdfPCell1 = getH2().escribeCelda();
                pdfPCell1.setBorder(Rectangle.BOX);
                pdfPCell1.setBorderWidthBottom(0f);
                table.addCell(pdfPCell1);

                getForm().setListaDimensiones("15", "85");
                getForm().setListaPaneles(String.valueOf(size));

                PdfPCell pdfPCell3 = getForm().escribeCelda();
                pdfPCell3.setBorder(Rectangle.BOX);
                pdfPCell3.setBorderWidthTop(0f);
                table.addCell(pdfPCell3);

                try {
                    getDocumento().add(table);
                } catch (DocumentException e) {
                    Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, e.toString());
                }

            }
        }
    }

    /**
     * Metodo para conocer si es de exportacion.
     * 
     * @return
     */
    private boolean isExportacion() {
        return (getDatosFactura().getFacturaXML()
                .getInfoFactura()
                .getComercioExterior() != null
                && getDatosFactura().getFacturaXML()
                        .getInfoFactura()
                        .getComercioExterior()
                        .trim()
                        .length() > 0);
    }

    private void informacionExportacion() {
        TablasSRI tablasSRI = new TablasSRI();
        getForm().setListaTitulos(TXT_15_2);
        getForm()
                .setListaValores(getDatosFactura().getFacturaXML()
                        .getInfoFactura()
                        .getIncoTermFactura(),
                        getDatosFactura().getFacturaXML()
                                .getInfoFactura()
                                .getLugarIncoTerm(),
                        tablasSRI.tabla25(getDatosFactura().getFacturaXML()
                                .getInfoFactura()
                                .getPaisOrigen()),
                        getDatosFactura().getFacturaXML()
                                .getInfoFactura()
                                .getPuertoEmbarque(),
                        tablasSRI.tabla25(getDatosFactura().getFacturaXML()
                                .getInfoFactura()
                                .getPaisDestino()),
                        getDatosFactura().getFacturaXML()
                                .getInfoFactura()
                                .getPuertoDestino(),
                        tablasSRI.tabla25(getDatosFactura().getFacturaXML()
                                .getInfoFactura()
                                .getPaisAdquisicion()));
        getForm()
                .setListaFormatos(Elemento.FORMATO_STRING, Elemento.FORMATO_STRING, Elemento.FORMATO_STRING,
                        Elemento.FORMATO_STRING, Elemento.FORMATO_STRING, Elemento.FORMATO_STRING,
                        Elemento.FORMATO_STRING);
        getForm().setListaDimensiones("45", "55");
        getForm().setListaPaneles("3", "7");
    }

    /**
     * Metodo para agregar informaci\u00f3n adicional.
     *
     */
    @Override
    protected synchronized void elemento9() {
        if (isExportacion())
            return;
        int size = informacionAdicional();

        if (size > 0) {
            getElementosComunes().espacios(2);
            getLinea().setWidthPercentage(100);
            getLinea().escribe();
            getH2().setTexto(TXT_10_1);
            getH2().escribe();
            getElementosComunes().espacios(2);
            getForm().escribe();
        }
    }

    /**
     * Metodo para agregar informaci\u00f3n adicional.
     *
     */
    private int informacionAdicional() {
        int size = 0;

        if (getDatosFactura().getFacturaXML().getInfoAdicional() != null && !getDatosFactura().getFacturaXML()
                .getInfoAdicional()
                .getCampoAdicional().isEmpty()) {

            for (Factura.InfoAdicional.CampoAdicional a : getDatosFactura().getFacturaXML()
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
                if (getPdfWriter().getVerticalPosition(true) < total) {
                    getDocumento().newPage();
                }
                getForm().setListaDimensiones("25", "75");
                getForm().setListaPaneles(String.valueOf(size));
            }
        }
        return size;
    }

    /**
     * Metodo para inicializar los totales.
     *
     */
    private void inicializaTotales() {
        TotalDocumento totalFactura = new TotalDocumento();

        totalFactura.setTitulo(TOTALES[0]);
        getTotales().add(0, totalFactura);

        totalFactura = new TotalDocumento();
        totalFactura.setTitulo(TOTALES[1]);
        getTotales().add(1, totalFactura);

        totalFactura = new TotalDocumento();
        totalFactura.setTitulo(TOTALES[2]);
        getTotales().add(2, totalFactura);

        totalFactura = new TotalDocumento();
        totalFactura.setTitulo(TOTALES[3]);
        getTotales().add(3, totalFactura);

        totalFactura = new TotalDocumento();
        totalFactura.setTitulo(TOTALES[4]);
        getTotales().add(4, totalFactura);

        totalFactura = new TotalDocumento();
        totalFactura.setTitulo(TOTALES[5]);
        getTotales().add(5, totalFactura);

        totalFactura = new TotalDocumento();
        totalFactura.setTitulo(TOTALES[6]);
        getTotales().add(6, totalFactura);

        totalFactura = new TotalDocumento();
        totalFactura.setTitulo(TOTALES[7]);
        getTotales().add(7, totalFactura);

        totalFactura = new TotalDocumento();
        totalFactura.setTitulo(TOTALES[8]);
        getTotales().add(8, totalFactura);

        totalFactura = new TotalDocumento();
        totalFactura.setTitulo(TOTALES[9]);
        getTotales().add(9, totalFactura);

        totalFactura = new TotalDocumento();
        totalFactura.setTitulo(TOTALES[10]);
        getTotales().add(10, totalFactura);

        totalFactura = new TotalDocumento();
        totalFactura.setTitulo(TOTALES[11]);
        getTotales().add(11, totalFactura);

        totalFactura = new TotalDocumento();
        totalFactura.setTitulo(TOTALES[12]);
        getTotales().add(12, totalFactura);
    }

    /**
     * Metodo para cargar los totales que el sistema tiene.
     *
     * @param bus
     */
    private void cargarTotales(com.aplicaciones13.ride.facturaexportacion.Factura bus) {

        if (bus.getInfoFactura().getTotalConImpuestos() != null && !bus.getInfoFactura()
                .getTotalConImpuestos()
                .getTotalImpuesto().isEmpty()) {

            for (Factura.InfoFactura.TotalConImpuestos.TotalImpuesto a : bus.getInfoFactura()
                    .getTotalConImpuestos()
                    .getTotalImpuesto()) {

                if (a.getCodigo().compareTo("2") == 0) {
                    if (a.getCodigoPorcentaje().compareTo("0") == 0) {
                        getTotales().get(1).setValor(a.getBaseImponible());
                    }

                    if (a.getCodigoPorcentaje().compareTo("2") == 0) {
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

    public DatosFactura getDatosFactura() {
        return datosFactura;
    }

    public void setDatosFactura(DatosFactura datosFactura) {
        this.datosFactura = datosFactura;
    }

    public List<TotalDocumento> getTotales() {
        return this.totalesCalculo;
    }

    public void setTotales(List<TotalDocumento> totales) {
        this.totalesCalculo = totales;
    }
}
