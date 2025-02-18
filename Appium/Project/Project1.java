package liveprojects;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Project1 {
    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException, URISyntaxException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.apps.tasks");
        options.setAppActivity(".ui.TaskListsActivity");
        options.noReset();

        URL serverURL = new URI("http://localhost:4723").toURL();
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Reusable method to add a task
    public void addTask(String taskName) {
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Create new task"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("add_task_title")));
        WebElement taskInput = driver.findElement(AppiumBy.id("add_task_title"));
        taskInput.click();
        taskInput.sendKeys(taskName);
        driver.findElement(AppiumBy.id("add_task_done")).click();
    }

    @Test
    public void tasks() {
        // Adding tasks
        addTask("Complete Activity with Google Tasks");
        addTask("Complete Activity with Google Keep");
        addTask("Complete the second Activity Google Keep");

        // Assertions to verify tasks are added
        Assert.assertEquals(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Complete Activity with Google Tasks']")).getText(),
                "Complete Activity with Google Tasks");

        Assert.assertEquals(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Complete Activity with Google Keep']")).getText(),
                "Complete Activity with Google Keep");

        Assert.assertEquals(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Complete the second Activity Google Keep']")).getText(),
                "Complete the second Activity Google Keep");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
