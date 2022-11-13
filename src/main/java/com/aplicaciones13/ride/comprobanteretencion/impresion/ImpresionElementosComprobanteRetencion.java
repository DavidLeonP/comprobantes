package com.aplicaciones13.ride.comprobanteretencion.impresion;

import com.aplicaciones13.sri.contenedores.TablasSRI;
import com.aplicaciones13.sri.contenedores.TotalDocumento;
import com.aplicaciones13.impresion.Elemento;
import com.aplicaciones13.impresion.ImpresionBaseElementos;
import com.aplicaciones13.ride.comprobanteretencion.ComprobanteRetencion;
import com.aplicaciones13.ride.comprobanteretencion.Impuesto;
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
 * Objeto para crear un documento de comprobante de Retencion.
 *
 * @author omarv omargo33@JeremiasSoft.com
 *
 */
public class ImpresionElementosComprobanteRetencion extends ImpresionBaseElementos {

    private static final String TXT_3_1 = "Comprobante de Retenci\u00f3n";
    
    private static final String[] TXT_6_1 = { "Raz\u00f3n Social", "RUC / CI.", "Ejercicio Fiscal",
            "Fecha Emisi\u00f3n" };
    private static final String[] TXT_7_1 = {
            "Comprobante", "N\u00famero", "Fecha Emisi\u00f3n", "Base Imponible", "Impuesto", "Descripcion",
            "% Retenido",
            "Valor Retenido"
    };

    private static final String TXT_8_1 = "VALOR TOTAL";
    private double totalGuia = 0;

    private static final String TXT_10_1 = "Informaci\u00f3n Adicional";
    
    private DatosComprobanteRetencion datosComprobanteRetencion;
    List<TotalDocumento> totales;

    
    /**
     * Metodo para generar el panel superior en un formato semejante al SRI.
     *
     */
    @Override
    protected synchronized void elemento10() {
        this.getElementosComunes().encabezado(
            getDatosComprobanteRetencion().getPathLogo(),
            getDatosComprobanteRetencion().getComprobanteRetencionXML().getInfoTributaria().getRazonSocial(),
            getDatosComprobanteRetencion().getComprobanteRetencionXML().getInfoTributaria().getDirMatriz(),
            getDatosComprobanteRetencion().getComprobanteRetencionXML().getInfoCompRetencion().getDirEstablecimiento(),
            getDatosComprobanteRetencion().getComprobanteRetencionXML().getInfoCompRetencion().getContribuyenteEspecial(),
            getDatosComprobanteRetencion().getComprobanteRetencionXML().getInfoCompRetencion().getObligadoContabilidad(),
            getDatosComprobanteRetencion().getComprobanteRetencionXML().getInfoTributaria().getRuc(),
            TXT_3_1,
            getDatosComprobanteRetencion().getComprobanteRetencionXML().getInfoTributaria().getEstab()
                    + "-" +
                    getDatosComprobanteRetencion().getComprobanteRetencionXML().getInfoTributaria().getPtoEmi()
                    + "-" +
                    getDatosComprobanteRetencion().getComprobanteRetencionXML().getInfoTributaria().getSecuencial(),
            getDatosComprobanteRetencion().getClaveAccesoAutorizacion(),
            getDatosComprobanteRetencion().getNumeroAutorizacion(),
            getDatosComprobanteRetencion().getFechaAutorizacion(),
            getDatosComprobanteRetencion().getAmbienteAutorizacion(),
            getDatosComprobanteRetencion().getEmisionAutorizacion(),
            getDatosComprobanteRetencion().isOffline());

        
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

        if (getDatosComprobanteRetencion().getComprobanteRetencionXML().getImpuestos() != null &&
                !getDatosComprobanteRetencion().getComprobanteRetencionXML().getImpuestos().getImpuesto().isEmpty()) {
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
    
    /**
     * Metodo para crear la informacion del cliente
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
    
    /**
     * Metodo para detalle Factura completa.
     *
     */
    private void detalleComprobanteRetencionCompleta() {
        List<Object> listaDatos = new ArrayList<>();
        TablasSRI tablasSRI = new TablasSRI();

        for (Impuesto a : getDatosComprobanteRetencion().getComprobanteRetencionXML()
                .getImpuestos()
                .getImpuesto()) {

            List<String> listaValores = new ArrayList<>();
            
            listaValores.add(0, tablasSRI.tabla4(a.getCodDocSustento()));
            listaValores.add(1, a.getNumDocSustento());
            listaValores.add(2, a.getFechaEmisionDocSustento());
            listaValores.add(3, String.valueOf(a.getBaseImponible()));
            listaValores.add(4, tablasSRI.tabla18(a.getCodigo()));
            listaValores.add(5, tablasSRI.tabla19(a.getCodigoRetencion()));
            listaValores.add(6, String.format("%.2f", a.getPorcentajeRetener().doubleValue()));
            listaValores.add(7, String.valueOf(a.getValorRetenido()));

            listaDatos.add(listaValores);

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
    protected synchronized void elementoFirma() {
        String firmaGrafica = getDatosComprobanteRetencion().getPathFirmaGrafica();        
        getElementosComunes().firmarGraficamente(firmaGrafica);
    }

    /**
     * Metodo para ejecutar los totales.
     *
     */
    private void totales() {
        getForm().setListaTitulos(TXT_8_1);
        getForm().setListaValores(String.format("%.2f", totalGuia).replace(",", "."));
        getForm().setListaFormatos(Elemento.FORMATO_STRING);
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

        if (getDatosComprobanteRetencion().getComprobanteRetencionXML().getInfoAdicional() != null &&
                !getDatosComprobanteRetencion().getComprobanteRetencionXML().getInfoAdicional().getCampoAdicional()
                        .isEmpty()) {
            for (ComprobanteRetencion.InfoAdicional.CampoAdicional a : getDatosComprobanteRetencion()
                    .getComprobanteRetencionXML().getInfoAdicional().getCampoAdicional()) {

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

    public DatosComprobanteRetencion getDatosComprobanteRetencion() {
        return datosComprobanteRetencion;
    }

    public void setDatosComprobanteRetencion(DatosComprobanteRetencion datosComprobanteRetencion) {
        this.datosComprobanteRetencion = datosComprobanteRetencion;
    }
}
