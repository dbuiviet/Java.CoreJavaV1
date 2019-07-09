package com.dbuiviet.java.CoreJavaV1;

import java.util.ArrayList;

/**
 * This uses reflection to spy on objects
 * @author dbuiviet
 * @version 1.0
 */

 public class ObjectAnalyzerTest
 {
    public static void main(String[] args) {

        ArrayList<Integer> squares = new ArrayList<>();    
        for(int i=1; i<5; i++)
            squares.add(i*i);

        System.out.println(new ObjectAnalyzer().toString(squares));
    }
 }