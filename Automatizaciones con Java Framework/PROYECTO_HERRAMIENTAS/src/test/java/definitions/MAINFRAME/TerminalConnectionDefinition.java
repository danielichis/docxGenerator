package definitions.MAINFRAME;
import Mainframe.AccessObjects.LoginInterface;
//import com.eviware.soapui.model.iface.Request;
//import com.eviware.soapui.support.SoapUIException;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.es.Dado;

import cucumber.api.java.es.Y;
//import org.apache.xmlbeans.XmlException;
import tools.SessionManager;

import java.io.IOException;
public class TerminalConnectionDefinition {
    LoginInterface loginInterface=new LoginInterface();
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
    @Dado("^que accedo a Access en mainframe$")
    public void queAccedoAAccessEnMainframe() throws InterruptedException {
        loginInterface.queAccedoAAccessEnMainframe();
    }

}
