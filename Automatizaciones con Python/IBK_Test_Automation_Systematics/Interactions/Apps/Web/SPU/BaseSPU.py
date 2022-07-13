import time

from Config.Parameters import *
from Interactions.Apps.Web.BaseWeb import *


def initialize():
    browser = initialize_web_browser()
    go_to_url(browser, SPU_WEB_URL)
    return browser


def login(browser):
    make_action(browser, SPU_USER_LOGIN_WEB_ELEMENT_XPATH, "write", SPU_WEB_USER)
    make_action(browser, SPU_PASSWORD_LOGIN_WEB_ELEMENT_XPATH, "write_enter", SPU_WEB_PASSWORD)
    time.sleep(4)
