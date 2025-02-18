from selenium import webdriver
from selenium.webdriver.common.by import By
with webdriver.Firefox() as driver:
    driver.get("https://training-support.net/webelements/dynamic-controls")
    print(f"the title of the main page is: {driver.title}")

    textField = driver.find_element(By.ID,"textInput")
    textField.is_enabled()
    print(f"the textField is enabled: {textField.is_enabled()}")

    enableButton = driver.find_element(By.XPATH,"//button[text()='Enable Input']")
    enableButton.click()

    print(f"the textFiled is enabled: {textField.is_enabled()}")

    driver.quit()