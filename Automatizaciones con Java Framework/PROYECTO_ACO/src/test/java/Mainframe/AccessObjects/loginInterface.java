package Mainframe.AccessObjects;
//import com.eviware.soapui.impl.WsdlInterfaceFactory;
//
//import com.eviware.soapui.impl.wsdl.*;
//import com.eviware.soapui.model.iface.Request;
//import com.eviware.soapui.support.SoapUIException;
import io.restassured.RestAssured;
import io.restassured.config.XmlConfig;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.apache.commons.io.IOUtils;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
//import org.apache.xmlbeans.XmlException;
import org.junit.Assert;
import tools.mainframe.helperMainframe;
import tools.mainframe.hooks;

import javax.net.ssl.*;
import java.io.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.HashMap;

import static io.restassured.RestAssured.given;


public class loginInterface extends helperMainframe{


    hooks HooksMainframe= new hooks();
    public void queAccedoAAccessEnMainframe() throws InterruptedException {
        boolean result =false;
        ascii();
        writeConsoleComand("connect(130.30.30.6)");
        waitText("data",5);
        waitText("LOGON APPLID() LOGMODE() DATA()",3000);
        writeTextIntoConsole("LOGON APPLID(ACCESS30)");
        enter();
        //insertComandandWaitResult(ENTER,3);
        result=waitText("ingrese",3000,ENTER);
        Assert.assertTrue(result);
    }









    public void obtengoDetallesDelPd3f() throws IOException {
//        WsdlProject project = new WsdlProject();
//        project.setName("Project1");
//        WsdlInterface iface = WsdlInterfaceFactory.importWsdl(project, "D:/Selenium.Bdd.Auto/Selenium.Bdd.Auto - v2/drivers/consultarlinea/IBKServiceA0042_v1.0_1.wsdl", true)[0];
//        WsdlOperation operation =iface.getOperationByName("MyOperation");
//        WsdlRequest request = operation.addNewRequest( "My request" );
//        // submit the request
//        WsdlSubmit submit =  request.submit(new WsdlSubmitContext(request), false );
//
//// wait for the response
//        Response response = (Response) submit.getResponse();
//
//
//// generate the request content from the schema
//        request.setRequestContent( operation.createRequest( true ) );
//
//        //	print the response
//        String content = response.toString();
//        System.out.println( content );
//


    }


    public void obtengoDetallesDelPdf() throws IOException {
        disableSslVerification();
        FileInputStream fileInputStream = new FileInputStream(new File("D:/Selenium.Bdd.Auto/Selenium.Bdd.Auto - v2/drivers/consultarlinea"));
        FileInputStream fileInputStream2 = new FileInputStream(new File("D:/Selenium.Bdd.Auto/Selenium.Bdd.Auto - v2/drivers/consultarlinea2"));

        RestAssured.baseURI="https://10.11.32.72:7200/ibk/srv/MPO/AtencionCliente/bancaSMS.consultarAfiliacion/v1.0";
        HashMap headermap = new HashMap<>();
        headermap.put("Content-Type", "text/xml");
        headermap.put("SOAPAction", "http://interbank.com.pe/service/CIF/bancaSMS.consultarAfiliacion/v1.0/");
        Response response=given().relaxedHTTPSValidation()
                .headers(headermap)
                .contentType("text/xml")
                .and()
                .body(IOUtils.toString(fileInputStream2,"UTF-8"))
                .when()
                .post()
                .then()
                .statusCode(200)
                .and()
                .log().all()
                .extract().response();
        XmlPath jsXpath= new XmlPath(response.asString());//Converting string into xml path to assert
        String rate=jsXpath.getString("GetConversionRateResult");
        System.out.println("rate returned is: " +  rate);


    }
    public void obtengoDetallesDelPdf2() throws IOException {
        //        File file = new File("D:/data/valida.pdf");
//        PDDocument doc1 = PDDocument.load(file);
//
//        PDFTextStripper textStripper = new PDFTextStripper();
//        textStripper.setSortByPosition(true);
//        String content = textStripper.getText(doc1);
//        System.out.println(content);
//        System.out.println(content.split("\n")[0]);
    }

        public void soaprequest() throws IOException {
        String address="Hyderabad";

        /* place your xml request from soap ui below with necessary changes in parameters*/
        StringBuffer output = new StringBuffer();
        try {
            BufferedReader in
                    = new BufferedReader(new FileReader("D:/Selenium.Bdd.Auto/Selenium.Bdd.Auto - v2/drivers/consultarlinea"));
            output = new StringBuffer();
            String st;
            while ((st=in.readLine()) != null) {
                output.append(st);
            }
            System.out.println(output.toString());
            in.close();
        }
        catch (Exception fx) {
            System.out.println("Exception " + fx.toString());
        }
        System.out.println(output.toString());
        String responseF=callSoapService(output);
        System.out.println("--------1--------");
        System.out.println(responseF);
        System.out.println("--------1--------");
    }
    String callSoapService(StringBuffer soapRequest) {
        try {

            String url = "https://10.11.32.72:7200/ibk/srv/MPO/AtencionCliente/bancaSMS.consultarAfiliacion/v1.0"; // replace your URL here
            URL obj = new URL(url);
            disableSslVerification();
         //   System.setProperty("sun.security.ssl.allowUnsafeRenegotiation", "true");
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            // change these values as per soapui request on top left of request, click on RAW, you will find all the headers
            con.setRequestMethod("POST");

            con.setRequestProperty("Content-encoding","deflate");
            con.setRequestProperty("Content-Type","text/xml; charset=UTF-8");
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(String.valueOf(soapRequest));
            wr.flush();
            wr.close();
            String responseStatus = con.getResponseMessage();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // You can play with response which is available as string now:
            String finalvalue= response.toString();

            return finalvalue;
        }
        catch (Exception e) {
            return e.getMessage();
        }

    }

    private void disableSslVerification() {
        try {
            // Create a trust manager that does not validate certificate chains
            TrustManager[] trustAllCerts = new TrustManager[] {
                    new X509TrustManager() {
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return null;
                        }

                        public void checkClientTrusted(X509Certificate[] certs,
                                                       String authType) {
                        }

                        public void checkServerTrusted(X509Certificate[] certs,
                                                       String authType) {
                        }
                    } };

            // Install the all-trusting trust manager
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

            // Create all-trusting host name verifier
            HostnameVerifier allHostsValid = new HostnameVerifier() {
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            };

            // Install the all-trusting host verifier
            HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
    }



}
