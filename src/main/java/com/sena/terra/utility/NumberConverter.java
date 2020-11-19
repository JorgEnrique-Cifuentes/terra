package com.sena.terra.utility;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.apache.commons.lang.StringUtils;

/**
 * NumberConverter.
 *
 * @author user_name - amendez
 *
 */
@FacesConverter(value = "numberConverter")
public class NumberConverter implements Converter {

    @Override
    public String getAsString(final FacesContext context, final UIComponent component, final Object value) {
        return value.toString();
    }

    @Override
    public Object getAsObject(final FacesContext context, final UIComponent component, final String value) {
        return null == value ? StringUtils.EMPTY : value.replaceAll("[^\\d]", StringUtils.EMPTY);
    }

}
