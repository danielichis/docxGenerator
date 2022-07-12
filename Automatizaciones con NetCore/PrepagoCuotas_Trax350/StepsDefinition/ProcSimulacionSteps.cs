using System;
using System.Threading;
using PrepagoCuotas_Trax350.Tasks;
using PrepagoCuotas_Trax350.Tasks.Content.Transaccion.Transaccion350;
using PrepagoCuotas_Trax350.Util;
using TechTalk.SpecFlow;

namespace PrepagoCuotas_Trax350.StepsDefinition
{
    [Binding]
    public class ProcSimulacionSteps
    {
        utilidad util = new utilidad();

        [When(@"hacer una simulacion de tipo_pago (.*) y numero de cuotas (.*)")]
        public void WhenHacerUnaSimulacionDeTipo_PagoYNumeroDeCuotas(string TIPOPAGO, string NUMCUOTA)
        {
            util.configSteps("Web");
            Thread.Sleep(3000);
            SimularPrepago simuprepago = new SimularPrepago();
            simuprepago.SimulaPrepago(TIPOPAGO, NUMCUOTA);
            util.capturaWeb();
            utilidad.tiempoEspera();
            utilidad.tiempoEspera();
            utilidad.tiempoEspera();
            loginAceptarTransactor aceptar = new loginAceptarTransactor();
            aceptar.btnAceptar();

        }
    }
}
