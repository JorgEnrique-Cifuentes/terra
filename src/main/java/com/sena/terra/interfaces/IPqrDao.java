/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.terra.interfaces;

import com.sena.terra.dto.PqrDto;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface IPqrDao {

    public List<PqrDto> listByEmpleado(final int EmpleadoId);
    
    public List<PqrDto> listAll();

    public void delete(final int pqrId);

    public void guardar(final PqrDto pqrDto, final int EmpleadoId);

}
