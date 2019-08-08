package com.dbuiviet.java.CoreJavaV1.abstractClass;

public class Student extends Person{
    private String major;

    /**
     * @param name Student's name
     * @param major Student's major
     *
     */
    public Student(String name, String major) {
        super(name);
        this.major = major;
    }

    @Override
    public String getDescription() {
        return "a student with major in " + major;
    }
}
