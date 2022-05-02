package definitions.MAINFRAME;
import Mainframe.AccessObjects.SystematicsInterface;
import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.es.E;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import org.json.simple.parser.ParseException;
import tools.SessionManager;

import java.io.IOException;
import java.util.List;
import java.util.Map;
public class SystematicsDefinition {
    private Scenario myScenario;
    SystematicsInterface systematicsInterface= new SystematicsInterface();
    @Before
    public void before(Scenario scenario) {
        if (SessionManager.obternerSesion("scenario")==null){
            SessionManager.GuardarSesion("scenario", scenario);
            myScenario = scenario;
        }else {
            myScenario = SessionManager.obternerSesion("scenario");
        }
    }
    @Entonces("^realizo la creacion de \"([^\"]*)\" clientes con tipo documento \"([^\"]*)\"$")
    public void realizoLaCreacionDeClientesConTipoDocumento(String numeroClientesCrear, String documento) throws InterruptedException, IOException, ParseException {
        systematicsInterface.realizoLaCreacionDeClientesConTipoDocumento(numeroClientesCrear,documento);
    }
    @Y("^realizo el alta de \"([^\"]*)\" campanas con tipo tarjeta \"([^\"]*)\" de la marca \"([^\"]*)\" para clientes nuevos con linea de credito \"([^\"]*)\"$")
    public void realizoElAltaDeCampanasConTipoTarjetaDeLaMarcaParaClientesNuevosConLineaDeCredito(String numero, String tipoTarjeta, String marca,String lineaCredito) throws Throwable {
        systematicsInterface.realizoLaCreacionDeClientesConTipoDocumento(numero,"DNI");
        systematicsInterface.realizoElAltaDeCampanasConTipoTarjetaDeLaMarca(tipoTarjeta,marca,lineaCredito);
    }
    @Y("^realizo el alta de \"([^\"]*)\" campañas con tipo tarjeta \"([^\"]*)\" de la marca \"([^\"]*)\" para clientes existentes con inicial dni \"([^\"]*)\" con linea de credito \"([^\"]*)\"$")
    public void realizoElAltaDeCampañasConTipoTarjetaDeLaMarcaParaClientesExistentesConInicialDniConLineaDeCredito(String numero, String tipoTarjeta, String marca,String dniInicial,String lineaCredito )throws Throwable {
        systematicsInterface.realizoElAltaDeCampañasConTipoTarjetaDeLaMarcaParaClientesExistentesConLineaDeCredito(numero,tipoTarjeta,marca,dniInicial,lineaCredito);
    }
    @Y("^realizo la creación de \"([^\"]*)\" cuentas de tipo \"([^\"]*)\" para el documento \"([^\"]*)\"$")
    public void realizoLaCreaciónDeCuentasDeTipoParaElDocumento(String numeroCrear, String tipoCuenta, String documento) throws Throwable {
        systematicsInterface.realizoLaCreaciónDeCuentasDeTipoParaElDocumento(numeroCrear,tipoCuenta,documento);
    }
    @E("^ingreso el codigo identidad \"([^\"]*)\", tipo moneda \"([^\"]*)\", la oficina \"([^\"]*)\", tipo producto \"([^\"]*)\"$")
    public void ingresoElCodigoIdentidadTipoMonedaLaOficinaTipoProducto(String codigoIdentidad, String tipoMoneda, String oficina, String tipoProducto) throws Throwable {
        systematicsInterface.ingresoElCodigoIdentidadTipoMonedaLaOficinaTipoProducto(codigoIdentidad,tipoMoneda,oficina,tipoProducto);
    }
    @Entonces("^ingreso el tipo COD CONECCION \"([^\"]*)\", TIPO DE PROD \"([^\"]*)\"$")
    public void ingresoElTipoCODCONECCIONTIPODEPROD(String codConeccion, String tipoProd) throws Throwable {
        systematicsInterface.ingresoElTipoCODCONECCIONTIPODEPROD(codConeccion,tipoProd);

    }
    @Y("^realizo la consulta con el comando \"([^\"]*)\"$")
    public void realizoLaConsultaConElComando(String comando) throws Throwable {
        systematicsInterface.realizoLaConsultaConElComando(comando);
    }
    @Y("^realizo la consulta del tipo documento \"([^\"]*)\" con numero \"([^\"]*)\" en Systematics$")
    public void realizoLaConsultaDelTipoDocumentoConNumeroEnSystematics(String tipoDocumento, String nroDocumento) throws Throwable {
        systematicsInterface.realizoLaConsultaDelTipoDocumentoConNumeroEnSystematics(tipoDocumento,nroDocumento);
    }
    @Y("^realizo la consulta de la cuenta \"([^\"]*)\" en RMAB$")
    public void realizoLaConsultaDeLaCuentaEnRMAB(String cuenta) throws Throwable {
        systematicsInterface.realizoLaConsultaDeLaCuentaEnRMAB(cuenta);
    }
    @Y("^consulto STI o IMI \"([^\"]*)\" para las transacciones asociadas al Caso de Prueba \"([^\"]*)\"$")
    public void consultoSTIOIMIParaLasTransaccionesAsociadasAlCasoDePrueba(String grupo, String cuenta, DataTable data) throws Throwable {
        List<Map<String,String>> list=data.asMaps(String.class,String.class);
        for (Map<String,String> e : list){
            switch (grupo){
                case "2":
                    if (cuenta.toLowerCase().equals(e.get("caso").toLowerCase())){
                        systematicsInterface.consultarHistoricoCuenta(e.get("monto"),e.get("fechaTransaccion"),e.get("caso"));
                    }
                    break;
                case "3":
                    if (cuenta.toLowerCase().equals(e.get("caso").toLowerCase())){
                        systematicsInterface.consultarEstadoCuenta(e.get("monto"),e.get("fechaTransaccion"),e.get("caso"));
                    }
                    break;
                case "4":
                    systematicsInterface.consultarBalanceCuenta();
                    break;
                case "5":
                    if (cuenta.toLowerCase().equals(e.get("caso").toLowerCase())){
                        systematicsInterface.consultarRetenciones(e.get("monto"),e.get("fechaTransaccion"),e.get("caso"));
                    }
                    break;
            }
        }
    }
}


