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
     *  Metodo para iniciar el test de ImpresionElementosCertificadoTest.
     */
    public ImpresionCertificadoTest() {
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
            mapa.put("documentoCodigo", "IKM7450");
            mapa.put("documentoNombre", "Certificad de ser Socio");
            mapa.put("documentoDestino", "/home/colaborador/test.pdf");
            mapa.put("documentoURL", "https://itextpdf.com/en/resources/examples/itext-7/repeating-rows");
            mapa.put("sitioWeb", "https://www.jardinazuayo.fin.ec");
            mapa.put("documentoValidez", "06 Noviembre de 2020");
            //mapa.put("documentoPie", "/mnt/documentos/logosCooperativa/membreteInferior_2239x209.png");
            //mapa.put("documentoEncabezado", "/mnt/documentos/logosCooperativa/membreteSuperior_2239x209.png");
            //mapa.put("documentoArchivoP12", "/mnt/documentos/pi16001-core/llave.p12");
            //mapa.put("documentoArchivoP12Clave", "Admin1234s");
            mapa.put("cuerpo", "texto para probar \n y probar el salto de pagina");

            //CenefaEstructura cenefaEstructuraSuperior = new CenefaEstructura(false, true, false, false, false, mapa.get("documentoEncabezado"));
            CenefaEstructura cenefaEstructuraInferior = new CenefaEstructura(false, true, false, false, false, mapa.get("documentoPie"));

            ImpresionElementosCertificado impresionCertificado = new ImpresionElementosCertificado();
            impresionCertificado.setOrdenElementos(new int[]{ 2, 1, 0});
          
            ImpresionITextBase impresionBaseIText = new ImpresionITextBase(impresionCertificado);
            //impresionBaseIText.setCenefaEstructuraSuperior(cenefaEstructuraSuperior);
            //impresionBaseIText.setCenefaEstructuraInferior(cenefaEstructuraInferior);
            impresionBaseIText.ejecutar(18, 36, 30, 36, mapa);
        } catch (Exception e) {            
            System.err.println("data " + e.toString());
        }
    }
}
