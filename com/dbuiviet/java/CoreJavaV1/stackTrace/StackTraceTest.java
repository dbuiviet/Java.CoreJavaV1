package com.dbuiviet.java.CoreJavaV1.stackTrace;

import java.util.Scanner;

/**
 * @author dbuiviet
 * @version 1.0 This demonstrates a trace feature of a recursive method call
 */

 public class StackTraceTest
 {
     public static void main(String[] args) 
     {

        Scanner in = new Scanner(System.in);
        
        System.out.print("Enter n: ");
        int n = in.nextInt();
        factorial(n);

        in.close();
     }

      /**
       * Compute a factorial of a number
       @param n a non-negative integer
       @return n! 1*2*....*n
       */
      public static int factorial (int n)
      {
          System.out.println("Factorial(" + n + "):");
          Throwable t = new Throwable();
          StackTraceElement[] frames = t.getStackTrace();
          for (StackTraceElement f : frames)
          {
              System.out.println(f);
          }
          int r;
          if (n <= 1) r = 1;
          else r = n * factorial(n-1);
          System.out.println("return: " + r);
          return r;
      }
 }