Feature: Visualizar la deuda total de la tarjeta desde los aplicativos internos del banco

    In order to Visualizar el monto de deuda total de la tarjeta.
    As a Funcionario de Banco.
    I want que cuando consulte la deuda total de la tarjeta en aplicaciones internas del banco su informacion sea VALIDO.

    Scenario: Cliente con bloqueo temporal a nivel de cuenta con consumos revolventes en moneda soles

        Given que la tarjeta presenta deuda en el aplicativo SPU y presenta deuda en el aplicativo NSAT.
        When  tiene bloqueo temporal a nivel de cuenta 
        And   tiene movimientos de consumos revolventes en moneda soles.
        Then  si la resta de los montos de la deuda total extraidos en SPU y NSAT es menor o igual a 12 y mayor o igual a cero, el mensaje de respuesta final a mostrar es "VALIDO".

    Scenario: Cliente con bloqueo temporal a nivel de cuenta con consumos revolventes y consumos en cuotas en moneda soles y consumos en cuotas en moneda dolares

        Given que la tarjeta presenta deuda en el aplicativo SPU y presenta deuda en el aplicativo NSAT.
        When  presenta bloqueo temporal a nivel de cuenta.
        And   tiene movimientos de consumos revolventes en moneda soles
        And   tiene movimientos de consumos en cuotas en moneda soles y en moneda dolares
        Then  si la resta de los montos de la deuda total extraidos en SPU y NSAT en soles es menor o igual a 12 y mayor o igual a cero
        And   si la resta de los montos de la deuda total extraidos en SPU y NSAT en dolares es igual a cero, el mensaje de respuesta final a mostrar es "VALIDO"
        
    Scenario: Cliente con bloqueo temporal a nivel de cuenta con consumos revolventes en moneda soles y consumos revolvente en moneda dolares y consumos en cuotas en moneda soles 

        Given que la tarjeta presenta deuda en el aplicativo SPU y presenta deuda en el aplicativo NSAT.
        When  presenta bloqueo temporal a nivel de cuenta.
        And   tiene movimientos de consumos revolventes en moneda soles y en moneda dolares
        And   tiene movimientos de consumos en cuotas en moneda soles
        Then  si la resta de los montos de la deuda total extraidos en SPU y NSAT en soles es menor o igual a 12 y mayor o igual a cero
        And   si la resta de los montos de la deuda total extraidos en SPU y NSAT en dolares es igual a cero, el mensaje de respuesta final a mostrar es "VALIDO"

    Scenario: Cliente con bloqueo temporal a nivel de tarjeta con consumos revolventes en moneda soles

        Given que la tarjeta presenta deuda en el aplicativo SPU y presenta deuda en el aplicativo NSAT.
        When  presenta bloqueo temporal a nivel de tarjeta.
        And   tiene movimientos de consumos revolventes en moneda soles
        Then  si la resta de los montos de la deuda total extraidos en SPU y NSAT en soles es menor o igual a 12 y mayor o igual a cero, el mensaje de respuesta final a mostrar es "VALIDO"
        
    
    Scenario: Cliente con bloqueo temporal a nivel de tarjeta con consumos revolventes y consumos en cuotas en moneda dolares

        Given que la tarjeta presenta deuda en el aplicativo SPU y presenta deuda en el aplicativo NSAT.
        When  presenta bloqueo temporal a nivel de tarjeta.
        And   tiene movimientos de consumos revolventes en moneda dolares
        And   tiene movimientos de consumos en cuotas en moneda dolares 
        Then  si la resta de los montos de la deuda total extraidos en SPU y NSAT en dolares es igual a cero, el mensaje de respuesta final a mostrar es "VALIDO"
        

    Scenario: Cliente de producto tradicional con consumos revolventes en moneda soles y moneda dolares

        Given que la tarjeta presenta deuda en el aplicativo SPU y presenta deuda en el aplicativo NSAT
        When  es cliente de producto tradicional.
        And   tiene movimientos de consumos revolventes en moneda soles y en moneda dolares
        Then  si la resta de los montos de la deuda total extraidos en SPU y NSAT en soles es menor o igual a 12 y mayor o igual a cero
        And   si la resta de los montos de la deuda total extraidos en SPU y NSAT en dolares es igual a cero, el mensaje de respuesta final a mostrar es "VALIDO"


    Scenario: Cliente de producto tradicional con consumos revolventes en dolares

        Given que la tarjeta presenta deuda en el aplicativo SPU y presenta deuda en el aplicativo NSAT
        When  es cliente de producto tradicional
        And   tiene movimientos de consumos revolventes en moneda dolares.
        Then  si la resta de los montos de la deuda total extraidos en SPU y NSAT en dolares es igual a cero, el mensaje de respuesta final a mostrar es "VALIDO"
        

    Scenario: Cliente de producto tradicional con consumos revolventes en soles

        Given que la tarjeta presenta deuda en el aplicativo SPU y presenta deuda en el aplicativo NSAT
        When  es cliente de producto tracional.
        And   tiene movimientos de consumos revolventes en soles
        Then  si la resta de los montos de la deuda total extraidos en SPU y NSAT en soles es menor o igual a 12 y mayor o igual a cero, el mensaje de respuesta final a mostrar es "VALIDO"


    Scenario: Cliente de producto tradicional con consumos revolventes en moneda soles y dolares y consumos en cuotas en soles y dolares

        Given que la tarjeta presenta deuda en el aplicativo SPU y presenta deuda en el aplicativo NSAT
        When  es cliente de producto tradicional.
        And   tiene movimientos de consumos revolventes en moneda soles y en moneda dolares
        And   tiene movimientos de consumos en cuotas en moneda soles y dolares
        Then  si la resta de los montos de la deuda total extraidos en SPU y NSAT en soles es menor o igual a 12 y mayor o igual a cero
        And   si la resta de los montos de la deuda total extraidos en SPU y NSAT en dolares es igual a cero, el mensaje de respuesta final a mostrar es "VALIDO"
        

    Scenario: Cliente de producto no tradicional con consumos revolventes en soles

        Given que la tarjeta presenta deuda en el aplicativo SPU y presenta deuda en el aplicativo NSAT
        When  es cliente de producto no tradicional
        And   tiene movimientos de consumos revolventes en moneda soles
        Then  si la resta de los montos de la deuda total extraidos en SPU y NSAT en soles es menor o igual a 12 y mayor o igual a cero, el mensaje de respuesta final a mostrar es "VALIDO"


    Scenario: Cliente de producto no tradicional con consumos revolventes en moneda soles y consumos en cuotas en moneda soles

        Given que la tarjeta presenta deuda en el aplicativo SPU y presenta deuda en el aplicativo NSAT
        When  es cliente de producto no tradicional
        And   tiene movimientos de consumos revolventes en moneda soles
        And   tiene movimientos de consumos en cuotas en moneda soles
        Then  si la resta de los montos de la deuda total extraidos en SPU y NSAT en soles es menor o igual a 12 y mayor o igual a cero, el mensaje de respuesta final a mostrar es "VALIDO"  


Scenario: Cliente de producto no tradicional sin deuda

        Given que la tarjeta no presenta deuda en el aplicativo SPU y no presenta deuda en el aplicativo NSAT
        When  es cliente de producto no tradicional
        And   no tiene movimientos de consumos revolventes en moneda soles
        And   no tiene movimientos de consumos en cuotas en moneda soles
        Then  si la resta de los montos de la deuda total extraidos en SPU y NSAT en soles es menor o igual a 12 y mayor o igual a cero, el mensaje de respuesta final a mostrar es "VALIDO"  
        

Scenario: Cliente de producto tradicional sin deuda

        Given que la tarjeta no presenta deuda en el aplicativo SPU y no presenta deuda en el aplicativo NSAT
        When  es cliente de producto tradicional.
        And   no tiene movimientos de consumos revolventes en moneda soles y en moneda dolares
        And   no tiene movimientos de consumos en cuotas en moneda soles y dolares
        Then  si la resta de los montos de la deuda total extraidos en SPU y NSAT en soles es menor o igual a 12 y mayor o igual a cero
        And   si la resta de los montos de la deuda total extraidos en SPU y NSAT en dolares es igual a cero, el mensaje de respuesta final a mostrar es "VALIDO"