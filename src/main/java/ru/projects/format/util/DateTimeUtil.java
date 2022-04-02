package ru.projects.format.util;

import java.time.format.DateTimeFormatter;

public abstract class DateTimeUtil {
    public static final String DATE_LONG_SPACED_PATTERN = "dd MMMM yyyy";
    public static final String DATE_SHORT_DASH_PATTERN = "yyyy-MM-dd";

    public static final String DATE_TIME_PATTERN = "dd.MM.yyyy HH:mm:ss";
    public static final String DATE_LONG_TIME_SHORT_PATTERN = "dd.MM.yyyy HH:mm";
    public static final String DATE_SHORT_TIME_LONG_PATTERN = "dd.MM.yy HH:mm:ss";

    public static final DateTimeFormatter DATE_LONG_SPACED = DateTimeFormatter.ofPattern(DATE_LONG_SPACED_PATTERN);

    public static final DateTimeFormatter DATE_TIME = DateTimeFormatter.ofPattern(DATE_TIME_PATTERN);
    public static final DateTimeFormatter DATE_LONG_TIME_SHORT = DateTimeFormatter.ofPattern(DATE_LONG_TIME_SHORT_PATTERN);
    public static final DateTimeFormatter DATE_SHORT_TIME_LONG = DateTimeFormatter.ofPattern(DATE_SHORT_TIME_LONG_PATTERN);
}