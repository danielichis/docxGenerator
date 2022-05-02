package definitions.MAINFRAME;
import Mainframe.AccessObjects.AccessInterface;
import Mainframe.AccessObjects.CicsFinancieroInterface;
import Mainframe.AccessObjects.HelperInterface;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.es.E;
import cucumber.api.java.es.Entonces;
import tools.SessionManager;
public class CicsFinancieroDefinition {
   CicsFinancieroInterface cicsFinancieroInterface = new CicsFinancieroInterface();
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
    @E("^ingreso a RNC Simulator$")
    public void ingresoARNCSimulator() throws InterruptedException {
        cicsFinancieroInterface.ingresoARNCSimulator();
    }
    @Entonces("^realizo la consulta de la tarjeta \"([^\"]*)\" con fecha vencimiento \"([^\"]*)\", estructura \"([^\"]*)\", tipo lectura \"([^\"]*)\", programa \"([^\"]*)\", sysid \"([^\"]*)\", tran \"([^\"]*)\", lengthCommarea \"([^\"]*)\"$")
    public void realizoLaConsultaDeLaTarjetaConFechaVencimientoEstructuraTipoLecturaProgramaSysidTranLengthCommarea( String pan,String  fechaVencimiento ,String  estructura ,String  tipoLectura ,String  programa ,String  sysId ,String  tran ,String  lengthCommarea ) throws Throwable {
        cicsFinancieroInterface.configuroCabeceraSuperior(programa,sysId,tran,lengthCommarea);
        cicsFinancieroInterface.realizoLaConsulta(pan,fechaVencimiento,estructura,tipoLectura);
    }
}
