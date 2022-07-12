Feature: PrepagoCuotas
	Realizar el prepago de un producto en cuotas desde el aplicativo Transactor

@mytag
Scenario: Transaccion 350 Prepago de Cuotas 
	Given que el usuario ingresa al aplcativo Transactor
	And inicia sesion digitando su contrasena cms$04
	And seleciona la opcion transaccion 350
	When se ingresa el numero de la tarjeta a prepagar <NUMTARJETA>
	And se selecciona el tipo_de_producto <PRODUCTO>
	And hacer una simulacion de tipo_pago <TIPOPAGO> y numero de cuotas <NUMCUOTA>
	And selecciona medio de cargo <CARGO>, el tipo_moneda <MONEDA> y aceptamos la transacción
	Then se genera el pago correctamente


	Examples: 
	| NUMTARJETA       | PRODUCTO         | TIPOPAGO | NUMCUOTA | CARGO      | MONEDA |
#	| 5443599980074459 | COMPRA EN CUOTAS | PRE-PAGO | 1        | 0 EFECTIVO | SOL    |
#	| 4110905057013087 | COMPRA EN CUOTAS | PRE-PAGO | 1        | 0 EFECTIVO | SOL    |
	| 5443599980093160 | EXTRACASH        | PRE-PAGO | 1        | 0 EFECTIVO | SOL    |
	| 4110905057013087 | COMPRA EN CUOTAS | PRE-PAGO | 1        | 0 EFECTIVO | SOL    |
#	| 4110905057013756 | COMPRA DE DEUDA  | PRE-PAGO | 1        | 0 EFECTIVO | SOL    |