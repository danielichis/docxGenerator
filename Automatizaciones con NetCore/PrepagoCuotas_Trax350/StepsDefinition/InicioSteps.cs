using System;
using System.Threading;
using Dynamitey.Internal.Optimization;
using PrepagoCuotas_Trax350.Tasks;
using PrepagoCuotas_Trax350.Util;
using TechTalk.SpecFlow;

namespace PrepagoCuotas_Trax350.StepsDefinition
{
    [Binding]
    public class InicioSteps
    {
        utilidad util = new utilidad();

        [Given(@"que el (.*) ingresa al aplcativo Transactor")]
        public void GivenQueElUsuarioIngresaAlAplcativoTransactor(String usuario)
        {
            util.configSteps("Web");
            config url = new config();
            PagTransactor web = new PagTransactor();
            web.abrirWeb(url.urlTransactor);
        }
        
        [Given(@"inicia sesion digitando su contrasena (.*)")]
        public void GivenIniciaSesionDigitandoSuContrasenaCms(String psw)
        {
            util.configSteps("Web");

            loginComenzarTransactor login = new loginComenzarTransactor();
            utilidad.tiempoEspera();
            utilidad.tiempoEspera();
            utilidad.tiempoEspera();
            utilidad.tiempoEspera();
            utilidad.tiempoEspera();
            login.btnComenzar();

            loginPswTransactor loginWeb = new loginPswTransactor();
            utilidad.tiempoEspera();
            utilidad.tiempoEspera();
            loginWeb.ingresarPsw(psw);

            util.capturaWeb();
            loginAceptarTransactor aceptar = new loginAceptarTransactor();
            aceptar.btnAceptar();

        }
        
        [Given(@"seleciona la opcion transaccion (.*)")]
        public void GivenSelecionaLaOpcionTransaccion(string num)
        {
            util.configSteps("Web");
            Console.WriteLine("numero transaccion step:" + num);
            Thread.Sleep(8000);
            transaccionTransactor transaccion = new transaccionTransactor();
            transaccion.transacion(num);
            util.capturaWeb();
            util.escribirLog();
            Thread.Sleep(4000);
        }
    }
}
