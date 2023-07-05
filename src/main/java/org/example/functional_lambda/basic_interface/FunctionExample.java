package org.example.functional_lambda.basic_interface;

import java.util.function.Function;

public class FunctionExample {
    // 특정한 클래스를 파라미터로 받아서 처리한 후 리턴
    // 데이터를 가공하거나 매핑하는 용도로 사용
    // 비즈니스 로직에 대한 리턴 값이 반드시 필요한 경우 사용
    public static int executeFunction(String context, Function<String, Integer> function){
        return function.apply(context);
    }

    public static void main(String[] args) {
        FunctionExample.executeFunction("hello", (String context)->context.length());
    }
}
