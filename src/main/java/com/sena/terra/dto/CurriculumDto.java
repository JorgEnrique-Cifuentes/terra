package com.sena.terra.dto;

import java.util.List;

/**
 *
 * @author Usuario
 */
public class CurriculumDto {

    private int idAspirante;
    private String tipoDocumento;
    private String numeroDocumento;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String direccion;
    private String telefono;
    private String correoElectronico;
    private String profesion;
    private String puntaje;
    private Integer idCiudad;
    private String estado;
    private List<EstudiosRealizadosDto> listaEstudiosRealizados;
    private List<ExperienciaLaboralDto> listaExperienciaLaboral;
    private String APROBADO;

    
    /**
     * @return the idAspirante
     */
    public int getIdAspirante() {
        return idAspirante;
    }

    /**
     * @param idAspirante the idAspirante to set
     */
    public void setIdAspirante(int idAspirante) {
        this.idAspirante = idAspirante;
    }

    /**
     * @return the tipoDocumento
     */
    public String getTipoDocumento() {
        return tipoDocumento;
    }

    /**
     * @param tipoDocumento the tipoDocumento to set
     */
    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    /**
     * @return the numeroDocumento
     */
    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    /**
     * @param numeroDocumento the numeroDocumento to set
     */
    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    /**
     * @return the primerNombre
     */
    public String getPrimerNombre() {
        return primerNombre;
    }

    /**
     * @param primerNombre the primerNombre to set
     */
    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    /**
     * @return the segundoNombre
     */
    public String getSegundoNombre() {
        return segundoNombre;
    }

    /**
     * @param segundoNombre the segundoNombre to set
     */
    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    /**
     * @return the primerApellido
     */
    public String getPrimerApellido() {
        return primerApellido;
    }

    /**
     * @param primerApellido the primerApellido to set
     */
    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    /**
     * @return the segundoApellido
     */
    public String getSegundoApellido() {
        return segundoApellido;
    }

    /**
     * @param segundoApellido the segundoApellido to set
     */
    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the correoElectronico
     */
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    /**
     * @param correoElectronico the correoElectronico to set
     */
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    /**
     * @return the profesion
     */
    public String getProfesion() {
        return profesion;
    }

    /**
     * @param profesion the profesion to set
     */
    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    /**
     * @return the listaEstudiosRealizados
     */
    public List<EstudiosRealizadosDto> getListaEstudiosRealizados() {
        return listaEstudiosRealizados;
    }

    /**
     * @param listaEstudiosRealizados the listaEstudiosRealizados to set
     */
    public void setListaEstudiosRealizados(List<EstudiosRealizadosDto> listaEstudiosRealizados) {
        this.listaEstudiosRealizados = listaEstudiosRealizados;
    }

    /**
     * @return the listaExperienciaLaboral
     */
    public List<ExperienciaLaboralDto> getListaExperienciaLaboral() {
        return listaExperienciaLaboral;
    }

    /**
     * @return the puntaje
     */
    public String getPuntaje() {
        return puntaje;
    }

    /**
     * @param puntaje the puntaje to set
     */
    public void setPuntaje(String puntaje) {
        this.puntaje = puntaje;
    }

    /**
     * @return the idCiudad
     */
    public Integer getIdCiudad() {
        return idCiudad;
    }

    /**
     * @param idCiudad the idCiudad to set
     */
    public void setIdCiudad(Integer idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @param listaExperienciaLaboral the listaExperienciaLaboral to set
     */
    public void setListaExperienciaLaboral(List<ExperienciaLaboralDto> listaExperienciaLaboral) {
        this.listaExperienciaLaboral = listaExperienciaLaboral;
    }

    public String getAPROBADO() {
        return APROBADO;
    }

    public void setAPROBADO(String APROBADO) {
        this.APROBADO = APROBADO;
    }
}