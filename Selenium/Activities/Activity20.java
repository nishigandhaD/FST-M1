import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity20 {
	public static void main(String args[]) {
		WebDriver driver;
		driver = new FirefoxDriver();
		driver.get("https://training-support.net/webelements/alerts");
		System.out.println("The title of the page is: "+driver.getTitle());
		
		WebElement promptAlert = driver.findElement(By.xpath("//*[@id=\"prompt\"]"));
		promptAlert.click();
		
		Alert promptalert = driver.switchTo().alert();
		System.out.println("The message on alert window is: "+promptalert.getText() );
		
		promptalert.sendKeys("Awesome!");
		//Thread.sleep(3000);
		promptalert.accept();
		
		WebElement result = driver.findElement(By.xpath("//*[@id=\"result\"]"));
		System.out.println("The result after accepting the alert message: "+result.getText());
		
		driver.quit();
		
	}

}
