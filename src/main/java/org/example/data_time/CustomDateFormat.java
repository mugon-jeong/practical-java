package org.example.data_time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class CustomDateFormat {
    public static final DateTimeFormatter KR_LOCAL_DATE;

    static {
        KR_LOCAL_DATE = new DateTimeFormatterBuilder()
                .parseCaseInsensitive()
                .append(DateTimeFormatter.ISO_LOCAL_DATE)
                .toFormatter();
    }

    public static final DateTimeFormatter KR_LOCAL_TIME;

    static {
        KR_LOCAL_TIME = new DateTimeFormatterBuilder()
                .parseCaseInsensitive()
                .appendValue(ChronoField.HOUR_OF_DAY)
                .appendLiteral(":")
                .appendText(ChronoField.MINUTE_OF_HOUR)
                .appendLiteral(":")
                .appendText(ChronoField.SECOND_OF_MINUTE)
                .toFormatter();
    }

    public static final DateTimeFormatter KR_LOCAL_DATE_TIME;

    static {
        KR_LOCAL_DATE_TIME = new DateTimeFormatterBuilder()
                .parseCaseInsensitive()
                .append(KR_LOCAL_DATE)
                .appendLiteral(" ")
                .append(KR_LOCAL_TIME)
                .toFormatter();
    }

    public static void main(String[] args) {
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println("날짜 : "+dateTime.format(CustomDateFormat.KR_LOCAL_DATE));
        System.out.println("시간 : "+dateTime.format(CustomDateFormat.KR_LOCAL_TIME));
        System.out.println("날짜/시간 : "+dateTime.format(CustomDateFormat.KR_LOCAL_DATE_TIME));
    }
}
