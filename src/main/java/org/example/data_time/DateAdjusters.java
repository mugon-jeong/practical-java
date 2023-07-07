package org.example.data_time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class DateAdjusters {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();

        DayOfWeek dayOfWeek = localDate.getDayOfWeek();

        System.out.println("이번 달의 첫번째 일: "+ localDate.with(TemporalAdjusters.firstDayOfMonth()));
        System.out.println("이번 달의 마지막 일: "+ localDate.with(TemporalAdjusters.lastDayOfMonth()));
        System.out.println("이번 달의 첫번째 월요일: "+ localDate.with(TemporalAdjusters.firstDayOfMonth()));
    }
}
