from selenium import webdriver
from selenium.webdriver.common.by import By
with webdriver.Firefox() as driver:
    driver.get("https://alchemy.hguy.co/crm")
    userName = driver.find_element(By.ID,"user_name")
    userName.send_keys("admin")
    
    password = driver.find_element(By.ID,"username_password")
    password.send_keys("pa$$w0rd")
	
    login = driver.find_element(By.ID,"bigbutton")
    login.click()
    
    dashBoard = driver.find_element(By.ID,"tab0")
    
    print(f"Dashboard text is {dashBoard.text} ")
    assert dashBoard.is_displayed(),"Homepage is not displayed , login not successfull"
    print("Login is successsfull and homepage is opened")
    driver.quit()
    