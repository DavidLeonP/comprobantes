package com.aplicaciones13.utilidades;


/**
 * Clase para crear Generar los Bundle
 * 
 * @author o.velez@13aplicaciones.com
 * 
 */
public class BundleFactory {
        
    /**
     * Crea el bundle para instancias.
     * 
     * @param bundlePath
     * @return
     */
    public static Bundles crearBundle(String bundlePath) {
        Bundles bundles = new Bundles();
        bundles.setBundle(bundlePath);
        return bundles;
    }
    
}
