package definitions.MAINFRAME;
import Mainframe.AccessObjects.AccessInterface;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Y;
import org.junit.Assert;
import tools.SessionManager;
public class AccessDefinition {
    AccessInterface accessInterface=new AccessInterface();
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
    @Dado("^que ingreso las credenciales e inicio sesion en Access$")
    public void queIngresoLasCredencialesEInicioSesionEnAccess() throws InterruptedException {
        Assert.assertTrue(accessInterface.queIngresoLasCredencialesEInicioSesionEnMainframe());
    }
    @Y("^accedo a la aplicacion \"([^\"]*)\" dentro de Access$")
    public void accedoALaAplicacionDentroDeAccess(String aplicacion) throws Throwable {
        accessInterface.accedoALaAplicacionDentroDeAccess(aplicacion);
    }
}
