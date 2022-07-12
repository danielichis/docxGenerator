package Interbank.com.pe.Task.Mainframe;
//import org.apache.xmlbeans.XmlException;
import Interbank.com.pe.Tool.mainframe.Hooks;
import Interbank.com.pe.Tool.mainframe.helpers.HelperMainframe;
import org.junit.Assert;

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
