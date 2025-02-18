import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity18 {
	public static void main(String args[]) {
		WebDriver driver;
		driver = new FirefoxDriver();
		driver.get("https://training-support.net/webelements/alerts");
		System.out.println("The title of the page is: "+driver.getTitle());
		WebElement simpleAlert = driver.findElement(By.xpath("//*[@id=\"simple\"]"));
		simpleAlert.click();
		
		Alert alert = driver.switchTo().alert();
		System.out.println("Alert message: "+alert.getText());
		alert.accept();
		WebElement result = driver.findElement(By.xpath("//*[@id=\"result\"]"));
		System.out.println("The result after clicking on alert: "+result.getText());
		driver.quit();
		
	}

}
