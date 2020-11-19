                                     /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.terra.bean;

import com.sena.terra.config.LoadTerraConfig;
import com.sena.terra.utility.ConverterUtil;
import com.sena.terra.utility.GeneratorReport;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author Usuario
 */
@Named(value = "cerficadoMb")
@ViewScoped
public class CerficadoMb implements Serializable {

    @Inject
    private LoginMb loginMb;

    /**
     * Creates a new instance of CerficadoMb
     */
    public CerficadoMb() {
        super();
    }

    public void generarCertificado() {
        final Map parameters = new HashMap();
        final String pathImage = LoadTerraConfig.getInstance()
                    .findProperty("path", "path.image");
        final String nameFile = loginMb.getLoginDto().getEmpleadoDto().getNumeroDocumento() + ".pdf";
        parameters.put("nombre", loginMb.getLoginDto().getEmpleadoDto().nombreCompleto());
        parameters.put("tipoDocumento", loginMb.getLoginDto().getEmpleadoDto().getTipoDocumento());
        parameters.put("numeroDocumento", loginMb.getLoginDto().getEmpleadoDto().getNumeroDocumento());
        parameters.put("fechaInicio", ConverterUtil.dateToString(loginMb
                .getLoginDto().getEmpleadoDto().getFechaIngreso()));
        parameters.put("fechaFinal", loginMb.getLoginDto().getEmpleadoDto().getFechaRetiro() == null
                ? "" : ConverterUtil.dateToString(loginMb
                        .getLoginDto().getEmpleadoDto().getFechaRetiro()));
        parameters.put("cargo", loginMb.getLoginDto().getEmpleadoDto().getCargo().toUpperCase());
        parameters.put("fechaActual", fechaActual());
        
        parameters.put("logoHeaderLeft", pathImage.concat(LoadTerraConfig.getInstance()
                    .findProperty("image", "image.logo.header.left")));
        parameters.put("logoHeaderRight", pathImage.concat(LoadTerraConfig.getInstance()
                    .findProperty("image", "image.logo.header.right")));
        parameters.put("firma", pathImage.concat(LoadTerraConfig.getInstance()
                    .findProperty("image", "image.firma")));
        parameters.put("sello", pathImage.concat(LoadTerraConfig.getInstance()
                    .findProperty("image", "image.sello")));
        parameters.put("footer", pathImage.concat(LoadTerraConfig.getInstance()
                    .findProperty("image", "image.footer")));
        System.out.println(parameters);
        GeneratorReport.generarReporte("certificado_laboral.jrxml", parameters, 
                FacesContext.getCurrentInstance(), nameFile);
    }

    private String fechaActual() {
        final StringBuilder builder = new StringBuilder();
        final Date date = new Date();
        final Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        builder.append("a los ").append(cal.get(Calendar.DAY_OF_MONTH));
        builder.append(" dias del mes de ").append(ConverterUtil.theMonth(cal.get(Calendar.MONTH)));
        builder.append(" de ").append(cal.get(Calendar.YEAR));
        return builder.toString();
    }

}
