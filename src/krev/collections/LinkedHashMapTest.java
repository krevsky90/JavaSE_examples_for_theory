package krev.collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapTest {
    public static void main(String[] args) {
        LinkedHashMap<String, String> lhm = new LinkedHashMap<>();
        lhm.put("one", "a");
        lhm.put("two", "b");
        lhm.put("three", "c");
        lhm.put("four", "d");
        lhm.put("five", "e");
        lhm.put("six", "f");

        HashMap<String, String> hm = new HashMap<>();
        hm.put("one", "a");
        hm.put("two", "b");
        hm.put("three", "c");
        hm.put("four", "d");
        hm.put("five", "e");
        hm.put("six", "f");
        //
        System.out.println("LHM:");
        for (Map.Entry<String, String> e : lhm.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }

        System.out.println("HM:");
        for (Map.Entry<String, String> e : hm.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }
    }
}
