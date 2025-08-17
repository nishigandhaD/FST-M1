package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;

public class Activity4 {

	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();// TODO Auto-generated method stub
		
		//Open a new browser to https://training-support.net/webelements/target-practice
		driver.get("https://training-support.net/webelements/target-practice");
		
		
		//Get the title of the page and print it to the console.
		String Title=driver.getTitle();
		System.out.println(Title);
		
		//Using xpath:
			//Find the 3rd header on the page and print it's text to the console.
			System.out.println("3rd header text =" + driver.findElement(By.xpath("//h3[contains(text(),'#3')]")).getText());
			// Find the 5th header and print its color
	        Color fifthHeaderColor = Color.fromString(driver.findElement(By.xpath("//h5[contains(text(), '#5')]")).getCssValue("color"));
	        System.out.println("Color as RGB: " + fifthHeaderColor.asRgb());
	        System.out.println("Color as hexcode: " + fifthHeaderColor.asHex());

	        // Find the violet button and print its classes
	        String purpleButtonClass = driver.findElement(By.xpath("//button[text()='Purple']")).getDomAttribute("class");
	        System.out.println(purpleButtonClass);
	        // Find the grey button and print its text
	        String slateButtonText = driver.findElement(By.xpath("//button[contains(@class, 'slate')]")).getText();
	        System.out.println(slateButtonText);

	        // Close the browser
	        driver.quit();
	}

}