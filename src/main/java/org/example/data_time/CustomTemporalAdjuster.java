package org.example.data_time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class CustomTemporalAdjuster implements TemporalAdjuster {
    public static int TRANSFER_DATE = 25;

    @Override
    public Temporal adjustInto(Temporal temporal) {
        // 입력한 값의 날짜 객체 생성
        LocalDate currentDate = LocalDate.from(temporal);

        // 입력된 값의 날짜 객체를 기준으로 이체해야할 날짜
        LocalDate transferDate = currentDate.withDayOfMonth(TRANSFER_DATE);
        System.out.println("입력된 값의 날짜 객체를 기준으로 이체해야할 날짜: " + transferDate);
        // 만일 오늘 일자가 TRANSFER_DATE보다 클 경우 다음 달에 이체를 하도록 설정
        if (currentDate.getDayOfMonth() > TRANSFER_DATE) {
            transferDate = transferDate.plusMonths(1);
            System.out.println("만일 오늘 일자가 TRANSFER_DATE보다 클 경우 다음 달에 이체를 하도록 설정: " + transferDate);
        }
        // 이체해야 하는 일자가 토요일 혹은 일요일일 경우 월요일로 이체 일자 조정
        if (transferDate.getDayOfWeek() == DayOfWeek.SATURDAY ||
                transferDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
            transferDate = transferDate.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
            System.out.println("이체해야 하는 일자가 토요일 혹은 일요일일 경우 월요일로 이체 일자 조정: " + transferDate);
        }
        return temporal.with(transferDate);
    }

    public static void main(String[] args) {
        CustomTemporalAdjuster adjuster = new CustomTemporalAdjuster();
        System.out.println("2018.07.15 기준 일체 일자: "+adjuster.adjustInto(LocalDate.of(2018, 7, 15)));
        System.out.println("2018.08.21 기준 일체 일자: "+adjuster.adjustInto(LocalDate.of(2018, 8,21)));
        System.out.println("2018.09.30 기준 일체 일자: "+adjuster.adjustInto(LocalDate.of(2018, 9,30)));
    }
}
