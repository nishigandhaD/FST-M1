from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.select import Select
with webdriver.Firefox() as driver:
    wait=WebDriverWait(driver,timeout=10)
    driver.get("https://training-support.net/webelements/selects")
    print("the title of the page is: " ,driver.title)

    element = driver.find_element(By.CSS_SELECTOR,".h-80")
    multiSelect = Select(element)

    multiSelect.select_by_visible_text("HTML")
    for i in range(3,6):
       multiSelect.select_by_index(i)

    multiSelect.select_by_value("nodejs")

    selectedOptions = multiSelect.all_selected_options
    print("selected options are: ")
    for option in selectedOptions:
        print(option.text)

    multiSelect.deselect_by_index(4)

    
    selectedOptions = multiSelect.all_selected_options
    print("selected options are: ")
    for option in selectedOptions:
        print(option.text)

    driver.quit()