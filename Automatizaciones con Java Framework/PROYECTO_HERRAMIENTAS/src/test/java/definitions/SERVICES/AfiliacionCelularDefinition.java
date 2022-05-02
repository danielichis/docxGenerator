package definitions.SERVICES;
import Services.BPI_SOAP_Objects.AfiliacionNumeroCelular;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import org.json.simple.parser.ParseException;
import org.xml.sax.SAXException;
import tools.services.Hooks;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashMap;
public class AfiliacionCelularDefinition {
    AfiliacionNumeroCelular afiliacionNumeroCelular = new AfiliacionNumeroCelular();
    tools.services.Hooks Hooks= new Hooks();
    @Dado("^que realizo la consulta de afiliacion del \"([^\"]*)\" con el numero \"([^\"]*)\"$")
    public void realizarconsulta(String tipoconsulta, String numero) throws InterruptedException, IOException, ParserConfigurationException, SAXException, ParseException {
        afiliacionNumeroCelular.realizarconsulta(tipoconsulta, numero);
    }
    @Entonces("^obtengo detalles de la respuesta$")
    public void obtengoDetallesDeLaRespuesta() {
        HashMap<String, String> detalles = afiliacionNumeroCelular.obtengoDetallesDeLaRespuesta("consultaAfiliacion", "</afiliacionDetalle>");
        tools.services.Hooks.setEvidence(tools.services.Hooks.mapToString(detalles));
        Hooks.saveIntoLog("DETALLES " +"\n"+ tools.services.Hooks.mapToString(detalles));
    }
    @Y("^realizo la desafiliacion del codigo unico asociado de requerirse$")
    public void realizoLaDesafiliacionDelCodigoUnicoAsociadoDeRequerirse() throws IOException, ParseException {
       afiliacionNumeroCelular.realizoLaDesafiliacionDelCodigoUnicoAsociadoDeRequerirse();
    }
    @Entonces("^realizo la afiliacion del numero \"([^\"]*)\" con operador \"([^\"]*)\" al siguiente codigo unico \"([^\"]*)\"$")
    public void realizoLaAfiliacionDelNumeroConOperadorAlSiguienteCodigoUnico(String numero, String operador, String codigoUnico) throws Throwable {
        afiliacionNumeroCelular.realizoLaAfiliacionDelNumeroConOperadorAlSiguienteCodigoUnico(numero,operador,codigoUnico);
    }
}
