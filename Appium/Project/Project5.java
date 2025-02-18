package liveprojects;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;


public class Project5 {
	 private AndroidDriver driver;
	    private WebDriverWait wait;

	    @BeforeClass
	    public void setUp() throws MalformedURLException, URISyntaxException {
	        UiAutomator2Options options = new UiAutomator2Options();
	        options.setPlatformName("android");
	        options.setAutomationName("UiAutomator2");
	        options.setAppPackage("com.android.chrome");
	        options.setAppActivity("com.google.android.apps.chrome.Main");
	        options.noReset();
	        URL serverURL = new URI("http://localhost:4723").toURL();

	        driver = new AndroidDriver(serverURL, options);
	        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	        
	        
	    }
	    
	    
	    @Test(priority=2)
	    public void ValidCredentials() throws InterruptedException {
	    	
	    	driver.get("https://v1.training-support.net/selenium");
	    	
	    	wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.Button[@text=\"Get Started!\"]")));
	    	 driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Get Started!\"]")).click();
	    	 
	    	 wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.view.View[contains(@text, 'Login Form')]"))).click();
	    	 
	    	 wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"username\"]")));
	    	 WebElement userName = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"username\"]"));
	    	 userName.sendKeys("admin");
	    	 
	    	 wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"password\"]")));
	    	 WebElement Password = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"password\"]"));
	    	 Password.sendKeys("password");
	    	 
	    	 Thread.sleep(1000);
	    	 driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Log in\"]")).click();
	    	 Thread.sleep(1000);
	    	 String confirmationMsg = driver.findElement(AppiumBy.xpath("//android.view.View[@resource-id=\"action-confirmation\"]")).getText();
	    	 System.out.println("Valid Credentials: "+confirmationMsg);
	    	 Assert.assertEquals("Welcome Back, admin", confirmationMsg , "Message is not same");

	    }
	    
	    @Test(priority=1)
	    public void InValidCredentials() throws InterruptedException {
	    	
	    	driver.get("https://v1.training-support.net/selenium");
	    	
	    	wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.Button[@text=\"Get Started!\"]")));
	    	 driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Get Started!\"]")).click();
	    	 
	    	 wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.view.View[contains(@text, 'Login Form')]"))).click();
	    	 
	    	 wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"username\"]")));
	    	 WebElement userName = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"username\"]"));
	    	 userName.sendKeys("Admin");
	    	 
	    	 wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"password\"]")));
	    	 WebElement Password = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"password\"]"));
	    	 Password.sendKeys("password");
	    	 
	    	 Thread.sleep(1000);
	    	 driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Log in\"]")).click();
	    	 Thread.sleep(1000);
	    	 String confirmationMsg = driver.findElement(AppiumBy.xpath("//android.view.View[@resource-id=\"action-confirmation\"]")).getText();
	    	 System.out.println("Wrong Credentials: "+confirmationMsg);
	    	 Assert.assertEquals("Invalid Credentials", confirmationMsg , "Message is not same");

	    }
	    

	    @AfterClass
	    public void tearDown() {
	        
	            driver.quit();
	        
	    }

}
