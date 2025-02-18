from selenium import webdriver
with webdriver.Firefox() as driver:
    driver.get("http://alchemy.hguy.co/crm")
    title = driver.title
    print(f"The title of the main page is: {title}")

    if title=="SuiteCRM":
        print("Title matches.Closing the browser")
        driver.quit()
    else:
        print("Title doesn't match")