package org.example.streamAPI;

import java.util.Arrays;
import java.util.List;

public class StreamFlatMapExample {
    // 데이터 평면화
    // 다중 배열 형태의 데이터를 필터링하거나 검색하거나 특정 조건의 작업을 수행해서
    // 데이터를 처리해야할 경우
    public static void main(String[] args) {
        String[][] rawData = new String[][] {
                {"A", "B"},
                {"F", "G"},
                {"K", "L"},
                {"P", "A"},
                {"U", "V"}
        };
        List<String[]> rawList = Arrays.asList(rawData);
        rawList.stream()
                // A를 필터링
                .filter(array -> "A".equals(array[0].toString())||"A".equals(array[1].toString()))
                // 결과값 출력
                .forEach(array -> System.out.println("{"+array[0]+","+array[1]+"}"));
        System.out.println("////////////////////////////////");
        rawList.stream()
                // 배열을 펼친다
                .flatMap(array -> Arrays.stream(array))
                // A를 필터링 한다.
                .filter(data->"A".equals(data.toString()))
                // 결과값 출력
                .forEach(data-> System.out.println(data));
    }
}
