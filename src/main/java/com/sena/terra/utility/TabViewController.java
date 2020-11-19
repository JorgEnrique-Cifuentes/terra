/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.terra.utility;

import java.io.Serializable;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.event.TabChangeEvent;

/**
 *
 * @author gaes1
 */
@Named
@ViewScoped
public class TabViewController implements Serializable {

	private int activeIndex;

	public void onTabChange(final TabChangeEvent event) {
    		final Map<String, Object> viewMap
			= FacesContext.getCurrentInstance().getViewRoot().getViewMap();
		viewMap.clear();
	} 

	/**
	 * @return the activeIndex
	 */
	public int getActiveIndex() {
		return activeIndex;
	}

	/**
	 * @param activeIndex the activeIndex to set
	 */
	public void setActiveIndex(final int activeIndex) {
		this.activeIndex = activeIndex;
	}

}
