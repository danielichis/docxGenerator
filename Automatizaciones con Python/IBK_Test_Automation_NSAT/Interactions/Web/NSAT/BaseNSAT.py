from selenium.webdriver import Keys

from Interactions.Web.BaseWeb import *
from Interactions.Web.NSAT.Elements.Login import *


def open_nsat_app():
    browser = initialize_web_browser()
    go_to_url(browser, NSAT_URL)
    login(browser)


def login(browser):
    browser.switch_to.frame(browser.find_element_by_xpath(INITIAL_FRAME))
    make_action(browser=browser, selector=IMAGE_LOGIN, action="click")
    make_action(browser=browser, selector=INPUT_USERNAME_FORM, action="write", value="")
    make_action(browser=browser, selector=INPUT_PASSWORD_FORM, action="write", value=Keys.CONTROL + "a")
    make_action(browser=browser, selector=INPUT_PASSWORD_FORM, action="write", value=Keys.BACKSPACE)
    make_action(browser=browser, selector=INPUT_PASSWORD_FORM, action="write", value="")
    make_action(browser=browser, selector=BUTTON_ACCEPT, action="click")
    time.sleep(3)
    if make_action(browser=browser, selector="CODENT", type_search="NAME", action="check", force_presence=False):
        make_action(browser=browser, selector="CODENT", type_search="NAME", action="write", value="0")
        make_action(browser=browser, selector=BUTTON_ACCEPT, action="click")
        time.sleep(2)