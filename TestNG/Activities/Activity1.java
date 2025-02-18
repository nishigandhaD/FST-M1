package testng;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1 {
	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		driver = new FirefoxDriver();
		driver.get("https://training-support.net/");
	}
	
	@Test(priority=0)
	public void homePageTest() {
		System.out.println("The title of the page is: "+driver.getTitle());
		assertEquals(driver.getTitle(),"Training Support","The title is the page is not same");
		WebElement aboutUS = driver.findElement(By.linkText("About Us"));
		aboutUS.click();
		
	}
	
	@Test(priority=1)
	public void aboutUsPage() {
		System.out.println("The title of the new page is: "+driver.getTitle());
		assertEquals(driver.getTitle(),"About Training Support","The title of new page is not same");
		
	}
	
	@AfterClass
	public void close() {
		driver.quit();
	}
	

}
