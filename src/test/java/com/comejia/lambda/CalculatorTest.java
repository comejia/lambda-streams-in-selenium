package com.comejia.lambda;

import com.comejia.lambda.calculator.Calculator;

public class CalculatorTest {

    public static void main(String[] args) {

        String exp = "5 + 2 - 3 * 7 + 2 / 3 ^ 2 % 3";

        Calculator.addOperation("^", (a, b) -> (int) Math.pow(a, b));
        Calculator.addOperation("%", (a, b) -> a % b);

        System.out.println(Calculator.calculate(exp));
    }
}
