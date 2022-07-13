from Config import Parameters
from Interactions.Apps.Web.SPU import Consult
from Steps import Mainframe_ingress, Access_applid_30_ingress, Systematics_ingress, CICSAA2K_ingress, Report_generation


def all():
    print("paso 1 : Ingreso a Mainframe por Telnet")
    em = Mainframe_ingress.run()
    print("paso 2 : Ingreso a la aplicacion Access30 y luego CICSAA2K")
    Access_applid_30_ingress.run(em)
    #CICSAA2K_ingress.run(em)
    print("paso 3 : Ingreso a Systematics")
    Systematics_ingress.run(em)
    print("paso 9 : Ingreso de Valores de Tarjeta")
    CU = Consult.execute_all(Parameters.values()["PAN"])
    print("paso 10 : Consulta de Datos en Systematics")
    Report_generation.run(em, CU)