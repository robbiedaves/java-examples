package com.robbiedaves.javaexamples.lambda.predicates;

public class CheckIfHopper implements CheckTrait {

    public boolean test(Animal a) {
        return a.canHop();
    }
}