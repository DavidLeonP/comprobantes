package com.aplicaciones13.impresion;


import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfPCell;

import java.util.logging.Level;
import java.util.logging.Logger;

/** Metodo para mostrar un titulo
 *
 * @author o.velez@13aplicaciones.com
 *
 */
public class H3 extends Elemento {
    public H3() {
        super();
    }

    public H3(String texto) {
        super();
        setTexto(texto);
    }

    /** Escribir objeto.
     *
     */
    public void escribe() {
        try {
            getDocumento().add(getParagraph());
        } catch (DocumentException e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING,
                                                            e.toString());
        }
    }

    /** Escribir objeto.
     *
     */
    public PdfPCell escribeCelda() {
        PdfPCell pdfPCell = new PdfPCell();
        pdfPCell.addElement(getParagraph());
        pdfPCell.setBorder(0);
        return pdfPCell;
    }

    @Override
    public void setTexto(String texto) {
        super.setTexto(texto);
        getFontTitulos().setSize(9);
        getFontTitulos().setStyle(Font.NORMAL);
        setParagraph(getTexto(), getFontTitulos());
    }
}
