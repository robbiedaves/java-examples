package com.robbiedaves.javaexamples.predicates;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateSearch {

    public static void testPredicateSearch(String[] args) {
        List<Animal> animals = new ArrayList<>(); // List of animals
        animals.add(new Animal("Fish", false, true));
        animals.add(new Animal("Kangaroo", true, false));
        animals.add(new Animal("Rabbit", true, false));
        animals.add(new Animal("Turtle", false, true));

        // The below are examples of how we can use our interface (CheckTrait)
        printWithCheckTrait(animals, new CheckIfHopper(),
                "Old Fashioned CheckIfHopper example"); // pass class that does check
        // In the above example, if we wanted to check if the animal can swim,
        //    we would need another implementation of CheckTrait. But we can pass in a Lambda instead
        printWithCheckTrait(animals, a -> a.canHop(), "Lambda can hop example");
        printWithCheckTrait(animals, a -> a.canSwim(), "Lambda can swim example");

        // We could have not defined any interface and used a Predicate instead
        printWithPredicate(animals, a -> a.canHop(), "Predicate canHop example");
        printWithPredicate(animals, a -> a.canSwim(), "Predicate canSwim example");

        // In Java 8, some existing classes have predicates, like ArrayList.
        // In ArrayList there is a method removeIf() that takes a predicate.
        animals.removeIf(a -> a.toString().contains("oo")); // remove any animal with 'oo' in the name, i.e. Kangaroo
        printWithPredicate(animals, a -> true, "Predicate print all example");
    }

    // Print method with a CheckTrait interface parameter to filter the animals
    public static void printWithCheckTrait(List<Animal> animals, CheckTrait checker, String filterTitle) {
        System.out.println(filterTitle);
        for (Animal animal : animals) {
            if (checker.test(animal)) {    // the general check
                System.out.print(animal + " ");
            }
        }
        System.out.println();
    }

    // Print method with a Predicate interface parameter to filter the animals
    public static void printWithPredicate(List<Animal> animals, Predicate<Animal> checker, String filterTitle) {
        System.out.println(filterTitle);
        for (Animal animal : animals) {
            if (checker.test(animal)) {
                System.out.println(animal + " ");
            }
        }
        System.out.println();
    }

}
