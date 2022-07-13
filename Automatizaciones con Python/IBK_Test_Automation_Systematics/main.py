from Runner import Run
import datetime
import tkinter as tk
import tkinter.font as tkFont
import json
from tkinter import messagebox
from tkcalendar import DateEntry
from Config import Parameters
import time


class App:
    def __init__(self, root):
        # setting title
        root.title("Systematics consultor piloto by CANVIA")
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

        pans = Parameters.user()["CardPANS"]
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
        mindate = today - datetime.timedelta(days=15)
        cal_startdate = DateEntry(root, font="Arial 9", selectmode='day', locale='es_PE',
                                  maxdate=today, disabledforeground='red',
                                  cursor='hand1', year=today.year, month=today.month, day=today.day)
        cal_startdate.place(x=170, y=80, width=70, height=25)

        self.start_date = cal_startdate

        cal_endate = DateEntry(root, font="Arial 9", selectmode='day', locale='es_PE',
                                maxdate=today, disabledforeground='red',
                               cursor='hand1', year=today.year, month=today.month, day=today.day)
        cal_endate.place(x=170, y=120, width=70, height=25)

        self.end_date = cal_endate

        self.disabled_dates = False

    def GButton_925_command(self):
        start_date = None
        end_date = None
        if len(self.selected.get()) == 16:
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
                "NameDirectory": str(name_directory)
            }
            json_object = json.dumps(dictionary, indent=6)
            with open("values.json", "w") as outfile:
                outfile.write(json_object)
            Run.all()
            root.destroy()
        else:
            messagebox.showinfo(message="El PAN no tienen los digitos correctos",
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

