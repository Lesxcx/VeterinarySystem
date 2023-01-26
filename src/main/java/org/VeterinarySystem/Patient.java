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

    public String getName() {
        return name;
    }

    public String getOwner() {
        return owner;
    }

    public String getBreed() {
        return breed;
    }

    public String getIssue() {
        return issue;
    }

    public int getAge() {
        return age;
    }

    public Date getDate() {
        return date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
