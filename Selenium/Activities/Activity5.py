from selenium import webdriver
from selenium.webdriver.common.by import By
with webdriver.Firefox() as driver:
    driver.get("https://training-support.net/webelements/dynamic-controls")
    print(f"the title of main page is: {driver.title}")

    checkBox = driver.find_element(By.ID,"checkbox")
    checkBox.is_displayed()

    toggleButton = driver.find_element(By.XPATH,"//button[text()='Toggle Checkbox']")
    toggleButton.click()

    checkBox.is_displayed()
    print(f"The checkbox is visble: {checkBox.is_displayed()}")

    driver.quit()