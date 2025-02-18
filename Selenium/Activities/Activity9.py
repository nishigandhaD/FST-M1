from selenium import webdriver
from selenium.webdriver.common.by import By
with webdriver.Firefox() as driver:
    driver.get("https://training-support.net/webelements/keyboard-events")
    print(f"the title of the main page is: {driver.title}")

    actions= webdriver.ActionChains(driver)
    actions.send_keys("This is a selenium script").perform()

    message = driver.find_element(By.CSS_SELECTOR,"h1.mt-3")
    print(f"the message on the page is: {message.text}")

    driver.quit()