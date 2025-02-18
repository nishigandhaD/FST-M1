from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:
    driver.get("https://training-support.net/")
    print(f"The title of the main page is: {driver.title}")


    button = driver.find_element(By.LINK_TEXT,"About Us")
    button.click()
    print(f"The title of the new page is: {driver.title}")

    driver.quit()



