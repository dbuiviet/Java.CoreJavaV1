package com.dbuiviet.java.CoreJavaV1.anonymousInnerClass;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 * This demonstrates anonymous inner class
 * 
 * @author dbuiviet
 * @version 1.0
 */

 public class AnonymousInnerClassTest
 {
    public static void main(String[] args) {
        TalkingClock tc = new TalkingClock();
        tc.start(1000, true);

        JOptionPane.showMessageDialog(null, "Quit Program?");
        System.exit(0);
    }
 }

 /**
 * A clock the prints the time in regular intervals
 * with toggled beeps
 */
class TalkingClock
{
    // private int interval;
    // private boolean beep;

    // public TalkingClock(int interval, boolean beep) {
    //     this.interval = interval;
    //     this.beep = beep;
    // }

    //Start the clock
    public void start(int interval, boolean beep)
    {
        ActionListener al = new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("At the tone, the time is " + new Date());

             //outer reference
             if (beep) Toolkit.getDefaultToolkit().beep();
            }
        };
        Timer t = new Timer(interval, al);
        t.start();
    }
 
    //inner class TimePrinter
    // class TimePrinter implements ActionListener {

    //     @Override
    //     public void actionPerformed(ActionEvent e) {
    //         System.out.println("At the tone, the time is " + new Date());

    //         //outer reference
    //         if (TalkingClock.this.beep) Toolkit.getDefaultToolkit().beep();
	// 	}
    // }
}