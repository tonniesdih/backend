package com.example.demo;

public class Student {

    String name;
    int age;
    String studentClass;
    String admissionNumber;
    String stream;

    public Student(String name, int age, String studentClass,
                   String admissionNumber, String stream) {
        this.name = name;
        this.age = age;
        this.studentClass = studentClass;
        this.admissionNumber = admissionNumber;
        this.stream = stream;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public String getAdmissionNumber() {
        return admissionNumber;
    }

    public String getStream() {
        return stream;
    }
}
