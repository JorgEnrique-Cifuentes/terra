/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.terra.config;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author USER
 */
@Singleton
@Startup
public class StartupBean {

    @PostConstruct
    public void inicializate() {
        LoadTerraConfig.getInstance();
    }

    @PreDestroy
    public void terminate() {
        System.out.println("Shut down in progress");
    }

}
