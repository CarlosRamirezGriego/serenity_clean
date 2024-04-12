package mosh.collections;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueuDemo {
    public static void show(){
        Queue<String> queue = new ArrayDeque<>();
        queue.add("c");
        queue.add("a");
        queue.add("b");
        queue.offer("d");
        String front = queue.peek();
        System.out.println(front);


    }
}
