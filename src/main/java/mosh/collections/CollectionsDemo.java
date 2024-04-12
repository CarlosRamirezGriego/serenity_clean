package mosh.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.ArrayBlockingQueue;

public class CollectionsDemo {
    public static void show() {
        Collection<String> collection = new ArrayList<>();
        Collections.addAll(collection, "a", "b", "c", "d" ) ;
        System.out.println(collection.isEmpty());
        collection.clear();
        System.out.println(collection.isEmpty());
        Collection<String> other = new ArrayList<>();
        other.addAll(collection);
        for (String item : other)
        {
            System.out.println(item);
        }

        System.out.println(collection == other);
        System.out.println(collection.equals(other));
    }
}
