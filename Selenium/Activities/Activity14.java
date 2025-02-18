import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity14 {
	public static void main(String args[]) {
		WebDriver driver;
		driver = new FirefoxDriver();
		driver.get("https://training-support.net/webelements/tables");
		System.out.println("The title of the page is: "+driver.getTitle());
		
		List<WebElement> cols = driver.findElements(By.xpath("//table[contains(@class,'table-auto')]/thead/tr/th"));
		System.out.println("The number of columns in the table: "+cols.size());
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@class,'table-auto')]/tbody/tr"));
		System.out.println("The number of rows in the table: "+rows.size());
		
		WebElement fifthrowbook = driver.findElement(By.xpath("//table[contains(@class,'table-auto')]/tbody/tr[5]/td[2]"));
		System.out.println("The Name of the book in 5th row: "+fifthrowbook.getText());
		
		WebElement pricecolumn = driver.findElement(By.xpath("//table[contains(@class,'table-auto')]/thead/tr/th[5]"));
		pricecolumn.click();
		
		WebElement fifthrowbookaftersort = driver.findElement(By.xpath("//table[contains(@class,'table-auto')]/tbody/tr[5]/td[2]"));
		System.out.println("The Name of the book in 5th row after sort: "+fifthrowbookaftersort.getText());
		
		driver.quit();
		
	}

}
