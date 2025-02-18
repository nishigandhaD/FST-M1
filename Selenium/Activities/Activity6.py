from selenium import webdriver
from selenium.webdriver.common.by import By
with webdriver.Firefox() as driver:
    driver.get("https://training-support.net/webelements/dynamic-controls")
    print(f"The title of the main page: {driver.title}")

    checkBox = driver.find_element(By.ID,"checkbox")
    checkBox.is_selected()
    print(f"the checkbox is selected: {checkBox.is_selected()}")

    checkBox.click()

    print(f"the checkbox is selected: {checkBox.is_selected()}")
    driver.quit()
