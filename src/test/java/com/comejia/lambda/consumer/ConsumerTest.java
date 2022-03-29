package com.comejia.lambda.consumer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerTest {

    public static void main(String[] args) {
        // Consumer
        Consumer<String> c = System.out::println;
        c.accept("udemy");

        List<String> list = new ArrayList<>();
        list.add("arbol");
        list.add("casa");

        list.forEach(c);

        // Chaining Consumer
        Consumer<String> dbConsumer = s -> System.out.println("I am writing into DB :: " + s);
        Consumer<String> loggingConsumer = s -> System.out.println("I am writing into Log file :: " + s);

        Consumer<String> dbLogConsumer = dbConsumer.andThen(loggingConsumer);
        list.forEach(dbLogConsumer);

        Map<String, Consumer<String>> map = new HashMap<>();
        map.put("db", dbConsumer);
        map.put("log", loggingConsumer);
        map.put("dblog", dbLogConsumer);

        list.forEach(map.get(System.getenv("consumer_type")));

        // BiConsumer
        BiConsumer<String, Integer> biConsumer = (s, i) -> {
            System.out.println("My name :: " + s);
            System.out.println("My age :: " + i);
        };
        biConsumer.accept("udemy", 10);

        map.forEach((key, value) -> System.out.println("Key is :: " + key));
    }
}
