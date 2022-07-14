Sobre las librerias:

	-Se usa tkinter y customtkinter para la interfaz (el customtkinter es para aspecto moderno)
	-Docx,DocxComposer,Docxtpl para trabajar con los archivos word.
	-Pandas para leer el archivo excel
	-PIL para leer imagenes

Sobre los modulos propios: 
	-composer.py : para juntar los word que estan en la carpeta 'Archivos Ouput'
	-makefiles.py : para llenar generar los word en base a la matriz de casos de prueba y la plantilla ubicada en 'Archivos Plantilla'
	-docximage.py : para agregar imagenes al word que tiene todos los casos de prueba juntos.
	-apptest.py : el modulo principal donde se construye la interfaz y se llama  los modulos.

Sobre los archivos Plantilla:
	-EPC_indexTemplate.docx : donde esta la primera pagina con la caratula del word
	-EPC_template.docx: El cuadro que se usa para rellenar con cada uno de los casos de prueba
	-HeadersMatrix.txt: makefiles.py extrae cinco cabeceras de la matriz de casos de prueba que se pueden modificar en este archivo.

Sobre el ejecutable :

	Se usa el auto-py-to-exe:
	Se agrega el MP.ico para el icono del ejecutable
	Nota: El pyinstaller no logra leer archivos json por lo que es necesario agregar manualmente las librerias de customtkinter y docxcompose

