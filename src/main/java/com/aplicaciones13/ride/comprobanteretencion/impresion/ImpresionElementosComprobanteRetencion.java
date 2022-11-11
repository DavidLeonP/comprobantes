package com.aplicaciones13.ride.comprobanteretencion.impresion;


import com.aplicaciones13.sri.contenedores.TablasSRI;
import com.aplicaciones13.sri.contenedores.TotalDocumento;
import com.aplicaciones13.impresion.Elemento;
import com.aplicaciones13.impresion.ImpresionBaseElementos;
import com.aplicaciones13.impresion.MarcaAgua;
import com.aplicaciones13.impresion.Pie;
import com.aplicaciones13.ride.comprobanteretencion.ComprobanteRetencion;
import com.aplicaciones13.ride.comprobanteretencion.Impuesto;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;


/** Objeto para crear un documento de comprobante de Retencion.
 *
 * @author omarv omargo33@JeremiasSoft.com
 *
 */
public class ImpresionElementosComprobanteRetencion extends ImpresionBaseElementos {

    private static final String TXT_3_1 = "Comprobante de Retenci\u00f3n";
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
    private static final String[] TXT_6_1 = { "Raz\u00f3n Social", "RUC / CI.", "Ejercicio Fiscal", "Fecha Emisi\u00f3n" };
    private static final String[] TXT_7_1 = {
        "Comprobante", "N\u00famero", "Fecha Emisi\u00f3n", "Base Imponible", "Impuesto", "Descripcion", "% Retenido",
        "Valor Retenido"
    };

    private static final String TXT_8_1 = "VALOR TOTAL";
    private double totalGuia = 0;

    private static final String TXT_10_1 = "Informaci\u00f3n Adicional";

    
    private static final String[] TXT_11_3 = { "Direcci\u00f3n Matriz", "Direcci\u00f3n Establecimiento" };
    private static final String[] TXT_11_4 = { "Contribuyente especial Nro.", "Obligado a llevar contabilidad" };
    private static final String TXT_11_5 = "RUC: ";
    private static final String TXT_11_6 = "Comprobante de Retenci\u00f3n";
    private static final String TXT_11_7 = "No.: %s-%s-%s";
    private static final String TXT_11_8 = "N\u00famero Autorizaci\u00f3n";
    private static final String TXT_11_9 = "Fecha Autorizaci\u00f3n";
    private static final String TXT_11_10 = "Ambiente";
    private static final String TXT_11_11 = "Emisi\u00f3n";
    private static final String TXT_11_12 = "Clave de Acceso";
    private static final String TXT_11_13 = "Normal";

    private DatosComprobanteRetencion datosComprobanteRetencion;
    List<TotalDocumento> totales;

    /** Metodo para agregar la marca de agua al sistema.
     *
     */
    @Override
    protected synchronized void elemento0() {
        getPdfWriter().setPageEvent(new MarcaAgua(getDatosComprobanteRetencion().getAmbienteAutorizacion()));
    }
    @Override
    protected synchronized void elemento1() {
        Pie pie = new Pie();        
        getPdfWriter().setPageEvent(pie);
    }

    /**Metodo para generar el logo del documento.
     *
     * Si el archivo no existe
     *  Agrega un logo temporal
     * Imprime el logo.
     *
     */
    @Override
    protected synchronized void elemento2() {
        getImagen().setPath(getDatosComprobanteRetencion().getPathLogo());
        getImagen().setScala(50f);
        getImagen().setX(400);
        getImagen().setY(690);
        getImagen().escribe();
    }

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
        getImagen().setPath(getDatosComprobanteRetencion().getPathLogo());
        getImagen().setScala(50f);
        tableIzquierda.addCell(getImagen().escribeCelda());

        //Nombre de la empresa
        getH1().setTexto(getDatosComprobanteRetencion().getComprobanteRetencionXML()
                                                       .getInfoTributaria()
                                                       .getRazonSocial());
        tableIzquierda.addCell(getH1().escribeCelda());

        //Informacion de la empresa
        getForm().setListaTitulos(TXT_11_3);
        getForm()
            .setListaValores(getDatosComprobanteRetencion().getComprobanteRetencionXML()
                                                                .getInfoTributaria()
                                                                .getDirMatriz(),
                             getDatosComprobanteRetencion().getComprobanteRetencionXML()
                                                                                                               .getInfoCompRetencion()
                                                                                                               .getDirEstablecimiento());
        getForm().setListaFormatos(Elemento.FORMATO_STRING, Elemento.FORMATO_STRING);
        getForm().setListaDimensiones("30", "70");
        getForm().setListaPaneles("2");
        tableIzquierda.addCell(getForm().escribeCelda());

        //Informacion de contabilidad
        getForm().setListaTitulos(TXT_11_4);
        getForm()
            .setListaValores(getDatosComprobanteRetencion().getComprobanteRetencionXML()
                                                                .getInfoCompRetencion()
                                                                .getContribuyenteEspecial(),
                             getDatosComprobanteRetencion().getComprobanteRetencionXML()
                                                                                                                           .getInfoCompRetencion()
                                                                                                                           .getObligadoContabilidad());
        getForm().setListaFormatos(Elemento.FORMATO_STRING, Elemento.FORMATO_STRING);
        getForm().setListaDimensiones("50", "50");
        getForm().setListaPaneles("2");
        tableIzquierda.addCell(getForm().escribeCelda());

        //Lado Derecho
        PdfPTable tableDerecha = new PdfPTable(1);


        //Ruc
        getH2().setTexto(TXT_11_5 + getDatosComprobanteRetencion().getComprobanteRetencionXML()
                                                                  .getInfoTributaria()
                                                                  .getRuc());
        tableDerecha.addCell(getH2().escribeCelda());

        //Nombre del documento
        getH1().setTexto(TXT_11_6);
        tableDerecha.addCell(getH1().escribeCelda());

        //Numero del documento
        getH1()
            .setTexto(String.format(TXT_11_7, getDatosComprobanteRetencion().getComprobanteRetencionXML()
                                                                               .getInfoTributaria()
                                                                               .getEstab(),
                                    getDatosComprobanteRetencion().getComprobanteRetencionXML()
                                                                                                                          .getInfoTributaria()
                                                                                                                          .getPtoEmi(),
                                                                         getDatosComprobanteRetencion().getComprobanteRetencionXML()
                                                                                                                                                                      .getInfoTributaria()
                                                                                                                                                                      .getSecuencial()));
        tableDerecha.addCell(getH1().escribeCelda());

        //Numero de autorizacion
        getH2().setTexto(TXT_11_8);
        tableDerecha.addCell(getH2().escribeCelda());
        if (getDatosComprobanteRetencion().isOffline())
            getP().setTexto(getDatosComprobanteRetencion().getClaveAccesoAutorizacion());
        else
            getP().setTexto(getDatosComprobanteRetencion().getNumeroAutorizacion());

        tableDerecha.addCell(getP().escribeCelda());

        //Fecha Autorizacion - modo offline
        if (!getDatosComprobanteRetencion().isOffline()) {
            getForm().setListaTitulos(TXT_11_9);
            getForm().setListaValores(getDatosComprobanteRetencion().getFechaAutorizacion());
            getForm().setListaFormatos(Elemento.FORMATO_STRING);
            getForm().setListaDimensiones("40", "60");
            getForm().setListaPaneles("1");
            tableDerecha.addCell(getForm().escribeCelda());
        }

        //Ambiente
        getForm().setListaTitulos(TXT_11_10);
        getForm().setListaValores(getDatosComprobanteRetencion().getAmbienteAutorizacion());
        getForm().setListaFormatos(Elemento.FORMATO_STRING);
        getForm().setListaDimensiones("40", "60");
        getForm().setListaPaneles("1");
        tableDerecha.addCell(getForm().escribeCelda());

        //Emision
        if (getDatosComprobanteRetencion().isOffline())
            getDatosComprobanteRetencion().setEmisionAutorizacion(TXT_11_13);
        getForm().setListaTitulos(TXT_11_11);
        getForm().setListaValores(getDatosComprobanteRetencion().getEmisionAutorizacion());
        getForm().setListaFormatos(Elemento.FORMATO_STRING);
        getForm().setListaDimensiones("40", "60");
        getForm().setListaPaneles("1");
        tableDerecha.addCell(getForm().escribeCelda());

        //Clave de acceso
        getH2().setTexto(TXT_11_12);
        tableDerecha.addCell(getH2().escribeCelda());

        getImagen().procesarCode128(getDatosComprobanteRetencion().getClaveAccesoAutorizacion());
        tableDerecha.addCell(getImagen().escribeCelda());

        table.addCell(tableIzquierda);
        table.addCell(tableDerecha);
        try {
            getDocumento().add(table);
        } catch (DocumentException e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, e.toString());
        }
    }

    /** Metodo para escribir la informacion del cliente.
     *
     */
    @Override
    protected synchronized void elemento11()  {
        espacios(2);

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


    /** Metodo para escribir la informacion del cliente.
     *
     */
    @Override
    protected synchronized void elemento12()  {
        espacios(2);

        if (getDatosComprobanteRetencion().getComprobanteRetencionXML().getImpuestos() != null &&
            !getDatosComprobanteRetencion().getComprobanteRetencionXML().getImpuestos().getImpuesto().isEmpty())             {
            detalleComprobanteRetencionCompleta();

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

    /** Metodo para agregar la informaci\u00f3n del documento
     *
     */
    @Override
    protected synchronized void elemento3() {
        getH1().setTexto(TXT_3_1);
        getH1().escribe();

        getH1()
            .setTexto(String.format(TXT_3_2, getDatosComprobanteRetencion().getComprobanteRetencionXML()
                                                                              .getInfoTributaria()
                                                                              .getEstab(),
                                    getDatosComprobanteRetencion().getComprobanteRetencionXML()
                                                                                                                         .getInfoTributaria()
                                                                                                                         .getPtoEmi(),
                                                                         getDatosComprobanteRetencion().getComprobanteRetencionXML()
                                                                                                                                                                     .getInfoTributaria()
                                                                                                                                                                     .getSecuencial()));
        getH1().escribe();

        espacios(1);
        getForm().setListaTitulos(TXT_3_3);

        getForm()
            .setListaValores(getDatosComprobanteRetencion().getNumeroAutorizacion(),
                             getDatosComprobanteRetencion().getFechaAutorizacion(),
                             getDatosComprobanteRetencion().getAmbienteAutorizacion(),
                             getDatosComprobanteRetencion().getEmisionAutorizacion());
        getForm()
            .setListaFormatos(Elemento.FORMATO_STRING, Elemento.FORMATO_STRING, Elemento.FORMATO_STRING,
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

        getImagen().procesarCode128(getDatosComprobanteRetencion().getClaveAccesoAutorizacion());
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
        getH2().setTexto(getDatosComprobanteRetencion().getComprobanteRetencionXML()
                                                       .getInfoTributaria()
                                                       .getRazonSocial());
        getH2().escribe();

        espacios(1);

        if (getDatosComprobanteRetencion().getComprobanteRetencionXML()
                                          .getInfoCompRetencion()
                                          .getObligadoContabilidad() == null ||
            getDatosComprobanteRetencion().getComprobanteRetencionXML()
                                                                                                              .getInfoCompRetencion()
                                                                                                              .getObligadoContabilidad()
                                                                                                              .trim()
                                                                                                              .length() ==
                         0)
            getForm().setListaTitulos(TXT_5_2);
        else
            getForm().setListaTitulos(TXT_5_1);
        getForm()
            .setListaValores(getDatosComprobanteRetencion().getComprobanteRetencionXML()
                                                                .getInfoTributaria()
                                                                .getRuc(),
                             getDatosComprobanteRetencion().getComprobanteRetencionXML()
                                                                                                         .getInfoTributaria()
                                                                                                         .getDirMatriz(),
                                                           getDatosComprobanteRetencion().getComprobanteRetencionXML()
                                                                                                                                                        .getInfoCompRetencion()
                                                                                                                                                        .getDirEstablecimiento(),
                              getDatosComprobanteRetencion().getComprobanteRetencionXML()
                                                                                                                                                                                                                .getInfoCompRetencion()
                                                                                                                                                                                                                .getContribuyenteEspecial(),
                                                             getDatosComprobanteRetencion().getComprobanteRetencionXML()
                                                                                                                                                                                                                                                                           .getInfoCompRetencion()
                                                                                                                                                                                                                                                                           .getObligadoContabilidad());
        getForm()
            .setListaFormatos(Elemento.FORMATO_STRING, Elemento.FORMATO_STRING, Elemento.FORMATO_STRING,
                              Elemento.FORMATO_STRING, Elemento.FORMATO_STRING);
        getForm().setListaDimensiones("25", "75");
        getForm().setListaPaneles("5");
        getForm().escribe();
    }

    /** Metodo para escribir la informacion del cliente.
     *
     */
    @Override
    protected synchronized void elemento6() {
        espacios(2);
        getLinea().escribe();

        informacionCliente();

        getForm().escribe();
    }

    /** Metodo para crear la informacion del cliente
     *
     */
    private void informacionCliente() {
        getForm().setListaTitulos(TXT_6_1);
        getForm()
            .setListaValores(getDatosComprobanteRetencion().getComprobanteRetencionXML()
                                                                .getInfoCompRetencion()
                                                                .getRazonSocialSujetoRetenido(),
                             getDatosComprobanteRetencion().getComprobanteRetencionXML()
                                                                                                                               .getInfoCompRetencion()
                                                                                                                               .getIdentificacionSujetoRetenido(),
                                                           getDatosComprobanteRetencion().getComprobanteRetencionXML()
                                                                                                                                                                                                 .getInfoCompRetencion()
                                                                                                                                                                                                 .getPeriodoFiscal(),
                              getDatosComprobanteRetencion().getComprobanteRetencionXML()
                                                                                                                                                                                                                                                    .getInfoCompRetencion()
                                                                                                                                                                                                                                                    .getFechaEmision());
        getForm()
            .setListaFormatos(Elemento.FORMATO_STRING, Elemento.FORMATO_STRING, Elemento.FORMATO_STRING,
                              Elemento.FORMATO_STRING);
        getForm().setListaDimensiones("25", "75");
        getForm().setListaPaneles("7");
    }

    /** Metodo para imprimir el detalle de la factura
     *
     * Si los datos en la factura existen
     *  Llena el vector de datos a ser recorridos
     *  Si existe codigo auxiliar
     *      Agrega los datos para la ubicacion en pantalla
     *  Caso contrario
     *      Agrega los datos para la ubicacion en pantalla sin el codigo auxiliar
     *
     */
    @Override
    protected synchronized void elemento7() {
        espacios(2);

        if (getDatosComprobanteRetencion().getComprobanteRetencionXML().getImpuestos() != null &&
            !getDatosComprobanteRetencion().getComprobanteRetencionXML().getImpuestos().getImpuesto().isEmpty()) {

            getLinea().escribe();
            detalleComprobanteRetencionCompleta();
            getTabla().escribe();
            getLinea().escribe();
            if (getPdfWriter().getVerticalPosition(true) < 140){
                getDocumento().newPage();
            }
        }
    }

    /** Metodo para detalle Factura completa.
     *
     */
    public void detalleComprobanteRetencionCompleta() {

        Vector vector = new Vector();
        List<String> listaValores = new ArrayList<>();

        for (Impuesto a : getDatosComprobanteRetencion().getComprobanteRetencionXML()
                                                        .getImpuestos()
                                                        .getImpuesto()) {

            listaValores = new ArrayList<>();

            listaValores.add(0, TablasSRI.Tabla4(a.getCodDocSustento()));
            listaValores.add(1, a.getNumDocSustento());
            listaValores.add(2, a.getFechaEmisionDocSustento());
            listaValores.add(3, String.valueOf(a.getBaseImponible()));
            listaValores.add(4, TablasSRI.Tabla18(a.getCodigo()));
            listaValores.add(5, TablasSRI.Tabla19(a.getCodigoRetencion()));
            listaValores.add(6, String.format("%.2f", a.getPorcentajeRetener().doubleValue()));
            listaValores.add(7, String.valueOf(a.getValorRetenido()));

            vector.add(listaValores);

            totalGuia = totalGuia + a.getValorRetenido().doubleValue();
        }

        getTabla().setListaTitulos(TXT_7_1);
        getTabla()
            .setListaFormatos(Elemento.FORMATO_STRING, Elemento.FORMATO_STRING, Elemento.FORMATO_STRING,
                              Elemento.FORMATO_STRING, Elemento.FORMATO_STRING, Elemento.FORMATO_STRING,
                              Elemento.FORMATO_STRING, Elemento.FORMATO_STRING);
        getTabla().setListaDimensiones("15", "14", "10", "10", "8", "25", "8", "10");
        getTabla()
            .setListaAlineacion(Element.ALIGN_LEFT, Element.ALIGN_LEFT, Element.ALIGN_LEFT, Element.ALIGN_RIGHT,
                                Element.ALIGN_LEFT, Element.ALIGN_LEFT, Element.ALIGN_RIGHT, Element.ALIGN_RIGHT);
        getTabla().setVectorDatos(vector);
        getTabla().setAncho(100);
    }

    /** Metodo para agregar los totales de la factura
     *
     */
    @Override
    protected synchronized void elemento8()  {
        espacios(2);
        totales();
        getForm().escribe();
    }

    /** Metodo para agregar los totales de la factura
     *
     */
    @Override
    protected synchronized void elemento13() {
        espacios(2);

        PdfPTable table = new PdfPTable(1);
        table.getDefaultCell().setBorder(0);
        table.setWidthPercentage(100f);

        totales();

        PdfPCell pdfPCell3 = getForm().escribeCelda();
        pdfPCell3.setBorder(Rectangle.BOX);
        table.addCell(pdfPCell3);

        try {
            getDocumento().add(table);
        } catch (DocumentException e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, e.toString());
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
    protected synchronized void elemento14() {
        String firmaGrafica = getDatosComprobanteRetencion().getPathFirmaGrafica();

        if (firmaGrafica != null && !firmaGrafica.isEmpty()) {
            if (getPdfWriter().getVerticalPosition(true) < 350) {
                getDocumento().newPage();
            }

            PdfPTable table = new PdfPTable(1);
            table.setWidthPercentage(100);
            getImagen().setPath(firmaGrafica);
            getImagen().setScala(50f);
            table.addCell(getImagen().escribeCelda());
            
            try{
                getDocumento().add(table);
            }catch (DocumentException e) {
                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, e.toString());
            }
        }
    }


    /** Metodo para ejecutar los totales.
     *
     */
    private void totales() {
        getForm().setListaTitulos(TXT_8_1);
        getForm().setListaValores(String.format("%.2f", totalGuia).replaceAll(",", "\\."));
        getForm().setListaFormatos(Elemento.FORMATO_STRING);
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

        if (getDatosComprobanteRetencion().getComprobanteRetencionXML().getInfoAdicional() != null &&
            !getDatosComprobanteRetencion().getComprobanteRetencionXML().getInfoAdicional().getCampoAdicional().isEmpty()) {
            for (ComprobanteRetencion.InfoAdicional.CampoAdicional a :
                 getDatosComprobanteRetencion().getComprobanteRetencionXML().getInfoAdicional().getCampoAdicional()) {

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
                getForm().setListaPaneles(String.valueOf(size));
                getForm().escribe();
            }
        }
    }


    public DatosComprobanteRetencion getDatosComprobanteRetencion() {
        return datosComprobanteRetencion;
    }

    public void setDatosComprobanteRetencion(DatosComprobanteRetencion datosComprobanteRetencion) {
        this.datosComprobanteRetencion = datosComprobanteRetencion;
    }
}
