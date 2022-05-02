package Mainframe.AccessObjects;

import org.junit.Assert;
import tools.mainframe.helperMainframe;
import tools.mainframe.hooks;

public class cicsAdministrativoInterface extends helperMainframe {
    hooks HooksMainframe= new hooks();


    public void ingresoLasCredencialesEInicioSesionEnCICS() throws InterruptedException {
        boolean flag=false;
        writeTextIntoConsole("IB00");
        waitText("IB00",2000);
        enter();
        waitText("Usuario",2000);
        String user= HooksMainframe.getSerenityParams("USER.MAINFRAME").trim();
        String pass= HooksMainframe.getSerenityParams("PASS.MAINFRAME").trim();
        writeTextIntoConsole(user);
        waitText("Usuario    : "+user,2000);
        if (user.length()<6){
            tab();
        }
        writeTextIntoConsole(pass);
        enter();
        flag=waitText("Aplicativos Autorizados",1000);
        takeEvidence();
        if (flag==false){
            leerPantalla().toString();
        }
        Assert.assertTrue(flag);

    }

    public void ingresoALaAplicacionDentroDeCICS(String aplicacion) throws InterruptedException {
        boolean flag=false;
        writeTextIntoConsole(aplicacion);
        enter();
    }
}
