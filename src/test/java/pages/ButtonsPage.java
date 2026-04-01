package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import utils.ActionUtil;
import utils.LoggerUtil;


public class ButtonsPage {
	WebDriver driver;
	 
    public ButtonsPage(WebDriver driver) {
        this.driver = driver;
    }
 
    public void open() {
        new HomePage(driver).goToElements();
        ActionUtil.click(driver, By.xpath("//span[text()='Buttons']"));
    }
 
    public void doubleClick() {
        LoggerUtil.info("Performing Double Click");
        new Actions(driver)
            .doubleClick(driver.findElement(By.id("doubleClickBtn")))
            .perform();
    }
 
    public void rightClick() {
        LoggerUtil.info("Performing Right Click");
        new Actions(driver)
            .contextClick(driver.findElement(By.id("rightClickBtn")))
            .perform();
    }
 
    public void singleClick() {
        LoggerUtil.info("Performing Single Click");
        ActionUtil.click(driver, By.xpath("//button[text()='Click Me']"));
    }
 
    // This method was MISSING — caused the error in TC10 to TC13
    public void performActions() {
        LoggerUtil.info("Opening Buttons Page");
        open();
        doubleClick();
        rightClick();
        singleClick();
        LoggerUtil.pass("All Button Actions Completed");
    }
}