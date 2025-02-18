package activities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity2 {
	AndroidDriver driver;
	WebDriverWait wait;
	@BeforeClass
	public void setUp() throws MalformedURLException,URISyntaxException{
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.android.chrome");
		options.setAppActivity("com.google.android.apps.chrome.Main");
		options.noReset();
		
		URL serverURL = new URI("http://localhost:4723").toURL();
		driver = new AndroidDriver(serverURL,options);
		
		driver.get("https://training-support.net/");
		
	}
	
	@Test
	public void webTest() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement heading = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.view.View[@text=\"Training Support\"]")));
		System.out.println("the heading of the page is: "+heading.getText());
		WebElement aboutUs = driver.findElement(AppiumBy.xpath("//android.view.View[@text=\"About Us\"]"));
		aboutUs.click();
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement headingAboutUs = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.view.View[@text='About Us']"))
		    );
		System.out.println("The heading on about us page is: "+headingAboutUs.getText());
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
