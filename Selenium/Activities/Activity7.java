import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity7 {
	public static void main(String args[]) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/webelements/dynamic-controls");
		System.out.println("The title of the main page is: "+driver.getTitle());
		
		WebElement textField = driver.findElement(By.id("textInput"));
		System.out.println("the textfield is enabled: "+textField.isEnabled());
		

		WebElement enableButton = driver.findElement(By.xpath("//button[text()='Enable Input']"));
		enableButton.click();
		
		System.out.println("the textfield is enabled: "+textField.isEnabled());
		driver.quit();
		
	}

}
