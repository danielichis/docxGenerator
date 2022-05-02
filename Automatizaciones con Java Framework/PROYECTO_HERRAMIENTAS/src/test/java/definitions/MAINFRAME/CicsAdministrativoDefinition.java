package definitions.MAINFRAME;
import Mainframe.AccessObjects.AccessInterface;
import Mainframe.AccessObjects.HelperInterface;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.es.E;
import tools.SessionManager;

import Mainframe.AccessObjects.CicsAdministrativoInterface;
public class CicsAdministrativoDefinition {
    CicsAdministrativoInterface cicsInterface= new CicsAdministrativoInterface();
    HelperInterface helperInterface = new HelperInterface();
    private Scenario myScenario;
    @Before
    public void before(Scenario scenario) {
        if (SessionManager.obternerSesion("scenario")==null){
            SessionManager.GuardarSesion("scenario", scenario);
            myScenario = scenario;
        }else {
            myScenario = SessionManager.obternerSesion("scenario");
        }
    }

    @E("^ingreso las credenciales e inicio sesion en CICS$")
    public void ingresoLasCredencialesEInicioSesionEnCICS() throws InterruptedException {
        cicsInterface.ingresoLasCredencialesEInicioSesionEnCICS();
    }

    @E("^ingreso a la aplicacion \"([^\"]*)\" dentro de CICS$")
    public void ingresoALaAplicacionDentroDeCICS(String aplicacion) throws Throwable {
        cicsInterface.ingresoALaAplicacionDentroDeCICS(aplicacion);
        helperInterface.validoMensajeUnicoPorAplicacion(aplicacion);
    }
}