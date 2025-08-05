package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {

	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();// TODO Auto-generated method stub
		
		//Open the training support site.
		driver.get("https://training-support.net");
		
		//Print the title of the page
		System.out.println("Tittle of Page is:" + driver.getTitle());
		
		//Click the about us button using cssSelector
		//driver.findElement(By.cssSelector("a[href]")).click();
		
		//Click the about us button using linkText locator
		driver.findElement(By.linkText("About Us")).click();
		
		//Print the title of the new page
		System.out.println("Tittle of new Page is:" + driver.getTitle());
	
		driver.quit();
	}

}
