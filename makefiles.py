from wsgiref import headers
from tqdm import tqdm
import pandas as pd
from docxtpl import DocxTemplate
from tkinter import messagebox
from datetime import datetime
def make_files(folderApp,codeReq,nameMatrix):
    matrixPath=nameMatrix
    folderEpc=folderApp+"/"+"Archivos Ouput"
    pathTemplate=folderApp+"/"+"Archivos Plantilla"+"/"+"EPC_template.docx"
    headersPath=folderApp+"/"+"Archivos Plantilla"+"/"+"HeadersMatrix.txt"
    doc=DocxTemplate(pathTemplate)
    casos=pd.read_excel(matrixPath)
    noHeaders=False
    with open(headersPath)as f:
        headers =dict([x.strip().split(":") for x in f.readlines()])
    print(headers["NUMERO DE CASO DE PRUEBA"])
    try:
        cp=headers["NUMERO DE CASO DE PRUEBA"]
        descp=headers["DESCRIPCION DEL CASO DE PRUEBA"]
        tester=headers["ANALISTA"]
        status=headers["ESTADO DE LA EJECUCION"]
        testDate=headers["FECHA DE EJECUCION"]
    except:
        messagebox.showerror("Error","LOS HEADERS NO CORRESPONDEN")
        noHeaders=True
    if noHeaders==False:
        casos=casos[[cp,descp,tester,status,testDate]].to_dict("records")
        for caso in casos:
            if not pd.isna(caso[cp]): #and (caso[status]=="OK" or caso[status]=="PENDIENTE"):
                #print(caso)
                context={
                "cpNumber":caso[cp],
                "cpDesc":caso[descp],
                "tester":caso[tester],
                "date":caso[testDate].strftime("%d/%m/%Y"),
                    }
                file_name=f"EPC - SRI_2022-{codeReq}-{caso['IDENTIFICADOR CP']}"
                doc.render(context)
                doc.save(f"{folderEpc}/{file_name}.docx")
        print(f"ARCHIVO GENERADO: {file_name}")
folderApp=r"C:\Users\LENOVO\Desktop\Proyectos de Daniel\wordTemplates"
codigoReq="2060"
#make_files(folderApp,codigoReq)