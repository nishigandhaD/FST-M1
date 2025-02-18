package activities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity1 {
	//Declare appium driver
	AndroidDriver driver;
	
	@BeforeClass
	public void setUp() throws MalformedURLException, URISyntaxException{
		//setup
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.android.calculator2");
		options.setAppActivity(".Calculator");
		options.noReset();
		
		//Server URL
		URL serverURL =new URI("http://localhost:4723").toURL();
		//URL serverURL = URI.create("http://localhost:4723").toURL();
		
		//Initialize of driver
		driver = new AndroidDriver(serverURL,options);
		
		
	}
	
	@Test
	public void addTest() {
		//find digit 5 and tap it
		driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_5")).click();
		//find plus symbol and tap it
		driver.findElement(AppiumBy.accessibilityId("×")).click();
		//find digit 9 and tap it
		driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_8")).click();
		//find equal to symbol and tap it
		driver.findElement(AppiumBy.accessibilityId("equals")).click();
		
		String result = driver.findElement(AppiumBy.id("com.android.calculator2:id/result")).getText();
		
		Assert.assertEquals(result, "40");
		
	}
	
	@AfterClass
	public void tearDown() {
		//close the app
		driver.quit();
	}

}
