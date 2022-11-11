package com.aplicaciones13.ride.notacredito.impresion;


import com.aplicaciones13.sri.contenedores.TablasSRI;
import com.aplicaciones13.sri.contenedores.TotalDocumento;
import com.aplicaciones13.Constantes;
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

public class ImpresionElementosNotaCredito extends ImpresionBaseElementos {
    private static final String TXT_3_1 = "Nota Cr\u00e9dito";
    private static final String TXT_3_2 = "No. %s-%s-%s";
    private static final String[] TXT_3_3 =
    { Constantes.NUMERO_AUTORIZACION, Constantes.FECHA_AUTORIZACION, Constantes.AMBIENTE,
      Constantes.EMISION };
    private static final String TXT_4_1 = "Clave de Acceso";
    private static final String[] TXT_5_1 =
    { "RUC", Constantes.DIRECCION_MATRIZ, Constantes.DIRECCION_ESTABLECIMIENTO,
      Constantes.CONTRIBUYENTE_ESPECIAL_NO, "Obligado a llevar contabilidad" };
    private static final String[] TXT_5_2 =
    { "RUC", Constantes.DIRECCION_MATRIZ, Constantes.DIRECCION_ESTABLECIMIENTO,
      Constantes.CONTRIBUYENTE_ESPECIAL_NO, "" };
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

    private static final String[] TXT_11_3 =
    { Constantes.DIRECCION_MATRIZ, Constantes.DIRECCION_ESTABLECIMIENTO };
    private static final String[] TXT_11_4 =
    { Constantes.CONTRIBUYENTE_ESPECIAL_NO, "Obligado a llevar contabilidad" };
    private static final String TXT_11_5 = "RUC: ";
    private static final String TXT_11_6 = "Nota Cr\u00e9dito";
    private static final String TXT_11_7 = "No.: %s-%s-%s";
    private static final String TXT_11_8 = "N\u00famero Autorizaci\u00f3n";
    private static final String TXT_11_9 = "Fecha Autorizaci\u00f3n";
    private static final String TXT_11_10 = Constantes.AMBIENTE;
    private static final String TXT_11_11 = "Emisi\u00f3n";
    private static final String TXT_11_12 = "Clave de Acceso";
    private static final String TXT_11_13 = "Normal";


    private DatosNotaCredito datosNotaCredito;
    private double totalDescuento = 0;
    List<TotalDocumento> totalesCalculados;
    
    /**Metodo para generar el panel superior en un formato semejante al SRI.
     *
     */
    @Override
    protected synchronized void elemento10() {
        PdfPTable table = new PdfPTable(2);

        table.setWidthPercentage(100);

        //Lado Izquierdo
        PdfPTable tableIzquierda = new PdfPTable(1);

        //Logotipo lado Izquierdo
        getImagen().setPath(getDatosNotaCredito().getPathLogo());
        getImagen().setScala(33f);
        tableIzquierda.addCell(getImagen().escribeCelda());

        //Nombre de la empresa
        getH1().setTexto(getDatosNotaCredito().getNotaCreditoXML().getInfoTributaria().getRazonSocial());
        tableIzquierda.addCell(getH1().escribeCelda());

        //Informacion de la empresa
        getForm().setListaTitulos(TXT_11_3);
        getForm().setListaValores(getDatosNotaCredito().getNotaCreditoXML().getInfoTributaria().getDirMatriz(),
                                  getDatosNotaCredito().getNotaCreditoXML().getInfoNotaCredito().getDirEstablecimiento());
        getForm().setListaFormatos(Elemento.FORMATO_STRING,
                                   Elemento.FORMATO_STRING);
        getForm().setListaDimensiones("30", "70");
        getForm().setListaPaneles("2");
        tableIzquierda.addCell(getForm().escribeCelda());

        //Informacion de contabilidad
        getForm().setListaTitulos(TXT_11_4);
        getForm().setListaValores(getDatosNotaCredito().getNotaCreditoXML().getInfoNotaCredito().getContribuyenteEspecial(),
                                  getDatosNotaCredito().getNotaCreditoXML().getInfoNotaCredito().getObligadoContabilidad());
        getForm().setListaFormatos(Elemento.FORMATO_STRING,
                                   Elemento.FORMATO_STRING);
        getForm().setListaDimensiones("50", "50");
        getForm().setListaPaneles("2");
        tableIzquierda.addCell(getForm().escribeCelda());

        //Lado Derecho
        PdfPTable tableDerecha = new PdfPTable(1);


        //Ruc
        getH2().setTexto(TXT_11_5 +
                         getDatosNotaCredito().getNotaCreditoXML().getInfoTributaria().getRuc());
        tableDerecha.addCell(getH2().escribeCelda());

        //Nombre del documento
        getH1().setTexto(TXT_11_6);
        tableDerecha.addCell(getH1().escribeCelda());

        //Numero del documento
        getH1().setTexto(String.format(TXT_11_7,
                                       getDatosNotaCredito().getNotaCreditoXML().getInfoTributaria().getEstab(),
                                       getDatosNotaCredito().getNotaCreditoXML().getInfoTributaria().getPtoEmi(),
                                       getDatosNotaCredito().getNotaCreditoXML().getInfoTributaria().getSecuencial()));
        tableDerecha.addCell(getH1().escribeCelda());

        //Numero de autorizacion
        getH2().setTexto(TXT_11_8);
        tableDerecha.addCell(getH2().escribeCelda());
        if (getDatosNotaCredito().isOffline())
            getP().setTexto(getDatosNotaCredito().getClaveAccesoAutorizacion());
        else
            getP().setTexto(getDatosNotaCredito().getNumeroAutorizacion());

        tableDerecha.addCell(getP().escribeCelda());

        //Fecha Autorizacion - modo offline
        if (!getDatosNotaCredito().isOffline()) {
            getForm().setListaTitulos(TXT_11_9);
            getForm().setListaValores(getDatosNotaCredito().getFechaAutorizacion());
            getForm().setListaFormatos(Elemento.FORMATO_STRING);
            getForm().setListaDimensiones("40", "60");
            getForm().setListaPaneles("1");
            tableDerecha.addCell(getForm().escribeCelda());
        }

        //Ambiente
        getForm().setListaTitulos(TXT_11_10);
        getForm().setListaValores(getDatosNotaCredito().getAmbienteAutorizacion());
        getForm().setListaFormatos(Elemento.FORMATO_STRING);
        getForm().setListaDimensiones("40", "60");
        getForm().setListaPaneles("1");
        tableDerecha.addCell(getForm().escribeCelda());

        //Emision
        if (getDatosNotaCredito().isOffline())
            getDatosNotaCredito().setEmisionAutorizacion(TXT_11_13);
        getForm().setListaTitulos(TXT_11_11);
        getForm().setListaValores(getDatosNotaCredito().getEmisionAutorizacion());
        getForm().setListaFormatos(Elemento.FORMATO_STRING);
        getForm().setListaDimensiones("40", "60");
        getForm().setListaPaneles("1");
        tableDerecha.addCell(getForm().escribeCelda());

        //Clave de acceso
        getH2().setTexto(TXT_11_12);
        tableDerecha.addCell(getH2().escribeCelda());
        
        //Codigo de barras
        getImagen().procesarCode128(getDatosNotaCredito().getClaveAccesoAutorizacion());
        tableDerecha.addCell(getImagen().escribeCelda());
        
        table.addCell(tableIzquierda);
        table.addCell(tableDerecha);
        try {
            getDocumento().add(table);
        } catch (DocumentException e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE,
                                                            e.toString());
        }
    }

    /** Metodo para escribir la informacion del cliente.
     *
     */
    @Override
    protected synchronized void elemento11()  {
        espacios(2);

        PdfPTable table1 = new PdfPTable(1);
        table1.setWidthPercentage(100f);

        informacionCliente1();
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
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE,
                                                            e.toString());
        }
    }

    /** Metodo para escribir la informacion del cliente.
     *
     */
    @Override
    protected  synchronized void elemento12(){
        espacios(2);

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
                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE,
                                                                e.toString());
            }

            if (getPdfWriter().getVerticalPosition(true) < 140)
                getDocumento().newPage();
        }
    }

    /** Metodo para agregar la informaci\u00f3n del documento
     *
     */
    @Override
    protected synchronized void elemento3() {
        getH1().setTexto(TXT_3_1);
        getH1().escribe();

        getH1().setTexto(String.format(TXT_3_2,
                                       getDatosNotaCredito().getNotaCreditoXML().getInfoTributaria().getEstab(),
                                       getDatosNotaCredito().getNotaCreditoXML().getInfoTributaria().getPtoEmi(),
                                       getDatosNotaCredito().getNotaCreditoXML().getInfoTributaria().getSecuencial()));
        getH1().escribe();

        espacios(1);
        getForm().setListaTitulos(TXT_3_3);

        getForm().setListaValores(getDatosNotaCredito().getNumeroAutorizacion(),
                                  getDatosNotaCredito().getFechaAutorizacion(),
                                  getDatosNotaCredito().getAmbienteAutorizacion(),
                                  getDatosNotaCredito().getEmisionAutorizacion());
        getForm().setListaFormatos(Elemento.FORMATO_STRING,
                                   Elemento.FORMATO_STRING,
                                   Elemento.FORMATO_STRING,
                                   Elemento.FORMATO_STRING);
        getForm().setListaDimensiones("25", "75");
        getForm().setListaPaneles("4");
        getForm().escribe();
    }

    /** Metodo para escribir el codigo de barras de la clave de acceso.
     *
     */
    @Override
    protected synchronized void elemento4() {
        getForm().setListaTitulos(TXT_4_1);

        getForm().setListaValores("");
        getForm().setListaFormatos(Elemento.FORMATO_STRING);
        getForm().setListaDimensiones("25", "75");
        getForm().setListaPaneles("1");
        getForm().escribe();

        getImagen().procesarCode128(getDatosNotaCredito().getClaveAccesoAutorizacion());
        getImagen().setX(165);
        getImagen().setY(680);
        getImagen().escribe();        
    }

    /** Metodo para escribir la informacion de la empresa
     *
     * @throws Exception
     */
    @Override
    protected synchronized void elemento5() {
        espacios(5);
        getLinea().escribe();
        getH2().setTexto(getDatosNotaCredito().getNotaCreditoXML().getInfoTributaria().getRazonSocial());
        getH2().escribe();

        espacios(1);

        if (getDatosNotaCredito().getNotaCreditoXML().getInfoNotaCredito().getObligadoContabilidad() ==
            null ||
            getDatosNotaCredito().getNotaCreditoXML().getInfoNotaCredito().getObligadoContabilidad().trim().length() ==
            0)
            getForm().setListaTitulos(TXT_5_2);
        else
            getForm().setListaTitulos(TXT_5_1);
        getForm().setListaValores(getDatosNotaCredito().getNotaCreditoXML().getInfoTributaria().getRuc(),
                                  getDatosNotaCredito().getNotaCreditoXML().getInfoTributaria().getDirMatriz(),
                                  getDatosNotaCredito().getNotaCreditoXML().getInfoNotaCredito().getDirEstablecimiento(),
                                  getDatosNotaCredito().getNotaCreditoXML().getInfoNotaCredito().getContribuyenteEspecial(),
                                  getDatosNotaCredito().getNotaCreditoXML().getInfoNotaCredito().getObligadoContabilidad());
        getForm().setListaFormatos(Elemento.FORMATO_STRING,
                                   Elemento.FORMATO_STRING,
                                   Elemento.FORMATO_STRING,
                                   Elemento.FORMATO_STRING,
                                   Elemento.FORMATO_STRING);
        getForm().setListaDimensiones("25", "75");
        getForm().setListaPaneles("5");
        getForm().escribe();
    }

    /** Metodo para escribir la informacion del cliente.
     *
     */
    @Override
    protected synchronized void elemento6(){
        espacios(2);
        getLinea().escribe();

        informacionCliente1();
        getForm().escribe();

        espacios(1);

        informacionCliente2();
        getForm().escribe();
    }

    /** Metodo para crear la informacion del cliente
     *
     */
    private void informacionCliente1() {
        getForm().setListaTitulos(TXT_6_10);
        getForm().setListaValores(getDatosNotaCredito().getNotaCreditoXML().getInfoNotaCredito().getRazonSocialComprador(),
                                  getDatosNotaCredito().getNotaCreditoXML().getInfoNotaCredito().getIdentificacionComprador(),
                                  getDatosNotaCredito().getNotaCreditoXML().getInfoNotaCredito().getFechaEmision());
        getForm().setListaFormatos(Elemento.FORMATO_STRING,
                                   Elemento.FORMATO_STRING,
                                   Elemento.FORMATO_STRING);
        getForm().setListaDimensiones("25", "75");
        getForm().setListaPaneles("3");
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

    /** Metodo para imprimir el detalle de la notaCredito
     *
     * Si los datos en la notaCredito existen
     *  Llena el lista de datos a ser recorridos
     *  Si existe codigo auxiliar
     *      Agrega los datos para la ubicacion en pantalla
     *  Caso contrario
     *      Agrega los datos para la ubicacion en pantalla sin el codigo auxiliar
     *
     */
    @Override
    protected synchronized void elemento7() {
        espacios(2);

        if (getDatosNotaCredito().getNotaCreditoXML().getDetalles() != null &&
            !getDatosNotaCredito().getNotaCreditoXML().getDetalles().getDetalle().isEmpty()) {

            getLinea().escribe();

            detalleNotaCreditoCompleta();

            getTabla().escribe();

            getLinea().escribe();
            if (getPdfWriter().getVerticalPosition(true) < 140)
                getDocumento().newPage();
        }
    }

    /** Metodo para detalle NotaCredito completa.
     *
     */
    public void detalleNotaCreditoCompleta() {

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
    protected  synchronized void elemento8() {
        espacios(2);

        subTotales();
        getForm().escribe();

        getLinea().setWidthPercentage(34);
        getLinea().escribe();

        totales();
        getForm().escribe();
    }

    /** Metodo para agregar los totales de la notaCredito
     *
     */
    @Override
    protected  synchronized void elemento13()  {
        espacios(2);

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
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE,
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
    protected  synchronized void elemento14()  {
        String firmaGrafica = getDatosNotaCredito().getPathFirmaGrafica();
        firmarGraficamente(firmaGrafica);        
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

                espacios(2);

                getH2().setTexto(TXT_10_1);
                getH2().escribe();
                espacios(2);

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
    public void cargarTotales(com.aplicaciones13.ride.notacredito.NotaCredito bus) {
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
