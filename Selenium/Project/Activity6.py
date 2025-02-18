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

    activitiesMenu = driver.find_element(By.XPATH,"//*[@id=\"grouptab_3\"]")
    
    print(f"The text of activites menu is: {activitiesMenu.text}")
    assert activitiesMenu.is_displayed()

    driver.quit()

