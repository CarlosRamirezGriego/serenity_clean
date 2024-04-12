package mosh.collections;

import org.htmlunit.corejs.javascript.NativeConsole;

public class LambdasDemo {
    public String prefix = "_";
    public static String prefixb = "_";


    public static void print(String message) {

    }

    public void show() {
        greet((message) -> {
            System.out.println(this.prefix + message);
        } );

    }

    public static void showb() {
        greet((message) -> {
            System.out.println(prefixb + message);
        } );

    }

    public static void showc() {
        greet(message -> print(message));
        greet(LambdasDemo::print);
    }


    public static void greet(Printer printer)
    {
        printer.print("Hello World");
    }
}
