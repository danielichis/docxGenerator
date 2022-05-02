package Mainframe.AccessObjects;

import org.junit.Assert;
import tools.mainframe.helperMainframe;

public class helperInterface extends helperMainframe {

    public void validoMensajeUnicoPorAplicacion(String aplicacion) throws InterruptedException {
        String mensajeReferente="";
        switch (aplicacion.toLowerCase()){
            case "sys":
                mensajeReferente="APLICACIONES SYSTEMATICS";
            break;
            case "aco":
                mensajeReferente="SISTEMA ADMINISTRADOR DE CONTROVERSIAS";
                break;

        }
        boolean flag=waitText(mensajeReferente,2000);
        limpiarConcatenacion();
        ascii();
        if (flag==false){
            leerPantalla().toString();
        }
        takeEvidence();
        Assert.assertTrue(flag);
    }


}
