package com.dbuiviet.java.CoreJavaV1.lambda;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class LambdaTest
{
    public static void main(String[] args) {
        String[] planets = new String[] {"Venus", "Earth", "Mars", "Jupiter", "Uranus", "Saturn", "Neptune", "Mercury"};

        System.out.println("Planets in original order: ");
        System.out.println(Arrays.toString(planets));

        System.out.println("Planets sorted in dictionary order: ");
        Arrays.sort(planets);
        System.out.println(Arrays.toString(planets));

        System.out.println("Planets sorted in lenght order: ");
        Arrays.sort(planets, (String first, String second) -> 
                                 (first.length() - second.length()));   //lambda expression
        System.out.println(Arrays.toString(planets));

        Timer t = new Timer(1000, (ActionListener) e -> 
        {
            System.out.println("The time is " + new Date());   //lambda expression
            Toolkit.getDefaultToolkit().beep();
        }   
        );

        t.start();

        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}