import datetime
import tkinter as tk
import tkinter.font as tkFont
import json
from tkinter import messagebox
from tkcalendar import DateEntry
from Config import RobotParameters
import time

from Interactions.Apps.Desktop.SNA32 import BaseSNA
from Interactions.Apps.Desktop.SNA32.Connex import FTI


class App:
    def __init__(self, root):
        # setting title
        root.title("Connex consultor PAN by CANVIA")
        # setting window size
        width = 350
        height = 322
        screenwidth = root.winfo_screenwidth()
        screenheight = root.winfo_screenheight()
        alignstr = '%dx%d+%d+%d' % (width, height, (screenwidth - width) / 2, (screenheight - height) / 2)
        root.geometry(alignstr)
        root.resizable(width=False, height=False)

        GLabel_1 = tk.Label(root)
        ft = tkFont.Font(family='Times', size=10)
        GLabel_1["font"] = ft
        GLabel_1["fg"] = "#333333"
        GLabel_1["justify"] = "center"
        GLabel_1["text"] = "N° tarjeta / PAN"
        GLabel_1.place(x=30, y=40, width=100, height=25)

        GLabel_103 = tk.Label(root)
        ft = tkFont.Font(family='Times', size=10)
        GLabel_103["font"] = ft
        GLabel_103["fg"] = "#333333"
        GLabel_103["justify"] = "center"
        GLabel_103["text"] = "Fecha Inicio"
        GLabel_103.place(x=40, y=80, width=70, height=25)

        GLabel_612 = tk.Label(root)
        ft = tkFont.Font(family='Times', size=10)
        GLabel_612["font"] = ft
        GLabel_612["fg"] = "#333333"
        GLabel_612["justify"] = "center"
        GLabel_612["text"] = "Fecha Fin"
        GLabel_612.place(x=40, y=120, width=70, height=25)

        GLabel_179 = tk.Label(root)
        ft = tkFont.Font(family='Times', size=10)
        GLabel_179["font"] = ft
        GLabel_179["fg"] = "#333333"
        GLabel_179["justify"] = "center"
        GLabel_179["text"] = "Valor Esperado"
        GLabel_179.place(x=30, y=160, width=100, height=25)

        pans = RobotParameters.user()["CardPANS"]
        variable = tk.StringVar(root)
        variable.set(pans[0])
        GLineEdit_725 = tk.OptionMenu(root, variable, *pans)
        GLineEdit_725["borderwidth"] = "1px"
        ft = tkFont.Font(family='Times', size=10)
        GLineEdit_725["font"] = ft
        GLineEdit_725["fg"] = "#333333"
        GLineEdit_725["justify"] = "center"
        GLineEdit_725["text"] = ""
        GLineEdit_725.place(x=170, y=40, width=150, height=25)
        self.pan = GLineEdit_725
        self.selected = variable

        GButton_925 = tk.Button(root)
        GButton_925["bg"] = "#efefef"
        ft = tkFont.Font(family='Times', size=10)
        GButton_925["font"] = ft
        GButton_925["fg"] = "#000000"
        GButton_925["justify"] = "center"
        GButton_925["text"] = "Comenzar"
        GButton_925.place(x=180, y=270, width=70, height=25)
        GButton_925["command"] = self.GButton_925_command

        # dd/mm/YY
        # top = tk.Toplevel(root)
        today = datetime.date.today()
        mindate = today - datetime.timedelta(days=30)
        cal_startdate = DateEntry(root, font="Arial 9", selectmode='day', locale='es_PE',
                                  mindate=mindate, maxdate=today, disabledforeground='red',
                                  cursor='hand1', year=today.year, month=today.month, day=today.day)
        cal_startdate.place(x=170, y=80, width=70, height=25)

        self.start_date = cal_startdate

        cal_endate = DateEntry(root, font="Arial 9", selectmode='day', locale='es_PE',
                               mindate=mindate, maxdate=today, disabledforeground='red',
                               cursor='hand1', year=today.year, month=today.month, day=today.day)
        cal_endate.place(x=170, y=120, width=70, height=25)

        self.end_date = cal_endate

        GLineEdit_22 = tk.Entry(root)
        GLineEdit_22["borderwidth"] = "1px"
        ft = tkFont.Font(family='Times', size=10)
        GLineEdit_22["font"] = ft
        GLineEdit_22["fg"] = "#333333"
        GLineEdit_22["justify"] = "center"
        GLineEdit_22["text"] = ""
        GLineEdit_22.place(x=170, y=160, width=70, height=25)
        self.expected_value = GLineEdit_22

        GCheckBox_666 = tk.Checkbutton(root)
        ft = tkFont.Font(family='Times', size=10)
        GCheckBox_666["font"] = ft
        GCheckBox_666["fg"] = "#333333"
        GCheckBox_666["justify"] = "center"
        GCheckBox_666["text"] = "Primer valor"
        GCheckBox_666.place(x=30, y=240, width=100, height=25)
        GCheckBox_666["offvalue"] = "0"
        GCheckBox_666["onvalue"] = "1"
        GCheckBox_666["command"] = self.GCheckBox_666_command

        details_options = ["Detalles Mínimos", "Detalles Totales"]
        detail_variable = tk.StringVar(root)
        detail_variable.set(details_options[0])
        GCheckBox_667 = tk.OptionMenu(root, detail_variable, *details_options)
        GCheckBox_667["borderwidth"] = "1px"
        ft = tkFont.Font(family='Times', size=10)
        GCheckBox_667["font"] = ft
        GCheckBox_667["fg"] = "#333333"
        GCheckBox_667["justify"] = "center"
        GCheckBox_667["text"] = ""
        GCheckBox_667.place(x=20, y=200, width=130, height=25)
        self.detail_options = GCheckBox_667
        self.selected_details = detail_variable

        self.disabled_dates = False
        self.only_first = False

    def GCheckBox_666_command(self):
        self.only_first = not self.only_first

    def GButton_925_command(self):
        start_date = None
        end_date = None

        if (self.selected.get() is None or self.selected.get() == "") and (
                self.expected_value.get() is None or self.expected_value.get() == ""):
            messagebox.showinfo(message="No ha ingresado PAN o Valor esperado", title="Error de Validación")
        else:
            if len(self.selected.get()) == 16 and len(self.expected_value.get()) == 2:
                if (self.start_date.get_date() is None or self.start_date.get_date() == "") and (
                        self.end_date.get_date() is None or self.end_date.get_date() == ""):
                    messagebox.showinfo(
                        message="La(s) casilla(s) de fecha estan vacias, inserte fechas o marque Fecha hoy",
                        title="Error de Validación")
                start_date = self.start_date.get_date()
                end_date = self.end_date.get_date()
                name_directory = time.strftime("%Y%m%d-%H%M%S")
                dictionary = {
                    "PAN": self.selected.get(),
                    "StartDate": str(start_date),
                    "EndDate": str(end_date),
                    "ExpectedValue": self.expected_value.get(),
                    "GetFirst": self.only_first,
                    "Details": self.selected_details.get(),
                    "NameDirectory": str(name_directory)
                }
                json_object = json.dumps(dictionary, indent=7)
                with open("values.json", "w") as outfile:
                    outfile.write(json_object)
                #os.popen(
                #    'behave -f allure_behave.formatter:AllureFormatter -o Reports "C:/Users/xt8393/Desktop/ati-nsat/Automatizaciones con Python/IBK_Test_Automation_Connex_VISASim/Features/consultConnexTransaction.feature"')
                BaseSNA.initialize("connex")
                FTI.open_fti_application()
                FTI.consult_transaction()
                root.destroy()
            else:
                messagebox.showinfo(message="El PAN o Valor Esperado no tienen los digitos correctos",
                                    title="Error de Validación")

    def GCheckBox_410_command(self):
        self.disabled_dates = not self.disabled_dates
        if self.disabled_dates:
            state = "disabled"
        else:
            state = "normal"
        self.start_date.delete(0, 'end')
        self.end_date.delete(0, 'end')
        self.end_date.config(state=state)  # OR entry['state'] = 'disabled'
        self.start_date.config(state=state)  # OR entry['state'] = 'disabled'


if __name__ == "__main__":
    root = tk.Tk()
    app = App(root)
    root.mainloop()
