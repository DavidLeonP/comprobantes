package com.aplicaciones13.sri.contenedores;

/** Objeto para tener la tablas del SRI.
 *
 * @author omar velez omargo33@jeremiassoft.com
 *
 */
public class TablasSRI {

    private static String TAB_IVA = "IVA";
    private static String TAB_ICE = "ICE";
    private static String TAB_CERO = "0%";
    private static String TAB_12 = "12%";
    private static String TAB_NO_IMPUESTO = "No Objeto de impuesto";

    /** Metodo para crear el objeto.
     *
     */
    public TablasSRI() {
        super();
    }

    /** Metodo de la tabla 15.
     *
     * @param codigo
     * @return
     */
    public static String Tabla15(String codigo) {
        codigo = (codigo == null) ? "" : codigo;

        if (codigo.compareTo("2") == 0)
            return TAB_IVA;

        if (codigo.compareTo("3") == 0)
            return TAB_ICE;

        return "";
    }

    /** Metodo con la tablas 16 y 17 conjugados.
     *
     * @param codigo
     * @param codigoPorcentaje
     * @return
     */
    public static String Tabla16_17(String codigo, String codigoPorcentaje) {
        codigo = (codigo == null) ? "" : codigo;

        if ((codigo + "-" + codigoPorcentaje).compareTo("2-0") == 0)
            return TAB_CERO;

        if ((codigo + "-" + codigoPorcentaje).compareTo("2-2") == 0)
            return TAB_12;

        if ((codigo + "-" + codigoPorcentaje).compareTo("2-6") == 0)
            return TAB_NO_IMPUESTO;

        if (codigo.compareTo("3") == 0)
            return TAB_ICE + "" + codigoPorcentaje;

        return "";
    }


    /**Metodo que permite generar la tabla 4.
     *
     */
    public static String Tabla4(String codigo) {
        codigo = (codigo == null) ? "" : codigo;

        if (codigo.compareTo("01") == 0)
            return "FACTURA";
        if (codigo.compareTo("03") == 0)
            return "LIQUIDACION DE COMPRA";
        if (codigo.compareTo("04") == 0)
            return "NOTA DE CREDITO";
        if (codigo.compareTo("05") == 0)
            return "NOTA DE DEBITO";
        if (codigo.compareTo("06") == 0)
            return "GUIA DE REMISION";
        if (codigo.compareTo("07") == 0)
            return "COMPROBANTE DE RETENCION";
        return "";
    }


    /**Metodo que permite generar la tabla 18.
     *
     */
    public static String Tabla18(String codigo) {
        codigo = (codigo == null) ? "" : codigo;

        if (codigo.compareTo("1") == 0)
            return "RENTA";
        if (codigo.compareTo("2") == 0)
            return "IVA";
        if (codigo.compareTo("6") == 0)
            return "ISD";
        return "";
    }

    /**Metodo que permite generar la tabla 19.
     *
     */
    public static String Tabla19(String codigo) {
        codigo = (codigo == null) ? "" : codigo;

        if (codigo.compareTo("1") == 0)
            return "IVA 30%";

        if (codigo.compareTo("2") == 0)
            return "IVA 70%";

        if (codigo.compareTo("3") == 0)
            return "IVA 100%";
        
        if (codigo.compareTo("9") == 0)
            return "IVA 10%";
        
        if (codigo.compareTo("10") == 0)
            return "IVA 20%";

        if (codigo.compareTo("4580") == 0)
            return "ISD 5%";


        if (codigo.compareTo("303") == 0)
            return "303  HONORARIOS PROFESIONALES Y DEMAS PAGOS POR SERVICIOS RELACIONADOS CON EL TITULO PROFESIONAL";
        if (codigo.compareTo("304") == 0)
            return "304  SERVICIOS PREDOMINA EL INTELECTO NO RELACIONADOS CON EL TITULO PROFESIONAL";
        if (codigo.compareTo("304A") == 0)
            return "304A  COMISIONES Y DEMAS PAGOS POR SERVICIOS PREDOMINA INTELECTO NO RELACIONADOS CON EL TITULO PROFESIONAL";
        if (codigo.compareTo("304B") == 0)
            return "304B  PAGOS A NOTARIOS Y REGISTRADORES DE LA PROPIEDAD Y MERCANTIL POR SUS ACTIVIDADES EJERCIDAS COMO TALES";
        if (codigo.compareTo("304C") == 0)
            return "304C  PAGOS A DEPORTISTAS, ENTRENADORES, ARBITROS, MIEMBROS DEL CUERPO TECNICO POR SUS ACTIVIDADES EJERCIDAS COMO TALES";
        if (codigo.compareTo("304D") == 0)
            return "304D  PAGOS A ARTISTAS POR SUS ACTIVIDADES EJERCIDAS COMO TALES";
        if (codigo.compareTo("304E") == 0)
            return "304E  HONORARIOS Y DEMAS PAGOS POR SERVICIOS DE DOCENCIA";
        if (codigo.compareTo("307") == 0)
            return "307  SERVICIOS PREDOMINA LA MANO DE OBRA";
        if (codigo.compareTo("308") == 0)
            return "308  UTILIZACION O APROVECHAMIENTO DE LA IMAGEN O RENOMBRE";
        if (codigo.compareTo("309") == 0)
            return "309  SERVICIOS PRESTADOS POR MEDIOS DE COMUNICACION Y AGENCIAS DE PUBLICIDAD";
        if (codigo.compareTo("310") == 0)
            return "310  SERVICIO DE TRANSPORTE PRIVADO DE PASAJEROS O TRANSPORTE PUBLICO O PRIVADO DE CARGA";
        if (codigo.compareTo("311") == 0)
            return "311  POR PAGOS A TRAVES DE LIQUIDACION DE COMPRA (NIVEL CULTURAL O RUSTICIDAD)";
        if (codigo.compareTo("312") == 0)
            return "312  TRANSFERENCIA DE BIENES MUEBLES DE NATURALEZA CORPORAL";
        if (codigo.compareTo("312A") == 0)
            return "312A  COMPRA DE BIENES DE ORIGEN AGRICOLA, AVICOLA, PECUARIO, APICOLA, CUNICULA, BIOACUATICO, Y FORESTAL";
        if (codigo.compareTo("314A") == 0)
            return "314A  REGALIAS POR CONCEPTO DE FRANQUICIAS DE ACUERDO A LEY DE PROPIEDAD INTELECTUAL - PAGO A PERSONAS NATURALES";
        if (codigo.compareTo("314B") == 0)
            return "314B  CANONES, DERECHOS DE AUTOR, MARCAS, PATENTES Y SIMILARES DE ACUERDO A LEY DE PROPIEDAD INTELECTUAL – PAGO A PERSONAS NATURALES";
        if (codigo.compareTo("314C") == 0)
            return "314C  REGALIAS POR CONCEPTO DE FRANQUICIAS DE ACUERDO A LEY DE PROPIEDAD INTELECTUAL - PAGO A SOCIEDADES";
        if (codigo.compareTo("314D") == 0)
            return "314D  CANONES, DERECHOS DE AUTOR, MARCAS, PATENTES Y SIMILARES DE ACUERDO A LEY DE PROPIEDAD INTELECTUAL – PAGO A SOCIEDADES";
        if (codigo.compareTo("319") == 0)
            return "319  CUOTAS DE ARRENDAMIENTO MERCANTIL, INCLUSIVE LA DE OPCION DE COMPRA";
        if (codigo.compareTo("320") == 0)
            return "320  POR ARRENDAMIENTO BIENES INMUEBLES";
        if (codigo.compareTo("322") == 0)
            return "322  SEGUROS Y REASEGUROS (PRIMAS Y CESIONES)";
        if (codigo.compareTo("323") == 0)
            return "323  POR RENDIMIENTOS FINANCIEROS PAGADOS A NATURALES Y SOCIEDADES (NO A IFIS)";
        if (codigo.compareTo("323A") == 0)
            return "323A  POR RF: DEPOSITOS CTA. CORRIENTE";
        if (codigo.compareTo("323B1") == 0)
            return "323B1  POR RF: DEPOSITOS CTA. AHORROS SOCIEDADES";
        if (codigo.compareTo("323E") == 0)
            return "323E  POR RF: DEPOSITO A PLAZO FIJO GRAVADOS";
        if (codigo.compareTo("323E2") == 0)
            return "323E2  POR RF: DEPOSITO A PLAZO FIJO EXENTOS";
        if (codigo.compareTo("323F") == 0)
            return "323F  POR RENDIMIENTOS FINANCIEROS: OPERACIONES DE REPORTO - REPOS";
        if (codigo.compareTo("323G") == 0)
            return "323G  POR RF: INVERSIONES (CAPTACIONES) RENDIMIENTOS DISTINTOS DE AQUELLOS PAGADOS A IFIS";
        if (codigo.compareTo("323H") == 0)
            return "323H  POR RF: OBLIGACIONES";
        if (codigo.compareTo("323I") == 0)
            return "323I  POR RF: BONOS CONVERTIBLE EN ACCIONES";
        if (codigo.compareTo("323M") == 0)
            return "323M  POR RF: INVERSIONES EN TITULOS VALORES EN RENTA FIJA GRAVADOS";
        if (codigo.compareTo("323N") == 0)
            return "323N  POR RF: INVERSIONES EN TITULOS VALORES EN RENTA FIJA EXENTOS";
        if (codigo.compareTo("323O") == 0)
            return "323O  POR RF: INTERESES PAGADOS A BANCOS Y OTRAS ENTIDADES SOMETIDAS AL CONTROL DE LA SUPERINTENDENCIA DE BANCOS Y DE LA ECONOMIA POPULAR Y SOLIDARIA";
        if (codigo.compareTo("323P") == 0)
            return "323P  POR RF: INTERESES PAGADOS POR ENTIDADES DEL SECTOR PUBLICO A FAVOR DE SUJETOS PASIVOS";
        if (codigo.compareTo("323Q") == 0)
            return "323Q  POR RF: OTROS INTERESES Y RENDIMIENTOS FINANCIEROS GRAVADOS";
        if (codigo.compareTo("323R") == 0)
            return "323R  POR RF: OTROS INTERESES Y RENDIMIENTOS FINANCIEROS EXENTOS";
        if (codigo.compareTo("324A") == 0)
            return "324A  POR RF: INTERESES EN OPERACIONES DE CREDITO ENTRE INSTITUCIONES DEL SISTEMA FINANCIERO Y ENTIDADES ECONOMIA POPULAR Y SOLIDARIA";
        if (codigo.compareTo("324B") == 0)
            return "324B  POR RF: POR INVERSIONES ENTRE INSTITUCIONES DEL SISTEMA FINANCIERO Y ENTIDADES ECONOMIA POPULAR Y SOLIDARIA";
        if (codigo.compareTo("325") == 0)
            return "325  ANTICIPO DIVIDENDOS";
        if (codigo.compareTo("325A") == 0)
            return "325A  DIVIDENDOS ANTICIPADOS PRESTAMOS ACCIONISTAS, BENEFICIARIOS O PARTÌCIPES";
        if (codigo.compareTo("326") == 0)
            return "326  DIVIDENDOS DISTRIBUIDOS QUE CORRESPONDAN AL IMPUESTO A LA RENTA UNICO ESTABLECIDO EN EL ART. 27 DE LA LRTI";
        if (codigo.compareTo("327") == 0)
            return "327  DIVIDENDOS DISTRIBUIDOS A PERSONAS NATURALES RESIDENTES";
        if (codigo.compareTo("328") == 0)
            return "328  DIVIDENDOS DISTRIBUIDOS A SOCIEDADES RESIDENTES";
        if (codigo.compareTo("329") == 0)
            return "329  DIVIDENDOS DISTRIBUIDOS A FIDEICOMISOS RESIDENTES";
        if (codigo.compareTo("330") == 0)
            return "330  DIVIDENDOS GRAVADOS DISTRIBUIDOS EN ACCIONES (REINVERSION DE UTILIDADES SIN DERECHO A REDUCCION TARIFA IR)";
        if (codigo.compareTo("331") == 0)
            return "331  DIVIDENDOS EXENTOS DISTRIBUIDOS EN ACCIONES (REINVERSION DE UTILIDADES CON DERECHO A REDUCCION TARIFA IR)";
        if (codigo.compareTo("332") == 0)
            return "332  OTRAS COMPRAS DE BIENES Y SERVICIOS NO SUJETAS A RETENCION";
        if (codigo.compareTo("332A") == 0)
            return "332A  POR LA ENAJENACION OCASIONAL DE ACCIONES O PARTICIPACIONES Y TITULOS VALORES";
        if (codigo.compareTo("332B") == 0)
            return "332B  COMPRA DE BIENES INMUEBLES";
        if (codigo.compareTo("332C") == 0)
            return "332C  TRANSPORTE PUBLICO DE PASAJEROS";
        if (codigo.compareTo("332D") == 0)
            return "332D  PAGOS EN EL PAIS POR TRANSPORTE DE PASAJEROS O TRANSPORTE INTERNACIONAL DE CARGA, A COMPAÑIAS NACIONALES O EXTRANJERAS DE AVIACION O MARITIMAS";
        if (codigo.compareTo("332E") == 0)
            return "332E  VALORES ENTREGADOS POR LAS COOPERATIVAS DE TRANSPORTE A SUS SOCIOS";
        if (codigo.compareTo("332F") == 0)
            return "332F  COMPRAVENTA DE DIVISAS DISTINTAS AL DOLAR DE LOS ESTADOS UNIDOS DE AMERICA";
        if (codigo.compareTo("332G") == 0)
            return "332G  PAGOS CON TARJETA DE CREDITO";
        if (codigo.compareTo("332H") == 0)
            return "332H  PAGO AL EXTERIOR TARJETA DE CREDITO REPORTADA POR LA EMISORA DE TARJETA DE CREDITO, SOLO RECAP";
        if (codigo.compareTo("333") == 0)
            return "333  ENAJENACION DE DERECHOS REPRESENTATIVOS DE CAPITAL Y OTROS DERECHOS COTIZADOS EN BOLSA ECUATORIANA";
        if (codigo.compareTo("334") == 0)
            return "334  ENAJENACION DE DERECHOS REPRESENTATIVOS DE CAPITAL Y OTROS DERECHOS NO COTIZADOS EN BOLSA ECUATORIANA";
        if (codigo.compareTo("335") == 0)
            return "335  POR LOTERIAS, RIFAS, APUESTAS Y SIMILARES";
        if (codigo.compareTo("336") == 0)
            return "336  POR VENTA DE COMBUSTIBLES A COMERCIALIZADORAS";
        if (codigo.compareTo("337") == 0)
            return "337  POR VENTA DE COMBUSTIBLES A DISTRIBUIDORES";
        if (codigo.compareTo("338") == 0)
            return "338  COMPRA LOCAL DE BANANO A PRODUCTOR";
        if (codigo.compareTo("339") == 0)
            return "339  LIQUIDACION IMPUESTO UNICO A LA VENTA LOCAL DE BANANO DE PRODUCCION PROPIA";
        if (codigo.compareTo("340") == 0)
            return "340  IMPUESTO UNICO A LA EXPORTACION DE BANANO DE PRODUCCION PROPIA - COMPONENTE 1";
        if (codigo.compareTo("341") == 0)
            return "341  IMPUESTO UNICO A LA EXPORTACION DE BANANO DE PRODUCCION PROPIA - COMPONENTE 2";
        if (codigo.compareTo("342") == 0)
            return "342  IMPUESTO UNICO A LA EXPORTACION DE BANANO PRODUCIDO POR TERCEROS";
        if (codigo.compareTo("343A") == 0)
            return "343A  POR ENERGIA ELECTRICA";
        if (codigo.compareTo("343B") == 0)
            return "343B  POR ACTIVIDADES DE CONSTRUCCION DE OBRA MATERIAL INMUEBLE, URBANIZACION, LOTIZACION O ACTIVIDADES SIMILARES";
        if (codigo.compareTo("344") == 0)
            return "344  OTRAS RETENCIONES APLICABLES EL 2%";
        if (codigo.compareTo("344A") == 0)
            return "344A  PAGO LOCAL TARJETA DE CREDITO REPORTADA POR LA EMISORA DE TARJETA DE CREDITO, SOLO RECAP";
        if (codigo.compareTo("346A") == 0)
            return "346A  GANANCIAS DE CAPITAL";
        if (codigo.compareTo("500") == 0)
            return "500  PAGO AL EXTERIOR - RENTAS INMOBILIARIAS";
        if (codigo.compareTo("501") == 0)
            return "501  PAGO AL EXTERIOR - BENEFICIOS EMPRESARIALES";
        if (codigo.compareTo("502") == 0)
            return "502  PAGO AL EXTERIOR - SERVICIOS EMPRESARIALES";
        if (codigo.compareTo("503") == 0)
            return "503  PAGO AL EXTERIOR - NAVEGACION MARITIMA Y/O AEREA";
        if (codigo.compareTo("504") == 0)
            return "504  PAGO AL EXTERIOR- DIVIDENDOS DISTRIBUIDOS A PERSONAS NATURALES";
        if (codigo.compareTo("504A") == 0)
            return "504A  PAGO AL EXTERIOR - DIVIDENDOS A SOCIEDADES";
        if (codigo.compareTo("504B") == 0)
            return "504B  PAGO AL EXTERIOR - ANTICIPO DIVIDENDOS";
        if (codigo.compareTo("504C") == 0)
            return "504C  PAGO AL EXTERIOR - DIVIDENDOS ANTICIPADOS PRESTAMOS ACCIONISTAS, BENEFICIARIOS O PARTÌCIPES";
        if (codigo.compareTo("504D") == 0)
            return "504D  PAGO AL EXTERIOR - DIVIDENDOS A FIDEICOMISOS";
        if (codigo.compareTo("504E") == 0)
            return "504E  PAGO AL EXTERIOR- DIVIDENDOS DISTRIBUIDOS A PERSONAS NATURALES (PARAISOS FISCALES)";
        if (codigo.compareTo("504F") == 0)
            return "504F  PAGO AL EXTERIOR - DIVIDENDOS A SOCIEDADES (PARAISOS FISCALES)";
        if (codigo.compareTo("504G") == 0)
            return "504G  PAGO AL EXTERIOR - ANTICIPO DIVIDENDOS (PARAISOS FISCALES)";
        if (codigo.compareTo("504H") == 0)
            return "504H  PAGO AL EXTERIOR - DIVIDENDOS A FIDEICOMISOS (PARAISOS FISCALES)";
        if (codigo.compareTo("505") == 0)
            return "505  PAGO AL EXTERIOR - RENDIMIENTOS FINANCIEROS";
        if (codigo.compareTo("505A") == 0)
            return "505A  PAGO AL EXTERIOR – INTERESES DE CREDITOS DE INSTITUCIONES FINANCIERAS DEL EXTERIOR";
        if (codigo.compareTo("505B") == 0)
            return "505B  PAGO AL EXTERIOR – INTERESES DE CREDITOS DE GOBIERNO A GOBIERNO";
        if (codigo.compareTo("505C") == 0)
            return "505C  PAGO AL EXTERIOR – INTERESES DE CREDITOS DE ORGANISMOS MULTILATERALES";
        if (codigo.compareTo("505D") == 0)
            return "505D  PAGO AL EXTERIOR - INTERESES POR FINANCIAMIENTO DE PROVEEDORES EXTERNOS";
        if (codigo.compareTo("505E") == 0)
            return "505E  PAGO AL EXTERIOR - INTERESES DE OTROS CREDITOS EXTERNOS";
        if (codigo.compareTo("505F") == 0)
            return "505F  PAGO AL EXTERIOR - OTROS INTERESES Y RENDIMIENTOS FINANCIEROS";
        if (codigo.compareTo("509") == 0)
            return "509  PAGO AL EXTERIOR - CANONES, DERECHOS DE AUTOR, MARCAS, PATENTES Y SIMILARES";
        if (codigo.compareTo("509A") == 0)
            return "509A  PAGO AL EXTERIOR - REGALIAS POR CONCEPTO DE FRANQUICIAS";
        if (codigo.compareTo("510") == 0)
            return "510  PAGO AL EXTERIOR - GANANCIAS DE CAPITAL";
        if (codigo.compareTo("511") == 0)
            return "511  PAGO AL EXTERIOR - SERVICIOS PROFESIONALES INDEPENDIENTES";
        if (codigo.compareTo("512") == 0)
            return "512  PAGO AL EXTERIOR - SERVICIOS PROFESIONALES DEPENDIENTES";
        if (codigo.compareTo("513") == 0)
            return "513  PAGO AL EXTERIOR - ARTISTAS";
        if (codigo.compareTo("513A") == 0)
            return "513A  PAGO AL EXTERIOR - DEPORTISTAS";
        if (codigo.compareTo("514") == 0)
            return "514  PAGO AL EXTERIOR - PARTICIPACION DE CONSEJEROS";
        if (codigo.compareTo("515") == 0)
            return "515  PAGO AL EXTERIOR - ENTRETENIMIENTO PUBLICO";
        if (codigo.compareTo("516") == 0)
            return "516  PAGO AL EXTERIOR - PENSIONES";
        if (codigo.compareTo("517") == 0)
            return "517  PAGO AL EXTERIOR - REEMBOLSO DE GASTOS";
        if (codigo.compareTo("518") == 0)
            return "518  PAGO AL EXTERIOR - FUNCIONES PUBLICAS";
        if (codigo.compareTo("519") == 0)
            return "519  PAGO AL EXTERIOR - ESTUDIANTES";
        if (codigo.compareTo("520") == 0)
            return "520  PAGO AL EXTERIOR - OTROS CONCEPTOS DE INGRESOS GRAVADOS";
        if (codigo.compareTo("520A") == 0)
            return "520A  PAGO AL EXTERIOR - PAGO A PROVEEDORES DE SERVICIOS HOTELEROS Y TURISTICOS EN EL EXTERIOR";
        if (codigo.compareTo("520B") == 0)
            return "520B  PAGO AL EXTERIOR - ARRENDAMIENTOS MERCANTIL INTERNACIONAL";
        if (codigo.compareTo("520D") == 0)
            return "520D  PAGO AL EXTERIOR - COMISIONES POR EXPORTACIONES Y POR PROMOCION DE TURISMO RECEPTIVO";
        if (codigo.compareTo("520E") == 0)
            return "520E  PAGO AL EXTERIOR - POR LAS EMPRESAS DE TRANSPORTE MARITIMO O AEREO Y POR EMPRESAS PESQUERAS DE ALTA MAR, POR SU ACTIVIDAD.";
        if (codigo.compareTo("520F") == 0)
            return "520F  PAGO AL EXTERIOR - POR LAS AGENCIAS INTERNACIONALES DE PRENSA";
        if (codigo.compareTo("520G") == 0)
            return "520G  PAGO AL EXTERIOR - CONTRATOS DE FLETAMENTO DE NAVES PARA EMPRESAS DE TRANSPORTE AEREO O MARITIMO INTERNACIONAL";
        if (codigo.compareTo("521") == 0)
            return "521  PAGO AL EXTERIOR - ENAJENACION DE DERECHOS REPRESENTATIVOS DE CAPITAL Y OTROS DERECHOS";
        if (codigo.compareTo("522A") == 0)
            return "522A  PAGO AL EXTERIOR - SERVICIOS TECNICOS, ADMINISTRATIVOS O DE CONSULTORIA Y REGALIAS CON CONVENIO DE DOBLE TRIBUTACION";
        if (codigo.compareTo("522B") == 0)
            return "522B  PAGO AL EXTERIOR - SERVICIOS TECNICOS, ADMINISTRATIVOS O DE CONSULTORIA Y REGALIAS SIN CONVENIO DE DOBLE TRIBUTACION";
        if (codigo.compareTo("522C") == 0)
            return "522C  PAGO AL EXTERIOR - SERVICIOS TECNICOS, ADMINISTRATIVOS O DE CONSULTORIA Y REGALIAS EN PARAISOS FISCALES";
        if (codigo.compareTo("523A") == 0)
            return "523A  PAGO AL EXTERIOR - SEGUROS Y REASEGUROS (PRIMAS Y CESIONES) CON CONVENIO DE DOBLE TRIBUTACION";
        if (codigo.compareTo("523B") == 0)
            return "523B  PAGO AL EXTERIOR - SEGUROS Y REASEGUROS (PRIMAS Y CESIONES) SIN CONVENIO DE DOBLE TRIBUTACION";
        if (codigo.compareTo("523C") == 0)
            return "523C  PAGO AL EXTERIOR - SEGUROS Y REASEGUROS (PRIMAS Y CESIONES) EN PARAISOS FISCALES";


        return "";
    }

    /**Metodo que permite generar la tabla 24.
     *
     */
    public static String Tabla24(String codigo) {
        codigo = (codigo == null) ? "" : codigo;


        if (codigo.compareTo("01") == 0)
            return "SIN UTILIZACION DEL SISTEMA FINANCIERO";
        if (codigo.compareTo("02") == 0)
            return "CHEQUE PROPIO";
        if (codigo.compareTo("03") == 0)
            return "CHEQUE CERTIFICADO";
        if (codigo.compareTo("04") == 0)
            return "CHEQUE DE GERENCIA";
        if (codigo.compareTo("05") == 0)
            return "CHEQUE DEL EXTERIOR";
        if (codigo.compareTo("06") == 0)
            return "D�BITO DE CUENTA";
        if (codigo.compareTo("07") == 0)
            return "TRANSFERENCIA PROPIO BANCO";
        if (codigo.compareTo("08") == 0)
            return "TRANSFERENCIA OTRO BANCO NACIONAL";
        if (codigo.compareTo("09") == 0)
            return "TRANSFERENCIA BANCO EXTERIOR";
        if (codigo.compareTo("10") == 0)
            return "TARJETA DE CR�DITO NACIONAL";
        if (codigo.compareTo("11") == 0)
            return "TARJETA DE CR�DITO INTERNACIONAL";
        if (codigo.compareTo("12") == 0)
            return "GIRO";
        if (codigo.compareTo("13") == 0)
            return "DEPOSITO EN CUENTA (CORRIENTE/AHORROS)";
        if (codigo.compareTo("14") == 0)
            return "ENDOSO DE INVERSI�N";
        if (codigo.compareTo("15") == 0)
            return "COMPENSACI�N DE DEUDAS";


        return "";
    }

    /**Metodo que permite generar la tabla 25.
     *
     */
    public static String Tabla25(String codigo) {
        codigo = (codigo == null) ? "" : codigo;
        if (codigo.compareTo("016") == 0)
            return "AMERICAN SAMOA";
        if (codigo.compareTo("332") == 0)
            return "CHIPRE";
        if (codigo.compareTo("074") == 0)
            return "BOUVET ISLAND";
        if (codigo.compareTo("333") == 0)
            return "EMIRATOS ARABES UNIDOS";
        if (codigo.compareTo("101") == 0)
            return "ARGENTINA";
        if (codigo.compareTo("334") == 0)
            return "QATAR";
        if (codigo.compareTo("102") == 0)
            return "BOLIVIA";
        if (codigo.compareTo("335") == 0)
            return "MALDIVAS";
        if (codigo.compareTo("103") == 0)
            return "BRASIL";
        if (codigo.compareTo("336") == 0)
            return "NEPAL";
        if (codigo.compareTo("104") == 0)
            return "CANADA";
        if (codigo.compareTo("337") == 0)
            return "OMAN";
        if (codigo.compareTo("105") == 0)
            return "COLOMBIA";
        if (codigo.compareTo("338") == 0)
            return "SINGAPUR";
        if (codigo.compareTo("106") == 0)
            return "COSTA RICA";
        if (codigo.compareTo("339") == 0)
            return "SRI LANKA (CEILAN)";
        if (codigo.compareTo("107") == 0)
            return "CUBA";
        if (codigo.compareTo("341") == 0)
            return "VIETNAM";
        if (codigo.compareTo("108") == 0)
            return "CHILE";
        if (codigo.compareTo("342") == 0)
            return "YEMEN";
        if (codigo.compareTo("109") == 0)
            return "ANGUILA";
        if (codigo.compareTo("343") == 0)
            return "ISLAS HEARD Y MCDONALD";
        if (codigo.compareTo("110") == 0)
            return "ESTADOS UNIDOS";
        if (codigo.compareTo("344") == 0)
            return "BRUNEI DARUSSALAM";
        if (codigo.compareTo("111") == 0)
            return "GUATEMALA";
        if (codigo.compareTo("346") == 0)
            return "TURQUIA";
        if (codigo.compareTo("112") == 0)
            return "HAITI";
        if (codigo.compareTo("347") == 0)
            return "AZERBAIJAN";
        if (codigo.compareTo("113") == 0)
            return "HONDURAS";
        if (codigo.compareTo("348") == 0)
            return "KAZAJSTAN";
        if (codigo.compareTo("114") == 0)
            return "JAMAICA";
        if (codigo.compareTo("349") == 0)
            return "KIRGUIZISTAN";
        if (codigo.compareTo("115") == 0)
            return "MALVINAS ISLAS";
        if (codigo.compareTo("350") == 0)
            return "TAJIKISTAN";
        if (codigo.compareTo("116") == 0)
            return "MEXICO";
        if (codigo.compareTo("351") == 0)
            return "TURKMENISTAN";
        if (codigo.compareTo("117") == 0)
            return "NICARAGUA";
        if (codigo.compareTo("352") == 0)
            return "UZBEKISTAN";
        if (codigo.compareTo("118") == 0)
            return "PANAMA";
        if (codigo.compareTo("353") == 0)
            return "PALESTINA";
        if (codigo.compareTo("119") == 0)
            return "PARAGUAY";
        if (codigo.compareTo("354") == 0)
            return "HONG KONG";
        if (codigo.compareTo("120") == 0)
            return "PERU";
        if (codigo.compareTo("355") == 0)
            return "MACAO";
        if (codigo.compareTo("121") == 0)
            return "PUERTO RICO";
        if (codigo.compareTo("356") == 0)
            return "ARMENIA";
        if (codigo.compareTo("122") == 0)
            return "REPUBLICA DOMINICANA";
        if (codigo.compareTo("402") == 0)
            return "BURKINA FASO";
        if (codigo.compareTo("123") == 0)
            return "EL SALVADOR";
        if (codigo.compareTo("403") == 0)
            return "ARGELIA";
        if (codigo.compareTo("124") == 0)
            return "TRINIDAD Y TOBAGO";
        if (codigo.compareTo("404") == 0)
            return "BURUNDI";
        if (codigo.compareTo("125") == 0)
            return "URUGUAY";
        if (codigo.compareTo("405") == 0)
            return "CAMERUN";
        if (codigo.compareTo("126") == 0)
            return "VENEZUELA";
        if (codigo.compareTo("406") == 0)
            return "CONGO";
        if (codigo.compareTo("127") == 0)
            return "CURAZAO";
        if (codigo.compareTo("407") == 0)
            return "ETIOPIA";
        if (codigo.compareTo("129") == 0)
            return "BAHAMAS";
        if (codigo.compareTo("408") == 0)
            return "GAMBIA";
        if (codigo.compareTo("130") == 0)
            return "BARBADOS";
        if (codigo.compareTo("409") == 0)
            return "GUINEA";
        if (codigo.compareTo("131") == 0)
            return "GRANADA";
        if (codigo.compareTo("410") == 0)
            return "LIBERIA";
        if (codigo.compareTo("132") == 0)
            return "GUYANA";
        if (codigo.compareTo("412") == 0)
            return "MADAGASCAR";
        if (codigo.compareTo("133") == 0)
            return "SURINAM";
        if (codigo.compareTo("413") == 0)
            return "MALAWI";
        if (codigo.compareTo("134") == 0)
            return "ANTIGUA Y BARBUDA";
        if (codigo.compareTo("414") == 0)
            return "MALI";
        if (codigo.compareTo("135") == 0)
            return "BELICE";
        if (codigo.compareTo("415") == 0)
            return "MARRUECOS";
        if (codigo.compareTo("136") == 0)
            return "DOMINICA";
        if (codigo.compareTo("416") == 0)
            return "MAURITANIA";
        if (codigo.compareTo("137") == 0)
            return "SAN CRISTOBAL Y NEVIS";
        if (codigo.compareTo("417") == 0)
            return "NIGERIA";
        if (codigo.compareTo("138") == 0)
            return "SANTA LUCIA";
        if (codigo.compareTo("419") == 0)
            return "ZIMBABWE (RHODESIA)";
        if (codigo.compareTo("139") == 0)
            return "SAN VICENTE Y LAS GRANAD.";
        if (codigo.compareTo("420") == 0)
            return "SENEGAL";
        if (codigo.compareTo("140") == 0)
            return "ANTILLAS HOLANDESAS";
        if (codigo.compareTo("421") == 0)
            return "SUDAN";
        if (codigo.compareTo("141") == 0)
            return "ARUBA";
        if (codigo.compareTo("422") == 0)
            return "SUDAFRICA (CISKEI)";
        if (codigo.compareTo("142") == 0)
            return "BERMUDA";
        if (codigo.compareTo("423") == 0)
            return "SIERRA LEONA";
        if (codigo.compareTo("143") == 0)
            return "GUADALUPE";
        if (codigo.compareTo("425") == 0)
            return "TANZANIA";
        if (codigo.compareTo("144") == 0)
            return "GUYANA FRANCESA";
        if (codigo.compareTo("426") == 0)
            return "UGANDA";
        if (codigo.compareTo("145") == 0)
            return "ISLAS CAIMAN";
        if (codigo.compareTo("427") == 0)
            return "ZAMBIA";
        if (codigo.compareTo("146") == 0)
            return "ISLAS VIRGENES (BRITANICAS)";
        if (codigo.compareTo("428") == 0)
            return "ÅLAND ISLANDS";
        if (codigo.compareTo("147") == 0)
            return "JOHNSTON ISLA";
        if (codigo.compareTo("429") == 0)
            return "BENIN";
        if (codigo.compareTo("148") == 0)
            return "MARTINICA";
        if (codigo.compareTo("430") == 0)
            return "BOTSWANA";
        if (codigo.compareTo("149") == 0)
            return "MONTSERRAT ISLA";
        if (codigo.compareTo("431") == 0)
            return "REPUBLICA CENTROAFRICANA";
        if (codigo.compareTo("151") == 0)
            return "TURCAS Y CAICOS ISLAS";
        if (codigo.compareTo("432") == 0)
            return "COSTA DE MARFIL";
        if (codigo.compareTo("152") == 0)
            return "VIRGENES,ISLAS(NORT.AMER.)";
        if (codigo.compareTo("433") == 0)
            return "CHAD";
        if (codigo.compareTo("201") == 0)
            return "ALBANIA";
        if (codigo.compareTo("434") == 0)
            return "EGIPTO";
        if (codigo.compareTo("202") == 0)
            return "ALEMANIA";
        if (codigo.compareTo("435") == 0)
            return "GABON";
        if (codigo.compareTo("203") == 0)
            return "AUSTRIA";
        if (codigo.compareTo("436") == 0)
            return "GHANA";
        if (codigo.compareTo("204") == 0)
            return "BELGICA";
        if (codigo.compareTo("437") == 0)
            return "GUINEA-BISSAU";
        if (codigo.compareTo("205") == 0)
            return "BULGARIA";
        if (codigo.compareTo("438") == 0)
            return "GUINEA ECUATORIAL";
        if (codigo.compareTo("207") == 0)
            return "ALBORAN Y PEREJIL";
        if (codigo.compareTo("439") == 0)
            return "KENIA";
        if (codigo.compareTo("208") == 0)
            return "DINAMARCA";
        if (codigo.compareTo("440") == 0)
            return "LESOTHO";
        if (codigo.compareTo("209") == 0)
            return "ESPAÑA";
        if (codigo.compareTo("441") == 0)
            return "MAURICIO";
        if (codigo.compareTo("211") == 0)
            return "FRANCIA";
        if (codigo.compareTo("442") == 0)
            return "MOZAMBIQUE";
        if (codigo.compareTo("212") == 0)
            return "FINLANDIA";
        if (codigo.compareTo("443") == 0)
            return "MAYOTTE";
        if (codigo.compareTo("213") == 0)
            return "REINO UNIDO";
        if (codigo.compareTo("444") == 0)
            return "NIGER";
        if (codigo.compareTo("214") == 0)
            return "GRECIA";
        if (codigo.compareTo("445") == 0)
            return "RWANDA";
        if (codigo.compareTo("215") == 0)
            return "PAISES BAJOS (HOLANDA)";
        if (codigo.compareTo("446") == 0)
            return "SEYCHELLES";
        if (codigo.compareTo("216") == 0)
            return "HUNGRIA";
        if (codigo.compareTo("447") == 0)
            return "SAHARA OCCIDENTAL";
        if (codigo.compareTo("217") == 0)
            return "IRLANDA";
        if (codigo.compareTo("448") == 0)
            return "SOMALIA";
        if (codigo.compareTo("218") == 0)
            return "ISLANDIA";
        if (codigo.compareTo("449") == 0)
            return "SANTO TOME Y PRINCIPE";
        if (codigo.compareTo("219") == 0)
            return "ITALIA";
        if (codigo.compareTo("450") == 0)
            return "SWAZILANDIA";
        if (codigo.compareTo("220") == 0)
            return "LUXEMBURGO";
        if (codigo.compareTo("451") == 0)
            return "TOGO";
        if (codigo.compareTo("221") == 0)
            return "MALTA";
        if (codigo.compareTo("452") == 0)
            return "TUNEZ";
        if (codigo.compareTo("222") == 0)
            return "NORUEGA";
        if (codigo.compareTo("453") == 0)
            return "ZAIRE";
        if (codigo.compareTo("223") == 0)
            return "POLONIA";
        if (codigo.compareTo("454") == 0)
            return "ANGOLA";
        if (codigo.compareTo("224") == 0)
            return "PORTUGAL";
        if (codigo.compareTo("456") == 0)
            return "CABO VERDE";
        if (codigo.compareTo("225") == 0)
            return "RUMANIA";
        if (codigo.compareTo("458") == 0)
            return "COMORAS";
        if (codigo.compareTo("226") == 0)
            return "SUECIA";
        if (codigo.compareTo("459") == 0)
            return "DJIBOUTI";
        if (codigo.compareTo("227") == 0)
            return "SUIZA";
        if (codigo.compareTo("460") == 0)
            return "NAMIBIA";
        if (codigo.compareTo("228") == 0)
            return "CANARIAS ISLAS";
        if (codigo.compareTo("463") == 0)
            return "ERITREA";
        if (codigo.compareTo("229") == 0)
            return "UCRANIA";
        if (codigo.compareTo("464") == 0)
            return "MOROCCO";
        if (codigo.compareTo("230") == 0)
            return "RUSIA";
        if (codigo.compareTo("465") == 0)
            return "REUNION";
        if (codigo.compareTo("231") == 0)
            return "YUGOSLAVIA";
        if (codigo.compareTo("466") == 0)
            return "SANTA ELENA";
        if (codigo.compareTo("233") == 0)
            return "ANDORRA";
        if (codigo.compareTo("499") == 0)
            return "JERSEY";
        if (codigo.compareTo("234") == 0)
            return "LIECHTENSTEIN";
        if (codigo.compareTo("501") == 0)
            return "AUSTRALIA";
        if (codigo.compareTo("235") == 0)
            return "MONACO";
        if (codigo.compareTo("503") == 0)
            return "NUEVA ZELANDA";
        if (codigo.compareTo("237") == 0)
            return "SAN MARINO";
        if (codigo.compareTo("504") == 0)
            return "SAMOA OCCIDENTAL";
        if (codigo.compareTo("238") == 0)
            return "VATICANO (SANTA SEDE)";
        if (codigo.compareTo("506") == 0)
            return "FIJI";
        if (codigo.compareTo("239") == 0)
            return "GIBRALTAR";
        if (codigo.compareTo("507") == 0)
            return "PAPUA NUEVA GUINEA";
        if (codigo.compareTo("241") == 0)
            return "BELARUS";
        if (codigo.compareTo("508") == 0)
            return "TONGA";
        if (codigo.compareTo("242") == 0)
            return "BOSNIA Y HERZEGOVINA";
        if (codigo.compareTo("509") == 0)
            return "PALAO (BELAU) ISLAS";
        if (codigo.compareTo("243") == 0)
            return "CROACIA";
        if (codigo.compareTo("510") == 0)
            return "KIRIBATI";
        if (codigo.compareTo("244") == 0)
            return "ESLOVENIA";
        if (codigo.compareTo("511") == 0)
            return "MARSHALL ISLAS";
        if (codigo.compareTo("245") == 0)
            return "ESTONIA";
        if (codigo.compareTo("512") == 0)
            return "MICRONESIA";
        if (codigo.compareTo("246") == 0)
            return "GEORGIA";
        if (codigo.compareTo("513") == 0)
            return "NAURU";
        if (codigo.compareTo("247") == 0)
            return "GROENLANDIA";
        if (codigo.compareTo("514") == 0)
            return "SALOMON ISLAS";
        if (codigo.compareTo("248") == 0)
            return "LETONIA";
        if (codigo.compareTo("515") == 0)
            return "TUVALU";
        if (codigo.compareTo("249") == 0)
            return "LITUANIA";
        if (codigo.compareTo("516") == 0)
            return "VANUATU";
        if (codigo.compareTo("250") == 0)
            return "MOLDOVA";
        if (codigo.compareTo("517") == 0)
            return "GUAM";
        if (codigo.compareTo("251") == 0)
            return "MACEDONIA";
        if (codigo.compareTo("518") == 0)
            return "ISLAS COCOS (KEELING)";
        if (codigo.compareTo("252") == 0)
            return "ESLOVAQUIA";
        if (codigo.compareTo("519") == 0)
            return "ISLAS COOK";
        if (codigo.compareTo("253") == 0)
            return "ISLAS FAROE";
        if (codigo.compareTo("520") == 0)
            return "ISLAS NAVIDAD";
        if (codigo.compareTo("260") == 0)
            return "FRENCH SOUTHERN TERRITORIES";
        if (codigo.compareTo("521") == 0)
            return "MIDWAY ISLAS";
        if (codigo.compareTo("301") == 0)
            return "AFGANISTAN";
        if (codigo.compareTo("522") == 0)
            return "NIUE ISLA";
        if (codigo.compareTo("302") == 0)
            return "ARABIA SAUDITA";
        if (codigo.compareTo("523") == 0)
            return "NORFOLK ISLA";
        if (codigo.compareTo("303") == 0)
            return "MYANMAR (BURMA)";
        if (codigo.compareTo("524") == 0)
            return "NUEVA CALEDONIA";
        if (codigo.compareTo("304") == 0)
            return "CAMBOYA";
        if (codigo.compareTo("525") == 0)
            return "PITCAIRN, ISLA";
        if (codigo.compareTo("306") == 0)
            return "COREA NORTE";
        if (codigo.compareTo("526") == 0)
            return "POLINESIA FRANCESA";
        if (codigo.compareTo("307") == 0)
            return "TAIWAN (CHINA)";
        if (codigo.compareTo("529") == 0)
            return "TIMOR DEL ESTE";
        if (codigo.compareTo("308") == 0)
            return "FILIPINAS";
        if (codigo.compareTo("530") == 0)
            return "TOKELAI";
        if (codigo.compareTo("309") == 0)
            return "INDIA";
        if (codigo.compareTo("531") == 0)
            return "WAKE ISLA";
        if (codigo.compareTo("310") == 0)
            return "INDONESIA";
        if (codigo.compareTo("532") == 0)
            return "WALLIS Y FUTUNA, ISLAS";
        if (codigo.compareTo("311") == 0)
            return "IRAK";
        if (codigo.compareTo("593") == 0)
            return "ECUADOR";
        if (codigo.compareTo("312") == 0)
            return "IRAN (REPUBLICA ISLAMICA)";
        if (codigo.compareTo("594") == 0)
            return "AGUAS INTERNACIONALES";
        if (codigo.compareTo("313") == 0)
            return "ISRAEL";
        if (codigo.compareTo("595") == 0)
            return "ALTO VOLTA";
        if (codigo.compareTo("314") == 0)
            return "JAPON";
        if (codigo.compareTo("596") == 0)
            return "BIELORRUSIA";
        if (codigo.compareTo("315") == 0)
            return "JORDANIA";
        if (codigo.compareTo("597") == 0)
            return "COTE D�?VOIRE";
        if (codigo.compareTo("316") == 0)
            return "KUWAIT";
        if (codigo.compareTo("598") == 0)
            return "CYPRUS";
        if (codigo.compareTo("317") == 0)
            return "LAOS REP. POP. DEMOC.";
        if (codigo.compareTo("599") == 0)
            return "REPUBLICA CHECA";
        if (codigo.compareTo("318") == 0)
            return "LIBANO";
        if (codigo.compareTo("600") == 0)
            return "FALKLAND ISLANDS";
        if (codigo.compareTo("319") == 0)
            return "MALASIA";
        if (codigo.compareTo("601") == 0)
            return "LATVIA";
        if (codigo.compareTo("321") == 0)
            return "MONGOLIA (MANCHURIA)";
        if (codigo.compareTo("602") == 0)
            return "LIBIA";
        if (codigo.compareTo("322") == 0)
            return "PAKISTAN";
        if (codigo.compareTo("603") == 0)
            return "NORTHERN MARIANA ISL";
        if (codigo.compareTo("323") == 0)
            return "SIRIA";
        if (codigo.compareTo("604") == 0)
            return "ST. PIERRE AND MIQUE";
        if (codigo.compareTo("325") == 0)
            return "TAILANDIA";
        if (codigo.compareTo("605") == 0)
            return "SYRIAN ARAB REPUBLIC";
        if (codigo.compareTo("327") == 0)
            return "BAHREIN";
        if (codigo.compareTo("606") == 0)
            return "TERRITORIO ANTARTICO BRITANICO";
        if (codigo.compareTo("328") == 0)
            return "BANGLADESH";
        if (codigo.compareTo("607") == 0)
            return "TERRITORIO BRITANICO OCEANO IN";
        if (codigo.compareTo("329") == 0)
            return "BUTAN";
        if (codigo.compareTo("688") == 0)
            return "SERBIA";
        if (codigo.compareTo("330") == 0)
            return "COREA DEL SUR";
        if (codigo.compareTo("831") == 0)
            return "GUERNSEY";
        if (codigo.compareTo("331") == 0)
            return "CHINA POPULAR";
        if (codigo.compareTo("832") == 0)
            return "JERSEY";
        if (codigo.compareTo("833") == 0)
            return "ISLE OF MAN";

        return "";
    }

}
