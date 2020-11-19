package com.sena.terra.bean;

import com.sena.terra.config.LoadTerraConfig;
import com.sena.terra.dto.EmpleadoDto;
import com.sena.terra.dto.LoginDto;
import com.sena.terra.dto.PermisoDto;
import com.sena.terra.facade.SendMailService;
import com.sena.terra.interfaces.IEmpleadoDao;
import com.sena.terra.interfaces.ILoginDao;
import com.sena.terra.interfaces.IPermisoDao;
import com.sena.terra.utility.EstadoUsuario;
import com.sena.terra.utility.GeneratePasswordRandom;
import com.sena.terra.utility.JsfUtility;
import com.sena.terra.utility.MessageUtil;
import com.sena.terra.utility.PermisoApp;
import com.sena.terra.utility.Validator;
import com.sena.terra.utility.ValidatorEncrypt;
import java.io.IOException;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Usuario
 */
@Named
@SessionScoped
public class LoginMb implements Serializable {

    @Inject
    private ILoginDao iLoginDao;

    @Inject
    private IEmpleadoDao empleadoDao;

    @Inject
    private IPermisoDao iPermisoDao;

    private LoginDto loginDto;

    @EJB
    private SendMailService mailService;

    @PostConstruct
    public void init() {
        loginDto = new LoginDto();
    }

    public String iniciarSesion() {
        if (Validator.isNull(this.loginDto.getIdentificacion())
                || Validator.isNull(this.loginDto.getContrasena())) {
            MessageUtil.addMessageError("¡oops!", "identificación y contraseña son obligatorios");
        } else {
            final EmpleadoDto empleado = obtenerEmpleado(this.loginDto.getIdentificacion());
            if (empleado == null) {
                MessageUtil.addMessageError("¡oops!", "El usuario no existe con esa identificación");
                return "";
            } else if (iLoginDao.obtenerLoginPorId(empleado.getIdLogin())
                    .getEstado().equals(EstadoUsuario.CAMBIO_CONTRASENA)) {
                this.loginDto.setEmpleadoDto(empleado);
                MessageUtil.addMessageInfo("Cambio de contraseña", "Por favor, actualice su contraseña");
                return "pretty:resetPassword";
            }
            if (ValidatorEncrypt.checkPass(this.loginDto.getContrasena(),
                    iLoginDao.obtenerLoginPorId(empleado.getIdLogin()).getContrasena())) {
                this.loginDto.setEmpleadoDto(empleado);
                this.loginDto.setIdUSUARIO(empleado.getIdLogin());
                this.loginDto.setListaPermisos(iPermisoDao.obtenerPermisos(empleado.getRolId()));
                JsfUtility.setAtttributeLogin(this.loginDto);
                iLoginDao.insertarHistorialUsuario(empleado.getIdLogin());
            } else {
                MessageUtil.addMessageError("¡oops!", "Contraseña invalida");
                return "";
            }
        }
        return "pretty:home";
    }

    public boolean validarPermiso(final PermisoApp permiso) {
        return this.loginDto.getListaPermisos().parallelStream()
                .anyMatch((PermisoDto perm) -> perm.getNombrePermiso()
                .equals(permiso));
    }

    public void cerrarSesion() throws IOException {
        final FacesContext context = FacesContext.getCurrentInstance();
        final ExternalContext externalContext = context.getExternalContext();
        final Object session = externalContext.getSession(false);
        final HttpSession httpSession = (HttpSession) session;
        httpSession.invalidate();
        externalContext.redirect(((HttpServletRequest) externalContext.getRequest()).getRequestURI());
    }

    public String restablecerPassword() {
        if (Validator.isNull(this.loginDto.getIdentificacionRestablecer())) {
            MessageUtil.addMessageError("¡oops!", "la identificación es obligatoria");
            return "";
        } else {
            final EmpleadoDto empleado = obtenerEmpleado(this.loginDto.getIdentificacionRestablecer());
            if (empleado == null) {
                MessageUtil.addMessageError("¡oops!", "El usuario no existe con esa identificación");
                return "";
            } else {
                final String passwordRandom = GeneratePasswordRandom.passwordRandom();
                final String passwordHash = ValidatorEncrypt.hashPassword(passwordRandom);
                iLoginDao.guardarPassword(empleado.getIdLogin(), passwordHash, EstadoUsuario.CAMBIO_CONTRASENA);
                LoadTerraConfig.getInstance();
                mailService.mailResetPassword(empleado, passwordRandom);
                MessageUtil.addMessageInfo("Exitoso", "Se ha enviado un "
                        + "correo electronico a ".concat(empleado.getCorreo()));
                 return "pretty:login";
            }
        }
    }

    public String updatePassword() {
        if (Validator.isNull(this.loginDto.getContrasena())) {
            MessageUtil.addMessageError("¡oops!", "La contraseña es obligatoria");
            return "";
        } else if (this.loginDto.getContrasena().trim().length() < 8
                && this.loginDto.getContrasena().trim().length() > 15) {
            MessageUtil.addMessageError("¡oops!", "La contraseña debe ser entre 8 y 15 caracteres");
            return "";
        } else {
            final String passwordChangue = ValidatorEncrypt
                    .hashPassword(this.loginDto.getContrasena());
            iLoginDao.guardarPassword(this.loginDto.getEmpleadoDto().getIdLogin(),
                    passwordChangue,  EstadoUsuario.ACTIVO);
            resetInput();
            MessageUtil.addMessageInfo("Exito", "La contraseña se ha cambiado satisfactoriamente");
        }
        return "pretty:login";

    }

    public void resetInput() {
        this.loginDto = new LoginDto();
    }

    private EmpleadoDto obtenerEmpleado(final String identificacion) {
        return empleadoDao
                .obtenerEmpleadoPorIdentificacion(identificacion);
    }

    /**
     * @return the loginDto
     */
    public LoginDto getLoginDto() {
        return loginDto;
    }

    /**
     * @param loginDto the loginDto to set
     */
    public void setLoginDto(LoginDto loginDto) {
        this.loginDto = loginDto;
    }

}
