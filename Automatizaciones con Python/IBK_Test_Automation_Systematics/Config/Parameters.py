from Utils import JsonReader

ENDPOINT_TELNET_SERVER_IP_ADDRESS = "130.30.30.6"
ENDPOINT_TELNET_SERVER_PORT_NUMBER = "2023"
ENDPOINT_TELNET_INITIAL_MESSAGE = "Enter: LOGON APPLID() LOGMODE() DATA()"
ACCESS30_INITIAL_VALUE_TO_CHECK = "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"
CICSAA2K_INITIAL_VALUE_TO_CHECK = "INTERBANK Bankactiva"
CICS_USER = "xt7177"
CICS_PASSWORD = "7177018"
ACCESS_30_NAME_APPLID = "ACCESS30"
CICSAA2K_NAME_APPLID = "CICSAA2K"
CICS_ACEPTA_ADMINISTRATIVO_OPTION = "1"
CICS_ACEPTA_ADMINISTRATIVO_PLATFORM_INTERFACE = "INTERBANK Bankactiva"
CICS_SECOND_LOGIN_VALIDATION_INTERFACE = "Intransferibles"
CICS_AUTHORIZED_APPS = "Aplicativos Autorizados"
CICS_SELECTOR_MEESAGE_VALIDATION = "Seleccion de Aplicaciones"
ERROR_MESSAGE = "EMS"
CICS_SYSTEMATICS_OPTION = "9"
SYSTEMATICS_INITIAL_SCREEN_MESSAGE_VALIDATION = "BIENVENIDO A LAS APLICACIONES SYSTEMATICS"
SYSTEMATICS_RMAB_PANEL_SUCCESS_CONSULT_VALIDATION = "CONSULTA RAPIDA RELACIONES DE CUENTA-CLIENTE"
ST1_MESSAGE_TITLE_1 = "INFORMACION DE CUENTAS"
IM1_MESSAGE_TITLE_1 = "CONSULTA SOBRE CUENTAS DE IM"
ST1_MESSAGE_TITLE_2 = "INFORMACION DE CUENTAS"
IM1_MESSAGE_TITLE_2 = "INFORMACION DE LA CUENTA"
ST2_MESSAGE_TITLE_1 = "CONSULTA HISTORICO DE CUENTA DE ST"
IM2_MESSAGE_TITLE_1 = "CONSULTA HISTORICA DE CUENTA"
ST2_MESSAGE_TITLE_2 = "HISTORICO DE CUENTA ST"
IM2_MESSAGE_TITLE_2 = "HISTORIALES DE CUENTA DE IMPACS"
ST5_MESSAGE_TITLE = "CONSULTA ONP/RETENC DE ST"
IM5_MESSAGE_TITLE = "CONSULTA SUSPENCION/RETENCION"
IM5_MESSAGE_TITLE_2 = "CONSULTA SOBRE PAROS DE PAGO/RETENCIONES"
SPU_WEB_URL = "http://ibkspuuat/spu/login.zul"
SPU_WEB_USER = "xt7177"
SPU_WEB_PASSWORD = "Septiembre20/00"
SPU_USER_LOGIN_WEB_ELEMENT_XPATH = "/html/body/div[2]/div[3]/div/div/div/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr/td[3]/input"
SPU_PASSWORD_LOGIN_WEB_ELEMENT_XPATH = "/html/body/div[2]/div[3]/div/div/div/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr/td[3]/input"
SPU_CONSULT_TAB_XPATH = "/html/body/div/div[2]/div/div[2]/div[1]/div[1]/div[2]/div/div/div/div/div[1]/div/div/div/table/tbody/tr/td[1]/a/table/tbody/tr/td[2]/div/button"
SPU_CONSULT_TYPE_SEARCH_XPATH = "/html/body/div[3]/div[3]/div/div/div/div/div[1]/div[3]/div[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/table[1]/tbody/tr/td/table/tbody/tr/td[5]/div/i/input"
SPU_CONSULT_DEBIT_CARD_OPTION_XPATH = "/html/body/div[4]/table/tbody/tr[3]/td[2]"
SPU_CONSULT_DEBIT_CARD_INPUT_XPATH = "/html/body/div[3]/div[3]/div/div/div/div/div[1]/div[3]/div[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/table[5]/tbody/tr/td/table/tbody/tr/td[11]/div/input"
SPU_CONSULT_CU_VALUE_CARD_XPATH = "/html/body/div[3]/div[3]/div/div/div/div/div[2]/div[3]/div/div/div/div/div[3]/table/tbody[2]/tr/td[2]/div/span"


def values():
    path = "values.json"
    return JsonReader.values(path)


def user():
    path = "user.json"
    return JsonReader.values(path)