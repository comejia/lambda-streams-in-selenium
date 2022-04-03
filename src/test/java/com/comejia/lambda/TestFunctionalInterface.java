package com.comejia.lambda;

import com.comejia.lambda.calculator.MathOperation;

import java.util.ArrayList;
import java.util.List;

public class TestFunctionalInterface {

    public static void main(String[] args) {
        GreetingService g = new GreetingService() {
            @Override
            public void greet(String name) {
                System.out.println("Hi ... " + name);
            }
        };
        g.greet("cesar");

        GreetingService g2 = name -> System.out.println("Hello ... " + name);
        g2.greet("octavio");


        List<String> list = new ArrayList<>();
        //StringOperations op = String::concat;
        StringOperations op = list::add;
        op.accept("udemy");
        //System.out.println(op.accept("udemy", "teco"));
        System.out.println(list);


        MathOperation add = Integer::sum;
        MathOperation subtract = (a, b) -> a - b;
        MathOperation div = (a, b) -> a / b;
        MathOperation mul = (a, b) -> a * b;

        int onScreenNumber = 5;
        onScreenNumber = calculate(onScreenNumber, add, 2);
        onScreenNumber = calculate(onScreenNumber, subtract, 3);
        onScreenNumber = calculate(onScreenNumber, mul, 7);
        onScreenNumber = calculate(onScreenNumber, add, 2);
        onScreenNumber = calculate(onScreenNumber, div, 3);

        System.out.println(onScreenNumber);
    }

    private static int calculate(int onScreenNumber, MathOperation mathOperation, int enteredNumber) {
        return mathOperation.operate(onScreenNumber, enteredNumber);
    }
}
