#language: es
Característica: Creacion Usuario
  Como un usuario
  Quiero crear usuarios en CICS


  Antecedentes:
    Dado que accedo a Access en mainframe

  @operacionesAco
  Esquema del escenario: operaciones Aco  <ID_Caso>
    Dado que ingreso las credenciales e inicio sesion en Access
    Y accedo a la aplicacion "<aplicacionACCESS>" dentro de Access
    E ingreso las credenciales e inicio sesion en CICS
    E ingreso a la aplicacion "<aplicacionCICS>" dentro de CICS
    E ingreso a la aplicacion "<aplicacionACO>" dentro del  SISTEMA ADMINISTRADOR DE CONTROVERSIAS
    Y realizo la consulta de la tarjeta "<numeroTARJETA>"
    Y realizo la controversia de la transaccion "<numeroTRANSACCION>"  con monto "<monto>"
    E ingreso el codigo reclamo "<codReclamo>" con codigo transaccion "<codTransaccion>", codigo razon "<codRazon>", ind.Doc "<indDoc>", rz.msg frau "<codFrau>"., y msj. texto "<mensaje>"
    Entonces valido la alta de la controversia
    Ejemplos:
      | ID_Caso | aplicacionACCESS | aplicacionCICS | aplicacionACO                   | numeroTARJETA    | numeroTRANSACCION | monto  | codReclamo | codTransaccion | codRazon |indDoc| codFrau | mensaje      |
     #   | CP001   | CICSAA2K         | ACO            | TRANSACCIONES PROCESADAS EMISOR | 377753072209520  | 564439             | 233.00 | 0000000006 | 215            | 4540     || 999     | controversia |
     #  | CP002  | CICSAA2K         | ACO            | TRANSACCIONES PROCESADAS EMISOR | 377753072209520  | 713590            | 200.00 | 0000000006 | 215            | 4540     || 999     | controversia |
     | CP003  | CICSAA2K         | ACO            | TRANSACCIONES PROCESADAS EMISOR | 377754498059911 |        030779           | 46.00  | 0000000006 | 215            | 4540     || 999     | controversia |
