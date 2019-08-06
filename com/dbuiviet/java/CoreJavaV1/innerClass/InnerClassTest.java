package com.dbuiviet.java.CoreJavaV1.innerClass;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;
/**
 * This class demonstrate inner class test
 * @author dbuiviet
 * @version 1.0
 */

public class InnerClassTest
{
    public static void main(String[] args) {
        TalkingClock tc = new TalkingClock(1000, true);
        tc.start();

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
    private int interval;
    private boolean beep;

    public TalkingClock(int interval, boolean beep) {
        this.interval = interval;
        this.beep = beep;
    }

    //Start the clock
    public void start()
    {
        ActionListener al = new TimePrinter();
        Timer t = new Timer(interval, al);
        t.start();
    }
 
    //inner class TimePrinter
    class TimePrinter implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("At the tone, the time is " + new Date());

            //outer reference
            if (TalkingClock.this.beep) Toolkit.getDefaultToolkit().beep();
		}
    }
}