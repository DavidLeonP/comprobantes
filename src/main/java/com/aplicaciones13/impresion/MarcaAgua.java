package com.aplicaciones13.impresion;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

/** Objeto para generar una marca de agua con el numero de documento.
 *
 */
public class MarcaAgua extends PdfPageEventHelper {
    private static final String TXT_1_1 = "Comprobante Generado en Ambiente de ";
    private String ambiente = "";

    public MarcaAgua(String ambiente) {
        this.ambiente = ambiente;
    }

    @Override
    public void onEndPage(PdfWriter writer, Document document) {
       /* ColumnText.showTextAligned(writer.getDirectContentUnder(),
                                   Element.ALIGN_CENTER,
                                   new Phrase((TXT_1_1 + ambiente).toUpperCase(),
                                              new H3().getFontMarcaAgua()),
                                   297.5f, 421,
                                   writer.getPageNumber() % 2 == 1 ? -45 : 45);*/
    }
}
