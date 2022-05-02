package definitions.MAINFRAME;
import Mainframe.AccessObjects.TarjetaInterbankInterface;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.es.Entonces;
import org.junit.Assert;
import tools.SessionManager;
public class TarjetaInterbankDefinition {
    TarjetaInterbankInterface tarjetaInterbankInterface=new TarjetaInterbankInterface();
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
    @Entonces("^realizo la consulta de la tarjeta \"([^\"]*)\" en Systematics$")
    public void realizoLaConsultaDeLaEnTRJSystematics(String tarjeta) throws Throwable {
        Assert.assertTrue(tarjetaInterbankInterface.realizoLaConsultaDeLaEnTRJSystematics(tarjeta));
    }
}
