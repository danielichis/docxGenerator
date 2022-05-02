package definitions.MAINFRAME;

import Mainframe.AccessObjects.accessInterface;
import Mainframe.AccessObjects.helperInterface;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.es.E;
import tools.sessionManager;

import Mainframe.AccessObjects.cicsAdministrativoInterface;

public class cicsAdministrativoDefinition {

    accessInterface AccessInterface=new accessInterface();
    cicsAdministrativoInterface CicsAdministrativoInterface = new cicsAdministrativoInterface();
    helperInterface HelperInterface = new helperInterface();
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



    @E("^ingreso las credenciales e inicio sesion en CICS$")

    public void ingresoLasCredencialesEInicioSesionEnCICS() throws InterruptedException {
        CicsAdministrativoInterface.ingresoLasCredencialesEInicioSesionEnCICS();
    }



    @E("^ingreso a la aplicacion \"([^\"]*)\" dentro de CICS$")
    public void ingresoALaAplicacionDentroDeCICS(String aplicacion) throws Throwable {
        CicsAdministrativoInterface.ingresoALaAplicacionDentroDeCICS(aplicacion);
        HelperInterface.validoMensajeUnicoPorAplicacion(aplicacion);

    }
}
