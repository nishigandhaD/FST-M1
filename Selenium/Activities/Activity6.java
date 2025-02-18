import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity6 {
	public static void main(String args[]) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/webelements/dynamic-controls");
		System.out.println("The title of the page is: "+driver.getTitle());
		
		WebElement checkbox = driver.findElement(By.id("checkbox"));
		checkbox.isSelected();
		System.out.println("The checkbox is selected: "+checkbox.isSelected());
		
		checkbox.click();
		
		System.out.println("the checkbox is selected: "+checkbox.isSelected());
		
		driver.quit();
	}

}
