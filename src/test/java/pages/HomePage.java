package pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;


import utils.ActionUtil;
import utils.LoggerUtil;
import utils.WaitUtil;

public class HomePage {
	  WebDriver driver;
	  
	    public HomePage(WebDriver driver) {
	        this.driver = driver;
	    }
	 
	    public void goToElements() {
	        driver.get("https://demoqa.com/");
	        LoggerUtil.info("Navigating to Elements");
	        ActionUtil.click(driver,
	            By.xpath("//div[@class='card mt-4 top-card'][.//h5[text()='Elements']]"));
	        WaitUtil.waitForUrlContains(driver, "elements");
	        LoggerUtil.pass("Elements section opened");
	    }
	}
	 
	 