import time

from selenium import webdriver
from selenium.common.exceptions import NoSuchElementException
from selenium.webdriver import Keys
from selenium.webdriver.common.by import By
from selenium.webdriver.support.select import Select


def initialize_web_browser():
    chromedriver = "C:\\Users\\xt8393\\Desktop\\Executable Generador\\chrome\\chromedriver.exe"
    options = webdriver.ChromeOptions()
    options.binary_location = 'C:\\Users\\xt8393\\Desktop\\Executable Generador\\chrome\\chrome.exe'
    options.add_argument("--headless")
    browser = webdriver.Chrome(options=options, executable_path=chromedriver)
    return browser


def go_to_url(browser, url):
    browser.get(url)


def find_element(browser, xpath):
    values = []
    try:
        values = [
            True,
            browser.find_element(By.XPATH, xpath)
        ]
    except NoSuchElementException as err:
        values = [
            False
        ]
        print(err)
    return values


def make_action(browser, xpath, action, value=None, force_presence=True, wait=None):
    if wait is not None:
        time.sleep(wait)
    object_element = find_element(browser, xpath)
    if force_presence:
        if not object_element[0]:
            raise
    element = object_element[1]
    if object_element[0]:
        if action == "click":
            element.click()
        if action == "write":
            element.clear()
            element.send_keys(value)
        if action == "write_enter":
            element.send_keys(value, Keys.ENTER)
        if action == "check":
            return True
        if action == "select":
            select = Select(element)
            if value[0] == "index":
                select.select_by_index(value[1])
            if value[0] == "text":
                select.select_by_visible_text(value[1])
            if value[0] == "value":
                select.select_by_value(value[1])
        if action == "get_text":
            return element.text