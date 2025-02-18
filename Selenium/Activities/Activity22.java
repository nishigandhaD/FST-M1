import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity22 {
	public static void main(String args[]) {
		WebDriver driver;
		driver = new FirefoxDriver();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));

		driver.get("https://training-support.net/webelements/popups");
		System.out.println("the title of the page is: "+driver.getTitle());
		WebElement popUp = driver.findElement(By.cssSelector("#launcher"));
		popUp.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#username")));
		WebElement userName = driver.findElement(By.cssSelector("#username"));
		userName.sendKeys("admin");
		WebElement password = driver.findElement(By.cssSelector("#password"));
		password.sendKeys("password");
		
		WebElement login = driver.findElement(By.cssSelector("button.svelte-1pdjkmx"));
		login.click();
		
		WebElement message = driver.findElement(By.cssSelector(".mt-5"));
		System.out.println("The confirmation message is: "+message.getText());
		
		driver.quit();
	}

}
