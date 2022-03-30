package com.comejia.lambda.predicate;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Rules {

    private static final Predicate<WebElement> isBlank = e -> e.getText().trim().length() == 0;
    private static final Predicate<WebElement> hasS = e -> e.getText().toLowerCase().contains("s");

    public static List<Predicate<WebElement>> get() {
        List<Predicate<WebElement>> predicate = new ArrayList<>();
        predicate.add(isBlank);
        predicate.add(hasS);
        return predicate;
    }
}
