import time

from Config.Parameters import *
from Interactions.Apps.Web.BaseWeb import make_action
from Interactions.Apps.Web.SPU import BaseSPU


def execute_all(PAN):
    browser = BaseSPU.initialize()
    BaseSPU.login(browser)
    go_to_tab(browser)
    select_type_search("DEBIT_CARD_NUMBER", browser)
    insert_parameters_form_by_debit_card(browser, PAN)
    return get_text_first_search_result_card(browser)


def go_to_tab(browser):
    make_action(browser, SPU_CONSULT_TAB_XPATH, "click")


def select_type_search(option, browser):
    make_action(browser, SPU_CONSULT_TYPE_SEARCH_XPATH, "click", wait=3)
    if option == "DEBIT_CARD_NUMBER":
        make_action(browser, SPU_CONSULT_DEBIT_CARD_OPTION_XPATH, "click", wait=3)
        time.sleep(2)


def insert_parameters_form_by_debit_card(browser,PAN):
    make_action(browser, SPU_CONSULT_DEBIT_CARD_INPUT_XPATH, "write_enter", PAN)
    time.sleep(3)


def get_text_first_search_result_card(browser):
    value = make_action(browser, SPU_CONSULT_CU_VALUE_CARD_XPATH, "get_text")
    print(value[6:16])
    return value[6:16]
