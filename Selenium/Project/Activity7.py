from selenium import webdriver
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common.by import By
with webdriver.Firefox() as driver:
    driver.get("http://alchemy.hguy.co/crm")

    userName = driver.find_element(By.ID,"user_name")
    userName.send_keys("admin")
    
    password = driver.find_element(By.ID,"username_password")
    password.send_keys("pa$$w0rd")
	
    login = driver.find_element(By.ID,"bigbutton")
    login.click()

    salesButton = driver.find_element(By.XPATH,"//*[@id=\"grouptab_0\"]")
    actions = ActionChains(driver)
    actions.move_to_element(salesButton).perform()

    wait = WebDriverWait(driver, 10)
    leadOption = wait.until(EC.visibility_of_element_located((By.XPATH, "//*[@id=\"moduleTab_9_Leads\"]")))
    leadOption.click()

    wait = WebDriverWait(driver, 30)
    additionalInfo = wait.until(EC.visibility_of_element_located((By.CSS_SELECTOR, "[title='Additional Details']")))

    additionalInfo.click()

    phoneNumber = driver.find_element(By.CSS_SELECTOR,".phone")
    print(f"The phonenumber displayed on the pop up of leads is {phoneNumber.text} ")

    driver.quit()





