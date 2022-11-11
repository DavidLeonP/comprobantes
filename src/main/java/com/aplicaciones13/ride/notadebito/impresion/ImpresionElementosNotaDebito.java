package com.aplicaciones13.ride.notadebito.impresion;

import com.aplicaciones13.sri.contenedores.TablasSRI;
import com.aplicaciones13.sri.contenedores.TotalDocumento;
import com.aplicaciones13.Constantes;
import com.aplicaciones13.impresion.Elemento;
import com.aplicaciones13.impresion.ImpresionBaseElementos;
import com.aplicaciones13.ride.notadebito.Impuesto;
import com.aplicaciones13.ride.notadebito.NotaDebito;
import com.aplicaciones13.ride.notadebito.ObligadoContabilidad;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ImpresionElementosNotaDebito extends ImpresionBaseElementos {

    private static final String TXT_3_1 = "Nota D\u00e9bito";
    private static final String TXT_3_2 = "No. %s-%s-%s";
    private static final String[] TXT_3_3 = { Constantes.NUMERO_AUTORIZACION, Constantes.FECHA_AUTORIZACION, Constantes.AMBIENTE,
    Constantes.EMISION };
    private static final String TXT_4_1 = "Clave de Acceso";
    private static final String[] TXT_5_1 = { "RUC", Constantes.DIRECCION_MATRIZ, Constantes.DIRECCION_ESTABLECIMIENTO,
            Constantes.CONTRIBUYENTE_ESPECIAL_NO, "Obligado a llevar contabilidad" };
    private static final String[] TXT_5_2 = { "RUC", Constantes.DIRECCION_MATRIZ, Constantes.DIRECCION_ESTABLECIMIENTO,
            Constantes.CONTRIBUYENTE_ESPECIAL_NO, "" };
    private static final String[] TXT_6_10 = { "Raz\u00f3n Social", "RUC / CI.", "Fecha Emisi\u00f3n" };

    private static final String[] TXT_6_11_1 = { "Comprobante (Modifica)", "N\u00famero", "Fecha", "RISE" };

    private static final String[] TXT_6_11_2 = { "Comprobante (Modifica)", "N\u00famero", "Fecha" };

    private static final String[] TXT_7_1 = { "Raz\u00f3n de la Modificaci\u00f3n", "Valor" };

    private static final String[] TOTALES = { "SUBTOTAL 12%", "SUBTOTAL 0%", "SUBTOTAL No Objeto de IVA", "SUBTOTAL",
            "TOTAL Excento IVA", "ICE", "IVA 12%", "VALOR TOTAL" };

    private static final String TXT_10_1 = "Informaci\u00f3n Adicional";

    private static final String[] TXT_11_3 = { Constantes.DIRECCION_MATRIZ, Constantes.DIRECCION_ESTABLECIMIENTO };
    private static final String[] TXT_11_4 = { Constantes.CONTRIBUYENTE_ESPECIAL_NO, "Obligado a llevar contabilidad" };
    private static final String TXT_11_5 = "RUC: ";
    private static final String TXT_11_6 = "Nota D\u00e9bito";
    private static final String TXT_11_7 = "No.: %s-%s-%s";
    private static final String TXT_11_8 = "N\u00famero Autorizaci\u00f3n";
    private static final String TXT_11_9 = "Fecha Autorizaci\u00f3n";
    private static final String TXT_11_10 = Constantes.AMBIENTE;
    private static final String TXT_11_11 = "Emisi\u00f3n";
    private static final String TXT_11_12 = "Clave de Acceso";
    private static final String TXT_11_13 = "Normal";

    private static final String TXT_14_1 = "Formas de Pago";

    private DatosNotaDebito datosNotaDebito;
    private List<TotalDocumento> totalesCalculados;
    TablasSRI tablasSRI = new TablasSRI();

    /**
     * Metodo para generar el logo del documento.
     *
     * Si el archivo no existe
     * Agrega un logo temporal
     * Imprime el logo.
     *
     */
    @Override
    protected synchronized void elemento2() {
        getImagen().setPath(getDatosNotaDebito().getPathLogo());
        getImagen().setScala(50f);
        getImagen().setX(400);
        getImagen().setY(690);
        getImagen().escribe();
    }

    /**
     * Metodo para generar el panel superior en un formato semejante al SRI.
     *
     */
    @Override
    protected synchronized void elemento10() {
        PdfPTable table = new PdfPTable(2);

        table.setWidthPercentage(100);

        // Lado Izquierdo
        PdfPTable tableIzquierda = new PdfPTable(1);

        // Logotipo lado Izquierdo        
        getImagen().setPath(getDatosNotaDebito().getPathLogo());
        getImagen().setScala(50f);
        tableIzquierda.addCell(getImagen().escribeCelda());

        // Nombre de la empresa
        getH1().setTexto(getDatosNotaDebito().getNotaDebitoXML().getInfoTributaria().getRazonSocial());
        tableIzquierda.addCell(getH1().escribeCelda());

        // Informacion de la empresa
        getForm().setListaTitulos(TXT_11_3);
        getForm().setListaValores(getDatosNotaDebito().getNotaDebitoXML().getInfoTributaria().getDirMatriz(),
                getDatosNotaDebito().getNotaDebitoXML().getInfoNotaDebito().getDirEstablecimiento());
        getForm().setListaFormatos(Elemento.FORMATO_STRING,
                Elemento.FORMATO_STRING);
        getForm().setListaDimensiones("30", "70");
        getForm().setListaPaneles("2");
        tableIzquierda.addCell(getForm().escribeCelda());

        // Informacion de contabilidad
        getForm().setListaTitulos(TXT_11_4);
        getForm().setListaValores(
                getDatosNotaDebito().getNotaDebitoXML().getInfoNotaDebito().getContribuyenteEspecial(),
                getDatosNotaDebito().getNotaDebitoXML().getInfoNotaDebito().getObligadoContabilidad());
        getForm().setListaFormatos(Elemento.FORMATO_STRING,
                Elemento.FORMATO_STRING);
        getForm().setListaDimensiones("50", "50");
        getForm().setListaPaneles("2");
        tableIzquierda.addCell(getForm().escribeCelda());

        // Lado Derecho
        PdfPTable tableDerecha = new PdfPTable(1);

        // Ruc
        getH2().setTexto(TXT_11_5 +
                getDatosNotaDebito().getNotaDebitoXML().getInfoTributaria().getRuc());
        tableDerecha.addCell(getH2().escribeCelda());

        // Nombre del documento
        getH1().setTexto(TXT_11_6);
        tableDerecha.addCell(getH1().escribeCelda());

        // Numero del documento
        getH1().setTexto(String.format(TXT_11_7,
                getDatosNotaDebito().getNotaDebitoXML().getInfoTributaria().getEstab(),
                getDatosNotaDebito().getNotaDebitoXML().getInfoTributaria().getPtoEmi(),
                getDatosNotaDebito().getNotaDebitoXML().getInfoTributaria().getSecuencial()));
        tableDerecha.addCell(getH1().escribeCelda());
        // Numero de autorizacion
        getH2().setTexto(TXT_11_8);
        tableDerecha.addCell(getH2().escribeCelda());
        if (getDatosNotaDebito().isOffline())
            getP().setTexto(getDatosNotaDebito().getClaveAccesoAutorizacion());
        else
            getP().setTexto(getDatosNotaDebito().getNumeroAutorizacion());

        tableDerecha.addCell(getP().escribeCelda());

        // Fecha Autorizacion - modo offline
        if (!getDatosNotaDebito().isOffline()) {
            getForm().setListaTitulos(TXT_11_9);
            getForm().setListaValores(getDatosNotaDebito().getFechaAutorizacion());
            getForm().setListaFormatos(Elemento.FORMATO_STRING);
            getForm().setListaDimensiones("40", "60");
            getForm().setListaPaneles("1");
            tableDerecha.addCell(getForm().escribeCelda());
        }

        // Ambiente
        getForm().setListaTitulos(TXT_11_10);
        getForm().setListaValores(getDatosNotaDebito().getAmbienteAutorizacion());
        getForm().setListaFormatos(Elemento.FORMATO_STRING);
        getForm().setListaDimensiones("40", "60");
        getForm().setListaPaneles("1");
        tableDerecha.addCell(getForm().escribeCelda());

        // Emision
        if (getDatosNotaDebito().isOffline())
            getDatosNotaDebito().setEmisionAutorizacion(TXT_11_13);
        getForm().setListaTitulos(TXT_11_11);
        getForm().setListaValores(getDatosNotaDebito().getEmisionAutorizacion());
        getForm().setListaFormatos(Elemento.FORMATO_STRING);
        getForm().setListaDimensiones("40", "60");
        getForm().setListaPaneles("1");
        tableDerecha.addCell(getForm().escribeCelda());

        // Clave de acceso
        getH2().setTexto(TXT_11_12);
        tableDerecha.addCell(getH2().escribeCelda());

        // Codigo de barras
        getImagen().procesarCode128(getDatosNotaDebito().getClaveAccesoAutorizacion());
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

    /**
     * Metodo para escribir la informacion del cliente.
     *
     */
    @Override
    protected synchronized void elemento11(){
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

    /**
     * Metodo para escribir la informacion del cliente.
     *
     */
    @Override
    protected synchronized void elemento12() {
        espacios(2);

        if (getDatosNotaDebito().getNotaDebitoXML().getMotivos() != null &&
                !getDatosNotaDebito().getNotaDebitoXML().getMotivos().getMotivo().isEmpty()) {

            detalleNotaDebitoCompleta();

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

    /**
     * Metodo para agregar la informaci\u00f3n del documento
     *
     */
    @Override
    protected synchronized void elemento3() {
        getH1().setTexto(TXT_3_1);
        getH1().escribe();

        getH1().setTexto(String.format(TXT_3_2,
                getDatosNotaDebito().getNotaDebitoXML().getInfoTributaria().getEstab(),
                getDatosNotaDebito().getNotaDebitoXML().getInfoTributaria().getPtoEmi(),
                getDatosNotaDebito().getNotaDebitoXML().getInfoTributaria().getSecuencial()));
        getH1().escribe();

        espacios(1);
        getForm().setListaTitulos(TXT_3_3);

        getForm().setListaValores(getDatosNotaDebito().getNumeroAutorizacion(),
                getDatosNotaDebito().getFechaAutorizacion(),
                getDatosNotaDebito().getAmbienteAutorizacion(),
                getDatosNotaDebito().getEmisionAutorizacion());
        getForm().setListaFormatos(Elemento.FORMATO_STRING,
                Elemento.FORMATO_STRING,
                Elemento.FORMATO_STRING,
                Elemento.FORMATO_STRING);
        getForm().setListaDimensiones("25", "75");
        getForm().setListaPaneles("4");
        getForm().escribe();
    }

    /**
     * Metodo para escribir el codigo de barras de la clave de acceso.
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

        getImagen().procesarCode128(getDatosNotaDebito().getClaveAccesoAutorizacion());
        getImagen().setX(165);
        getImagen().setY(680);
        getImagen().escribe();       
    }

    /**
     * Metodo para escribir la informacion de la empresa
     *
     * @throws Exception
     */
    @Override
    protected synchronized void elemento5() {
        espacios(5);
        getLinea().escribe();
        getH2().setTexto(getDatosNotaDebito().getNotaDebitoXML().getInfoTributaria().getRazonSocial());
        getH2().escribe();

        espacios(1);

        ObligadoContabilidad contabilidad = getDatosNotaDebito().getNotaDebitoXML().getInfoNotaDebito()
                .getObligadoContabilidad();

        String obligado = contabilidad.value();

        if (obligado.equalsIgnoreCase("SI"))
            getForm().setListaTitulos(TXT_5_1);
        else
            getForm().setListaTitulos(TXT_5_2);
        getForm().setListaValores(getDatosNotaDebito().getNotaDebitoXML().getInfoTributaria().getRuc(),
                getDatosNotaDebito().getNotaDebitoXML().getInfoTributaria().getDirMatriz(),
                getDatosNotaDebito().getNotaDebitoXML().getInfoNotaDebito().getDirEstablecimiento(),
                getDatosNotaDebito().getNotaDebitoXML().getInfoNotaDebito().getContribuyenteEspecial(),
                getDatosNotaDebito().getNotaDebitoXML().getInfoNotaDebito().getObligadoContabilidad());
        getForm().setListaFormatos(Elemento.FORMATO_STRING,
                Elemento.FORMATO_STRING,
                Elemento.FORMATO_STRING,
                Elemento.FORMATO_STRING,
                Elemento.FORMATO_STRING);
        getForm().setListaDimensiones("25", "75");
        getForm().setListaPaneles("5");
        getForm().escribe();
    }

    /**
     * Metodo para escribir la informacion del cliente.
     *
     */
    @Override
    protected synchronized void elemento6() {
        espacios(2);
        getLinea().escribe();

        informacionCliente1();
        getForm().escribe();
        espacios(1);
        informacionCliente2();
        getForm().escribe();
    }

    /**
     * Metodo para crear la informacion del cliente
     *
     */
    private void informacionCliente1() {

        getForm().setListaTitulos(TXT_6_10);
        getForm().setListaValores(getDatosNotaDebito().getNotaDebitoXML().getInfoNotaDebito().getRazonSocialComprador(),
                getDatosNotaDebito().getNotaDebitoXML().getInfoNotaDebito().getIdentificacionComprador(),
                getDatosNotaDebito().getNotaDebitoXML().getInfoNotaDebito().getFechaEmision());
        getForm().setListaFormatos(Elemento.FORMATO_STRING,
                Elemento.FORMATO_STRING,
                Elemento.FORMATO_STRING);
        getForm().setListaDimensiones("25", "75");
        getForm().setListaPaneles("3");
    }

    /**
     * Metodo para crear la informacion del cliente
     *
     */
    private void informacionCliente2() {
        String rise = getDatosNotaDebito().getNotaDebitoXML().getInfoNotaDebito().getRise();        
        if (rise != null && rise.trim().length() > 0) {
            getForm().setListaTitulos(TXT_6_11_1);
            getForm().setListaValores(
                    tablasSRI.tabla4(getDatosNotaDebito().getNotaDebitoXML().getInfoNotaDebito().getCodDocModificado()),
                    getDatosNotaDebito().getNotaDebitoXML().getInfoNotaDebito().getNumDocModificado(),
                    getDatosNotaDebito().getNotaDebitoXML().getInfoNotaDebito().getFechaEmisionDocSustento(),
                    rise);
            getForm().setListaFormatos(Elemento.FORMATO_STRING,
                    Elemento.FORMATO_STRING,
                    Elemento.FORMATO_STRING,
                    Elemento.FORMATO_STRING);
            getForm().setListaDimensiones("25", "75");
            getForm().setListaPaneles("4");
        } else {
            getForm().setListaTitulos(TXT_6_11_2);
            getForm().setListaValores(
                    tablasSRI.tabla4(getDatosNotaDebito().getNotaDebitoXML().getInfoNotaDebito().getCodDocModificado()),
                    getDatosNotaDebito().getNotaDebitoXML().getInfoNotaDebito().getNumDocModificado(),
                    getDatosNotaDebito().getNotaDebitoXML().getInfoNotaDebito().getFechaEmisionDocSustento());
            getForm().setListaFormatos(Elemento.FORMATO_STRING,
                    Elemento.FORMATO_STRING,
                    Elemento.FORMATO_STRING);
            getForm().setListaDimensiones("25", "75");
            getForm().setListaPaneles("3");
        }
    }

    /**
     * Metodo para imprimir el detalle de la notaDebito
     *
     * Si los datos en la notaDebito existen
     * Llena el Lista de datos a ser recorridos
     * Si existe codigo auxiliar
     * Agrega los datos para la ubicacion en pantalla
     * Caso contrario
     * Agrega los datos para la ubicacion en pantalla sin el codigo auxiliar
     *
     */
    @Override
    protected synchronized void elemento7(){
        espacios(2);

        if (getDatosNotaDebito().getNotaDebitoXML().getMotivos() != null &&
                !getDatosNotaDebito().getNotaDebitoXML().getMotivos().getMotivo().isEmpty()) {

            getLinea().escribe();

            detalleNotaDebitoCompleta();

            getTabla().escribe();

            getLinea().escribe();
            if (getPdfWriter().getVerticalPosition(true) < 140)
                getDocumento().newPage();
        }

    }

    /**
     * Metodo para detalle NotaDebito completa.
     *
     */
    public void detalleNotaDebitoCompleta() {

        List<Object> listaDatos = new ArrayList<>();
        

        for (NotaDebito.Motivos.Motivo a : getDatosNotaDebito().getNotaDebitoXML().getMotivos().getMotivo()) {
            List<String> listaValores  = new ArrayList<>();
            listaValores.add(0, a.getRazon());
            listaValores.add(1, a.getValor().toString());
            listaDatos.add(listaValores);

        }
        getTabla().setListaTitulos(TXT_7_1);
        getTabla().setListaFormatos(Elemento.FORMATO_STRING,
                Elemento.FORMATO_STRING);
        getTabla().setListaDimensiones("80", "20");
        getTabla().setListaAlineacion(Element.ALIGN_LEFT, Element.ALIGN_RIGHT);
        getTabla().setListaDatos(listaDatos);
        getTabla().setAncho(100);

    }

    /**
     * Metodo para agregar los totales de la notaDebito
     *
     */
    @Override
    protected synchronized void elemento8() {
        espacios(2);

        subTotales();
        getForm().escribe();

        getLinea().setWidthPercentage(34);
        getLinea().escribe();

        totales();
        getForm().escribe();
    }

    /**
     * Metodo para agregar los totales de la notaDebito
     *
     */
    @Override
    protected synchronized void elemento13(){
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
     * Metodo para agregar Formas de pago exportaciones.
     *
     */
    @Override
    protected synchronized void elemento14() {
        int size = 0;
        
        List<NotaDebito.InfoNotaDebito.Pagos> pagos = getDatosNotaDebito().getNotaDebitoXML().getInfoNotaDebito()
                .getPagos();

        if (pagos != null && !pagos.isEmpty()) {
            for (NotaDebito.InfoNotaDebito.Pagos a : pagos) {

                String tiempoPago = "";

                tiempoPago = tiempoPago
                        + ((a.getPago().get(0).getPlazo() == null) ? "" : " a " + a.getPago().get(0).getPlazo());
                tiempoPago = tiempoPago
                        + ((a.getPago().get(0).getUnidadTiempo() == null) ? "" : a.getPago().get(0).getUnidadTiempo());

                getForm().getListaTitulos().add((size + 1) + ".- Forma pago");
                getForm().getListaValores().add(tablasSRI.tabla24(a.getPago().get(0).getFormaPago()) +
                        tiempoPago +
                        " por un valor de " +
                        a.getPago().get(0).getTotal());
                getForm().getListaFormatos().add(Elemento.FORMATO_STRING);
                size++;
            }

            if (size > 0) {
                int total = 74 + (12 * size);
                if (getPdfWriter().getVerticalPosition(true) < total)
                    getDocumento().newPage();

                espacios(2);
                getLinea().setWidthPercentage(100);
                getLinea().escribe();
                getH2().setTexto(TXT_14_1);
                getH2().escribe();
                espacios(2);

                getForm().setListaDimensiones("15", "85");
                getForm().setListaPaneles(String.valueOf(size));
                getForm().escribe();
            }
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
    protected synchronized void elemento15() {
        String firmaGrafica = getDatosNotaDebito().getPathFirmaGrafica();

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
     * Metodo para ejecutar los totales.
     *
     */
    private void subTotales() {
        this.totalesCalculados = new ArrayList<>();
        inicializaTotales();

        cargarTotales(getDatosNotaDebito().getNotaDebitoXML());

        int i = 0;
        int j = 0;
        while (i < getTotales().size() - 1) {
            TotalDocumento a = getTotales().get(i);

            getForm().getListaTitulos().add(a.getTitulo());
            getForm().getListaValores().add((a.getValor() == null) ? "" : a.getValor().toString());
            getForm().getListaFormatos().add(Elemento.FORMATO_MONEDA);
            getForm().getListaCamposAlineadosDerecha().add(String.valueOf(j++));

            i++;
        }
        getForm().setListaDimensiones("70", "30");
        getForm().setListaPaneles("-1", "-1", String.valueOf(i));
    }

    /**
     * Metodo para ejecutar los totales.
     *
     */
    private void totales() {
        getForm().getListaTitulos().add(getTotales().get(getTotales().size() -
                1).getTitulo());

        getForm().getListaValores().add((getTotales().get(getTotales().size() -
                1).getValor() == null) ? ""
                        : getTotales().get(getTotales().size() -
                                1).getValor().toString());
        getForm().getListaFormatos().add(Elemento.FORMATO_MONEDA);
        getForm().getListaCamposAlineadosDerecha().add("0");
        getForm().setListaDimensiones("70", "30");
        getForm().setListaPaneles("-1", "-1", "1");
    }

    /**
     * Metodo para agregar informaci\u00f3n adicional.
     *
     */
    @Override
    protected synchronized void elemento9() {
        int size = 0;

        if (getDatosNotaDebito().getNotaDebitoXML().getInfoAdicional() != null &&
            !getDatosNotaDebito().getNotaDebitoXML().getInfoAdicional().getCampoAdicional().isEmpty()) {

            for (NotaDebito.InfoAdicional.CampoAdicional a : getDatosNotaDebito().getNotaDebitoXML().getInfoAdicional()
                    .getCampoAdicional()) {

                if (!a.getNombre().startsWith("js")) {
                    getForm().getListaTitulos().add(a.getNombre());
                    getForm().getListaValores().add((a.getValue() == null) ? "" : String.valueOf(a.getValue()) );
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

    /**
     * Metodo para inicializar los totales.
     *
     */
    public void inicializaTotales() {
        TotalDocumento totalNotaDebito = new TotalDocumento();

        totalNotaDebito.setTitulo(TOTALES[0]);
        getTotales().add(0, totalNotaDebito);

        totalNotaDebito = new TotalDocumento();
        totalNotaDebito.setTitulo(TOTALES[1]);
        getTotales().add(1, totalNotaDebito);

        totalNotaDebito = new TotalDocumento();
        totalNotaDebito.setTitulo(TOTALES[2]);
        getTotales().add(2, totalNotaDebito);

        totalNotaDebito = new TotalDocumento();
        totalNotaDebito.setTitulo(TOTALES[3]);
        getTotales().add(3, totalNotaDebito);

        totalNotaDebito = new TotalDocumento();
        totalNotaDebito.setTitulo(TOTALES[4]);
        getTotales().add(4, totalNotaDebito);

        totalNotaDebito = new TotalDocumento();
        totalNotaDebito.setTitulo(TOTALES[5]);
        getTotales().add(5, totalNotaDebito);

        totalNotaDebito = new TotalDocumento();
        totalNotaDebito.setTitulo(TOTALES[6]);
        getTotales().add(6, totalNotaDebito);

        totalNotaDebito = new TotalDocumento();
        totalNotaDebito.setTitulo(TOTALES[7]);
        getTotales().add(7, totalNotaDebito);

    }

    /**
     * Metodo para cargar los totales que el sistema tiene.
     *
     * @param bus
     */
    public void cargarTotales(com.aplicaciones13.ride.notadebito.NotaDebito bus) {
        if (bus.getInfoNotaDebito().getImpuestos() != null &&
                !bus.getInfoNotaDebito().getImpuestos().getImpuesto().isEmpty()) {

            for (Impuesto a : bus.getInfoNotaDebito().getImpuestos().getImpuesto()) {

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
                        getTotales().get(4).setValor(a.getBaseImponible());
                    }
                }

                if (a.getCodigo().compareTo("3") == 0) {
                    getTotales().get(5).setValor(a.getValor());
                }
            }
        }

        getTotales().get(3).setValor(bus.getInfoNotaDebito().getTotalSinImpuestos());
        getTotales().get(7).setValor(bus.getInfoNotaDebito().getValorTotal());
    }

    public DatosNotaDebito getDatosNotaDebito() {
        return datosNotaDebito;
    }

    public void setDatosNotaDebito(DatosNotaDebito datosNotaDebito) {
        this.datosNotaDebito = datosNotaDebito;
    }

    public List<TotalDocumento> getTotales() {
        return this.totalesCalculados;
    }

    public void setTotales(List<TotalDocumento> totales) {
        this.totalesCalculados = totales;
    }
}
