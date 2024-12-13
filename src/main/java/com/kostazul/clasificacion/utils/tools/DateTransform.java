package com.kostazul.clasificacion.utils.tools;

import com.kostazul.clasificacion.utils.exceptions.FormatInvalidException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateTransform {

    /**
     * constructor privado.
     */
    private DateTransform() {
    }

    /**
     * Parsea la fecha
     *
     * @param date fecha
     * @return Date
     */
    public static Date parseDate(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return dateFormat.parse(date);
        } catch (ParseException e) {
            throw new FormatInvalidException("Error en la fecha debe estar en formato yyyy-mm-dd");
        }
    }
}
