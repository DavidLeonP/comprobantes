package com.aplicaciones13.documentos.impresion.ensamble.ride;

import java.util.ArrayList;
import java.util.List;

import com.aplicaciones13.documentos.estructuras.comprobanteretencion.v1_0_0.ComprobanteRetencion;
import com.aplicaciones13.documentos.estructuras.comprobanteretencion.v1_0_0.Impuesto;
import com.aplicaciones13.documentos.impresion.elementos.texto.Elemento;
import com.aplicaciones13.documentos.utilidades.Bundle;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.properties.TextAlignment;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Objeto para crear un documento de Comprobante de Retencion.
 *
 * @author omargo33
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ImpresionElementosComprobanteRetencion extends ImpresionElementosRide {

    private static Bundle bundle = new Bundle("elementos-ride");

    private ComprobanteRetencion comprobanteRetencion;

    private double totalRetenido;

    /**
     * Constructor para el objeto.
     *
     */
    public ImpresionElementosComprobanteRetencion() {
        comprobanteRetencion = new ComprobanteRetencion();

    }

    @Override
    public synchronized void elemento2() {
        setRazonSocial(getComprobanteRetencion().getInfoTributaria().getRazonSocial());
        setDireccionMatriz(getComprobanteRetencion().getInfoTributaria().getDirMatriz());
        setDireccionEstablecimiento(getComprobanteRetencion().getInfoCompRetencion().getDirEstablecimiento());
        setContribuyenteEspecial(getComprobanteRetencion().getInfoCompRetencion().getContribuyenteEspecial());
        setObligadoContabilidad(getComprobanteRetencion().getInfoCompRetencion().getObligadoContabilidad().value());
        setClaveAccesoAutorizacion(getParametrosBusqueda().get("claveAccesoAutorizacion"));
        setAgenteRetencion(getComprobanteRetencion().getInfoTributaria().getAgenteRetencion());
        setContribuyenteRimpe(getComprobanteRetencion().getInfoTributaria().getContribuyenteRimpe());
        super.elemento2();
    }

    /**
     * Metodo para escribir la informacion del cliente.
     *
     */
    public synchronized void elemento3() {
        getEspacio().escribir(1);
        getLineaSolida().escribir();

        String razonSocial = getComprobanteRetencion().getInfoCompRetencion().getRazonSocialSujetoRetenido();
        escribirCamposSimples(razonSocial, "com_001");

        String identificacion = getComprobanteRetencion().getInfoCompRetencion().getIdentificacionSujetoRetenido();
        try {
            escribirCamposSimples(identificacion,
                    "tabla6_" + getComprobanteRetencion().getInfoCompRetencion().getTipoIdentificacionSujetoRetenido());
        } catch (Exception e) {
            escribirCamposSimples(identificacion, "gen003");
        }

        String ejercicioFiscal = getComprobanteRetencion().getInfoCompRetencion().getPeriodoFiscal();
        escribirCamposSimples(ejercicioFiscal, "com_003");

        String fechaEmision = getComprobanteRetencion().getInfoCompRetencion().getFechaEmision();
        escribirCamposSimples(fechaEmision, "com_004");
    }

    /**
     * Metodo para escribir la el detalle del comprobante.
     */
    public synchronized void elemento4() {
        Object[] filaValores;
        List<Object[]> listaValores = new ArrayList<>();

        if (getComprobanteRetencion().getImpuestos() == null ||
                getComprobanteRetencion().getImpuestos().getImpuesto().size() == 0) {
            return;
        }

        getEspacio().escribir(1);
        getLineaSolida().escribir();

        for (Impuesto a : getComprobanteRetencion().getImpuestos().getImpuesto()) {
            filaValores = new Object[8];
            filaValores[0] = bundle.getMessage("tabla3_" + a.getCodDocSustento());
            filaValores[1] = a.getNumDocSustento();
            filaValores[2] = a.getFechaEmisionDocSustento();
            filaValores[3] = a.getBaseImponible();
            filaValores[4] = bundle.getMessage("tabla16_" + a.getCodigo());
            filaValores[5] = bundle.getMessage("tabla18_" + a.getCodigoRetencion());
            filaValores[6] = String.format("%.2f", Double.valueOf(a.getPorcentajeRetener().doubleValue()));
            filaValores[7] = a.getValorRetenido();
            listaValores.add(filaValores);
            totalRetenido += a.getValorRetenido().doubleValue();
        }
        getTabla().setListaTitulos(bundle.getMessages(
                "com_005", "com_006", "com_007", "com_008",
                "com_009", "com_010", "com_011", "com_012"));
        getTabla().setListaFormatos(
                Elemento.FORMATO_STRING,
                Elemento.FORMATO_STRING,
                Elemento.FORMATO_STRING,
                Elemento.FORMATO_STRING,
                Elemento.FORMATO_STRING,
                Elemento.FORMATO_STRING,
                Elemento.FORMATO_STRING,
                Elemento.FORMATO_STRING);
        getTabla().setListaDimensiones(15f, 14f, 10f, 10f, 8f, 25f, 8f, 10f);
        getTabla().getMapaAlineamiento().put(0, TextAlignment.LEFT);
        getTabla().getMapaAlineamiento().put(1, TextAlignment.LEFT);
        getTabla().getMapaAlineamiento().put(2, TextAlignment.LEFT);
        getTabla().getMapaAlineamiento().put(3, TextAlignment.RIGHT);
        getTabla().getMapaAlineamiento().put(4, TextAlignment.LEFT);
        getTabla().getMapaAlineamiento().put(5, TextAlignment.LEFT);
        getTabla().getMapaAlineamiento().put(6, TextAlignment.RIGHT);
        getTabla().getMapaAlineamiento().put(7, TextAlignment.RIGHT);

        getTabla().setListaValores(listaValores);
        getTabla().setBandasPresentacion(true);
        getTabla().procesar();
        getTabla().escribir();

        if (getCurrentPosition().getY() < 140) {
            getDocumento().add(new AreaBreak());
        }
    }

    /**
     * Metodo para escribir la sumatoria del comprobante.
     */
    public synchronized void elemento5() {
        Cell cell = new Cell();

        getForm().setListaTitulos(bundle.getMessage("com_013"));
        getForm().setListaValores(totalRetenido);
        getForm().getListaFormatos().add(Elemento.FORMATO_MONEDA);
        getForm().getMapaAlineamiento().put(1, TextAlignment.RIGHT);
        getForm().setListaDimensiones(22f, 11f);

        getPanel().setListaDimensiones(64f, 36f);

        getForm().procesar();
        getForm().getTabla().setBorderTop(border);
        getPanel().setListaCeldas(cell, getForm().getTabla());
        getForm().reset();

        getPanel().procesar();
        getPanel().escribir();
    }

    /**
     * Metodo para escribir la informacion adicional
     */
    public synchronized void elemento6() {
        for (ComprobanteRetencion.InfoAdicional.CampoAdicional a : getComprobanteRetencion()
                .getInfoAdicional()
                .getCampoAdicional()) {
            cargarInformacionAdicional(a.getNombre(), a.getValue());
        }

        elementoInformacionAdicional();
    }
}