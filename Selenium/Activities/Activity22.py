from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.select import Select
with webdriver.Firefox() as driver:
    wait=WebDriverWait(driver,timeout=10)
    driver.get("https://training-support.net/webelements/popups")
    print("the title of the page is: " ,driver.title)
    popUp = driver.find_element(By.CSS_SELECTOR,"#launcher")
    popUp.click()

    wait.until(EC.visibility_of_element_located((By.CSS_SELECTOR, "#username")))
    userName = driver.find_element(By.CSS_SELECTOR,"#username")
    userName.send_keys("admin")
    password = driver.find_element(By.CSS_SELECTOR,"#password")
    password.send_keys("password")
    login = driver.find_element(By.CSS_SELECTOR,"button.svelte-1pdjkmx")
    login.click()
    message = driver.find_element(By.CSS_SELECTOR,".mt-5")
    print("The confirmation message is: ",message.text)
    driver.quit()
