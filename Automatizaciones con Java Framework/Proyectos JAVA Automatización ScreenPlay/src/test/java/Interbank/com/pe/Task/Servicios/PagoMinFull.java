package Interbank.com.pe.Task.Servicios;

import Interbank.com.pe.Util.HelperServices;
import io.restassured.response.Response;
import Interbank.com.pe.Util.UserDetails;
import Interbank.com.pe.Util.metodosAdicionales;
import org.apache.commons.io.IOUtils;
import org.json.simple.JSONObject;
import org.junit.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class PagoMinFull extends HelperServices {

    metodosAdicionales metodos =  new metodosAdicionales();
    HashMap<String, String> responseTramas = new HashMap<>();
    UserDetails ApiModels= new UserDetails();

    String minSol = "0.00";
    String fullSol = "0.00";
    String minDol = "0.00";
    String fullDol = "0.00";
    String contrato = "000000000000";
    String tarjeta = "000000000000000";
    String estado = "";

    public void consultarMontos(String tarjeta, String codigounico)  {

        JSONObject header = new JSONObject();

        header.put("X-IBM-Client-Id", "a3a383ba-3d4d-4a35-a85e-0cd0f09eae26");
        header.put("X-INT-Branch-Id", "100");
        header.put("X-INT-CardId-Type", "1");
        header.put("X-INT-Consumer-Id", "FTI");
        header.put("X-INT-Message-Id", "202244291744564");
        header.put("X-INT-Net-Id", "TD");
        header.put("X-INT-Service-Id", "SAT");
        header.put("X-INT-Supervisor-Id", "BUSSPWP");
        header.put("X-INT-Timestamp", "2022-01-06T02:36:50.852Z");
        header.put("X-INT-User-Id", "S38504");
        header.put("Authorization", "Basic dUJzZUdlblVhdDpJYmsyMDE4JA==");

        JSONObject body = new JSONObject();

        this.tarjeta = tarjeta;
        String pan = metodos.truncarPAN(tarjeta).trim();
        String coduni = codigounico;
        String link = "https://dpiuat.grupoib.local:7020/ibk/uat/api/credit-card/v3/";
        String url = link + pan;

        Response response=executeGetApiServicesRequest(url,
                body,
                header,
                coduni
        );

        ApiModels.setResponseCollection(
                "minimumAmountSoles",
                response.jsonPath().getJsonObject("payment.minimumAmountSoles")
        );
        ApiModels.setResponseCollection(
                "totalAmountSoles",
                response.jsonPath().getJsonObject("payment.totalAmountSoles")
        );
        ApiModels.setResponseCollection(
                "minimumAmountDollars",
                response.jsonPath().getJsonObject("payment.minimumAmountDollars")
        );
        ApiModels.setResponseCollection(
                "totalAmountDollars",
                response.jsonPath().getJsonObject("payment.totalAmountDollars")
        );
        ApiModels.setResponseCollection(
                "contractNumber",
                response.jsonPath().getJsonObject("account.contractNumber")
        );

        if (response.getStatusCode() == 200){
            Interbank.com.pe.Tool.services.Hooks.setEvidence("Status CODE del servicio: " + response.getStatusCode());;
            Interbank.com.pe.Tool.services.Hooks.setEvidence("RESPONSE:");
            Interbank.com.pe.Tool.services.Hooks.setEvidence(response.prettyPrint());
        } else {
            Interbank.com.pe.Tool.services.Hooks.setEvidence("Status CODE del servicio: " + response.getStatusCode());
            Interbank.com.pe.Tool.services.Hooks.setEvidence("RESPONSE: " + response.getBody().prettyPrint());
            Assert.fail("El codigo del response es " + response.getStatusCode() + " que indica error, revisar la información ingresada.");

        }

    }

    public void obtenerMontos(){

        minSol = ApiModels.getResponseCollection("minimumAmountSoles");
        fullSol = ApiModels.getResponseCollection("totalAmountSoles");
        minDol = ApiModels.getResponseCollection("minimumAmountDollars");
        fullDol = ApiModels.getResponseCollection("totalAmountDollars");
        contrato = ApiModels.getResponseCollection("contractNumber");

        if (minSol.equals("0.00") && fullSol.equals("0.00") && minDol.equals("0.00") && fullDol.equals("0.00")){
            Interbank.com.pe.Tool.services.Hooks.setEvidence("Monto minimo en soles: " + minSol);
            Interbank.com.pe.Tool.services.Hooks.setEvidence("Monto full en soles: " + fullSol);
            Interbank.com.pe.Tool.services.Hooks.setEvidence("Monto minimo en dolares: " + minDol);
            Interbank.com.pe.Tool.services.Hooks.setEvidence("Monto full en dolares: " + fullDol);
            Assert.fail("No se obtuvieron montos que pagar, no se realizara el abono.");
        }else{
            Interbank.com.pe.Tool.services.Hooks.setEvidence("Se cargaron los montos correctamente.");
            Interbank.com.pe.Tool.services.Hooks.setEvidence("Monto minimo en soles: " + minSol);
            Interbank.com.pe.Tool.services.Hooks.setEvidence("Monto full en soles: " + fullSol);
            Interbank.com.pe.Tool.services.Hooks.setEvidence("Monto minimo en dolares: " + minDol);
            Interbank.com.pe.Tool.services.Hooks.setEvidence("Monto full en dolares: " + fullDol);
        }

    }

    public void realizoAbono(String tipoP) throws IOException {

        try {
            String uri = "https://dpisit.grupoib.local:5200/ibk/srv/MPO/Colocaciones/proceso.abonarTarjetaCredito/v1.0";
            String enM = "";

            FileInputStream tramaconsulta = new FileInputStream(new File("src/test/java/providers/uat/abonarTarjetaCredito.xml"));
            String tramaOriginal = IOUtils.toString(tramaconsulta, "UTF-8");

            SimpleDateFormat format1= new SimpleDateFormat("yyyyMMddHHmmssZZZZ");
            SimpleDateFormat format2= new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

            Date date = new Date(System.currentTimeMillis());

            String TF1 = tramaOriginal.replace("fechaMessage", format1.format(date));
            TF1 = TF1.replace("fechaTime", format2.format(date));
            TF1 = TF1.replace("PAN", tarjeta);
            TF1 = TF1.replace("numCuenta", contrato);

            if (tipoP.equals("pagMinS")){
                TF1 = TF1.replace("codMoP", "001");
                TF1 = TF1.replace("monTr", "001");
                TF1 = TF1.replace("impTr", minSol);
                TF1 = TF1.replace("impPa", minSol);
            } else if (tipoP.equals("pagMinD")){
                TF1 = TF1.replace("codMoP", "010");
                TF1 = TF1.replace("monTr", "010");
                TF1 = TF1.replace("impTr", minDol);
                TF1 = TF1.replace("impPa", minDol);
            } else if (tipoP.equals("pagFullS")){
                TF1 = TF1.replace("codMoP", "001");
                TF1 = TF1.replace("monTr", "001");
                TF1 = TF1.replace("impTr", fullSol);
                TF1 = TF1.replace("impPa", fullSol);
            } else if (tipoP.equals("pagFullD")){
                TF1 = TF1.replace("codMoP", "010");
                TF1 = TF1.replace("monTr", "010");
                TF1 = TF1.replace("impTr", fullDol);
                TF1 = TF1.replace("impPa", fullDol);
            } else if (tipoP.equals("pagMenorMinS")){
                TF1 = TF1.replace("codMoP", "001");
                TF1 = TF1.replace("monTr", "001");
                TF1 = TF1.replace("impTr", metodos.menorMin(minSol));
                TF1 = TF1.replace("impPa", metodos.menorMin(minSol));
            } else if (tipoP.equals("pagMenorMinD")){
                TF1 = TF1.replace("codMoP", "010");
                TF1 = TF1.replace("monTr", "010");
                TF1 = TF1.replace("impTr", metodos.menorMin(minDol));
                TF1 = TF1.replace("impPa", metodos.menorMin(minDol));
            } else if (tipoP.equals("pagMayorFullS")){
                TF1 = TF1.replace("codMoP", "001");
                TF1 = TF1.replace("monTr", "001");
                TF1 = TF1.replace("impTr", metodos.mayorFull(minSol, fullSol));
                TF1 = TF1.replace("impPa", metodos.mayorFull(minSol, fullSol));
            } else if (tipoP.equals("pagMayorFullD")){
                TF1 = TF1.replace("codMoP", "010");
                TF1 = TF1.replace("monTr", "010");
                TF1 = TF1.replace("impTr", metodos.mayorFull(minDol, fullDol));
                TF1 = TF1.replace("impPa", metodos.mayorFull(minDol, fullDol));
            } else if (tipoP.equals("pagEntreMinFullS")){
                TF1 = TF1.replace("codMoP", "001");
                TF1 = TF1.replace("monTr", "001");
                TF1 = TF1.replace("impTr", enM = metodos.mayorMinmenorFull(minSol, fullSol));
                TF1 = TF1.replace("impPa", enM );
            } else if (tipoP.equals("pagEntreMinFullD")){
                TF1 = TF1.replace("codMoP", "010");
                TF1 = TF1.replace("monTr", "010");
                TF1 = TF1.replace("impTr", enM = metodos.mayorMinmenorFull(minDol, fullDol));
                TF1 = TF1.replace("impPa", enM);
            } else {
                estado = "error en este paso";
                System.out.println(estado);
            }

            // Hashmap para crear el header
            HashMap headermap = new HashMap<>();
            headermap.put("Content-Type", "text/xml");
            headermap.put("SOAPAction", "http://interbank.com.pe/service/MPO/Colocaciones/proceso.abonarTarjetaCredito/v1.0/");

            // Metodo para ejecutur el servicio soap
            String response = executeSOAPServicesRequest(
                    "",
                    uri,
                    "",
                    TF1,
                    headermap
            );

            responseTramas.put("abonoTrama", response);
            System.out.println(response);

            if (response.contains("OCURRIO UN ERROR AL PROCESAR EL MENSAJE")){
                Interbank.com.pe.Tool.services.Hooks.setEvidence("Error durante la ejecución");
                Interbank.com.pe.Tool.services.Hooks.setEvidence(response);
                Assert.fail("Error durante la ejecución, se debe revisar.");
            } else {
                Interbank.com.pe.Tool.services.Hooks.setEvidence("Se realizo la ejecución.");
                Interbank.com.pe.Tool.services.Hooks.setEvidence("RESPONSE:");
                Interbank.com.pe.Tool.services.Hooks.setEvidence(response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Error al realizar el abono, favor de revisar");

        }

    }

    public void realizoAbonos(String tipoP, String tipoP2) throws IOException {

        if (tipoP.equals("pagMinS") && tipoP2.equals("pagFullD")) {
            realizoAbono("pagMinS");
            realizoAbono("pagFullD");
        } else if(tipoP.equals("pagMinD") && tipoP2.equals("pagFullS")){
            realizoAbono("pagMinD");
            realizoAbono("pagFullS");
        } else {
            estado = "Error en este paso";
            System.out.println(estado);
            Assert.fail("ERROR!");
        }

    }

    public void revisarMovimientos() throws IOException {

            if (estado.equals("error en este paso")){
                System.out.println("No se realizo el abono, no se realiza la consultar; favor de revisar");

                String uri = "https://dpiuat.grupoib.local:7200/ibk/srv/MPO/Colocaciones/tarjeta.consultarMovimientosTC/v1.0";

                FileInputStream tramaconsulta = new FileInputStream(new File("src/test/java/providers/uat/consultaMovimientos.xml"));
                String tramaOriginal = IOUtils.toString(tramaconsulta, "UTF-8");

                String TF = tramaOriginal.replace("cardNumber", tarjeta);

                // Hashmap para crear el header
                HashMap headermap = new HashMap<>();
                headermap.put("Content-Type", "text/xml");
                headermap.put("SOAPAction", "http://interbank.com.pe/service/MPO/Colocaciones/tarjeta.consultarMovimientosTC/v1.0/");

                // Metodo para ejecutura el soap
                String response = executeSOAPServicesRequest(
                        "",
                        uri,
                        "",
                        TF,
                        headermap
                );

                responseTramas.put("consultaTrama", response);
                System.out.println(response);

                if (response.contains("OCURRIO UN ERROR AL PROCESAR EL MENSAJE")){
                    Interbank.com.pe.Tool.services.Hooks.setEvidence("Error durante la ejecución");
                    Assert.fail("Error durante la ejecución, se debe revisar.");
                    Interbank.com.pe.Tool.services.Hooks.setEvidence(response);
                } else {
                    Interbank.com.pe.Tool.services.Hooks.setEvidence("Se realizo la ejecución.");
                    Interbank.com.pe.Tool.services.Hooks.setEvidence("RESPONSE:");
                    Interbank.com.pe.Tool.services.Hooks.setEvidence(response);
                }
            }
    }

    public void obtenerDia(String a){
        boolean resultado = metodos.obtenerDia(a.toLowerCase());

        if (resultado == true){
            Interbank.com.pe.Tool.services.Hooks.setEvidence("Se ejecuta el caso, el día indicado es el de hoy.");
        } else {
            Assert.fail("No se ejecuta el caso, ya que el día indicado no es mismo de hoy.");
        }
    }

}