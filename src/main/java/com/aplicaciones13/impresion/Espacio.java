package com.aplicaciones13.impresion;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPCell;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase para imprimir un espacio
 *
 * @author o.velez@13aplicaciones.com
 *
 */
public class Espacio extends Elemento {

    public Espacio() {
        super();
    }

    /**
     * Imprime un espacio en el reporte.
     *
     */
    public void escribe() {
        try {
            super.setTexto(" ");
            getFontDatos().setSize(4);
            setParagraph(getTexto(), getFontDatos());
            getDocumento().add(getParagraph());
        } catch (DocumentException e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING,
                    e.toString());
        }
    }

    /**
     * Imprime una celda en blanco.
     *
     */
    public PdfPCell escribeCelda() {
        setParagraph(" ", getFontDatos());
        PdfPCell pdfPCeld = new PdfPCell();
        pdfPCeld.addElement(getParagraph());
        pdfPCeld.setBorder(0);
        return pdfPCeld;
    }
}
