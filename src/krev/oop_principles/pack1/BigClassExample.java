package krev.oop_principles.pack1;

import java.lang.invoke.MethodHandles;

/**
 * INFO#6: static is NOT allowed
 */
public class BigClassExample {
    private String privateField;
    protected String protectedField;
    public String publicField;

    private static String privateStaticField;
    protected static String protectedStaticField;
    public static String publicStaticField;


    private BigClassExample(String  v1) {
        /**
         * INFO#3
         * 1) constructor can set values to static fields
         * 2) constructor REWRITES the values that were set in static block {}
         */
        privateStaticField = "privateStaticField = constructor of " + MethodHandles.lookup().lookupClass().getSimpleName() + "(v1)";
        protectedStaticField = "protectedStaticField = constructor of " + MethodHandles.lookup().lookupClass().getSimpleName() + "(v1)";
        publicStaticField = "publicStaticField = constructor of " + MethodHandles.lookup().lookupClass().getSimpleName() + "(v1)";
    }

    protected BigClassExample(String  v1,String  v2) {
        //todo:
    }

    public BigClassExample(String v1, String v2, String v3) {
        //todo:
//        publicStaticField = 33;
    }

    //INFO#1: can't be static constructor!
//    public static BigClassExample() {}

    //INFO#2: this block can't be private/protected/public
    static {
        privateStaticField = "privateStaticField = static block of " + MethodHandles.lookup().lookupClass().getSimpleName();
        protectedStaticField = "protectedStaticField = static block of " + MethodHandles.lookup().lookupClass().getSimpleName();
        publicStaticField = "protectedStaticField = static block of " + MethodHandles.lookup().lookupClass().getSimpleName();

        //INFO#4: static block can't initialize non-static fields like privateField
    }

    public static void main(String[] args) {
        new BigClassExample("v1");

        System.out.println(privateStaticField);
        System.out.println(protectedStaticField);
        System.out.println(publicStaticField);

        new BigClassExample("1").privateMethod("1");
    }

    private void privateMethod(String v1) {
        System.out.println("call " + getClass().getEnclosingMethod().getName());
    }

    protected void protectedMethod(String v1) {}

    void defaultMethod(String v1) {}

    public void publicMethod(String v1) {}

    final public void finalPublicMethod(String v1) {}

    private static void privateStaticMethod() {}

    static void defaultStaticMethod() {}

    protected static void protectedStaticMethod() {}

    public static void publicStaticMethod() {}

    /**
     * INFO#5: all methods of sub class have access to
     * 1) all static fields and methods
     * 2) all non-static fields and methods
     * NO MATTER if is it private/protected/...
     */
    private class PrivateChildClass {
        private void privateChildMethod() {
            String f = privateField;
            String ff = privateStaticField;
            privateMethod("f");
            privateStaticMethod();
        }

        protected void protectedChileMethod() {
            String f = privateField;
            String ff = privateStaticField;
        }
    }


}
