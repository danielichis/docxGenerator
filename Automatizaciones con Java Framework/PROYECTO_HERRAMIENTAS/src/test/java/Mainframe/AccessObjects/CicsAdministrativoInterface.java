package Mainframe.AccessObjects;
import org.junit.Assert;
import tools.mainframe.helpers.HelperMainframe;
import tools.mainframe.Hooks;
public class CicsAdministrativoInterface extends HelperMainframe {
    Hooks hooksMainframe= new Hooks();
    public void ingresoLasCredencialesEInicioSesionEnCICS() throws InterruptedException {
        boolean flag=false;
        boolean cicsScreen=waitText("CICS",9000);
        if (!cicsScreen){
            System.out.println("Error emulator");
            Assert.fail();
        }
        writeTextIntoConsole("IB00");
        waitCommandResult(3000);
        waitText("IB00",9000);
        enter();
        waitCommandResult(3000);
        waitText("Usuario",9000);
        String user= hooksMainframe.getSerenityParams("USER.CICS.MAINFRAME").trim();
        String pass= hooksMainframe.getSerenityParams("PASS.CICS.MAINFRAME").trim();
        resetlockedkeyboard();
        home();
        waitCommandResult(3000);
        resetlockedkeyboard();
        writeTextIntoConsole(user);
        waitCommandResult(9000);
        boolean userAppear=waitText(user,9000);
        int i=0;
        while (userAppear==false && i++<2){
            resetlockedkeyboard();
            home();
            waitCommandResult(3000);
            resetlockedkeyboard();
            writeTextIntoConsole(user);
        }
        if(userAppear==false){takeEvidence(); Assert.fail();}
        if (user.length()<6){
            tab();
        }
        resetlockedkeyboard();
        writeTextIntoConsole(pass);
        waitCommandResult(3000);
        resetlockedkeyboard();
        enter();
        waitCommandResult(3000);
        flag=waitText("Aplicativos Autorizados",15000);
        takeEvidence();
        Assert.assertTrue(flag);

    }

    public void ingresoALaAplicacionDentroDeCICS(String aplicacion) throws InterruptedException {
        boolean flag=false;
        resetlockedkeyboard();
        writeTextIntoConsole(aplicacion);
        waitCommandResult(5000);
        waitText(aplicacion,2000);
        resetlockedkeyboard();
        enter();
        waitCommandResult(5000);
        waitText("ok",2000);
    }
}
