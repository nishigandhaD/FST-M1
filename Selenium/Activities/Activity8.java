import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Activity8 {
	public static void main(String args[]) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/webelements/mouse-events");
		System.out.println("The title of the main page is: "+driver.getTitle());
		
		Actions builder = new Actions(driver);
		

		WebElement cargoLock = driver.findElement(By.xpath("//h1[text()='Cargo.lock']"));
		WebElement cargotoml = driver.findElement(By.xpath("//h1[text()='Cargo.toml']"));
		WebElement src = driver.findElement(By.xpath("//h1[text()='src']"));
		WebElement target = driver.findElement(By.xpath("//h1[text()='target']"));
		
		Action actionsToPerform1 =builder.click(cargoLock).pause(1000).moveToElement(cargotoml).pause(1000).click(cargotoml).build();
		
		actionsToPerform1.perform();
		
		WebElement result = driver.findElement(By.id("result"));
		System.out.println("the message is: "+result.getText());
		
		Action actionsToPerform2 = builder.doubleClick(src).pause(1000).contextClick(target).pause(1000).build();
		
		actionsToPerform2.perform();
		
		builder.click(driver.findElement(By.xpath("//div[@id='menu']/div/ul/li[1]"))).pause(1000).build().perform();
		System.out.println("the message is: "+result.getText());
		
		driver.quit();
	}
		
}
