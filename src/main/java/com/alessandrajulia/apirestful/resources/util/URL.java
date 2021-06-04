package com.alessandrajulia.apirestful.resources.util;

import org.springframework.expression.ParseException;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.time.LocalDate;

public class URL {

    public static String decodeParam(String text){
        try {
            return URLDecoder.decode(text, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    public static LocalDate decodeDate(String textDate, LocalDate defaultValue){
        try {
            return LocalDate.parse(textDate);
        } catch (ParseException e) {
            return defaultValue;
        }
    }
}
