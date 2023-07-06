package org.example.concurrent.spliterator;

import java.util.ArrayList;
import java.util.List;

public class HelloPerson {
    private String firstName;
    private String lastName;
    private String country;

    public HelloPerson(String firstName, String lastName, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return this.getFirstName() + " " + this.getLastName() + " from " + this.getCountry();
    }

    public static List<HelloPerson> getSampleData() {
        List<HelloPerson> sampleData = new ArrayList<>();
        sampleData.add(new HelloPerson("John", "Doe", "UK"));
        sampleData.add(new HelloPerson("A", "B", "I"));
        sampleData.add(new HelloPerson("C", "D", "J"));
        sampleData.add(new HelloPerson("E", "F", "K"));
        sampleData.add(new HelloPerson("G", "H", "L"));
        return sampleData;
    }
}
