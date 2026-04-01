package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionUtil {
	 // Fix 1: Use JavaScript click instead of normal .click()
    //        DemoQA has sticky ad banners that cause ElementClickInterceptedException
    public static void click(WebDriver driver, By locator) {
        WebElement element = WaitUtil.waitForElementClickable(driver, locator);
        try {
            element.click();
        } catch (Exception e) {
            // Fallback to JS click if normal click is intercepted by ads
            LoggerUtil.info(null);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }
 
    public static void type(WebDriver driver, By locator, String value) {
        WebElement element = WaitUtil.waitForElement(driver, locator);
        element.clear();
        element.sendKeys(value);
    }
}