package org.example.functional_lambda.basic_interface;

import java.util.function.Predicate;

public class PredicateAndExample {

    // 남자인지 판단
    public static Predicate<Person> isMale() {
        return (Person p) -> "male".equals(p.getSex());
    }

    // 성인인지 판단
    public static Predicate<Person> isAdult() {
        return (Person p) -> p.getAge() > 20;
    }

    public static void main(String[] args) {
        Person person = new Person("David", "male", 28);

        Predicate<Person> predicateA = PredicateAndExample.isAdult();
        Predicate<Person> predicateB = PredicateAndExample.isMale();

        // Predicate 객체 조합
        Predicate<Person> predicateAB = predicateA.and(predicateB);

        System.out.println(person.getName() + "'s result : " + predicateAB.test(person));
    }

    public static class Person {
        private String name;
        private String sex;
        private int age;

        public Person(String name, String sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}