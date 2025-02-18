import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity15 {
	public static void main(String args[]) {
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://training-support.net/webelements/dynamic-attributes");
		System.out.println("The title of the page is: "+driver.getTitle());
		
		WebElement fullName = driver.findElement(By.xpath("//input[starts-with(@id,'full-name')]"));
		WebElement email = driver.findElement(By.xpath("//input[contains(@id,'-email')]"));
		WebElement eventDate = driver.findElement(By.xpath("//input[contains(@name, '-event-date-')]"));
		WebElement details = driver.findElement(By.xpath("//textarea[contains(@id,'-additional-details-')]"));
		WebElement submit = driver.findElement(By.xpath("//button[starts-with(@class,'font-bold svelte-')]"));
		fullName.sendKeys("Renuka Devi");
		email.sendKeys("renuka@mail.com");
		eventDate.sendKeys("2025-02-26");
		details.sendKeys("feb");
		submit.click();
		
		WebElement confirmationmessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"action-confirmation\"]")));
		String message = confirmationmessage.getText();
		System.out.println("The confirmation message is: "+message);
		
		driver.quit();
	}
}
