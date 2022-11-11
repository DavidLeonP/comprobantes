package com.aplicaciones13.ride.guiaremision1.impresion;

import com.aplicaciones13.sri.contenedores.TablasSRI;
import com.aplicaciones13.sri.contenedores.TotalDocumento;
import com.aplicaciones13.Constantes;
import com.aplicaciones13.impresion.Elemento;
import com.aplicaciones13.impresion.ImpresionBaseElementos;
import com.aplicaciones13.ride.guiaremision1.Detalle;
import com.aplicaciones13.ride.guiaremision1.GuiaRemision;
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
 * Objeto para crear un documento de guiaRemision.
 *
 * @author omarv omargo33@JeremiasSoft.com
 *
 */
public class ImpresionElementosGuiaRemision extends ImpresionBaseElementos {

    private static final String TXT_3_1 = "Guia Remisión";
    private static final String TXT_3_2 = "No. %s-%s-%s";
    private static final String[] TXT_3_3 = { Constantes.NUMERO_AUTORIZACION, Constantes.FECHA_AUTORIZACION, Constantes.AMBIENTE, Constantes.EMISION };
    private static final String TXT_4_1 = "Clave de Acceso";
    private static final String[] TXT_5_1 = {
            "RUC", Constantes.DIRECCION_MATRIZ, Constantes.DIRECCION_ESTABLECIMIENTO, Constantes.CONTRIBUYENTE_ESPECIAL_NO,
            "Obligado a llevar contabilidad"
    };
    private static final String[] TXT_5_2 = {
            "RUC", Constantes.DIRECCION_MATRIZ, Constantes.DIRECCION_ESTABLECIMIENTO, Constantes.CONTRIBUYENTE_ESPECIAL_NO, ""
    };
    private static final String[] TXT_6_1 = {
            "Razón Social (Transportista)", "RUC/CI.", "Placa", "Dirección Partida", "Fecha Inicio Transorte",
            "Fecha Fin Transorte", "RISE"
    };

    private static final String[] TXT_7_10 = {
            "Documento Sustento ", "Número ", "Fecha Emision ", "Número autorizado ", "Motivo de Traslado " };

    private static final String[] TXT_7_11 = { "Razón Social (Destinatario)", "Identificación", "Direccion" };

    private static final String[] TXT_7_12 = { "Documento Aduanero Único", "Cód. Establecimiento destino ", "Ruta" };

    private static final String[] TXT_7_2 = { "Cod.", "Cod. Alt.", "Descripción", "Cantidad" };

    private static final String TXT_10_1 = "Información Adicional";

    private static final String[] TXT_11_3 = { "Dirección Matriz", "Dirección Establecimiento" };
    private static final String[] TXT_11_4 = { Constantes.CONTRIBUYENTE_ESPECIAL_NO, "Obligado a llevar contabilidad" };
    private static final String TXT_11_5 = "RUC: ";
    private static final String TXT_11_6 = "Guía Remisión";
    private static final String TXT_11_7 = "No.: %s-%s-%s";
    private static final String TXT_11_8 = "No.: Autorización";
    private static final String[] TXT_11_9 = { "Fecha Autorización ", Constantes.AMBIENTE, "Emisión" };
    private static final String TXT_11_10 = "Clave de Acceso";

    private DatosGuiaRemision datosGuiaRemision;
    List<TotalDocumento> totales;

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
        getImagen().setPath(getDatosGuiaRemision().getPathLogo());
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
        getImagen().setPath(getDatosGuiaRemision().getPathLogo());
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

        // Numero de autorizacion
        getP().setTexto(getDatosGuiaRemision().getNumeroAutorizacion());
        tableDerecha.addCell(getP().escribeCelda());

        getForm().setListaTitulos(TXT_11_9);
        getForm()
                .setListaValores(getDatosGuiaRemision().getFechaAutorizacion(),
                        getDatosGuiaRemision().getAmbienteAutorizacion(),
                        getDatosGuiaRemision().getEmisionAutorizacion());
        getForm().setListaFormatos(Elemento.FORMATO_STRING, Elemento.FORMATO_STRING, Elemento.FORMATO_STRING);
        getForm().setListaDimensiones("30", "70");
        getForm().setListaPaneles("3");
        tableDerecha.addCell(getForm().escribeCelda());

        getH2().setTexto(TXT_11_10);
        tableDerecha.addCell(getH2().escribeCelda());

        // Codigo de barras
        getImagen().procesarCode128(getDatosGuiaRemision().getClaveAccesoAutorizacion());
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
    @Override
    protected synchronized void elemento11() {
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
     *
     */
    @Override
    protected synchronized void elemento12() {
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
    @Override
    protected synchronized void elemento13() {
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
     * Metodo para agregar la información del documento
     *
     */
    @Override
    protected synchronized void elemento3() {
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
    @Override
    protected synchronized void elemento4() {

        getForm().setListaTitulos(TXT_4_1);

        getForm().setListaValores("");
        getForm().setListaFormatos(Elemento.FORMATO_STRING);
        getForm().setListaDimensiones("25", "75");
        getForm().setListaPaneles("1");
        getForm().escribe();

        getImagen().procesarCode128(getDatosGuiaRemision().getClaveAccesoAutorizacion());
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
    @Override
    protected synchronized void elemento6() {
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
                .setListaValores(TablasSRI.tabla4(getDatosGuiaRemision().getGuiaRemisionXML()
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
     * Crea la tabla de envios a de mercadería de la guia de remisión.
     *
     * @param i
     */
    private void informacionDetalleEnvio(int i) {
        List<Object> listaDatos = new ArrayList<>();

        for (Detalle a : getDatosGuiaRemision().getGuiaRemisionXML()
                .getDestinatarios()
                .getDestinatario()
                .get(i)
                .getDetalles()
                .getDetalle()) {

            List<String> listaValores = new ArrayList<>();
            listaValores.add(0, a.getCodigoInterno());
            listaValores.add(1, a.getCodigoAdicional());
            listaValores.add(2, a.getDescripcion());
            listaValores.add(3, String.valueOf(a.getCantidad()));

            listaDatos.add(listaValores);

            if (a.getDetallesAdicionales() != null && !a.getDetallesAdicionales()
                    .getDetAdicional().isEmpty()) {
                for (Detalle.DetallesAdicionales.DetAdicional b : a.getDetallesAdicionales().getDetAdicional()) {
                    List<String> listaValoresDet = new ArrayList<>();
                    listaValoresDet.add(0, "");
                    listaValoresDet.add(1, "");
                    listaValoresDet.add(2, b.getNombre() + ": " + b.getValor());
                    listaValoresDet.add(3, "");

                    listaDatos.add(listaValoresDet);
                }
            }
        }
        getTabla().setListaTitulos(TXT_7_2);
        getTabla()
                .setListaFormatos(Elemento.FORMATO_STRING, Elemento.FORMATO_STRING, Elemento.FORMATO_STRING,
                        Elemento.FORMATO_STRING);
        getTabla().setListaDimensiones("15", "15", "60", "10");
        getTabla().setListaAlineacion(Element.ALIGN_LEFT, Element.ALIGN_LEFT, Element.ALIGN_LEFT, Element.ALIGN_RIGHT);
        getTabla().setListaDatos(listaDatos);
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
    @Override
    protected synchronized void elemento7() {
        if (getDatosGuiaRemision().getGuiaRemisionXML().getDestinatarios() != null &&
                !getDatosGuiaRemision().getGuiaRemisionXML().getDestinatarios().getDestinatario().isEmpty()) {
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
     * Metodo para agregar información adicional.
     *
     */
    @Override
    protected synchronized void elemento9() {
        int size = 0;

        if (getDatosGuiaRemision().getGuiaRemisionXML().getInfoAdicional() != null &&
                !getDatosGuiaRemision().getGuiaRemisionXML().getInfoAdicional().getCampoAdicional().isEmpty()) {
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
                getForm().setListaPaneles(String.valueOf(size));
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
