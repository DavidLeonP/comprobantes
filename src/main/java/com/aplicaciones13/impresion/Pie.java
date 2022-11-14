package com.aplicaciones13.impresion;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;

import com.aplicaciones13.utilidades.FechasFormato;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Objeto para crear el Pie de documentos.
 * 
 * @author o.velez@13aplicaciones.com
 * 
 */
public class Pie extends PdfPageEventHelper {

    private static final String TXT_PIE_1 = "Creado: %s P\u00e1g.: %s de";
    private int pageNumber = 1;
    PdfTemplate total;

    /**
     * Metodo para crear el pie de pagina.
     */
    public Pie() {
        super();
    }

    /**
     * Metodo para incrementar los numeros de pagina
     *
     * @param writer
     * @param document
     */
    @Override
    public void onStartPage(PdfWriter writer, Document document) {
        pageNumber++;
    }

    /**
     * Metodo para poner el numero de la pagina.
     *
     * @param writer
     * @param document
     */
    @Override
    public void onEndPage(PdfWriter writer, Document document) {
        String mensaje = String.format(TXT_PIE_1, FechasFormato.nowFormat(), pageNumber);
        Rectangle rect = writer.getBoxSize(ImpresionBaseIText.BOX_SIZE_NOMBRE);

        if (total == null)
            total = writer.getDirectContent().createTemplate(40, 16);

        try {
            PdfPTable table = new PdfPTable(2);
            table.setTotalWidth(500);
            table.setWidths(new float[] { 112, 267 });
            table.getDefaultCell().setBorder(Rectangle.NO_BORDER);

            P p = new P();
            p.setTexto(mensaje);
            PdfPCell cell1 = new PdfPCell(p.getParagraph());
            cell1.setBorder(Rectangle.NO_BORDER);
            table.addCell(cell1);

            PdfPCell cell2 = new PdfPCell(Image.getInstance(total));
            cell2.setBorder(Rectangle.NO_BORDER);
            table.addCell(cell2);

            table.writeSelectedRows(0, -1, rect.getLeft() - 2, rect.getBottom() - 26, writer.getDirectContent());
        } catch (Exception e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING, e.toString());
        }
    }

    /**
     * Metodo para abrir el documento.
     * 
     * @param writer
     * @param document
     */
    @Override
    public void onOpenDocument(PdfWriter writer, Document document) {
        total = writer.getDirectContent().createTemplate(40, 16);
    }

    /**
     * Metodo para cerrar el documento.
     * 
     * @param writer
     * @param document
     */
    @Override
    public void onCloseDocument(PdfWriter writer, Document document) {
        String totalPaginas = String.valueOf(writer.getPageNumber() - 1);        
        float largototal = (totalPaginas.length() * 4.50f);
        ColumnText.showTextAligned(total, Element.ALIGN_RIGHT,
                new Phrase(totalPaginas, new P().getFontDatos()), largototal, 6.00f, 0);

    }
}
