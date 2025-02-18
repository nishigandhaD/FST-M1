import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Activity4 {
    public static void main(String[] args) {
       
        WebDriver driver = new FirefoxDriver();

       
        driver.get("https://training-support.net/webelements/target-practice");
        
        System.out.println("The title of the main page is: " + driver.getTitle());

        
        WebElement thirdHeader = driver.findElement(By.xpath("//h3[contains(text(), 'Heading #3')]"));
        System.out.println("The text of thirdHeader is: "+thirdHeader.getText());
        
        WebElement fifthHeader = driver.findElement(By.xpath("//h5[contains(text(), 'Heading #5')]"));
        System.out.println("The color of fifthHeader is: "+fifthHeader.getCssValue("Color"));
       
       
        WebElement purpleButton = driver.findElement(By.xpath("//button[text()='Purple']"));
        System.out.println("Classes of purple Button: "+purpleButton.getAttribute("class"));
       
        WebElement slateButton = driver.findElement(By.xpath("//button[text() ='Slate']"));
        System.out.println("The text of the slate button is: "+slateButton.getText());

        
        driver.quit();
    }
}