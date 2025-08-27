package Selenium_Project;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class adminLogin {

	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void setUp() {
	driver=new FirefoxDriver();
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); 
	driver.get("https://alchemy.hguy.co/jobs/wp-admin");
	
	}
	
	@Test 
	public void logIn() {
		driver.findElement(By.id("user_login")).sendKeys("​root");
		driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
		
		driver.findElement(By.id("wp-submit")).click();
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://alchemy.hguy.co/jobs/wp-admin/");
		
		
	}
	@Test (dependsOnMethods = {"logIn"})
	public void backendJobListing() {
		
		
		
		driver.findElement(By.xpath("//div[text()='Job Listings']")).click();
		driver.findElement(By.linkText("Add New")).click();
		//driver.findElement(By.id("toolbar-453335e9-8bb6-4eee-9f89-42c240cb0e81toolbar-453335e9-8bb6-4eee-9f89-42c240cb0e81")).click();
		driver.findElement(By.id("post-title-0")).sendKeys("Tester");
		driver.findElement(By.id("_company_website")).sendKeys("https://www.cisco.com/c/en/us/about/careers.html");
		driver.findElement(By.id("_company_twitter")).sendKeys("@Cisco");
		driver.findElement(By.id("_company_name")).sendKeys("Cisco");
		driver.findElement(By.id("_company_tagline")).sendKeys("Always there for your growth");
		driver.findElement(By.id("_company_video")).sendKeys("https://video.cisco.com/detail/video/6171341319001");
		//driver.findElement(By.xpath("//button[text()='publish...']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Publish')]")).click();
		
		driver.findElement(By.xpath("//button[text()='Publish']")).click();
		driver.navigate().back();
		driver.navigate().refresh();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='job_position']")));
		
		List<WebElement> position = driver.findElements(By.xpath("//div[@class='job_position']"));
		
		for (int i = 0; i < position.size(); i++) {
		    String text = position.get(i).getText();
		 
		    if (text.contains("Tester Cisco")) {          
		        Assert.assertEquals(text, "Tester Cisco");
		       break;
		    }
		}
	}
	
	
	
	
	@AfterClass
	public void cleanUp() {
		
		driver.close();
	}
	
}
