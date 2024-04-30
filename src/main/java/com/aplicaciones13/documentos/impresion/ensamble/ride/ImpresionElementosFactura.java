package com.aplicaciones13.documentos.impresion.ensamble.ride;

import com.aplicaciones13.documentos.estructuras.factura.v2_1_0.Pagos.Pago;
import com.aplicaciones13.documentos.impresion.elementos.texto.Elemento;
import com.aplicaciones13.documentos.estructuras.factura.v2_1_0.Factura;

import com.aplicaciones13.documentos.utilidades.Bundle;

import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Cell;
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
public class ImpresionElementosFactura extends ImpresionElementosRide {

    private static Bundle bundle = new Bundle("elementos-ride");

    private static String[] totalesPresentacion = {
            "1", "1", "1 2", "1 2", "1", "1", "1", "1", "2", "2", "2", "2", "1 2" };

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

    @Override
    public synchronized void elemento2() {
        setRazonSocial(getFactura().getInfoTributaria().getRazonSocial());
        setDireccionMatriz(getFactura().getInfoTributaria().getDirMatriz());
        setDireccionEstablecimiento(getFactura().getInfoFactura().getDirEstablecimiento());
        setContribuyenteEspecial(getFactura().getInfoFactura().getContribuyenteEspecial());
        setObligadoContabilidad(getFactura().getInfoFactura().getObligadoContabilidad().value());
        setClaveAccesoAutorizacion(getParametrosBusqueda().get("claveAccesoAutorizacion"));
        setAgenteRetencion(getFactura().getInfoTributaria().getAgenteRetencion());
        setContribuyenteRimpe(getFactura().getInfoTributaria().getContribuyenteRimpe());
        super.elemento2();
    }

    /**
     * Metodo para escribir la informacion del cliente.
     *
     */
    public synchronized void elemento3() {
        getEspacio().escribir(1);
        getLineaSolida().escribir();

        String razonSocial = getFactura().getInfoFactura().getRazonSocialComprador();
        escribirCamposSimples(razonSocial, "fac_013");

        String identificacion = getFactura().getInfoFactura().getIdentificacionComprador();
        try {
            escribirCamposSimples(identificacion,
                    "tabla6_" + getFactura().getInfoFactura().getTipoIdentificacionComprador());
        } catch (Exception e) {
            escribirCamposSimples(identificacion, "gen_003");
        }

        String direccion = getFactura().getInfoFactura().getDireccionComprador();
        escribirCamposSimples(direccion, "fac_060");

        String fechaEmision = getFactura().getInfoFactura().getFechaEmision();
        escribirCamposSimples(fechaEmision, "fac_015");

        String guiaRemision = getFactura().getInfoFactura().getGuiaRemision();
        escribirCamposSimples(guiaRemision, "fac_016");
    }

    /**
     * Metodo para detalle de la factura.
     *
     */
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
                filaValores[1] = generarDescripcion(a);
                filaValores[2] = a.getCantidad().toString();
                filaValores[3] = a.getPrecioUnitario().toString();
                filaValores[4] = a.getDescuento().toString();
                filaValores[5] = a.getPrecioTotalSinImpuesto().toString();

                listaValores.add(filaValores);
            }
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
    public synchronized void elemento5() {
        Cell cell = new Cell();
        getLineaSolida().escribir();

        inicializaTotales();

        cargarTotales();

        if (isExportacion()) {
            subTotalesExportacion();
        } else {
            subTotales();
        }

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
                    buscarPais(getFactura().getInfoFactura().getPaisOrigen()),
                    getFactura().getInfoFactura().getPuertoEmbarque(),
                    buscarPais(getFactura().getInfoFactura().getPaisDestino()),
                    getFactura().getInfoFactura().getPuertoDestino(),
                    buscarPais(getFactura().getInfoFactura().getPaisAdquisicion()));
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
    public synchronized void elemento7() {
        if (isExportacion())
            return;

        for (Factura.InfoAdicional.CampoAdicional a : getFactura().getInfoAdicional().getCampoAdicional()) {
            cargarInformacionAdicional(a.getNombre(), a.getValue());
        }

        elementoInformacionAdicional();
    }

    /**
     * Metodo para agregar Formas de pago
     *
     */
    public synchronized void elemento8() {
        int size = 0;
        String formaPagoDinamica = "";

        if (getFactura()
                .getInfoFactura()
                .getPagos() != null
                && getFactura().getInfoFactura()
                        .getPagos()
                        .getPago()
                        .size() > 0) {
            getEspacio().escribir(1);
            getLineaSolida().escribir();

            for (Pago a : getFactura().getInfoFactura().getPagos().getPago()) {
                if (a.getPlazo() == null || a.getPlazo().intValue() <= 0) {
                    formaPagoDinamica = bundle.getMessage("fac_061",
                            bundle.getMessage("tabla24_" + a.getFormaPago()),
                            a.getTotal());
                } else {
                    formaPagoDinamica = bundle.getMessage("fac_059",
                            bundle.getMessage("tabla24_" + a.getFormaPago()),
                            a.getPlazo(),
                            a.getUnidadTiempo(),
                            a.getTotal());
                }

                getForm().getListaTitulos().add(bundle.getMessage("fac_058", (size + 1)));
                getForm().getListaValores().add(formaPagoDinamica);
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
     * Metodo para ejecutar los totales en una factura de exportacion.
     *
     */
    private void subTotalesExportacion() {

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
                bundle.getMessage("fac_035")
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

        for (int j = 0; j < getForm().getListaTitulos().size(); j++) {
            getForm().getMapaAlineamiento().put(j + 1, TextAlignment.RIGHT);
        }

        getForm().setListaDimensiones(22f, 11f);
        getForm().procesar();
    }

    /**
     * Metodo para ejecutar los sub totales.
     *
     */
    private void subTotales() {
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

        for (int j = 0; j < getForm().getListaTitulos().size(); j++) {
            getForm().getMapaAlineamiento().put(j + 1, TextAlignment.RIGHT);
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
     * Metodo para generar la descripcion de la factura.
     * 
     * Agrega el codigo auxiliar y los detalles adicionales del item.
     * 
     * @param a
     * @return
     */
    private String generarDescripcion(Factura.Detalles.Detalle a) {
        String codigo = a.getCodigoPrincipal();
        StringBuilder sb = new StringBuilder();
        sb.append(a.getDescripcion());

        if (a.getCodigoAuxiliar() != null &&
                a.getCodigoAuxiliar().trim().length() > 0 &&
                String.valueOf(codigo).compareTo(a.getCodigoAuxiliar()) != 0) {
            sb.append("\nCod.: ").append(a.getCodigoAuxiliar());
        }

        if (a.getDetallesAdicionales() != null &&
                !a.getDetallesAdicionales().getDetAdicional().isEmpty()) {
            for (Factura.Detalles.Detalle.DetallesAdicionales.DetAdicional b : a.getDetallesAdicionales()
                    .getDetAdicional()) {
                sb.append("\n").append(b.getNombre()).append(": ").append(b.getValor());
            }
        }
        return sb.toString();
    }

    /**
     * Metodo para buscar el pais en el bundle.
     * 
     * @param codigo
     * @return
     */
    private String buscarPais(String codigo) {
        return bundle.getMessage("tabla25_" + codigo);
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
