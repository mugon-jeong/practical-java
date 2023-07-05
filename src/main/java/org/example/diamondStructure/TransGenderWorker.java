package org.example.diamondStructure;

public class TransGenderWorker extends TransGenderMale implements Male{
    private int age;
    private String name;

    public TransGenderWorker(int age, String name) {
        this.age = age;
        this.name = name;
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
}
