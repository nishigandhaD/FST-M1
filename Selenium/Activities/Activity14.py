from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.wait import WebDriverWait
with webdriver.Firefox() as driver:
    wait=WebDriverWait(driver,timeout=10)
    driver.get("https://training-support.net/webelements/tables")
    print(f"The title of the page is: {driver.title}")
    cols= driver.find_elements(By.XPATH,"//table[contains(@class,'table-auto')]/thead/tr/th")
    print("The number of columns: ",len(cols))
    rows = driver.find_elements(By.XPATH,"//table[contains(@class,'table-auto')]/tbody/tr")
    print("The number of rows: ",len(rows))

    fifthrowbook = driver.find_element(By.XPATH,"//table[contains(@class,'table-auto')]/tbody/tr[5]/td[2]")
    print("The name of the book in 5th row is: ",fifthrowbook.text)

    pricecolumn = driver.find_element(By.XPATH,"//table[contains(@class,'table-auto')]/thead/tr/th[5]")
    pricecolumn.click()

    fifthrowbookaftersort = driver.find_element(By.XPATH,"//table[contains(@class,'table-auto')]/tbody/tr[5]/td[2]")
    print("The Name of the book in 5th row after sort: ",fifthrowbookaftersort.text)

    driver.quit()