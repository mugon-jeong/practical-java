package org.example.functional_lambda.basic_interface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {
    // 요청 받은 내용을 소비
    // 아무런 값도 리턴하지 않고 요청 받은 내용을 처리
    public static void executeConsumer(List<String> nameList, Consumer<String> consumer){
        for(String name : nameList){
            // 메서드의 두 번째 인수로 전달된 람다 표현식을 실행
            consumer.accept(name);
        }
    }

    public static void main(String[] args) {
        List<String> nameList = Arrays.asList("홍길동", "김민수");
        Consumer<String> lambdaConsumer = (String name)-> System.out.println(name);
        executeConsumer(nameList, lambdaConsumer);
        Consumer<String> methodConsumer = System.out::println;
        executeConsumer(nameList, methodConsumer);

        // Consumer 인터페이스 조합
        Consumer<String> consumer1 = (String text)-> System.out.println("hello: "+text);
        Consumer<String> consumer2 = (String text)-> System.out.println("text length: "+text.length());

        // accept 파라미터를 consumer1, consumer2에 전달하여 연결
        consumer1.andThen(consumer2).accept("java");
    }
}
