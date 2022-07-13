from Config.Parameters import ACCESS_30_NAME_APPLID, ACCESS30_INITIAL_VALUE_TO_CHECK
from Interactions.Apps.Mainframe.BaseMainframe import logon_applid


def ingress(em):
    parameters_to_validate = [
        2,
        12,
        ACCESS30_INITIAL_VALUE_TO_CHECK
    ]
    logon_applid(em, ACCESS_30_NAME_APPLID, parameters_to_validate, 2)