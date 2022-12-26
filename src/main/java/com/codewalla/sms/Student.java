package com.codewalla.sms;

public class Student {

    private String name;

    private int id;

    private String course;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }




    public Student(String name, int id, String course, int age) {
        this.name = name;
        this.id = id;
        this.course = course;
        this.age = age;
    }

}
