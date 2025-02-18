package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.List;


public class Activity7 {
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
	        driver.get("https://training-support.net/webelements/lazy-loading");
	        
	    }
	    
	    
	  
	    
	    @Test
	    public void Images() throws InterruptedException{
	    	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(AppiumBy.xpath("//android.widget.TextView[@text=\"Lazy Loading\"]")));
	    	
	    	String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
	    	
	    	List<WebElement> images = driver.findElements(AppiumBy.className("android.widget.Image"));
	    	System.out.println("Before scroll: " + images.size());
	    	
	    	String imageText = 
	    			driver.findElement(AppiumBy
	    			.androidUIAutomator(UiScrollable + ".scrollForward(25).getChildByText(className(\"android.widget.Image\"), \"Helen\")"))
	    			.getText();
			System.out.println("Found " + imageText + "!");
			

	    	images = driver.findElements(AppiumBy.className("android.widget.Image"));
	    	System.out.println("After scroll: " + images.size());
	    	
	    	Assert.assertEquals(images.size(), 3);
	    }


	    @AfterClass
	    public void tearDown() {
	        
	            driver.quit();
	        
	    }

}
