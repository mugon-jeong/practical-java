package org.example.streamAPI;

import java.util.Arrays;
import java.util.List;

public class StreamMatchExample {
    public static void main(String[] args) {
        List<Integer> numberList = Arrays.asList(1, 3, 5, 7, 9, 11);

        // allMatch
        // 모두 일치 확인
        boolean answer1 = numberList.stream().allMatch(number -> number <10);
        System.out.printf("10보다 모두 작은가요? : %s\n", answer1);

        // anyMath
        // 하나라도 일치 확인
        boolean answer2 = numberList.stream().anyMatch(number -> number % 3 == 0);
        System.out.printf("3의 배수가 있나요? : %s\n", answer2);

        // noneMatch
        // 모두 일치하지 않는지 확인
        boolean anwser3 = numberList.stream().noneMatch(number -> number % 2 == 0);
        System.out.printf("2의 배수가 없나요? : %s\n", anwser3);
    }
}
