package com.aplicaciones13.sri.contenedores;


import java.math.BigDecimal;

/** Objeto para soportar los totales de los documentos.
 *
 * @author o.velez@13aplicaciones.com
 *
 */
public class TotalDocumento {
    private String titulo;
    private BigDecimal valor;

    /** Metodo para generar el objeto.
     *
     */
    public TotalDocumento() {
        super();
        setTitulo("");
        setValor(new BigDecimal(0));
    }

    //Propiedades

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
