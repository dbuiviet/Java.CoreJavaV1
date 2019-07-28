package com.dbuiviet.java.CoreJavaV1.timer;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;
//resolve the conflict with java.util.Timer;
//import javax.management.timer.Timer;

/**
 * @author dbuiviet
 * @version 1.0
 */

 public class TimerTest
 {
     public static void main(String[] args) 
     {
         ActionListener listener = new TimePrinter();

         //construc a timer to call the listener
         //once every 10 seconds
         Timer t = new Timer(10000, listener);
         t.start();

        JOptionPane.showMessageDialog(null, "Quit Program?");
        System.exit(0);
     }
     
 }

 class TimePrinter implements ActionListener 
 {

    @Override
    public void actionPerformed(ActionEvent arg0) 
    {
        System.out.println("At the tone, the time is: " + new Date());
        Toolkit.getDefaultToolkit().beep();
	}
     
 }