import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity10 {
	public static void main(String args[]) {
		WebDriver driver = new FirefoxDriver();
		Actions builder = new Actions(driver);
		driver.get("https://training-support.net/webelements/drag-drop");
		System.out.println("The title of the page is: "+driver.getTitle());
		
		WebElement footBall = driver.findElement(By.id("ball"));
		WebElement dropzone1 = driver.findElement(By.id("dropzone1"));
		WebElement dropzone2 = driver.findElement(By.id("dropzone2"));
		
		//builder.clickAndHold(footBall).moveToElement(dropzone1).pause(3000).release().build().perform();
		builder.dragAndDrop(footBall,dropzone1).pause(3000).build().perform();
		if(driver.findElement(By.className("dropzone-text")).getText().equals("Dropped!")) {
			System.out.println("The ball was dropped in dropzone1");
		}
		
		builder.dragAndDrop(footBall,dropzone2).pause(3000).build().perform();
		if(driver.findElement(By.className("dropzone-text")).getText().equals("Dropped!")) {
			System.out.println("The ball was dropped in dropzone2");
		}
		
		driver.quit();
			
		}
	}


