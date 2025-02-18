package seleniumActivities;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity4 {
	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/crm");
	}
	
	@Test(priority = 0)
	public void login() {
		WebElement userName = driver.findElement(By.id("user_name"));
		WebElement password = driver.findElement(By.id("username_password"));
		WebElement login = driver.findElement(By.id("bigbutton"));
		
		userName.sendKeys("admin");
		password.sendKeys("pa$$w0rd");
		login.click();
	}
	
	@Test(priority = 1 , dependsOnMethods = "login")
	public void homePage() {
		WebElement dashBoard = driver.findElement(By.id("tab0"));
		System.out.println("Dashboard text is: "+dashBoard.getText());
		assertTrue(dashBoard.isDisplayed(),"Homepage is not displayed , login not successfull");
		System.out.println("Login is successsfull and homepage is opened");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
