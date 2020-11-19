/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.terra.utility;

import javax.faces.FactoryFinder;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.context.FacesContextFactory;
import javax.faces.lifecycle.LifecycleFactory;
import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.faces.lifecycle.Lifecycle;

/**
 *
 * @author USER
 */

public class FacesContextBuilder {

    public static FacesContext getFacesContext(final ServletRequest request, final ServletResponse response) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        if (facesContext != null) {
            return facesContext;
        }
        final FacesContextFactory contextFactory = (FacesContextFactory) FactoryFinder
                .getFactory(FactoryFinder.FACES_CONTEXT_FACTORY);
        final LifecycleFactory lifecycleFactory = (LifecycleFactory) FactoryFinder
                .getFactory(FactoryFinder.LIFECYCLE_FACTORY);
        final Lifecycle lifecycle = lifecycleFactory.getLifecycle(LifecycleFactory.DEFAULT_LIFECYCLE);
        final ServletContext servletContext = ((HttpServletRequest) request).getSession().getServletContext();
        facesContext = contextFactory.getFacesContext(servletContext, request, response, lifecycle);
        InnerFacesContext.setFacesContextAsCurrentInstance(facesContext);
        if (null == facesContext.getViewRoot()) {
            facesContext.setViewRoot(new UIViewRoot());
        }

        return facesContext;
    }

    private abstract static class InnerFacesContext extends FacesContext {

        protected static void setFacesContextAsCurrentInstance(final FacesContext facesContext) {
            FacesContext.setCurrentInstance(facesContext);
        }
    }

}
