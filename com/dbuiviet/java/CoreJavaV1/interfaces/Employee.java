package com.dbuiviet.java.CoreJavaV1.interfaces;

// import java.time.LocalDate;
// import java.util.Objects;

// import statements come after the package statement

/**
 * @version 1.11 2015-05-08
 * @author Cay Horstmann
 */
public class Employee implements Comparable<Employee>
{
   private String name;
   private double salary;
   //private LocalDate hireDay;

   // public Employee(String name, double salary, int year, int month, int day)
   // {
   //    this.name = name;
   //    this.salary = salary;
   //    hireDay = LocalDate.of(year, month, day);
   // }

   public Employee(String name, double salary)
   {
      this.name = name;
      this.salary = salary;
   }

   public String getName()
   {
      return name;
   }

   public double getSalary()
   {
      return salary;
   }

   // public LocalDate getHireDay()
   // {
   //    return hireDay;
   // }

   public void raiseSalary(double byPercent)
   {
      double raise = salary * byPercent / 100;
      salary += raise;
   }


   /**
    * Compare employee by salary
    @param other compare with other employee
    @return integer value (negative for less salary, 0 for equal, positive for more salary)
    */
   public int compareTo(Employee other)
   {
      return Double.compare(this.salary, other.salary);
   }


   // public boolean equals(Object otherObject)
   // {
   //    // a quick test to see if the objects are identical
   //    if (this == otherObject) return true;

   //    // must return false if the explicit parameter is null
   //    if (otherObject == null) return false;

   //    // if the classes don't match, they can't be equal
   //    if (getClass() != otherObject.getClass()) return false;

   //    // now we know otherObject is a non-null Employee
   //    Employee other = (Employee) otherObject;

   //    // test whether the fields have identical values
   //    return Objects.equals(name, other.name) && salary == other.salary && Objects.equals(hireDay, other.hireDay);
   // }

   // public int hashCode()
   // {
   //    return Objects.hash(name, salary, hireDay); 
   // }

   // public String toString()
   // {
   //    return getClass().getName() + "[name=" + name + ",salary=" + salary + ",hireDay=" + hireDay
   //          + "]";
   // }
}