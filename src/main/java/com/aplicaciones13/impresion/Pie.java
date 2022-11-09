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


public class Pie extends PdfPageEventHelper {

    private String TXT_PIE_1 = "No.: %s Creado: %s P\u00e1g.: %s de";

    private int pagenumber = 1;
    private String numeroDocumento;
    private String nombreDocumento;

    PdfTemplate total;

    public Pie(String nombreDocumento) {
        super();
        setNumeroDocumento("");
        this.nombreDocumento = nombreDocumento;
    }

    /** Metodo para incrementar los numeros de pagina
     *
     * @param writer
     * @param document
     */
    @Override
    public void onStartPage(PdfWriter writer, Document document) {
        pagenumber++;
    }

    /** Metodo para poner el numero de la pagina.
     *
     * @param writer
     * @param document
     */
    @Override
    public void onEndPage(PdfWriter writer, Document document) {

        String mensaje = String.format(TXT_PIE_1, getNumeroDocumento(), FechasFormato.nowFormat(), pagenumber);

        Rectangle rect = writer.getBoxSize(ImpresionBaseIText.BOX_SIZE_NOMBRE);
        ColumnText.showTextAligned(writer.getDirectContentUnder(), Element.ALIGN_LEFT,
                                   new Phrase(this.nombreDocumento, new P().getFontDatos()), rect.getLeft(),
                                   rect.getBottom() - 26, 0);

        if (total == null)
            total = writer.getDirectContent().createTemplate(30, 16);

        try {
            PdfPTable table = new PdfPTable(2);
            table.setTotalWidth(500);
            table.setWidths(new float[] { 250, 267 });
            table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);

            P p = new P();
            p.setTexto(mensaje);
            PdfPCell cell_1 = new PdfPCell(p.getParagraph());
            cell_1.setBorder(PdfPCell.NO_BORDER);
            table.addCell(cell_1);

            PdfPCell cell_2 = new PdfPCell(Image.getInstance(total));
            cell_2.setBorder(PdfPCell.NO_BORDER);
            table.addCell(cell_2);
            table.writeSelectedRows(0, -1, rect.getLeft() - 2, rect.getBottom() - 26, writer.getDirectContent());
        } catch (Exception e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, e.toString());
        }
    }

    @Override
    public void onOpenDocument(PdfWriter writer, Document document) {
        total = writer.getDirectContent().createTemplate(30, 16);
    }

    @Override
    public void onCloseDocument(PdfWriter writer, Document document) {
        ColumnText.showTextAligned(total, Element.ALIGN_RIGHT,
                                   new Phrase((writer.getPageNumber() - 1) + "", new P().getFontDatos()), 6, 6, 0);
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

}
