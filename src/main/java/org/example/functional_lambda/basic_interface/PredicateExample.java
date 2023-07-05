package org.example.functional_lambda.basic_interface;

import java.util.function.Predicate;

public class PredicateExample {
    // 제네릭 타입으로 선언된 객체를 파라미터로 받아서 처리한 후 참/거짓 중 하나를 리턴
    // 어떤 처리 후 성공 혹은 실패했는지 확인 또는 값에 대한 검증 수행 등
    public static boolean isValid(String name, Predicate<String> predicate){
        return predicate.test(name);
    }

    public static void main(String[] args) {
        Predicate<String> predicate = (name) -> name.length() > 3;
        System.out.println(isValid("홍길동", predicate));
    }
}
