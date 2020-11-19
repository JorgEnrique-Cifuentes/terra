/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.terra.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "empleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e")
    , @NamedQuery(name = "Empleado.findById", query = "SELECT e FROM Empleado e WHERE e.id = :id")
    , @NamedQuery(name = "Empleado.findByTipoDocumento", query = "SELECT e FROM Empleado e WHERE e.tipoDocumento = :tipoDocumento")
    , @NamedQuery(name = "Empleado.findByNumeroDocumento", query = "SELECT e FROM Empleado e WHERE e.numeroDocumento = :numeroDocumento")
    , @NamedQuery(name = "Empleado.findByPrimerNombre", query = "SELECT e FROM Empleado e WHERE e.primerNombre = :primerNombre")
    , @NamedQuery(name = "Empleado.findBySegundoNombre", query = "SELECT e FROM Empleado e WHERE e.segundoNombre = :segundoNombre")
    , @NamedQuery(name = "Empleado.findByPrimerApellido", query = "SELECT e FROM Empleado e WHERE e.primerApellido = :primerApellido")
    , @NamedQuery(name = "Empleado.findBySegundoApellido", query = "SELECT e FROM Empleado e WHERE e.segundoApellido = :segundoApellido")
    , @NamedQuery(name = "Empleado.findByDireccion", query = "SELECT e FROM Empleado e WHERE e.direccion = :direccion")
    , @NamedQuery(name = "Empleado.findByTelefono", query = "SELECT e FROM Empleado e WHERE e.telefono = :telefono")
    , @NamedQuery(name = "Empleado.findByCiudad", query = "SELECT e FROM Empleado e WHERE e.ciudad = :ciudad")
    , @NamedQuery(name = "Empleado.findByNacionalidad", query = "SELECT e FROM Empleado e WHERE e.nacionalidad = :nacionalidad")
    , @NamedQuery(name = "Empleado.findByCorreo", query = "SELECT e FROM Empleado e WHERE e.correo = :correo")
    , @NamedQuery(name = "Empleado.findByFechaIngreso", query = "SELECT e FROM Empleado e WHERE e.fechaIngreso = :fechaIngreso")
    , @NamedQuery(name = "Empleado.findByFechaRetiro", query = "SELECT e FROM Empleado e WHERE e.fechaRetiro = :fechaRetiro")
    , @NamedQuery(name = "Empleado.findByCargo", query = "SELECT e FROM Empleado e WHERE e.cargo = :cargo")
    , @NamedQuery(name = "Empleado.findBySalario", query = "SELECT e FROM Empleado e WHERE e.salario = :salario")
    , @NamedQuery(name = "Empleado.findByEstadoEmpleado", query = "SELECT e FROM Empleado e WHERE e.estadoEmpleado = :estadoEmpleado")
    , @NamedQuery(name = "Empleado.findByTIPODOCUMENTOidTIPODOCUMENTO", query = "SELECT e FROM Empleado e WHERE e.tIPODOCUMENTOidTIPODOCUMENTO = :tIPODOCUMENTOidTIPODOCUMENTO")
    , @NamedQuery(name = "Empleado.findByROLidROL", query = "SELECT e FROM Empleado e WHERE e.rOLidROL = :rOLidROL")
    , @NamedQuery(name = "Empleado.findByCONTRATOidCONTRATO", query = "SELECT e FROM Empleado e WHERE e.cONTRATOidCONTRATO = :cONTRATOidCONTRATO")
    , @NamedQuery(name = "Empleado.findByIdLogin", query = "SELECT e FROM Empleado e WHERE e.idLogin = :idLogin")})
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "TIPO_DOCUMENTO")
    private String tipoDocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "NUMERO_DOCUMENTO")
    private String numeroDocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "PRIMER_NOMBRE")
    private String primerNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "SEGUNDO_NOMBRE")
    private String segundoNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "PRIMER_APELLIDO")
    private String primerApellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "SEGUNDO_APELLIDO")
    private String segundoApellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "DIRECCION")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "TELEFONO")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "CIUDAD")
    private String ciudad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "NACIONALIDAD")
    private String nacionalidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "CORREO")
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_INGRESO")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @Column(name = "FECHA_RETIRO")
    @Temporal(TemporalType.DATE)
    private Date fechaRetiro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "CARGO")
    private String cargo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SALARIO")
    private double salario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ESTADO_EMPLEADO")
    private String estadoEmpleado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIPO_DOCUMENTO_idTIPO_DOCUMENTO")
    private int tIPODOCUMENTOidTIPODOCUMENTO;
    @JoinColumn(name = "ROL_idROL", referencedColumnName = "idROL")
    @ManyToOne(optional = false)
    private Rol rOLidROL;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CONTRATO_idCONTRATO")
    private int cONTRATOidCONTRATO;
    @Column(name = "ID_LOGIN")
    private int idLogin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eMPLEADOidEMPLEADO")
    private List<Contrato> contratoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eMPLEADOidEMPLEADO")
    private List<Desprendible> desprendibleList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpleado")
    private List<Pqr> pqrList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eMPLEADOidEMPLEADO")
    private List<CertificacionLaboral> certificacionLaboralList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpleado")
    private List<PruebasPsicotecnicas> pruebasPsicotecnicasList;

    public Empleado() {
    }

    public Empleado(int id) {
        this.id = id;
    }

    public Empleado(int id, String tipoDocumento, String numeroDocumento, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String direccion, String telefono, String ciudad, String nacionalidad, String correo, Date fechaIngreso, String cargo, double salario, String estadoEmpleado, int tIPODOCUMENTOidTIPODOCUMENTO, int cONTRATOidCONTRATO) {
        this.id = id;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.ciudad = ciudad;
        this.nacionalidad = nacionalidad;
        this.correo = correo;
        this.fechaIngreso = fechaIngreso;
        this.cargo = cargo;
        this.salario = salario;
        this.estadoEmpleado = estadoEmpleado;
        this.tIPODOCUMENTOidTIPODOCUMENTO = tIPODOCUMENTOidTIPODOCUMENTO;
        this.cONTRATOidCONTRATO = cONTRATOidCONTRATO;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaRetiro() {
        return fechaRetiro;
    }

    public void setFechaRetiro(Date fechaRetiro) {
        this.fechaRetiro = fechaRetiro;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getEstadoEmpleado() {
        return estadoEmpleado;
    }

    public void setEstadoEmpleado(String estadoEmpleado) {
        this.estadoEmpleado = estadoEmpleado;
    }

    public int getTIPODOCUMENTOidTIPODOCUMENTO() {
        return tIPODOCUMENTOidTIPODOCUMENTO;
    }

    public void setTIPODOCUMENTOidTIPODOCUMENTO(int tIPODOCUMENTOidTIPODOCUMENTO) {
        this.tIPODOCUMENTOidTIPODOCUMENTO = tIPODOCUMENTOidTIPODOCUMENTO;
    }

    public int getCONTRATOidCONTRATO() {
        return cONTRATOidCONTRATO;
    }

    public void setCONTRATOidCONTRATO(int cONTRATOidCONTRATO) {
        this.cONTRATOidCONTRATO = cONTRATOidCONTRATO;
    }

    public int getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(int idLogin) {
        this.idLogin = idLogin;
    }

    @XmlTransient
    public List<Contrato> getContratoList() {
        return contratoList;
    }

    public void setContratoList(List<Contrato> contratoList) {
        this.contratoList = contratoList;
    }

    @XmlTransient
    public List<Desprendible> getDesprendibleList() {
        return desprendibleList;
    }

    public void setDesprendibleList(List<Desprendible> desprendibleList) {
        this.desprendibleList = desprendibleList;
    }

    @XmlTransient
    public List<Pqr> getPqrList() {
        return pqrList;
    }

    public void setPqrList(List<Pqr> pqrList) {
        this.pqrList = pqrList;
    }

    @XmlTransient
    public List<CertificacionLaboral> getCertificacionLaboralList() {
        return certificacionLaboralList;
    }

    public void setCertificacionLaboralList(List<CertificacionLaboral> certificacionLaboralList) {
        this.certificacionLaboralList = certificacionLaboralList;
    }

    @XmlTransient
    public List<PruebasPsicotecnicas> getPruebasPsicotecnicasList() {
        return pruebasPsicotecnicasList;
    }

    public void setPruebasPsicotecnicasList(List<PruebasPsicotecnicas> pruebasPsicotecnicasList) {
        this.pruebasPsicotecnicasList = pruebasPsicotecnicasList;
    }

    public Rol getROLidROL() {
        return rOLidROL;
    }

    public void setROLidROL(Rol rOLidROL) {
        this.rOLidROL = rOLidROL;
    }
    
    public String nombreCompleto() {
        final StringBuilder builder = new StringBuilder();
        builder.append(this.primerNombre).append(" ").append(this.segundoNombre);
        builder.append(this.primerApellido).append(" ").append(this.segundoApellido);
        return builder.toString();
    }


    @Override
    public String toString() {
        return "com.sena.terra.entity.Empleado[ id=" + id + " ]";
    }

}
