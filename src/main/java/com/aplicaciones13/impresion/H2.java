package com.aplicaciones13.impresion;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfPCell;

/**Metodo para mostrar un titulo
 *
 * @author o.velez@13aplicaciones.com
 *
 */
public class H2 extends Elemento {
    public H2() {
        super();
    }

    public H2(String texto) {
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
        PdfPCell pdfPCeld = new PdfPCell();
        pdfPCeld.addElement(getParagraph());
        pdfPCeld.setBorder(0);
        return pdfPCeld;
    }

    @Override
    public void setTexto(String texto) {
        super.setTexto(texto.toUpperCase());
        getFontTitulos().setSize(12);
        getFontTitulos().setStyle(Font.NORMAL);
        setParagraph(getTexto(), getFontTitulos());
    }
}
