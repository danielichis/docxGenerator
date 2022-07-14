from PIL import Image
from os.path import isfile, join
import os
pics_folder=r"C:\Users\LENOVO\Desktop\Proyectos de Daniel\wordTemplates\Archivos Input"
files_list = [f for f in os.listdir(pics_folder) if isfile(join(pics_folder, f))]
for file in files_list:
    filename = os.fsdecode(file)
    #print(filename)
    im = Image.open(pics_folder+"/"+filename)
    #large=im.size[0]
    print("TAMAÑO EN PIXELES")
    print(im.size[0],im.size[1])
    