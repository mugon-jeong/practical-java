package org.example.data_time;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;

public class ListTimeZone {
    public static void main(String[] args) {
        // 모든 타임존 목록을 조회해서 컬렉션에 담는다.
        ArrayList<String> timeZoneList = new ArrayList<>(ZoneId.getAvailableZoneIds());

        Collections.sort(timeZoneList);

        // 현지 로컬 날짜와 시간
        LocalDateTime localDT = LocalDateTime.now();

        // 타임존 기반의 시간차
        for(String timeZone : timeZoneList) {
            ZoneId zoneId = ZoneId.of(timeZone);
            // 타임존 기반의 날짜 시간 객체
            ZonedDateTime zdt = localDT.atZone(zoneId);
            // 타임존 기반의 시차 객체, 초 단위
            ZoneOffset offset = zdt.getOffset();
            String out = String.format("%25s %8s%n", zoneId, offset);

            // 초단위 시차를 시간 단위 시차로 변경
            int secondsOfHour = offset.getTotalSeconds() / 60 / 60;

            // 시차가 존재할 경우 출력
            if(secondsOfHour != 0){
                System.out.println(out);
            }
        }
    }
}
