from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.select import Select
with webdriver.Firefox() as driver:
    wait=WebDriverWait(driver,timeout=10)
    driver.get("https://training-support.net/webelements/selects")
    print("the title of the page is: " ,driver.title)

    dropdown = driver.find_element(By.CSS_SELECTOR,"select.h-10")
    singleSelect = Select(dropdown)
    singleSelect.select_by_visible_text("Two")
    print("Second option: " , singleSelect.first_selected_option.text)
    singleSelect.select_by_index(3)
    print("third option: ",singleSelect.first_selected_option.text)
    singleSelect.select_by_value("four")
    print("fourth option: ",singleSelect.first_selected_option.text)
    
    all_options = singleSelect.options
    print("options in the dropdown: ")
    for option in all_options:
        print(option.text)

    driver.quit()

