package com.dbuiviet.java.CoreJavaV1.reflection;

import java.util.Scanner;
import java.lang.Class;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

// import java.util.*;
// import java.lang.reflect.*;
/**
 * This program uses reflection to print all features of a class
 * @version 1.0 2019-06-12
 * @author dbuiviet
 */
public class ReflectionTest
{
    public static void main(String[] args) {
        //read class name from commnand line or user input
        String clName;

        if (args.length > 0)
        {
            clName = args[0];
        }
        else
        {
            Scanner in = new Scanner(System.in);
            System.out.print("Enter a class name (i.e java.util.Date): ");
            clName = in.next();

            in.close();
        }
            

        try
        {
            //print class name or superclass name (if != Object)
            Class cl = Class.forName(clName);
            Class supercl = cl.getSuperclass();
            String modifier = Modifier.toString(cl.getModifiers());
            if (modifier.length() > 0) System.out.print(modifier + " ");
            System.out.print("class " + clName);
            if (supercl != null && supercl != Object.class) System.out.print(" extends " + supercl.getName());

            //print Constructor, Methods and Fields
            System.out.print("\n{\n");
            printConstructors(cl);
            System.out.println();
            printMethods(cl);
            System.out.println();
            printFields(cl);
            System.out.println("}");
        }
        catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        }

        System.exit(0);
    }

    /**
     * Print all constructors of a class
     * @param cl a class
     */
    public static void printConstructors(Class cl)
    {
        Constructor[] constructors = cl.getDeclaredConstructors();

        for (Constructor c : constructors)
        {
            String name = c.getName();
            System.out.println("   ");
            String modifiers = Modifier.toString(c.getModifiers());
            if (modifiers.length() > 0) System.out.print(modifiers + " ");
            System.out.print(name + "(");

            //print parameter types
            Class[] paramTypes = c.getParameterTypes();
            for (int i=0; i<paramTypes.length; i++)
            {
                if (i>0) System.out.print(", ");
                System.out.print(paramTypes[i].getName());
            }
            System.out.println(");");
        }
    }

    /**
     * Print all methods of a class
     * @param cl a class
     */
    public static void printMethods(Class cl)
    {
        Method[] methods = cl.getDeclaredMethods();

        for (Method m : methods)
        {
            Class retType = m.getReturnType();
            String name = m.getName();
            System.out.println("   ");

            String modifiers = Modifier.toString(m.getModifiers());
            if (modifiers.length() > 0) System.out.print(modifiers + " ");
            System.out.print(retType.getName() + " " + name + "(");

            //print parameter types
            Class[] paramTypes = m.getParameterTypes();
            for (int i=0; i<paramTypes.length; i++)
            {
                if (i>0) System.out.print(", ");
                System.out.print(paramTypes[i].getName());
            }
            System.out.println(");");
        }
    }

    /**
     * Print all constructors of a class
     * @param cl a class
     */
    public static void printFields(Class cl)
    {
        Field[] fields = cl.getDeclaredFields();

        for (Field f : fields)
        {
            Class type = f.getType();
            String name = f.getName();
            System.out.println("   ");

            String modifiers = Modifier.toString(f.getModifiers());
            if (modifiers.length() > 0) System.out.print(modifiers + " ");
            System.out.println(type.getName() + " " + name + ";");            
        }
    }
}