#language: es
Característica:  Realizar operaciones en Cics Administrativo
  Como un usuario
  Quiero realizar operaciones en CICS Administrativo


  Antecedentes:
    Dado que accedo a Access en mainframe

  @creacionCuentaIMSTparaClientes
  Esquema del escenario: creacion de Clientes por Systematics  <ID_Caso>
    Dado que ingreso las credenciales e inicio sesion en Access
    Y accedo a la aplicacion "<aplicacionACCESS>" dentro de Access
    E ingreso las credenciales e inicio sesion en CICS
    E ingreso a la aplicacion "<aplicacionCICS>" dentro de CICS
    Y realizo la creación de "<numeroCuentas>" cuentas de tipo "<tipoCuenta>" para el documento "<nroDocumento>"
    E ingreso el codigo identidad "<CTL1>", tipo moneda "<CTL2>", la oficina "<CTL3>", tipo producto "<CTL4>"
    Y ingreso el tipo COD CONECCION "<conConeccion>", TIPO DE PROD "<tipoProd>"
    Y realizo la consulta con el comando "RMAB"
    Ejemplos:
      | ID_Caso | aplicacionACCESS | aplicacionCICS | numeroCuentas | tipoCuenta | nroDocumento | CTL1 | CTL2 | CTL3 | CTL4 | conConeccion | tipoProd |
      | CP002   | CICSAA2K         | SYS            | 1             | ST         | 90608886      | 0003 | 0001 | 0100 | 0002 | IND          | 206      |
      | CP001   | CICSAA2K         | SYS            | 1             | IM         | 90608886      | 0003 | 0001 | 0100 | 0001 | IND          | 101      |


  @creacionClientesSYSTEMATICS
  Esquema del escenario: creacion de Clientes por Systematics  <ID_Caso>
    Dado que ingreso las credenciales e inicio sesion en Access
    Y accedo a la aplicacion "<aplicacionACCESS>" dentro de Access
    E ingreso las credenciales e inicio sesion en CICS
    E ingreso a la aplicacion "<aplicacionCICS>" dentro de CICS
    Entonces realizo la creacion de "<numeroClientesCrear>" clientes con tipo documento "<tipoDocumento>"
    Ejemplos:
      | ID_Caso | aplicacionACCESS | aplicacionCICS | numeroClientesCrear | tipoDocumento |
      | CP001   | CICSAA2K         | SYS            | 1                | DNI           |


  @creacionCampañasASSI_CN
  Esquema del escenario: creacion de campañas con clientes nuevos ASSI  <ID_Caso>
    Dado que ingreso las credenciales e inicio sesion en Access
    Y accedo a la aplicacion "<aplicacionACCESS>" dentro de Access
    E ingreso las credenciales e inicio sesion en CICS
    E ingreso a la aplicacion "<aplicacionCICS>" dentro de CICS
    Y realizo el alta de "<numeroCampanas>" campanas con tipo tarjeta "<tipoTarjeta>" de la marca "<marca>" para clientes nuevos con linea de credito "<lineaCredito>"
    Ejemplos:
      | ID_Caso | aplicacionACCESS | aplicacionCICS | numeroCampanas | tipoTarjeta | marca | lineaCredito |
      | CP001   | CICSAA2K         | SYS            | 1              | INFINITE    | VISA  | 5000         |

  @creacionCampañasASSI_CE
  Esquema del escenario: creacion de campañas con clientes existentes ASSI  <ID_Caso>
    Dado que ingreso las credenciales e inicio sesion en Access
    Y accedo a la aplicacion "<aplicacionACCESS>" dentro de Access
    E ingreso las credenciales e inicio sesion en CICS
    E ingreso a la aplicacion "<aplicacionCICS>" dentro de CICS
    Y realizo el alta de "<numeroCampanas>" campañas con tipo tarjeta "<tipoTarjeta>" de la marca "<marca>" para clientes existentes con inicial dni "<iniciarDNI>" con linea de credito "<lineaCredito>"
    Ejemplos:
      | ID_Caso | aplicacionACCESS | aplicacionCICS | numeroCampanas | tipoTarjeta | marca | lineaCredito | iniciarDNI |
      | CP001   | CICSAA2K         | SYS            | 6              | PLATINUM    | AMEX  | 5000         | 72261958         |
#       | CP001   | CICSAA2K         | SYS            | 2              | BLACK                 | AMEX       | 5000         | 54         |
#       | CP001   | CICSAA2K         | SYS            | 2              | BLUE JOVEN            | AMEX       | 5000         | 45         |
#       | CP001   | CICSAA2K         | SYS            | 2              | INFINITE              | VISA       | 5000         | 544822     |
#       | CP001   | CICSAA2K         | SYS            | 2              | ORO                   | VISA       | 5000         | 7218       |
#       | CP001   | CICSAA2K         | SYS            | 2              | SIGNATURE             | VISA       | 5000         |            |
#       | CP001   | CICSAA2K         | SYS            | 2              | CLASICA INTERNACIONAL | VISA       | 5000         |            |
#       | CP001   | CICSAA2K         | SYS            | 2              | INTERBANK PREMIA      | VISA       | 5000         |            |
#       | CP001   | CICSAA2K         | SYS            | 2              | ORO                   | MASTERCARD | 5000         |            |
#       | CP001   | CICSAA2K         | SYS            | 2              | PLATINUM              | MASTERCARD | 5000         |            |
#       | CP001   | CICSAA2K         | SYS            | 2              | STANDAR               | MASTERCARD | 5000         |            |



  @asignarTarjetaDebitoACliente
  Esquema del escenario: creacion de Clientes por Systematics  <ID_Caso>
    Dado que ingreso las credenciales e inicio sesion en Access
    Y accedo a la aplicacion "<aplicacionACCESS>" dentro de Access
    E ingreso las credenciales e inicio sesion en CICS
    E ingreso a la aplicacion "<aplicacionCICS>" dentro de CICS
    Ejemplos:
      | ID_Caso | aplicacionACCESS | aplicacionCICS | tarjeta          |
      | CP001   | CICSAA2K         | TRJ            | 4110740057040164 |
