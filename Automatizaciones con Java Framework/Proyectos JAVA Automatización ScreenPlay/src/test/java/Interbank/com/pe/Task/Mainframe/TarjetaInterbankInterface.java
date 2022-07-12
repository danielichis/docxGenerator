package Interbank.com.pe.Task.Mainframe;

public class TarjetaInterbankInterface extends HelperInterface {

    public boolean realizoLaConsultaDeLaEnTRJSystematics(String tarjeta) throws InterruptedException {
        boolean flag = false;
        waitText("Consultas", 9000);
        writeTextIntoConsole("02");
        enter();
        waitCommandResult(3000);
        waitText("02. Tarjeta", 9000);
        writeTextIntoConsole("02");
        writeTextIntoConsole(tarjeta);
        takeEvidence();
        enter();
        waitCommandResult(3000);
        flag = waitText("Numero tarjeta", 9000);
        limpiarConcatenacion();
        takeEvidence();
        return flag;
    }

}
