package Mainframe.AccessObjects;
import org.junit.Assert;
import tools.mainframe.helpers.HelperMainframe;
public class HelperInterface extends HelperMainframe {
    public void validoMensajeUnicoPorAplicacion(String aplicacion) throws InterruptedException {
        String mensajeReferente="";
        switch (aplicacion.toLowerCase()){
            case "sys":
                mensajeReferente="APLICACIONES SYSTEMATICS";
            break;
            case "aco":
                mensajeReferente="SISTEMA ADMINISTRADOR DE CONTROVERSIAS";
                break;
            case "trj":
                mensajeReferente="TRJO001";
                break;
        }
        boolean flag=waitText(mensajeReferente,9000);
        takeEvidence();
        Assert.assertTrue(flag);
    }
}
