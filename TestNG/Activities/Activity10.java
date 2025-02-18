package testng;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Activity10 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://training-support.net/webelements/simple-form");
    }

    public static List<List<String>> readExcel(String filePath) {
        List<List<String>> data = new ArrayList<>();
        try (FileInputStream file = new FileInputStream(filePath);
             XSSFWorkbook workbook = new XSSFWorkbook(file)) {

            XSSFSheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                List<String> rowData = new ArrayList<>();
                for (Cell cell : row) {
                    switch (cell.getCellType()) {
                        case STRING:
                            rowData.add(cell.getStringCellValue().trim());
                            break;
                        case NUMERIC:
                            if (DateUtil.isCellDateFormatted(cell)) {
                                rowData.add(cell.getDateCellValue().toString());
                            } else {
                                rowData.add(String.valueOf(cell.getNumericCellValue()).trim());
                            }
                            break;
                        default:
                            rowData.add(cell.toString().trim());
                    }
                }
                data.add(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Data read from Excel: " + data);
        return data;
    }

    @DataProvider(name = "Events")
    public static Object[][] signUpInfo() {
        String filePath = "C:/Javatest/Simple form.xlsx";
        List<List<String>> data = readExcel(filePath);

        if (data.size() < 4) {
            throw new RuntimeException("Not enough data in Excel file.");
        }

        return new Object[][]{
                {data.get(1)},
                {data.get(2)},
                {data.get(3)}
        };
    }

    @Test(dataProvider = "Events")
    public void registerTest(List<String> rows) throws InterruptedException {
        WebElement fullName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("full-name")));
        fullName.sendKeys(rows.get(0));

        WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        email.sendKeys(rows.get(1));

        String formattedDate = formatDate(rows.get(2));
        System.out.println("Formatted Date for Input Field: " + formattedDate);

        WebElement dateField = wait.until(ExpectedConditions.elementToBeClickable(By.name("event-date")));
        dateField.clear();
        dateField.sendKeys(formattedDate);

        String enteredDate = dateField.getAttribute("value");
        System.out.println("Entered date in the field: " + enteredDate);

        assertEquals(enteredDate, formattedDate, "Date not set correctly!");

        WebElement detailsField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("additional-details")));
        detailsField.sendKeys(rows.get(3));

        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Submit']")));
        System.out.println("All fields filled. Now clicking submit.");
        submitButton.click();

        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("action-confirmation")));
        String message = confirmationMessage.getText();
        System.out.println("Confirmation Message: " + message);
        assertEquals(message, "Your event has been scheduled!", "Confirmation message did not match!");

        driver.navigate().refresh();
    }

    private String formatDate(String eventDate) {
        String[] dateParts = eventDate.replaceAll("\"", "").trim().split(" ");
        
        // Skip the weekday name (e.g., "Wed")
        String day = dateParts[2]; // Get the day
        String month = getMonthNumber(dateParts[1]); // Get the month from the second part
        String year = dateParts[5]; // Get the year from the last part
        
        // Format the date as yyyy-MM-dd (expected by input type="date")
        return year + "-" + month + "-" + day;
    }

    private String getMonthNumber(String monthName) {
        switch (monthName.toLowerCase()) {
            case "jan":
                return "01";
            case "feb":
                return "02";
            case "mar":
                return "03";
            case "apr":
                return "04";
            case "may":
                return "05";
            case "jun":
                return "06";
            case "jul":
                return "07";
            case "aug":
                return "08";
            case "sep":
                return "09";
            case "oct":
                return "10";
            case "nov":
                return "11";
            case "dec":
                return "12";
            default:
                throw new IllegalArgumentException("Invalid month: " + monthName);
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
