import time

from Config import RobotParameters
from Config.Parameters import *
from Interactions.Apps.Desktop.SNA32 import BaseSNA
from Interactions.Os.Windows.KeyboardActions import insert_word, press_tab, press_enter


def open_app():
    status = BaseSNA.open_applid_app("logon applid(" + CONNEX_NAME_APPLID + ")")
    if not status:
        raise


def login_connex_app():
    insert_word(RobotParameters.user()["ConnexUser"])
    press_tab()
    insert_word(RobotParameters.user()["ConnexPassword"])
    press_enter()
    time.sleep(2)
    status = BaseSNA.validate_app_present("text", CONNEX_INTERFACE_SELECT_MENU_VALUE_TO_CHECK)
    return status


def navigate_to_option(tabs_to_select, time_to_wait, value_to_validate):
    if tabs_to_select is not None:
        press_tab(multiple_times=tabs_to_select)
    press_enter()
    time.sleep(time_to_wait)
    return BaseSNA.validate_app_present("text", value_to_validate)
