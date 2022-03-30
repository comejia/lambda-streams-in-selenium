package com.comejia.lambda.predicate;

import java.util.function.Predicate;

public class PredicateTest {

    public static void main(String[] args) {

        Predicate<Integer> isGt2 = n -> n > 2;
        Predicate<Integer> isLt10 = n -> n < 10;

        System.out.println(isGt2.test(5));
        System.out.println(isLt10.test(5));
        System.out.println(isGt2.and(isLt10).test(2));
        System.out.println(isGt2.negate().test(3));

    }
}
