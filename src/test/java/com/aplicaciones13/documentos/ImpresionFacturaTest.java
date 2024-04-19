/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplicaciones13.documentos;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

import com.aplicaciones13.documentos.impresion.ensamble.ImpresionITextBase;
import com.aplicaciones13.documentos.impresion.ensamble.ride.ImpresionElementosFactura;

/**
 *
 * @author omarv
 */
public class ImpresionFacturaTest {

    
    /**
     *  Metodo para iniciar el test de ImpresionElementosCertificadoTest.
     */
    public ImpresionFacturaTest() {
        //No requiere para este ejercicio
    }

    /**
     * Test of elemento2 method, of class ImpresionElementosCertificado.
     */
    @Test
    public void testelemento2() { 
        try {
            Map<String, String> mapa = new HashMap<>();
            //Datos socios
            mapa.put("numeroAutorizacion", "121321564156145643213524564321654516513215");
            mapa.put("ambienteAutorizacion", "PRUEBAS");
            mapa.put("emisionAutorizacion", "2020-08-06");
            mapa.put("claveAccesoAutorizacion", "121321564156145643213524564321654516513215");
            mapa.put("fechaAutorizacion", "2020-08-06");
            mapa.put("documentoDestino", "/home/colaborador/testFactura.pdf");
            
            ImpresionElementosFactura impresionFactura = new ImpresionElementosFactura();

            //impresionFactura.setFactura(null);

            impresionFactura.setOrdenElementos(new int[]{3});
            ImpresionITextBase impresionBaseIText = new ImpresionITextBase(impresionFactura);
            impresionBaseIText.ejecutar(18, 36, 30, 36, mapa);
        } catch (Exception e) {            
            System.err.println("data " + e.toString());
        }
    }
}
