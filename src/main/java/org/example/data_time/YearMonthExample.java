package org.example.data_time;

import java.time.YearMonth;

public class YearMonthExample {
    public static void main(String[] args) {
        YearMonth now = YearMonth.now();

        // 1년 추가
        YearMonth date1 = now.plusYears(1);

        // 1개월 추가
        YearMonth date2 = now.plusMonths(1);
    }
}
