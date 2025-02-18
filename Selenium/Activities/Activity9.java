import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity9 {
	public static void main(String args[]) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/webelements/keyboard-events");
		System.out.println("The title of the main page: "+driver.getTitle());
		
		Actions builder = new Actions(driver);
		builder.sendKeys("This is a selenium script").build().perform();
		
		
		WebElement message = driver.findElement(By.cssSelector("h1.mt-3"));
		
		System.out.println("The text is: "+message.getText());
		
		driver.quit();
		
	}

}
