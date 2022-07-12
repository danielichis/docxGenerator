package Interbank.com.pe.Util;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.apache.commons.io.IOUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class HelperServices {

    public JSONObject getAttributesFromJson(String jsonPath) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONArray jsonParse = (JSONArray) parser.parse(new FileReader(jsonPath));
        JSONObject getData = (JSONObject) jsonParse.get(0);
        return getData;
    }

    public String agregarElemento(String servicePATH, String tramaIndex, List<String> tramas) throws IOException {
        FileInputStream tramaconsulta = new FileInputStream(new File(servicePATH));
        String tramaOriginal = IOUtils.toString(tramaconsulta, "UTF-8");
        String trama1 = tramaOriginal.substring(0, tramaOriginal.indexOf(tramaIndex.replace("/", "")) + tramaIndex.replace("/", "").length());
        String trama2 = tramaOriginal.substring(tramaOriginal.indexOf(tramaIndex));
        for (String e : tramas) {
            trama1 = trama1+ e +"\n";
        }
        trama1 = trama1 + trama2;
        return trama1;
    }



    public List<String> getAttributes(HashMap<String, String> map) {
        List<String> list = new ArrayList<>();
        for (String e : map.keySet()) {
            list.add("<" + e + ">" + map.get(e) + "</" + e + ">");
        }
        return list;
    }

    public Response executeApiServicesRequest(String url, JSONObject body, JSONObject header){
        RestAssured.baseURI=url;
        Response response=given().relaxedHTTPSValidation()
                .headers(header)
                .and()
                .body(body)
                .when()
                .post()
                .then()

                .and()
                .extract().response();

            return response;

    }

    public Response executeGetApiServicesRequest(String url, JSONObject body, JSONObject header, String codunico){
        RestAssured.baseURI=url;
        Response response=given().relaxedHTTPSValidation()
                .queryParam("referenceId", codunico)
                .headers(header)
                .and()
                .when()
                .get()
                .then()
                .and()
                .extract().response();

        return response;

    }


//    RestAssured.baseURI=url;
//    Response response= (Response) given().relaxedHTTPSValidation()
//            .headers(header)
//            .and()
//            .body(body)
//            .when()
//            .post()
//            .then()
//            .extract().response().body();
//        response.asString()
    public Response executeApiServicesRequest(String url, String service, Map<String, String> body, JSONObject header){
        RestAssured.baseURI=url;
        Response response=given().relaxedHTTPSValidation()
                .headers(header)
                .and()
                .formParams(body)
                .when()
                .post()
                .then()
                .statusCode(200)
                .and()
                .extract().response();

        return response;

    }



    public String executeSOAPServicesRequest(String pathAObtener,String url,String service, String trama, HashMap header) throws IOException {
        RestAssured.baseURI=url;
           Response response=given().relaxedHTTPSValidation()
                .headers(header)
                .and()
                .body(trama)
                .when()
                .post()
                .then()
                .statusCode(200)
                .and()
                .extract().response();

        XmlPath jsXpath= new XmlPath(response.asString());
        jsXpath.getNode(pathAObtener);
        String result=jsXpath.prettify();
        return result;

    }








}
