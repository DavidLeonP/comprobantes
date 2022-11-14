package com.aplicaciones13.ride.notacredito.impresion;

import com.aplicaciones13.sri.contenedores.TablasSRI;
import com.aplicaciones13.sri.contenedores.TotalDocumento;
import com.aplicaciones13.impresion.Elemento;
import com.aplicaciones13.impresion.ImpresionBaseElementos;
import com.aplicaciones13.ride.notacredito.NotaCredito;
import com.aplicaciones13.ride.notacredito.TotalConImpuestos;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase para imprimir los elementos de la nota de credito.
 * 
 * @author o.velez@13aplicaciones.com
 * 
 */
public class ImpresionElementosNotaCredito extends ImpresionBaseElementos {
    private static final String TXT_3_1 = "Nota Cr\u00e9dito";
    

    private static final String[] TXT_6_10 =
    { "Raz\u00f3n Social", "RUC / CI.", "Fecha Emisi\u00f3n" };

    private static final String[] TXT_6_11_1 =
    { "Comprobante (Modifica)", "N\u00famero", "Fecha", "RISE", "Raz\u00f3n" };

    private static final String[] TXT_6_11_2 =
    { "Comprobante (Modifica)", "N\u00famero", "Fecha", "Raz\u00f3n" };

    private static final String[] TXT_7_1 =
    { "Cod.", "Descripci\u00f3n", "Cant.", "Precio Uni.", "Desc.", "Total" };

    private static final String[] TXT_7_2 =
    { "Cod.", "Descripci\u00f3n", "Cant.", "Precio Uni.", "Total" };

    private static final String[] TOTALES =
    { "SUBTOTAL 12%", "SUBTOTAL 0%", "SUBTOTAL No Objeto de IVA", "SUBTOTAL",
      "TOTAL DESCUENTO", "TOTAL Excento IVA", "IVA 12%", "ICE", "IRBPNR",
      "VALOR TOTAL" };

    private static final String TXT_10_1 = "Informaci\u00f3n Adicional";


    private DatosNotaCredito datosNotaCredito;
    private double totalDescuento = 0;
    List<TotalDocumento> totalesCalculados;
    
    /**Metodo para generar el panel superior en un formato semejante al SRI.
     *
     */
    @Override
    protected synchronized void elemento10() {
        this.getElementosComunes().encabezado(
                getDatosNotaCredito().getPathLogo(),
                getDatosNotaCredito().getNotaCreditoXML().getInfoTributaria().getRazonSocial(),
                getDatosNotaCredito().getNotaCreditoXML().getInfoTributaria().getDirMatriz(),
                getDatosNotaCredito().getNotaCreditoXML().getInfoNotaCredito().getDirEstablecimiento(),
                getDatosNotaCredito().getNotaCreditoXML().getInfoNotaCredito().getContribuyenteEspecial(),
                getDatosNotaCredito().getNotaCreditoXML().getInfoNotaCredito().getObligadoContabilidad(),
                getDatosNotaCredito().getNotaCreditoXML().getInfoTributaria().getRuc(),
                TXT_3_1,
                getDatosNotaCredito().getNotaCreditoXML().getInfoTributaria().getEstab()
                        + "-" +
                        getDatosNotaCredito().getNotaCreditoXML().getInfoTributaria().getPtoEmi()
                        + "-" +
                        getDatosNotaCredito().getNotaCreditoXML().getInfoTributaria().getSecuencial(),
                getDatosNotaCredito().getClaveAccesoAutorizacion(),
                getDatosNotaCredito().getNumeroAutorizacion(),
                getDatosNotaCredito().getFechaAutorizacion(),
                getDatosNotaCredito().getAmbienteAutorizacion(),
                getDatosNotaCredito().getEmisionAutorizacion(),
                getDatosNotaCredito().isOffline());
    }

    /** Metodo para escribir la informacion del cliente.
     *
     */
    @Override
    protected synchronized void elemento11()  {
        getElementosComunes().espacios(2);

        PdfPTable table1 = new PdfPTable(1);
        table1.setWidthPercentage(100f);

        getForm().setListaTitulos(TXT_6_10);
        getForm().setListaValores(getDatosNotaCredito().getNotaCreditoXML().getInfoNotaCredito().getRazonSocialComprador(),
                                  getDatosNotaCredito().getNotaCreditoXML().getInfoNotaCredito().getIdentificacionComprador(),
                                  getDatosNotaCredito().getNotaCreditoXML().getInfoNotaCredito().getFechaEmision());
        getForm().setListaFormatos(Elemento.FORMATO_STRING,
                                   Elemento.FORMATO_STRING,
                                   Elemento.FORMATO_STRING);
        getForm().setListaDimensiones("25", "75");
        getForm().setListaPaneles("3");
        PdfPCell pdfPCell = getForm().escribeCelda();
        table1.addCell(pdfPCell);

        informacionCliente2();
        pdfPCell = getForm().escribeCelda();
        table1.addCell(pdfPCell);

        PdfPTable table = new PdfPTable(1);
        table.setWidthPercentage(100f);
        table.addCell(table1);

        try {
            getDocumento().add(table);
        } catch (DocumentException e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING,
                                                            e.toString());
        }
    }

    /** Metodo para escribir la informacion del cliente.
     *
     */
    @Override
    protected  synchronized void elemento12(){
        getElementosComunes().espacios(2);

        if (getDatosNotaCredito().getNotaCreditoXML().getDetalles() != null &&
            !getDatosNotaCredito().getNotaCreditoXML().getDetalles().getDetalle().isEmpty()) {

            detalleNotaCreditoCompleta();

            PdfPTable table = new PdfPTable(1);
            table.setWidthPercentage(100f);
            PdfPCell pdfPCell = getTabla().escribeCelda();
            pdfPCell.setBorder(Rectangle.BOX);

            table.addCell(pdfPCell);

            try {
                getDocumento().add(table);
            } catch (DocumentException e) {
                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING,
                                                                e.toString());
            }

            if (getPdfWriter().getVerticalPosition(true) < 140)
                getDocumento().newPage();
        }
    }

    
    /** Metodo para crear la informacion del cliente
     *
     */
    private void informacionCliente2() {
        TablasSRI tablasSRI = new TablasSRI();

        String rise =
            getDatosNotaCredito().getNotaCreditoXML().getInfoNotaCredito().getRise();

        if (rise != null && rise.trim().length() > 0) {

            getForm().setListaTitulos(TXT_6_11_1);
            getForm().setListaValores(tablasSRI.tabla4(getDatosNotaCredito().getNotaCreditoXML().getInfoNotaCredito().getCodDocModificado()),
                                      getDatosNotaCredito().getNotaCreditoXML().getInfoNotaCredito().getNumDocModificado(),
                                      getDatosNotaCredito().getNotaCreditoXML().getInfoNotaCredito().getFechaEmisionDocSustento(),
                                      rise,
                                      getDatosNotaCredito().getNotaCreditoXML().getInfoNotaCredito().getMotivo());
            getForm().setListaFormatos(Elemento.FORMATO_STRING,
                                       Elemento.FORMATO_STRING,
                                       Elemento.FORMATO_STRING,
                                       Elemento.FORMATO_STRING,
                                       Elemento.FORMATO_STRING);
            getForm().setListaDimensiones("25", "75");
            getForm().setListaPaneles("5");
        } else {
            getForm().setListaTitulos(TXT_6_11_2);
            getForm().setListaValores(tablasSRI.tabla4(getDatosNotaCredito().getNotaCreditoXML().getInfoNotaCredito().getCodDocModificado()),
                                      getDatosNotaCredito().getNotaCreditoXML().getInfoNotaCredito().getNumDocModificado(),
                                      getDatosNotaCredito().getNotaCreditoXML().getInfoNotaCredito().getFechaEmisionDocSustento(),
                                      getDatosNotaCredito().getNotaCreditoXML().getInfoNotaCredito().getMotivo());
            getForm().setListaFormatos(Elemento.FORMATO_STRING,
                                       Elemento.FORMATO_STRING,
                                       Elemento.FORMATO_STRING,
                                       Elemento.FORMATO_STRING);
            getForm().setListaDimensiones("25", "75");
            getForm().setListaPaneles("4");
        }
    }
    
    /** Metodo para detalle NotaCredito completa.
     *
     */
    private void detalleNotaCreditoCompleta() {
        if (totalDescuento > 0) {
            List<Object> listaDatos = new ArrayList<>();           

            for (NotaCredito.Detalles.Detalle a :
                 getDatosNotaCredito().getNotaCreditoXML().getDetalles().getDetalle()) {
                    List<String> listaValores = new ArrayList<>();
                listaValores.add(0, a.getCodigoInterno());
                listaValores.add(1, a.getDescripcion());
                listaValores.add(2, a.getCantidad().toString());
                listaValores.add(3, a.getPrecioUnitario().toString());
                listaValores.add(4, a.getDescuento().toString());
                listaValores.add(5, a.getPrecioTotalSinImpuesto().toString());

                totalDescuento =
                        totalDescuento + a.getDescuento().doubleValue();

                listaDatos.add(listaValores);                

                if (a.getCodigoAdicional() != null &&
                    a.getCodigoAdicional().trim().length() > 0) {
                    listaValores = new ArrayList<>();
                    listaValores.add(0, "");
                    listaValores.add(1, "Cod.: " + a.getCodigoAdicional());
                    listaValores.add(2, "");
                    listaValores.add(3, "");
                    listaValores.add(4, "");
                    listaValores.add(5, "");
                    listaDatos.add(listaValores);  
                }

                if (a.getDetallesAdicionales() != null &&
                    !a.getDetallesAdicionales().getDetAdicional().isEmpty()) {
                    for (NotaCredito.Detalles.Detalle.DetallesAdicionales.DetAdicional b :
                         a.getDetallesAdicionales().getDetAdicional()) {
                        listaValores = new ArrayList<>();
                        listaValores.add(0, "");
                        listaValores.add(1,
                                         b.getNombre() + ": " + b.getValor());
                        listaValores.add(2, "");
                        listaValores.add(3, "");
                        listaValores.add(4, "");
                        listaValores.add(5, "");
                        listaDatos.add(listaValores);  
                    }
                }


                getTabla().setListaTitulos(TXT_7_1);
                getTabla().setListaFormatos(Elemento.FORMATO_STRING,
                                            Elemento.FORMATO_STRING,
                                            Elemento.FORMATO_STRING,
                                            Elemento.FORMATO_STRING,
                                            Elemento.FORMATO_STRING,
                                            Elemento.FORMATO_STRING);
                getTabla().setListaDimensiones("10", "10", "35", "10", "10",
                                               "10", "15");
                getTabla().setListaAlineacion(Element.ALIGN_LEFT,
                                              Element.ALIGN_LEFT,
                                              Element.ALIGN_RIGHT,
                                              Element.ALIGN_RIGHT,
                                              Element.ALIGN_RIGHT,
                                              Element.ALIGN_RIGHT);
            }
            getTabla().setListaTitulos(TXT_7_1);
            getTabla().setListaFormatos(Elemento.FORMATO_STRING,
                                        Elemento.FORMATO_STRING,
                                        Elemento.FORMATO_STRING,
                                        Elemento.FORMATO_STRING,
                                        Elemento.FORMATO_STRING,
                                        Elemento.FORMATO_STRING);
            getTabla().setListaDimensiones("15", "40", "10", "10", "10", "15");
            getTabla().setListaAlineacion(Element.ALIGN_LEFT,
                                          Element.ALIGN_LEFT,
                                          Element.ALIGN_RIGHT,
                                          Element.ALIGN_RIGHT,
                                          Element.ALIGN_RIGHT,
                                          Element.ALIGN_RIGHT);
            getTabla().setListaDatos(listaDatos);
            getTabla().setAncho(100);
        } else {
            List<Object> listaDatos = new ArrayList<>();
            

            for (NotaCredito.Detalles.Detalle a :
                 getDatosNotaCredito().getNotaCreditoXML().getDetalles().getDetalle()) {
                List<String> listaValores = new ArrayList<>();
                listaValores.add(0, a.getCodigoInterno());
                listaValores.add(1, a.getDescripcion());
                listaValores.add(2, a.getCantidad().toString());
                listaValores.add(3, a.getPrecioUnitario().toString());                
                listaValores.add(4, a.getPrecioTotalSinImpuesto().toString());

                totalDescuento =
                        totalDescuento + a.getDescuento().doubleValue();

                listaDatos.add(listaValores);

                if (a.getCodigoAdicional() != null &&
                    a.getCodigoAdicional().trim().length() > 0) {
                    listaValores = new ArrayList<>();
                    listaValores.add(0, "");
                    listaValores.add(1, "Cod.: " + a.getCodigoAdicional());
                    listaValores.add(2, "");
                    listaValores.add(3, "");
                    listaValores.add(4, "");                    
                    listaDatos.add(listaValores);
                }

                if (a.getDetallesAdicionales() != null &&
                    !a.getDetallesAdicionales().getDetAdicional().isEmpty()) {
                    for (NotaCredito.Detalles.Detalle.DetallesAdicionales.DetAdicional b :
                         a.getDetallesAdicionales().getDetAdicional()) {
                        listaValores = new ArrayList<>();
                        listaValores.add(0, "");
                        listaValores.add(1,
                                         b.getNombre() + ": " + b.getValor());
                        listaValores.add(2, "");
                        listaValores.add(3, "");
                        listaValores.add(4, "");                        
                        
                        listaDatos.add(listaValores);
                    }
                }

                getTabla().setListaTitulos(TXT_7_2);
                getTabla().setListaFormatos(Elemento.FORMATO_STRING,
                                            Elemento.FORMATO_STRING,
                                            Elemento.FORMATO_STRING,
                                            Elemento.FORMATO_STRING,                                            
                                            Elemento.FORMATO_STRING);
                getTabla().setListaDimensiones("10", "10", "45", "10", "10",
                                                "15");
                getTabla().setListaAlineacion(Element.ALIGN_LEFT,
                                              Element.ALIGN_LEFT,
                                              Element.ALIGN_RIGHT,
                                              Element.ALIGN_RIGHT,                                              
                                              Element.ALIGN_RIGHT);
            }
            getTabla().setListaTitulos(TXT_7_2);
            getTabla().setListaFormatos(Elemento.FORMATO_STRING,
                                        Elemento.FORMATO_STRING,
                                        Elemento.FORMATO_STRING,
                                        Elemento.FORMATO_STRING,                                        
                                        Elemento.FORMATO_STRING);
            getTabla().setListaDimensiones("15", "50", "10", "10",  "15");
            getTabla().setListaAlineacion(Element.ALIGN_LEFT,
                                          Element.ALIGN_LEFT,
                                          Element.ALIGN_RIGHT,
                                          Element.ALIGN_RIGHT,                                          
                                          Element.ALIGN_RIGHT);
            getTabla().setListaDatos(listaDatos);
            getTabla().setAncho(100);
        }
    }

    /** Metodo para agregar los totales de la notaCredito
     *
     */
    @Override
    protected  synchronized void elemento13()  {
        getElementosComunes().espacios(2);

        PdfPTable table = new PdfPTable(1);
        table.getDefaultCell().setBorder(0);

        table.setWidthPercentage(100f);

        subTotales();
        PdfPCell pdfPCell1 = getForm().escribeCelda();
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
        table3.addCell(getLinea().escribeCelda());

        pdfPCell2.addElement(table3);
        table.addCell(pdfPCell2);

        totales();
        PdfPCell pdfPCell3 = getForm().escribeCelda();
        pdfPCell3.setBorder(Rectangle.BOX);
        pdfPCell3.setBorderWidthTop(0f);
        table.addCell(pdfPCell3);

        try {
            getDocumento().add(table);
        } catch (DocumentException e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING,
                                                            e.toString());
        }
    }
    
    /**
     * Metodo para agregar una imagen con la firma de un documento
     *
     * Esta firma no es legal ni optima para el SRI.
     *
     * @throws Exception
     */
    @Override
    protected  synchronized void elementoFirma()  {
        String firmaGrafica = getDatosNotaCredito().getPathFirmaGrafica();
        getElementosComunes().firmarGraficamente(firmaGrafica);
    }


    /** Metodo para ejecutar los totales.
     *
     */
    private void subTotales() {
        this.totalesCalculados = new ArrayList<>();
        inicializaTotales();

        cargarTotales(getDatosNotaCredito().getNotaCreditoXML());

        int i = 0;
        int j = 0;
        while (i < getTotales().size() - 1) {

            if (!(i == 4 && totalDescuento == 0)) {
                TotalDocumento a = getTotales().get(i);
                getForm().getListaTitulos().add(a.getTitulo());
                getForm().getListaValores().add((a.getValor() == null) ? "" :
                                                a.getValor().toString());
                getForm().getListaFormatos().add(Elemento.FORMATO_MONEDA);
                getForm().getListaCamposAlineadosDerecha().add(String.valueOf(j++));
            }
            i++;
        }
        getForm().setListaDimensiones("70", "30");
        getForm().setListaPaneles("-1", "-1", String.valueOf(i));
    }


    /** Metodo para ejecutar los totales.
     *
     */
    private void totales() {
        getForm().getListaTitulos().add(getTotales().get(getTotales().size() -
                                                         1).getTitulo());

        getForm().getListaValores().add((getTotales().get(getTotales().size() -
                                                          1).getValor() ==
                                         null) ? "" :
                                        getTotales().get(getTotales().size() -
                                                         1).getValor().toString());
        getForm().getListaFormatos().add(Elemento.FORMATO_MONEDA);
        getForm().getListaCamposAlineadosDerecha().add("0");
        getForm().setListaDimensiones("70", "30");
        getForm().setListaPaneles("-1", "-1", "1");
    }

    /** Metodo para agregar informaci\u00f3n adicional.
     *
     */
    @Override
    protected synchronized void elemento9() {
        int size = 0;

        if (getDatosNotaCredito().getNotaCreditoXML().getInfoAdicional() !=
            null &&
            !getDatosNotaCredito().getNotaCreditoXML().getInfoAdicional().getCampoAdicional().isEmpty()) {

            for (NotaCredito.InfoAdicional.CampoAdicional a :
                 getDatosNotaCredito().getNotaCreditoXML().getInfoAdicional().getCampoAdicional()) {

                if (!a.getNombre().startsWith("js")) {
                    getForm().getListaTitulos().add(a.getNombre());
                    getForm().getListaValores().add((a.getValue() == null) ?
                                                    "" :
                                                    String.valueOf(a.getValue()));
                    getForm().getListaFormatos().add(Elemento.FORMATO_STRING);
                    size++;
                }
            }

            if (size > 0) {

                int total = 74 + (12 * size);

                if (getPdfWriter().getVerticalPosition(true) < total)
                    getDocumento().newPage();

                getElementosComunes().espacios(2);

                getH2().setTexto(TXT_10_1);
                getH2().escribe();
                getElementosComunes().espacios(2);

                getForm().setListaDimensiones("25", "75");
                getForm().setListaPaneles(String.valueOf(size));
                getForm().escribe();
            }
        }
    }

    /** Metodo para inicializar los totales.
     *
     */
    public void inicializaTotales() {
        TotalDocumento totalNotaCredito = new TotalDocumento();

        totalNotaCredito.setTitulo(TOTALES[0]);
        getTotales().add(0, totalNotaCredito);

        totalNotaCredito = new TotalDocumento();
        totalNotaCredito.setTitulo(TOTALES[1]);
        getTotales().add(1, totalNotaCredito);

        totalNotaCredito = new TotalDocumento();
        totalNotaCredito.setTitulo(TOTALES[2]);
        getTotales().add(2, totalNotaCredito);

        totalNotaCredito = new TotalDocumento();
        totalNotaCredito.setTitulo(TOTALES[3]);
        getTotales().add(3, totalNotaCredito);

        totalNotaCredito = new TotalDocumento();
        totalNotaCredito.setTitulo(TOTALES[4]);
        getTotales().add(4, totalNotaCredito);

        totalNotaCredito = new TotalDocumento();
        totalNotaCredito.setTitulo(TOTALES[5]);
        getTotales().add(5, totalNotaCredito);

        totalNotaCredito = new TotalDocumento();
        totalNotaCredito.setTitulo(TOTALES[6]);
        getTotales().add(6, totalNotaCredito);

        totalNotaCredito = new TotalDocumento();
        totalNotaCredito.setTitulo(TOTALES[7]);
        getTotales().add(7, totalNotaCredito);

        totalNotaCredito = new TotalDocumento();
        totalNotaCredito.setTitulo(TOTALES[8]);
        getTotales().add(8, totalNotaCredito);

        totalNotaCredito = new TotalDocumento();
        totalNotaCredito.setTitulo(TOTALES[9]);
        getTotales().add(9, totalNotaCredito);
    }

    /** Metodo para cargar los totales que el sistema tiene.
     *
     * @param bus
     */
    private void cargarTotales(com.aplicaciones13.ride.notacredito.NotaCredito bus) {
        if (bus.getInfoNotaCredito().getTotalConImpuestos() != null &&
            !bus.getInfoNotaCredito().getTotalConImpuestos().getTotalImpuesto().isEmpty()) {
            for (TotalConImpuestos.TotalImpuesto a :
                 bus.getInfoNotaCredito().getTotalConImpuestos().getTotalImpuesto()) {

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

                    if (a.getCodigoPorcentaje().compareTo("7") == 0) {
                        getTotales().get(5).setValor(a.getBaseImponible());
                    }
                }

                if (a.getCodigo().compareTo("3") == 0) {
                    getTotales().get(7).setValor(a.getValor());
                }

                if (a.getCodigo().compareTo("5") == 0) {
                    getTotales().get(8).setValor(a.getValor());
                }
            }
        }

        getTotales().get(3).setValor(bus.getInfoNotaCredito().getTotalSinImpuestos());
        getTotales().get(4).setValor(BigDecimal.valueOf(totalDescuento));
        getTotales().get(9).setValor(bus.getInfoNotaCredito().getValorModificacion());
    }

    public DatosNotaCredito getDatosNotaCredito() {
        return datosNotaCredito;
    }

    public void setDatosNotaCredito(DatosNotaCredito datosNotaCredito) {
        this.datosNotaCredito = datosNotaCredito;
    }

    public List<TotalDocumento> getTotales() {
        return this.totalesCalculados;
    }

    public void setTotales(List<TotalDocumento> totales) {
        this.totalesCalculados = totales;
    }
}
