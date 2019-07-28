package com.dbuiviet.java.CoreJavaV1.clone;

/**
 * @author dbuiviet
 * @version 1.0
 */
public class CloneTest
{
    public static void main(String[] args) 
    {
        
        try{
            //original value
            Employee original = new Employee("Bui Viet Dung", 99000);
            original.setHireDay(2019, 1, 1);

            //cloned values
            Employee cloned = (Employee) original.clone();
            cloned.raiseSalary(10);
            cloned.setHireDay(2019, 12, 9);
            
            //print both values
            System.out.println("original = " + original.toString());
            System.out.println("cloned = " + cloned.toString());
        }
        catch(CloneNotSupportedException e)
        {
            e.printStackTrace();
        }
    }
}