package org.example.functional_lambda.extend_interface;

import java.util.function.IntPredicate;

public class IntPredicateExample {
    // Predicate interface를 숫자 처리를 위해 IntPredicate로 대체
    public static boolean isPositive(int i, IntPredicate intPredicate){
        return intPredicate.test(i);
    }

    public static void main(String[] args) {
        IntPredicate intPredicate = i -> i > 0;
        System.out.println(isPositive(1, intPredicate));
    }
}
