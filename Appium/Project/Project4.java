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
import java.util.List;

public class Project4 {

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
        
        driver.get("https://v1.training-support.net/selenium");
    }

    @Test
    public void testToDoList() throws InterruptedException 
    {
    	wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.Button[@text=\"Get Started!\"]")));
    	 driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Get Started!\"]")).click();
    	 //UiScrollable String
    	 String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
    	 //Scroll to end
    	 driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".scrollToEnd(2)"));
    	 
    	 wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.view.View[contains(@text, 'To-Do List')]"))).click();

    	 
    	 wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"taskInput\"]")));

    	 WebElement InputField = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"taskInput\"]"));
    	 InputField.sendKeys("Add tasks to list");
    	 driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Add Task\"]")).click();
    	 Thread.sleep(1000);
    	 InputField.sendKeys("Get number of tasks");
    	 driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Add Task\"]")).click();
    	 Thread.sleep(1000);
    	 InputField.sendKeys("Clear the list");
    	 driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Add Task\"]")).click();
    	 Thread.sleep(1000);
    	 
    	 driver.findElement(AppiumBy.xpath("//android.view.View[@text=\"Add tasks to list\"]")).click();
    	 Thread.sleep(1000);
    	 driver.findElement(AppiumBy.xpath("//android.view.View[@text=\"Get number of tasks\"]")).click();
    	 Thread.sleep(1000);
    	 driver.findElement(AppiumBy.xpath("//android.view.View[@text=\"Clear the list\"]")).click();
    	 
    	 Thread.sleep(1000);
    	 driver.findElement(AppiumBy.xpath("//android.view.View[@text=\" Clear List\"]")).click();
    	 Thread.sleep(1000);
    	 List<WebElement> list = driver.findElements(AppiumBy.xpath("//android.view.View[@resource-id=\"tasksList\"]/android.view.View"));
         System.out.println("number of tasks: " + list.size());
         
         Assert.assertEquals(list.size(), 0 , "List is not empty");
    	 }
    

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
} 