package org.example.data_time;

import java.time.*;
import java.time.temporal.TemporalQueries;
import java.time.temporal.TemporalQuery;
import java.time.temporal.TemporalUnit;

public class TemporalQueriesExample {
    public static void main(String[] args) {
        // 날짜와 시간 클래스의 정밀한 단위를 조회
        TemporalQuery<TemporalUnit> chronoUnitQuery = TemporalQueries.precision();
        System.out.println("LocalDate 정밀도: "+ LocalDate.now().query(chronoUnitQuery));
        System.out.println("LocalDateTime 정밀도: "+ LocalDateTime.now().query(chronoUnitQuery));
        System.out.println("YearMonth 정밀도: "+ YearMonth.now().query(chronoUnitQuery));
        System.out.println("Instant 정밀도: "+ Instant.now().query(chronoUnitQuery));

        // zone id 조회
        TemporalQuery<ZoneId> zoneIdQuery = TemporalQueries.zoneId();
        System.out.println("ZonedDateTime의 Zone Id: "+ ZonedDateTime.now().query(zoneIdQuery));

        // zoned date time 에서 현재 local time 값 구하기
        TemporalQuery<LocalTime> localQuery = TemporalQueries.localTime();
        System.out.println("ZonedDateTime의 시간: "+ ZonedDateTime.now(ZoneId.of("America/Los_Angeles")).query(localQuery));
    }
}
