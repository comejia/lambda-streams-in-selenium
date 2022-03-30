package com.comejia.lambda.function;

import java.util.function.Function;

public class FunctionTest {

    public static void main(String[] args) {

        Function<String, Integer> strLen = String::length;
        Function<Integer, Integer> square = i -> i * i;

        System.out.println(strLen.apply("hi, how are you"));
        System.out.println(strLen.andThen(square).apply("hi, how are you"));

        // andThen vs compose
        Function<Integer, Integer> plus2 = i -> i + 2;
        System.out.println(plus2.andThen(square).apply(8));
        System.out.println(plus2.compose(square).apply(8));

    }
}
