package com.aplicaciones13.impresion;


import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfPCell;

import java.util.logging.Level;
import java.util.logging.Logger;


/**Metodo para mostrar un titulo
 *
 * @author o.velez@13aplicaciones.com
 *
 */
public class H1 extends Elemento {

    public H1() {
        super();
    }

    public H1(String texto) {
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

    /** Escribir objeto en una celda.
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
        super.setTexto(texto.toUpperCase());
        getFontTitulos().setSize(14);
        getFontTitulos().setStyle(Font.BOLD);
        setParagraph(getTexto(), getFontTitulos());
    }
}
