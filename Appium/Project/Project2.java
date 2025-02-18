package liveprojects;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Project2 {
    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException, URISyntaxException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.keep");
        options.setAppActivity(".activities.BrowseActivity");
        options.noReset();
        
        URL serverURL = new URI("http://localhost:4723").toURL();
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void keepNote() {
        // Create a new note
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("speed_dial_create_close_button"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("new_note_button"))).click();

        // Enter the note title
        WebElement titleField = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("editable_title")));
        titleField.sendKeys("The first note title");

        // Enter the note description
        WebElement descField = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("edit_note_text")));
        descField.sendKeys("first note description");

        // Save the note by navigating back
        driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]")).click();

        // Verify the title
        WebElement savedTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(
            AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.google.android.keep:id/index_note_title\" and @text=\"The first note title\"]")
        ));

        // Debugging - Print the retrieved title
        System.out.println("Saved Note Title: " + savedTitle.getText());

        // Assert the title is correct
        Assert.assertEquals(savedTitle.getText(), "The first note title", "Title verification failed!");

        
    }

    @AfterClass
    public void tearDown() {
        
            driver.quit();
        
    }
}
