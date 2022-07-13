import os
import time
from datetime import datetime

from Config import Parameters
from Config.Parameters import *
from Interactions.Apps.Mainframe.BaseMainframe import validate_presence_text, reset_session, ingress_values_console


def ingress_first_login(em):
    em.fill_field(10, 68, CICS_USER, 6)
    em.fill_field(11, 68, CICS_PASSWORD, 7)
    em.send_enter()
    em.wait_for_field()
    parameters = [
        1, 24, CICS_SELECTOR_MEESAGE_VALIDATION
    ]
    validate_presence_text(em, parameters)


def initial_ingress(em):
    em.fill_field(23, 14, CICS_ACEPTA_ADMINISTRATIVO_OPTION, 1)
    em.send_enter()
    time.sleep(4)
    #if em.string_get(1, 1, 3) == "EMS":
    #    reset_session(em)
    # if em.string_get(6, 32, 23) == CICS_AUTHORIZED_APPS or \
    # em.string_get(21, 55, 15) == CICS_SECOND_LOGIN_VALIDATION_INTERFACE or \
    # em.string_get(17, 18, 41) == SYSTEMATICS_INITIAL_SCREEN_MESSAGE_VALIDATION:
    if em.string_get(22, 22, 20) != CICS_ACEPTA_ADMINISTRATIVO_PLATFORM_INTERFACE:
        print(em.string_get(6, 32, 23))
        print(em.string_get(21, 55, 15))
        print(em.string_get(17, 18, 41))
        reset_session(em)
    em.wait_for_field()
    parameters = [
           22, 22, CICS_ACEPTA_ADMINISTRATIVO_PLATFORM_INTERFACE
    ]
    validate_presence_text(em, parameters)


def ingress_app_ib00(em):
    em.fill_field(20, 69, "ib00", 4)
    em.send_enter()
    time.sleep(3)
    em.wait_for_field()
    parameters = [
        21, 55, CICS_SECOND_LOGIN_VALIDATION_INTERFACE
    ]
    validate_presence_text(em, parameters)


def authenticate_login_by_CICSAA2K(em):
    em.fill_field(10, 71, CICS_USER, 6)
    em.fill_field(11, 71, CICS_PASSWORD, 7)
    em.send_enter()
    time.sleep(2)
    em.wait_for_field()
    parameters = [
        6, 32, CICS_AUTHORIZED_APPS
    ]
    validate_presence_text(em, parameters)


def open_systematics(em):
    em.fill_field(20, 44, CICS_SYSTEMATICS_OPTION, 1)
    em.send_enter()
    time.sleep(3)
    em.wait_for_field()
    parameters = [
        17, 18, SYSTEMATICS_INITIAL_SCREEN_MESSAGE_VALIDATION
    ]
    validate_presence_text(em, parameters)
    em.exec_command(b'CLEAR')


def consult_systematics(em, CU):
    parameters = [
        2,
        21,
        SYSTEMATICS_RMAB_PANEL_SUCCESS_CONSULT_VALIDATION,
    ]
    ingress_values_console(em, "rmab;nb"+CU, validate_after=True, parameters_to_check=parameters)
    positions = [7, 9, 11, 13, 15, 17, 19]
    filtered_positions = []
    accounts_filtered = []
    date_range_start = Parameters.values()["StartDate"]
    date_range_end = Parameters.values()["EndDate"]
    name_directory = Parameters.user()["ReportDirectory"] + Parameters.values()["NameDirectory"]
    os.mkdir(name_directory)
    os.mkdir(name_directory + "\\im")
    os.mkdir(name_directory + "\\st")
    date_1 = datetime.strptime(date_range_start, "%Y-%m-%d")
    date_2 = datetime.strptime(date_range_end, "%Y-%m-%d")
    print(date_1)
    print(date_2)
    for y in positions:
        if em.string_found(y, 4, "P"):
            date_3 = datetime.strptime(em.string_get(y+1, 64, 10), "%d/%m/%Y")
            if date_1 <= date_3 <= date_2:
                filtered_positions.append(y)
    if len(filtered_positions) > 0:
        for x in filtered_positions:
            command_applier = ""
            if em.string_get(x, 18, 2) == "ST":
                command_applier = "s"
            elif em.string_get(x, 18, 2) == "IM":
                command_applier = "i"
            else:
                pass
            if command_applier != "":
                accounts_filtered.append(em.string_get(x, 21, 20))
                em.fill_field(x, 2, "x", 1)
                em.send_enter()
                time.sleep(2)
                xt1(em, command_applier, name_directory)
                xt2(em, command_applier, name_directory)
                xt5(em, command_applier, name_directory)
            rmab_return(em)
    else:
        print("no hay transacciones que consultar o valores para rescatar")
        raise
    # else:
    #     raise
    print(filtered_positions)
    print(accounts_filtered)
    em.terminate()


def xt1(em, command_applier, name_directory):
    parameters1 = parameters2 = []
    report_name = ""
    if command_applier == "s":
        report_name = "st"
        parameters1 = [
            2,
            30,
            ST1_MESSAGE_TITLE_1
        ]
        parameters2 = [
            2,
            27,
            ST1_MESSAGE_TITLE_2
        ]
    if command_applier == "i":
        report_name = "im"
        parameters1 = [
            2,
            25,
            IM1_MESSAGE_TITLE_1
        ]
        parameters2 = [
            2,
            29,
            IM1_MESSAGE_TITLE_2
        ]
    em.wait_for_field()
    validate_presence_text(em, parameters1)
    em.save_screen(name_directory+"\\"+report_name+"\\report"+report_name+"1.html")
    em.send_pf("1")
    time.sleep(2)
    em.wait_for_field()
    validate_presence_text(em, parameters2)
    em.save_screen(name_directory+"\\"+report_name+"\\report"+report_name+"1.html")


def xt2(em, command_applier, name_directory):
    em.send_pf4()
    time.sleep(2)
    em.wait_for_field()
    parameters1 = parameters2 = []
    report_name = ""
    if command_applier == "s":
        report_name = "st"
        parameters1 = [
            2,
            24,
            ST2_MESSAGE_TITLE_1
        ]
        parameters2 = [
            2,
            29,
            ST2_MESSAGE_TITLE_2
        ]
    if command_applier == "i":
        report_name = "im"
        parameters1 = [
            2,
            26,
            IM2_MESSAGE_TITLE_1
        ]
        parameters2 = [
            2,
            26,
            IM2_MESSAGE_TITLE_2
        ]
    validate_presence_text(em, parameters1)
    em.move_to(3,18)
    em.send_enter()
    time.sleep(2)
    em.wait_for_field()
    validate_presence_text(em, parameters2)
    em.save_screen(name_directory+"\\"+report_name+"\\report"+report_name+"2.html")


def xt5(em, command_applier, name_directory):
    em.move_to(1, 18)
    em.send_string("5")
    em.send_enter()
    time.sleep(2)
    em.wait_for_field()
    report_name = ""
    if command_applier == "s":
        report_name = "st"
        parameters = [
            2,
            30,
            ST5_MESSAGE_TITLE
        ]
        validate_presence_text(em, parameters)
    if command_applier == "i":
        report_name = "im"
        parameters = [
            2,
            27,
            IM5_MESSAGE_TITLE
        ]
        validate_presence_text(em, parameters)
        em.move_to(3, 17)
        em.send_enter()
        time.sleep(2)
        parameters2 = [
            2,
            21,
            IM5_MESSAGE_TITLE_2
        ]
        validate_presence_text(em, parameters2)
    em.save_screen(name_directory+"\\"+report_name+"\\report"+report_name+"5.html")


def rmab_return(em):
    em.move_to(1, 15)
    em.send_string("rmab")
    em.send_enter()
    time.sleep(2)
    em.wait_for_field()