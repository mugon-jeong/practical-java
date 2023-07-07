package org.example.data_time;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ParsingDate {
    public static void main(String[] args) {
        String year = "2020";
        String month = "01";
        String day = "01";
        String input = year + "-" + month + "-" + day;

        // 문자열을 이용한 날짜 시간 패턴 지정
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");

        // 파싱
        LocalDate parse = LocalDate.parse(input, formatter);
        System.out.println(parse.toString());
    }
}
