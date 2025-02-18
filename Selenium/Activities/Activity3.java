import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {
	public static void main(String args[]) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/webelements/login-form/");
		System.out.println("The title of main page is: "+driver.getTitle());
		
		WebElement username = driver.findElement(By.xpath("//*[@id='username']"));
		username.sendKeys("admin");
		
		WebElement password = driver.findElement(By.xpath("//*[@id='password']"));
		password.sendKeys("password");
		
		WebElement login = driver.findElement(By.xpath("//button[text()='Submit']"));
		login.click();
		
		WebElement message = driver.findElement(By.xpath("//h1[contains(text(),'Success')]"));
		String Message = message.getText();
	
		System.out.println(Message);
		
		driver.quit();
		
	}

}
