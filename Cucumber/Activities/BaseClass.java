package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
    // Create a new instance of the Firefox driver
	public static WebDriver driver;
    public static WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
    
    
    
    
    
   
}