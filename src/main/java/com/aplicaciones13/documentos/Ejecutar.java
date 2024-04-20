package com.aplicaciones13.documentos;

import com.aplicaciones13.documentos.estruturas.factura.v2_1_0.Factura;
import com.aplicaciones13.documentos.impresion.ensamble.ImpresionITextBase;
import com.aplicaciones13.documentos.impresion.ensamble.ride.ImpresionElementosFactura;
import com.aplicaciones13.documentos.utilidades.Conversion;

import java.util.HashMap;
import java.util.Map;

import java.io.File;

public class Ejecutar {

    public static void main(String[] args) {
        try {
            Map<String, String> mapa = new HashMap<>();
            //Datos socios
            mapa.put("numeroAutorizacion", "012345678901234567890123456 789012345678901234567890");
            mapa.put("ambienteAutorizacion", "PRUEBAS");
            mapa.put("emisionAutorizacion", "2020-08-06");
            mapa.put("claveAccesoAutorizacion", "121321564156145643213524564321654516513215");
            mapa.put("fechaAutorizacion", "2020-08-06");
            mapa.put("documentoDestino", "/home/ovelez/testFactura.pdf");
            mapa.put("pathImagen", "/home/ovelez/Documentos/clientes/13Aplicaciones/hostWeb/site/imagenes/goDaddy/13_512x512.png");
            
            ImpresionElementosFactura impresionFactura = new ImpresionElementosFactura();


            File documentoXml = new File("/home/ovelez/Descargas/001-001-000025979.xml");

            Factura factura = Conversion.obtenerDocumentoParseado(documentoXml, Factura.class);

            impresionFactura.setFactura(factura);

            impresionFactura.setOrdenElementos(new int[]{2});
            ImpresionITextBase impresionBaseIText = new ImpresionITextBase(impresionFactura);
            impresionBaseIText.ejecutar(18, 36, 30, 36, mapa);
        } catch (Exception e) {            
            System.err.println("data " + e.toString());
        }
    }

}
