package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestActivity3 {
	WebDriver driver;
	
	@BeforeClass
	public void beforeMethod(){
	driver=new FirefoxDriver();
	
	driver.get("https://training-support.net/webelements/login-form/");
	}
	
	
	@Test
	public void logintest() {
		driver.findElement(By.id("username")).sendKeys("admin");;
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		String login_msg =driver.findElement(By.cssSelector("h1.text-center")).getText();
		Assert.assertEquals(login_msg, "Login Success!");
	}
	
	
	
	@AfterClass
	public void afterclass() {
		
		driver.close();
	}
	
	

}
