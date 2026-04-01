package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {
    public static WebDriver initDriver() {
        ChromeOptions options = new ChromeOptions();
 
        // Fix 1: --start-maximized ensures full page is visible
        options.addArguments("--start-maximized");
 
        // Fix 2: Required for Chrome 115+ to avoid WebSocket errors
        options.addArguments("--remote-allow-origins=*");
 
        // Fix 3: Disable popups/notifications that block clicks
        options.addArguments("--disable-notifications");
 
        // Fix 4: Disable infobars like "Chrome is being controlled by automated software"
        options.addArguments("--disable-infobars");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
 
        // Fix 5: Disable extensions that may interfere with tests
        options.addArguments("--disable-extensions");
 
        LoggerUtil.info("ChromeDriver initialized");
        return new ChromeDriver(options);
    }
}
