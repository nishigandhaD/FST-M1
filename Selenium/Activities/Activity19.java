import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity19 {
	public static void main(String args[]) {
		WebDriver driver;
		driver = new FirefoxDriver();
		driver.get("https://training-support.net/webelements/alerts");
		System.out.println("The title of the page is: "+driver.getTitle());
		
		WebElement confirmAlert = driver.findElement(By.xpath("//*[@id=\"confirmation\"]"));
		confirmAlert.click();
		Alert confirmalert = driver.switchTo().alert();
		System.out.println("The mesage on alert window is: "+confirmalert.getText());
		
		confirmalert.accept();
		//confirmalert.dismiss();
		
		WebElement result = driver.findElement(By.xpath("//*[@id=\"result\"]"));
		System.out.println("The result after accepting/dismissing the alert message: "+result.getText());
		
		driver.quit();
	}

}
