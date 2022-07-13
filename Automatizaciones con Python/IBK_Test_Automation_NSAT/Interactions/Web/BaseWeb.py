import os
import time

from selenium import webdriver
from selenium.common.exceptions import NoSuchElementException
from selenium.webdriver import Keys, ActionChains
from selenium.webdriver.common.by import By
from selenium.webdriver.support.select import Select


def initialize_web_browser():
    options = webdriver.IeOptions()
    options.add_argument("--auto-open-devtools-for-tabs")
    executable_path = os.path.dirname(os.path.abspath(__file__))+"\\Drivers\\IE\\IEDriverServer.exe"
    print(executable_path)
    browser = webdriver.Ie(options=options, executable_path=executable_path)
    return browser


def go_to_url(browser, url):
    browser.get(url)


def move_cursor_to_element(browser, element):
    action = ActionChains(browser)
    action.move_to_element(element)


def find_element(browser, selector, type_search="XPATH"):
    by_type = By.XPATH
    if type_search == "NAME":
        by_type = By.NAME
    try:
        values = [
            True,
            browser.find_element(by_type, selector)
        ]
    except NoSuchElementException as err:
        values = [
            False
        ]
        print(err)
    return values


def make_action(browser, selector, action, type_search="XPATH", value=None, force_presence=True, wait=None):
    if wait is not None:
        time.sleep(wait)
    object_element = find_element(browser, selector, type_search)
    if force_presence:
        if not object_element[0]:
            raise
    element = object_element[1]
    if object_element[0]:
        if action == "click":
            element.click()
        if action == "write":
            #element.clear()
            element.send_keys(value)
        if action == "write_enter":
            element.send_keys(value, Keys.ENTER)
        if action == "move_cursor_to_element":
            move_cursor_to_element(browser, element)
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