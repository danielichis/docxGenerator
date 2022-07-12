package Interbank.com.pe.Task.Mainframe;
import org.junit.Assert;
import Interbank.com.pe.Tool.mainframe.helpers.HelperMainframe;
import Interbank.com.pe.Tool.mainframe.Hooks;
public class AccessInterface extends HelperMainframe {
    Hooks hooksMainframe= new Hooks();
    public boolean queIngresoLasCredencialesEInicioSesionEnMainframe() throws InterruptedException {
        boolean flag=false;
        waitText("Usuario:",3000);
        String user= hooksMainframe.getSerenityParams("USER.MAINFRAME").trim();
        String pass= hooksMainframe.getSerenityParams("PASS.MAINFRAME").trim();
        writeTextIntoConsole(user);
        waitCommandResult(3000);
        waitText(user,9000);
        tab();
        waitCommandResult(3000);
        waitText("Usuario:    "+ user,9000);
        writeTextIntoConsole(pass);
        waitCommandResult(3000);
        enter();
        waitCommandResult(3000);
        flag=waitText("Aplicaciones",9000);
        takeEvidence();
        return flag;
    }
    public void accedoALaAplicacionDentroDeAccess(String aplicacion) throws InterruptedException {
        boolean flag=false;
        waitText("Seleccion de Aplicaciones",9000);
        waitText(aplicacion,9000);
        writeTextIntoConsole("LF "+ aplicacion);
        waitCommandResult(3000);
        waitText("LF "+ aplicacion,9000);
        enter();
        waitCommandResult(3000);
        waitText("logged off",9000);

        writeTextIntoConsole(aplicacion+"_________________");
        waitCommandResult(3000);
        boolean correctCommand= waitText("COMMAND ==> "+aplicacion,9000);
        if (correctCommand==false){
            pf(24);
            writeTextIntoConsole(aplicacion+"_________________");
        }
        enter();
        waitCommandResult(3000);
        String palabraClave="";
        switch (aplicacion.toUpperCase()){
            case "CICSAA2K":
                palabraClave="CONSULTA";
                break;
            case "CICSFA2K":
                palabraClave="CICS Financiero";
                break;
        }
        flag=waitText(palabraClave,9000);
        takeEvidence();
        Assert.assertTrue(flag);
    }
}
