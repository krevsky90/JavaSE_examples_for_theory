package krev.oop_principles.nestedClasses;

public class AnonymousClassesTest {
    interface HelloWorld {
        public void greet();
        public void greetSomeone(String someone);
    }

    public void sayHello() {

        //local class
        class EnglishGreeting implements HelloWorld {
            String name = "world";
            public void greet() {
                greetSomeone("world");
            }
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Hello, " + name);
            }
        }

        HelloWorld englishGreeting = new EnglishGreeting();

        //anonymous class
        HelloWorld frenchGreeting = new HelloWorld() {
            String name = "tout le monde";
            public void greet() {
                greetSomeone("tout le monde");
            }
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Salut, " + name);
            }
        };

        //anonymous class
        HelloWorld spanishGreeting = new HelloWorld() {
            String name = "Mundo";
            public void greet() {
                greetSomeone("Mundo");
            }
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Hola, " + name);
            }
        };
        englishGreeting.greet();
        frenchGreeting.greetSomeone("Fred");
        spanishGreeting.greet();
    }

    public static void main(String... args) {
        AnonymousClassesTest myApp = new AnonymousClassesTest();
        myApp.sayHello();
    }

}
