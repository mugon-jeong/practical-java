package org.example.functional_lambda.extend_interface;

import java.util.function.BiConsumer;

public class BiConsumerExample {
    // `Bi` 접두어가 붙은 인터페이스는 입력 파라미터가 2개이다.
    public static void executeBiConsumer(String param1, String param2, BiConsumer<String, String> biConsumer) {
        biConsumer.accept(param1, param2);
    }

    public static void main(String[] args) {
        executeBiConsumer("a", "b", (param1, param2) -> System.out.println(param1 + param2));

        BiConsumer<String, String> biConsumer = (String param1, String param2) -> {
            System.out.println(param1);
            System.out.println(param2);
        };
        BiConsumerExample.executeBiConsumer("Hello", "World", biConsumer);
    }
}
