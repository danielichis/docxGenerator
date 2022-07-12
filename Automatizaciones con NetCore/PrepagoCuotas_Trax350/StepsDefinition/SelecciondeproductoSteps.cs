using System;
using System.Threading;
using PrepagoCuotas_Trax350.Tasks.Content.Transaccion.Transaccion350;
using TechTalk.SpecFlow;
using PrepagoCuotas_Trax350.Util;
using PrepagoCuotas_Trax350.Tasks.Content.Transaccion.Transaccion510;
using OpenQA.Selenium;
using PrepagoCuotas_Trax350.Tasks;

namespace PrepagoCuotas_Trax350.Feature
{
    [Binding]
    public class SelecciondeproductoSteps

    {

        utilidad util = new utilidad();

        [When(@"se ingresa el numero de la tarjeta a prepagar (.*)")]
        public void WhenSeIngresaElNumeroDeLaTarjetaAPrepagar(string NUMTARJETA)
        {
            util.configSteps("Web");
            Thread.Sleep(3000);
            Transaccion350Transactor transaccion350 = new Transaccion350Transactor();
            transaccion350.IngresaTC(NUMTARJETA);
        }
        
        [When(@"se selecciona el tipo_de_producto (.*)")]
        public void WhenSeSeleccionaElTipo_De_Producto(string PRODUCTO)
        {
            util.configSteps("Web");
            SeleccionarTipoProducto transaccion350 = new SeleccionarTipoProducto();
            transaccion350.SelecProd(PRODUCTO);
            utilidad.tiempoEspera();
            utilidad.tiempoEspera();
            utilidad.tiempoEspera();
            utilidad.tiempoEspera();
            utilidad.tiempoEspera();
            util.capturaWeb();
            loginAceptarTransactor aceptar = new loginAceptarTransactor();
            aceptar.btnAceptar();
        }
    }
}
