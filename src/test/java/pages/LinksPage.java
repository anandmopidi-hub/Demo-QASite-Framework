package pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.ActionUtil;
import utils.LoggerUtil;

public class LinksPage {
	 WebDriver driver;
	 
	    public LinksPage(WebDriver driver) {
	        this.driver = driver;
	    }
	 
	    // Fix 1: Added open() helper to navigate to Links page from Elements
	    public void open() {
	        new HomePage(driver).goToElements();
	        ActionUtil.click(driver, By.xpath("//span[text()='Links']"));
	    }
	 
	    public void handleLinks() {
	        LoggerUtil.info("Opening Links Page");
	        open();
	        String parent = driver.getWindowHandle();
	 
	        LoggerUtil.info("Clicking Simple Link");
	        ActionUtil.click(driver, By.id("simpleLink"));
	        switchAndCloseTab(parent);
	 
	        LoggerUtil.info("Clicking Dynamic Link");
	        ActionUtil.click(driver, By.id("dynamicLink"));
	        switchAndCloseTab(parent);
	 
	        LoggerUtil.pass("Links Handled Successfully");
	    }
	 
	    // Fix 2: Renamed switchTab → switchAndCloseTab to clearly describe behaviour:
	    //        it switches to any new child tab, closes it, and returns to parent.
	    //        The original name was misleading — it was doing close+switch, not just switch.
	    private void switchAndCloseTab(String parent) {
	        Set<String> windows = driver.getWindowHandles();
	        for (String w : windows) {
	            if (!w.equals(parent)) {
	                driver.switchTo().window(w);
	                LoggerUtil.info("Switched to Child Tab — closing it");
	                driver.close();
	            }
	        }
	        driver.switchTo().window(parent);
	        LoggerUtil.info("Returned to Parent Tab");
	    }
	}