/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.terra.utility;

import com.sena.terra.dto.LoginDto;
import java.io.IOException;
import java.util.Calendar;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Usuario
 */
public class JsfUtility {

    public static void setAtttributeLogin(final LoginDto loginDto) {
        final FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getSessionMap().put("usuario", loginDto);
    }

    public static LoginDto getAtttributeLogin(final String loginDto) {
        final FacesContext context = FacesContext.getCurrentInstance();
        return (LoginDto) context.getExternalContext().getSessionMap().get(loginDto);
    }

    public static String getRemoteAddress() {
        final HttpServletRequest request
                = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String ipAddress = request.getHeader("X-FORWARDED-FOR");
        if (ipAddress != null) {
            // cares only about the first IP if there is a list
            ipAddress = ipAddress.replaceFirst(",.*", "");
        } else {
            ipAddress = request.getRemoteAddr();
        }
        return ipAddress;
    }

    public static String createNumeroRadicacion(final int id) {
        final StringBuilder builder = new StringBuilder();
        final Calendar fecha = Calendar.getInstance();
        final int mes = fecha.get(Calendar.MONTH) + 1;
        final int dia = fecha.get(Calendar.DAY_OF_MONTH);
        builder.append(id).append(dia).append(mes);
        return builder.toString();
    }

    public static void opendDialog(final String widgetVar) {
        final PrimeFaces current = PrimeFaces.current();
        final StringBuilder builder = new StringBuilder();
        builder.append("PF('").append(widgetVar)
                .append("').show()");
        current.executeScript(builder.toString());
    }

    public static void hideDialog(final String widgetVar) {
        final PrimeFaces current = PrimeFaces.current();
        final StringBuilder builder = new StringBuilder();
        builder.append("PF('").append(widgetVar)
                .append("').hide()");
        current.executeScript(builder.toString());
    }

    public static void updateComponent(final String id) {
        PrimeFaces.current().ajax().update(id);
    }
    
    public static void reloadPage() {
        final ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        try {
            System.out.println(".....................................................................................................");
            System.out.println(((HttpServletRequest) ec.getRequest()).getRequestURL());
            ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
        } catch (IOException e) {
            System.err.print("Error al recargar la página " + e.getMessage());
        }

    }
    
    public static void reloadPageCurriculum() {
        final ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        try {
            System.out.println(".....................................................................................................");
            System.out.println(((HttpServletRequest) ec.getRequest()).getRequestURL());
            ec.redirect("http://localhost:8080/terra/curriculum");
        } catch (IOException e) {
            System.err.print("Error al recargar la página " + e.getMessage());
        }

    }
}
