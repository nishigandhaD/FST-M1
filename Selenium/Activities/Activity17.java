import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity17 {
	public static void main(String args[]) {
		WebDriver driver;
		driver = new FirefoxDriver();
		driver.get("https://training-support.net/webelements/selects");
		System.out.println("The title of the page is: "+driver.getTitle());
		
		WebElement element = driver.findElement(By.cssSelector(".h-80"));
		Select multiSelect = new Select(element);
		
		multiSelect.selectByVisibleText("HTML");
		
		for (int i = 3; i <= 5; i++) {
            multiSelect.selectByIndex(i);
        }
		
		multiSelect.selectByValue("nodejs");
		
		List<WebElement> selectedoptions = multiSelect.getAllSelectedOptions();
		System.out.println("selected options are: ");
		for(WebElement options:selectedoptions) {
			System.out.println(options.getText());
		}
		
		
		multiSelect.deselectByIndex(4);
	
		selectedoptions = multiSelect.getAllSelectedOptions();
				System.out.println("selected options are: ");
				for(WebElement options:selectedoptions) {
					System.out.println(options.getText());
				}
				
		driver.quit();
		
	}

}
