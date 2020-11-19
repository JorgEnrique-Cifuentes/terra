/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.terra.utility;

import com.sena.terra.config.LoadTerraConfig;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

/**
 *
 * @author USER
 */
public class GeneratorReport {

    public static void generarReporte(final String jrxml,
            final Map parameters, final FacesContext facesContext,
            final String nameFile) {
        try {
            final String pathReport = LoadTerraConfig.getInstance()
                    .findProperty("path", "path.source.report");
            final JasperReport jasperReport = JasperCompileManager.compileReport(pathReport.concat(jrxml));
            final JasperPrint print = JasperFillManager
                    .fillReport(jasperReport, parameters, new JREmptyDataSource(Constant.ONE));
            final HttpServletResponse response = (HttpServletResponse) facesContext
                    .getCurrentInstance().getExternalContext().getResponse();
            response.setHeader("Content-disposition", "attachment;filename=" + nameFile);
            try (final ServletOutputStream outputStream = response.getOutputStream()) {
                JasperExportManager.exportReportToPdfStream(print, outputStream);
                FacesContext.getCurrentInstance().responseComplete();
            } catch (final IOException ex) {
                Logger.getLogger(GeneratorReport.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (JRException ex) {
            System.out.println("Error " + ex.getMessage());
        }
    }

}
