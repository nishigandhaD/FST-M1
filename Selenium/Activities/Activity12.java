import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity12 {
	public static void main(String args[]) {
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		driver.get("https://training-support.net/webelements/dynamic-content");
		System.out.println("The title of the page is: "+driver.getTitle());
		
		WebElement button =driver.findElement(By.id("genButton"));
		button.click();
		
		if(wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("word"),"release"))) {
			WebElement word = driver.findElement(By.id("word"));
			System.out.println("Word is: "+word.getText());
		}
		
		driver.quit();
	}

}
