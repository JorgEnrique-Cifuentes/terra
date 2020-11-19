/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.terra.interfaces;

import com.sena.terra.dto.ContratacionDto;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface IContratacionDao {
    
    public void guardar(final ContratacionDto contratacionDto);
    
    public void delete(final ContratacionDto contratacionDto);
    
    public List<ContratacionDto> listaContratacion();
    
    
    
}
