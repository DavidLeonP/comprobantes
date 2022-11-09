package com.aplicaciones13.impresion;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfPCell;

/**Metodo para mostrar un titulo
 *
 * @author omarv omargo33@JeremiasSoft.com
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
            // MainFiles.escribirLogDefault(this.getClass().getName(),
            //                            ".escribe()", e.toString());
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

    public void setTexto(String texto) {
        super.setTexto(texto.toUpperCase());
        getFontTitulos().setSize(12);
        getFontTitulos().setStyle(Font.NORMAL);
        setParagraph(getTexto(), getFontTitulos());
    }
}
