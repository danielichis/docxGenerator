from fileinput import filename
from sre_parse import State
from statistics import mode
import string
from numpy import matrix
import pandas as pd
from tkinter import *
import tkinter
import tkinter.messagebox
from tkinter import messagebox
from tkinter import END, StringVar, filedialog
from attr import validate
import customtkinter
import sys
import os
from composer import combine_all_docx
from makefiles import make_files
from docximage import add_imagenes
from tkinter import filedialog as fd
from tkinter.messagebox import showinfo
customtkinter.set_appearance_mode("Dark")  # Modes: "System" (standard), "Dark", "Light"
customtkinter.set_default_color_theme("green")

#first change in other pc
class App(customtkinter.CTk):
    WIDTH = 780
    HEIGHT = 520
    def ruta_carpeta_application(self):
        config_name = 'myapp.cfg'
        # determine if application is a script file or frozen exe
        if getattr(sys, 'frozen', False):
            application_path = os.path.dirname(sys.executable)
        elif __file__:
            application_path = os.path.dirname(__file__)
        config_path = os.path.join(application_path, config_name)
        #mb.showinfo("Información", config_path)
        print(application_path)
        return application_path
    def __init__(self):
        super().__init__()
        self.iconbitmap(self.ruta_carpeta_application()+"/"+"MP.ico")
        self.title("QA TESTING MEDIOS DE PAGO DOCS")
        self.geometry(f"{App.WIDTH}x{App.HEIGHT}")
        self.protocol("WM_DELETE_WINDOW", self.on_closing)  # call .on_closing() when app gets closed
        self.grid_columnconfigure(5, weight=1)
        self.grid_rowconfigure(9, weight=1)
        self.wordtoaddimage=self.ruta_carpeta_application()+"CP JUNTO.docx"

        self.button_1 = customtkinter.CTkButton(master=self,
                                                text="Carpeta de capturas de pantalla",
                                                fg_color=("gray75", "gray30"),  # <- custom tuple-color
                                                command=lambda:self.folder_pics())
        self.button_1.grid(row=1, column=0, pady=10, padx=10)

        self.button_2 = customtkinter.CTkButton(master=self,
                                                text="Seleccione Matriz de CP",
                                                fg_color=("gray75", "gray30"),  # <- custom tuple-color
                                                command=lambda:self.read_excel())
        self.button_2.grid(row=1, column=1, pady=10, padx=10)

        self.button_3 = customtkinter.CTkButton(master=self,
                                                text="GENERAR DOCUMENTOS",
                                                fg_color=("gray75", "gray30"),  # <- custom tuple-color
                                                command=lambda:self.generar_docs()) #state=tkinter.DISABLED
        self.button_3.grid(row=7, column=3, pady=10, padx=10)

        self.button_4 = customtkinter.CTkButton(master=self,
                                                text="UNIR DOCUMENTOS",
                                                fg_color=("red75", "gray30"),  # <- custom tuple-color
                                                command=lambda:self.unir_docs()) #state=tkinter.DISABLED
        self.button_4.grid(row=8, column=3, pady=0, padx=00)

        self.button_4 = customtkinter.CTkButton(master=self,
                                                text="AGREGAR IMAGENES",
                                                fg_color=("red75", "gray30"),  # <- custom tuple-color
                                                command=lambda:add_imagenes(self.ruta_carpeta_application(),self.wordtoaddimage)) #state=tkinter.DISABLED
        self.button_4.grid(row=9, column=3, pady=0, padx=00)

        
        self.label_1 = customtkinter.CTkLabel(master=self,
                                              text="cantidad de capturas de pantalla",
                                              text_font=("Roboto Medium", -16))  # font name and size in px
        self.label_1.grid(row=2, column=0, pady=10, padx=10)

        self.label_2 = customtkinter.CTkLabel(master=self,
                                              text="cantidad de cp en Matriz",
                                              text_font=("Roboto Medium", -16))  # font name and size in px
        self.label_2.grid(row=6, column=0, pady=10, padx=10)

        
        self.label_5 = customtkinter.CTkLabel(master=self,
                                              text="CODIGO DE REQUERIMIENTO",
                                              text_font=("Roboto Medium", -16))  # font name and size in px
        self.label_5.grid(row=7, column=0, pady=10, padx=10)

        self.sv1=StringVar()
        #self.sv1.trace("w", lambda name, index, mode, change_validar)        
        #self.e1=Entry(self, textvariable=self.sv1, validate="focusout", validatecommand=self.change_validar)
        self.e1=customtkinter.CTkEntry(master=self)
        self.e1.grid(row=2,column=1,pady=10, padx=10)
        self.sv1='0'
        self.e1.insert(0,self.sv1)

        self.sv2=StringVar()
        #self.e2=Entry(self, textvariable=self.sv2, validate="focusout", validatecommand=self.change_validar)
        self.e2=customtkinter.CTkEntry(master=self)
        self.e2.grid(row=6,column=1,pady=10, padx=10)
        self.sv2='0'
        self.e2.insert(0,self.sv2)

        self.e3=customtkinter.CTkEntry(master=self)
        self.e3.grid(row=7,column=1,pady=10, padx=10)
        self.sv3=''
        self.e3.insert(0,self.sv3)

        self.switch_2 = customtkinter.CTkSwitch(master=self,
                                                text="Dark Mode",
                                                command=self.change_mode)
        self.switch_2.grid(row=9, column=0, pady=10, padx=20, sticky="w")

        self.switch_3 = customtkinter.CTkSwitch(master=self,
                                                text=".DOC JUNTOS",
                                                )
        self.switch_3.grid(row=8, column=1, pady=10, padx=20, sticky="w")

        self.switch_4 = customtkinter.CTkSwitch(master=self,
                                                text=".DOC CON IMAGENES",
                                                )
        self.switch_4.grid(row=8, column=0, pady=10, padx=20, sticky="w")

    def generar_docs(self):
        appFolder=self.ruta_carpeta_application()
        folderEpc=appFolder+"/"+"Archivos Ouput"
        codeReq=self.e3.get()
        pathTemplate="EPC_template.docx"
        ejecutado=False
        try:
            matrixPath=self.filename
            if self.filename!="":
                modeJoin=False
                make_files(appFolder,codeReq,self.filename,modeJoin)
                print("Generando documentos...")
                print(f"ruta de casos de prueba {folderEpc}")
                print(f"nombre plantilla epc {pathTemplate}")
                print(f"nombre archivo matriz {matrixPath}")
                print(f"codgio de requerimiento {codeReq}")
                messagebox.showinfo("PROCEDIMIENTO EXITOSO","SE CREARON LOS ARCHIVOS")
                ejecutado=True
            else:
                messagebox.showerror("SIN MATRIZ","ERRR INESPERADO :(")
                print(f"el nombre del archivo matriz es :{self.filename}")
        except Exception as e:
            print (e)
            messagebox.showerror("SIN MATRIZ","ERROR NO SE PUDO GENERAR LSO ARCHIVOS")
            print(self.filename)
        print(f"BOLEANO DE COMBINAR :{self.switch_3.get()}")
        print(f"BOLEANO DE IMAGENES :{self.switch_4.get()}")
        if self.switch_3.get()==1 and ejecutado==True:
            print("ejecutando procedimiento de unir docs")
            self.unir_docs()
        if self.switch_4.get()==1 and ejecutado==True:
            print("ejecutando procedimiento de  agregar imagenes")
            nameDoc=self.wordtoaddimage
            modeJoin=True
            add_imagenes(self.ruta_carpeta_application(),nameDoc,modeJoin)
    def unir_docs(self):
        appFolder=self.ruta_carpeta_application()
        print("Uniendo los documentos...")
        try:
            combine_all_docx(appFolder)
            messagebox.showinfo("PROCEDMIENTO EXITOSO","SE COMBINARON LOS DOCUMENTOS :) ")
        except Exception as e:
            print(e)
            messagebox.showerror("ERROR","NO SE PUDO COMBINAR :(")
    def folder_pics(self):
        print(f"seleccionando carpeta de imagenes ")
        self.folderPdfs=""
        self.folderPdfs=filedialog.askdirectory()
        #ext="pdf"
        print(self.folderPdfs)
        directory = os.fsencode(self.folderPdfs)
        self.count_files_1=0
        self.count_files_2=0
        for file in os.listdir(directory):
            filename = os.fsdecode(file)
            #print(filename)
            if filename.endswith(f".jpg") or filename.endswith(f".png"):
                self.count_files_1=self.count_files_1+1
                filePath=f"{self.folderPdfs}/{filename}"
                self.e1.delete(0,END)
                self.e1.insert(0,self.count_files_1)
            else:
                continue
        print(f"cantidad de imagenes: {self.count_files_1}")
    def select_file(self):
        filetypes = (
            ('text files', '*.xlsx'),
            ('All files', '*.*')
        )

        filename = fd.askopenfilename(
            title='Open a file',
            initialdir='/',
            filetypes=filetypes)
        if filename!="":
            showinfo(
                title='SELECCION',
                message=filename
            )
        return filename
    def read_excel(self):
        appFolder=self.ruta_carpeta_application()
        print("parseando el excel")
        try:
            self.filename=self.select_file()
            casos=pd.read_excel(self.filename).to_dict("records")
            with open(appFolder+"/Archivos Plantilla/"+"HeadersMatrix.txt")as f:
                headers =dict([x.strip().split(":") for x in f.readlines()])
            print(headers["NUMERO DE CASO DE PRUEBA"])
            cp=headers["NUMERO DE CASO DE PRUEBA"]
            #print(casos)
            count_cases=0
            for caso in casos:
                print(caso)
                if not pd.isna((caso[cp])):
                    count_cases=count_cases+1
            self.e2.delete(0,END)
            self.e2.insert(0,count_cases)
        except Exception as e:
            print(e)
            messagebox.showerror("ERROR EN LA PRIMERA COLUMNA DE LA MATRIZ")

    def change_mode(self):
        if self.switch_2.get() == 1:
            customtkinter.set_appearance_mode("light")
        else:
            customtkinter.set_appearance_mode("dark")

    def on_closing(self, event=0):
        self.destroy()
    def start(self):
        self.mainloop()
            
if __name__ == "__main__":
    app = App()
    app.start()
    
