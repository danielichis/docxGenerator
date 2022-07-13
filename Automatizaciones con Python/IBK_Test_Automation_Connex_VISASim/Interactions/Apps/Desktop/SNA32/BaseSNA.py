import time

from pywinauto import Application

from Config import RobotParameters
from Interactions.Apps.Desktop.BaseDesktop import *
from Interactions.Apps.Desktop.SNA32.Connex.BaseConnex import *
from Interactions.Os.Windows.KeyboardActions import *
from Config.Parameters import *
from Interactions.Os.Windows.Mouse import click_center


def initialize(app):
    try:
        close_opened_SNA()
    except Exception as e:
        pass
    open_application(route=RobotParameters.user()["RouteSNAApplication"], title_app=TITLE_SNA_APPLICATION,
                                 minimize_all=True, maximize_app=True, wait_to_open=20)

    if validate_app_present(type_validation="text", expected_value=SNA_INITIAL_VALUE_TO_CHECK):
        if app == "connex":
            open_app()
            if validate_app_present("text", CONNEX_INTERFACE_LOGIN_VALUE_TO_CHECK):
                return login_connex_app()
    else:
        raise


def open_applid_app(app):
    keyboard.send_keys('{F12}')
    time.sleep(1)
    if validate_app_present(type_validation="text",
                            expected_value=APPLID_INTERFACE_VALUE_TO_CHECK):
        insert_word(app)
        press_enter()
        time.sleep(3)
        return True
    else:
        raise


def validate_app_present(type_validation, expected_value):
    copy_all_value_in_screen_command()
    value = str(pyperclip.paste())
    logic = expected_value in value
    return logic


def close_opened_SNA():
    app = Application(backend="uia").connect(path=ROUTE_SNA_APPLICATION)
    #app.SNAServer3270Applet.set_focus()
    # APP.SNAServer3270Applet.Views.click()
    app.kill(soft=True)


def copy_all_value_in_screen_command():
    keyboard.send_keys('{VK_MENU down}''{VK_MENU up}')
    keyboard.send_keys('{e down}''{e up}')
    keyboard.send_keys('{s down}''{s up}')
    keyboard.send_keys('{VK_MENU down}''{VK_MENU up}')
    keyboard.send_keys('{e down}''{e up}')
    keyboard.send_keys('{c down}''{c up}')
    click_center()