$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/feature/herramientaPagoMinFull.feature");
formatter.feature({
  "name": "Realizar operaciones de pago Min-Full",
  "description": "  Como un analista del banco\n  Quiero realizar operaciones de abonos junto a la consulta que confirme el abono",
  "keyword": "Característica"
});
formatter.scenarioOutline({
  "name": "Usuario realiza un pago minimo en soles para un producto tradicional \"\u003cID_Caso\u003e\"",
  "description": "",
  "keyword": "Esquema del escenario",
  "tags": [
    {
      "name": "@PagoMinimoSolesTrad"
    }
  ]
});
formatter.step({
  "name": "que realizo la consulta del \"\u003cPAN\u003e\" y el \"\u003ccodigo_unico\u003e\"",
  "keyword": "Dado "
});
formatter.step({
  "name": "que el dia de hoy es la fecha de pago",
  "keyword": "Y "
});
formatter.step({
  "name": "obtengo detalles de los montos a pagar",
  "keyword": "Y "
});
formatter.step({
  "name": "realizo el abono correspondiente en \"pago_minimo_soles\"",
  "keyword": "Cuando "
});
formatter.step({
  "name": "reviso los movimientos del contrato.",
  "keyword": "Entonces "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Ejemplos",
  "rows": [
    {
      "cells": [
        "ID_Caso",
        "PAN",
        "codigo_unico"
      ]
    },
    {
      "cells": [
        "CP001",
        "4110905057032053",
        "60144661"
      ]
    },
    {
      "cells": [
        "CP002",
        "4110930657026909",
        "60111748"
      ]
    },
    {
      "cells": [
        "CP003",
        "377754998064635",
        "60018375"
      ]
    },
    {
      "cells": [
        "CP004",
        "4913370797050718",
        "60418066"
      ]
    },
    {
      "cells": [
        "CP005",
        "4110930657022072",
        "60460931"
      ]
    },
    {
      "cells": [
        "CP006",
        "5443599980074715",
        "60460931"
      ]
    },
    {
      "cells": [
        "CP007",
        "5443599980076843",
        "60478713"
      ]
    },
    {
      "cells": [
        "CP008",
        "5491619980078135",
        "60384520"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Usuario realiza un pago minimo en soles para un producto tradicional \"CP001\"",
  "description": "",
  "keyword": "Esquema del escenario",
  "tags": [
    {
      "name": "@PagoMinimoSolesTrad"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "que realizo la consulta del \"4110905057032053\" y el \"60144661\"",
  "keyword": "Dado "
});
formatter.write("Status CODE del servicio: 200");
formatter.write("RESPONSE:");
formatter.write("{\n    \"isflagNSAT\": \"true\",\n    \"customerTypeCode\": \"TI\",\n    \"branch\": \"0987\",\n    \"bin\": \"411090\",\n    \"brandCode\": \"1\",\n    \"typeIndicator\": \"14\",\n    \"isBlock\": \"true\",\n    \"situation\": {\n        \"code\": \"5\",\n        \"description\": \"PODERCLIEN\"\n    },\n    \"account\": {\n        \"contractNumber\": \"000002252868\",\n        \"status\": \"BLOQUEO TEMPORAL\",\n        \"currencyCode\": \"604\",\n        \"isDoubleCurrency\": \"true\"\n    },\n    \"consumptionLine\": {\n        \"processed\": {\n            \"sign\": \"+\",\n            \"amount\": \"1123.99\"\n        },\n        \"authorized\": {\n            \"sign\": \"+\",\n            \"amount\": \"0.00\"\n        }\n    },\n    \"creditLine\": {\n        \"sign\": \"+\",\n        \"amount\": \"50000.00\",\n        \"used\": {\n            \"sign\": \"+\",\n            \"amount\": \"1123.99\"\n        },\n        \"available\": {\n            \"sign\": \"+\",\n            \"amount\": \"48876.01\"\n        }\n    },\n    \"parallelLineList\": [\n        \n    ],\n    \"shipping\": {\n        \"address\": \"AV CARLOS VILLARAN NRO 140 MZ A LT 8 INT\",\n        \"email\": \"\",\n        \"type\": \"FISICO\"\n    },\n    \"installment\": {\n        \"dollarsAmount\": \"0.00\",\n        \"solesAmount\": \"0.00\",\n        \"flag\": \"NO\"\n    },\n    \"cashdraw\": {\n        \"anualRate\": \"59.73\",\n        \"used\": \"1125.75\",\n        \"available\": \"874.25\"\n    },\n    \"consumption\": {\n        \"monthlyRate\": \"2.83\",\n        \"anualRate\": \"39.78\"\n    },\n    \"overdraft\": {\n        \"interestRate\": \"2.83\",\n        \"percentage\": \"10.00\",\n        \"amount\": \"5000.00\",\n        \"flag\": \"SI\"\n    },\n    \"blockReason\": \"0\",\n    \"debt\": {\n        \"solesAmount\": \"1241.25\",\n        \"dollarsAmount\": \"0.00\",\n        \"solesAmountSign\": \"+\",\n        \"dollarsAmountSign\": \"+\"\n    },\n    \"delayPenalty\": {\n        \"isDelay\": \"true\",\n        \"days\": \"000023\",\n        \"startDay\": \"20220615\"\n    },\n    \"payment\": {\n        \"minimumAmountSoles\": \"223.24\",\n        \"totalAmountSoles\": \"1225.30\",\n        \"minimumAmountDollars\": \"0.00\",\n        \"totalAmountDollars\": \"0.00\",\n        \"paymentDate\": \"20220706\",\n        \"billingClosingDate\": \"20220704\"\n    },\n    \"parallelLine\": \"NO\"\n}");
formatter.match({
  "location": "PagoMinFullDefinition.realizarConsulta(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "que el dia de hoy es la fecha de pago",
  "keyword": "Y "
});
formatter.write("El día indicado no es el de hoy, no se procedera con la ejecución");
formatter.match({
  "location": "PagoMinFullDefinition.queElDiaDeHoyEs()"
});
formatter.result({
  "error_message": "java.lang.AssertionError: El día indicado no es el de hoy, no se procedera con la ejecución\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat Interbank.com.pe.Task.Servicios.JavaAutomatizacion.obtenerFecha(JavaAutomatizacion.java:337)\r\n\tat Interbank.com.pe.stepdefinition.PagoMinFullDefinition.queElDiaDeHoyEs(PagoMinFullDefinition.java:60)\r\n\tat ✽.que el dia de hoy es la fecha de pago(src/test/resources/feature/herramientaPagoMinFull.feature:10)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "obtengo detalles de los montos a pagar",
  "keyword": "Y "
});
formatter.match({
  "location": "PagoMinFullDefinition.obtengoDetalle()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "realizo el abono correspondiente en \"pago_minimo_soles\"",
  "keyword": "Cuando "
});
formatter.match({
  "location": "PagoMinFullDefinition.realizoElAbonoCorrespondienteEn(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "reviso los movimientos del contrato.",
  "keyword": "Entonces "
});
formatter.match({
  "location": "PagoMinFullDefinition.revisoLosMovimientosDelContrato()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "Usuario realiza un pago minimo en soles para un producto tradicional \"CP002\"",
  "description": "",
  "keyword": "Esquema del escenario",
  "tags": [
    {
      "name": "@PagoMinimoSolesTrad"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "que realizo la consulta del \"4110930657026909\" y el \"60111748\"",
  "keyword": "Dado "
});
formatter.write("Status CODE del servicio: 200");
formatter.write("RESPONSE:");
formatter.write("{\n    \"isflagNSAT\": \"true\",\n    \"customerTypeCode\": \"TI\",\n    \"branch\": \"0987\",\n    \"bin\": \"411093\",\n    \"brandCode\": \"1\",\n    \"typeIndicator\": \"17\",\n    \"isBlock\": \"false\",\n    \"situation\": {\n        \"code\": \"5\",\n        \"description\": \"PODERCLIEN\"\n    },\n    \"account\": {\n        \"contractNumber\": \"000002253395\",\n        \"status\": \"OPERATIVO\",\n        \"currencyCode\": \"604\",\n        \"isDoubleCurrency\": \"false\"\n    },\n    \"consumptionLine\": {\n        \"processed\": {\n            \"sign\": \"+\",\n            \"amount\": \"134.23\"\n        },\n        \"authorized\": {\n            \"sign\": \"+\",\n            \"amount\": \"0.00\"\n        }\n    },\n    \"creditLine\": {\n        \"sign\": \"+\",\n        \"amount\": \"15000.00\",\n        \"used\": {\n            \"sign\": \"+\",\n            \"amount\": \"134.23\"\n        },\n        \"available\": {\n            \"sign\": \"+\",\n            \"amount\": \"14865.77\"\n        }\n    },\n    \"parallelLineList\": [\n        \n    ],\n    \"shipping\": {\n        \"address\": \"AV SECTOR 10 GFRUPO 1 NRO 001 MZ L LT 1\",\n        \"email\": \"DURANC1103@GMAIL.COM\",\n        \"type\": \"FIS Y CORREO PE\"\n    },\n    \"installment\": {\n        \"dollarsAmount\": \"0.00\",\n        \"solesAmount\": \"0.00\",\n        \"flag\": \"NO\"\n    },\n    \"cashdraw\": {\n        \"anualRate\": \"98.95\",\n        \"used\": \"0.00\",\n        \"available\": \"15000.00\"\n    },\n    \"consumption\": {\n        \"monthlyRate\": \"1.99\",\n        \"anualRate\": \"26.68\"\n    },\n    \"overdraft\": {\n        \"interestRate\": \"1.99\",\n        \"percentage\": \"10.00\",\n        \"amount\": \"1500.00\",\n        \"flag\": \"SI\"\n    },\n    \"blockReason\": \"0\",\n    \"debt\": {\n        \"solesAmount\": \"157.26\",\n        \"dollarsAmount\": \"0.00\",\n        \"solesAmountSign\": \"+\",\n        \"dollarsAmountSign\": \"+\"\n    },\n    \"delayPenalty\": {\n        \"isDelay\": \"true\",\n        \"days\": \"000002\",\n        \"startDay\": \"20220706\"\n    },\n    \"payment\": {\n        \"minimumAmountSoles\": \"43.00\",\n        \"totalAmountSoles\": \"146.28\",\n        \"minimumAmountDollars\": \"0.00\",\n        \"totalAmountDollars\": \"0.00\",\n        \"paymentDate\": \"20220706\",\n        \"billingClosingDate\": \"20220704\"\n    },\n    \"parallelLine\": \"NO\"\n}");
formatter.match({
  "location": "PagoMinFullDefinition.realizarConsulta(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "que el dia de hoy es la fecha de pago",
  "keyword": "Y "
});
formatter.write("El día indicado no es el de hoy, no se procedera con la ejecución");
formatter.match({
  "location": "PagoMinFullDefinition.queElDiaDeHoyEs()"
});
formatter.result({
  "error_message": "java.lang.AssertionError: El día indicado no es el de hoy, no se procedera con la ejecución\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat Interbank.com.pe.Task.Servicios.JavaAutomatizacion.obtenerFecha(JavaAutomatizacion.java:337)\r\n\tat Interbank.com.pe.stepdefinition.PagoMinFullDefinition.queElDiaDeHoyEs(PagoMinFullDefinition.java:60)\r\n\tat ✽.que el dia de hoy es la fecha de pago(src/test/resources/feature/herramientaPagoMinFull.feature:10)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "obtengo detalles de los montos a pagar",
  "keyword": "Y "
});
formatter.match({
  "location": "PagoMinFullDefinition.obtengoDetalle()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "realizo el abono correspondiente en \"pago_minimo_soles\"",
  "keyword": "Cuando "
});
formatter.match({
  "location": "PagoMinFullDefinition.realizoElAbonoCorrespondienteEn(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "reviso los movimientos del contrato.",
  "keyword": "Entonces "
});
formatter.match({
  "location": "PagoMinFullDefinition.revisoLosMovimientosDelContrato()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "Usuario realiza un pago minimo en soles para un producto tradicional \"CP003\"",
  "description": "",
  "keyword": "Esquema del escenario",
  "tags": [
    {
      "name": "@PagoMinimoSolesTrad"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "que realizo la consulta del \"377754998064635\" y el \"60018375\"",
  "keyword": "Dado "
});
formatter.write("Status CODE del servicio: 200");
formatter.write("RESPONSE:");
formatter.write("{\n    \"isflagNSAT\": \"true\",\n    \"customerTypeCode\": \"TI\",\n    \"branch\": \"0987\",\n    \"bin\": \"377754\",\n    \"brandCode\": \"2\",\n    \"typeIndicator\": \"9\",\n    \"isBlock\": \"true\",\n    \"situation\": {\n        \"code\": \"5\",\n        \"description\": \"PODERCLIEN\"\n    },\n    \"account\": {\n        \"contractNumber\": \"000002253259\",\n        \"status\": \"BLOQUEO TEMPORAL\",\n        \"currencyCode\": \"604\",\n        \"isDoubleCurrency\": \"true\"\n    },\n    \"consumptionLine\": {\n        \"processed\": {\n            \"sign\": \"+\",\n            \"amount\": \"12375.06\"\n        },\n        \"authorized\": {\n            \"sign\": \"+\",\n            \"amount\": \"0.00\"\n        }\n    },\n    \"creditLine\": {\n        \"sign\": \"+\",\n        \"amount\": \"50000.00\",\n        \"used\": {\n            \"sign\": \"+\",\n            \"amount\": \"12375.06\"\n        },\n        \"available\": {\n            \"sign\": \"+\",\n            \"amount\": \"37624.94\"\n        }\n    },\n    \"parallelLineList\": [\n        \n    ],\n    \"shipping\": {\n        \"address\": \"AV CANADA NRO 169\",\n        \"email\": \"\",\n        \"type\": \"FISICO\"\n    },\n    \"installment\": {\n        \"dollarsAmount\": \"0.00\",\n        \"solesAmount\": \"0.00\",\n        \"flag\": \"NO\"\n    },\n    \"cashdraw\": {\n        \"anualRate\": \"59.73\",\n        \"used\": \"10276.91\",\n        \"available\": \"8276.91\"\n    },\n    \"consumption\": {\n        \"monthlyRate\": \"2.83\",\n        \"anualRate\": \"39.78\"\n    },\n    \"overdraft\": {\n        \"interestRate\": \"2.83\",\n        \"percentage\": \"10.00\",\n        \"amount\": \"5000.00\",\n        \"flag\": \"SI\"\n    },\n    \"blockReason\": \"0\",\n    \"debt\": {\n        \"solesAmount\": \"50.00\",\n        \"dollarsAmount\": \"3106.81\",\n        \"solesAmountSign\": \"+\",\n        \"dollarsAmountSign\": \"+\"\n    },\n    \"delayPenalty\": {\n        \"isDelay\": \"true\",\n        \"days\": \"000025\",\n        \"startDay\": \"20220613\"\n    },\n    \"payment\": {\n        \"minimumAmountSoles\": \"40.00\",\n        \"totalAmountSoles\": \"40.00\",\n        \"minimumAmountDollars\": \"470.00\",\n        \"totalAmountDollars\": \"3102.79\",\n        \"paymentDate\": \"20220711\",\n        \"billingClosingDate\": \"20220707\"\n    },\n    \"parallelLine\": \"NO\"\n}");
formatter.match({
  "location": "PagoMinFullDefinition.realizarConsulta(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "que el dia de hoy es la fecha de pago",
  "keyword": "Y "
});
formatter.write("El día indicado no es el de hoy, no se procedera con la ejecución");
formatter.match({
  "location": "PagoMinFullDefinition.queElDiaDeHoyEs()"
});
formatter.result({
  "error_message": "java.lang.AssertionError: El día indicado no es el de hoy, no se procedera con la ejecución\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat Interbank.com.pe.Task.Servicios.JavaAutomatizacion.obtenerFecha(JavaAutomatizacion.java:337)\r\n\tat Interbank.com.pe.stepdefinition.PagoMinFullDefinition.queElDiaDeHoyEs(PagoMinFullDefinition.java:60)\r\n\tat ✽.que el dia de hoy es la fecha de pago(src/test/resources/feature/herramientaPagoMinFull.feature:10)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "obtengo detalles de los montos a pagar",
  "keyword": "Y "
});
formatter.match({
  "location": "PagoMinFullDefinition.obtengoDetalle()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "realizo el abono correspondiente en \"pago_minimo_soles\"",
  "keyword": "Cuando "
});
formatter.match({
  "location": "PagoMinFullDefinition.realizoElAbonoCorrespondienteEn(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "reviso los movimientos del contrato.",
  "keyword": "Entonces "
});
formatter.match({
  "location": "PagoMinFullDefinition.revisoLosMovimientosDelContrato()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "Usuario realiza un pago minimo en soles para un producto tradicional \"CP004\"",
  "description": "",
  "keyword": "Esquema del escenario",
  "tags": [
    {
      "name": "@PagoMinimoSolesTrad"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "que realizo la consulta del \"4913370797050718\" y el \"60418066\"",
  "keyword": "Dado "
});
formatter.write("Status CODE del servicio: 200");
formatter.write("RESPONSE:");
formatter.write("{\n    \"isflagNSAT\": \"true\",\n    \"customerTypeCode\": \"TI\",\n    \"branch\": \"0987\",\n    \"bin\": \"491337\",\n    \"brandCode\": \"1\",\n    \"typeIndicator\": \"2\",\n    \"isBlock\": \"true\",\n    \"situation\": {\n        \"code\": \"5\",\n        \"description\": \"PODERCLIEN\"\n    },\n    \"account\": {\n        \"contractNumber\": \"000002253228\",\n        \"status\": \"BLOQUEO POR MORA\",\n        \"currencyCode\": \"604\",\n        \"isDoubleCurrency\": \"true\"\n    },\n    \"consumptionLine\": {\n        \"processed\": {\n            \"sign\": \"+\",\n            \"amount\": \"0.00\"\n        },\n        \"authorized\": {\n            \"sign\": \"+\",\n            \"amount\": \"0.00\"\n        }\n    },\n    \"creditLine\": {\n        \"sign\": \"+\",\n        \"amount\": \"50000.00\",\n        \"used\": {\n            \"sign\": \"+\",\n            \"amount\": \"0.00\"\n        },\n        \"available\": {\n            \"sign\": \"+\",\n            \"amount\": \"50000.00\"\n        }\n    },\n    \"parallelLineList\": [\n        \n    ],\n    \"shipping\": {\n        \"address\": \"AV SAN FRANCISCO NRO 258 MZ A LT 8 INT 1\",\n        \"email\": \"\",\n        \"type\": \"FISICO\"\n    },\n    \"installment\": {\n        \"dollarsAmount\": \"0.00\",\n        \"solesAmount\": \"0.00\",\n        \"flag\": \"NO\"\n    },\n    \"cashdraw\": {\n        \"anualRate\": \"59.73\",\n        \"used\": \"0.00\",\n        \"available\": \"2000.00\"\n    },\n    \"consumption\": {\n        \"monthlyRate\": \"2.83\",\n        \"anualRate\": \"39.78\"\n    },\n    \"overdraft\": {\n        \"interestRate\": \"2.83\",\n        \"percentage\": \"10.00\",\n        \"amount\": \"5000.00\",\n        \"flag\": \"SI\"\n    },\n    \"blockReason\": \"0\",\n    \"debt\": {\n        \"solesAmount\": \"13.18\",\n        \"dollarsAmount\": \"0.00\",\n        \"solesAmountSign\": \"+\",\n        \"dollarsAmountSign\": \"+\"\n    },\n    \"delayPenalty\": {\n        \"isDelay\": \"true\",\n        \"days\": \"000025\",\n        \"startDay\": \"20220613\"\n    },\n    \"payment\": {\n        \"minimumAmountSoles\": \"3.18\",\n        \"totalAmountSoles\": \"3.18\",\n        \"minimumAmountDollars\": \"0.00\",\n        \"totalAmountDollars\": \"0.00\",\n        \"paymentDate\": \"20220711\",\n        \"billingClosingDate\": \"20220707\"\n    },\n    \"parallelLine\": \"NO\"\n}");
formatter.match({
  "location": "PagoMinFullDefinition.realizarConsulta(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "que el dia de hoy es la fecha de pago",
  "keyword": "Y "
});
formatter.write("El día indicado no es el de hoy, no se procedera con la ejecución");
formatter.match({
  "location": "PagoMinFullDefinition.queElDiaDeHoyEs()"
});
formatter.result({
  "error_message": "java.lang.AssertionError: El día indicado no es el de hoy, no se procedera con la ejecución\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat Interbank.com.pe.Task.Servicios.JavaAutomatizacion.obtenerFecha(JavaAutomatizacion.java:337)\r\n\tat Interbank.com.pe.stepdefinition.PagoMinFullDefinition.queElDiaDeHoyEs(PagoMinFullDefinition.java:60)\r\n\tat ✽.que el dia de hoy es la fecha de pago(src/test/resources/feature/herramientaPagoMinFull.feature:10)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "obtengo detalles de los montos a pagar",
  "keyword": "Y "
});
formatter.match({
  "location": "PagoMinFullDefinition.obtengoDetalle()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "realizo el abono correspondiente en \"pago_minimo_soles\"",
  "keyword": "Cuando "
});
formatter.match({
  "location": "PagoMinFullDefinition.realizoElAbonoCorrespondienteEn(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "reviso los movimientos del contrato.",
  "keyword": "Entonces "
});
formatter.match({
  "location": "PagoMinFullDefinition.revisoLosMovimientosDelContrato()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "Usuario realiza un pago minimo en soles para un producto tradicional \"CP005\"",
  "description": "",
  "keyword": "Esquema del escenario",
  "tags": [
    {
      "name": "@PagoMinimoSolesTrad"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "que realizo la consulta del \"4110930657022072\" y el \"60460931\"",
  "keyword": "Dado "
});
formatter.write("Status CODE del servicio: 200");
formatter.write("RESPONSE:");
formatter.write("{\n    \"isflagNSAT\": \"true\",\n    \"customerTypeCode\": \"TI\",\n    \"branch\": \"0987\",\n    \"bin\": \"411093\",\n    \"brandCode\": \"1\",\n    \"typeIndicator\": \"17\",\n    \"isBlock\": \"false\",\n    \"situation\": {\n        \"code\": \"5\",\n        \"description\": \"PODERCLIEN\"\n    },\n    \"account\": {\n        \"contractNumber\": \"000002244630\",\n        \"status\": \"OPERATIVO\",\n        \"currencyCode\": \"604\",\n        \"isDoubleCurrency\": \"false\"\n    },\n    \"consumptionLine\": {\n        \"processed\": {\n            \"sign\": \"+\",\n            \"amount\": \"3336.80\"\n        },\n        \"authorized\": {\n            \"sign\": \"+\",\n            \"amount\": \"0.00\"\n        }\n    },\n    \"creditLine\": {\n        \"sign\": \"+\",\n        \"amount\": \"20000.00\",\n        \"used\": {\n            \"sign\": \"+\",\n            \"amount\": \"3336.80\"\n        },\n        \"available\": {\n            \"sign\": \"+\",\n            \"amount\": \"16663.20\"\n        }\n    },\n    \"parallelLineList\": [\n        \n    ],\n    \"shipping\": {\n        \"address\": \"AV LOS ALAMOS NRO 1415\",\n        \"email\": \"\",\n        \"type\": \"FISICO\"\n    },\n    \"installment\": {\n        \"dollarsAmount\": \"0.00\",\n        \"solesAmount\": \"0.00\",\n        \"flag\": \"NO\"\n    },\n    \"cashdraw\": {\n        \"anualRate\": \"34.33\",\n        \"used\": \"0.00\",\n        \"available\": \"2000.00\"\n    },\n    \"consumption\": {\n        \"monthlyRate\": \"1.99\",\n        \"anualRate\": \"26.68\"\n    },\n    \"overdraft\": {\n        \"interestRate\": \"1.99\",\n        \"percentage\": \"10.00\",\n        \"amount\": \"2000.00\",\n        \"flag\": \"SI\"\n    },\n    \"blockReason\": \"0\",\n    \"debt\": {\n        \"solesAmount\": \"3396.72\",\n        \"dollarsAmount\": \"0.00\",\n        \"solesAmountSign\": \"+\",\n        \"dollarsAmountSign\": \"+\"\n    },\n    \"delayPenalty\": {\n        \"isDelay\": \"true\",\n        \"days\": \"000002\",\n        \"startDay\": \"20220706\"\n    },\n    \"payment\": {\n        \"minimumAmountSoles\": \"134.00\",\n        \"totalAmountSoles\": \"3377.72\",\n        \"minimumAmountDollars\": \"0.00\",\n        \"totalAmountDollars\": \"0.00\",\n        \"paymentDate\": \"20220706\",\n        \"billingClosingDate\": \"20220704\"\n    },\n    \"parallelLine\": \"NO\"\n}");
formatter.match({
  "location": "PagoMinFullDefinition.realizarConsulta(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "que el dia de hoy es la fecha de pago",
  "keyword": "Y "
});
formatter.write("El día indicado no es el de hoy, no se procedera con la ejecución");
formatter.match({
  "location": "PagoMinFullDefinition.queElDiaDeHoyEs()"
});
formatter.result({
  "error_message": "java.lang.AssertionError: El día indicado no es el de hoy, no se procedera con la ejecución\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat Interbank.com.pe.Task.Servicios.JavaAutomatizacion.obtenerFecha(JavaAutomatizacion.java:337)\r\n\tat Interbank.com.pe.stepdefinition.PagoMinFullDefinition.queElDiaDeHoyEs(PagoMinFullDefinition.java:60)\r\n\tat ✽.que el dia de hoy es la fecha de pago(src/test/resources/feature/herramientaPagoMinFull.feature:10)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "obtengo detalles de los montos a pagar",
  "keyword": "Y "
});
formatter.match({
  "location": "PagoMinFullDefinition.obtengoDetalle()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "realizo el abono correspondiente en \"pago_minimo_soles\"",
  "keyword": "Cuando "
});
formatter.match({
  "location": "PagoMinFullDefinition.realizoElAbonoCorrespondienteEn(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "reviso los movimientos del contrato.",
  "keyword": "Entonces "
});
formatter.match({
  "location": "PagoMinFullDefinition.revisoLosMovimientosDelContrato()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "Usuario realiza un pago minimo en soles para un producto tradicional \"CP006\"",
  "description": "",
  "keyword": "Esquema del escenario",
  "tags": [
    {
      "name": "@PagoMinimoSolesTrad"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "que realizo la consulta del \"5443599980074715\" y el \"60460931\"",
  "keyword": "Dado "
});
formatter.write("Status CODE del servicio: 403");
formatter.write("RESPONSE: {\n    \"httpCode\": \"403\",\n    \"httpMessage\": \"Business error\",\n    \"providerCode\": \"0055\",\n    \"providerMessage\": \"CDIR039 ERROR PAN NO EXISTE\"\n}");
formatter.match({
  "location": "PagoMinFullDefinition.realizarConsulta(String,String)"
});
formatter.result({
  "error_message": "java.lang.AssertionError: El codigo del response es 403 que indica error, revisar la información ingresada.\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat Interbank.com.pe.Task.Servicios.JavaAutomatizacion.consultarMontos(JavaAutomatizacion.java:95)\r\n\tat Interbank.com.pe.stepdefinition.PagoMinFullDefinition.realizarConsulta(PagoMinFullDefinition.java:33)\r\n\tat ✽.que realizo la consulta del \"5443599980074715\" y el \"60460931\"(src/test/resources/feature/herramientaPagoMinFull.feature:9)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "que el dia de hoy es la fecha de pago",
  "keyword": "Y "
});
formatter.match({
  "location": "PagoMinFullDefinition.queElDiaDeHoyEs()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "obtengo detalles de los montos a pagar",
  "keyword": "Y "
});
formatter.match({
  "location": "PagoMinFullDefinition.obtengoDetalle()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "realizo el abono correspondiente en \"pago_minimo_soles\"",
  "keyword": "Cuando "
});
formatter.match({
  "location": "PagoMinFullDefinition.realizoElAbonoCorrespondienteEn(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "reviso los movimientos del contrato.",
  "keyword": "Entonces "
});
formatter.match({
  "location": "PagoMinFullDefinition.revisoLosMovimientosDelContrato()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "Usuario realiza un pago minimo en soles para un producto tradicional \"CP007\"",
  "description": "",
  "keyword": "Esquema del escenario",
  "tags": [
    {
      "name": "@PagoMinimoSolesTrad"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "que realizo la consulta del \"5443599980076843\" y el \"60478713\"",
  "keyword": "Dado "
});
formatter.write("Status CODE del servicio: 200");
formatter.write("RESPONSE:");
formatter.write("{\n    \"isflagNSAT\": \"true\",\n    \"customerTypeCode\": \"TI\",\n    \"branch\": \"0895\",\n    \"bin\": \"544359\",\n    \"brandCode\": \"4\",\n    \"typeIndicator\": \"2\",\n    \"isBlock\": \"false\",\n    \"situation\": {\n        \"code\": \"5\",\n        \"description\": \"PODERCLIEN\"\n    },\n    \"account\": {\n        \"contractNumber\": \"000002229374\",\n        \"status\": \"OPERATIVO\",\n        \"currencyCode\": \"604\",\n        \"isDoubleCurrency\": \"true\"\n    },\n    \"consumptionLine\": {\n        \"processed\": {\n            \"sign\": \"+\",\n            \"amount\": \"553.01\"\n        },\n        \"authorized\": {\n            \"sign\": \"+\",\n            \"amount\": \"0.00\"\n        }\n    },\n    \"creditLine\": {\n        \"sign\": \"+\",\n        \"amount\": \"8000.00\",\n        \"used\": {\n            \"sign\": \"+\",\n            \"amount\": \"553.01\"\n        },\n        \"available\": {\n            \"sign\": \"+\",\n            \"amount\": \"7446.99\"\n        }\n    },\n    \"parallelLineList\": [\n        {\n            \"name\": \"EXTRACASH\",\n            \"solesAmount\": \"0.00\",\n            \"dollarsAmount\": \"0.00\"\n        },\n        {\n            \"name\": \"COMPRA DEUDA\",\n            \"solesAmount\": \"0.00\",\n            \"dollarsAmount\": \"0.00\"\n        }\n    ],\n    \"shipping\": {\n        \"address\": \"AV LAS FLORES NRO 145\",\n        \"email\": \"\",\n        \"type\": \"FISICO\"\n    },\n    \"installment\": {\n        \"dollarsAmount\": \"0.00\",\n        \"solesAmount\": \"0.00\",\n        \"flag\": \"NO\"\n    },\n    \"cashdraw\": {\n        \"anualRate\": \"99.86\",\n        \"used\": \"0.00\",\n        \"available\": \"2000.00\"\n    },\n    \"consumption\": {\n        \"monthlyRate\": \"5.02\",\n        \"anualRate\": \"80.00\"\n    },\n    \"overdraft\": {\n        \"interestRate\": \"5.02\",\n        \"percentage\": \"10.00\",\n        \"amount\": \"800.00\",\n        \"flag\": \"SI\"\n    },\n    \"blockReason\": \"0\",\n    \"debt\": {\n        \"solesAmount\": \"590.86\",\n        \"dollarsAmount\": \"0.00\",\n        \"solesAmountSign\": \"+\",\n        \"dollarsAmountSign\": \"+\"\n    },\n    \"delayPenalty\": {\n        \"isDelay\": \"true\",\n        \"days\": \"000001\",\n        \"startDay\": \"20220707\"\n    },\n    \"payment\": {\n        \"minimumAmountSoles\": \"56.00\",\n        \"totalAmountSoles\": \"578.09\",\n        \"minimumAmountDollars\": \"0.00\",\n        \"totalAmountDollars\": \"0.00\",\n        \"paymentDate\": \"20220707\",\n        \"billingClosingDate\": \"20220705\"\n    },\n    \"parallelLine\": \"SI\"\n}");
formatter.match({
  "location": "PagoMinFullDefinition.realizarConsulta(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "que el dia de hoy es la fecha de pago",
  "keyword": "Y "
});
formatter.write("El día indicado no es el de hoy, no se procedera con la ejecución");
formatter.match({
  "location": "PagoMinFullDefinition.queElDiaDeHoyEs()"
});
formatter.result({
  "error_message": "java.lang.AssertionError: El día indicado no es el de hoy, no se procedera con la ejecución\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat Interbank.com.pe.Task.Servicios.JavaAutomatizacion.obtenerFecha(JavaAutomatizacion.java:337)\r\n\tat Interbank.com.pe.stepdefinition.PagoMinFullDefinition.queElDiaDeHoyEs(PagoMinFullDefinition.java:60)\r\n\tat ✽.que el dia de hoy es la fecha de pago(src/test/resources/feature/herramientaPagoMinFull.feature:10)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "obtengo detalles de los montos a pagar",
  "keyword": "Y "
});
formatter.match({
  "location": "PagoMinFullDefinition.obtengoDetalle()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "realizo el abono correspondiente en \"pago_minimo_soles\"",
  "keyword": "Cuando "
});
formatter.match({
  "location": "PagoMinFullDefinition.realizoElAbonoCorrespondienteEn(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "reviso los movimientos del contrato.",
  "keyword": "Entonces "
});
formatter.match({
  "location": "PagoMinFullDefinition.revisoLosMovimientosDelContrato()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "Usuario realiza un pago minimo en soles para un producto tradicional \"CP008\"",
  "description": "",
  "keyword": "Esquema del escenario",
  "tags": [
    {
      "name": "@PagoMinimoSolesTrad"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "que realizo la consulta del \"5491619980078135\" y el \"60384520\"",
  "keyword": "Dado "
});
formatter.write("Status CODE del servicio: 200");
formatter.write("RESPONSE:");
formatter.write("{\n    \"isflagNSAT\": \"true\",\n    \"customerTypeCode\": \"TI\",\n    \"branch\": \"0100\",\n    \"bin\": \"549161\",\n    \"brandCode\": \"4\",\n    \"typeIndicator\": \"4\",\n    \"isBlock\": \"false\",\n    \"situation\": {\n        \"code\": \"5\",\n        \"description\": \"PODERCLIEN\"\n    },\n    \"account\": {\n        \"contractNumber\": \"000002202593\",\n        \"status\": \"OPERATIVO\",\n        \"currencyCode\": \"604\",\n        \"isDoubleCurrency\": \"true\"\n    },\n    \"consumptionLine\": {\n        \"processed\": {\n            \"sign\": \"+\",\n            \"amount\": \"0.00\"\n        },\n        \"authorized\": {\n            \"sign\": \"+\",\n            \"amount\": \"0.00\"\n        }\n    },\n    \"creditLine\": {\n        \"sign\": \"+\",\n        \"amount\": \"10000.00\",\n        \"used\": {\n            \"sign\": \"+\",\n            \"amount\": \"0.00\"\n        },\n        \"available\": {\n            \"sign\": \"+\",\n            \"amount\": \"10000.00\"\n        }\n    },\n    \"parallelLineList\": [\n        {\n            \"name\": \"EXTRACASH\",\n            \"solesAmount\": \"0.00\",\n            \"dollarsAmount\": \"0.00\"\n        },\n        {\n            \"name\": \"REPROGRAMACION DEUDA PARALELA\",\n            \"solesAmount\": \"0.00\",\n            \"dollarsAmount\": \"0.00\"\n        }\n    ],\n    \"shipping\": {\n        \"address\": \"AV 2 DE MAYO NRO 66 LT \\n\",\n        \"email\": \"\",\n        \"type\": \"FISICO\"\n    },\n    \"installment\": {\n        \"dollarsAmount\": \"0.00\",\n        \"solesAmount\": \"0.00\",\n        \"flag\": \"SI\"\n    },\n    \"cashdraw\": {\n        \"anualRate\": \"59.73\",\n        \"used\": \"0.00\",\n        \"available\": \"100.00\"\n    },\n    \"consumption\": {\n        \"monthlyRate\": \"3.13\",\n        \"anualRate\": \"44.75\"\n    },\n    \"overdraft\": {\n        \"interestRate\": \"3.13\",\n        \"percentage\": \"10.00\",\n        \"amount\": \"1000.00\",\n        \"flag\": \"SI\"\n    },\n    \"blockReason\": \"0\",\n    \"debt\": {\n        \"solesAmount\": \"24.19\",\n        \"dollarsAmount\": \"28.19\",\n        \"solesAmountSign\": \"+\",\n        \"dollarsAmountSign\": \"+\"\n    },\n    \"delayPenalty\": {\n        \"isDelay\": \"false\",\n        \"days\": \"000000\",\n        \"startDay\": \"00000000\"\n    },\n    \"payment\": {\n        \"minimumAmountSoles\": \"10.83\",\n        \"totalAmountSoles\": \"10.83\",\n        \"minimumAmountDollars\": \"14.81\",\n        \"totalAmountDollars\": \"14.81\",\n        \"paymentDate\": \"20220801\",\n        \"billingClosingDate\": \"20220707\"\n    },\n    \"parallelLine\": \"SI\"\n}");
formatter.match({
  "location": "PagoMinFullDefinition.realizarConsulta(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "que el dia de hoy es la fecha de pago",
  "keyword": "Y "
});
formatter.write("El día indicado no es el de hoy, no se procedera con la ejecución");
formatter.match({
  "location": "PagoMinFullDefinition.queElDiaDeHoyEs()"
});
formatter.result({
  "error_message": "java.lang.AssertionError: El día indicado no es el de hoy, no se procedera con la ejecución\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat Interbank.com.pe.Task.Servicios.JavaAutomatizacion.obtenerFecha(JavaAutomatizacion.java:337)\r\n\tat Interbank.com.pe.stepdefinition.PagoMinFullDefinition.queElDiaDeHoyEs(PagoMinFullDefinition.java:60)\r\n\tat ✽.que el dia de hoy es la fecha de pago(src/test/resources/feature/herramientaPagoMinFull.feature:10)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "obtengo detalles de los montos a pagar",
  "keyword": "Y "
});
formatter.match({
  "location": "PagoMinFullDefinition.obtengoDetalle()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "realizo el abono correspondiente en \"pago_minimo_soles\"",
  "keyword": "Cuando "
});
formatter.match({
  "location": "PagoMinFullDefinition.realizoElAbonoCorrespondienteEn(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "reviso los movimientos del contrato.",
  "keyword": "Entonces "
});
formatter.match({
  "location": "PagoMinFullDefinition.revisoLosMovimientosDelContrato()"
});
formatter.result({
  "status": "skipped"
});
formatter.uri("src/test/resources/feature/mantenimientoData.feature");
formatter.feature({
  "name": "Realizar operaciones de pago Min-Full",
  "description": "  Como un analista QA/banco\n  Quiero realizar operaciones para mantenimiento de data",
  "keyword": "Característica"
});
formatter.scenarioOutline({
  "name": "El analista desea realizar mantenimiento decontratos en soles \"\u003cID_Caso\u003e\"",
  "description": "",
  "keyword": "Esquema del escenario",
  "tags": [
    {
      "name": "@ConsumoMantenimiento"
    }
  ]
});
formatter.step({
  "name": "que el dia de hoy es \"\u003cdia\u003e\"",
  "keyword": "Dado "
});
formatter.step({
  "name": "ingreso la \"\u003cPAN\u003e\" y el \"\u003cmonto\u003e\" en \"\u003cmoneda\u003e\" al servicio",
  "keyword": "Cuando "
});
formatter.step({
  "name": "ejecuto el servicio de consumo",
  "keyword": "Entonces "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Ejemplos",
  "rows": [
    {
      "cells": [
        "ID_Caso",
        "dia",
        "PAN",
        "monto",
        "moneda"
      ]
    },
    {
      "cells": [
        "CP001",
        "VIERNES",
        "4772890057027023",
        "650",
        "soles"
      ]
    },
    {
      "cells": [
        "CP002",
        "LUNES",
        "4222240057023646",
        "750",
        "soles"
      ]
    },
    {
      "cells": [
        "CP003",
        "MARTES",
        "4913370797054033",
        "560",
        "soles"
      ]
    },
    {
      "cells": [
        "CP004",
        "MIÉRCOLES",
        "4222240057023661",
        "850",
        "soles"
      ]
    },
    {
      "cells": [
        "CP005",
        "JUEVES",
        "377754998066531",
        "780",
        "soles"
      ]
    },
    {
      "cells": [
        "CP005",
        "MIÉRCOLES",
        "5443599980074715",
        "2000",
        "soles"
      ]
    }
  ]
});
formatter.scenario({
  "name": "El analista desea realizar mantenimiento decontratos en soles \"CP001\"",
  "description": "",
  "keyword": "Esquema del escenario",
  "tags": [
    {
      "name": "@ConsumoMantenimiento"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "que el dia de hoy es \"VIERNES\"",
  "keyword": "Dado "
});
formatter.write("Se ejecuta el caso, el día indicado es el de hoy.");
formatter.match({
  "location": "mantenimientoDataDefinition.queElDiaDeHoyEs(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "ingreso la \"4772890057027023\" y el \"650\" en \"soles\" al servicio",
  "keyword": "Cuando "
});
formatter.match({
  "location": "mantenimientoDataDefinition.ingresoLaElYElEn(String,String,String)"
});
formatter.result({
  "error_message": "java.io.FileNotFoundException: src\\test\\java\\providers\\uat\\realizaConsumo.xml (El sistema no puede encontrar la ruta especificada)\r\n\tat java.io.FileInputStream.open0(Native Method)\r\n\tat java.io.FileInputStream.open(FileInputStream.java:195)\r\n\tat java.io.FileInputStream.\u003cinit\u003e(FileInputStream.java:138)\r\n\tat Interbank.com.pe.Task.Servicios.JavaAutomatizacion.consumo(JavaAutomatizacion.java:287)\r\n\tat Interbank.com.pe.stepdefinition.mantenimientoDataDefinition.ingresoLaElYElEn(mantenimientoDataDefinition.java:42)\r\n\tat ✽.ingreso la \"4772890057027023\" y el \"650\" en \"soles\" al servicio(src/test/resources/feature/mantenimientoData.feature:85)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "ejecuto el servicio de consumo",
  "keyword": "Entonces "
});
formatter.match({
  "location": "mantenimientoDataDefinition.ejecutoElServicioDeConsumo()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "El analista desea realizar mantenimiento decontratos en soles \"CP002\"",
  "description": "",
  "keyword": "Esquema del escenario",
  "tags": [
    {
      "name": "@ConsumoMantenimiento"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "que el dia de hoy es \"LUNES\"",
  "keyword": "Dado "
});
formatter.match({
  "location": "mantenimientoDataDefinition.queElDiaDeHoyEs(String)"
});
formatter.result({
  "error_message": "java.lang.AssertionError: No se ejecuta el caso, ya que el día indicado no es mismo de hoy.\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat Interbank.com.pe.Task.Servicios.JavaAutomatizacion.obtenerDia(JavaAutomatizacion.java:348)\r\n\tat Interbank.com.pe.stepdefinition.mantenimientoDataDefinition.queElDiaDeHoyEs(mantenimientoDataDefinition.java:56)\r\n\tat ✽.que el dia de hoy es \"LUNES\"(src/test/resources/feature/mantenimientoData.feature:84)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "ingreso la \"4222240057023646\" y el \"750\" en \"soles\" al servicio",
  "keyword": "Cuando "
});
formatter.match({
  "location": "mantenimientoDataDefinition.ingresoLaElYElEn(String,String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "ejecuto el servicio de consumo",
  "keyword": "Entonces "
});
formatter.match({
  "location": "mantenimientoDataDefinition.ejecutoElServicioDeConsumo()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "El analista desea realizar mantenimiento decontratos en soles \"CP003\"",
  "description": "",
  "keyword": "Esquema del escenario",
  "tags": [
    {
      "name": "@ConsumoMantenimiento"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "que el dia de hoy es \"MARTES\"",
  "keyword": "Dado "
});
formatter.match({
  "location": "mantenimientoDataDefinition.queElDiaDeHoyEs(String)"
});
formatter.result({
  "error_message": "java.lang.AssertionError: No se ejecuta el caso, ya que el día indicado no es mismo de hoy.\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat Interbank.com.pe.Task.Servicios.JavaAutomatizacion.obtenerDia(JavaAutomatizacion.java:348)\r\n\tat Interbank.com.pe.stepdefinition.mantenimientoDataDefinition.queElDiaDeHoyEs(mantenimientoDataDefinition.java:56)\r\n\tat ✽.que el dia de hoy es \"MARTES\"(src/test/resources/feature/mantenimientoData.feature:84)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "ingreso la \"4913370797054033\" y el \"560\" en \"soles\" al servicio",
  "keyword": "Cuando "
});
formatter.match({
  "location": "mantenimientoDataDefinition.ingresoLaElYElEn(String,String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "ejecuto el servicio de consumo",
  "keyword": "Entonces "
});
formatter.match({
  "location": "mantenimientoDataDefinition.ejecutoElServicioDeConsumo()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "El analista desea realizar mantenimiento decontratos en soles \"CP004\"",
  "description": "",
  "keyword": "Esquema del escenario",
  "tags": [
    {
      "name": "@ConsumoMantenimiento"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "que el dia de hoy es \"MIÉRCOLES\"",
  "keyword": "Dado "
});
formatter.match({
  "location": "mantenimientoDataDefinition.queElDiaDeHoyEs(String)"
});
formatter.result({
  "error_message": "java.lang.AssertionError: No se ejecuta el caso, ya que el día indicado no es mismo de hoy.\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat Interbank.com.pe.Task.Servicios.JavaAutomatizacion.obtenerDia(JavaAutomatizacion.java:348)\r\n\tat Interbank.com.pe.stepdefinition.mantenimientoDataDefinition.queElDiaDeHoyEs(mantenimientoDataDefinition.java:56)\r\n\tat ✽.que el dia de hoy es \"MIÉRCOLES\"(src/test/resources/feature/mantenimientoData.feature:84)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "ingreso la \"4222240057023661\" y el \"850\" en \"soles\" al servicio",
  "keyword": "Cuando "
});
formatter.match({
  "location": "mantenimientoDataDefinition.ingresoLaElYElEn(String,String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "ejecuto el servicio de consumo",
  "keyword": "Entonces "
});
formatter.match({
  "location": "mantenimientoDataDefinition.ejecutoElServicioDeConsumo()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "El analista desea realizar mantenimiento decontratos en soles \"CP005\"",
  "description": "",
  "keyword": "Esquema del escenario",
  "tags": [
    {
      "name": "@ConsumoMantenimiento"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "que el dia de hoy es \"JUEVES\"",
  "keyword": "Dado "
});
formatter.match({
  "location": "mantenimientoDataDefinition.queElDiaDeHoyEs(String)"
});
formatter.result({
  "error_message": "java.lang.AssertionError: No se ejecuta el caso, ya que el día indicado no es mismo de hoy.\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat Interbank.com.pe.Task.Servicios.JavaAutomatizacion.obtenerDia(JavaAutomatizacion.java:348)\r\n\tat Interbank.com.pe.stepdefinition.mantenimientoDataDefinition.queElDiaDeHoyEs(mantenimientoDataDefinition.java:56)\r\n\tat ✽.que el dia de hoy es \"JUEVES\"(src/test/resources/feature/mantenimientoData.feature:84)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "ingreso la \"377754998066531\" y el \"780\" en \"soles\" al servicio",
  "keyword": "Cuando "
});
formatter.match({
  "location": "mantenimientoDataDefinition.ingresoLaElYElEn(String,String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "ejecuto el servicio de consumo",
  "keyword": "Entonces "
});
formatter.match({
  "location": "mantenimientoDataDefinition.ejecutoElServicioDeConsumo()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "El analista desea realizar mantenimiento decontratos en soles \"CP005\"",
  "description": "",
  "keyword": "Esquema del escenario",
  "tags": [
    {
      "name": "@ConsumoMantenimiento"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "que el dia de hoy es \"MIÉRCOLES\"",
  "keyword": "Dado "
});
formatter.match({
  "location": "mantenimientoDataDefinition.queElDiaDeHoyEs(String)"
});
formatter.result({
  "error_message": "java.lang.AssertionError: No se ejecuta el caso, ya que el día indicado no es mismo de hoy.\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat Interbank.com.pe.Task.Servicios.JavaAutomatizacion.obtenerDia(JavaAutomatizacion.java:348)\r\n\tat Interbank.com.pe.stepdefinition.mantenimientoDataDefinition.queElDiaDeHoyEs(mantenimientoDataDefinition.java:56)\r\n\tat ✽.que el dia de hoy es \"MIÉRCOLES\"(src/test/resources/feature/mantenimientoData.feature:84)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "ingreso la \"5443599980074715\" y el \"2000\" en \"soles\" al servicio",
  "keyword": "Cuando "
});
formatter.match({
  "location": "mantenimientoDataDefinition.ingresoLaElYElEn(String,String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "ejecuto el servicio de consumo",
  "keyword": "Entonces "
});
formatter.match({
  "location": "mantenimientoDataDefinition.ejecutoElServicioDeConsumo()"
});
formatter.result({
  "status": "skipped"
});
});