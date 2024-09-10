package com.farnamhs.blog.util;

import java.time.LocalDate;

import static java.time.LocalDate.parse;
import static java.time.format.DateTimeFormatter.ofPattern;

public class LocalDateFormatter {

    private static final String RESPONSE_FORMAT = "MMMM d, yyyy";
    private static final String REQUEST_FORMAT = "yyyy-MM-dd";

    public static String formatToResponse(LocalDate date) {
        return date.format(ofPattern(RESPONSE_FORMAT));
    }

    public static LocalDate parseFromRequest(String requestFormatDate) {
        return parse(requestFormatDate, ofPattern(REQUEST_FORMAT));
    }

    public static String getRequestFormatDate(String responseFormatDate) {
        return parse(responseFormatDate, ofPattern(RESPONSE_FORMAT)).format(ofPattern(REQUEST_FORMAT));
    }
}
