package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v137.page.model.WindowOpen;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {

	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();// TODO Auto-generated method stub
		
		//Open the training support site.
		//driver.get("https://training-support.net");
		
		//Print the title of the page
		//System.out.println("Tittle of Page is:" + driver.getTitle());
		
		//Click the about us button using Xpath
		//driver.findElement(By.xpath("//a[@href='/about']")).click();
		
		//Print the title of the new page
		//System.out.println("Tittle of new Page is:" + driver.getTitle());
			
		
		
		//open another site
		driver.get("https://training-support.net/webelements/login-form/");
		
		//Get the title of the page and print it to the console.
		System.out.println("Tittle of the page is:" + driver.getTitle());
				
				//Find the username field using any locator and enter "admin" into it.
				driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
				
				//Find the password field using any locator and enter "password" into it.
				driver.findElement(By.xpath("//input[@type='password']")).sendKeys("password");
			
				//Find the "Log in" button using any locator and click it.
				driver.findElement(By.xpath("//button[@class='svelte-1pdjkmx']")).click();
		
		//close browser
		driver.quit();
		
	}

}
