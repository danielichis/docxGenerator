#language: es
Característica: Realizar operaciones BPI
  Como un usuario
  Quiero realizar operaciones en el canal BPI


  @ConsultarAfiliacion
  Esquema del escenario: Afiliar numero celular a una cuenta BPI  <ID_Caso>
    Dado que realizo la consulta de afiliacion del "<tipoConsulta>" con el numero "<numero>"
    Entonces obtengo detalles de la respuesta
    Ejemplos:
      | ID_Caso | tipoConsulta   | numero      |
      | CP002   | CODIGO UNICO   |0060543628  |

  @AfiliarCelularBPI
  Esquema del escenario: Afiliar numero celular a una cuenta BPI  <ID_Caso>
    Dado que realizo la consulta de afiliacion del "NUMERO CELULAR" con el numero "<numeroCelular>"
    Y realizo la desafiliacion del codigo unico asociado de requerirse
    Y que realizo la consulta de afiliacion del "CODIGO UNICO" con el numero "<codigoUnico>"
    Y realizo la desafiliacion del codigo unico asociado de requerirse
    Entonces realizo la afiliacion del numero "<numeroCelular>" con operador "<operador>" al siguiente codigo unico "<codigoUnico>"
    Ejemplos:
      | ID_Caso | numeroCelular | operador | codigoUnico |
      | CP002   | 51927493379  | C        | 0060457541 |

  @DesafiliarCelularBPI
  Esquema del escenario: Desafiliar un numero celular de una cuenta BPI  <ID_Caso>
    Dado que realizo la consulta de afiliacion del "<tipoConsulta>" con el numero "<numero>"
    Entonces realizo la desafiliacion del codigo unico asociado de requerirse
    Ejemplos:
      | ID_Caso | tipoConsulta   | numero      |
      | CP001   | NUMERO CELULAR | 51902144434 |
      | CP002   | CODIGO UNICO   | 0060148651  |


