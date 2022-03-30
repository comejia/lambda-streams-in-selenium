package com.comejia.lambda;

import com.comejia.lambda.predicate.Rules;
import com.comejia.lambda.supplier.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.util.List;
import java.util.function.Predicate;

public class SeleniumTest {

    private WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setDriver(@Optional("chrome") String browser) {
        this.driver = DriverFactory.getDriver(browser);
    }

    @Test
    public void driverWithSupplierTest() {
        this.driver.get("https://www.google.com/");
    }

    @Test
    public void consumerTest() {
        this.driver.get("https://www.google.com/");
        this.driver.findElements(By.tagName("a"))
                .forEach(el -> System.out.println(el.getText()));
    }

    @Test
    public void predicateTest() {
        this.driver.get("https://www.google.com/");
        List<WebElement> elements = this.driver.findElements(By.tagName("a"));

        Predicate<WebElement> isBlank = e -> e.getText().trim().length() == 0;

        System.out.println("Before :: " + elements.size());
        elements.removeIf(isBlank);
        System.out.println("After :: " + elements.size());

        System.out.println("Before remove ::" );
        elements.forEach(el -> System.out.println(el.getText()));

        Predicate<WebElement> hasS = e -> e.getText().toLowerCase().contains("s");
        elements.removeIf(hasS); // elements.removeIf(isBlank.or(hasS));
        System.out.println("After remove ::" );
        elements.forEach(el -> System.out.println(el.getText()));
    }

    @Test
    public void predicateWithRulesTest() {
        this.driver.get("https://www.google.com/");
        List<WebElement> elements = this.driver.findElements(By.tagName("a"));

        System.out.println("Before :: " + elements.size());

        Rules.get().forEach(elements::removeIf);

        System.out.println("After :: " + elements.size());

        elements.forEach(el -> System.out.println(el.getText()));

    }

    @AfterTest
    public void quitDriver() {
        this.driver.quit();
    }
}
