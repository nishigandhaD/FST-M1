import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity16 {
	public static void main(String args[]) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/webelements/selects");
		System.out.println("the title of the page is: "+driver.getTitle());
		WebElement dropdown = driver.findElement(By.cssSelector("select.h-10"));
		Select singleSelect = new Select(dropdown);
		
		singleSelect.selectByVisibleText("Two");
		System.out.println("Second option: " + singleSelect.getFirstSelectedOption().getText());
		singleSelect.selectByIndex(3);
		System.out.println("third option: " + singleSelect.getFirstSelectedOption().getText());
		singleSelect.selectByValue("four");
		System.out.println("fourth option: "+singleSelect.getFirstSelectedOption().getText());
		
		List<WebElement> all_options = singleSelect.getOptions();
		System.out.println("options in the dropdown: ");
		for(WebElement option:all_options) {
			System.out.println(option.getText());
		}
		
		driver.quit();
		
	}

}
