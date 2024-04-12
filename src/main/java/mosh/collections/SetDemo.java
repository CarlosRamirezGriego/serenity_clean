package mosh.collections;

import java.util.*;

public class SetDemo {
    public static void show(){
        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("c");
        set.add("a");
        System.out.println(set);

        Collection<String> coll = new ArrayList<>();
        Collections.addAll(coll, "a", "b", "c", "d", "a", "d");
        Set<String> setb = new HashSet<>(coll);
        System.out.println(setb);


        Set<String> setc = new HashSet<>(Arrays.asList("a", "b","c","d"));
        Set<String> setd = new HashSet<>(Arrays.asList("d", "e","f","g"));

        // Union
        //setc.addAll(setd);
        //System.out.println(setc);

        //Intersecion
        //setc.retainAll(setd);
        //System.out.println(setc);

        //Difference
        setc.removeAll(setd);
        System.out.println(setc);

    }
}
