package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;


public class Activity6 {
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
	        driver.get("https://training-support.net/webelements/sliders");
	        
	    }
	    
	    
	  
	    
	    @Test(priority=1)
	    public void slider75Test() throws InterruptedException{
	    	
	    	
			wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.SeekBar")));
			// Get the size of the screen
			Dimension dims = driver.manage().window().getSize();
			// Set the start and end points
			Point start = new Point((int) (dims.getWidth() * .50), (int) (dims.getHeight() * .73));
			Point end = new Point((int) (dims.getWidth() * .67), (int) (dims.getHeight() * .72));
			// Perform swipe
			ActionsBase.doSwipe(driver, start, end, 2000);
	 
		    Thread.sleep(1000);

		    // Fetch and print volume text
		    String volumeText = driver
					.findElement(AppiumBy.xpath("//android.view.View/android.widget.TextView[contains(@text, '%')]"))
					.getText();
		    
		   System.out.println("The voulme button is on: "+volumeText);
		 
				// Assertions
				assertTrue(volumeText.contains("75%"));
		}
	 
	    @Test(priority=2)
		public void slider25Test() throws InterruptedException {
			// Wait for page to load
			wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.SeekBar")));
			// Get the size of the screen
			Dimension dims = driver.manage().window().getSize();
			// Set the start and end points
			Point start = new Point((int) (dims.getWidth() * .50), (int) (dims.getHeight() * .72));
			Point end = new Point((int) (dims.getWidth() * .34), (int) (dims.getHeight() * .72));
			// Perform swipe
			ActionsBase.doSwipe(driver, start, end, 2000);
			
		    Thread.sleep(1000);
	 
			// Get the volume level
		    String volumeText = driver
					.findElement(AppiumBy.xpath("//android.view.View/android.widget.TextView[contains(@text, '%')]"))
					.getText();
		    
		   System.out.println("The voulme button is on: "+volumeText);
			 
			 Thread.sleep(1000);
			// Assertions
			assertTrue(volumeText.contains("25%"));
			
		}



	    @AfterClass
	    public void tearDown() {
	        
	            driver.quit();
	        
	    }

}
