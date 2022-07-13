import time

from Config.Parameters import CICSAA2K_NAME_APPLID, CICSAA2K_INITIAL_VALUE_TO_CHECK, \
    CICS_SECOND_LOGIN_VALIDATION_INTERFACE
from Interactions.Apps.Mainframe.BaseMainframe import logon_applid, validate_presence_text


def ingress(em):
    parameters = [
        22, 22, CICSAA2K_INITIAL_VALUE_TO_CHECK
    ]
    logon_applid(em, CICSAA2K_NAME_APPLID, parameters, 2)
    ingress_ib00(em)


def ingress_ib00(em):
    em.fill_field(20, 69, "ib00", 4)
    em.send_enter()
    em.wait_for_field()
    time.sleep(4)
    parameters = [
         21, 55, CICS_SECOND_LOGIN_VALIDATION_INTERFACE
    ]
    validate_presence_text(em, parameters)


