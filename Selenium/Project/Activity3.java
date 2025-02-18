package seleniumActivities;

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
		driver.get("http://alchemy.hguy.co/crm");
	}
	
	@Test
	public void copyRight() {
		WebElement firstCopyRight = driver.findElement(By.id("admin_options"));
		System.out.println("the first copy right text is: "+firstCopyRight.getText());
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
