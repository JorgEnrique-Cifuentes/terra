/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.terra.dao;

import com.sena.terra.conversor.CurriculumConversor;
import com.sena.terra.dto.CurriculumDto;
import com.sena.terra.entity.EstudiosRealizados;
import com.sena.terra.entity.ExperienciaLaboral;
import com.sena.terra.entity.HojasDeVida;
import com.sena.terra.facade.EstudiosRealizadosFacade;
import com.sena.terra.facade.ExperienciaLaboralFacade;
import com.sena.terra.facade.HojasDeVidaFacade;
import com.sena.terra.interfaces.ICurriculumDao;
import com.sena.terra.utility.Validator;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Usuario
 */
@Stateless
@Local(ICurriculumDao.class)
public class CurriculumDao implements ICurriculumDao {

    @Inject
    private HojasDeVidaFacade hojasDeVidaFacade;

    @Inject
    private EstudiosRealizadosFacade estudiosRealizadosFacade;

    @Inject
    private ExperienciaLaboralFacade experienciaLaboralFacade;

    @Override
    public List<CurriculumDto> listAll() {
        final List<HojasDeVida> listaEntity = hojasDeVidaFacade.findAll();
        return CurriculumConversor.listaCurriculumFromEntity(listaEntity);
    }

    @Override
    public void guardar(final CurriculumDto curriculumDto) {
        final HojasDeVida hojasDeVida = CurriculumConversor.curriculumFromDto(curriculumDto);
        final List<EstudiosRealizados> listaEstudioRealizados = hojasDeVida.getEstudiosRealizadosList();
        final List<ExperienciaLaboral> listaExperienciaLaboral = hojasDeVida.getExperienciaLaboralList();
        hojasDeVida.setEstudiosRealizadosList(new ArrayList());
        hojasDeVida.setExperienciaLaboralList(new ArrayList());
        final int puntaje = (curriculumDto.getListaEstudiosRealizados().size()
                + curriculumDto.getListaExperienciaLaboral().size()) * 100;
        hojasDeVida.setPuntaje(String.valueOf(puntaje));
        if (hojasDeVida.getIdAspirante() == 0) {
            System.out.println("Pasa por Dao hoja de vida >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
             hojasDeVida.setEstado("NUEVA");
            hojasDeVidaFacade.create(hojasDeVida);
        } else {
            hojasDeVidaFacade.edit(hojasDeVida);
        }
        guardarListas(hojasDeVida, listaEstudioRealizados, listaExperienciaLaboral);
    }

    public void guardarListas(final HojasDeVida hojasDeVida,
            final List<EstudiosRealizados> listaEstudioRealizados,
            List<ExperienciaLaboral> listaExperienciaLaboral) {
        if (!Validator.isListNull(listaEstudioRealizados)) {
            listaEstudioRealizados.forEach(estudio -> {
                estudio.setIdHojaDeVida(hojasDeVida);
                if (estudio.getId() == 0) {
                    estudiosRealizadosFacade.create(estudio);
                } else {
                    estudiosRealizadosFacade.edit(estudio);
                }
            });
        }
        if (!Validator.isListNull(listaExperienciaLaboral)) {
            listaExperienciaLaboral.forEach(laboral -> {
                laboral.setIdHojasDeVida(hojasDeVida);
                if (laboral.getId() == 0) {
                    experienciaLaboralFacade.create(laboral);
                } else {
                    experienciaLaboralFacade.edit(laboral);
                }
            });
        }
    }

    @Override
    public void delete(CurriculumDto curriculumDto) {
        final HojasDeVida hojasDeVida = CurriculumConversor.curriculumFromDto(curriculumDto);
        if (!Validator.isListNull(hojasDeVida.getEstudiosRealizadosList())) {
            hojasDeVida.getEstudiosRealizadosList().forEach(estudio -> {
                estudiosRealizadosFacade.remove(estudio);
            });
        }
        if (!Validator.isListNull(hojasDeVida.getExperienciaLaboralList())) {
            hojasDeVida.getExperienciaLaboralList().forEach(laboral -> {
                experienciaLaboralFacade.remove(laboral);
            });
        }
        hojasDeVida.setEstudiosRealizadosList(new ArrayList<>());
        hojasDeVida.setExperienciaLaboralList(new ArrayList<>());
        hojasDeVidaFacade.remove(hojasDeVida);
    }

    @Override
    public boolean curriculumExiste(final String identificacion) {
        return hojasDeVidaFacade.curriculumExiste(identificacion);
    }

    @Override
    public void select(CurriculumDto curriculumDto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}