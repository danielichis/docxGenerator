#language: es
Característica: Realizar operaciones de pago Min-Full
  Como un analista QA/banco
  Quiero realizar operaciones para mantenimiento de data

   #Pagos minimo para los casos de pag Full-Minimo  --> Cristhian
  @MantenimientoMinimoSoles
  Esquema del escenario: El analista desea realizar mantenimiento de contratos en soles "<ID_Caso>"
    Dado que realizo la consulta del "<PAN>" y el "<codigo_unico>"
    Y que el dia de hoy es la fecha de pago
    Y obtengo detalles de los montos a pagar
    Cuando realizo el abono correspondiente en "pago_minimo_soles"
    Entonces reviso los movimientos del contrato.
    Ejemplos:
      | ID_Caso | PAN               | codigo_unico    |
      | CP001   | 4110930616507254  | 60003469        |


  @MantenimientoMinimoDolar
  Esquema del escenario: El analista desea realizar mantenimiento de contratos en dolares "<ID_Caso>"
    Dado que realizo la consulta del "<PAN>" y el "<codigo_unico>"
    Y que el dia de hoy es la fecha de pago
    Y obtengo detalles de los montos a pagar
    Cuando realizo el abono correspondiente en "pago_minimo_dolares"
    Entonces reviso los movimientos del contrato.
    Ejemplos:
      | ID_Caso | PAN               | codigo_unico    |
      | CP001   | 4110930616507254  | 60003469        |

  #Pagos full para los casos de TRX350  --> Carmen
  @MantenimientoFullSoles
  Esquema del escenario: Usuario realiza un pago minimo en soles para un producto no tradicional "<ID_Caso>"
    Dado que realizo la consulta del "<PAN>" y el "<codigo_unico>"
    Y que el dia de hoy es la fecha de pago
    Y obtengo detalles de los montos a pagar
    Cuando realizo el abono correspondiente en "pago_full_soles"
    Entonces reviso los movimientos del contrato.
    Ejemplos:
      | ID_Caso | PAN              | codigo_unico |
      | CP005   | 4110930657026685 | 60415464     |
      | CP008   | 5491619980078135 | 60384520     |

  @MantenimientoFullDolares
  Esquema del escenario: Usuario realiza un pago minimo en dolares para un producto tradicional "<ID_Caso>"
    Dado que realizo la consulta del "<PAN>" y el "<codigo_unico>"
    Y que el dia de hoy es la fecha de pago
    Y obtengo detalles de los montos a pagar
    Cuando realizo el abono correspondiente en "pago_full_dolares"
    Entonces reviso los movimientos del contrato.
    Ejemplos:
      | ID_Caso | PAN             | codigo_unico |
      | CP008   | 5491619980078135 | 60384520     |


 #Pagos full para los casos de morosidad  --> Katty
 @MantenimientoMorosoSoles
 Esquema del escenario: El analista desea realizar mantenimiento de contratos en soles "<ID_Caso>"
   Dado que el dia de hoy es "<dia>"
   Y consulto la deuda del "<PAN>" con "<codigo_unico>"
   Cuando obtengo los montos
   Entonces realizo el abono correspondiente en "pago_full_soles"
   Ejemplos:
     | ID_Caso | PAN               | codigo_unico    | dia       |
     | CP001	|4772890057027023	|60098382	      |VIERNES    |
     | CP002	|4222240057023646 	|60100381	      |LUNES      |
     | CP003	|4913370797054033 	|60099588	      |MARTES     |
     | CP004	|4222240057023661	|60063046	      |MIÉRCOLES  |
     | CP005	|377754998066531	|60479590	      |JUEVES     |


#  @MantenimientoPagoMinimoDolar
#  Esquema del escenario: El analista desea realizar mantenimiento de contratos en dolares "<ID_Caso>"
#    Dado que el dia de hoy es "<dia>"
#    Y consulto la deuda del "<PAN>" con "<codigo_unico>"
#    Cuando obtengo los montos
#    Entonces realizo el <"pago_minimo_dolares">
#    Ejemplos:
#      | ID_Caso | PAN               | codigo_unico    | dia        |

#################################################################################################################
 #Consumos
 @ConsumoMantenimiento
 Esquema del escenario: El analista desea realizar mantenimiento decontratos en soles "<ID_Caso>"
   Dado que el dia de hoy es "<dia>"
   Cuando ingreso la "<PAN>" y el "<monto>" en "<moneda>" al servicio
   Entonces ejecuto el servicio de consumo
   Ejemplos:
     | ID_Caso | dia       | PAN               |  monto    | moneda  |
     | CP001   | VIERNES	| 4772890057027023	| 650	    | soles   |
     | CP002   | LUNES	    | 4222240057023646 	| 750	    | soles   |
     | CP003   | MARTES	| 4913370797054033 	| 560	    | soles   |
     | CP004   | MIÉRCOLES	| 4222240057023661	| 850	    | soles   |
     | CP005   | JUEVES	| 377754998066531	| 780	    | soles   |
     | CP005   | MIÉRCOLES	| 5443599980074715	| 2000	    | soles   |


