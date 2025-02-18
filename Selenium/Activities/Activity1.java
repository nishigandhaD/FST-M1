import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {
	public static void main(String args[]) {
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://training-support.net/");
		
		System.out.println("The title of the main page is: "+driver.getTitle());
		
		WebElement button = driver.findElement(By.linkText("About Us"));
		
		button.click();
		
		System.out.println("The title of the new page is: "+driver.getTitle());
		
		driver.quit();
	}

}
