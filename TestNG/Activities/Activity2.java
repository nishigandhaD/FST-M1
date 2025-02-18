package testng;
import org.testng.SkipException;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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
	public void setUp() {
		driver = new FirefoxDriver();
		driver.get("https://training-support.net/webelements/target-practice/");
		
	}
	
	@Test
	public void testCase1() {
		assertEquals(driver.getTitle(),"Selenium: Target Practice","The title of the page is not same");
		
	}
	
	@Test
	public void testCase2() {
		WebElement blackBut = driver.findElement(By.cssSelector("button.black"));
		assertTrue(blackBut.isDisplayed());
		assertEquals(blackBut.getText(),"black","The text of black button is not black");
		
	}
	
	@Test(enabled=false)
	public void testCase3() {
		System.out.println("This method is not ready to be tested yet");
		
	}
	
	@Test
	public void testCase4(){
		
			throw new SkipException("Skipping this test as it is not ready to be tested yet");
		}
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
