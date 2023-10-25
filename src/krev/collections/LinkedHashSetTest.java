package krev.collections;

import java.util.LinkedHashSet;

public class LinkedHashSetTest {
    public static void main(String[] args) {
        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
        lhs.add(1);
        lhs.add(2);
        lhs.add(1);

        for (Integer i : lhs) {
//            System.out.println(lhs.get);    //there is no get method!
//            lhs.add(3);         //throws ConcurrentModificationException
            System.out.println(i);
        }

        System.out.println("");


    }
}
