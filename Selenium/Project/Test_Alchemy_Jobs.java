package Selenium_Project;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Test_Alchemy_Jobs {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void setUp() {
	driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		driver.get("https://alchemy.hguy.co/jobs");
		
	}
	
	
	@Test (priority=1)
	public void webTitle() 
	{
		
	 Assert.assertEquals(driver.getTitle(), "Alchemy Jobs – Job Board Application");
			
	}
	@Test (priority=2)
	public void webHeading() 
	{
		String Heading=driver.findElement(By.xpath("//h1[@class='entry-title']")).getText();
		Assert.assertEquals(Heading, "Welcome to Alchemy Jobs");
	}
	
	@Test (priority=3)
	public void imageUrl() {
		WebElement image=driver.findElement(By.xpath("//img[@itemprop='image']"));
		String imageUrl=image.getAttribute("src");
	    System.out.println("The image URL is: "+ imageUrl);
	}
	@Test(priority=4)
	public void secoundheading() {
		String secoundheading= driver.findElement(By.xpath("//h2[text()='Quia quis non']")).getText();
		Assert.assertEquals(secoundheading, "Quia quis non");
	}
	
	@Test (priority=5)
	public void navigatePage() {
		
		String pageUrl="https://alchemy.hguy.co/jobs/jobs/";
		driver.findElement(By.linkText("Jobs")).click();
		Assert.assertEquals(pageUrl, driver.getCurrentUrl());
		
		
	}
	@Test (dependsOnMethods = {"navigatePage"})
	public void applyJobs() {
		driver.findElement(By.id("search_keywords")).sendKeys("Testing");
		driver.findElement(By.xpath("//input[@value='Search Jobs']")).click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@class='company_logo']")));
		element.click();
		
		driver.findElement(By.xpath("//input[@value='Apply for job']")).click();
		
		String email=driver.findElement(By.className("job_application_email")).getText();
		System.out.println("To apply for this job email your details to:" + email);
	}
	
	@Test (priority=6)
	public void jobListing() {
		driver.findElement(By.linkText("Post a Job")).click();
		driver.findElement(By.id("create_account_email")).sendKeys("cisco95@gmail.com");
		driver.findElement(By.id("job_title")).sendKeys("Automation Tester");
		
		Select option=new Select (driver.findElement(By.id("job_type")));
		
		option.selectByValue("3");
		driver.findElement(By.id("job_description_ifr")).sendKeys("5 years of experience is required.");
		driver.findElement(By.id("application")).sendKeys("https://www.cisco.com/c/en/us/about/careers.html");
		driver.findElement(By.id("company_name")).sendKeys("cisco");
		
		driver.findElement(By.xpath("//input[@value='Preview']")).click();
		driver.findElement(By.id("job_preview_submit_button")).click();
		
		
		//driver.findElement(By.linkText("click here")).click();
		
		driver.findElement(By.linkText("Jobs")).click();
		driver.findElement(By.id("search_keywords")).clear();
		driver.findElement(By.xpath("//input[@value='Search Jobs']")).click();
		List<WebElement> companyName =driver.findElements(By.xpath("//div[@class='company']"));
		
		for (int i = 0; i < companyName.size(); i++) {
		    String text = companyName.get(i).getText();
		    if (text.contains("Cisco")) {          
		        Assert.assertEquals(text, "Cisco");
		        break;
		    }
		}
		
		
	}
	
	
	
	
	@AfterClass
	public void cleanUp() {
		driver.close();
	}
	
	
	
	
	
	
	
	

}
