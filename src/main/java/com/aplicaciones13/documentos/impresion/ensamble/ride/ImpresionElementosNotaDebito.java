package com.aplicaciones13.documentos.impresion.ensamble.ride;

import java.util.ArrayList;
import java.util.List;

import com.aplicaciones13.documentos.estructuras.notadebito.v1_0_0.NotaDebito;
import com.aplicaciones13.documentos.impresion.elementos.texto.Elemento;
import com.aplicaciones13.documentos.utilidades.Bundle;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.properties.TextAlignment;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Clase para ensamblar los elementos de la nota de debito.
 * 
 * @author omargo33
 * @since 2024-04-30
 * 
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ImpresionElementosNotaDebito extends ImpresionElementosRide {

    private static Bundle bundle = new Bundle("elementos-ride");

    private NotaDebito notaDebito;

    private Totales totales;

    /**
     * Constructor para el objeto.
     *
     */
    public ImpresionElementosNotaDebito() {
        notaDebito = new NotaDebito();
        totales = new Totales();
    }

    /**
     * Metodo para poner en encabezado del documento.
     * 
     */
    @Override
    public synchronized void elemento2() {
        setRazonSocial(getNotaDebito().getInfoTributaria().getRazonSocial());
        setDireccionMatriz(getNotaDebito().getInfoTributaria().getDirMatriz());
        setDireccionEstablecimiento(getNotaDebito().getInfoNotaDebito().getDirEstablecimiento());
        setContribuyenteEspecial(getNotaDebito().getInfoNotaDebito().getContribuyenteEspecial());
        setObligadoContabilidad(getNotaDebito().getInfoNotaDebito().getObligadoContabilidad().value());
        setClaveAccesoAutorizacion(getParametrosBusqueda().get("claveAccesoAutorizacion"));
        setAgenteRetencion(getNotaDebito().getInfoTributaria().getAgenteRetencion());
        setContribuyenteRimpe(getNotaDebito().getInfoTributaria().getContribuyenteRimpe());
        super.elemento2();
    }

    /**
     * Metodo para escribir la informacion del cliente y documento modificado.
     *
     */
    public synchronized void elemento3() {
        getEspacio().escribir(1);
        getLineaSolida().escribir();

        getForm().setListaTitulos(
                bundle.getMessage("nod_001"),
                bundle.getMessage("tabla6_" + getNotaDebito().getInfoNotaDebito().getTipoIdentificacionComprador()),
                bundle.getMessage("nod_002"));
        getForm().setListaValores(getNotaDebito().getInfoNotaDebito().getRazonSocialComprador(),
                getNotaDebito().getInfoNotaDebito().getIdentificacionComprador(),
                getNotaDebito().getInfoNotaDebito().getFechaEmision());
        getForm().setListaFormatos(Elemento.FORMATO_STRING,
                Elemento.FORMATO_STRING,
                Elemento.FORMATO_STRING);
        getForm().setListaDimensiones(15f, 85f);
        getForm().procesar();
        getForm().escribir();
        getForm().reset();

        getLineaSolida().escribir();
        getForm().setListaTitulos(bundle.getMessages("nod_003", "nod_004"));
        getForm().setListaValores(
                bundle.getMessage("tabla3_" + getNotaDebito().getInfoNotaDebito().getCodDocModificado())
                        + ": " + getNotaDebito().getInfoNotaDebito().getNumDocModificado(),
                getNotaDebito().getInfoNotaDebito().getFechaEmisionDocSustento());
        getForm().setListaFormatos(
                Elemento.FORMATO_STRING,
                Elemento.FORMATO_STRING);
        getForm().setListaDimensiones(23f, 23f, 15f, 35f);
        getForm().procesar();
        getForm().escribir();

        String rise = getNotaDebito().getInfoNotaDebito().getRise();
        escribirCamposSimples(rise, "nod_005");
    }

    /**
     * Metodo para escribir los detalles de la nota de debito.
     */
    public synchronized void elemento4() {
        List<Object[]> listaValores = new ArrayList<>();
        Object[] filaValores;

        for (NotaDebito.Motivos.Motivo a : getNotaDebito().getMotivos().getMotivo()) {
            filaValores = new Object[2];
            filaValores[0] = a.getRazon();
            filaValores[1] = String.valueOf(a.getValor());
            listaValores.add(filaValores);
        }
        getTabla().setListaTitulos(bundle.getMessages("nod_006", "nod_007"));
        getTabla().setListaFormatos(
                Elemento.FORMATO_STRING,
                Elemento.FORMATO_STRING);
        getTabla().setListaDimensiones(80f, 20f);
        getTabla().getMapaAlineamiento().put(0, TextAlignment.LEFT);
        getTabla().getMapaAlineamiento().put(1, TextAlignment.RIGHT);
        getTabla().setListaValores(listaValores);
        getTabla().setBandasPresentacion(true);
        getTabla().procesar();
        getTabla().escribir();
    }

    /**
     * Metodo para escribir totales de la nota de debito.
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
     * Metodo para generar los elementos de totalizacion de la nota de debito.
     */
    private void elementoSubTotales() {
        getTotales().setSubTotal(String.valueOf(getNotaDebito().getInfoNotaDebito().getTotalSinImpuestos()));

        for (com.aplicaciones13.documentos.estructuras.notadebito.v1_0_0.Impuesto a : getNotaDebito()
                .getInfoNotaDebito().getImpuestos().getImpuesto()) {
            getTotales().cargarData(a.getCodigo(), a.getCodigoPorcentaje(),
                    String.valueOf(a.getTarifa()),
                    String.valueOf(a.getBaseImponible()), String.valueOf(a.getValor()));
        }

        getTotales().setListaTitulosNoRequeridos(
            "tabla21_2_2", "tabla21_2_10", "tabla21_2_3", "tabla21_2_4",
            "tabla21_2_5", "tabla21_2_8", "tabla21_200", "tabla21_3", 
            "tabla21_5", "tabla21_20_2", "tabla21_20_10", "tabla21_20_3", 
            "tabla21_20_4" , "tabla21_20_5", "tabla21_20_8", "tabla21_9");
        
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
        getForm().setListaValores(getNotaDebito().getInfoNotaDebito().getValorTotal());
        getForm().getListaFormatos().add(0, Elemento.FORMATO_MONEDA);
        getForm().getMapaAlineamiento().put(1, TextAlignment.RIGHT);
        getForm().setListaDimensiones(35f, 15f);
        getForm().procesar();
    }

    /**
     * Metodo para escribir los detalles de la nota de debito.
     */
    public synchronized void elemento6() {
        for (NotaDebito.InfoAdicional.CampoAdicional a : getNotaDebito().getInfoAdicional().getCampoAdicional()) {
            cargarInformacionAdicional(a.getNombre(), a.getValue());
        }

        elementoInformacionAdicional();
    }
}
