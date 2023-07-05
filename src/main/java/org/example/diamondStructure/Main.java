package org.example.diamondStructure;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        // 클래스의 public 메서드와 인터페이스의 default 메서드가 동일하기에
        // 어떤 인터페이스의 default를 호출할지 정해줘야한다.
        Worker conny = new Worker(30, "conny", "male");
        System.out.println(conny.getInfomation() + ", " + conny.getSex());

        // 클래스의 public 메서드와 인터페이스의 default 메서드가 동일하더라도
        // 클래스가 우선 호출되기에 에러가 발생하지 않는다.
        TransGenderWorker transGenderWorker = new TransGenderWorker(30, "trans");
        System.out.println(transGenderWorker.getInfomation() + ", " + transGenderWorker.getSex());
    }
}