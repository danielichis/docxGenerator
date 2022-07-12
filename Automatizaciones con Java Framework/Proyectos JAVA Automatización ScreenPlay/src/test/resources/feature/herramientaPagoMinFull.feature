#language: es
Característica: Realizar operaciones de pago Min-Full
  Como un analista del banco
  Quiero realizar operaciones de abonos junto a la consulta que confirme el abono


  @PagoMinimoSolesTrad
  Esquema del escenario: Usuario realiza un pago minimo en soles para un producto tradicional "<ID_Caso>"
    Dado que realizo la consulta del "<PAN>" y el "<codigo_unico>"
    Y que el dia de hoy es la fecha de pago
    Y obtengo detalles de los montos a pagar
    Cuando realizo el abono correspondiente en "pago_minimo_soles"
    Entonces reviso los movimientos del contrato.
    Ejemplos:
      | ID_Caso | PAN              | codigo_unico | GL |
      | CP001   | 4110905057032053 | 60144661     | 13 |
      | CP002   | 4110930657026909 | 60111748     | 13 |
      | CP003   | 377754998064635  | 60018375     | 16 |
      | CP004   | 4913370797050718 | 60418066     | 16 |
      | CP005   | 4110930657022072 | 60460931     | 13 |
      | CP006   | 5443599980074715 | 60460931     | 13 |
      | CP007   | 5443599980076843 | 60478713     | 14 |
      | CP008   | 5491619980078135 | 60384520     | 1  |
      | CP009   | 377754798071616  | 60424161     | 16 |
      | CP010   | 377753006157852  | 60409168     | 17 |
      | CP011   | 5443599980076843 | 60478713     | 14 |
      | CP012   | 377750998000967  | 60478751     | 15 |

  @PagoMinimoDolares
  Esquema del escenario: Usuario realiza un pago minimo en dolares para un producto tradicional "<ID_Caso>"
    Dado que realizo la consulta del "<PAN>" y el "<codigo_unico>"
    Y que el dia de hoy es la fecha de pago
    Y obtengo detalles de los montos a pagar
    Cuando realizo el abono correspondiente en "pago_minimo_dolares"
    Entonces reviso los movimientos del contrato.
    Ejemplos:
      | ID_Caso | PAN              | codigo_unico | GL |
      | CP003   | 377754998064635  | 60018375     | 16 |
      | CP003   | 4772890057023741 | 60155674     | 15 |
      | CP003   | 5443599980076843 | 60478713     | 14 |


  @PagoFullSolesTrad
  Esquema del escenario: Usuario realiza un pago full en soles para un producto tradicional "<ID_Caso>"
    Dado que realizo la consulta del "<PAN>" y el "<codigo_unico>"
    Y que el dia de hoy es la fecha de pago
    Y obtengo detalles de los montos a pagar
    Cuando realizo el abono correspondiente en "pago_full_soles"
    Entonces reviso los movimientos del contrato.
    Ejemplos:
      | ID_Caso | PAN              | codigo_unico | GL  |
      | CP004   | 4913370797050718 | 60418066     | 16  |
      | CP004   | 377753006169964 | 60575571     | 15  |
      | CP004   | 4110930657011810 | 34345061     | 14  |


  @PagoFullDolarTrad
  Esquema del escenario: Usuario realiza un pago minimo en dolares para un producto tradicional "<ID_Caso>"
    Dado que realizo la consulta del "<PAN>" y el "<codigo_unico>"
    Y que el dia de hoy es la fecha de pago
    Y obtengo detalles de los montos a pagar
    Cuando realizo el abono correspondiente en "pago_full_dolares"
    Entonces reviso los movimientos del contrato.
    Ejemplos:
      | ID_Caso | PAN              | codigo_unico | GL  |
      | CP006   | 377753998066160  | 60425189     | 16  |
      | CP003   | 4772890057023741 | 60155674     | 15  |
      | CP004   | 4110919057024259 | 60157781     | 14  |

  @PagoMenorMinSolesTrad
  Esquema del escenario: Usuario realiza un pago menor al minimo en soles para un producto tradicional "<ID_Caso>"
    Dado que realizo la consulta del "<PAN>" y el "<codigo_unico>"
    Y que el dia de hoy es la fecha de pago
    Y obtengo detalles de los montos a pagar
    Cuando realizo el abono correspondiente en "pago_menor_minimo_soles"
    Entonces reviso los movimientos del contrato.
    Ejemplos:
      | ID_Caso | PAN              | codigo_unico | GL  |
      | CP007   | 4110919057030736 | 60409450     | 16  |
      | CP004   | 4110905057039108 | 60592645     | 15  |
      | CP004   | 4110905057040205 | 60591668     | 14  |


  @PagoMenorMinDolar
  Esquema del escenario: Usuario realiza un pago menor al minimo en dolar para un producto tradicional "<ID_Caso>"
    Dado que realizo la consulta del "<PAN>" y el "<codigo_unico>"
    Y que el dia de hoy es la fecha de pago
    Y obtengo detalles de los montos a pagar
    Cuando realizo el abono correspondiente en "pago_menor_minimo_dolares"
    Entonces reviso los movimientos del contrato.
    Ejemplos:
      | ID_Caso | PAN             | codigo_unico | GL |
      | CP009   | 377753006170517 | 60418403     | 16 |
      | CP009   | 4732444557018709  | 60493621   | 15 |
      | CP004   | 377754798087059 | 60484557     | 14  |

  @PagoMayorFullSolesTrad
  Esquema del escenario: Usuario realiza un pago mayor al full en soles para un producto tradicional "<ID_Caso>"
    Dado que realizo la consulta del "<PAN>" y el "<codigo_unico>"
    Y que el dia de hoy es la fecha de pago
    Y obtengo detalles de los montos a pagar
    Cuando realizo el abono correspondiente en "pago_mayor_full_soles"
    Entonces reviso los movimientos del contrato.
    Ejemplos:
      | ID_Caso | PAN             | codigo_unico | GL |
      | CP010   | 377753006170525 | 60381447     | 16 |
      | CP010   | 4110905057035023  |60587769    | 15  |
      | CP004   | 4110905057040239 | 60592637     | 14  |

  @PagoMayorFullDolar
  Esquema del escenario: Usuario realiza un pago mayor al full en dolares para un producto tradicional "<ID_Caso>"
    Dado que realizo la consulta del "<PAN>" y el "<codigo_unico>"
    Y que el dia de hoy es la fecha de pago
    Y obtengo detalles de los montos a pagar
    Cuando realizo el abono correspondiente en "pago_mmayor_full_dolares"
    Entonces reviso los movimientos del contrato.
    Ejemplos:
      | ID_Caso | PAN             | codigo_unico | GL |
      | CP012   | 377752998085402 | 60418264     | 16 |
      | CP012   | 377754798074156 | 60478054     | 15 |
      | CP004   | 4110905057035064 | 60588895     | 14  |


  @PagoEntreMinFullSolesTrad
  Esquema del escenario: Usuario realiza un pago mayor al minimo y menor al full en soles para un producto tradicional "<ID_Caso>"
    Dado que realizo la consulta del "<PAN>" y el "<codigo_unico>"
    Y que el dia de hoy es la fecha de pago
    Y obtengo detalles de los montos a pagar
    Cuando realizo el abono correspondiente en "pago_entre_minimo_full_soles"
    Entonces reviso los movimientos del contrato.
    Ejemplos:
      | ID_Caso | PAN             | codigo_unico | GL |
      | CP013   | 5444029980102679 | 60410110     | 16  |


  @PagoEntreMinFullDolar
  Esquema del escenario: Usuario realiza un pago mayor al minimo y menor al full en dolares para un producto tradicional "<ID_Caso>"
    Dado que realizo la consulta del "<PAN>" y el "<codigo_unico>"
    Y que el dia de hoy es la fecha de pago
    Y obtengo detalles de los montos a pagar
    Cuando realizo el abono correspondiente en "pago_entre_minimo_full_dolares"
    Entonces reviso los movimientos del contrato.
    Ejemplos:
      | ID_Caso | PAN             | codigo_unico | GL |
      | CP015   | 4913370797050726 | 60407956    | 16 |

