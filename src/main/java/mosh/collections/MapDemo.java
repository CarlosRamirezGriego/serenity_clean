package mosh.collections;

import java.util.*;

public class MapDemo {
    public static void show(){
        Customer c1 = new Customer("a", "e1");
        Customer c2 = new Customer("b", "e2");
        Customer c3 = new Customer("c", "e3");
        Map<String, Customer> map = new HashMap<>();
        map.put(c1.getEmail(), c1);
        map.put(c2.getEmail(), c2);
        map.put(c3.getEmail(), c3);

        Customer s = map.get("e2");
        System.out.println(s);
    }
}
