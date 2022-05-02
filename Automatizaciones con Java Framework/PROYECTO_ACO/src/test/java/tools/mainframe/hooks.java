package tools.mainframe;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import tools.sessionManager;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class hooks  extends sessionManager{

    private static hooks instancia = null;
    protected Process emulator;
    public static InputStream lectura;
    public static PrintWriter teclado;
    protected String ws3270exe = getSerenityParams("serenity.ruta.ws3270exe").trim();



    public static void getEvidence(String text) {
        sessionManager.scenario = sessionManager.obternerSesion("scenario");
        sessionManager.scenario.write(text);
    }


    public hooks() {
        try {
            this.emulator = Runtime.getRuntime().exec(ws3270exe);
            lectura = this.emulator.getInputStream();
            teclado = new PrintWriter(new OutputStreamWriter(this.emulator.getOutputStream()));
        } catch (FileNotFoundException ef) {
            System.err.println("File Path not found");
            System.exit(1);
        } catch (IOException ex) {
            System.err.println("Error ws3270.exe");
            System.exit(1);
        }
    }


    public void saveFacadeEvidence(String log, String nameFile){
        saveIntoLog( log, "target/log-operaciones/",nameFile);
        try {
            saveIntoLog( log, getSerenityParams("LOG.RUTA").trim(),nameFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            saveIntoLog( log,"//grupoib.local/dfs3/Certificacion/04. Medios de Pago/Automatizaciones/DATACREADA_AUTOMATIZACIONES/",nameFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveIntoLog(String log,String ruta, String nameFile){
        String destinationDir = ruta;
        File destinationFile = new File(destinationDir);
        if (!destinationFile.exists()) {
            destinationFile.mkdir();
            System.out.println("Carpeta Creada:" + destinationFile.getAbsolutePath());
        }

        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            Date date = new Date();
            String time = sdf.format(date);
            String filename= destinationFile.getAbsolutePath()+"/"+time+"_"+nameFile+".txt";
            FileWriter fw = new FileWriter(filename,true);
            SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm a");
            fw.write(sdf2.format(date)+": "+ log+"\n");
            fw.close();
        }
        catch(IOException ioe)
        {
            System.err.println("IOException: " + ioe.getMessage());
        }
    }
    public void saveIntoLog(String log){

        String destinationDir = "target/log-operaciones/";
        File destinationFile = new File(destinationDir);
        if (!destinationFile.exists()) {
            destinationFile.mkdir();
            System.out.println("Carpeta Creada:" + destinationFile.getAbsolutePath());
        }

        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            Date date = new Date();
            String time = sdf.format(date);
            String filename= destinationFile.getAbsolutePath()+"/"+time+".txt";
            FileWriter fw = new FileWriter(filename,true);
            SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm a");
            fw.write(sdf2.format(date)+": "+ log+"\n");
            fw.close();
            System.out.println(log);
        }
        catch(IOException ioe)
        {
            System.err.println("IOException: " + ioe.getMessage());
        }




    }

    public static hooks getInstancia() {
        if (instancia == null) {
            instancia = new hooks();
        }
        return instancia;
    }











}




