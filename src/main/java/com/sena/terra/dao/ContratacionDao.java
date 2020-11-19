/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.terra.dao;

import com.sena.terra.dto.ContratacionDto;
import com.sena.terra.interfaces.IContratacionDao;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;

/**
 *
 * @author Usuario
 */
@Stateless
@Local(IContratacionDao.class)
public class ContratacionDao implements IContratacionDao {

    @Override
    public void guardar(ContratacionDto contratacionDto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(ContratacionDto contratacionDto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ContratacionDto> listaContratacion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
