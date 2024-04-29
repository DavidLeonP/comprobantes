package com.aplicaciones13.documentos.impresion.ensamble.ride;

import com.aplicaciones13.documentos.estructuras.notadebito.v1_0_0.NotaDebito;
import com.aplicaciones13.documentos.utilidades.Bundle;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ImpresionElementosNotaDebito  extends ImpresionElementosRide {

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
     * Metodo para escribir la informacion del cliente.
     *
     */
    public synchronized void elemento3() {
    }    
}
