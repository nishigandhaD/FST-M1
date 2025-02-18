from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
with webdriver.Firefox() as driver:
    wait=WebDriverWait(driver,timeout=10)
    driver.get("https://training-support.net/webelements/tables")
    print(f"the title of the page is: {driver.title}")

    cols= driver.find_elements(By.XPATH,"//table[contains(@class,'table-auto')]/thead/tr/th")
    print("The number of columns: ",len(cols))
    rows = driver.find_elements(By.XPATH,"//table[contains(@class,'table-auto')]/tbody/tr")
    print("The number of rows: ",len(rows))

    thirdrow = driver.find_elements(By.XPATH,"//table[contains(@class,'table-auto')]/tbody/tr[3]/td")
    for cell in thirdrow:
        print(cell.text)

    secondrowcell = driver.find_element(By.XPATH,"//table[contains(@class,'table-auto')]/tbody/tr[2]/td[2]")
    print("Second row second column", secondrowcell.text)

    driver.quit()
    