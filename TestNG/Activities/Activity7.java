package testng;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Activity7 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @BeforeMethod
    public void navigateToLoginPage() {
        driver.get("https://training-support.net/webelements/login-form");
    }

    @DataProvider(name = "Credentials")
    public static Object[][] credentials() {
        return new Object[][]{
            {"admin", "password", "Welcome Back, Admin!"},
            {"admin_user", "Password", "A Simple Login Form!"}
        };
    }

    @Test(dataProvider = "Credentials")
    public void login(String username, String password, String expectedMessage) {
        // Locate elements
        WebElement userName = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.xpath("//button[text()='Submit']"));

        // Clear and enter credentials
        userName.clear();
        passwordField.clear();
        userName.sendKeys(username);
        passwordField.sendKeys(password);

        // Click login button
        loginButton.click();

        // Wait for success or form reload
        WebElement messageElement = wait.until(ExpectedConditions.presenceOfElementLocated(
        	    By.cssSelector("h2.text-center, form.ui.form h2")
        	));


        // Get the displayed message
        String actualMessage = messageElement.getText();

        // Assert the message
        assertEquals(actualMessage.trim(), expectedMessage, "The login message does not match the expected value.");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
