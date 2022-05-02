package Mainframe.AccessObjects;

import org.junit.Assert;
import tools.mainframe.helperMainframe;
import tools.mainframe.hooks;

public class accessInterface extends helperMainframe {
    hooks HooksMainframe= new hooks();

    public void queIngresoLasCredencialesEInicioSesionEnMainframe() throws InterruptedException {
        boolean flag=false;
        String user= HooksMainframe.getSerenityParams("USER.MAINFRAME").trim();
        String pass= HooksMainframe.getSerenityParams("PASS.MAINFRAME").trim();
        writeTextIntoConsole(user);
        waitText(user,2000);
        tab();
        writeTextIntoConsole(pass);
        enter();
        flag=waitText("Aplicaciones",2000);
        takeEvidence();
        if (flag==false){
            leerPantalla().toString();
        }
        Assert.assertTrue(flag);
    }

    public void accedoALaAplicacionDentroDeAccess(String aplicacion) throws InterruptedException {
        boolean flag=false;
        writeTextIntoConsole("LF "+ aplicacion);
        waitText("LF "+ aplicacion,3000);
        enter();
        waitText("logged off",3000);
        writeTextIntoConsole(aplicacion);
        enter();
        String palabraClave="";
        switch (aplicacion.toUpperCase()){
            case "CICSAA2K":
                palabraClave="CONSULTA";
                break;
            case "CICSFA2K":
                palabraClave="CICS Financiero";
                break;
        }
        flag=waitText(palabraClave,3000);
        takeEvidence();
        if (flag==false){
            leerPantalla().toString();
        }
        Assert.assertTrue(flag);





    }
}
