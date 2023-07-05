package org.example.functional_lambda.basic_interface;

import java.util.function.Function;

public class FunctionAndThenExample {
    public static void main(String[] args) {
        Function<String, Integer> parseIntFunction = (String str) -> Integer.parseInt(str) + 1;
        Function<Integer, String> intToStrFunction = (Integer i) -> "String : " + Integer.toString(i);

        // Function 객체 조합
        // 앞에서부터 뒤로 적용
        System.out.println(parseIntFunction.andThen(intToStrFunction).apply("1000"));

        // 뒤에서 앞으로 적용
        System.out.println(intToStrFunction.compose(parseIntFunction).apply("1000"));
    }
}
