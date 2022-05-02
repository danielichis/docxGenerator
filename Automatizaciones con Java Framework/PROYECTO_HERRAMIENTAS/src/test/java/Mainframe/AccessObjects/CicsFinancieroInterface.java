package Mainframe.AccessObjects;

import org.junit.Assert;
import tools.mainframe.helpers.HelperMainframe;
import tools.mainframe.Hooks;

import java.util.ArrayList;
import java.util.List;

public class CicsFinancieroInterface extends HelperMainframe {
    Hooks hooksMainframe= new Hooks();
    public void ingresoALaAplicacionDentroDeCICS(String aplicacion) throws InterruptedException {
        boolean flag=false;
        writeTextIntoConsole(aplicacion);
        enter();
    }
    public void ingresoARNCSimulator() throws InterruptedException {
        boolean flag=false;
        waitText("Bienvenido al CICS Financiero",9000);
        //Ingreso a Cics Financiero
        String user= hooksMainframe.getSerenityParams("USER.MAINFRAME").trim();
        String pass= hooksMainframe.getSerenityParams("PASS.MAINFRAME").trim();
        writeTextIntoConsole(user);
        if (user.length()<8){
            tab();
        }
        writeTextIntoConsole(pass);
        enter();
        //Ingreso a ARNC simulator
        writeTextIntoConsole("rnsm");
        enter();
        flag=waitText("RNC SIMULATOR",9000);
        takeEvidence();
        Assert.assertTrue(flag);

    }

    public void configuroCabeceraSuperior(String programa, String sysId, String tran, String lengthCommarea) throws InterruptedException {
        writeTextIntoConsole(programa);
        waitText("PROGRAM : "+programa,9000);
        if (programa.length()<8){
            for (int i=1;i<=(8-programa.length());i++){
                space();
            }
        }
        writeTextIntoConsole(sysId);
        waitText("SYSID : "+sysId,9000);
        if (programa.length()<4){tab(); }
        writeTextIntoConsole(tran);
        waitText("TRAN : "+tran,9000);
        if (programa.length()<4){ tab(); }
        writeTextIntoConsole(lengthCommarea);
        waitText("LENGTH OF COMMAREA : "+lengthCommarea,9000);
        if (programa.length()<5){ tab(); }
    }

    public void realizoLaConsulta(String pan, String fechaVencimiento, String estructura, String tipoLectura) throws InterruptedException {
        writeTextIntoConsole(estructura);
        writeTextIntoConsole(pan);
        waitText(estructura+pan,9000);
        String tipoPAN=pan.split("")[0];
        int espacios=0;
        switch (tipoPAN){
            case "3":
                tipoPAN="AMEX";
                espacios=7;
                break;
            case "4":
                tipoPAN="VISA";
                espacios=6;
                break;
            case "5":
                tipoPAN="MC";
                espacios=6;
                break;
        }
        for(int i=0;i<espacios;i++){right();}
        writeTextIntoConsole(fechaVencimiento);
        writeTextIntoConsole(tipoLectura);
        enter();
        pf(7);
        waitText(estructura+pan,9000);
        ascii();
        String getPantalla= leerPantalla().toString();
        String [] cadena= getPantalla.substring(getPantalla.indexOf(estructura+pan),getPantalla.length()).split("\n");
        List<String> filtroCadena=new ArrayList<>();
        for (String e:cadena[2].split(" ")){
            if(e.length()>0 && !e.contains(":")  && !e.contains("-") ){
                filtroCadena.add(e);
            }
        }
        try {
            filtroCadena.remove(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (String e:cadena[3].split(" ")){
            if(e.length()>0 && !e.contains(":")  && !e.contains("-") ){
                filtroCadena.add(e);
            }
        }
        try {
            filtroCadena.remove(4);
        } catch (Exception e) {
            e.printStackTrace();
        }
        hooksMainframe.saveIntoLog("--------------------------------------------------------------------");
        hooksMainframe.saveIntoLog("PAN CONSULTADO: "+pan);
        hooksMainframe.saveIntoLog("CON FECHA VENCIMIENTO: "+fechaVencimiento);
        filtroCadena.forEach(sString -> hooksMainframe.saveIntoLog(sString));
        if (tipoPAN.equals("AMEX")){
           hooksMainframe.saveIntoLog("PIN "+ filtroCadena.get(0).substring(0,4));
           hooksMainframe.saveIntoLog("PVV "+ filtroCadena.get(0).substring(4,8));
           hooksMainframe.saveIntoLog("CVV2 "+ filtroCadena.get(1));
           hooksMainframe.saveIntoLog("5CSCS "+ filtroCadena.get(2).substring(filtroCadena.get(2).trim().length()-12,filtroCadena.get(2).trim().length()-7));
           hooksMainframe.saveIntoLog("4CSCS "+ filtroCadena.get(2).substring(filtroCadena.get(2).trim().length()-7,filtroCadena.get(2).trim().length()-3));
           hooksMainframe.saveIntoLog("3CSCS "+ filtroCadena.get(3).substring(filtroCadena.get(3).trim().length()-3,filtroCadena.get(3).trim().length()));
           hooksMainframe.saveIntoLog("CVV "+ filtroCadena.get(2).substring(filtroCadena.get(2).trim().length()-3,filtroCadena.get(2).trim().length()));
        }else if ( tipoPAN.equals("VISA") ){
           hooksMainframe.saveIntoLog("PIN "+ filtroCadena.get(0).substring(0,4));
           hooksMainframe.saveIntoLog("PVV "+ filtroCadena.get(0).substring(4,8));
           hooksMainframe.saveIntoLog("CVV2 "+ filtroCadena.get(0).substring(8,11));
           hooksMainframe.saveIntoLog("CVV "+ filtroCadena.get(0).substring(11,14));
        }else if (tipoPAN.equals("MC")){
           hooksMainframe.saveIntoLog("PIN "+ filtroCadena.get(0).substring(0,4));
           hooksMainframe.saveIntoLog("PVV "+ filtroCadena.get(0).substring(4,8));
           hooksMainframe.saveIntoLog("CVV2 "+ filtroCadena.get(0).substring(8,11));
           hooksMainframe.saveIntoLog("CVV "+ filtroCadena.get(0).substring(11,14));
        }
        hooksMainframe.saveIntoLog("--------------------------------------------------------------------");
        takeEvidence();
    }
}
