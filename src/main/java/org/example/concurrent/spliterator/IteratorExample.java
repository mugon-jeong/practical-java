package org.example.concurrent.spliterator;

import java.util.Iterator;
import java.util.List;

public class IteratorExample {
    public static void main(String[] args) {
        List<HelloPerson> personList = HelloPerson.getSampleData();

        // Iterator로 데이터 처리
        Iterator<HelloPerson> peopleIterator = personList.iterator();
        while (peopleIterator.hasNext()) {
            HelloPerson person = peopleIterator.next();
            System.out.println("Hello " + person);
        }
    }
}
