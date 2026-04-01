package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import utils.ActionUtil;
import utils.LoggerUtil;
import utils.WaitUtil;

public class RadioButtonPage {
	  WebDriver driver;
	  
	    public RadioButtonPage(WebDriver driver) {
	        this.driver = driver;
	    }
	 
	    public void clickYes() {
	        new HomePage(driver).goToElements();
	        ActionUtil.click(driver, By.xpath("//span[text()='Radio Button']"));
	        WaitUtil.waitForUrlContains(driver, "radio-button");
	        LoggerUtil.info("Radio Button page opened");
	        ActionUtil.click(driver, By.cssSelector("label[for='yesRadio']"));
	        WaitUtil.waitForElement(driver,
	            By.xpath("//p[contains(@class,'mt-3')]//span[text()='Yes']"));
	        LoggerUtil.pass("Yes radio button selected");
	    }
	}
	 