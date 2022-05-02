package Mainframe.AccessObjects;
import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.apache.commons.io.IOUtils;
//import org.apache.xmlbeans.XmlException;
import org.junit.Assert;
import tools.mainframe.helpers.HelperMainframe;
import tools.mainframe.Hooks;

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
public class LoginInterface extends HelperMainframe {
    Hooks hooksMainframe= new Hooks();
    public void queAccedoAAccessEnMainframe() throws InterruptedException {
        boolean result =false;
        ascii();
        writeConsoleComand("connect(130.30.30.6)");
        waitText("data",9000);
        waitText("LOGON APPLID() LOGMODE() DATA()",3000);
        writeTextIntoConsole("LOGON APPLID(ACCESS30)");
        enter();
        waitCommandResult(3000);
        result=waitText("ingrese",9000);
        if (result==false){
            ascii();
            takeEvidence();
        }
        Assert.assertTrue(result);
    }

}
