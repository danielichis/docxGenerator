import time

from win32api import GetSystemMetrics, mouse_event, SetCursorPos
from win32con import *


def click_center():
    x = int(GetSystemMetrics(0) / 2)
    y = int(GetSystemMetrics(1) / 2)

    SetCursorPos((x, y))
    mouse_event(MOUSEEVENTF_LEFTDOWN, x, y, 0, 0)
    time.sleep(.1)
    mouse_event(MOUSEEVENTF_LEFTUP, x, y, 0, 0)
