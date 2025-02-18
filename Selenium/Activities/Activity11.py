from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.wait import WebDriverWait
with webdriver.Firefox() as driver:
    wait = WebDriverWait(driver,timeout=10)
    driver.get("https://training-support.net/webelements/dynamic-controls")
    print(f"The title of the page is: {driver.title}")

    checkBox = driver.find_element(By.ID,"checkbox")
    print("Checkbox is displayed? ", checkBox.is_displayed())
    toggleButton = driver.find_element(By.XPATH,"//button[text()='Toggle Checkbox']")
    toggleButton.click()
    wait.until(EC.invisibility_of_element(checkBox))
    print("Checkbox is displayed? ", checkBox.is_displayed())
    
    toggleButton1 = driver.find_element(By.XPATH,"//button[text()='Toggle Checkbox']")
    toggleButton1.click()
    wait.until(EC.element_to_be_clickable(checkBox)).click()
    print("Checkbox is selected? ", checkBox.is_selected())

    driver.quit()
