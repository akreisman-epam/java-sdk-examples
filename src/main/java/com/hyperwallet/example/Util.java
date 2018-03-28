package com.hyperwallet.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.hyperwallet.clientsdk.util.HyperwalletJsonConfiguration;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.TimeZone;

public class Util {

    private static ObjectMapper objectMapper = new ObjectMapper();
    private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss z");
    private static DateFormat shortDateFormat = new SimpleDateFormat("zyyyy-MM");

    {
        TimeZone utc = TimeZone.getTimeZone("UTC");
        objectMapper.setTimeZone(utc);
    }

    public static void print(Object object) throws IOException {
        try {
            FilterProvider filters = new SimpleFilterProvider()
                .addFilter(HyperwalletJsonConfiguration.INCLUSION_FILTER,
                           SimpleBeanPropertyFilter.serializeAllExcept(Collections.<String>emptySet()));

            ObjectWriter writer = objectMapper.writer(filters);
            writer.withDefaultPrettyPrinter().writeValue(System.out, object);
            System.out.println();
        } catch (JsonProcessingException e) {
            //noop
        }
    }

    public static Date parseDate(String value) {
        try {
            return dateFormat.parse(value);
        } catch (ParseException ex) {
            try {
                return shortDateFormat.parse(value);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
