from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.select import Select
with webdriver.Firefox() as driver:
    wait=WebDriverWait(driver,timeout=10)
    driver.get("https://training-support.net/webelements/alerts")
    print("the title of the page is: " ,driver.title)
    promptAlert = driver.find_element(By.XPATH,"//*[@id=\"prompt\"]")
    promptAlert.click()
    promptalert=wait.until(EC.alert_is_present())
    print("The mesage on alert window is: ",promptalert.text)
    promptalert.send_keys("Awesome!")
    promptalert.accept()
    

    result = driver.find_element(By.XPATH,"//*[@id=\"result\"]")
    print("The result after clicking on alert: ",result.text)
    driver.quit()