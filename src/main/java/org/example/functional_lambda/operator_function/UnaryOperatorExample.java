package org.example.functional_lambda.operator_function;

import java.util.function.UnaryOperator;

public class UnaryOperatorExample {
    // 하나의 연산
    public static void main(String[] args) {
        UnaryOperator<Integer> operatorA = (Integer t) -> t * 2;
        System.out.println(operatorA.apply(2));
    }
}
