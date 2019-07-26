package com.dbuiviet.java.CoreJavaV1.lambda;

import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.Timer;
import java.util.Date;

import javax.swing.JOptionPane;

/**
 * @author dbuiviet
 * @version 1.0
 */

public class LambdaTest
{
    public static void main(String[] args) 
    {
        String[] planets = new String[] {"Mercury", "Mars", "Earth", "Venus", "Jupiter", "Neptune", "Saturn", "Uranus"};

        System.out.println(Arrays.toString(planets));

        System.out.println("Sorted in dictionary order: ");
        Arrays.sort(planets);
        System.out.println(Arrays.toString(planets));

        System.out.println("Sorted by length: ");
        Arrays.sort(planets, (String first, String second) -> first.length() - second.length());    //lambda expression
        System.out.println(Arrays.toString(planets));

        Timer t = new Timer(1000, (ActionListener) event ->
                    System.out.println("The time is " + new Date()));   //lambda expression
        t.start();

        JOptionPane.showMessageDialog(null, "Quit the program?");
        System.exit(0);
    }
}