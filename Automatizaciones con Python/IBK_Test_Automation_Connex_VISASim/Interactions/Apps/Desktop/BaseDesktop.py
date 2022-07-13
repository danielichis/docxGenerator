import time

import pywinauto.findwindows
from pywinauto import Application, Desktop
from Interactions.Os.Windows.KeyboardActions import *


def close_application(title_app):
    app = Application().connect(title=title_app, timeout=10)
    app.type_keys("%{F4}")  # Alt-F4


def open_application(route, title_app, minimize_all=False, maximize_app=False, wait_to_open=0):
    app = Application(backend="uia")
    if minimize_all:
        minimize_all_windows()
    try:
        app.start(route, timeout=wait_to_open)
        windows = Desktop(backend="uia").windows()
        if len(windows):
            for w in windows:
                if title_app in w.window_text():
                    '''connect = app.connect(title=w.window_text())'''
                    if maximize_app:
                        maximize_current_window()
        else:
            raise

    except Exception as ex:
        print('Error: ' + str(ex))
        raise
