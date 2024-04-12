package mosh.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ListDemo {
    public static void show() {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "a", "b", "c", "d", "b" ) ;
        list.set(0, "a+");
        System.out.println(list);
        System.out.println(list.indexOf("a+"));
        System.out.println(list.indexOf("tacos"));
        System.out.println(list.lastIndexOf("b"));;
        System.out.println(list.subList(1,3));


    }
}
