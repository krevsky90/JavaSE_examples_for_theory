package krev.oop_principles.extension_area_of_visibility;

public class Child extends Parent {
    //can write anything since it is not extension. because private method (of Parent class) cannot be extended
    private void methodPrivate() {

    }


    //can extend area of visibility (i.e. protected -> public)
    public void methodProtected() {

    }
    //canNOT decrease area of visibility (i.e. protected -> private or public -> protected or protected -> default)
//    private void methodProtected() {
//
//    }

}
