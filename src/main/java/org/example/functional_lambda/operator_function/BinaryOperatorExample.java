package org.example.functional_lambda.operator_function;

import java.util.function.BinaryOperator;

public class BinaryOperatorExample {
    // 두개의 입력 타입, 하나의 리턴타입
    public static void main(String[] args) {
        BinaryOperator<Integer> operatorA = (Integer a, Integer b) -> a + b;
        System.out.println(operatorA.apply(10, 20));
    }
}
