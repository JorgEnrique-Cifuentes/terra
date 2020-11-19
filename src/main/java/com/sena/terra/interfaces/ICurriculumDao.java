/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.terra.interfaces;

import com.sena.terra.dto.CurriculumDto;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface ICurriculumDao {

    public List<CurriculumDto> listAll();

    public void guardar(final CurriculumDto curriculumDto);

    public void delete(final CurriculumDto curriculumDto);
    
    public boolean curriculumExiste(final String identificacion);

    public void select(CurriculumDto curriculumDto);
    
}
