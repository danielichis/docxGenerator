package Interbank.com.pe.Task.BPI_SOAP_Objects;

import Interbank.com.pe.Tool.services.HelperServices;
import Interbank.com.pe.Tool.services.Hooks;

import java.util.HashMap;

public class AfiliacionNumeroCelular extends HelperServices {
    Interbank.com.pe.Tool.services.Hooks Hooks=new Hooks();
    HashMap<String, String> responseTramas = new HashMap<>();

/*

    public void realizarconsulta(String tipoconsulta, String numero) throws IOException, ParserConfigurationException, ParseException {

        //pare recorrer el json
        JSONObject node1 = getAttributesFromJson("src/test/resources/data/BPI/servicesParameters.json");
        JSONObject node2 = (JSONObject) node1.get("atributos");
        JSONObject atributos = (JSONObject) node2.get("afiliarBPI");
        String newXmlServices = "";
        //Adecuar trama
        if (tipoconsulta.toUpperCase().trim().equals("NUMERO CELULAR")) {
             //hasmap dponde se colocaran los valores a enviar en el xml (va sustituri de acuerdo a una nodo clave
            HashMap<String, String> atributosMap = new HashMap<String, String>();
            atributosMap.put((String) atributos.get("4"), numero);
//            atributosMap.put("tipoDocumento","01");
//            atributosMap.put("numeroTarjeta","411090******2053");
            newXmlServices = agregarElemento("src/test/java/providers/uat/consultarAfiliacionBPI.xml",
                    "</solConsultaAfiliacion>",
                    getAttributes(atributosMap)
            );
        } else if (tipoconsulta.toUpperCase().trim().equals("CODIGO UNICO")) {
            HashMap<String, String> atributosMap = new HashMap<String, String>();
            atributosMap.put((String) atributos.get("2"), numero);
            newXmlServices = agregarElemento("src/test/java/providers/uat/consultarAfiliacionBPI.xml",
                    "</solConsultaAfiliacion>",
                    getAttributes(atributosMap)
            );

        }

        node2 = (JSONObject) node1.get("url");

        //hasmap para crear el hearder
        HashMap headermap = new HashMap<>();
        headermap.put("Content-Type", "text/xml");
       // headermap.put("SOAPAction", "http://interbank.com.pe/service/MPO/Colocaciones/proceso.abonarTarjetaCredito/v1.0/");
        headermap.put("SOAPAction", node2.get("consultaBPI"));


        //metodo para ejecutura el soap
        String response = executeSOAPServicesRequest(
                "status",
                "https://10.11.32.72:7200/ibk/srv/MPO/AtencionCliente/bancaSMS.consultarAfiliacion/v1.0",
                "",
                newXmlServices,
                headermap
        );

        responseTramas.put("consultaAfiliacion", response);
        tools.services.Hooks.setEvidence("DETALLES"+"\n"+ tools.services.Hooks.mapToString(obtengoDetallesDeLaRespuesta("consultaAfiliacion", "</afiliacionDetalle>")));

    }

    public HashMap<String, String> obtengoDetallesDeLaRespuesta(String responseTramaString, String tramaIndex) {
        String response = responseTramas.get(responseTramaString);

        String trama1 = response.substring(
                response.indexOf(tramaIndex.replace("/", "")) + tramaIndex.replace("/", "").length(),
                response.indexOf(tramaIndex)
        );
        String[] atributos = trama1.split("\n");
        HashMap<String, String> map = new HashMap<>();
        for (String f : atributos) {
            try {
                String key = f.substring(f.indexOf("<") + 1);
                String value = key.substring(key.indexOf(">") + 1);
                map.put(key.substring(0, key.indexOf(">")), value.substring(0, value.indexOf("<")));
            } catch (Exception e) {
            }
        }

        return map;
    }


    public void realizoLaDesafiliacionDelCodigoUnicoAsociadoDeRequerirse() throws IOException, ParseException {

        String lastResponse = responseTramas.get("consultaAfiliacion");

        boolean afiliado = lastResponse.contains("NO SE ENCONTRO AFILIACION") ? false : true;
        if (afiliado == true) {
            JSONObject node1 = getAttributesFromJson("src/test/resources/data/BPI/servicesParameters.json");
            JSONObject node2 = (JSONObject) node1.get("atributos");
            JSONObject atributos = (JSONObject) node2.get("afiliarBPI");
            HashMap<String, String> map = obtengoDetallesDeLaRespuesta("consultaAfiliacion", "</afiliacionDetalle>");

            HashMap<String, String> atributosMap = new HashMap<String, String>();
            atributosMap.put((String) atributos.get("2"), map.get("codigoUnico"));
            atributosMap.put((String) atributos.get("3"), map.get("codigoOperador"));
            atributosMap.put((String) atributos.get("4"), map.get("numeroCelular"));
            String newXmlServices = agregarElemento("src/test/java/providers/uat/desafiliarOperadorBPI.xml",
                    "</solDesafiliacion>",
                    Arrays.asList(
                            getAttributes(atributosMap).get(2),
                            getAttributes(atributosMap).get(1),
                            getAttributes(atributosMap).get(0)));

            node2 = (JSONObject) node1.get("url");
            HashMap headermap = new HashMap<>();
            headermap.put("Content-Type", "text/xml");
            headermap.put("SOAPAction", node2.get("desafiliarBPI"));
            String response = executeSOAPServicesRequest(
                    "numeroCelular",
                    "https://dpisit.grupoib.local:5200/ibk/srv/MPO/Utilitarios/bancaSMS.desafiliar/v1.0",
                    "",
                    newXmlServices,
                    headermap
            );
            if (!response.contains("EJECUCION CON EXITO")){
                Assert.fail();
            }
            responseTramas.put("desafiliarOperador", response);
            tools.services.Hooks.setEvidence(tools.services.Hooks.mapToString(obtengoDetallesDeLaRespuesta("desafiliarOperador", "</operacion>")));

        }else {
            System.out.println("no requiere desafiliación");
        }
    }




    public void realizoLaAfiliacionDelNumeroConOperadorAlSiguienteCodigoUnico(String numero, String operador, String codigoUnico) throws IOException, ParseException {

            JSONObject node1 = getAttributesFromJson("src/test/resources/data/BPI/servicesParameters.json");
            JSONObject node2 = (JSONObject) node1.get("atributos");
            JSONObject atributos = (JSONObject) node2.get("afiliarBPI");


            HashMap<String, String> atributosMap = new HashMap<String, String>();
            atributosMap.put((String) atributos.get("5"), "1");
            atributosMap.put((String) atributos.get("2"), codigoUnico.trim());
            atributosMap.put((String) atributos.get("3"), operador.toUpperCase().trim());
            atributosMap.put((String) atributos.get("4"), numero.trim());
            String newXmlServices = agregarElemento(
                    "src/test/java/providers/uat/afiliarOperadorBPI.xml",
                    "</datoAfiliacion>",
                     Arrays.asList(
                            getAttributes(atributosMap).get(1),
                            getAttributes(atributosMap).get(3),
                            getAttributes(atributosMap).get(2),
                            getAttributes(atributosMap).get(0))
            );
            node2 = (JSONObject) node1.get("url");
            HashMap headermap = new HashMap<>();
            headermap.put("Content-Type", "text/xml");
            headermap.put("SOAPAction", node2.get("afiliarBPI"));
            String response = executeSOAPServicesRequest(
                    "numeroCelular",
                    "https://dpiuat.grupoib.local:7200/ibk/srv/MPO/Utilitarios/bancaSMS.afiliar/v1.0",
                    "",
                    newXmlServices,
                    headermap
            );
            if (!response.contains("EJECUCION CON EXITO")){
                Assert.fail();
            }
            responseTramas.put("afiliarOperador", response);
            String resumen= "Detalles afiliación"+"\n"+
                    tools.services.Hooks.mapToString(obtengoDetallesDeLaRespuesta(
                            "afiliarOperador",
                            "</operacion>"));
          tools.services.Hooks.setEvidence(resumen);
          Hooks.saveIntoLog("\n"+resumen);

    }
*/

}
