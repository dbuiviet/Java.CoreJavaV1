package com.dbuiviet.java.CoreJavaV1;

import java.util.Scanner;
import java.lang.Enum;

/**
 * This program demonstrates enumerated types.
 * @version 1.0 2004-05-24
 * @author Cay Horstmann
 */

 public class EnumTest
 {
     public static void main(String[] args) {
        //Get input from console
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a size: SMALL, MEDIUM, LARGE, EXTRA_LARGE: ");
        String input = in.next().toUpperCase();
        Size size = Enum.valueOf(Size.class, input);
        System.out.println("size: "+size);
        System.out.println("abbreviation: "+size.getAbbreviation());
        if(size == Size.EXTRA_LARGE)
            System.out.println("You did pay attention to the _.");

        try {
            // String clName = in.getClass().getName();
            // System.out.println(clName);
            //String clName = "java.util.Random"; //will not throw an excetion
            //String clName = "java.util.Scaner"; //will throw an exception            
            //Object obj = Class.forName(clName).newInstance();
            //Object obj = Class.forName(clName).getConstructor().newInstance();
        } catch (Exception e) {            
            e.printStackTrace();
        }

        in.close();
     }
 }

 //public enum Size {SMALL, MEDIUM, LARGE, EXTRA_LARGE};
 enum Size
 {
    SMALL("S"), 
    MEDIUM("M"), 
    LARGE("L"),
    EXTRA_LARGE("XL");

    private String abbr;

    private Size(String abbr) {this.abbr = abbr;}
    public String getAbbreviation() {return abbr;}
 }