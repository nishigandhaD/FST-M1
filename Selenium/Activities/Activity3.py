from selenium import webdriver
from selenium.webdriver.common.by import By
with webdriver.Firefox() as driver:
    driver.get("https://training-support.net/webelements/login-form/")
    print(f"The title of the main page is: {driver.title}")
    username = driver.find_element(By.XPATH,"//*[@id='username']")
    username.send_keys("admin")
    password = driver.find_element(By.XPATH,"//*[@id='password']")
    password.send_keys("password")
    login = driver.find_element(By.XPATH,"//button[text()='Submit']")
    login.click()

    message = driver.find_element(By.XPATH,"//h1[contains(text(),'Success')]")
    Message = message.text
    print(f"The title of the new page is: {Message}")

    driver.quit()