/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplicaciones13.documentos;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

import com.aplicaciones13.documentos.estructuras.autorizacion.Autorizacion;
import com.aplicaciones13.documentos.estructuras.comprobanteretencion.v1_0_0.ComprobanteRetencion;
import com.aplicaciones13.documentos.estructuras.factura.v2_1_0.Factura;
import com.aplicaciones13.documentos.estructuras.notadebito.v1_0_0.NotaDebito;
import com.aplicaciones13.documentos.impresion.ensamble.ImpresionITextBase;
import com.aplicaciones13.documentos.impresion.ensamble.ride.ImpresionElementosComprobanteRetencion;
import com.aplicaciones13.documentos.impresion.ensamble.ride.ImpresionElementosFactura;
import com.aplicaciones13.documentos.impresion.ensamble.ride.ImpresionElementosNotaDebito;
//import com.aplicaciones13.documentos.impresion.ensamble.ride.ImpresionElementosNotaDebito;
import com.aplicaciones13.documentos.utilidades.Conversion;
import com.aplicaciones13.documentos.utilidades.Route;

import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author omargo33
 */
@Slf4j
public class ImpresionDocumentosTest {
    String pathUser = System.getProperty("user.dir");

    /**
     * Test of factura
     */
    @Test
    public void testFactura() {

        String claveAcceso = "1312202301179001691900122011070002060400460006816";

        try {
            Map<String, String> mapa = new HashMap<>();            
            Autorizacion autorizacion =Route.getAutorizacion(pathUser + "/recursos/facturaAutorizacion003.xml");
            Factura factura = Conversion.xmlToPojo(autorizacion.getComprobante(), Factura.class);

            mapa.put("numeroAutorizacion", autorizacion.getNumeroAutorizacion());
            mapa.put("claveAccesoAutorizacion", claveAcceso);
            mapa.put("fechaAutorizacion", String.valueOf(autorizacion.getFechaAutorizacion()));
            mapa.put("documentoDestino", pathUser + "/recursos/testFactura01.pdf");
            mapa.put("pathImagen", pathUser + "/recursos/logoRideHorizontal.png");

            ImpresionElementosFactura impresionFactura = new ImpresionElementosFactura();
            impresionFactura.setFactura(factura);
            impresionFactura.setOrdenElementos(new int[] { 2, 3, 4, 5, 6, 7, 8 });
            ImpresionITextBase impresionBaseIText = new ImpresionITextBase(impresionFactura);
            impresionBaseIText.ejecutar(18, 36, 30, 36, mapa);
        } catch (Exception e) {
            log.error("Test Factura {}", e.toString());
        }
    }

    public void testComprobanteRetencion() {

        String claveAcceso = "0707202207139170166700120010010000868170010699911";

        try {
            Map<String, String> mapa = new HashMap<>();
            Autorizacion autorizacion =Route.getAutorizacion(pathUser + "/recursos/1391701667001-5-001-001-000081168.xml");
            ComprobanteRetencion comprobanteRentecion = Conversion.xmlToPojo(autorizacion.getComprobante(), ComprobanteRetencion.class);

            mapa.put("numeroAutorizacion", autorizacion.getNumeroAutorizacion());
            mapa.put("claveAccesoAutorizacion", claveAcceso);
            mapa.put("fechaAutorizacion", String.valueOf(autorizacion.getFechaAutorizacion()));
            mapa.put("documentoDestino", pathUser + "/recursos/testComprobanteRetension01.pdf");
            mapa.put("pathImagen", pathUser + "/recursos/logoRideHorizontal.png");

            ImpresionElementosComprobanteRetencion impresionElementosComprobanteRetencion = new ImpresionElementosComprobanteRetencion();
            impresionElementosComprobanteRetencion.setComprobanteRetencion(comprobanteRentecion);
            impresionElementosComprobanteRetencion.setOrdenElementos(new int[] { 2, 3, 4, 5, 6});
            ImpresionITextBase impresionBaseIText = new ImpresionITextBase(impresionElementosComprobanteRetencion);
            impresionBaseIText.ejecutar(18, 36, 30, 36, mapa);
        } catch (Exception e) {
            log.error("Test Comprobante {}", e.toString());
        }
    }

    @Test
    public void testNotaDebito() {

        String claveAcceso = "0707202205139170166700120010010000868170010699911";

        try {
            Map<String, String> mapa = new HashMap<>();
            Autorizacion autorizacion = Route.getAutorizacion(pathUser + "/recursos/notaDebito000.xml");
            NotaDebito notaDebito = Conversion.xmlToPojo(autorizacion.getComprobante(), NotaDebito.class);

            mapa.put("numeroAutorizacion", autorizacion.getNumeroAutorizacion());
            mapa.put("claveAccesoAutorizacion", claveAcceso);
            mapa.put("fechaAutorizacion", String.valueOf(autorizacion.getFechaAutorizacion()));
            mapa.put("documentoDestino", pathUser + "/recursos/testNotaDebito01.pdf");
            mapa.put("pathImagen", pathUser + "/recursos/logoRideHorizontal.png");

            ImpresionElementosNotaDebito impresionElementosNotaDebito = new ImpresionElementosNotaDebito();
            impresionElementosNotaDebito.setNotaDebito(notaDebito);
            impresionElementosNotaDebito.setOrdenElementos(new int[] { 2, 3, 4, 5, 6 });
            ImpresionITextBase impresionBaseIText = new ImpresionITextBase(impresionElementosNotaDebito);
            impresionBaseIText.ejecutar(18, 36, 30, 36, mapa);
        } catch (Exception e) {
            log.error("Test Nota Debito {}", e.toString());
        }
    }
}
