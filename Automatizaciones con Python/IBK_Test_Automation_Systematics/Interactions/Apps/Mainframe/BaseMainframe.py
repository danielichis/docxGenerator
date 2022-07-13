import time

from py3270 import Emulator

from Config.Parameters import ENDPOINT_TELNET_INITIAL_MESSAGE


def ingress():
    em = Emulator()
    em.connect("130.30.30.6:2023")
    em.wait_for_field()
    if em.string_found(1, 12, ENDPOINT_TELNET_INITIAL_MESSAGE):
        return em
    else:
        em.terminate()
        raise


def logon_applid(em, name_app, screen_ingress_parameters, time_wait):
    string_to_send = "LOGON APPLID(" + name_app + ")"
    ingress_values_console(em=em, string_to_send=string_to_send,
                           validate_after=True, parameters_to_check=screen_ingress_parameters, time_wait=time_wait)


def ingress_values_console(em, string_to_send, validate_after=False, parameters_to_check=None, time_wait=2):
    em.send_string(string_to_send)
    em.send_enter()
    time.sleep(time_wait)
    em.wait_for_field()
    if validate_after:
        validate_presence_text(em, parameters_to_check)


def validate_presence_text(em, screen_ingress_parameters):
    x = screen_ingress_parameters[0]
    y = screen_ingress_parameters[1]
    value_to_compare = screen_ingress_parameters[2]
    print("valor obtenido : "+em.string_get(x, y, len(value_to_compare)))
    print("valor esperado : "+value_to_compare)
    if em.string_found(x, y, value_to_compare):
        em.save_screen("captura.html")
        return em
    else:
        em.save_screen("capturaerror.html")
        em.terminate()
        raise


def reset_session(em):
    try:
        em.exec_command(b'CLEAR')
        em.send_string("cesf")
        em.send_enter()
        time.sleep(3)
        em.send_pf3()
        time.sleep(1)
    except Exception as err:
        em.terminate()