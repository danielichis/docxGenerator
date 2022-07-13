from fileinput import filename
from importlib.metadata import files
from docxcompose.composer import Composer
from docx import Document as Document_compose
from os import listdir
from os.path import isfile, join
#folderApp=r"C:\Users\LENOVO\Desktop\Proyectos de Daniel\wordTemplates"
def combine_all_docx(folderApp):
    foldertpl=folderApp+"/"+"Archivos Plantilla"
    folderEpc=folderApp+"/"+"Archivos Ouput"
    index_file=foldertpl+"/"+"EPC_indexTemplate.docx"
    files_list = [f for f in listdir(folderEpc) if isfile(join(folderEpc, f))]
    number_of_sections=len(files_list)
    master = Document_compose(index_file)
    composer = Composer(master)
    for i in range(0, number_of_sections):
        relative_temp=folderEpc+"/"+files_list[i]
        doc_temp = Document_compose(relative_temp)
        composer.append(doc_temp)
        print(files_list[i])
    nameCombined=folderApp+"/"+"CP JUNTO.docx"
    composer.save(nameCombined)
#combine_all_docx(r"C:\Users\LENOVO\Desktop\Proyectos de Daniel\wordTemplates")
