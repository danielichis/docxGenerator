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
      | ID_Caso | PAN              | codigo_unico |
      | CP001   | 4110905057032053 | 60144661     |
      | CP002   | 4110930657026909 | 60111748     |
      | CP003   | 377754998064635  | 60018375     |
      | CP004   | 4913370797050718 | 60418066     |
      | CP005   | 4110930657022072 | 60460931     |
      | CP006   | 5443599980074715 | 60460931     |
      | CP007   | 5443599980076843 | 60478713     |
      | CP008   | 5491619980078135 | 60384520     |

  @PagoMinimoSolesNoTrad
  Esquema del escenario: Usuario realiza un pago minimo en soles para un producto no tradicional "<ID_Caso>"
    Dado que realizo la consulta del "<PAN>" y el "<codigo_unico>"
    Y que el dia de hoy es la fecha de pago
    Y obtengo detalles de los montos a pagar
    Cuando realizo el abono correspondiente en "pago_minimo_soles"
    Entonces reviso los movimientos del contrato.
    Ejemplos:
      | ID_Caso | PAN             | codigo_unico |
      | CP002   | 4110930657026909 | 60111748     |

  @PagoMinimoDolares
  Esquema del escenario: Usuario realiza un pago minimo en dolares para un producto tradicional "<ID_Caso>"
    Dado que realizo la consulta del "<PAN>" y el "<codigo_unico>"
    Y que el dia de hoy es la fecha de pago
    Y obtengo detalles de los montos a pagar
    Cuando realizo el abono correspondiente en "pago_minimo_dolares"
    Entonces reviso los movimientos del contrato.
    Ejemplos:
      | ID_Caso | PAN             | codigo_unico |
      | CP003   | 377754998064635 | 60018375     |

  @PagoFullSolesTrad
  Esquema del escenario: Usuario realiza un pago full en soles para un producto tradicional "<ID_Caso>"
    Dado que realizo la consulta del "<PAN>" y el "<codigo_unico>"
    Y que el dia de hoy es la fecha de pago
    Y obtengo detalles de los montos a pagar
    Cuando realizo el abono correspondiente en "pago_full_soles"
    Entonces reviso los movimientos del contrato.
    Ejemplos:
      | ID_Caso | PAN             | codigo_unico |
      | CP004   | 4913370797050718 | 60418066     |

  @PagoFullSolesNoTrad
  Esquema del escenario: Usuario realiza un pago minimo en soles para un producto no tradicional "<ID_Caso>"
    Dado que realizo la consulta del "<PAN>" y el "<codigo_unico>"
    Y que el dia de hoy es la fecha de pago
    Y obtengo detalles de los montos a pagar
    Cuando realizo el abono correspondiente en "pago_full_soles"
    Entonces reviso los movimientos del contrato.
    Ejemplos:
      | ID_Caso | PAN             | codigo_unico |
      | CP005   | 4110930657026685 | 60415464     |

  @PagoFullDolarTrad
  Esquema del escenario: Usuario realiza un pago minimo en dolares para un producto tradicional "<ID_Caso>"
    Dado que realizo la consulta del "<PAN>" y el "<codigo_unico>"
    Y que el dia de hoy es la fecha de pago
    Y obtengo detalles de los montos a pagar
    Cuando realizo el abono correspondiente en "pago_full_dolares"
    Entonces reviso los movimientos del contrato.
    Ejemplos:
      | ID_Caso | PAN             | codigo_unico |
      | CP006   | 377753998066160 | 60425189     |

  @PagoMenorMinSolesTrad
  Esquema del escenario: Usuario realiza un pago menor al minimo en soles para un producto tradicional "<ID_Caso>"
    Dado que realizo la consulta del "<PAN>" y el "<codigo_unico>"
    Y que el dia de hoy es la fecha de pago
    Y obtengo detalles de los montos a pagar
    Cuando realizo el abono correspondiente en "pago_menor_minimo_soles"
    Entonces reviso los movimientos del contrato.
    Ejemplos:
      | ID_Caso | PAN             | codigo_unico |
      | CP007   | 4110919057030736 | 60409450     |


  @PagoMenorMinSolesNoTrad
  Esquema del escenario: Usuario realiza un pago menor al minimo en soles para un producto no tradicional "<ID_Caso>"
    Dado que realizo la consulta del "<PAN>" y el "<codigo_unico>"
    Y que el dia de hoy es la fecha de pago
    Y obtengo detalles de los montos a pagar
    Cuando realizo el abono correspondiente en "<pago_menor_minimo_soles>"
    Entonces reviso los movimientos del contrato.
    Ejemplos:
      | ID_Caso | PAN             | codigo_unico |
      | CP008   | 4110930657022072 | 60460931     |

  @PagoMenorMinDolar
  Esquema del escenario: Usuario realiza un pago menor al minimo en dolar para un producto tradicional "<ID_Caso>"
    Dado que realizo la consulta del "<PAN>" y el "<codigo_unico>"
    Y que el dia de hoy es la fecha de pago
    Y obtengo detalles de los montos a pagar
    Cuando realizo el abono correspondiente en "pago_menor_minimo_dolares"
    Entonces reviso los movimientos del contrato.
    Ejemplos:
      | ID_Caso | PAN             | codigo_unico |
      | CP009   | 377753006170517 | 60418403     |

  @PagoMayorFullSolesTrad
  Esquema del escenario: Usuario realiza un pago mayor al full en soles para un producto tradicional "<ID_Caso>"
    Dado que realizo la consulta del "<PAN>" y el "<codigo_unico>"
    Y que el dia de hoy es la fecha de pago
    Y obtengo detalles de los montos a pagar
    Cuando realizo el abono correspondiente en "pago_mayor_full_soles"
    Entonces reviso los movimientos del contrato.
    Ejemplos:
      | ID_Caso | PAN             | codigo_unico |
      | CP010   | 377753006170525 | 60381447     |

  @PagoMayorFullSolesNoTrad
  Esquema del escenario: Usuario realiza un pago menor al minimo en soles para un producto no tradicional "<ID_Caso>"
    Dado que realizo la consulta del "<PAN>" y el "<codigo_unico>"
    Y que el dia de hoy es la fecha de pago
    Y obtengo detalles de los montos a pagar
    Cuando realizo el abono correspondiente en "pago_mayor_full_soles"
    Entonces reviso los movimientos del contrato.
    Ejemplos:
      | ID_Caso | PAN             | codigo_unico |
      | CP011   | 4110930657021850 | 60268567     |

  @PagoMayorFullDolar
  Esquema del escenario: Usuario realiza un pago mayor al full en dolares para un producto tradicional "<ID_Caso>"
    Dado que realizo la consulta del "<PAN>" y el "<codigo_unico>"
    Y que el dia de hoy es la fecha de pago
    Y obtengo detalles de los montos a pagar
    Cuando realizo el abono correspondiente en "pago_mmayor_full_dolares"
    Entonces reviso los movimientos del contrato.
    Ejemplos:
      | ID_Caso | PAN             | codigo_unico |
      | CP012   | 377752998085402 | 60418264     |

  @PagoEntreMinFullSolesTrad
  Esquema del escenario: Usuario realiza un pago mayor al minimo y menor al full en soles para un producto tradicional "<ID_Caso>"
    Dado que realizo la consulta del "<PAN>" y el "<codigo_unico>"
    Y que el dia de hoy es la fecha de pago
    Y obtengo detalles de los montos a pagar
    Cuando realizo el abono correspondiente en "pago_entre_minimo_full_soles"
    Entonces reviso los movimientos del contrato.
    Ejemplos:
      | ID_Caso | PAN             | codigo_unico |
      | CP013   | 5444029980102679 | 60410110     |

  @PagoEntreMinFullSolesNoTrad
  Esquema del escenario: Usuario realiza un pago mayor al minimo y menor al full en soles para un producto no tradicional "<ID_Caso>"
    Dado que realizo la consulta del "<PAN>" y el "<codigo_unico>"
    Y que el dia de hoy es la fecha de pago
    Y obtengo detalles de los montos a pagar
    Cuando realizo el abono correspondiente en "pago_entre_minimo_full_soles"
    Entonces reviso los movimientos del contrato.
    Ejemplos:
      | ID_Caso | PAN             | codigo_unico |
      | CP014   | 4110930657011810 | 60543361    |

  @PagoEntreMinFullDolar
  Esquema del escenario: Usuario realiza un pago mayor al minimo y menor al full en dolares para un producto tradicional "<ID_Caso>"
    Dado que realizo la consulta del "<PAN>" y el "<codigo_unico>"
    Y que el dia de hoy es la fecha de pago
    Y obtengo detalles de los montos a pagar
    Cuando realizo el abono correspondiente en "pago_entre_minimo_full_dolares"
    Entonces reviso los movimientos del contrato.
    Ejemplos:
      | ID_Caso | PAN             | codigo_unico |
      | CP015   | 4913370797050726 | 60407956    |

  @PagoMinSolesFullDolar
  Esquema del escenario: Usuario realiza un pago mminimo en soles y full en dolares para un producto tradicional "<ID_Caso>"
    Dado que realizo la consulta del "<PAN>" y el "<codigo_unico>"
    Y que el dia de hoy es la fecha de pago
    Y obtengo detalles de los montos a pagar
    Cuando realizo el abono correspondiente en "pago_minimo_soles" y "pago_full_dolares"
    Entonces reviso los movimientos del contrato.
    Ejemplos:
      | ID_Caso | PAN              | codigo_unico |
      | CP016   | 377753998066160 | 60425189     |

  @PagoMinDolarFullSoles
  Esquema del escenario: Usuario realiza un pago mminimo en dolares y full en soles para un producto tradicional "<ID_Caso>"
    Dado que realizo la consulta del "<PAN>" y el "<codigo_unico>"
    Y que el dia de hoy es la fecha de pago
    Y obtengo detalles de los montos a pagar
    Cuando realizo el abono correspondiente en "pago_minimo_dolares" y "pago_full_soles"
    Entonces reviso los movimientos del contrato.
    Ejemplos:
      | ID_Caso | PAN              | codigo_unico |
      | CP017   | 377753998066160 | 60425189     |
