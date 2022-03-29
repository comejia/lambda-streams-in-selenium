package com.comejia.lambda;

import com.comejia.lambda.supplier.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class SeleniumTest {

    private WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setDriver(@Optional("chrome") String browser) {
        this.driver = DriverFactory.getDriver(browser);
    }

    @Test
    public void googleTest() {
        this.driver.get("https://www.google.com/");
        this.driver.findElements(By.tagName("a"))
                .forEach(el -> System.out.println(el.getText()));
    }

    @AfterTest
    public void quitDriver() {
        this.driver.quit();
    }
}
