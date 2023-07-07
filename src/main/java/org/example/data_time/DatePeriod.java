package org.example.data_time;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class DatePeriod {
    public static void main(String[] args) {

        LocalDate oldDate = LocalDate.of(2007, 10, 3);
        LocalDate newDate = LocalDate.of(2018, 4, 27);

        // 시간차이
        Period period = Period.between(oldDate, newDate);
        System.out.println(period.toString());

        // 날짜로 계산
        long days = ChronoUnit.DAYS.between(oldDate, newDate);
        System.out.println(days);
    }
}
