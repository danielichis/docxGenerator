from Interactions.Apps.Mainframe.Apps import Systematics


def run(em):
    print("paso 4")
    Systematics.ingress_first_login(em)
    print("paso 5")
    Systematics.initial_ingress(em)
    print("paso 6")
    Systematics.ingress_app_ib00(em)
    print("paso 7")
    Systematics.authenticate_login_by_CICSAA2K(em)
    print("paso 8")
    Systematics.open_systematics(em)