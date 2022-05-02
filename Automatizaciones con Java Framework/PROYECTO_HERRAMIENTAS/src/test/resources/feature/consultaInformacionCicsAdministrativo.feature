#language: es
Característica:  Realizar operaciones en Cics Administrativo
  Como un usuario
  Quiero realizar operaciones en CICS Administrativo


  Antecedentes:
    Dado que accedo a Access en mainframe

  @consultarTARJETA
  Esquema del escenario: creacion de Clientes por Systematics  <ID_Caso>
    Dado que ingreso las credenciales e inicio sesion en Access
    Y accedo a la aplicacion "<aplicacionACCESS>" dentro de Access
    E ingreso las credenciales e inicio sesion en CICS
    E ingreso a la aplicacion "<aplicacionCICS>" dentro de CICS
    Entonces realizo la consulta de la tarjeta "<tarjeta>" en Systematics
    Ejemplos:
      | ID_Caso | aplicacionACCESS | aplicacionCICS | tarjeta          |
#      | CP002 | CICSAA2K         | TRJ            | 4547760007116347 |
      | CP001   | CICSAA2K         | TRJ            |4110740057213290                     |



  @consultarCliente
  Esquema del escenario: creacion de Clientes por Systematics  <ID_Caso>
    Dado que ingreso las credenciales e inicio sesion en Access
    Y accedo a la aplicacion "<aplicacionACCESS>" dentro de Access
    E ingreso las credenciales e inicio sesion en CICS
    E ingreso a la aplicacion "<aplicacionCICS>" dentro de CICS
    Y realizo la consulta del tipo documento "<tipoDoc>" con numero "<nroDocumento>" en Systematics
    Y realizo la consulta con el comando "RMI1"
    Y realizo la consulta con el comando "RMI2"
    Y realizo la consulta con el comando "RMC1"
    Y realizo la consulta con el comando "RMC2"
    Y realizo la consulta con el comando "RMC3"
    Y realizo la consulta con el comando "RMC4"
    Y realizo la consulta con el comando "RMMB"
    Y realizo la consulta con el comando "RMAB"
    Y realizo la consulta con el comando "ST21"
    Y realizo la consulta con el comando "RMLT"
    Ejemplos:
      | ID_Caso | aplicacionACCESS | aplicacionCICS | tipoDoc | nroDocumento |
      | CP001   | CICSAA2K         | SYS            | CU     | 60457428    |

  @consultarMovimientos
  Esquema del escenario: consultar Movimientos TD  <ID_Caso>
    Dado que ingreso las credenciales e inicio sesion en Access
    Y accedo a la aplicacion "<aplicacionACCESS>" dentro de Access
    E ingreso las credenciales e inicio sesion en CICS
    E ingreso a la aplicacion "<aplicacionCICS>" dentro de CICS
    Y realizo la consulta del tipo documento "<tipoDoc>" con numero "<nroDocumento>" en Systematics
    Y realizo la consulta de la cuenta "<ncuenta>" en RMAB
    Y consulto STI o IMI "2" para las transacciones asociadas al Caso de Prueba "<ID_Caso>"
      | monto | fechaTransaccion | caso  |
      | 51.00  | 26/04/22         | CP001 |
      | 2.50 | 19/04/22            | CP002 |
    Y consulto STI o IMI "3" para las transacciones asociadas al Caso de Prueba "<ID_Caso>"
      | monto | fechaTransaccion | caso  |
      | 20.50 | 01/04/22         | CP001 |
      | 4     | 01/03            | CP002 |
    Y consulto STI o IMI "4" para las transacciones asociadas al Caso de Prueba "<ID_Caso>"
      | monto | fechaTransaccion |
      | None  | None             |
    Y consulto STI o IMI "5" para las transacciones asociadas al Caso de Prueba "<ID_Caso>"
      | monto | fechaTransaccion | caso |
      | 50.00  | 26/04/22         | CP001 |
        | 38.02 | 19/04/22         | CP002 |
      Ejemplos:
      | ID_Caso | aplicacionACCESS | aplicacionCICS | tipoDoc | nroDocumento | ncuenta        |
     #  | CP001   | CICSAA2K         | sys            | CU      | 60455822     | 00007005214281 |
      | CP001   | CICSAA2K         | sys            | CU      | 60455514  | 7003659597 |









