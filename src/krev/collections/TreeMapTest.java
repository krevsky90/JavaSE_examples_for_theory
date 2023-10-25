package krev.collections;

import java.util.TreeMap;

public class TreeMapTest {
    public static void main(String[] args) {
        TreeMap<MyKey, String> treeMap = new TreeMap<>();
        treeMap.put(new MyKey(1), "one");
        treeMap.put(new MyKey(2), "two");
    }

    /**
     * NOTE: if class is not Comparable then its object can't be put to TreeMap
     * if we try - we will get exception like 'MyKey cannot be cast to java.lang.Comparable'
     */
    static class MyKey implements Comparable {
        private int key;

        MyKey(int key) {
            this.key = key;
        }

        int getKey() {
            return this.key;
        }

        @Override
        public int compareTo(Object o) {
            return (o == null ?  -1 : (((MyKey)o).getKey() - key));
        }
    }
}
