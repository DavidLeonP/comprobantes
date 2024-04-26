package com.aplicaciones13.documentos.impresion.ensamble.ride;

import java.util.ArrayList;
import java.util.List;

import com.aplicaciones13.documentos.estructuras.comprobanteretencion.v1_0_0.ComprobanteRetencion;
import com.aplicaciones13.documentos.estructuras.comprobanteretencion.v1_0_0.Impuesto;
import com.aplicaciones13.documentos.estructuras.factura.v2_1_0.Factura;
import com.aplicaciones13.documentos.impresion.elementos.texto.Elemento;
import com.aplicaciones13.documentos.utilidades.Bundle;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.layout.properties.TextAlignment;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

/**
 * Objeto para crear un documento de Comprobante de Retencion.
 *
 * @author omargo33
 *
 */
@Slf4j
@EqualsAndHashCode(callSuper = false)
public class ImpresionElementosComprobanteRetencion extends ImpresionElementosRide {

    private static Bundle bundle = new Bundle("elementos-ride");

    private ComprobanteRetencion comprobanteRetencion;

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
        super.elemento2();
    }

    /**
     * Metodo para escribir la informacion del cliente.
     *
     */
    @Override
    public synchronized void elemento3() {
        getEspacio().escribir(1);
        getLineaSolida().escribir();

        getForm().setListaTitulos(bundle.getMessages("com_001", "com_002", "com_003", "com_004"));
        getForm().setListaValores(
                getComprobanteRetencion().getInfoCompRetencion().getRazonSocialSujetoRetenido(),
                getComprobanteRetencion().getInfoCompRetencion().getIdentificacionSujetoRetenido(),
                getComprobanteRetencion().getInfoCompRetencion().getPeriodoFiscal(),
                getComprobanteRetencion().getInfoCompRetencion().getFechaEmision());
        getForm()
                .setListaFormatos(
                        Elemento.FORMATO_STRING,
                        Elemento.FORMATO_STRING,
                        Elemento.FORMATO_STRING,
                        Elemento.FORMATO_STRING);
        getForm().setListaDimensiones(15f, 85f);
        getForm().procesar();
        getForm().escribir();
        getForm().reset();
    }

    /**
     * Metodo para escribir la el detalle del comprobante.
     */
    @Override
    public synchronized void elemento4() {

        List<Object[]> listaValores = new ArrayList<>();
        Object[] filaValores;



        if (getComprobanteRetencion().getImpuestos() == null ||
                getComprobanteRetencion().getImpuestos().getImpuesto().size() == 0) {
            return;
        }


            for (Impuesto a : getComprobanteRetencion().getImpuestos().getImpuesto()) {
                filaValores = new Object[6];
                filaValores[0] = bundle.getMessage("tabla3_01"+a.getCodDocSustento());
                filaValores[1] = a.getNumDocSustento();
                filaValores[2] = a.getFechaEmisionDocSustento();
                filaValores[3] = a.getBaseImponible();
                filaValores[4] = bundle.getMessage("tabla16_" + a.getCodigo());
                filaValores[5] = 

                
            listaValores.add(5, TablasSRI.Tabla19(a.getCodigoRetencion()));
            listaValores.add(6, String.format("%.2f", Double.valueOf(a.getPorcentajeRetener().doubleValue())));
            listaValores.add(7, a.getValorRetenido() + "");

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
                    Elemento.FORMATO_STRING,
                    Elemento.FORMATO_STRING,
                    Elemento.FORMATO_STRING);
            getTabla().setListaDimensiones(15f, 14f, 10f, 10f, 8f, 25f, 8f, 10f);

            getTabla().getMapaAlineamiento().put(1, TextAlignment.LEFT);
            getTabla().getMapaAlineamiento().put(2, TextAlignment.LEFT);
            getTabla().getMapaAlineamiento().put(3, TextAlignment.LEFT);
            getTabla().getMapaAlineamiento().put(4, TextAlignment.RIGHT);
            getTabla().getMapaAlineamiento().put(5, TextAlignment.LEFT);
            getTabla().getMapaAlineamiento().put(6, TextAlignment.LEFT);
            getTabla().getMapaAlineamiento().put(7, TextAlignment.RIGHT);
            getTabla().getMapaAlineamiento().put(8, TextAlignment.RIGHT);

            getTabla().setListaValores(listaValores);
            getTabla().setBandasPresentacion(true);
            getTabla().procesar();
            getTabla().escribir();
        }

        if (getCurrentPosition().getY() < 140) {
            getDocumento().add(new AreaBreak());
        }



        getEspacio().escribir(1);
        getLineaSolida().escribir();



    }
}