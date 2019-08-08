package com.dbuiviet.java.CoreJavaV1.abstractClass;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;

/**
 * This program demonstrates abstract class
 * @version 1.0
 * @author dbuiviet
 */

public class PersonTest {
    public static void main(String[] args) {
        Person[] people = new Person[2];

        //fill Person array with Employee and Student objects
        people[0] = new Employee("Bui Viet Dung", 100000, 2000, 12, 12);
        people[1] = new Student("Bui Viet Thien Minh", "Computer Science");

        //print out names and description
        for(Person p : people)
            System.out.println(p.getName() + " is " + p.getDescription());
    }
}
