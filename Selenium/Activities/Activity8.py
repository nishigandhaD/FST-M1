from selenium import webdriver
from selenium.webdriver.common.by import By
with webdriver.Firefox() as driver:
    driver.get("https://training-support.net/webelements/mouse-events")
    print(f"the title of the main page is: {driver.title}")

    actions = webdriver.ActionChains(driver)
    cargoLock = driver.find_element(By.XPATH,"//h1[text()='Cargo.lock']")
    cargotoml = driver.find_element(By.XPATH,"//h1[text()='Cargo.toml']")
    src = driver.find_element(By.XPATH,"//h1[text()='src']")
    target = driver.find_element(By.XPATH,"//h1[text()='target']")

    actions.click(cargoLock).pause(5).move_to_element(cargotoml).pause(5).click(cargotoml).perform()

    result = driver.find_element(By.ID,"result")
    print(f"the message is: {result.text}")

    actions.double_click(src).pause(5).context_click(target).pause(5).perform()
    actions.click(driver.find_element(By.XPATH,"//div[@id='menu']/div/ul/li[1]")).pause(5).perform()

    result = driver.find_element(By.ID,"result")
    print(f"the message is: {result.text}")
    driver.quit()
		
