package Interbank.com.pe.Tool;
import cucumber.api.Scenario;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
public class SessionManager {
    public static Scenario scenario;
    public static void GuardarSesion(String key, Object value) {
        Serenity.setSessionVariable(key).to(value);
    }
    public static <T> T obternerSesion(String key) {
        return Serenity.sessionVariableCalled(key);
    }
    public String getSerenityParams(String key){
        EnvironmentVariables variables= SystemEnvironmentVariables.createEnvironmentVariables();
        return variables.getProperty(key);
    }
}
