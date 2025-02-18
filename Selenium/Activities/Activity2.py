from selenium import webdriver
from selenium.webdriver.common.by import By
with webdriver.Firefox() as driver:
    driver.get("https://training-support.net/webelements/login-form/")
    print(f"The title of the main page is: {driver.title} ")
    username = driver.find_element(By.NAME,"username")
    username.send_keys("admin")
    password = driver.find_element(By.NAME,"password")
    password.send_keys("password")
    login = driver.find_element(By.XPATH,"//button[text()='Submit']")
    login.click()
    print(f"The title of the new page is: {driver.title}")
    driver.quit()

