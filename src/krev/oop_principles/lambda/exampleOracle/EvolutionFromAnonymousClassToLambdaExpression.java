package krev.oop_principles.lambda.exampleOracle;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EvolutionFromAnonymousClassToLambdaExpression {
    private final static EvolutionFromAnonymousClassToLambdaExpression instance = new EvolutionFromAnonymousClassToLambdaExpression();

    public static void main(String[] args) {
        List<Person> roster = Arrays.asList(
                new Person("name1", 20, "email1"),
                new Person("name2", 120, "email2"),
                new Person("name3", 2, "email3"),
                new Person("name4", 18, "email4")
        );

        instance.testApproach1(roster);
        instance.testApproach3(roster);
    }

    /**
     * Approach 1: Create Methods That Search for Members That Match One Characteristic
     */
    public void printPersonsOlderThan(List<Person> roster, int age) {
        for (Person p : roster) {
            if (p.getAge() >= age) {
                p.printPerson();
            }
        }
    }

    public void testApproach1(List<Person> roster) {
        printPersonsOlderThan(roster, 25);
    }

    /**
     * Approach 3: Specify Search Criteria Code in a Local Class
     */
    interface ICheckPerson {
        boolean test(Person p);
    }

    class CheckPersonEligible implements ICheckPerson {
        public boolean test(Person p) {
            return p.getGender() == Person.Sex.MALE
                    && p.getAge() >= 18
                    && p.getAge() <= 25;
        }
    }

    public void printPersons(List<Person> roster,
                             ICheckPerson tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    public void testApproach3(List<Person> roster) {
        printPersons(roster, new CheckPersonEligible());
    }

    /**
     * Approach 4: Specify Search Criteria Code in an Anonymous Class
     */
    public void testApproach4(List<Person> roster) {
        printPersons(roster, new ICheckPerson() {
            @Override
            public boolean test(Person p) {
                return p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25;
            }
        });
    }

    /**
     * Approach 5: Specify Search Criteria Code with a Lambda Expression
     */
    public void testApproach5(List<Person> roster) {
        printPersons(roster, (Person p) -> p.getGender() == Person.Sex.MALE
                && p.getAge() >= 18
                && p.getAge() <= 25
        );
    }

    /**
     * Approach 6: Use Standard Functional Interfaces with Lambda Expressions
     */
    public void printPersonsWithPredicate(List<Person> roster,
                                          Predicate<Person> tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    public void testApproach6(List<Person> roster) {
        printPersonsWithPredicate(roster, (Person p) -> p.getGender() == Person.Sex.MALE
                && p.getAge() >= 18
                && p.getAge() <= 25
        );
    }

    /**
     * Approach 7: Use Lambda Expressions Throughout Your Application
     * i.e. use lambda expression instead of calling printPerson
     */
    public void printPersonsWithPredicateAndConsumer(List<Person> roster,
                                                     Predicate<Person> tester,
                                                     Consumer<Person> consumer) {
        for (Person p : roster) {
            if (tester.test(p)) {
                consumer.accept(p);
            }
        }
    }

    public void testApproach7_1(List<Person> roster) {
        /**
         * NOTE: let's skip Person type since it is calculable
         */
        printPersonsWithPredicateAndConsumer(roster, p -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25,
                p -> p.printPerson()
        );
    }

    //Let's add Function interface to add new action: to get email and print it
    //NOTE: that we changed the type in Consumer from Person to String
    public void printPersonsWithPredicateAndConsumerAndFunction(List<Person> roster,
                                                                Predicate<Person> tester,
                                                                Function<Person, String> mapper,
                                                                Consumer<String> consumer) {
        for (Person p : roster) {
            if (tester.test(p)) {
                String data = mapper.apply(p);
                consumer.accept(data);
            }
        }
    }

    public void testApproach7_2(List<Person> roster) {
        printPersonsWithPredicateAndConsumerAndFunction(roster, p -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25,
                p -> p.getEmailAddress(),
                email -> System.out.println(email)
        );
    }

    /**
     * Approach 8: Use Generics More Extensively
     * i.e. replace Person with X, String with Y
     *
     * NOTE: I replace List<X> with Iterable<X> that is more abstract
     */
    public <X,Y> void printPersonsWithPredicateAndConsumerAndFunctionGenerics(Iterable<X> roster,
                                                                Predicate<X> tester,
                                                                Function<X, Y> mapper,
                                                                Consumer<Y> consumer) {
        for (X p : roster) {
            if (tester.test(p)) {
                Y data = mapper.apply(p);
                consumer.accept(data);
            }
        }
    }

    public void testApproach8(List<Person> roster) {
        printPersonsWithPredicateAndConsumerAndFunctionGenerics(roster, p -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25,
                p -> p.getEmailAddress(),
                email -> System.out.println(email)
        );
    }

    /**
     * Approach 9: Use Aggregate Operations That Accept Lambda Expressions as Parameters
     */
    public void testApproach9(List<Person> roster) {
        roster.stream().filter (
                            p -> p.getGender() == Person.Sex.MALE
                                && p.getAge() >= 18
                                && p.getAge() <= 25)
                        .map(p -> p.getEmailAddress())
                        .forEach(email  -> System.out.println(email)
        );
    }

}
