from selenium import webdriver
from selenium.webdriver.common.by import By
with webdriver.Firefox() as driver:
    driver.get("http://alchemy.hguy.co/crm")
    firstCopyRight = driver.find_element(By.ID,"admin_options")
    
    print(f"the copy right text is {firstCopyRight.text}")

    driver.quit()