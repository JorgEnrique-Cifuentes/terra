package com.sena.terra.utility;

import com.sena.terra.dto.ParametrizacionDto;
import com.sena.terra.interfaces.IParametrizacionDao;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.inject.Produces;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author gaes1
 */
@Named
@ViewScoped
public class CombosController implements Serializable {

    @Inject
    private IParametrizacionDao iParametrizacionDao;

    /**
     *
     * @author USUARIO
     * @return arreglo con los tipos de documento
     */
    @Produces
    @Named("listaTiposDocumentos")
    public List<ParametrizacionDto> getObtenerTiposDocumento() {
        return iParametrizacionDao.Lista(Constant.PARAM_TPD);
    }

    /**
     *
     * @author USUARIO
     * @return arreglo con los tipos de contrato
     */
    @Produces
    @Named("tipoDocumentos")
    public List<ParametrizacionDto> obtenerTiposContrato() {
        return iParametrizacionDao.Lista(Constant.PARAM_TPC);
    }

    /**
     *
     * @author USUARIO
     * @return arreglo con los tipos de pqr
     */
    @Produces
    @Named("tipoPqrs")
    public List<ParametrizacionDto> obtenerTiposPqr() {
        return iParametrizacionDao.Lista(Constant.PARAM_PQR);
    }

    /**
     *
     * @author USUARIO
     * @return arreglo con los tipos de ciudades
     */

    @Produces
    @Named("listaCiudades")
    public List<ParametrizacionDto> obtenerTiposCiudades() {
        return iParametrizacionDao.Lista(Constant.PARAM_CDD);
    }

}
