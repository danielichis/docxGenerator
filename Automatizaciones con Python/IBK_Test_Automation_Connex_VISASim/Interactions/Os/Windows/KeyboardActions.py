import pyperclip
from pywinauto import keyboard


def press_tab(multiple_times=0):
    if multiple_times == 0:
        multiple_times = 1
    for x in range(multiple_times):
        keyboard.send_keys('{TAB}')


def press_pause():
    keyboard.send_keys('{VK_PAUSE}')


def press_enter():
    keyboard.send_keys('{ENTER}')


def copy():
    keyboard.send_keys('{VK_CONTROL down}{c down}{c up}{VK_CONTROL up}')


def paste():
    keyboard.send_keys('{VK_CONTROL down}{v down}{v up}{VK_CONTROL up}')


def copy_one_line():
    keyboard.send_keys('{LEFT down}{HOME down}{HOME up}{LEFT up}')
    keyboard.send_keys('{VK_LSHIFT down}{RIGHT down}{RIGHT up}{VK_LSHIFT up}')
    keyboard.send_keys('{VK_CONTROL down}{c down}{c up}{VK_CONTROL up}')


def copy_all(typo):
    keyboard.send_keys('{VK_CONTROL down}{' + typo + ' down}{' + typo + ' up}{VK_CONTROL up}')
    keyboard.send_keys('{VK_CONTROL down}{c down}{c up}{VK_CONTROL up}')


def maximize_current_window():
    keyboard.send_keys('{RWIN down}{UP down}{UP up}{RWIN up}')


def minimize_all_windows():
    keyboard.send_keys('{RWIN down}{m down}{m up}{RWIN up}')


def insert_word(value):
    pyperclip.copy(value)
    paste()


def insert_fx(value):
    keyboard.send_keys("'{F" + value + "}'")
