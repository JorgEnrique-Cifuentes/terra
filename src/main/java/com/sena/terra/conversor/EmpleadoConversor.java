/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.terra.conversor;

import com.sena.terra.dto.EmpleadoDto;
import com.sena.terra.entity.Empleado;

/**
 *
 * @author Usuario
 */
public class EmpleadoConversor {

    public static EmpleadoDto empleadoFromEntity(final Empleado empleado) {

        if (null == empleado) {
            return null;
        } else {
            final EmpleadoDto empleadoDto = new EmpleadoDto();
            empleadoDto.setIdEMPLEADO(empleado.getId());
            empleadoDto.setCargo(empleado.getCargo());
            empleadoDto.setCiudad(empleado.getCiudad());
            empleadoDto.setCorreo(empleado.getCorreo());
            empleadoDto.setDireccion(empleado.getDireccion());
            empleadoDto.setEstadoEmpleado(empleado.getEstadoEmpleado());
            empleadoDto.setFechaIngreso(empleado.getFechaIngreso());
            empleadoDto.setFechaRetiro(empleado.getFechaRetiro());
            empleadoDto.setNacionalidad(empleado.getNacionalidad());
            empleadoDto.setNumeroDocumento(empleado.getNumeroDocumento());
            empleadoDto.setPrimerApellido(empleado.getPrimerApellido());
            empleadoDto.setPrimerNombre(empleado.getPrimerNombre());
            empleadoDto.setSalario(empleado.getSalario());
            empleadoDto.setSegundoApellido(empleado.getSegundoApellido());
            empleadoDto.setSegundoNombre(empleado.getSegundoNombre());
            empleadoDto.setTelefono(empleado.getTelefono());
            empleadoDto.setTipoDocumento(empleado.getTipoDocumento());
            empleadoDto.setRolId(empleado.getROLidROL().getIdROL());
            empleadoDto.setNombreRol(empleado.getROLidROL().getTipoRol());
            empleadoDto.setIdLogin(empleado.getIdLogin());
            return empleadoDto;
        }

    }
    
    public static Empleado empleadoFromDto(final EmpleadoDto empleadoDto) {

        if (null == empleadoDto) {
            return null;
        } else {
            final Empleado empleado = new Empleado();
            empleado.setId(empleadoDto.getIdEMPLEADO());
            empleado.setCargo(empleadoDto.getCargo());
            empleado.setCiudad(empleadoDto.getCiudad());
            empleado.setCorreo(empleadoDto.getCorreo());
            empleado.setDireccion(empleadoDto.getDireccion());
            empleado.setEstadoEmpleado(empleadoDto.getEstadoEmpleado());
            empleado.setFechaIngreso(empleadoDto.getFechaIngreso());
            empleado.setFechaRetiro(empleadoDto.getFechaRetiro());
            empleado.setNacionalidad(empleadoDto.getNacionalidad());
            empleado.setNumeroDocumento(empleadoDto.getNumeroDocumento());
            empleado.setPrimerApellido(empleadoDto.getPrimerApellido());
            empleado.setPrimerNombre(empleadoDto.getPrimerNombre());
            empleado.setSalario(empleadoDto.getSalario());
            empleado.setSegundoApellido(empleadoDto.getSegundoApellido());
            empleado.setSegundoNombre(empleadoDto.getSegundoNombre());
            empleado.setTelefono(empleadoDto.getTelefono());
            empleado.setTipoDocumento(empleadoDto.getTipoDocumento());
            return empleado;
        }

    }

}
