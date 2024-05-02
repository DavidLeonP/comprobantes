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

import java.util.ArrayList;
import java.util.List;

//TODO revisar para una factura de exporacion.
/**
 * Objeto para crear un documento de factura.
 *
 * @author omargo33
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ImpresionElementosFactura extends ImpresionElementosRide {

    private static Bundle bundle = new Bundle("elementos-ride");

    private Factura factura;
    private Totales totales;

    /**
     * Constructor para el objeto.
     *
     */
    public ImpresionElementosFactura() {
        factura = new Factura();
        totales = new Totales();
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

        elementoSubTotales();
        getPanel().setListaDimensiones(64f, 36f);
        getPanel().setListaCeldas(cell, getForm().getTabla());
        getForm().reset();
        getPanel().procesar();
        getPanel().escribir();

        elementoTotal();
        getPanel().setListaDimensiones(64f, 36f);        
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
     * Metodo para generar los elementos de totalizacion de la nota de debito.
     * 
     * Se usa el objeto Totales para generar los elementos de totalizacion.
     */
    private void elementoSubTotales() {
        getTotales().setPropina(getFactura().getInfoFactura().getPropina().toString());
        getTotales().setTotalDescuento(getFactura().getInfoFactura().getTotalDescuento().toString());
        getTotales().setSubTotal(getFactura().getInfoFactura().getTotalSinImpuestos().toString());

        for (com.aplicaciones13.documentos.estructuras.factura.v2_1_0.Factura.InfoFactura.TotalConImpuestos.TotalImpuesto a : getFactura()
                .getInfoFactura().getTotalConImpuestos().getTotalImpuesto()) {
            getTotales().cargarTotalesSubtotales(a.getCodigo(), a.getCodigoPorcentaje(),
                    String.valueOf(a.getTarifa()),
                    String.valueOf(a.getBaseImponible()), String.valueOf(a.getValor()));
        }

        getTotales().setListaTitulosNoRequeridos(
                "tabla21_2_2", "tabla21_2_10", "tabla21_2_3", "tabla21_2_4",
                "tabla21_2_5", "tabla21_2_8", "tabla21_200", "tabla21_3",
                "tabla21_5", "tabla21_20_2", "tabla21_20_10", "tabla21_20_3",
                "tabla21_20_4", "tabla21_20_5", "tabla21_20_8", "tabla21_9");
        getTotales().leerValores();
        getTotales().procesar();

        getForm().setListaTitulos(getTotales().getArregloTitulos());
        getForm().setListaValores(getTotales().getArregloValores());

        for (int i = 0; i < getTotales().getArregloValores().length; i++) {
            getForm().getListaFormatos().add(i, Elemento.FORMATO_MONEDA);
            getForm().getMapaAlineamiento().put(i + 1, TextAlignment.RIGHT);
        }
        getForm().setListaDimensiones(35f, 15f);
        getForm().procesar();
    }

    /**
     * Metodo para generar el elemento de total de la factura.
     */
    private void elementoTotal() {
        getForm().setListaTitulos(bundle.getMessage("tabla21_10"));
        getForm().setListaValores(getFactura().getInfoFactura().getImporteTotal());
        getForm().getListaFormatos().add(0, Elemento.FORMATO_MONEDA);
        getForm().getMapaAlineamiento().put(1, TextAlignment.RIGHT);
        getForm().setListaDimensiones(35f, 15f);
        getForm().procesar();
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
