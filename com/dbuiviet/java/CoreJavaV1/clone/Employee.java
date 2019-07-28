package com.dbuiviet.java.CoreJavaV1.clone;

//import java.time.LocalDate;
import java.util.Date;
import java.util.GregorianCalendar;
//import java.util.Objects;

// import statements come after the package statement

/**
 * @version 1.11 2015-05-08
 * @author Cay Horstmann
 */
public class Employee implements Cloneable
{
   private String name;
   private double salary;
   //private LocalDate hireDay;
   private Date hireDay;

   public Employee(String name, double salary)
   {
      this.name = name;
      this.salary = salary;
      hireDay = new Date();
   }

   // public Employee(String name, double salary, int year, int month, int day)
   // {
   //    this.name = name;
   //    this.salary = salary;
   //    hireDay = LocalDate.of(year, month, day);
   // }

   public String getName()
   {
      return name;
   }

   public double getSalary()
   {
      return salary;
   }

   public Date getHireDay()
   {
      return hireDay;
   }

   public Employee clone() throws CloneNotSupportedException
   {
      //call Object.clone()
      Employee cloned = (Employee) super.clone();

      //clone mutable fields
      cloned.hireDay = (Date) this.hireDay.clone();

      return cloned;
   }

   /**
    * Set hireDay to a given date
    * @param year year of the given date
    @param month month of the given date
     @param date month of the given date
    */
   public void setHireDay(int year, int month, int day)
   {
      Date newHireDay = new GregorianCalendar(year, month -1, day).getTime();

      hireDay.setTime(newHireDay.getTime());
      
   }

   public void raiseSalary(double byPercent)
   {
      double raise = salary * byPercent / 100;
      salary += raise;
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

   public String toString()
   {
      return getClass().getName() + "[name=" + name + ",salary=" + salary + ",hireDay=" + hireDay
            + "]";
   }
}