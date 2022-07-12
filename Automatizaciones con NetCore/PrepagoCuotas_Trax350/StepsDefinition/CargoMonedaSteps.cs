using System;
using System.Threading;
using PrepagoCuotas_Trax350.Tasks;
using PrepagoCuotas_Trax350.Tasks.Content.Transaccion.Transaccion350;
using PrepagoCuotas_Trax350.Util;
using TechTalk.SpecFlow;

namespace PrepagoCuotas_Trax350.StepsDefinition
{
    [Binding]
    public class CargoMonedaSteps
    {
        utilidad util = new utilidad();

        [When(@"selecciona medio de cargo (.*), el tipo_moneda (.*) y aceptamos la transacción")]
        public void WhenSeleccionaMedioDeCargoElTipo_MonedaYAceptamosLaTransaccion(string CARGO, string MONEDA)
        {
            util.configSteps("Web");
            Thread.Sleep(3000);
            AceptaSimulacion acepsimulacion = new AceptaSimulacion();
            acepsimulacion.AceptoSimulacion(CARGO, MONEDA);
            util.capturaWeb();
            utilidad.tiempoEspera();
            loginAceptarTransactor aceptar = new loginAceptarTransactor();
            aceptar.btnAceptar();
        }
    }
}
