package com.dbuiviet.java.CoreJavaV1.interfaces;

import java.util.Arrays;

/**
 * This class represents the Comparable interface
 * 
 * @version 1.0
 * @author dbuiviet
 */

public class EmployeeSortTest
{
    public static void main(String[] args) {

        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Bui Viet Dung", 35000);
        staff[1] = new Employee("Le Duc Hanh", 30000);
        staff[2] = new Employee("Do Thi Thu", 20000);

        Arrays.sort(staff);

        //print info in sorted salary
        for (Employee e : staff)
            System.out.println("Name: " + e.getName() + ", Salary: " + e.getSalary());
    }
}