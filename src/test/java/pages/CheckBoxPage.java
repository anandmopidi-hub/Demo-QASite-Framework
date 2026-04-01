package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.ActionUtil;
import utils.LoggerUtil;


public class CheckBoxPage {
	 WebDriver driver;
	 
	    // Fix: Constructor was missing WebDriver parameter — changed from
	    // public CheckBoxPage() {}  →  public CheckBoxPage(WebDriver driver)
	    public CheckBoxPage(WebDriver driver) {
	        this.driver = driver;
	    }
	 
	    public void selectCheckBox() {
	        LoggerUtil.info("Navigating to CheckBox Page");
	        new HomePage(driver).goToElements();
	        ActionUtil.click(driver, By.xpath("//span[text()='Check Box']"));
	        LoggerUtil.info("Expanding All Nodes");
	        ActionUtil.click(driver, By.xpath("//button[@title='Expand all']"));
	        LoggerUtil.info("Selecting Documents Checkbox");
	        ActionUtil.click(driver, By.xpath("//span[text()='Documents']"));
	        LoggerUtil.pass("Documents Checkbox Selected");
	    }
	}
	 