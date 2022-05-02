#language: es
Característica: Realizar operaciones en Cics Financiero
  Como un usuario
  Quiero realizar operaciones en CICS Financiero


  Antecedentes:
    Dado que accedo a Access en mainframe

  @consultarRNCPAN
  Esquema del escenario: consulta RNC <ID_Caso>
    Dado que ingreso las credenciales e inicio sesion en Access
    Y accedo a la aplicacion "<aplicacionACCESS>" dentro de Access
    E ingreso a RNC Simulator
    Entonces realizo la consulta de la tarjeta "<pan>" con fecha vencimiento "<fechaVencimiento>", estructura "<estructura>", tipo lectura "<tipoLectura>", programa "<programa>", sysid "<sysId>", tran "<tran>", lengthCommarea "<lengthCommarea>"
    Ejemplos:
      | ID_Caso | aplicacionACCESS | pan              | fechaVencimiento | estructura | tipoLectura | programa | sysId | tran | lengthCommarea |
      | CP001   | CICSFA2K         | 4547760007116347 | 2704             | 2C1        | 000         | CDSR001  | FA2K  | RNSM | 00000          |
#      | CP002   | CICSFA2K         | 5444029980086906 | 2609             | 2C1        | 000         | CDSR001  | FA2K  | RNSM | 00000          |
#      | CP003   | CICSFA2K         | 377750698004061  | 2509             | 2C1        | 000         | CDSR001  | FA2K  | RNSM | 00000          |
