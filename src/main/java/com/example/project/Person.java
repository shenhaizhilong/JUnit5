package com.example.project;

/**
 * @author: shenhaizhilong
 * @date: 2019/2/14 8:47
 */
public class Person {
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


}
