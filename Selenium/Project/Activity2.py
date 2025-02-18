from selenium import webdriver
from selenium.webdriver.common.by import By
with webdriver.Firefox() as driver:
    driver.get("http://alchemy.hguy.co/crm")

    headerUrl = driver.find_element(By.XPATH,"//img[@alt='SuiteCRM']")
    imageUrl = headerUrl.get_attribute("src")
    print(f"The url of the header image is: {imageUrl}")
    driver.quit()

