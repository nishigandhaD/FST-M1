from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
with webdriver.Firefox() as driver:
    wait=WebDriverWait(driver,timeout=10)
    driver.get("https://training-support.net/webelements/dynamic-attributes")
    print(f"the titlt of the page is: {driver.title}")

    fullName = driver.find_element(By.XPATH,"//input[starts-with(@id,'full-name')]")
    email = driver.find_element(By.XPATH,"//input[contains(@id,'-email')]")
    eventDate = driver.find_element(By.XPATH,"//input[contains(@name, '-event-date-')]")
    details = driver.find_element(By.XPATH,"//textarea[contains(@id,'-additional-details-')]")
    submit = driver.find_element(By.XPATH,"//button[starts-with(@class,'font-bold svelte-')]")
    fullName.send_keys("Renuka Devi")
    email.send_keys("renuka@mail.com")
    eventDate.send_keys("2025-02-26")
    details.send_keys("feb")
    submit.click()

    confirmationMessage = wait.until(EC.visibility_of_element_located((By.XPATH, "//*[@id='action-confirmation']")))
    message=confirmationMessage.text
    print("The confirmation message is: ",message)

    driver.quit()