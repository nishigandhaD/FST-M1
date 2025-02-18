import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity21 {
	public static void main(String args[]) {
		WebDriver driver;
		driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get("https://training-support.net/webelements/tabs");
		System.out.println("The title of the main page is: "+driver.getTitle());
		WebElement tabButton = driver.findElement(By.cssSelector(".bg-purple-200"));
		tabButton.click();
		
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		System.out.println("currently opened windows: "+driver.getWindowHandles());
		
		for(String handle: driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
		
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".bg-purple-200")));
		System.out.println("Handle of current tab: "+driver.getWindowHandle());
		System.out.println("The title of the current page: "+driver.getTitle());
		WebElement message = driver.findElement(By.cssSelector(".mt-5"));
		System.out.println("The message on the current page: "+message.getText());
		driver.findElement(By.cssSelector(".bg-purple-200")).click();
		
		wait.until(ExpectedConditions.numberOfWindowsToBe(3));
		System.out.println("currently opened windows: "+driver.getWindowHandles());
		
		for(String handle:driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".bg-purple-200")));
		System.out.println("Handle of the current page: "+driver.getWindowHandle());
		System.out.println("The title of the current page: "+driver.getTitle());
		WebElement message1 = driver.findElement(By.cssSelector(".mt-5"));
		System.out.println("The message on the current page: "+message1.getText());
		
		driver.quit();
		
	}

}
