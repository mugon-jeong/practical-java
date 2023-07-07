package org.example.data_time;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class FlightTimeSimulator {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm a");

        // 서울발 로스앤젤레스 국제 공항행 출발
        LocalDateTime leaving = LocalDateTime.of(2018, Month.MAY, 9, 17, 20);
        ZoneId leavingZone = ZoneId.of("Asia/Seoul");
        ZonedDateTime departure = ZonedDateTime.of(leaving, leavingZone);

        String out1 = departure.format(formatter);

        System.out.printf("출발 : %s (%s)%n",out1, leavingZone);

        // 12시간 후 LAX 도착
        ZoneId arrivingZone = ZoneId.of("America/Los_Angeles");
        ZonedDateTime arrival = departure.withZoneSameInstant(arrivingZone).plusMinutes(720);

        String out2 = arrival.format(formatter);
        System.out.printf("도착 : %s (%s)%n",out2, leavingZone);

        // 서머타임 적용 여부 확인
        if(arrivingZone.getRules().isDaylightSavings(arrival.toInstant())){
            System.out.printf("(%s 서머타임 시간 적용.)%n", arrivingZone);
        }else{
            System.out.printf("(%s 표준 시간 적용.)%n", arrivingZone);
        }
    }
}
