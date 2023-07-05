package org.example.diamondStructure;

public class Worker implements Female, Male{
    private int age;
    private String name;
    private String sex;

    public Worker(int age, String name, String sex) {
        this.age = age;
        this.name = name;
        this.sex = sex;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getInfomation() {
        return "Name: " + this.name +" is "+ this.age +" years old.";
    }

    // Male, Femal 인터페이스에서 동일한 default 메서드를 오버라이드해서 재정의
    // 다중 상속시 직접 인테페이스의 어떤 default 메서드를 가져올지 정의해줘야함
    @Override
    public String getSex() {
        String returnValue = null;
        if(this.sex.equals("male")){
            returnValue = Male.super.getSex();
        }else if(this.sex.equals("female")){
            returnValue = Female.super.getSex();
        }
        return returnValue;
    }
}
