package com.aplicaciones13.documentos.impresion.ensamble.ride;


import java.math.BigDecimal;

import lombok.Data;

/** Objeto para soportar los totales de los documentos.
 *
 * @author omargo33
 *
 */
@Data
public class TotalDocumentoFactura {
    private String titulo;
    private BigDecimal valor;

    /** Metodo para generar el objeto.
     *
     */
    public TotalDocumentoFactura() {
        super();
        setTitulo("");
        setValor(new BigDecimal(0));
    }
}
