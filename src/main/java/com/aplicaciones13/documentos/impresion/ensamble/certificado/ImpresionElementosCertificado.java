package com.aplicaciones13.documentos.impresion.ensamble.certificado;

import com.aplicaciones13.documentos.impresion.elementos.texto.P;
import com.aplicaciones13.documentos.impresion.ensamble.ImpresionElementosBase;
import com.aplicaciones13.documentos.utilidades.Bundle;
import com.itextpdf.layout.Document;

/**
 * Objeto con los datos de impresiones certificado de socio.
 *
 * @author Omar Velez o.velez@jardinazuayo.fin.ec
 *
 */
public class ImpresionElementosCertificado extends ImpresionElementosBase {
    private final String SALTO_PAGINA = "\n";

    Bundle bundle = new Bundle("elementos-certificado");

    P pTitulos;

    /**
     * Metodo para crear el objeto.
     *
     */
    public ImpresionElementosCertificado() {
        super();
        pTitulos = new P(P.TEXTO);

        pTitulos = new P(P.PARRAFO) {
            @Override
            public Document getDocumento() {
                return getDocumentoPadre();
            }
        };

    }

    /**
     * Imprime el primer elemento 2.
     * 
     * Imprime una linea solida.
     * Deja 4 espacios
     * Imprime "la peticion verbal de certificado"
     * Titulo Certifica
     * Se escribe el cuerpo.
     * Imprime "en honor a la verdad"
     * Imprime "Atentamente"
     */
    @Override
    public synchronized void elemento2() {
        getLineaSolida().escribir();
        getEspacio().escribir(4);

        getP().setTexto(bundle.getMessage("txt_001_02"));
        getP().escribir();
        getEspacio().escribir(2);

        getH2().setTextoCentro(bundle.getMessage("txt_001_03"));
        getH2().escribir();
        getEspacio().escribir(2);

        String cuerpo = String.valueOf(getParametrosBusqueda().get("cuerpo"));
        String[] lineas = cuerpo.split(SALTO_PAGINA);
        for (String linea : lineas) {
            agregarParrafo(linea);            
        }
        getEspacio().escribir(3);

        getP().setTexto(bundle.getMessage("txt_001_04"));
        getP().escribir();

        imprimirAtentamente();
    }

    /**
     * Metodo para separar el titulo de la descripcion.
     * 
     * En caso de que no se espere negritas se imprime normalmente.
     * 
     * Para que se haga efecto la impresion en negrita debe ser de la forma:
     * 
     * [Titulo:] descripcion de la linea
     * 
     * @param titulo
     */
    private void agregarParrafo(String texto) {
        if (texto != null && !texto.isEmpty()) {
            texto=texto.trim();
            if (texto.startsWith("[")) {
                String titulo = texto.substring(1, texto.indexOf("]"));
                String descripcion = texto.substring(texto.indexOf("]") + 1);
                pTitulos.addTexto(titulo, descripcion);                
                pTitulos.escribir();
                pTitulos.setParagraph("");                
            } else {
                getP().setTexto(texto);
                getP().escribir();
            }
        }
    }
}