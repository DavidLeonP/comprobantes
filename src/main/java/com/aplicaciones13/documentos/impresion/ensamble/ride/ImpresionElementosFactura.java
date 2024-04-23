package com.aplicaciones13.documentos.impresion.ensamble.ride;

import com.aplicaciones13.documentos.estructuras.factura.v2_1_0.Pagos.Pago;
import com.aplicaciones13.documentos.impresion.elementos.texto.Elemento;
import com.aplicaciones13.documentos.impresion.elementos.texto.P;
import com.aplicaciones13.documentos.impresion.ensamble.ImpresionElementosBase;
import com.aplicaciones13.documentos.estructuras.factura.v2_1_0.Factura;

import com.aplicaciones13.documentos.utilidades.Bundle;

import com.itextpdf.barcodes.Barcode128;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.pdf.xobject.PdfFormXObject;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

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

    private static Bundle bundle = new Bundle("elementos-ride");

    private static String[] totalesPresentacion = {
            "1", "1", "1 2", "1 2", "1", "1", "1", "1", "2", "2", "2", "2", "1 2" };

    Border border = new SolidBorder(1f);
    private Factura factura;
    List<TotalDocumentoFactura> totales;

    /**
     * Constructor para el objeto.
     *
     */
    public ImpresionElementosFactura() {
        factura = new Factura();
        totales = new ArrayList<>();
    }

    /**
     * Metodo para generar el panel superior en un formato semejante al SRI.
     *
     */
    @Override
    public synchronized void elemento2() {
        getPanel().setListaDimensiones(50f);
        getPanel().getMapaAlineamiento().put(1, TextAlignment.CENTER);
        getPanel().setListaCeldas(informacionEmpresa().toArray());
        getPanel().procesar();
        Table tableIzq = getPanel().getTabla();
        tableIzq.setBorderRight(border);

        getPanel().setListaDimensiones(50f);
        getPanel().getMapaAlineamiento().put(1, TextAlignment.LEFT);
        getPanel().setListaCeldas(informacionDocumento().toArray());
        getPanel().procesar();
        Table tableDer = getPanel().getTabla();

        getPanel().setListaDimensiones(52f, 48f);
        getPanel().setListaCeldas(tableIzq, tableDer);
        getPanel().procesar();
        getPanel().escribir();
    }

    /**
     * Metodo para escribir la informacion del cliente.
     *
     */
    @Override
    public synchronized void elemento3() {
        getEspacio().escribir(1);
        getLineaSolida().escribir();

        getForm().setListaTitulos(bundle.getMessages("fac_013", "fac_014", "fac_015", "fac_016"));
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
        getForm().setListaDimensiones(15f, 85f);
        getForm().procesar();
        getForm().escribir();
        getForm().reset();
    }

    /**
     * Metodo para detalle de la factura.
     *
     */
    @Override
    public synchronized void elemento4() {
        List<Object[]> listaValores = new ArrayList<>();
        Object[] filaValores;

        getEspacio().escribir(1);
        getLineaSolida().escribir();

        if (getFactura().getDetalles() != null &&
                getFactura().getDetalles().getDetalle().size() > 0) {
            for (Factura.Detalles.Detalle a : getFactura().getDetalles().getDetalle()) {
                filaValores = new Object[6];
                filaValores[0] = a.getCodigoPrincipal();
                filaValores[1] = a.getDescripcion();
                filaValores[2] = a.getCantidad().toString();
                filaValores[3] = a.getPrecioUnitario().toString();
                filaValores[4] = a.getDescuento().toString();
                filaValores[5] = a.getPrecioTotalSinImpuesto().toString();

                if (a.getCodigoAuxiliar() != null &&
                        a.getCodigoAuxiliar().trim().length() > 0 &&
                        String.valueOf(filaValores[0]).compareTo(a.getCodigoAuxiliar()) != 0) {
                    filaValores[1] = filaValores[1] + "\nCod.: " + a.getCodigoAuxiliar();
                }

                if (a.getDetallesAdicionales() != null &&
                        !a.getDetallesAdicionales().getDetAdicional().isEmpty()) {
                    for (Factura.Detalles.Detalle.DetallesAdicionales.DetAdicional b : a.getDetallesAdicionales()
                            .getDetAdicional()) {
                        filaValores[1] = filaValores[1] + "\n" + b.getNombre() + ": " + b.getValor();
                    }
                }

                listaValores.add(filaValores);
            }

            getTabla().setColorFondo(new DeviceRgb(223, 224, 226));
            getTabla().setListaTitulos(
                    bundle.getMessages("fac_017", "fac_018", "fac_019", "fac_020", "fac_021", "fac_022"));
            getTabla().setListaFormatos(
                    Elemento.FORMATO_STRING,
                    Elemento.FORMATO_STRING,
                    Elemento.FORMATO_STRING,
                    Elemento.FORMATO_STRING,
                    Elemento.FORMATO_STRING,
                    Elemento.FORMATO_STRING);
            getTabla().setListaDimensiones(15f, 40f, 10f, 10f, 10f, 14f);

            getTabla().getMapaAlineamiento().put(1, TextAlignment.LEFT);
            getTabla().getMapaAlineamiento().put(2, TextAlignment.LEFT);
            getTabla().getMapaAlineamiento().put(3, TextAlignment.RIGHT);
            getTabla().getMapaAlineamiento().put(4, TextAlignment.RIGHT);
            getTabla().getMapaAlineamiento().put(5, TextAlignment.RIGHT);
            getTabla().getMapaAlineamiento().put(6, TextAlignment.RIGHT);

            getTabla().setListaValores(listaValores);
            getTabla().setBandasPresentacion(true);
            getTabla().procesar();
            getTabla().escribir();
        }

        if (getCurrentPosition().getY() < 140) {
            getDocumento().add(new AreaBreak());
        }
    }

    /**
     * Metodo para agregar los totales de la factura
     *
     */
    @Override
    public synchronized void elemento5() {
        Cell cell = new Cell();
        getLineaSolida().escribir();

        inicializaTotales();

        cargarTotales();

        subTotales();
        getPanel().setListaDimensiones(64f, 36f);

        getForm().procesar();
        getPanel().setListaCeldas(cell, getForm().getTabla());
        getForm().reset();

        getPanel().procesar();
        getPanel().escribir();

        totales();
        getPanel().setListaDimensiones(64f, 36f);

        getForm().procesar();
        getForm().getTabla().setBorderTop(border);
        getPanel().setListaCeldas(cell, getForm().getTabla());
        getForm().reset();

        getPanel().procesar();
        getPanel().escribir();
    }

    /**
     * Metodo para agregar informacion de la exportacion SRI.
     *
     */
    @Override
    public synchronized void elemento6() {
        if (isExportacion()) {
            getLineaSolida().escribir();

            getH2().setTexto(bundle.getMessage("fac_037"));
            getH2().escribir();

            getForm().setListaTitulos(
                    bundle.getMessages("fac_038", "fac_039", "fac_040", "fac_041", "fac_042", "fac_043", "fac_044"));
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
            getForm().procesar();
            getForm().escribir();
            getForm().reset();
        }
    }

    /**
     * Metodo para agregar informacion adicional.
     *
     */
    @Override
    public synchronized void elemento7() {
        if (isExportacion())
            return;

        if (isInformacionAdicional()) {
            getEspacio().escribir(1);
            getLineaSolida().escribir();

            int size = 0;

            getH2().setTexto(bundle.getMessage("fac_036"));
            getH2().escribir();

            for (Factura.InfoAdicional.CampoAdicional a : getFactura()
                    .getInfoAdicional()
                    .getCampoAdicional()) {
                getForm().getListaTitulos().add(a.getNombre());
                getForm().getListaValores().add((a.getValue() == null) ? "" : String.valueOf(a.getValue()));
                getForm().getListaFormatos().add(Elemento.FORMATO_STRING);
                size++;
            }

            if (size > 0) {
                int total = 74 + (12 * size);
                if (getCurrentPosition().getY() < total) {
                    getDocumento().add(new AreaBreak());
                }
                getForm().setListaDimensiones(30f, 70f);
                getForm().procesar();
                getForm().escribir();
                getForm().reset();
            }
        }
    }

    /**
     * Metodo para agregar Formas de pago
     *
     */
    @Override
    public synchronized void elemento8() {
        int size = 0;

        if (getFactura()
                .getInfoFactura()
                .getPagos() != null
                && getFactura().getInfoFactura()
                        .getPagos()
                        .getPago()
                        .size() > 0) {
            getEspacio().escribir(1);
            getLineaSolida().escribir();

            for (Pago a : getFactura().getInfoFactura()
                    .getPagos()
                    .getPago()) {
                getForm().getListaTitulos().add(bundle.getMessage("fac_058", (size + 1)));
                getForm().getListaValores().add(
                        bundle.getMessage("fac_059",
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

                getH2().setTexto(bundle.getMessage("fac_045"));
                getH2().escribir();

                getForm().setListaDimensiones(15f, 85f);
                getForm().procesar();
                getForm().escribir();
                getForm().reset();
            }
        }
    }

    /**
     * Metodo para generar el panel superior con la informacion de la empresa.
     * 
     * @return
     */
    private List<Object> informacionEmpresa() {
        List<Object> listaLadoIzquerdo = new ArrayList<>();

        // Lado Izquierdo
        int anchoImagen = (int) (getCurrentPosition().getAncho() * 0.2);
        int margenes = (int) (getCurrentPosition().getAncho() / 2 - anchoImagen) / 2;

        getImagen().setPathImagen(getParametrosBusqueda().get("pathImagen"));
        getImagen().setMaximoAncho(anchoImagen);
        getImagen().procesar();

        // Celda para imagen en el centro en el eje horizontal
        Cell cellimg = new Cell();
        cellimg.setPaddingLeft(margenes);
        cellimg.add(getImagen().getImagen());

        // Agregar imagen a la lista
        listaLadoIzquerdo.add(cellimg);

        // Nombre de la empresa
        getH1().setParagraph(getFactura()
                .getInfoTributaria()
                .getRazonSocial());

        // Agregar nombre de la empresa a la lista
        listaLadoIzquerdo.add(getH1().getParagraph());

        // Informacion de la empresa
        getForm().setListaTitulos(bundle.getMessages("fac_001", "fac_002"));
        getForm().setListaValores(getFactura()
                .getInfoTributaria()
                .getDirMatriz(),
                getFactura()
                        .getInfoFactura()
                        .getDirEstablecimiento());
        getForm().setListaFormatos(Elemento.FORMATO_STRING, Elemento.FORMATO_STRING);
        getForm().setListaDimensiones(18.0f, 82.0f);
        getForm().procesar();
        listaLadoIzquerdo.add(getForm().getTabla());
        getForm().reset();

        // Informacion de contabilidad
        getForm().setListaTitulos(bundle.getMessages("fac_003", "fac_004"));
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
        listaLadoIzquerdo.add(getForm().getTabla());
        getForm().reset();

        return listaLadoIzquerdo;
    }

    /**
     * Metodo para generar el panel superior en un formato semejante al SRI.
     *
     */
    private List<Object> informacionDocumento() {
        String tipoDocumento = getParametrosBusqueda().get("claveAccesoAutorizacion").substring(8, 10);
        List<Object> listaLado = new ArrayList<>();

        // Ruc
        getH2().setParagraph(bundle.getMessage("fac_005", getFactura().getInfoTributaria().getRuc()));
        listaLado.add(getH2().getParagraph());

        // Nombre del documento
        getH1().setParagraph(bundle.getMessage("tabla3_" + tipoDocumento));
        listaLado.add(getH1().getParagraph());

        // Numero del documento
        getH1().setParagraph(
                bundle.getMessage("fac_007",
                        getFactura()
                                .getInfoTributaria()
                                .getEstab(),
                        getFactura()
                                .getInfoTributaria()
                                .getPtoEmi(),
                        getFactura().getInfoTributaria()
                                .getSecuencial()));
        listaLado.add(getH1().getParagraph());

        // Numero de autorizacion
        getH2().setParagraph(bundle.getMessage("fac_008"));
        listaLado.add(getH2().getParagraph());

        getTexto().setParagraph(getParametrosBusqueda().get("numeroAutorizacion"));
        getTexto().getParagraph().setFontSize(P.TEXTO);
        listaLado.add(getTexto().getParagraph());

        // Ambiente
        getForm().setListaTitulos(bundle.getMessages("fac_010", "fac_011"));
        getForm().setListaValores(
                bundle.getMessage("tabla4_" + getParametrosBusqueda().get("ambienteAutorizacion")),
                bundle.getMessage("tabla2_" + getParametrosBusqueda().get("emisionAutorizacion")));
        getForm().setListaFormatos(Elemento.FORMATO_STRING, Elemento.FORMATO_STRING);
        getForm().setListaDimensiones(25f, 75f);
        getForm().procesar();
        listaLado.add(getForm().getTabla());
        getForm().reset();

        // Clave de acceso
        getP().setParagraph(bundle.getMessage("fac_012"));
        listaLado.add(getP().getParagraph());

        Barcode128 barcode = new Barcode128(getDocumento().getPdfDocument());
        barcode.setCodeType(Barcode128.CODE128);
        barcode.setCode(getParametrosBusqueda().get("claveAccesoAutorizacion"));

        PdfFormXObject barcodeObject = barcode.createFormXObject(null, null, getDocumento().getPdfDocument());
        Cell cell = new Cell().add(new Image(barcodeObject));
        listaLado.add(cell);

        return listaLado;
    }

    /**
     * Metodo para inicializar los totales.
     *
     */
    public void inicializaTotales() {
        setTotales(new ArrayList<TotalDocumentoFactura>());
        TotalDocumentoFactura totalFactura = new TotalDocumentoFactura();
        totalFactura.setTitulo(bundle.getMessage("fac_023"));
        getTotales().add(0, totalFactura);

        totalFactura = new TotalDocumentoFactura();
        totalFactura.setTitulo(bundle.getMessage("fac_024"));
        getTotales().add(1, totalFactura);

        totalFactura = new TotalDocumentoFactura();
        totalFactura.setTitulo(bundle.getMessage("fac_025"));
        getTotales().add(2, totalFactura);

        totalFactura = new TotalDocumentoFactura();
        totalFactura.setTitulo(bundle.getMessage("fac_026"));
        getTotales().add(3, totalFactura);

        totalFactura = new TotalDocumentoFactura();
        totalFactura.setTitulo(bundle.getMessage("fac_027"));
        getTotales().add(4, totalFactura);

        totalFactura = new TotalDocumentoFactura();
        totalFactura.setTitulo(bundle.getMessage("fac_028"));
        getTotales().add(5, totalFactura);

        totalFactura = new TotalDocumentoFactura();
        totalFactura.setTitulo(bundle.getMessage("fac_029"));
        getTotales().add(6, totalFactura);

        totalFactura = new TotalDocumentoFactura();
        totalFactura.setTitulo(bundle.getMessage("fac_030"));
        getTotales().add(7, totalFactura);

        totalFactura = new TotalDocumentoFactura();
        totalFactura.setTitulo(bundle.getMessage("fac_031"));
        getTotales().add(8, totalFactura);

        totalFactura = new TotalDocumentoFactura();
        totalFactura.setTitulo(bundle.getMessage("fac_032"));
        getTotales().add(9, totalFactura);

        totalFactura = new TotalDocumentoFactura();
        totalFactura.setTitulo(bundle.getMessage("fac_033"));
        getTotales().add(10, totalFactura);

        totalFactura = new TotalDocumentoFactura();
        totalFactura.setTitulo(bundle.getMessage("fac_034"));
        getTotales().add(11, totalFactura);

        totalFactura = new TotalDocumentoFactura();
        totalFactura.setTitulo(bundle.getMessage("fac_035"));
        getTotales().add(12, totalFactura);
    }

    /**
     * Metodo para cargar los totales que el sistema tiene.
     *
     * @param bus
     */
    public void cargarTotales() {
        if (getFactura().getInfoFactura().getTotalConImpuestos() != null && getFactura().getInfoFactura()
                .getTotalConImpuestos()
                .getTotalImpuesto()
                .size() > 0) {

            for (Factura.InfoFactura.TotalConImpuestos.TotalImpuesto a : getFactura().getInfoFactura()
                    .getTotalConImpuestos()
                    .getTotalImpuesto()) {
                if (a.getCodigo().compareTo("2") == 0) {

                    switch (a.getCodigoPorcentaje()) {
                        case "0":
                            getTotales().get(1).setValor(a.getBaseImponible());
                            break;
                        case "2":
                            getTotales().get(0).setTitulo(bundle.getMessage("fac_046"));
                            getTotales().get(6).setTitulo(bundle.getMessage("fac_047"));
                            getTotales().get(0).setValor(a.getBaseImponible());
                            getTotales().get(6).setValor(a.getValor());
                            break;
                        case "3":
                            getTotales().get(0).setTitulo(bundle.getMessage("fac_048"));
                            getTotales().get(6).setTitulo(bundle.getMessage("fac_049"));
                            getTotales().get(0).setValor(a.getBaseImponible());
                            getTotales().get(6).setValor(a.getValor());
                            break;

                        case "4":
                            getTotales().get(0).setTitulo(bundle.getMessage("fac_023"));
                            getTotales().get(6).setTitulo(bundle.getMessage("fac_029"));
                            getTotales().get(0).setValor(a.getBaseImponible());
                            getTotales().get(6).setValor(a.getValor());
                            break;

                        case "5":
                            getTotales().get(0).setTitulo(bundle.getMessage("fac_050"));
                            getTotales().get(6).setTitulo(bundle.getMessage("fac_051"));
                            getTotales().get(0).setValor(a.getBaseImponible());
                            getTotales().get(6).setValor(a.getValor());
                            break;

                        case "6":
                            getTotales().get(2).setValor(a.getBaseImponible());
                            break;

                        default:
                            log.info("Codigo de impuesto no encontrado: {}", a.getCodigoPorcentaje());
                            break;
                    }

                }

                if (a.getCodigo().compareTo("3") == 0) {
                    getTotales().get(5).setValor(a.getValor());
                }
            }
        }

        getTotales().get(3).setValor(getFactura().getInfoFactura().getTotalSinImpuestos());
        getTotales().get(4).setValor(getFactura().getInfoFactura().getTotalDescuento());
        getTotales().get(7).setValor(getFactura().getInfoFactura().getPropina());
        getTotales().get(8).setValor(getFactura().getInfoFactura().getFleteInternacional());

        getTotales().get(9).setValor(getFactura().getInfoFactura().getSeguroInternacional());
        getTotales().get(10).setValor(getFactura().getInfoFactura().getGastosAduaneros());
        getTotales().get(11).setValor(getFactura().getInfoFactura().getGastosTransporteOtros());
        getTotales().get(12).setValor(getFactura().getInfoFactura().getImporteTotal());
    }

    /**
     * Metodo para ejecutar los totales.
     *
     */
    private void subTotales() {
        if (isExportacion()) {
            int i = 0;
            String[] totalesExportacion = {
                    "", "",
                    bundle.getMessage("fac_053"),
                    bundle.getMessage("fac_052"),
                    "", "", "", "",
                    bundle.getMessage("fac_054"),
                    bundle.getMessage("fac_055"),
                    bundle.getMessage("fac_056"),
                    bundle.getMessage("fac_057"),
                    bundle.getMessage("fac_052")
            };

            while (i < getTotales().size() - 1) {
                TotalDocumentoFactura a = getTotales().get(i);

                if (totalesPresentacion[i].indexOf("2") >= 0) {
                    getForm().getListaTitulos().add(totalesExportacion[i].trim());
                    getForm().getListaValores().add((a.getValor() == null) ? "" : a.getValor().toString());
                    getForm().getListaFormatos().add(Elemento.FORMATO_MONEDA);
                }
                i++;
            }

            String tiuloPivot = getForm().getListaTitulos().get(0);
            String valorPivot = String.valueOf(getForm().getListaValores().get(0));
            getForm().getListaTitulos().remove(0);
            getForm().getListaValores().remove(0);
            getForm().getListaTitulos().add(tiuloPivot);
            getForm().getListaValores().add(valorPivot);

        } else {
            int i = 0;
            while (i < getTotales().size() - 1) {
                TotalDocumentoFactura a = getTotales().get(i);
                String valorString = (a.getValor() == null) ? "0" : a.getValor().toString();
                double valor = Double.parseDouble(valorString);

                if (i < 3)
                    valor = 1f;

                if (valor > 0 && totalesPresentacion[i].indexOf("1") >= 0) {
                        getForm().getListaTitulos().add(a.getTitulo());
                        getForm().getListaValores().add((a.getValor() == null) ? "" : a.getValor().toString());
                        getForm().getListaFormatos().add(Elemento.FORMATO_MONEDA);
                }
                i++;
            }
        }

        for (int i = 0; i < getForm().getListaTitulos().size(); i++) {
            getForm().getMapaAlineamiento().put(i + 1, TextAlignment.RIGHT);
        }

        getForm().setListaDimensiones(22f, 11f);
        getForm().procesar();
    }

    /**
     * Metodo para ejecutar los totales.
     *
     */
    private void totales() {
        if (isExportacion())
            getForm().getListaTitulos().add(bundle.getMessage("fac_052"));
        else
            getForm().getListaTitulos().add(getTotales().get(getTotales().size() - 1).getTitulo());

        getForm().getListaValores()
                .add((getTotales().get(getTotales().size() - 1).getValor() == null) ? ""
                        : getTotales().get(getTotales().size() - 1)
                                .getValor()
                                .toString());
        getForm().getListaFormatos().add(Elemento.FORMATO_MONEDA);
        getForm().getMapaAlineamiento().put(1, TextAlignment.RIGHT);
        getForm().setListaDimensiones(22f, 11f);
        getForm().procesar();
    }

    /**
     * Metodo para conocer si la factura tiene informacion adicional.
     * 
     * @return
     */
    private boolean isInformacionAdicional() {
        return (getFactura().getInfoAdicional() != null && getFactura()
                .getInfoAdicional()
                .getCampoAdicional()
                .size() > 0);
    }

    /**
     * Metodo para conocer si la factura es de exportacion.
     * 
     * @return
     */
    private boolean isExportacion() {
        return (getFactura().getInfoFactura()
                .getComercioExterior() != null
                && getFactura().getInfoFactura()
                        .getComercioExterior()
                        .trim()
                        .length() > 0);
    }
}
