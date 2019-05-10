package com.dbuiviet.java.CoreJavaV1;
/**
 *	famous HelloWorld example 
 */
// import java.io.*;
// import java.awt.*;
// import javax.swing.*;
import static java.lang.Math.*;
import java.util.Scanner;


/**
 * @author Admin
 *
 */
public class HelloWorld {

	/**
	 * @param args
	 */
	
	public static final double CM_PER_INCH = 2.54;
	
	public static void main(String[] args) throws Exception {		
		// System.out.println("Hello World!");
		// EventQueue.invokeLater(()->{
        //      JFrame frame = new ImageViewerFrame();
        //      frame.setTitle("Image Viewer");
        //      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //      frame.setVisible(true);
        // });
		
		double paperWidth = 8.5;
		double paperHeight = 11;
		
		System.out.println("Paper size in centimeters: " + paperWidth*CM_PER_INCH + 
				" by " + paperHeight*CM_PER_INCH);
		
		System.out.println("The square root of \u03C0 is " + sqrt(PI));		

		double x = 9.999;
		int nx = (int)Math.round(x);	//nearest x
		System.out.println("Nearest integer of " + x + " is " + nx);

		String aString = String.join("/", "S", "M", "L", "XL");
		System.out.println(aString);

		Scanner in = new Scanner(System.in);

		System.out.println("What is your name? ");
		String name = in.nextLine();
		System.out.println("What is your age? ");
		Integer age = in.nextInt();
		//System.out.println("Hello, " + name + ", You will be " + (age+1) + " years old in next year!");
		System.out.printf("Hello, %s. You will be %d years old in next year!", name, (age+1));
		System.out.printf("%,.2f", 10000.0/3);

		in.close();
	}

}
