package org.example.streamAPI;

import java.util.List;
import java.util.stream.Collectors;

public class ReduceSumExample {
    public static void main(String[] args) {
        List<Integer> intList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // for 문장을 이용한 계산
        int sumTemp = 0;
        for (int value : intList) {
            sumTemp += value;
        }
        System.out.printf("for 문장 이용 sum: %s\n", sumTemp);

        // forEach 이용
        int sum[] = {0};
        intList.stream().forEach(value -> sum[0] += value);
        System.out.printf("forEach 문장 이용 sum: %s\n", sum[0]);

        // IntStream
        int sum1 = intList.stream().mapToInt(Integer::intValue).sum();
        System.out.printf("IntStream 문장 이용 sum: %s\n", sum1);

        // Stream.collect
        int sum2 = intList.stream().collect(Collectors.summingInt(Integer::intValue));
        System.out.printf("Stream.collect 문장 이용 sum: %s\n", sum2);

        // 메서드 참조
        int sum3 = intList.stream().reduce(0, Integer::sum);
        System.out.printf("Stream.reduce 이용 (메서드참조) sum: %s\n", sum3);

        // 람다 표현식
        int sum4 = intList.stream().reduce(0, (x, y) -> x + y);
        System.out.printf("Stream.reduce 이용 (람다 표현식) sum: %s\n", sum4);

        // 람다표현식 + 병렬 처리
        int sum5 = intList.parallelStream().reduce(0, (x, y) -> x + y);
        System.out.printf("Stream.reduce 이용 (람다 표현식 + 병렬 처리) sum: %s\n", sum5);

        // 최댓값 구하기
        int max = intList.stream().reduce(0, Integer::max);
        System.out.printf("최댓값: %s\n", max);

        // 최솟값 구하기
        int min = intList.stream().reduce(0, Integer::min);
        System.out.printf("최솟값: %s\n", min);
    }
}
