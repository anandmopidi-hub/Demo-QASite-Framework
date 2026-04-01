package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.ActionUtil;
import utils.LoggerUtil;


public class TextBoxPage {
	WebDriver driver;
	 
    public TextBoxPage(WebDriver driver) {
        this.driver = driver;
    }
 
    public void open() {
        LoggerUtil.info("Navigating to Elements Section");
        // Fix 1: Navigate to home first before clicking Elements
        new HomePage(driver).goToElements();
        LoggerUtil.info("Clicking Text Box menu item");
        // Fix 2: Use text-based XPath for reliability instead of index-based id
        ActionUtil.click(driver, By.xpath("//span[text()='Text Box']"));
        LoggerUtil.pass("Text Box Page Opened");
    }
 
    public void fillForm() {
        LoggerUtil.info("Filling Text Box Form");
        ActionUtil.type(driver, By.id("userName"), "Anand");
        ActionUtil.type(driver, By.id("userEmail"), "anand@test.com");
        ActionUtil.type(driver, By.id("currentAddress"), "Ahmedabad");
        ActionUtil.type(driver, By.id("permanentAddress"), "Ahmedabad");
        ActionUtil.click(driver, By.id("submit"));
        LoggerUtil.pass("Form Submitted Successfully");
    }
}


