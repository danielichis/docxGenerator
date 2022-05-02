package Mainframe.AccessObjects;

import models.UserDetails;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import tools.mainframe.helpers.HelperMainframe;
import tools.mainframe.Hooks;

import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

public class SystematicsInterface extends HelperMainframe {
    Hooks HooksMainframe = new Hooks();

    public void ingresarRMCA() throws InterruptedException {
        clear();
        writeTextIntoConsole("RMCA");
        enter();
        waitText("BUSQUEDA / UBICAR  CLIENTE", 9000);
    }

    public String getAletoryRucNumber() {
        String ruc = "";
        boolean correcto = false;
        //Indices RUC
        while (!correcto) {
            ruc = "";
            List<String> indicesRuc = Arrays.asList("20", "10", "15", "17");
            List<String> semillaRuc = Arrays.asList("5", "4", "3", "2", "7", "6", "5", "4", "3", "2", "0");

            ruc = ruc + indicesRuc.get(new Random()
                    .nextInt(3));
            ruc = ruc + getAletoryNumber(9);
            List<String> rucArray = Arrays.asList(ruc.split(""));
            //Validar Ruc
            int sumaProducto = 0;
            int ultimoDigitoGeneradoRuc = Integer.parseInt(rucArray.get(10));
            for (int i = 0; i < semillaRuc.size(); i++) {
                sumaProducto = sumaProducto + Integer.parseInt(semillaRuc.get(i)) * Integer.parseInt(rucArray.get(i));
            }
            int ultimoDigitoFormula = (11 - (sumaProducto - sumaProducto / 11 * 11));
            if (ultimoDigitoFormula == 10) {
                ultimoDigitoFormula = 0;
            }
            if (ultimoDigitoFormula == 11) {
                ultimoDigitoFormula = 1;
            }
            correcto = ultimoDigitoGeneradoRuc == ultimoDigitoFormula ? true : false;
        }

        return ruc;
    }

    public String getAletoryNumber(int digitos) {
        String numeroAletorio = "";
        if (digitos > 20) {
            Assert.fail("Supera el limite de dígitos");
        } else {
            numeroAletorio = String.valueOf(digitos < 1 ? 0 : new Random()
                    .nextInt((9 * (int) Math.pow(10, digitos - 1)) - 1)
                    + (int) Math.pow(10, digitos - 1));
        }
        return numeroAletorio;
    }

    public HashMap<String, String> getAletoryRucData() throws IOException, ParseException {
        HashMap<String, String> userMap = new HashMap<String, String>();
        JSONParser parser = new JSONParser();
        JSONArray jsonParse = (JSONArray) parser.parse(new FileReader("src/test/resources/data/systematics/companysDB.json"));
        for (int i = 0; i <= 1; i++) {
            JSONObject getData = (JSONObject) jsonParse.get(Integer.parseInt(getAletoryNumber(3)));
            switch (i) {
                case 0:
                    userMap.put("id", getData.get("id").toString().trim().toUpperCase());
                    userMap.put("nombre", getData.get("firstCompany").toString().trim().toUpperCase());
                    userMap.put("fecha", getData.get("date").toString().trim().toUpperCase());
                    userMap.put("localidad", getData.get("locate").toString().trim().toUpperCase());
                    userMap.put("numeroEmpleados", getData.get("employessNumber").toString().trim().toUpperCase());

                case 1:
                    String firstMap = userMap.get("nombre");
                    userMap.put("nombre", firstMap + getData.get("firstCompany").toString().trim().toUpperCase().substring(0, 2) + " SA");
            }
        }
        return userMap;
    }

    public HashMap<String, String> getAletoryUserData() throws IOException, ParseException {
        HashMap<String, String> userMap = new HashMap<String, String>();
        JSONParser parser = new JSONParser();
        JSONArray jsonParse = (JSONArray) parser.parse(new FileReader("src/test/resources/data/systematics/usersDB.json"));
        for (int i = 0; i <= 4; i++) {
            JSONObject getData = (JSONObject) jsonParse.get(Integer.parseInt(getAletoryNumber(3)));
            switch (i) {
                case 0:
                    userMap.put("id", getData.get("id").toString().trim().toUpperCase());
                    userMap.put("nombre", getData.get("first_name").toString().trim().toUpperCase());
                    userMap.put("sexo", getData.get("gender").toString().trim().toUpperCase());
                    userMap.put("email", getData.get("email").toString().trim().toUpperCase());
                    break;
                case 1:
                    userMap.put("apellidoPaterno", getData.get("last_name").toString().trim().toUpperCase());
                    break;
                case 2:
                    userMap.put("apellidoMaterno", getData.get("secont_name").toString().trim().toUpperCase());
                    break;
                case 3:
                    userMap.put("fechaNacimiento", getData.get("date").toString().trim().toUpperCase());
                    break;
                case 4:
                    userMap.put("localidad", getData.get("locate").toString().trim().toUpperCase());
                    break;
            }
        }
        return userMap;
    }


    public void realizoLaCreacionDeClientesConTipoDocumento(String numeroClientesCrear, String tipodocumento) throws InterruptedException, IOException, ParseException {
        UserDetails UserDetails = new UserDetails();
        int clientesCreados = 0;
        String numeroDocumento = "";
        while (!(Integer.parseInt(numeroClientesCrear) == clientesCreados)) {
            ingresarRMCA();
            String docNumber = "";
            String PC = "";
            switch (tipodocumento) {
                case "DNI":
                    docNumber = "1";
                    numeroDocumento = getAletoryNumber(8);
                    PC = "P";
                    break;
                case "RUC":
                    docNumber = "2";
                    numeroDocumento = getAletoryRucNumber();
                    PC = "C";
                    break;
            }
            //FLUJO
            //PANTALLA REGISTRAR DOCUMENTO
            tab();
            waitText("ok",2000);
            tab();
            waitText("ok",2000);
            writeTextIntoConsole(numeroDocumento);
            waitText("ok",2000);
            waitText("DOCUMENTO      " + String.valueOf(numeroDocumento), 9000);
            waitText("ok",2000);
            enter();
            waitText("ok",2000);
            //P/C
            writeTextIntoConsole(PC);
            waitText("ok",2000);
            waitText("P/C  " + PC, 9000);
            waitText("ok",2000);
            enter();
            waitText("ok",2000);

            //TIPO
            tab();  waitText("ok",2000);
            tab();  waitText("ok",2000);
            tab();  waitText("ok",2000);
            writeTextIntoConsole(docNumber);  waitText("ok",2000);
            waitText("TIPO " + docNumber, 9000);  waitText("ok",2000);
            enter();  waitText("ok",2000);
            pf(14);  waitText("ok",2000);
            UserDetails.clearUserDetails();
            if (docNumber == "1") {
                if (!flujoDNI()) {
                    UserDetails.clearUserDetails();
                    continue;
                }
            } else if (docNumber == "2") {
                if (!flujoRUC()) {
                    UserDetails.clearUserDetails();
                    continue;
                }
            }
            boolean isCreated = waitText("proceso completo", 9000);
            if (isCreated) {
                ingresarRMCA();
                waitText("MANTENIMIENTO DIRECCION DEL CLIENTE", 9000);
                tab();  waitText("ok",2000);
                tab();  waitText("ok",2000);
                writeTextIntoConsole(numeroDocumento);  waitText("ok",2000);
                waitText("DOCUMENTO      " + numeroDocumento, 9000);  waitText("ok",2000);
                enter();  waitText("ok",2000);
                //P/C
                writeTextIntoConsole(PC);  waitText("ok",2000);
                waitText("P/C  " + PC, 9000);  waitText("ok",2000);
                enter();  waitText("ok",2000);
                waitText("000000", 9000);  waitText("ok",2000);
                String pantallaActual = leerPantalla().toString();
                int intentos = 0;
                while (pantallaActual.length() < 10) {
                    pantallaActual = leerPantalla().toString();
                    intentos = +1;
                    if (intentos > 10) {
                        break;
                    }
                }
                String CU = (pantallaActual.substring(pantallaActual.indexOf("000000"), pantallaActual.indexOf("000000") + 14)).replace("000000", "").trim();
                clientesCreados += 1;
                System.out.println(numeroDocumento);
                System.out.println(CU);
                if (docNumber == "1") {
                    HooksMainframe.saveFacadeEvidence("(" + HooksMainframe.getSerenityParams("USER.MAINFRAME") + ") USUARIO CREADO-> " + "TIPO DOCUMENTO: " + tipodocumento +
                            " NUMERO DOCUMENTO: " + numeroDocumento +
                            " CU: " + CU + " con nombre: " + UserDetails.getUserDetails("nombre") + " " + UserDetails.getUserDetails("apellidoPaterno") + " " + UserDetails.getUserDetails("apellidoMaterno"), " CREACION CLIENTES SYSTEMATICS ", "dd-MM-yyyy", "hh:mm a");
                    UserDetails.setCreateUsers(numeroDocumento + "," + CU + "," + UserDetails.getUserDetails("nombre") + "," + UserDetails.getUserDetails("apellidoPaterno") + "," + UserDetails.getUserDetails("apellidoMaterno"));

                } else if (docNumber == "2") {
                    HooksMainframe.saveFacadeEvidence("(" + HooksMainframe.getSerenityParams("USER.MAINFRAME") + ") USUARIO CREADO-> " + "TIPO DOCUMENTO: " + tipodocumento +
                            " NUMERO DOCUMENTO: " + numeroDocumento +
                            " CU: " + CU + " con nombre Empresa: " + UserDetails.getUserDetails("nombre"), " CREACION CLIENTES SYSTEMATICS ", "dd-MM-yyyy", "hh:mm a");
                }
            } else {
                System.out.println("FAIL");
            }

            takeEvidence();

        }
    }

    public boolean flujoDNI() throws InterruptedException, IOException, ParseException {
        UserDetails UserDetails = new UserDetails();
        boolean docDisponible = waitText("1er nom", 9000);
        if (!docDisponible) {
            return false;
        }
        //PANTALLA AGREGAR DOCUMENTO
        tab();  waitText("ok",2000);
        tab();  waitText("ok",2000);
        tab();  waitText("ok",2000);
        tab();  waitText("ok",2000);
        HashMap<String, String> userMap = getAletoryUserData();
        writeTextIntoConsole(userMap.get("apellidoPaterno"));  waitText("ok",2000);
        waitText("AP. PAT.    " + userMap.get("apellidoPaterno"), 9000);
        UserDetails.setUserDetails("apellidoPaterno", userMap.get("apellidoPaterno"));
        tab();  waitText("ok",2000);
        writeTextIntoConsole(userMap.get("apellidoMaterno"));
        waitText("AP. MAT.    " + userMap.get("apellidoMaterno"), 9000);
        UserDetails.setUserDetails("apellidoMaterno", userMap.get("apellidoMaterno"));
        tab();  waitText("ok",2000);
        writeTextIntoConsole(userMap.get("nombre"));
        waitText("1ER NOM     " + userMap.get("nombre"), 9000);
        UserDetails.setUserDetails("nombre", userMap.get("nombre"));

        tab();  waitText("ok",2000);
        tab();  waitText("ok",2000);
        writeTextIntoConsole(userMap.get("localidad").split("-")[0].trim());  waitText("ok",2000);
        tab();  waitText("ok",2000);
        writeTextIntoConsole("A");

        writeTextIntoConsole(userMap.get("localidad").split("-")[1].trim());  waitText("ok",2000);
        tab();  waitText("ok",2000);
        writeTextIntoConsole("A");  waitText("ok",2000);

        down();  waitText("ok",2000);
        down();  waitText("ok",2000);
        tab();  waitText("ok",2000);
        writeTextIntoConsole(userMap.get("localidad").split("-")[2].trim());
        waitText("DISTRITO  " + userMap.get("localidad").split("-")[2].trim(), 9000);
        tab();  waitText("ok",2000);
        writeTextIntoConsole(userMap.get("localidad").split("-")[3].trim());
        waitText("PROVINCIA  " + userMap.get("localidad").split("-")[3].trim(), 9000);
        tab();  waitText("ok",2000);
        writeTextIntoConsole(userMap.get("localidad").split("-")[4].trim());
        waitText("DEPARTAM  " + userMap.get("localidad").split("-")[4].trim(), 9000);
        tab();  waitText("ok",2000);
        writeTextIntoConsole(userMap.get("localidad").split("-")[5].trim());
        waitText("COD POSTAL " + userMap.get("localidad").split("-")[5].trim(), 9000);

        enter();  waitText("ok",2000);
        writeTextIntoConsole("RMC3");
        waitText("DATOS SOBRE EL CLIENTE", 9000);
        enter();  waitText("ok",2000);
        tab();  waitText("ok",2000);
        tab();  waitText("ok",2000);
        writeTextIntoConsole("U");
        tab();  waitText("ok",2000);
        writeTextIntoConsole(userMap.get("fechaNacimiento"));
        writeTextIntoConsole(userMap.get("sexo"));
        tab();  waitText("ok",2000);
        tab();  waitText("ok",2000);
        writeTextIntoConsole("U");
        enter();  waitText("ok",2000);
        return true;

    }

    public boolean flujoRUC() throws InterruptedException, IOException, ParseException {
        UserDetails UserDetails = new UserDetails();
        boolean docDisponible = waitText("NBRE", 9000);
        if (!docDisponible) {
            return false;
        }
        //PANTALLA AGREGAR DOCUMENTO
        tab();  waitText("ok",2000);
        tab();  waitText("ok",2000);
        tab();  waitText("ok",2000);
        tab();  waitText("ok",2000);
        HashMap<String, String> userMap = getAletoryRucData();
        writeTextIntoConsole(userMap.get("nombre"));  waitText("ok",2000);
        waitText("NBRE  " + userMap.get("nombre"), 9000);
        UserDetails.setUserDetails("nombre", userMap.get("nombre"));
        down();  waitText("ok",2000);
        down();  waitText("ok",2000);
        down();  waitText("ok",2000);
        down();  waitText("ok",2000);
        tab();  waitText("ok",2000);

        writeTextIntoConsole(userMap.get("localidad").split("-")[0].trim());
        waitText("DIR   " + userMap.get("localidad").split("-")[0].trim(), 9000);
        tab();  waitText("ok",2000);
        writeTextIntoConsole("A");  waitText("ok",2000);

        writeTextIntoConsole(userMap.get("localidad").split("-")[1].trim());  waitText("ok",2000);
        tab();  waitText("ok",2000);
        writeTextIntoConsole("A");  waitText("ok",2000);

        down();  waitText("ok",2000);
        down();  waitText("ok",2000);
        tab();  waitText("ok",2000);
        writeTextIntoConsole(userMap.get("localidad").split("-")[2].trim());
        waitText("DISTRI    " + userMap.get("localidad").split("-")[2].trim(), 9000);
        tab();  waitText("ok",2000);
        writeTextIntoConsole(userMap.get("localidad").split("-")[3].trim());
        waitText("PROVINCIA  " + userMap.get("localidad").split("-")[3].trim(), 9000);
        tab();  waitText("ok",2000);
        writeTextIntoConsole(userMap.get("localidad").split("-")[4].trim());
        waitText("DEPART    " + userMap.get("localidad").split("-")[4].trim(), 9000);
        tab();  waitText("ok",2000);
        writeTextIntoConsole(userMap.get("localidad").split("-")[5].trim());
        waitText("COD POSTAL " + userMap.get("localidad").split("-")[5].trim(), 9000);

        enter();  waitText("ok",2000);
        boolean datosCliente = waitText("PROCESO COMPLETO ", 9000);
        if (datosCliente == false) {
            return false;
        }
        writeTextIntoConsole("RMC5");
        enter();  waitText("ok",2000);
        waitText("INFORMACION COMERCIAL DEL CLIENTE", 9000);
        tab();  waitText("ok",2000);
        tab();  waitText("ok",2000);
        writeTextIntoConsole("U");
        down();  waitText("ok",2000);
        down();  waitText("ok",2000);
        down();  waitText("ok",2000);
        down();  waitText("ok",2000);
        down();  waitText("ok",2000);
        down();  waitText("ok",2000);
        down();  waitText("ok",2000);
        down();  waitText("ok",2000);
        down();  waitText("ok",2000);
        down();  waitText("ok",2000);


        tab();  waitText("ok",2000);
        tab();  waitText("ok",2000);


        writeTextIntoConsole(userMap.get("fecha"));
        waitText("FCH CONST.  " + userMap.get("fecha"), 9000);
        writeTextIntoConsole(" ");
        tab();  waitText("ok",2000);
        String numeroEmpleados = userMap.get("numeroEmpleados");
        int cont = 9;
        cont = cont - numeroEmpleados.length();
        for (int i = 1; i <= cont; i++) {
            right();
        }
        writeTextIntoConsole(userMap.get("numeroEmpleados"));
        waitText(userMap.get("numeroEmpleados"), 9000);
        enter();  waitText("ok",2000);
        return true;

    }


    public void realizoElAltaDeCampanasConTipoTarjetaDeLaMarca(String tipoTarjeta, String marca, String lineadeCredito) throws IOException, ParseException {
        JSONObject node1 = getAttributesFromJson("src/test/resources/data/ASSI/cardParameters.json");
        JSONObject node2 = (JSONObject) node1.get("CARD");
        String number = getAletoryNumber(6);
        UserDetails UserDetails = new UserDetails();
        int operacion = 1;
        for (String e : UserDetails.getCreateUsers()) {
            String documento = e.split(",")[0];
            String cu = e.split(",")[1];
            String nombre = e.split(",")[2];
            String apellidoP = e.split(",")[3];
            String apellidoM = e.split(",")[4];
            String tipoDocumento = "01";

            JSONObject tarjetaNode = (JSONObject) node2.get(marca);
            JSONObject tipoTarjetaNode = (JSONObject) tarjetaNode.get(tipoTarjeta);

            String cadena = "1-330472831|||||1-330472865|" + tipoDocumento.trim() + "|" + documento.trim() + "|" +
                    cu.trim() + "|" + nombre + "||" + apellidoP + "|" + apellidoM +
                    "|||||||||||||||||||||||||||||||||||||||||||||||||||Aprobado|" + tipoTarjeta + "|" +
                    lineadeCredito + "|||||||||||||||||||||||01|" + tipoTarjetaNode.get("MARCATARJETA").toString().trim() + "|" +
                    tipoTarjetaNode.get("TIPOTARJETA").toString().trim() + "|01|" + lineadeCredito + "|" + tipoTarjetaNode.get("TASA1").toString().trim() +
                    "|" + tipoTarjetaNode.get("TASA2").toString().trim() + "|" + tipoTarjetaNode.get("TIPOCLIENTE").toString().trim() + "|" +
                    tipoTarjetaNode.get("CEM").toString().trim() + "|0|||||191101008001 |55|0|1|0|0||15000|" +
                    tipoTarjetaNode.get("FLUJOINGRESO").toString().trim() + "||||||1-330472831||" + lineadeCredito + "|" +
                    String.valueOf(operacion) + "|N|" + marca.trim() + "|" + tipoTarjeta.trim() + "|||||||||||||||||||||||" +
                    String.valueOf(operacion) + "|ASI=1";

            HooksMainframe.saveFacadeEvidence("(" + HooksMainframe.getSerenityParams("USER.MAINFRAME") + "): " + cadena, "CAMPAÑAS CREADAS", "MM-yyyy", "dd-MM-yyyy");

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            String time = sdf.format(date);
            HooksMainframe.saveIntoLog(cadena, "//grupoib.local/dfs3/CrmUat-Carga/SBL/Campanna/Lead", "SBL_CAMPANNA_" + time + "_MDP_" + HooksMainframe.getSerenityParams("USER.MAINFRAME") + "_id_" + number + "", "", "");
            operacion += 1;
        }
        UserDetails.clearCreateUsers();

    }

    public void realizoElAltaDeCampañasConTipoTarjetaDeLaMarcaParaClientesExistentesConLineaDeCredito(String numero, String tipoTarjeta, String marca, String dniInicial, String lineaCredito) throws InterruptedException, IOException, ParseException {
        String tipodocumento = "DNI";
        UserDetails UserDetails = new UserDetails();
        int clientesEncontrados = 0;
        int operacion = 1;
        String numeroOperacion = getAletoryNumber(8);
        String numeroDocumento = "";

        while (!(Integer.parseInt(numero) == clientesEncontrados)) {
            ingresarRMCA();
            String docNumber = "";
            String PC = "";
            switch (tipodocumento) {
                case "DNI":
                    docNumber = "1";
                    int cont = dniInicial.length();
                    int restante = 8 - cont;
                    if (!(restante == 0)) {
                        numeroDocumento = dniInicial + getAletoryNumber(8 - cont);
                    } else {
                        numeroDocumento = dniInicial;
                    }

                    PC = "P";
                    break;
                case "RUC":
                    docNumber = "2";
                    numeroDocumento = getAletoryRucNumber();
                    PC = "C";
                    break;
            }
            //FLUJO
            //PANTALLA REGISTRAR DOCUMENTO
            tab();  waitText("ok",2000);
            tab();  waitText("ok",2000);
            writeTextIntoConsole(numeroDocumento);  waitText("ok",2000);
            waitText("DOCUMENTO      " + String.valueOf(numeroDocumento), 9000);
            enter();  waitText("ok",2000);
            //P/C
            writeTextIntoConsole(PC);
            waitText("P/C  " + PC, 9000);
            enter();  waitText("ok",2000);
            UserDetails.clearUserDetails();
            if (docNumber == "1") {
                boolean documentoExistente = waitText("MANTENIMIENTO DIRECCION DEL CLIENTE", 10);
                if (!documentoExistente) {
                    continue;
                }
                writeTextIntoConsole("RM1P");
                enter();  waitText("ok",2000);
                if (!waitText("COMANDO ===> RM1P", 9000)) {
                    continue;
                }
                String pantallaString = leerPantalla().toString();
                if (!waitText("AP. PAT.", 9000)) {
                    System.out.println("ERROR CATCH NAME");
                    ;
                }
                String apellidoP = pantallaString.substring(pantallaString.indexOf("AP. PAT.") + "AP. PAT.".length(), pantallaString.indexOf("AP. PAT.") + 38);
                String apellidoM = pantallaString.substring(pantallaString.indexOf("AP. MAT.") + "AP. MAT.".length(), pantallaString.indexOf("AP. MAT.") + 38);
                String nombre1 = pantallaString.substring(pantallaString.indexOf("1ER NOM") + "1ER NOM".length(), pantallaString.indexOf("1ER NOM") + 38);
                String nombre2 = pantallaString.substring(pantallaString.indexOf("2DO NOM") + "2DO NOM".length(), pantallaString.indexOf("2DO NOM") + 38);
                String cu = (pantallaString.substring(pantallaString.indexOf("000000"), pantallaString.indexOf("000000") + 14)).replace("000000", "").trim();

                String tipoDocumento = "1";
                clientesEncontrados += 1;

                JSONObject node1 = getAttributesFromJson("src/test/resources/data/ASSI/cardParameters.json");
                JSONObject node2 = (JSONObject) node1.get("CARD");
                JSONObject tarjetaNode = (JSONObject) node2.get(marca);
                JSONObject tipoTarjetaNode = (JSONObject) tarjetaNode.get(tipoTarjeta);

                String cadena = "1-330472831|||||1-330472865|" + tipoDocumento.trim() + "|" + numeroDocumento.trim() + "|" +
                        cu.trim() + "|" + nombre1.trim() + "|" + nombre2.trim() + "|" + apellidoP.trim() + "|" + apellidoM.trim() +
                        "|||||||||||||||||||||||||||||||||||||||||||||||||||Aprobado|" + tipoTarjeta + "|" +
                        lineaCredito + "|||||||||||||||||||||||01|" + tipoTarjetaNode.get("MARCATARJETA").toString().trim() + "|" +
                        tipoTarjetaNode.get("TIPOTARJETA").toString().trim() + "|01|" + lineaCredito + "|" + tipoTarjetaNode.get("TASA1").toString().trim() +
                        "|" + tipoTarjetaNode.get("TASA2").toString().trim() + "|" + tipoTarjetaNode.get("TIPOCLIENTE").toString().trim() + "|" +
                        tipoTarjetaNode.get("CEM").toString().trim() + "|0|||||191101008001 |55|0|1|0|0||15000|" +
                        tipoTarjetaNode.get("FLUJOINGRESO").toString().trim() + "||||||1-330472831||" + lineaCredito + "|" +
                        String.valueOf(operacion) + "|N|" + marca.trim() + "|" + tipoTarjeta.trim() + "|||||||||||||||||||||||" +
                        String.valueOf(operacion) + "|ASI=1";

                HooksMainframe.saveFacadeEvidence("(" + HooksMainframe.getSerenityParams("USER.MAINFRAME") + ") (con clientes ya existentes): " + cadena, "CAMPAÑAS CREADAS", "MM-yyyy", "dd-MM-yyyy");

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date date = new Date();
                String time = sdf.format(date);

                HooksMainframe.saveIntoLog(cadena, "//grupoib.local/dfs3/CrmUat-Carga/SBL/Campanna/Lead", "SBL_CAMPANNA_" + time + "_MDP_" + HooksMainframe.getSerenityParams("USER.MAINFRAME") + "_id_" + numeroOperacion + "", "", "");
                operacion += 1;


            } else if (docNumber == "2") {

            }


        }


    }


    public boolean realizoLaConsultaDeLaCuentaEnRMAB(String cuenta) throws InterruptedException {
        home();
        writeTextIntoConsole("RMAB");
        enter();
        boolean pageRMAB = waitText("COMANDO ===> RMAB", 3000);
        if (pageRMAB == false) {
            takeEvidence();
            System.out.println("TIME ERROR RESPONSE");
            Assert.fail();
        }
        String catchScreen = leerPantalla().toString();

        List<String> cuentas = Arrays.stream(catchScreen.split("_")).collect(Collectors.toList()).subList(1, catchScreen.split("_").length);
        boolean isFound = false;
        boolean finalPage = false;
        int paginasRevisadas = 1;
        while (!isFound) {
            finalPage = catchScreen.contains("ULTIMA PAGINA") ? true : false;
            home();
            tab();
            tab();
            for (String e : cuentas) {
                if (e.toLowerCase().contains(cuenta.toLowerCase())) {
                    writeTextIntoConsole("X");
                    limpiarConcatenacion();
                    takeEvidence();
                    limpiarConcatenacion();
                    isFound = true;
                    enter();
                    boolean ismatch = waitText(cuenta, 9000);
                    if (ismatch == false) {
                        System.out.println("error account selected");
                        System.out.println(leerPantalla().toString());
                        return false;
                    }
                    System.out.println("PAGINAS REVISADAS " + paginasRevisadas);
                    limpiarConcatenacion();
                    takeEvidence();
                    break;

                } else {
                    tab();
                }
            }
            if (isFound == false) {
                if (finalPage == false) {
                    paginasRevisadas += 1;
                    pf(1);
                    Instant start = Instant.now();
                    while (!leerPantalla().toString().contains("ok")) {
                        pf(1);
                        Thread.sleep(600);
                        Instant end = Instant.now();
                        Duration timeElapsed = Duration.between(start, end);
                        if (timeElapsed.toMillis() > 10000) {
                            return false;
                        }
                    }
                    catchScreen = leerPantalla().toString();
                    List<String> cuentas2 = Arrays.stream(catchScreen.split("_")).collect(Collectors.toList()).subList(1, catchScreen.split("_").length);
                    if (!cuentas.contains(cuentas2)) {
                        cuentas = cuentas2;
                    }
                } else {
                    System.out.println("No se encontro cuenta");
                    System.out.println("PAGINAS REVISADAS " + paginasRevisadas);
                    takeEvidence();
                    Assert.fail();
                    break;
                }

            }
        }
        return true;
    }

    public boolean consultarHistoricoCuenta(String monto, String fechaTransaccion, String casoAsociado) throws InterruptedException {
        System.out.println(monto);
        home();  waitText("ok",2000);
        right();  waitText("ok",2000);
        waitText("ok", 3000);
        right();  waitText("ok",2000);
        waitText("ok", 3000);
        right();  waitText("ok",2000);
        waitText("ok", 3000);
        writeTextIntoConsole("2");
        boolean correctWrite=waitText(new String[]{"STI2", "IMI2"},500);
        int cont=0;
        while (!correctWrite && cont++<4){
            resetlockedkeyboard();
            home();  waitText("ok",2000);
            right();  waitText("ok",2000);
            right();  waitText("ok",2000);
            right();  waitText("ok",2000);
            writeTextIntoConsole("2");  waitText("ok",2000);
        }
        if (correctWrite==false){
            return false;
        }
        enter();  waitText("ok",2000);
        waitText("SELECCIONAR OPCION", 9000);
        enter();  waitText("ok",2000);
        waitText("PF1", 9000);
        String catchScreen = leerPantalla().toString();
        List<String> cuentas = Arrays.stream(catchScreen.split("_")).collect(Collectors.toList()).subList(1, catchScreen.split("_").length);
        boolean isFound = false;
        boolean finalPage = false;
        int paginasRevisadas = 1;
        Hooks.setEvidence("Monto a buscar ->" + monto + " con fecha de transaccion ->" + fechaTransaccion + " asociado al Caso de Prueba "+casoAsociado);
        while (!isFound) {
            //finalPage = catchScreen.contains("ADELANTARSE") ? true : false;
            finalPage=waitText(new String[]{"NO TRANSACCIONES","ADELANTARSE","TECLA PF/PA INVALIDA","ST MEMO RECORD NOT FOUND"},2000);
            home();  waitText("ok",2000);
            down();  waitText("ok",2000);
            down();  waitText("ok",2000);
            down();  waitText("ok",2000);
            tab();  waitText("ok",2000);
            waitText("ok", 2000);
            correctWrite=waitText(new String[]{"STI2", "IMI2"},500);
            if (!correctWrite){return false;}
            for (String e : cuentas) {
                if (e.toLowerCase().contains(monto.toLowerCase()) && e.toLowerCase().contains(fechaTransaccion.toLowerCase())) {
                    writeTextIntoConsole("X");
                    limpiarConcatenacion();
                    takeEvidence();
                    limpiarConcatenacion();
                    isFound = true;
                    enter();  waitText("ok",2000);
                    waitText("ok", 3000);
                    boolean ismatch = waitText(monto, 9000);
                    if (ismatch == false) {
                        System.out.println("error account selected");
                        System.out.println(leerPantalla().toString());
                        return false;
                    }
                    System.out.println("PAGINAS REVISADAS " + paginasRevisadas);
                    limpiarConcatenacion();
                    takeEvidence();
                    limpiarConcatenacion();
                    break;

                } else {
                    tab();  waitText("ok",2000);
                }
            }
            if (isFound == false) {
                if (finalPage == false) {
                    paginasRevisadas += 1;
                    pf(1);
                    Instant start = Instant.now();
                    while (!leerPantalla().toString().contains("ok")) {
                        System.out.println("Trying to read Screen");
                        pf(1);  waitText("ok",2000);
                        Thread.sleep(600);
                        Instant end = Instant.now();
                        Duration timeElapsed = Duration.between(start, end);
                        if (timeElapsed.toMillis() > 10000) {
                            return false;
                        }
                    }
                    catchScreen = leerPantalla().toString();
                    List<String> cuentas2 = Arrays.stream(catchScreen.split("_")).collect(Collectors.toList()).subList(1, catchScreen.split("_").length);
                    if (!cuentas.contains(cuentas2)) {
                        cuentas = cuentas2;
                    }
                } else {

                    System.out.println("PAGINAS REVISADAS " + paginasRevisadas);
                    Hooks.setEvidence("No se encontro transacción ");
                    takeEvidence();
                    break;
                }

            }

        }
        return true;
    }

    public boolean consultarEstadoCuenta(String monto, String fechaTransaccion, String casoAsociado) throws InterruptedException {
        System.out.println(monto);
        home();
        waitText("ok", 3000);
        right();
        waitText("ok", 3000);
        right();
        waitText("ok", 3000);
        right();
        waitText("ok", 3000);
        writeTextIntoConsole("3");
        boolean correctWrite=waitText(new String[]{"STI3", "IMI3"},500);
        int cont=0;
        while (!correctWrite && cont++<4){
            resetlockedkeyboard();
            home();
            right();
            right();
            right();
            writeTextIntoConsole("3");
        }
        if (correctWrite==false){
            return false;
        }
        enter();

        boolean stiAccount = waitText("STI", 500);
        if (!stiAccount) {
            waitText("Tipo de Transacción", 500);
            enter();
        }

        boolean pageCharge = waitText("PF1", 9000);
        if (pageCharge == false) {
            return false;
        }

        String catchScreen = leerPantalla().toString();

        List<String> cuentas = Arrays.stream(catchScreen.split("\n")).collect(Collectors.toList()).subList(1, catchScreen.split("\n").length);
        boolean isFound = false;
        boolean finalPage = false;
        int paginasRevisadas = 1;
        Hooks.setEvidence("Monto a buscar ->" + monto + " con fecha de transaccion ->" + fechaTransaccion + " asociado al Caso de Prueba "+casoAsociado);
        while (!isFound) {
            finalPage =waitText(new String[]{"NO TRANSACCIONES","ADELANTARSE","SAVINGS TRANSACTIONS","ST MEMO RECORD NOT FOUND"},3000);
            correctWrite=waitText(new String[]{"STI3", "IMI3"},100);
            if (!correctWrite){
                return false;
            }
            for (String e : cuentas) {
                if (e.toLowerCase().contains(monto.toLowerCase()) && e.toLowerCase().contains(fechaTransaccion.toLowerCase())) {
                    limpiarConcatenacion();
                    takeEvidence();
                    limpiarConcatenacion();
                    isFound = true;
                    System.out.println("PAGINAS REVISADAS " + paginasRevisadas);
                    break;
                }
            }
            if (isFound == false) {
                if (finalPage == false) {
                    paginasRevisadas += 1;
                    pf(1);
                    waitText("ok", 2000);
                    Instant start = Instant.now();
                    while (!leerPantalla().toString().contains("ok")) {
                        System.out.println("Trying to read Screen");
                        pf(1);
                        Thread.sleep(600);
                        Instant end = Instant.now();
                        Duration timeElapsed = Duration.between(start, end);
                        if (timeElapsed.toMillis() > 10000) {
                            return false;
                        }
                    }
                    catchScreen = leerPantalla().toString();
                    List<String> cuentas2 = Arrays.stream(catchScreen.split("\n")).collect(Collectors.toList()).subList(1, catchScreen.split("\n").length);
                    if (!cuentas.contains(cuentas2)) {
                        cuentas = cuentas2;
                    }
                } else {
                    System.out.println("PAGINAS REVISADAS " + paginasRevisadas);
                    Hooks.setEvidence("No se encontro transacción");
                    takeEvidence();
                    break;
                }
            }
        }
        return true;
    }


    public void consultarBalanceCuenta() throws InterruptedException {
        home();
        waitText("ok", 3000);
        right();
        waitText("ok", 3000);
        right();
        waitText("ok", 3000);
        right();
        waitText("ok", 3000);
        writeTextIntoConsole("4");
        waitText("ok", 3000);
        enter();
        takeEvidence();

    }

    public boolean consultarRetenciones(String monto, String fechaTransaccion, String casoAsociado) throws InterruptedException {

        System.out.println(monto);
        home();
        right();
        waitText("ok", 3000);
        right();
        waitText("ok", 3000);
        right();
        waitText("ok", 3000);
        writeTextIntoConsole("5");
        waitText("ok", 3000);
        boolean correctWrite=waitText(new String[]{"STI5", "IMI5"},500);
        int cont=0;
        while (!correctWrite && cont++<4){
            resetlockedkeyboard();
            home();
            right();
            right();
            right();
            writeTextIntoConsole("5");
        }
        if (correctWrite==false){
            return false;
        }

        enter();
        boolean imi = waitText("IMI", 3000);

        if (imi) {
            enter();
        }
        waitText("PF1", 9000);
        String catchScreen = leerPantalla().toString();
        List<String> cuentas = Arrays.stream(catchScreen.split("_")).collect(Collectors.toList()).subList(1, catchScreen.split("_").length);
        boolean isFound = false;
        boolean finalPage = false;
        int paginasRevisadas = 1;
        Hooks.setEvidence("Monto a buscar ->" + monto + " con fecha de transaccion ->" + fechaTransaccion + " asociado al Caso de Prueba "+casoAsociado);
        while (!isFound) {
            System.out.println("PAGINAS REVISADA " + paginasRevisadas);
            finalPage = waitText(
                    new String[]{"ADELANTARSE",
                            "DEMASIADOS DIGITOS",
                            "NO TRANSACCIONES",
                            "CANNOT CLOSE DUE TO HOLD","NO COINCIDE CLVE INGRES","ST MEMO RECORD NOT FOUND"}
                    ,1000) ? true : false;
            correctWrite=waitText(new String[]{"STI5", "IMI5"},100);
            if (!correctWrite){
                return false;
            }
            home();
            down();
            down();
            down();
            tab();
            waitText("ok", 2000);
            for (String e : cuentas) {
                if (e.toLowerCase().contains(monto.toLowerCase()) && e.toLowerCase().contains(fechaTransaccion.toLowerCase())) {
                    if (imi == true) {
                        writeTextIntoConsole("X");
                        limpiarConcatenacion();
                        takeEvidence();
                        limpiarConcatenacion();
                        isFound = true;
                        enter();
                        waitText("ok", 3000);
                    } else {
                        isFound = true;
                    }
                    boolean ismatch = waitText(monto, 9000);
                    if (ismatch == false) {
                        System.out.println("error account selected");
                        System.out.println(leerPantalla().toString());
                        return false;
                    }
                    System.out.println("PAGINAS REVISADAS " + paginasRevisadas);
                    limpiarConcatenacion();
                    takeEvidence();
                    limpiarConcatenacion();
                    break;

                } else {
                    tab();
                }
            }
            if (isFound == false) {
                if (finalPage == false) {
                    paginasRevisadas += 1;
                    pf(1);
                    Instant start = Instant.now();
                    while (!leerPantalla().toString().contains("ok")) {
                        pf(1);
                        Thread.sleep(600);
                        Instant end = Instant.now();
                        Duration timeElapsed = Duration.between(start, end);
                        if (timeElapsed.toMillis() > 10000) {
                            return false;
                        }
                    }
                    catchScreen = leerPantalla().toString();
                    List<String> cuentas2 = Arrays.stream(catchScreen.split("_")).collect(Collectors.toList()).subList(1, catchScreen.split("_").length);
                    if (!cuentas.contains(cuentas2)) {
                        cuentas = cuentas2;
                    }
                } else {
                    System.out.println("PAGINAS REVISADAS " + paginasRevisadas);
                    Hooks.setEvidence("No se encontro transacción ");
                    takeEvidence();
                    break;
                }

            }

        }

             return true;
    }

    public void realizoLaCreaciónDeCuentasDeTipoParaElDocumento(String numeroCrear, String tipoCuenta, String documento) throws InterruptedException {
        UserDetails.tipoCuenta = tipoCuenta;
        UserDetails.documento = documento;
        realizoLaConsultaDelTipoDocumentoConNumeroEnSystematics(tipoCuenta, documento);
        home();
        writeTextIntoConsole("RMSA");
        enter();
        waitText("ok",2000);
        pf(3);
        waitText("ok",2000);
        boolean limpiar = waitText("PROCESAMIENTO SESION SUSPENDIDO", 3000);
        if (limpiar == false) {
            System.out.println("No se puedo suspender sesión anterior");
            takeEvidence();
            Assert.fail();
        }

        writeTextIntoConsole("RMAB");
        waitText("ok",2000);
        enter();
        waitText("ok",2000);
        waitText("CTL1", 10);
        waitText("ok",2000);
        takeEvidence();

        home();
        writeTextIntoConsole("RMSA");
        waitText("ok",2000);
        enter();
        waitText("ok",2000);


        home();
        waitText("ok",2000);
        tab();
        waitText("ok",2000);
        tab();
        waitText("ok",2000);
        if (tipoCuenta.equals("IM")) {
            writeTextIntoConsole(numeroCrear);
        } else if (tipoCuenta.equals("ST")) {
            tab();
            writeTextIntoConsole(numeroCrear);
        }
        down();
        waitText("ok",2000);
        down();
        waitText("ok",2000);
        down();
        waitText("ok",2000);
        tab();
        waitText("ok",2000);
        writeTextIntoConsole(tipoCuenta);
        waitText("ok",2000);
        waitText(tipoCuenta, 9000);

    }

    public void ingresoElCodigoIdentidadTipoMonedaLaOficinaTipoProducto(String codigoIdentidad, String tipoMoneda, String oficina, String tipoProducto) throws InterruptedException {

        tab();
        writeTextIntoConsole(codigoIdentidad);
        waitText("ok",2000);
        writeTextIntoConsole(tipoMoneda);
        waitText("ok",2000);
        writeTextIntoConsole(oficina);
        waitText("ok",2000);
        writeTextIntoConsole(tipoProducto);
        waitText("ok",2000);
        waitText(codigoIdentidad + " " + tipoMoneda, 9000);
        takeEvidence();
    }

    public void ingresoElTipoCODCONECCIONTIPODEPROD(String codConeccion, String tipoProd) throws InterruptedException {

        writeTextIntoConsole(codConeccion);
        tab();
        waitText("ok",2000);
        tab();
        waitText("ok",2000);

        writeTextIntoConsole("1");
        waitText("ok",2000);
        enter();
        waitText("ok",2000);
        boolean result = waitText("INFORMACION PERSONAL", 9000);
        if (result == false) {
            takeEvidence();
            Assert.fail();
        }

        writeTextIntoConsole(tipoProd);
        if (UserDetails.tipoCuenta.equals("ST")) {
            writeTextIntoConsole("1");
        }
        takeEvidence();
        String pantallaActual = leerPantalla().toString();
        String resumen = "";
        try {
            resumen = resumen + " Para el documento: " + UserDetails.documento + " se le realizó la creacion de ";
            if (UserDetails.tipoCuenta.equals("ST")) {
                resumen = resumen + " ST (AHORRO) con " + pantallaActual.substring(pantallaActual.indexOf("Cuenta: 0000"), pantallaActual.indexOf("Cuenta: 0000") + 62).toString().toLowerCase();
            } else if (UserDetails.tipoCuenta.equals("IM")) {
                resumen = resumen + " IM (CORRIENTE) con " + pantallaActual.substring(pantallaActual.indexOf("Cuenta  0000"), pantallaActual.indexOf("Cuenta  0000") + 69).toString().toLowerCase();
            }
        } catch (Exception e) {
            resumen = resumen + "Error Parse for document " + UserDetails.documento + " " + UserDetails.tipoCuenta;
            e.printStackTrace();
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String time = sdf.format(date);
        HooksMainframe.saveFacadeEvidence("(" + HooksMainframe.getSerenityParams("USER.MAINFRAME") + "): " + resumen, "CREACION CUENTAS ST IM", "MM-yyyy", "dd-MM-yyyy");
        enter();
        waitText("ok",2000);
        pf(9);
        waitText("ok",2000);
        pf(4);
        waitText("ok",2000);
        result = waitText("PROCESAMIENTO", 9000);
        takeEvidence();
        Assert.assertTrue((result));
    }

    public void realizoLaConsultaDelTipoDocumentoConNumeroEnSystematics(String tipoDocumento, String nroDocumento) throws InterruptedException {
        if (tipoDocumento.toUpperCase().trim().equals("CU")) {
            clear();
            writeTextIntoConsole("RMAB;nb  " + nroDocumento);
            waitText("ok", 3000);
            enter();
            waitText("ok", 3000);
            takeEvidence();
        } else {
            ingresarRMCA();
            tab();
            tab();
            writeTextIntoConsole(nroDocumento);
            waitText("DOCUMENTO      " + String.valueOf(nroDocumento), 9000);
            enter();
            //P/C
            writeTextIntoConsole("P");
            limpiarConcatenacion();
            waitText("ok",1000);
            waitText("P/C  " + "P", 300);
            enter();
            boolean accederRMCA = waitText("NUMERO CLIENTE", 9000);
            if (accederRMCA == false) {
                takeEvidence();
                Assert.fail();
            }


        }


    }

    public void realizoLaConsultaConElComando(String comando) throws InterruptedException {
        home();
        writeTextIntoConsole(comando);
        enter();
        waitText("COMANDO ===> " + comando, 9000);
        takeEvidence();
    }


}
