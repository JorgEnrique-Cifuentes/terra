/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.terra.security;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.omnifaces.filter.HttpFilter;
import org.omnifaces.util.Servlets;

/**
 *
 * @author Usuario
 */
@WebFilter(filterName = "Security", urlPatterns = {"/pages/*"},
		   dispatcherTypes = {DispatcherType.FORWARD, DispatcherType.REQUEST, DispatcherType.ERROR})
public class Security extends HttpFilter {

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response,
            HttpSession session, FilterChain chain)
            throws ServletException, IOException {
        if (session != null && session.getAttribute("usuario") != null) {
            chain.doFilter(request, response);
        } else {
            Servlets.facesRedirect(request, response, "login.xhtml");
        }
    }

}
