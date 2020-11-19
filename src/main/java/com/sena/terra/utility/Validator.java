/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.terra.utility;

import java.util.Collection;
import javax.persistence.TypedQuery;

/**
 *
 * @author Usuario
 */
public class Validator {

    public static <T> T getSingleResult(final TypedQuery<T> query) {
        return query.setMaxResults(Constant.ONE).getResultList()
                .parallelStream().findFirst().orElse(null);
    }

    public static boolean isNull(final String value) {
        return value == null || value.isEmpty();
    }

    public static boolean isListNull(final Collection lista) {
        return lista == null || lista.isEmpty();
    }

}
