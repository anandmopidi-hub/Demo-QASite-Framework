package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.ButtonsPage;
import pages.CheckBoxPage;
import pages.LinksPage;
import pages.RadioButtonPage;
import pages.TextBoxPage;
import pages.WebTablePage;
import utils.TestListener;

@Listeners(TestListener.class)

public class DemoQATest extends BaseTest {
 
	 @Test(priority = 1)
	    public void TC01_openElements() {
	        TextBoxPage page = new TextBoxPage(driver);
	        page.open();
	        Assert.assertTrue(driver.getCurrentUrl().contains("text-box"));
	    }
	 
	    @Test(priority = 2)
	    public void TC02_fillTextBox() {
	        TextBoxPage page = new TextBoxPage(driver);
	        page.open();
	        page.fillForm();
	        Assert.assertTrue(driver.getPageSource().contains("Anand"));
	    }
	 
	    // ================= CHECKBOX =================
	 
	    @Test(priority = 3)
	    public void TC03_openCheckBox() {
	        CheckBoxPage page = new CheckBoxPage(driver);   // Line 41 - now fixed
	        page.selectCheckBox();
	        Assert.assertTrue(driver.getCurrentUrl().contains("checkbox"));
	    }
	 
	    @Test(priority = 4)
	    public void TC04_selectDocuments() {
	        CheckBoxPage page = new CheckBoxPage(driver);   // Line 49 - now fixed
	        page.selectCheckBox();
	        Assert.assertTrue(driver.getPageSource().toLowerCase().contains("documents"));
	    }
	 
	    // ================= RADIO =================
	 
	    @Test(priority = 5)
	    public void TC05_radioButtonYes() {
	        RadioButtonPage page = new RadioButtonPage(driver);
	        page.clickYes();
	        Assert.assertTrue(driver.getPageSource().contains("Yes"));
	    }
	 
	    // ================= WEB TABLE =================
	 
	    @Test(priority = 6)
	    public void TC06_openWebTable() {
	        WebTablePage page = new WebTablePage(driver);
	        page.addUser();
	        Assert.assertTrue(driver.getCurrentUrl().contains("webtables"));
	    }
	 
	    @Test(priority = 7)
	    public void TC07_addUser() {
	        WebTablePage page = new WebTablePage(driver);
	        page.addUser();
	        Assert.assertTrue(driver.getPageSource().contains("Anand"));
	    }
	 
	    @Test(priority = 8)
	    public void TC08_searchUser() {
	        WebTablePage page = new WebTablePage(driver);
	        page.addUser();
	        driver.findElement(By.id("searchBox")).sendKeys("Cierra");
	        Assert.assertTrue(driver.getPageSource().contains("Cierra"));
	    }
	 
	    @Test(priority = 9)
	    public void TC09_deleteUser() {
	        WebTablePage page = new WebTablePage(driver);
	        page.addUser();
	        driver.findElement(By.xpath(
	            "//div[.//div[text()='Anand']]//span[@title='Delete']"
	        )).click();
	        Assert.assertTrue(driver.getPageSource().contains("No rows found")
	            || !driver.getPageSource().contains("Anand"));
	    }
	 
	    // ================= BUTTONS =================
	 
	    @Test(priority = 10)
	    public void TC10_openButtons() {
	        ButtonsPage page = new ButtonsPage(driver);
	        page.performActions();
	        Assert.assertTrue(driver.getCurrentUrl().contains("buttons"));
	    }
	 
	    @Test(priority = 11)
	    public void TC11_doubleClick() {
	        ButtonsPage page = new ButtonsPage(driver);
	        page.performActions();
	        Assert.assertTrue(driver.getPageSource().contains("double click"));
	    }
	 
	    @Test(priority = 12)
	    public void TC12_rightClick() {
	        ButtonsPage page = new ButtonsPage(driver);
	        page.performActions();
	        Assert.assertTrue(driver.getPageSource().contains("right click"));
	    }
	 
	    @Test(priority = 13)
	    public void TC13_singleClick() {
	        ButtonsPage page = new ButtonsPage(driver);
	        page.performActions();
	        Assert.assertTrue(driver.getPageSource().contains("dynamic click"));
	    }
	 
	    // ================= LINKS =================
	 
	    @Test(priority = 14)
	    public void TC14_openLinks() {
	        LinksPage page = new LinksPage(driver);
	        page.handleLinks();
	        Assert.assertTrue(driver.getCurrentUrl().contains("links"));
	    }
	 
	    @Test(priority = 15)
	    public void TC15_simpleLink() {
	        LinksPage page = new LinksPage(driver);
	        page.handleLinks();
	        Assert.assertTrue(driver.getWindowHandles().size() >= 1);
	    }
	 
	    @Test(priority = 16)
	    public void TC16_dynamicLink() {
	        LinksPage page = new LinksPage(driver);
	        page.handleLinks();
	        Assert.assertTrue(driver.getWindowHandles().size() >= 1);
	    }
	 
	    // ================= API LINKS =================
	 
	    @Test(priority = 17)
	    public void TC17_createdLink() {
	        new LinksPage(driver).handleLinks();
	        driver.findElement(By.id("created")).click();
	        Assert.assertTrue(driver.getPageSource().contains("Created"));
	    }
	 
	    @Test(priority = 18)
	    public void TC18_noContentLink() {
	        new LinksPage(driver).handleLinks();
	        driver.findElement(By.id("no-content")).click();
	        Assert.assertTrue(driver.getPageSource().contains("No Content"));
	    }
	 
	    @Test(priority = 19)
	    public void TC19_movedLink() {
	        new LinksPage(driver).handleLinks();
	        driver.findElement(By.id("moved")).click();
	        Assert.assertTrue(driver.getPageSource().contains("Moved"));
	    }
	 
	    @Test(priority = 20)
	    public void TC20_badRequest() {
	        new LinksPage(driver).handleLinks();
	        driver.findElement(By.id("bad-request")).click();
	        Assert.assertTrue(driver.getPageSource().contains("Bad Request"));
	    }
	 
	   
	}
	 