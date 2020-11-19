/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.terra.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Usuario
 */
public class ConverterUtil {

    public static String dateToString(final Date date) {
        final String pattern = "MM-dd-yyyy";
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }

    public static String theMonth(int month) {
        final String[] monthNames = {"Enero", "Febrero", "Marzo", "Abril", 
            "Mayo", "Junio", "Julio", "Agosto", "Septiembre", 
            "Octubre", "Noviembre", "Diciembre"};
        return monthNames[month];
    }

}
