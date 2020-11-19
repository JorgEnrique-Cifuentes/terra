/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.terra.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "hojas_de_vida")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HojasDeVida.findAll", query = "SELECT h FROM HojasDeVida h"),
    @NamedQuery(name = "HojasDeVida.findByIdAspirante", query = "SELECT h FROM HojasDeVida h WHERE h.idAspirante = :idAspirante"),
    @NamedQuery(name = "HojasDeVida.findByTipoDocumento", query = "SELECT h FROM HojasDeVida h WHERE h.tipoDocumento = :tipoDocumento"),
    @NamedQuery(name = "HojasDeVida.findByNumeroDocumento", query = "SELECT h FROM HojasDeVida h WHERE h.numeroDocumento = :numeroDocumento"),
    @NamedQuery(name = "HojasDeVida.findByPrimerNombre", query = "SELECT h FROM HojasDeVida h WHERE h.primerNombre = :primerNombre"),
    @NamedQuery(name = "HojasDeVida.findBySegundoNombre", query = "SELECT h FROM HojasDeVida h WHERE h.segundoNombre = :segundoNombre"),
    @NamedQuery(name = "HojasDeVida.findByPrimerApellido", query = "SELECT h FROM HojasDeVida h WHERE h.primerApellido = :primerApellido"),
    @NamedQuery(name = "HojasDeVida.findBySegundoApellido", query = "SELECT h FROM HojasDeVida h WHERE h.segundoApellido = :segundoApellido"),
    @NamedQuery(name = "HojasDeVida.findByDireccion", query = "SELECT h FROM HojasDeVida h WHERE h.direccion = :direccion"),
    @NamedQuery(name = "HojasDeVida.findByTelefono", query = "SELECT h FROM HojasDeVida h WHERE h.telefono = :telefono"),
    @NamedQuery(name = "HojasDeVida.findByCorreoElectronico", query = "SELECT h FROM HojasDeVida h WHERE h.correoElectronico = :correoElectronico")})
public class HojasDeVida implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ASPIRANTE")
    private int idAspirante;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIPO_DOCUMENTO")
    private String tipoDocumento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMERO_DOCUMENTO")
    private String numeroDocumento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRIMER_NOMBRE")
    private String primerNombre;
    @Basic(optional = false)
    @Column(name = "SEGUNDO_NOMBRE")
    private String segundoNombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRIMER_APELLIDO")
    private String primerApellido;
    @Basic(optional = false)
    @Column(name = "SEGUNDO_APELLIDO")
    private String segundoApellido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DIRECCION")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "TELEFONO")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CORREO_ELECTRONICO")
    private String correoElectronico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "PUNTAJE")
    private String puntaje;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "PROFESION")
    private String profesion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CIUDAD")
    private Integer idCiudad;
    @JoinColumn(name = "ID_PRUEBAS_PSICOTECNICAS", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private PruebasPsicotecnicas idPruebasPsicotecnicas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idHojasDeVida")
    private List<ExperienciaLaboral> experienciaLaboralList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idHojaDeVida")
    private List<EstudiosRealizados> estudiosRealizadosList;

    public HojasDeVida() {
    }

    public HojasDeVida(int idAspirante) {
        this.idAspirante = idAspirante;
    }

    public HojasDeVida(int idAspirante, String tipoDocumento, String numeroDocumento, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String direccion, String telefono, String correoElectronico) {
        this.idAspirante = idAspirante;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
    }

    public int getIdAspirante() {
        return idAspirante;
    }

    public void setIdAspirante(int idAspirante) {
        this.idAspirante = idAspirante;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public PruebasPsicotecnicas getIdPruebasPsicotecnicas() {
        return idPruebasPsicotecnicas;
    }

    public void setIdPruebasPsicotecnicas(PruebasPsicotecnicas idPruebasPsicotecnicas) {
        this.idPruebasPsicotecnicas = idPruebasPsicotecnicas;
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

    @XmlTransient
    public List<ExperienciaLaboral> getExperienciaLaboralList() {
        return experienciaLaboralList;
    }

    public void setExperienciaLaboralList(List<ExperienciaLaboral> experienciaLaboralList) {
        this.experienciaLaboralList = experienciaLaboralList;
    }

    @XmlTransient
    public List<EstudiosRealizados> getEstudiosRealizadosList() {
        return estudiosRealizadosList;
    }

    public void setEstudiosRealizadosList(List<EstudiosRealizados> estudiosRealizadosList) {
        this.estudiosRealizadosList = estudiosRealizadosList;
    }

    @Override
    public String toString() {
        return "com.sena.terra.entity.HojasDeVida[ idAspirante=" + idAspirante + " ]";
    }

}
