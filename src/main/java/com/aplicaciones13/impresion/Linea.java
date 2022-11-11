package com.aplicaciones13.impresion;


import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

import java.util.logging.Level;
import java.util.logging.Logger;

/**Metodo para mostrar una linea.
 *
 * @author omarv omargo33@JeremiasSoft.com
 *
 */
public class Linea extends Elemento {

    float widthPercentage;

    /** Create objecto.
     *
     */
    public Linea() {
        super();
        setWidthPercentage(100);
    }

    /** Escribir objeto.
     *
     */
    public void escribe() {
        try {
            PdfPCell cell = new PdfPCell();
            cell.setBorderWidthLeft(0);
            cell.setBorderWidthTop(0);
            cell.setBorderWidthRight(0);

            PdfPTable table = new PdfPTable(1);
            table.addCell(cell);
            table.setHorizontalAlignment(Element.ALIGN_RIGHT);
            table.setWidthPercentage(getWidthPercentage());
            getDocumento().add(table);

        } catch (DocumentException e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE,
                                                            e.toString());
        }
    }

    /** Escribir objeto.
     *
     */
    public PdfPTable escribeCelda() {
        PdfPCell cell = new PdfPCell();
        cell.setBorderWidthLeft(0);
        cell.setBorderWidthTop(0);
        cell.setBorderWidthRight(0);

        PdfPTable table = new PdfPTable(1);
        table.addCell(cell);
        table.setHorizontalAlignment(Element.ALIGN_RIGHT);
        table.setWidthPercentage(getWidthPercentage());
        return table;
    }

    public float getWidthPercentage() {
        return widthPercentage;
    }

    public void setWidthPercentage(float widthPercentage) {
        this.widthPercentage = widthPercentage;
    }
}
