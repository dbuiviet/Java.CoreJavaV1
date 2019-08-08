package com.dbuiviet.java.CoreJavaV1.packageTest;

import com.dbuiviet.java.CoreJavaV1.employee.Employee;

import static java.lang.System.*;

/**
 * This program demonstrates the use of package
 * @version 1.0
 * @author dbuiviet
 */

public class PackageTest {
    public static void main(String[] args) {
        Employee harry = new Employee("Harry Hacker", 50000, 1989, 10, 1);

        harry.raiseSalary(5);

        out.println("name=" + harry.getName() + ",salary=" + harry.getSalary());
    }
}
