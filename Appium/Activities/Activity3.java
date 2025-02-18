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

public class Activity3 {
	AndroidDriver driver;
	
	@BeforeClass
	public void setUp() throws MalformedURLException, URISyntaxException {
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.android.calculator2");
		options.setAppActivity(".Calculator");
		options.noReset();
		
		URL serverURL =  new URI("http://localhost:4723").toURL();
		driver = new AndroidDriver(serverURL,options);
		
		
	}
	
	@Test
	public void addTest() {
		driver.findElement(AppiumBy.id("digit_5")).click();
		driver.findElement(AppiumBy.accessibilityId("plus")).click();
		driver.findElement(AppiumBy.id("digit_9")).click();
		driver.findElement(AppiumBy.accessibilityId("equals")).click();
		String add = driver.findElement(AppiumBy.id("result")).getText();
		System.out.println("The result of 5 + 9 = "+add);	
		Assert.assertEquals(add, "14");
		
	}
	
	@Test
	public void subtractionTest() {
		driver.findElement(AppiumBy.id("digit_1")).click();
		driver.findElement(AppiumBy.id("digit_0")).click();
		driver.findElement(AppiumBy.accessibilityId("minus")).click();
		driver.findElement(AppiumBy.id("digit_5")).click();
		driver.findElement(AppiumBy.accessibilityId("equals")).click();
		String sub = driver.findElement(AppiumBy.id("result")).getText();
		System.out.println("The result of 10 - 5 = "+sub);	
		Assert.assertEquals(sub, "5");
	}
	
	@Test
	public void multiplicationTest() {
		driver.findElement(AppiumBy.id("digit_5")).click();
		driver.findElement(AppiumBy.accessibilityId("×")).click();
		driver.findElement(AppiumBy.id("digit_1")).click();
		driver.findElement(AppiumBy.id("digit_0")).click();
		driver.findElement(AppiumBy.id("digit_0")).click();
		driver.findElement(AppiumBy.accessibilityId("equals")).click();
		String multiply = driver.findElement(AppiumBy.id("result")).getText();
		System.out.println("The result of 5 * 100 = "+multiply);
		Assert.assertEquals(multiply, "500");
	}
	
	@Test
	public void divTest() {
		driver.findElement(AppiumBy.id("digit_5")).click();
		driver.findElement(AppiumBy.id("digit_0")).click();
		driver.findElement(AppiumBy.accessibilityId("divide")).click();
		driver.findElement(AppiumBy.id("digit_2")).click();
		driver.findElement(AppiumBy.accessibilityId("equals")).click();
		String division = driver.findElement(AppiumBy.id("result")).getText();
		System.out.println("The result of 50/2 = "+division);	
		Assert.assertEquals(division, "25");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
