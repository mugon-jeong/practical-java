package org.example.functional_lambda.reference;

import java.util.ArrayList;

public class MethodReferenceExample {
    public static MethodReferenceExample of() {
        return new MethodReferenceExample();
    }

    // 데이터 처리 로직 정의
    public static void executeMethod(String entity) {
        if (entity != null && !"".equals(entity)) {
            System.out.println("Contents : " + entity);
            System.out.println("Length : " + entity.length());
        }
    }

    // 대문자로 변경하는 코드
    public void toUpperCase(String entity){
        System.out.println(entity.toUpperCase());
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        // 정적 메서드 참조
        list.stream().forEach(MethodReferenceExample::executeMethod);

        // 한정적 메서드 참조
        // 외부에서 정의한 객체(MethodReferenceExample.of())의 메서드(toUpperCase)를 참조
        list.stream().forEach(MethodReferenceExample.of()::toUpperCase);

        // 비한정적 메서드 참조
        // public 혹은 protected로 정의한 메서드를 참조할때 사용
        // 람다 표현식 내붸서 생성한 객체의 메서드를 참조할때 사용
        list.stream().map(String::toUpperCase).forEach(System.out::println);

    }
}
