package Interbank.com.pe.stepdefinition;

import Interbank.com.pe.Task.Servicios.JavaAutomatizacion;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import Interbank.com.pe.Tool.SessionManager;
import Interbank.com.pe.Tool.services.Hooks;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;

import java.io.IOException;

public class PagoMinFullDefinition {
    Interbank.com.pe.Tool.services.Hooks Hooks = new Hooks();

    JavaAutomatizacion pago = new JavaAutomatizacion();
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

    @Dado("^que realizo la consulta del \"([^\"]*)\" y el \"([^\"]*)\"$")
    public void realizarConsulta(String pan, String codigo) {
        pago.consultarMontos(pan, codigo);
    }

    @Y("^obtengo detalles de los montos a pagar")
    public void obtengoDetalle() {
        pago.obtenerMontos();
    }


    @Cuando("^realizo el abono correspondiente en \"([^\"]*)\"$")
    public void realizoElAbonoCorrespondienteEn(String tipoP)  {
        pago.realizoAbono(tipoP);
    }

    @Entonces("^realizo el abono correspondiente en \"([^\"]*)\" y \"([^\"]*)\"$")
    public void realizoElAbonoCorrespondienteEnY(String tipoP, String tipoP2) {
        pago.realizoAbonos(tipoP, tipoP2);

    }

    @Entonces("^reviso los movimientos del contrato.$")
    public void revisoLosMovimientosDelContrato() throws IOException {
        pago.revisarMovimientos();
    }

    @Y("^que el dia de hoy es la fecha de pago$")
    public void queElDiaDeHoyEs() {
        pago.obtenerFecha();
    }

}
