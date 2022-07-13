Feature: Consultar transacción en CISC - Connex

  Scenario: Como Analista QA deseo consultar el estado de una transacción con el número PAN
    Given el analista QA se autentica en CONNEX
    When ingrea al área de FTI
    Then busca la transacción con el número de tarjeta entre las fechas y se valida el valor esperado