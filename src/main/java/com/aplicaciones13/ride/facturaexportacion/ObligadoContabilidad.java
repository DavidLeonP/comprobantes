
package com.aplicaciones13.ride.facturaexportacion;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for obligadoContabilidad.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="obligadoContabilidad">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SI"/>
 *     &lt;enumeration value="NO"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 *
 */
@XmlType(name = "obligadoContabilidad")
@XmlEnum
public enum ObligadoContabilidad {

    SI,
    NO;

    public String value() {
        return name();
    }

    public static ObligadoContabilidad fromValue(String v) {
        return valueOf(v);
    }

}
