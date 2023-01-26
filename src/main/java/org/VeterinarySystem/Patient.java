package org.VeterinarySystem;

import java.util.Date;

public class Patient {
    private String name, owner, breed, issue;
    private int age;
    private Date date;

    public Patient() {
    }

    public Patient(String name, String owner, String breed, String issue, int age, Date date) {
        this.name = name;
        this.owner = owner;
        this.breed = breed;
        this.issue = issue;
        this.age = age;
        this.date = date;
    }

}
