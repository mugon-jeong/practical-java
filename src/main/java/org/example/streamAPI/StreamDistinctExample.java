package org.example.streamAPI;

import org.example.functional_lambda.basic_interface.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

public class StreamDistinctExample {
    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> key) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(key.apply(t), Boolean.TRUE) == null;
    }

    public void test() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("John", 30));
        personList.add(new Person("a", 30));
        personList.add(new Person("b", 30));
        personList.add(new Person("John", 30));

        personList.stream().filter(distinctByKey(b -> (b.getName() + b.getAge())))
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        new StreamDistinctExample().test();
    }
}
