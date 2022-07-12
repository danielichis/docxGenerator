package Interbank.com.pe.stepdefinition;

import Interbank.com.pe.Task.Servicios.JavaAutomatizacion;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import Interbank.com.pe.Tool.SessionManager;
import Interbank.com.pe.Tool.services.Hooks;


public class mantenimientoDataDefinition {
    Interbank.com.pe.Tool.services.Hooks Hooks = new Hooks();
    JavaAutomatizacion data = new JavaAutomatizacion();
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

    @Y("^consulto la deuda del \"([^\"]*)\" con \"([^\"]*)\"$")
    public void consultoLaDeudaDelCon(String tarjeta, String codigo) {
        data.consultarMontos(tarjeta, codigo);
    }

    @Cuando("^obtengo los montos$")
    public void obtengoLosMontos() {
        data.obtenerMontos();
    }


    @Cuando("^ingreso la \"([^\"]*)\" y el \"([^\"]*)\" en \"([^\"]*)\" al servicio$")
    public void ingresoLaElYElEn(String tarjeta, String monto, String moneda) throws Throwable {
        data.consumo(tarjeta, monto, moneda);
    }

    @Entonces("^ejecuto el servicio de consumo$")
    public void ejecutoElServicioDeConsumo() {
    }

    @Entonces("^realizo el <\"([^\"]*)\">$")
    public void realizoEl(String tPago) throws Throwable {
        data.realizoAbono(tPago);
    }

    @Dado("^que el dia de hoy es \"([^\"]*)\"$")
    public void queElDiaDeHoyEs(String dia) throws Throwable {
        data.obtenerDia(dia);
    }
}
