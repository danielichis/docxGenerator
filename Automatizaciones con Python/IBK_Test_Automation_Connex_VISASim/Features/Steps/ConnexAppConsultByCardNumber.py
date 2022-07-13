import os
from datetime import time

from behave import *

from Config import RobotParameters
from Config.Environment import env
from Interactions.Apps.Desktop.SNA32 import BaseSNA
from Interactions.Apps.Desktop.SNA32.Connex.FTI import *
from Utils.DateConverter import *

use_step_matcher("re")


@given("el analista QA se autentica en CONNEX")
def step_impl(context):
    """
    :type context: behave.runner.Context
    """
    assert (BaseSNA.initialize("connex"))
    '''raise NotImplementedError(u'STEP: Given the QA Analyst sign in CONNEX application')'''


@step("ingrea al área de FTI")
def step_impl(context):
    """
    :type context: behave.runner.Context
    """
    assert (open_fti_application())
    '''raise NotImplementedError(u'STEP: And search the transaction of specific card number')'''


@then('busca la transacción con el número de tarjeta entre las fechas y se valida el valor esperado')
def step_impl(context):
    """
    :type context: behave.runner.Context
    """
    pan = RobotParameters.values()["PAN"]
    if len(pan) != 16:
        raise
    dates_formatted = {}
    date_range_start = RobotParameters.values()["StartDate"]
    date_range_end = RobotParameters.values()["EndDate"]
    only_first = RobotParameters.values()["GetFirst"]
    details = RobotParameters.values()["Details"]
    name_directory = env("JSON_DIRECTORY") + RobotParameters.values()["NameDirectory"]
    os.mkdir(env("JSON_DIRECTORY") + RobotParameters.values()["NameDirectory"])
    require_first = False
    if (date_range_start != "None" or date_range_start != "") and (date_range_end != "None" or date_range_end != ""):
        values = {0: date_range_start, 1: date_range_end}
        dates_formatted = convert_date(values)
    if only_first:
        require_first = True
    expected_value = RobotParameters.values()["ExpectedValue"]
    middle = consult_transaction(card_number=pan, range_between=dates_formatted, require_detail=details,
                                     only_first=require_first, name_directory=name_directory, expected_value=expected_value)

    assert (middle[0])


    # if expected_value:
    #     final = FTI.expected_transaction_value_comparer(final_values=middle[1], expected_value=expected_value,
    #                                                     name_directory=name_directory)
    #     assert final
    '''raise NotImplementedError(u'STEP: And set a specific date')'''
