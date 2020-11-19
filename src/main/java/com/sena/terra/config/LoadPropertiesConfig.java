/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.terra.config;

import java.util.HashMap;

/**
 *
 * @author USER
 */
public class LoadPropertiesConfig {

    private static HashMap<String, HashMap<String, String>> properties;

    public LoadPropertiesConfig() {
        properties = obtenerPropiedades();
    }

    private HashMap<String, HashMap<String, String>> obtenerPropiedades() {
        return BundleConfig.listBublePropertie();
    }
    
    public String findProperty(final String bundle, final String nameProperty){
       return properties.get(bundle).entrySet().parallelStream()
               .filter(property -> property.getKey()
                       .equals(nameProperty)).findAny().get().getValue();
    
    }
            

}
