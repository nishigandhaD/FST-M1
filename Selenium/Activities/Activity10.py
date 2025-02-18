from selenium import webdriver
from selenium.webdriver.common.by import By
with webdriver.Firefox() as driver:
    driver.get("https://training-support.net/webelements/drag-drop")
    print(f"the title of the page is: {driver.title}")
    footBall = driver.find_element(By.ID,"ball")
    dropzone1 = driver.find_element(By.ID,"dropzone1")
    dropzone2 = driver.find_element(By.ID,"dropzone2")
    actions = webdriver.ActionChains(driver)
    actions.drag_and_drop(footBall,dropzone1).pause(5).perform()
    if(driver.find_element(By.CLASS_NAME,"dropzone-text").text=="Dropped!"):
        print("The ball was dropped in dropzone1")

    actions.drag_and_drop(footBall,dropzone2).pause(5).perform()
    if(driver.find_element(By.CLASS_NAME,"dropzone-text").text=="Dropped!"):
        print("The ball was dropped in dropzone2")
    
    driver.quit()

