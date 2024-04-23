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
import com.aplicaciones13.documentos.estructuras.factura.v2_1_0.Factura;
import com.aplicaciones13.documentos.impresion.ensamble.ImpresionITextBase;
import com.aplicaciones13.documentos.impresion.ensamble.ride.ImpresionElementosFactura;
import com.aplicaciones13.documentos.utilidades.Conversion;

import lombok.extern.slf4j.Slf4j;

import java.io.File;

/**
 *
 * @author omargo33
 */
@Slf4j
class ImpresionDocumentosTest {

    /**
     * Test of factura
     */
    @Test
    void testFactura() {
        String pathUser = System.getProperty("user.dir");
        String claveAcceso="1312202301179001691900122011070002060400460006816";
        String ambiente= claveAcceso.substring(23, 24);
        String emision= claveAcceso.substring(47, 48);
        try {
            Map<String, String> mapa = new HashMap<>();
            File documentoXml = new File(pathUser + "/recursos/facturaAutorizacion.xml");
            Autorizacion autorizacion = Conversion.xmlToPojo(documentoXml, Autorizacion.class);
            Factura factura = Conversion.xmlToPojo(autorizacion.getComprobante(), Factura.class);

            mapa.put("numeroAutorizacion", autorizacion.getNumeroAutorizacion());
            mapa.put("ambienteAutorizacion", ambiente);
            mapa.put("emisionAutorizacion", emision);
            mapa.put("claveAccesoAutorizacion", claveAcceso);
            mapa.put("fechaAutorizacion", autorizacion.getFechaAutorizacion());
            mapa.put("documentoDestino", pathUser + "/recursos/testFactura.pdf");
            mapa.put("pathImagen", pathUser + "/recursos/13aplicaciones.png");

            ImpresionElementosFactura impresionFactura = new ImpresionElementosFactura();
            impresionFactura.setFactura(factura);
            impresionFactura.setOrdenElementos(new int[] { 2, 3, 4, 5, 6, 7, 8 });            
            ImpresionITextBase impresionBaseIText = new ImpresionITextBase(impresionFactura);
            impresionBaseIText.ejecutar(18, 36, 30, 36, mapa);
        } catch (Exception e) {
            log.error("Test Factura {}", e.toString());
        }
    }
}
