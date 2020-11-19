package com.sena.terra.utility;

import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.WeakHashMap;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * ViewParamConverter.
 *
 * @author gaes1
 * 
 *
 */
@FacesConverter(value = "viewParamConveter")
public class ViewParamConverter implements Converter {

    private static final Map<Object, String> entities = new WeakHashMap<>();

    @Override
    public String getAsString(final FacesContext context, final UIComponent component, final Object entity) {
        synchronized (entities) {
            if (entities.containsKey(entity)) {
                return entities.get(entity);
            } else {
                final String uuid = UUID.randomUUID().toString();
                entities.put(entity, uuid);
                return uuid;
            }
        }
    }

    @Override
    public Object getAsObject(final FacesContext context, final UIComponent component, final String uuid) {
        for (final Entry<Object, String> entry : entities.entrySet()) {
            if (entry.getValue().equals(uuid)) {
                return entry.getKey();
            }
        }
        return null;
    }

}
