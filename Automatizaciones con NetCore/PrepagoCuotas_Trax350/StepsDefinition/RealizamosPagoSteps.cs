using System;
using System.Threading;
using PrepagoCuotas_Trax350.Tasks;
using PrepagoCuotas_Trax350.Tasks.Content.Transaccion.Transaccion350;
using PrepagoCuotas_Trax350.Util;
using TechTalk.SpecFlow;

namespace PrepagoCuotas_Trax350.StepsDefinition
{
    [Binding]
    public class RealizamosPagoSteps
    {
        utilidad util = new utilidad();

        [Then(@"se genera el pago correctamente")]
        public void ThenSeGeneraElPagoCorrectamente()
        {
            util.configSteps("Web");
            Thread.Sleep(3000);
            RealizamosPago rpago = new RealizamosPago();
            rpago.PagoRealizado();
            utilidad.tiempoEspera();
            utilidad.tiempoEspera();
            loginAceptarTransactor aceptar = new loginAceptarTransactor();
            aceptar.btnAceptar();
            utilidad.tiempoEspera();
            utilidad.tiempoEspera();
            Voucher avoucher = new Voucher();
            util.capturaWeb();
            avoucher.aceptavoucher();
            utilidad.tiempoEspera();
            avoucher.aceptavoucher();
            utilidad.tiempoEspera();
        }
    }
    }
