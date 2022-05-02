package definitions.MAINFRAME;

import Mainframe.AccessObjects.accessInterface;
import Mainframe.AccessObjects.loginInterface;
import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Y;
import tools.sessionManager;

public class accessDefinition {

    accessInterface AccessInterface=new accessInterface();


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

    @Dado("^que ingreso las credenciales e inicio sesion en Access$")
    public void queIngresoLasCredencialesEInicioSesionEnAccess() throws InterruptedException {
        AccessInterface.queIngresoLasCredencialesEInicioSesionEnMainframe();
    }

    @Y("^accedo a la aplicacion \"([^\"]*)\" dentro de Access$")
    public void accedoALaAplicacionDentroDeAccess(String aplicacion) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        AccessInterface.accedoALaAplicacionDentroDeAccess(aplicacion);
    }
}
