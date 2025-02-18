package testng;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity5 {
	WebDriver driver;
	
	@BeforeClass(alwaysRun = true)
	public void setUp() {
		driver = new FirefoxDriver();
		driver.get("https://training-support.net/webelements/target-practice");
	}
	
	@Test (groups = {"HeaderTests","ButtonTests"})
	public void titleOfThePage() {
		System.out.println("The title of the page is "+driver.getTitle());
		assertEquals(driver.getTitle(),"Selenium: Target Practice","The title is not same");
	}
	
	@Test (dependsOnMethods = {"titleOfThePage"}, groups = {"HeaderTests"})
	public void HeaderTest1() {
		WebElement thirdHeader = driver.findElement(By.xpath("//h3[contains(text(), 'Heading #3')]"));
        System.out.println("The text of thirdHeader is: "+thirdHeader.getText());
	}
	
	@Test (dependsOnMethods = {"titleOfThePage"}, groups = {"HeaderTests"})
	public void HeaderTest2() {
        WebElement fifthHeader = driver.findElement(By.xpath("//h5[contains(text(), 'Heading #5')]"));
        System.out.println("The color of fifthHeader is: "+fifthHeader.getCssValue("Color"));
		
	}
	
	@Test (dependsOnMethods = {"titleOfThePage"}, groups = {"ButtonTests"})
	public void ButtonTest1() {
		WebElement emeraId = driver.findElement(By.xpath("//button[text()='Emerald']"));
		assertEquals(emeraId.getText(),"Emerald","The text of Emerald is not same");
	}
	
	@Test (dependsOnMethods = {"titleOfThePage"}, groups = {"ButtonTests"})
	public void ButtonTest2() {
		WebElement purpleButton = driver.findElement(By.xpath("//button[text()='Purple']"));
		assertEquals(purpleButton.getCssValue("color"), "rgb(88, 28, 135)");
        System.out.println("Color of purple Button: "+purpleButton.getCssValue("color"));
	}
	
	
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

}
