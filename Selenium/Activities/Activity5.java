import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5 {
	public static void main(String args[]) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/webelements/dynamic-controls");
		System.out.println("The title of the main page is: "+driver.getTitle());
		
		WebElement checkbox = driver.findElement(By.id("checkbox"));
		checkbox.isDisplayed();
		
		WebElement toggleButton = driver.findElement(By.xpath("//button[text()='Toggle Checkbox']"));
		toggleButton.click();
		
		
		checkbox.isDisplayed();
	
		
		System.out.println("The checkbox is visible: "+checkbox.isDisplayed());
		
		driver.quit();
		
		
		
		
		
	
	}

}
