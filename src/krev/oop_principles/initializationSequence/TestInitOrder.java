package krev.oop_principles.initializationSequence;

import krev.oop_principles.nestedClasses.OuterClass;

public class TestInitOrder {
    public static void main(String[] args) {
        Cat cat = new Cat("Rizhick");
    }
    /**
     * //Output:
     * Static block in Pet
     * Static block in Cat
     * First block in Pet
     * Second block in Pet
     * Pet constructor with Name Rizhick
     * First block in Cat
     * Second block in Cat
     * Cat constructor with Name: Rizhick
     */
}
