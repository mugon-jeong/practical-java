package org.example.streamAPI;

import org.example.functional.FunctionSearchingTravel;
import org.example.functional.TravelInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamFilterExample {
    public static void main(String[] args) {
        List<TravelInfo> list = new ArrayList<>();
        Stream<TravelInfo> travelInfoStream = list.stream();

        // 필터 조건을 정의
        travelInfoStream.filter(FunctionSearchingTravel::isVietname).forEach(System.out::println);
    }
}
