package base;



import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;


import utils.DriverFactory;

public class BaseTest {

	public static WebDriver driver;
    public static WebDriverWait wait;
 
    @BeforeClass
    public void setup() {
        driver = DriverFactory.initDriver();
        // Fix 1: Navigate to base URL before tests begin
        driver.get("https://demoqa.com/");
        // Fix 2: Initialize WebDriverWait that was declared but never initialized
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        System.out.println("Browser Started");
    }
 
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            // Fix 3: Added null check before quit to avoid NullPointerException
            driver.quit();
        }
        System.out.println("Browser Closed");
    }
}


