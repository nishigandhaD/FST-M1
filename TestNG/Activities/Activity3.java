package testng;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity3 {
	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		driver = new FirefoxDriver();
		driver.get("https://training-support.net/webelements/login-form/");
	}
	
	@Test
	public void credentials() {
		WebElement username = driver.findElement(By.xpath("//*[@id='username']"));
		username.sendKeys("admin");
		
		WebElement password = driver.findElement(By.xpath("//*[@id='password']"));
		password.sendKeys("password");
		
		WebElement login = driver.findElement(By.xpath("//button[text()='Submit']"));
		login.click();
		
		WebElement message = driver.findElement(By.xpath("//h2[contains(text(),'Welcome Back, Admin!')]"));
		String Message = message.getText();
		
		assertEquals("Welcome Back, Admin!",Message,"The confirmation message is wrong");
		
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
