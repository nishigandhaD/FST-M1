from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:
    driver.get("https://training-support.net/webelements/target-practice")
    print(f"The title of main page is {driver.title}")

    thirdHeader =  driver.find_element(By.XPATH,"//h3[contains(text(), 'Heading #3')]")
    print(f"The text of thirdHeader is {thirdHeader.text}")

    fifthHeader = driver.find_element(By.XPATH,"//h5[contains(text(), 'Heading #5')]")
    print(f"color of fifthHeader is {fifthHeader.value_of_css_property("Color")}")

    purpleButton = driver.find_element(By.XPATH,"//button[text()='Purple']")
    print(f"classes of purpleButton: {purpleButton.get_attribute("class")}")

    slateButton = driver.find_element(By.XPATH,"//button[text() ='Slate']")
    print(f"text in slate button is {slateButton.text}")

    driver.quit()