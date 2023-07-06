package org.example.concurrent.spliterator;

import java.util.List;
import java.util.Spliterator;

public class SpliteratorExample {
    // Spliterator에 포함된 데이터의 개수 예측
    public static void printSize(String name, Spliterator<HelloPerson> spliterator) {
        System.out.printf("Estimated size of %s is %d%n", name, spliterator.estimateSize());
    }

    // Spliterator 데이터 출력
    public static void printSpliterator(Spliterator<HelloPerson> spliterator) {
        spliterator.forEachRemaining(person -> {
            System.out.println("Hello " + person);
        });
    }
    public static void main(String[] args) {
        List<HelloPerson> personList = HelloPerson.getSampleData();

        Spliterator<HelloPerson> spliterator = personList.spliterator();
        // 순차처리
        spliterator.forEachRemaining(person -> {
            System.out.println("Hello " + person);
        });

        // 병렬처리
        System.out.println("첫 번째 split 전");
        printSize("spliterator", spliterator);
        Spliterator<HelloPerson> spliterator1 = spliterator.trySplit();
        System.out.println("첫 번째 split 후");
        printSize("spliterator1", spliterator);
        printSize("spliterator1", spliterator1);
        Spliterator<HelloPerson> spliterator2 = spliterator.trySplit();
        System.out.println("두 번째 split 후");
        printSize("spliterator", spliterator);
        printSize("spliterator1", spliterator1);
        printSize("spliterator2", spliterator2);

        System.out.println("------------------------------------------------");
        System.out.println("spliterator");
        printSpliterator(spliterator);
        System.out.println("spliterator1");
        printSpliterator(spliterator1);
        System.out.println("spliterator2");
        printSpliterator(spliterator2);

    }
}
