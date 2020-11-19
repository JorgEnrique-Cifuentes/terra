/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.terra.config;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.ResourceBundle;
import javax.faces.context.FacesContext;

/**
 *
 * @author USER
 */
public class BundleConfig {

    private static final String[] NAME_PROPERTIES = {"path", "mail", "image"};

    protected static String loadBublePropertie(final String propertie,
            final String value) {
        final FacesContext context = FacesContext.getCurrentInstance();
        final ResourceBundle bundle = context.getApplication().getResourceBundle(context, propertie);
        return bundle.getString(value);
    }

    protected static HashMap<String, HashMap<String, String>> listBublePropertie() {
        final HashMap<String, HashMap<String, String>> hashMapProperties = new HashMap<>();
        for (final String nameProperty : NAME_PROPERTIES) {
            final ResourceBundle bundle
                    = ResourceBundle.getBundle(nameProperty);
            hashMapProperties.put(nameProperty, obtenerValores(bundle, bundle.getKeys()));
        }
        return hashMapProperties;
    }

    private static HashMap<String, String> obtenerValores(final ResourceBundle bundle,
            final Enumeration<String> enumeration) {
        final HashMap<String, String> hashMapProperties = new HashMap<>();
        while (enumeration.hasMoreElements()) {
            final String key = enumeration.nextElement();
            final String value = bundle.getString(key);
            hashMapProperties.put(key, value);
        }
        return hashMapProperties;
    }

}
