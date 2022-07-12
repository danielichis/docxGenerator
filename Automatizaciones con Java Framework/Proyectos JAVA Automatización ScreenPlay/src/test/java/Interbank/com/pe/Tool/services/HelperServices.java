package Interbank.com.pe.Tool.services;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.yecht.Data;

import java.io.IOException;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class HelperServices {

    String result = "";

     public String executeSOAPServicesRequest(String pathAObtener, String url, String service, String trama, HashMap header) throws IOException {
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
        result=jsXpath.prettyPrint();
        return result;
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
                .statusCode(200)
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
}
