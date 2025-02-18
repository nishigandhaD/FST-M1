from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.select import Select
with webdriver.Firefox() as driver:
    wait=WebDriverWait(driver,timeout=10)
    driver.get("https://training-support.net/webelements/tabs")
    print("the title of the page is: " ,driver.title)
    tabButton = driver.find_element(By.CSS_SELECTOR,".bg-purple-200")
    tabButton.click()

    wait.until(EC.number_of_windows_to_be(2))
    print("currently opened windows: ",driver.window_handles)
    for handle in driver.window_handles:
        driver.switch_to.window(handle)

    wait.until(EC.element_to_be_clickable((By.CSS_SELECTOR, ".bg-purple-200")))

    print("Current tab: ", driver.current_window_handle)
    print("New Page title: ", driver.title)
    message = driver.find_element(By.CSS_SELECTOR,".mt-5")
    print("The message on the current page: ",message.text)
    driver.find_element(By.CSS_SELECTOR,".bg-purple-200").click()
    wait.until(EC.number_of_windows_to_be(3))
    print("Currently opened windows:", driver.window_handles)

    for handle in driver.window_handles:
        driver.switch_to.window(handle)

    wait.until(EC.visibility_of_element_located((By.CSS_SELECTOR, ".bg-purple-200")))

    print("Handle of the current page: "+driver.current_window_handle)
    print("The title of the current page: ",driver.title)
    message1 = driver.find_element(By.CSS_SELECTOR,".mt-5")
    print("The message on the current page: ",message1.text)
    driver.quit()
		
		
		