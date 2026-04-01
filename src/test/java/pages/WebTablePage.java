package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.ActionUtil;
import utils.LoggerUtil;

public class WebTablePage {
	 WebDriver driver;
	 
	    public WebTablePage(WebDriver driver) {
	        this.driver = driver;
	    }
	 
	    public void addUser() {
	        LoggerUtil.info("Navigating to Web Tables Page");
	        // Fix 1: Navigate to Elements section first before clicking Web Tables
	        new HomePage(driver).goToElements();
	        ActionUtil.click(driver, By.xpath("//span[text()='Web Tables']"));
	        LoggerUtil.info("Clicking Add New Record Button");
	        ActionUtil.click(driver, By.id("addNewRecordButton"));
	        LoggerUtil.info("Entering User Details");
	        ActionUtil.type(driver, By.id("firstName"), "Anand");
	        ActionUtil.type(driver, By.id("lastName"), "Kumar");
	        ActionUtil.type(driver, By.id("userEmail"), "anand@test.com");
	        ActionUtil.type(driver, By.id("age"), "25");
	        ActionUtil.type(driver, By.id("salary"), "25000");
	        ActionUtil.type(driver, By.id("department"), "QA");
	        LoggerUtil.info("Submitting Registration Form");
	        ActionUtil.click(driver, By.id("submit"));
	        LoggerUtil.pass("User Added Successfully");
	    }
	}