package seleniumActivities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1 {
	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		driver = new FirefoxDriver();
		driver.get("http://alchemy.hguy.co/crm");
		
	}
	
	@Test
	public void title() {
		String title = driver.getTitle();
		 System.out.println("Page Title: " + title);
		if(title.equals( "SuiteCRM")) {
			System.out.println("Title matches. Closing the browser.");
			driver.close();
			
		}
		else {
			System.out.println("Title doesn't matches");
		}
			
	}
	
}
