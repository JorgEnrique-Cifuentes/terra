/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.terra.config;

/**
 *
 * @author USER
 */
public class LoadTerraConfig extends LoadPropertiesConfig {

    private static LoadTerraConfig instance;
    
    /**
     * Don't let anyone else instantiate this class
     */
    private LoadTerraConfig() {
        super();
    }
    
    

    /**
     * Lazily create the instance when it is accessed for the first time
     */
    public static synchronized LoadTerraConfig getInstance() {
        if (instance == null) {
            instance = new LoadTerraConfig();
        }
        return instance;
    }
    
}
