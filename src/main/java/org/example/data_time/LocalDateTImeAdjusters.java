package org.example.data_time;

import java.time.*;
import java.time.temporal.Temporal;

public class LocalDateTImeAdjusters {
    public static void main(String[] args) {
        // 1. 동일형의 반환
        LocalDateTime beforeDate = LocalDateTime.of(2018, Month.APRIL, 10, 8, 40);
        LocalDateTime afterDate = LocalDateTime.now();

        // afterDate를 beforeDate로 변환
        Temporal temporal = beforeDate.adjustInto(afterDate);

        System.out.println("beforeDate: " + beforeDate);
        System.out.println("afterDate: " + afterDate);
        System.out.println("temporal: " + temporal);
        System.out.println("beforeDate: " + beforeDate);
        System.out.println("afterDate: " + afterDate);

        // 2. 다른 형의 반환
        LocalDate local = LocalDate.of(2018, Month.JANUARY, 10);
        ZonedDateTime zdt = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("America/Los_Angeles"));
        Temporal temporal1 = local.adjustInto(zdt);
        if(temporal1 instanceof  LocalDate){
            System.out.println("tempral1 is LocalDate");
        }
        if(temporal1 instanceof  ZonedDateTime){
            System.out.println("tempral1 is ZonedDateTime");
        }
    }
}
