package seleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 {
	WebDriver driver;
	
	@BeforeClass
	public void setUp(){
		driver = new FirefoxDriver();
		driver.get("http://alchemy.hguy.co/crm");
	}
	
	@Test
	public void url() {
		WebElement headerUrl = driver.findElement(By.xpath("//img[@alt='SuiteCRM']"));
		String imageUrl = headerUrl.getAttribute("src");
		System.out.println("The url of the header image is: "+imageUrl);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
