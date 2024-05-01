package com.aplicaciones13.documentos.impresion.ensamble.ride;

import java.util.ArrayList;
import java.util.List;

import com.aplicaciones13.documentos.estructuras.notadebito.v1_0_0.NotaDebito;
import com.aplicaciones13.documentos.impresion.elementos.texto.Elemento;
import com.aplicaciones13.documentos.utilidades.Bundle;
import com.itextpdf.layout.properties.TextAlignment;

import lombok.AllArgsConstructor;
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

    /**
     * Constructor para el objeto.
     *
     */
    public ImpresionElementosNotaDebito() {
        notaDebito = new NotaDebito();
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
            filaValores[1] = a.getValor().toString();
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

        for (com.aplicaciones13.documentos.estructuras.notadebito.v1_0_0.Impuesto a : getNotaDebito()
                .getInfoNotaDebito().getImpuestos().getImpuesto()) {
            cargarImpuestos(a.getCodigo(), a.getCodigoPorcentaje(), a.getTarifa().toString(),
                    a.getBaseImponible().toString(), a.getValor().toString());
        }

        String[] arregloTitulos = bundle.getMessages(
                "tabla21_2_2", "tabla21_2_10", "tabla21_2_3",
                "tabla21_2_4", "tabla21_2_5", "tabla21_2_0",
                "tabla21_2_6", "tabla21_2_7", "tabla21_2_8",
                "tabla21_200", "tabla21_210", "tabla21_3",
                "tabla21_5", "tabla21_20_2", "tabla21_20_10",
                "tabla21_20_3", "tabla21_20_4", "tabla21_20_5",
                "tabla21_20_8", "tabla21_9");

        Object[] arregloValores = {
                buscarCodigoYCodigoPorcentaje("2", "2").getBaseImponible(), 
                buscarCodigoYCodigoPorcentaje("2", "10").getBaseImponible(),
                buscarCodigoYCodigoPorcentaje("2", "3").getBaseImponible(),
                buscarCodigoYCodigoPorcentaje("2", "4").getBaseImponible(),
                buscarCodigoYCodigoPorcentaje("2", "5").getBaseImponible(),
                buscarCodigoYCodigoPorcentaje("2", "0").getBaseImponible(), 
                buscarCodigoYCodigoPorcentaje("2", "6").getBaseImponible(),
                buscarCodigoYCodigoPorcentaje("2", "7").getBaseImponible(),
                buscarCodigoYCodigoPorcentaje("2", "8").getBaseImponible(),
                getNotaDebito().getInfoNotaDebito().getTotalSinImpuestos(),
                "",// total descuento
                buscarCodigo("3").getValor(),
                buscarCodigo("5").getValor(),
                buscarCodigoYCodigoPorcentaje("2", "2").getValor(), 
                buscarCodigoYCodigoPorcentaje("2", "10").getValor(), 
                buscarCodigoYCodigoPorcentaje("2", "3").getValor(),
                buscarCodigoYCodigoPorcentaje("2", "4").getValor(),
                buscarCodigoYCodigoPorcentaje("2", "5").getValor(),
                buscarCodigoYCodigoPorcentaje("2", "8").getValor(), 
                ""//propina
        };

        //TODO retirar si no hay valores en: 2_2, 2_10, 2_3, 2_4, 2_5, 2_8
        //TODO retirar si no hay valores en: 20_2, 20_10, 20_3, 20_4, 20_5, 20_8
        //Retirar "Total descuento" que es solo para factura
        //Retirar "Propina" que es solo para factura
        

        getForm().setListaTitulos(arregloTitulos);
        getForm().setListaValores(arregloValores);

        for (int i = 0; i < arregloValores.length; i++) {
            getForm().getListaFormatos().add(i, Elemento.FORMATO_MONEDA);
            getForm().getMapaAlineamiento().put(i + 1, TextAlignment.RIGHT);
        }
        getForm().setListaDimensiones(35f, 15f);
        getForm().procesar();
        getForm().escribir();
        getForm().reset();
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

    public Impuesto buscarCodigo(String codigo) {
        for (Impuesto impuesto : getListaImpuestos()) {
            if (impuesto.getCodigo().equals(codigo)) {
                return impuesto;
            }
        }
        return new Impuesto();
    }

    public Impuesto buscarCodigoYCodigoPorcentaje(String codigo, String codigoPorcentaje) {
        for (Impuesto impuesto : getListaImpuestos()) {
            if (impuesto.getCodigo().equals(codigo) &&
                    impuesto.getCodigoPorcentaje().equals(codigoPorcentaje)) {
                return impuesto;
            }
        }
        return new Impuesto();
    }

    List<Impuesto> listaImpuestos = new ArrayList<>();

    /**
     * Metodo para cargar inforamcion adicional.
     * 
     * @param codigo
     * @param codigoPorcentaje
     * @param tarifa
     * @param baseImponible
     * @param valor
     */
    public void cargarImpuestos(String codigo, String codigoPorcentaje, String tarifa, String baseImponible,
            String valor) {
        if (listaImpuestos == null) {
            listaImpuestos = new ArrayList<>();
        }

        Impuesto impuesto = new Impuesto();
        impuesto.setCodigo(codigo);
        impuesto.setCodigoPorcentaje(codigoPorcentaje);
        impuesto.setTarifa(tarifa);
        impuesto.setBaseImponible(baseImponible);
        impuesto.setValor(valor);
        listaImpuestos.add(impuesto);
    }

    @Data
    public class Impuesto {
        String codigo;
        String codigoPorcentaje;
        String tarifa;
        String baseImponible;
        String valor;
    }
}
