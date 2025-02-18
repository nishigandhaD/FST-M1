import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Activity13 {
	public static void main(String args[]) {
		WebDriver driver;
		
		driver = new FirefoxDriver();
		driver.get("https://training-support.net/webelements/tables");
		System.out.println("The title of the page: "+driver.getTitle());
		
		List<WebElement> cols = driver.findElements(By.xpath("//table[contains(@class, 'table-auto')]/thead/tr/th"));
		System.out.println("Number of cols: "+cols.size());
		List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@class,'table-auto')]/tbody/tr"));
		System.out.println("Number of rows: "+rows.size());
		
		List<WebElement> thirdrow = driver.findElements(By.xpath("//table[contains(@class,'table-auto')]/tbody/tr[3]/td"));
		System.out.println("Thrid row values: ");
		for(WebElement cell: thirdrow) {
			System.out.println(cell.getText());
		}
		
		WebElement secondrowcell = driver.findElement(By.xpath("//table[contains(@class,'table-auto')]/tbody/tr[2]/td[2]"));
		System.out.println("Second row second coulumn: "+ secondrowcell.getText());
		
		driver.quit();
	}

}
