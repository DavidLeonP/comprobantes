package com.aplicaciones13.documentos.impresion.ensamble;

import com.aplicaciones13.documentos.impresion.elementos.texto.Elemento;
import com.aplicaciones13.documentos.impresion.elementos.presentacion.Espacio;
import com.aplicaciones13.documentos.impresion.elementos.presentacion.Linea;
import com.aplicaciones13.documentos.impresion.elementos.texto.Titulo;
import com.aplicaciones13.documentos.utilidades.BundleMessages;
import com.aplicaciones13.documentos.impresion.elementos.texto.P;
import com.aplicaciones13.documentos.impresion.elementos.imagen.ImagenCodigoQR;
import com.aplicaciones13.documentos.impresion.elementos.imagen.Imagen;
import com.aplicaciones13.documentos.impresion.elementos.compuestos.Panel;
import com.aplicaciones13.documentos.impresion.elementos.compuestos.Form;
import com.aplicaciones13.documentos.impresion.elementos.compuestos.Tabla;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.property.TextAlignment;
import java.util.HashMap;
import java.util.Map;
import com.itextpdf.layout.element.Table;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * Clase base para la generación de elementos.
 *
 *
 * @author omargo33
 *
 */
@Slf4j
@Data
public class ImpresionElementosBase {

    /**
     * Elemento para generar los mensajes.
     */
    private static BundleMessages bundle = new BundleMessages("elementos-base");

    private float margenSuperiorOriginal;
    private int[] ordenElementos;
    
    private Document documento;
    private Espacio espacio;
    private Form form;
    private Imagen imagen;
    private ImagenCodigoQR imagenCodigoQR;
    private Linea lineaPunteada;
    private Linea lineaSolida;
    private Map<String, String> parametrosBusqueda;
    private P nota;
    private P p;
    private P texto;
    private Panel panel;
    private PdfWriter pdfWriter;
    private Tabla tabla;
    private Titulo h1;
    private Titulo h2;
    private Titulo h3;

    /**
     * Metodo para crear el objeto.
     *
     */
    public ImpresionElementosBase() {
        init();
    }

    /**
     * Metodo para inicialiar el objeto.
     *
     */
    private void init() {
        setMargenSuperiorOriginal(0f);
        setEspacio(new Espacio() {
            @Override
            public Document getDocumento() {
                return getDocumentoPadre();
            }
        });

        setP(new P(P.PARRAFO ) {
            @Override
            public Document getDocumento() {
                return getDocumentoPadre();
            }
        });

        setTexto(new P(P.TEXTO) {
            @Override
            public Document getDocumento() {
                return getDocumentoPadre();
            }
        });

        setNota(new P(P.NOTA) {
            @Override
            public Document getDocumento() {
                return getDocumentoPadre();
            }
        });

        setH1(new Titulo(Titulo.H1) {
            @Override
            public Document getDocumento() {
                return getDocumentoPadre();
            }
        });

        setH2(new Titulo(Titulo.H2) {
            @Override
            public Document getDocumento() {
                return getDocumentoPadre();
            }
        });

        setH3(new Titulo(Titulo.H3) {
            @Override
            public Document getDocumento() {
                return getDocumentoPadre();
            }
        });

        setLineaSolida(new Linea(Linea.LINEA_SOLIDA) {
            @Override
            public Document getDocumento() {
                return getDocumentoPadre();
            }
        });

        setLineaPunteada(new Linea(Linea.LINEA_PUNTEADA) {
            @Override
            public Document getDocumento() {
                return getDocumentoPadre();
            }
        });

        setImagen(new Imagen() {
            @Override
            public Document getDocumento() {
                return getDocumentoPadre();
            }
        });

        setImagenCodigoQR(new ImagenCodigoQR() {
            @Override
            public Document getDocumento() {
                return getDocumentoPadre();
            }
        });

        setForm(new Form() {
            @Override
            public Document getDocumento() {
                return getDocumentoPadre();
            }
        });

        setTabla(new Tabla() {
            @Override
            public Document getDocumento() {
                return getDocumentoPadre();
            }
        });

        setPanel(new Panel() {
            @Override
            public Document getDocumento() {
                return getDocumentoPadre();
            }
        });

        setParametrosBusqueda(new HashMap<>());
        setPdfWriter(null);
    }

    /**
     * @return
     */
    public Document getDocumentoPadre() {
        return this.documento;
    }

    /**
     * Escribir los datos en el documento.
     *
     * Fija los tamaños de la hoja Fija los marjenes de la hoja Fija el
     * encabezado y pie de pagina membretado. Pone el titulo del documento.
     *
     * Lla los elementos a ser impresos.
     *
     */
    public void escribir() {
        for (int i = 0; i < ordenElementos.length; i++) {
            imprimirElemento(ordenElementos[i]);
        }
    }

    /**
     * Metod para imprimir los elementos en el orden solicitado.
     *
     * @param valor
     */
    public void imprimirElemento(int valor) {

        switch (valor) {
            case 0:
                elemento0();
                break;
            case 1:
                elemento1();
                break;

            case 2:
                elemento2();
                break;

            case 3:
                elemento3();
                break;

            case 30:
                elemento30();
                break;

            case 4:
                elemento4();
                break;

            case 5:
                elemento5();
                break;
            case 6:
                elemento6();
                break;
            case 7:
                elemento7();
                break;
            default:
                log.warn(".imprimirElemento() elemento no exite {} ", valor);
        }
    }

    /**
     * Metodo para imprimir el elemento 0.
     *
     * El elemento 0 es para calcular el espacio de firma y un salto de pagina
     * para que se ve en espacio correcto.
     *
     */
    public synchronized void elemento0() {
        if (getCurrentPosition().getY() < 120) {
            getDocumento().add(new AreaBreak());
        }
        getLineaSolida().escribir();
        getH3().setTexto(bundle.getMessage("txt_000_01"));
        getH3().escribir();
    }

    /**
     * Metodo para imprimir el elemento 1.
     *
     * Datos de scaneo y documentacion electronica.
     *
     */
    public synchronized void elemento1() {
        if (getCurrentPosition().getY() < 150) {
            getDocumento().add(new AreaBreak());
        }
        getH3().setTexto(bundle.getMessage("txt_000_02"));
        getH3().escribir();

        getForm().setListaTitulos(
                bundle.getMessage("txt_000_03"),
                bundle.getMessage("txt_000_04"),
                bundle.getMessage("txt_000_05"));
        getForm().setListaValores(getParametrosBusqueda().get("documentoCodigo"),
                getParametrosBusqueda().get("sitioWeb"),
                bundle.getMessage("txt_000_07", getParametrosBusqueda().get("documentoValidez")));

        getForm().setListaDimensiones(10f, 90f);
        getForm().setListaFormatos(Elemento.FORMATO_STRING, Elemento.FORMATO_STRING, Elemento.FORMATO_STRING);
        getForm().procesar();

        escribirQR(getForm().getTabla());
    }

    /**
     * Metodo para escribir codigo QR
     *
     * @param table
     */
    public void escribirQR(Table table) {
        getImagenCodigoQR().setAncho(55f);
        getImagenCodigoQR().getTexto().setText((String) getParametrosBusqueda().get("documentoURL"));
        getImagenCodigoQR().procesar();

        Cell cell = new Cell();
        Border bol = new SolidBorder(30f);
        cell.setBorder(bol);
        cell.add(getImagenCodigoQR().getImagen());

        getPanel().setListaDimensiones(10f, 90f);
        getPanel().getMapaAlineamiento().put(1, TextAlignment.CENTER);
        getPanel().getMapaAlineamiento().put(2, TextAlignment.RIGHT);
        getPanel().setListaCeldas(cell, table);
        getPanel().procesarEscribir();
    }

    /**
     * Metodo para imprimier mensaje de atentamente.
     *
     */
    public void imprimirAtentamente() {
        if (getCurrentPosition().getY() < 280) {
            getDocumento().add(new AreaBreak());
        }
        getEspacio().escribir(3);
        getP().setTexto(bundle.getMessage("txt_001_05",
                getParametrosBusqueda().get("documentoSucursal"),
                getParametrosBusqueda().get("fechaEmision")));
        getP().escribir();

        getEspacio().escribir(4);
        getP().setTexto(bundle.getMessage("txt_001_06"));
        getP().escribir();

        getP().setTexto(bundle.getMessage("txt_001_07"));
        getP().escribir();

        getEspacio().escribir(2);
        getLineaSolida().escribir();
    }

    /**
     * Metodo para imprimir el elemento 2.
     *
     */
    public synchronized void elemento2() {
        log.warn(".elemento2()");
    }

    /**
     * Metodo para imprimir el elemento 3.
     *
     */
    public synchronized void elemento3() {
        log.warn(".elemento3()");
    }

    /**
     * Metodo para imprimir el elemento 3.
     *
     */
    public synchronized void elemento30() {
        log.warn(".elemento30()");
    }

    /**
     * Metodo para imprimir el elemento 4.
     *
     */
    public synchronized void elemento4() {
        log.warn(".elemento4()");
    }

    /**
     * Metodo para imprimir el elemento 5.
     *
     */
    public synchronized void elemento5() {
        log.warn(".elemento5()");
    }

    /**
     * Metodo para imprimir el elemento 6.
     *
     */
    public synchronized void elemento6() {
        log.warn(".elemento6()");
    }

    /**
     * Metodo para imprimir el elemento 6.
     *
     */
    public synchronized void elemento7() {
        log.warn(".elemento7()");
    }

    /**
     * @param documento
     */
    public void setDocumento(Document documento) {
        this.documento = documento;
        init();
    }

    public CurrentPosition getCurrentPosition() {
        return new CurrentPosition();
    }

    /**
     * Clase para contener la posicion current dentro de la escritura del
     * sistema.
     *
     *
     *
     * @author omargo33
     *
     */
    @Data
    @ToString
    protected class CurrentPosition {

        private final float ancho;
        private final float x;
        private final float y;
        private final int pagina;

        /**
         * Metodo para crear la posicion inicial.
         * 
         */
        public CurrentPosition() {
            x = getDocumento().getRenderer().getCurrentArea().getBBox().getX();
            float yAreaEscribible = getDocumento().getRenderer().getCurrentArea().getBBox().getY();
            float topMargenEncabezado = getDocumento().getRenderer().getCurrentArea().getBBox().getTop();
            y = topMargenEncabezado - yAreaEscribible + margenSuperiorOriginal;
            pagina = getDocumento().getRenderer().getCurrentArea().getPageNumber();
            ancho = 500f;
        }        
    }
}
