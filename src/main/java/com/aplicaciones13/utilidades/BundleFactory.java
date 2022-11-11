package com.aplicaciones13.utilidades;

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
