package testng;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Activity6 {
	WebDriver driver;
	WebDriverWait wait;
	@BeforeClass
	public void setUp() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
		driver.get("https://training-support.net/webelements/login-form");
	}
	
	@Test
	@Parameters({"username","password" , "message"})
	public void authenticate(String username, String password , @Optional("Login Success!") String message){
		WebElement userName = driver.findElement(By.xpath("//*[@id='username']"));
		userName.sendKeys(username);
		
		WebElement Password = driver.findElement(By.xpath("//*[@id='password']"));
		Password.sendKeys(password);
		
		WebElement login = driver.findElement(By.xpath("//button[text()='Submit']"));
		login.click();
		
		wait.until(ExpectedConditions.titleContains("Success"));
		 
        // Assert login message
        String loginMessage = driver.findElement(By.cssSelector("h2.text-center")).getText();
        assertEquals(loginMessage,"Welcome Back, Admin!");
		
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
