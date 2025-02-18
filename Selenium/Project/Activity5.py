from selenium import webdriver
from selenium.webdriver.common.by import By
with webdriver.Firefox() as driver:
    driver.get("http://alchemy.hguy.co/crm")

    userName = driver.find_element(By.ID,"user_name")
    userName.send_keys("admin")
    
    password = driver.find_element(By.ID,"username_password")
    password.send_keys("pa$$w0rd")
	
    login = driver.find_element(By.ID,"bigbutton")
    login.click()

    navigationMenu = driver.find_element(By.CSS_SELECTOR,".desktop-toolbar")
    print(f"The color of the navigation bar is: {navigationMenu.value_of_css_property('color')}")

    #driver.quit()