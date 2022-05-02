package definitions.MAINFRAME;

import Mainframe.AccessObjects.accessInterface;
import Mainframe.AccessObjects.acoInterface;
import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.es.E;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import tools.sessionManager;

import java.io.IOException;

public class acoDefinition {

    acoInterface AcoInterface=new acoInterface();


    private Scenario myScenario;

    @Before
    public void before(Scenario scenario) {
        if (sessionManager.obternerSesion("scenario")==null){
            sessionManager.GuardarSesion("scenario", scenario);
            myScenario = scenario;
        }else {
            myScenario = sessionManager.obternerSesion("scenario");
        }
    }
//    @Y("^obtengo detalles del pdf$")
//    public void obtengoDetallesDelPdf() throws IOException {
//        LoginInterface.obtengoDetallesDelPdf();
//    }


    @E("^ingreso a la aplicacion \"([^\"]*)\" dentro del  SISTEMA ADMINISTRADOR DE CONTROVERSIAS$")
    public void ingresoALaAplicacionDentroDelSISTEMAADMINISTRADORDECONTROVERSIAS(String aplicacion) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        AcoInterface.ingresoALaAplicacionDentroDelSISTEMAADMINISTRADORDECONTROVERSIAS(aplicacion);
    }

    @Y("^realizo la consulta de la tarjeta \"([^\"]*)\"$")
    public void realizoLaConsultaDeLaTarjeta(String tarjeta) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        AcoInterface.realizoLaConsultaDeLaTarjeta(tarjeta);
    }

    @Y("^realizo la controversia de la transaccion \"([^\"]*)\"  con monto \"([^\"]*)\"$")
    public void realizoLaControversiaDeLaTransaccionConMonto(String transaccion, String monto) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        AcoInterface.realizoLaControversiaDeLaTransaccionConMonto(transaccion,monto);
    }



    @Entonces("^valido la alta de la controversia$")
    public void validoLaAltaDeLaControversia() throws InterruptedException {
        AcoInterface.validoLaAltaDeLaControversia();
    }

    @E("^ingreso el codigo reclamo \"([^\"]*)\" con codigo transaccion \"([^\"]*)\", codigo razon \"([^\"]*)\", ind\\.Doc \"([^\"]*)\", rz\\.msg frau \"([^\"]*)\"\\., y msj\\. texto \"([^\"]*)\"$")
    public void ingresoElCodigoReclamoConCodigoTransaccionCodigoRazonIndDocRzMsgFrauYMsjTexto(String codigoreclamo,String codigotransaccion, String codigorazon,String indDoc, String codigofraude, String mensaje) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        AcoInterface.ingresoElCodigoReclamoConCodigoTransaccionCodigoRazonRzMsgFrauYMsjTexto(codigoreclamo,codigotransaccion,codigorazon,indDoc,codigofraude,mensaje);

    }
}
