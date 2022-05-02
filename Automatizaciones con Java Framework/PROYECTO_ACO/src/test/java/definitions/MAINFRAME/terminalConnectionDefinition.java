package definitions.MAINFRAME;

import Mainframe.AccessObjects.loginInterface;
//import com.eviware.soapui.model.iface.Request;
//import com.eviware.soapui.support.SoapUIException;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.es.Dado;

import cucumber.api.java.es.Y;
//import org.apache.xmlbeans.XmlException;
import tools.sessionManager;

import java.io.IOException;

public class terminalConnectionDefinition {

    loginInterface LoginInterface=new loginInterface();


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

    @Dado("^que accedo a Access en mainframe$")
    public void queAccedoAAccessEnMainframe() throws InterruptedException {
        LoginInterface.queAccedoAAccessEnMainframe();

    }


    @Y("^obtengo detalles del pdf$")
    public void obtengoDetallesDelPdf() throws IOException {
        LoginInterface.obtengoDetallesDelPdf();
    }


}
