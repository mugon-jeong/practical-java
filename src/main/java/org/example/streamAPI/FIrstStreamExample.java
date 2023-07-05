package org.example.streamAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FIrstStreamExample {

    public static void main(String[] args) {
        List<String> firstList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            firstList.add(String.valueOf(i));
        }

        // 스트림 객체 생성
        Stream<String> firstStream = firstList.stream();
        // 스트림 객체의 크기 조회(최종 연산)
        System.out.println(firstStream.count());

        // 스트림에서 앞의 5개 데이터를 한정해서 새로운 스트림 객체 생성 (중간연산)
        Stream<String> limit = firstStream.limit(5);
        // IllegalStateException: 스트림은 이미 처리되었거나 종료되었음
        // count 연산시 이미 스트림이 종료
        // 스트림을 재생성 후 실행해야함
        limit.forEach(System.out::println);


    }
}
