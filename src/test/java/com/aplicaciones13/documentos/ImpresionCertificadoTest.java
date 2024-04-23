/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplicaciones13.documentos;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

import com.aplicaciones13.documentos.impresion.elementos.presentacion.CenefaEstructura;
import com.aplicaciones13.documentos.impresion.ensamble.ImpresionITextBase;
import com.aplicaciones13.documentos.impresion.ensamble.certificado.ImpresionElementosCertificado;

/**
 *
 * @author omarv
 */
public class ImpresionCertificadoTest {

    /**
     * Test of elemento2 method, of class ImpresionElementosCertificado.
     */
    @Test
    public void testCertificado() {
        String pathUser = System.getProperty("user.dir");
 
        try {
            Map<String, String> mapa = new HashMap<>();
            //Datos socios
            mapa.put("nombre", "VELEZ BAYAS OMAR ANTONIO");
            mapa.put("tipoIdentificacion", "C.I.");
            mapa.put("identificacion", "0102581709");
            mapa.put("fechaSocio", "27 de Noviembre de 2007");
            mapa.put("fechaEmision", "06 Agosto de 2020");            
            //Datos estadoCuenta
            mapa.put("fechaPeriodo", "06 Agosto de 2020");
            mapa.put("saldoDisponible", "600");
            mapa.put("saldoBloqueado", "500.13");
            mapa.put("saldoTotal", "1000.23");
            //Datos requeridos
            mapa.put("documentoSucursal", "Cuenca");
            mapa.put("documentoCodigo", "0102581709");
            mapa.put("documentoNombre", "Certificad con firma");
            mapa.put("documentoDestino", pathUser +"/recursos/testCertificado.pdf");
            mapa.put("documentoURL", "https://itextpdf.com/en/resources/examples/itext-7/repeating-rows");
            mapa.put("sitioWeb", "https://www.jardinazuayo.fin.ec");
            mapa.put("documentoValidez", "06 Noviembre de 2020");
            mapa.put("documentoPie", pathUser +"/recursos/pie.png");
            mapa.put("documentoEncabezado", pathUser +"/recursos/encabezado.png");
            mapa.put("documentoArchivoP12", pathUser +"/recursos/data.xml");
            mapa.put("documentoArchivoP12Clave", "Admin1234s");
            mapa.put("cuerpo", "texto para probar \n y probar el salto de pagina");

            CenefaEstructura cenefaEstructuraSuperior = new CenefaEstructura(false, true, false, false, false, mapa.get("documentoEncabezado"));
            CenefaEstructura cenefaEstructuraInferior = new CenefaEstructura(false, true, false, false, false, mapa.get("documentoPie"));

            ImpresionElementosCertificado impresionCertificado = new ImpresionElementosCertificado();
            impresionCertificado.setOrdenElementos(new int[]{ 2, 1, 0});
          
            ImpresionITextBase impresionBaseIText = new ImpresionITextBase(impresionCertificado);
            impresionBaseIText.setCenefaEstructuraSuperior(cenefaEstructuraSuperior);
            impresionBaseIText.setCenefaEstructuraInferior(cenefaEstructuraInferior);
            impresionBaseIText.ejecutar(18, 36, 30, 36, mapa);
        } catch (Exception e) {            
            System.err.println("data " + e.toString());
        }
    }
}
