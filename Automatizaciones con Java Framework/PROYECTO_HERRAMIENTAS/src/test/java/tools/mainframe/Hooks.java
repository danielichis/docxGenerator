package tools.mainframe;
import tools.SessionManager;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Hooks extends SessionManager {

    private static Hooks instancia = null;
    protected Process emulator;
    public static InputStream lectura;
    public static PrintWriter teclado;
    protected String ws3270exe = getSerenityParams("serenity.ruta.ws3270exe").trim();



    public static void setEvidence(String text) {
        System.out.println(text);
        SessionManager.scenario = SessionManager.obternerSesion("scenario");
        SessionManager.scenario.write(text);
    }


    public Hooks() {
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


    public void saveFacadeEvidence(String log, String nameFile,String dateFormatArchivo,String seqFormatLog){
        saveIntoLog( log, "target/log-operaciones/",nameFile,dateFormatArchivo,seqFormatLog);
        try {
            saveIntoLog( log, getSerenityParams("LOG.RUTA").trim(),nameFile,dateFormatArchivo,seqFormatLog);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            saveIntoLog( log,"//grupoib.local/dfs3/Certificacion/04. Medios de Pago/Automatizaciones/DATACREADA_AUTOMATIZACIONES/",nameFile,dateFormatArchivo,seqFormatLog);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveIntoLog(String log,String ruta, String nameFile,String dateFormatArchivo,String seqFormatLog){
        String destinationDir = ruta;
        File destinationFile = new File(destinationDir);
        if (!destinationFile.exists()) {
            destinationFile.mkdir();
            System.out.println("Carpeta Creada:" + destinationFile.getAbsolutePath());
        }

        try
        {
            String time="";
            if (!dateFormatArchivo.equals("")){
                SimpleDateFormat sdf = new SimpleDateFormat(dateFormatArchivo);
                Date date = new Date();
                time = sdf.format(date);
                String filename= destinationFile.getAbsolutePath()+"/"+time+"_"+nameFile+".txt";
                FileWriter fw = new FileWriter(filename,true);
                SimpleDateFormat sdf2 = new SimpleDateFormat(seqFormatLog);
                fw.write(sdf2.format(date)+": "+ log+"\n");
                fw.close();
            }else {
                String filename = destinationFile.getAbsolutePath() + "/" + nameFile + ".txt";
                FileWriter fw = new FileWriter(filename, true);
                fw.write(log + "\n");
                fw.close();
            }


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

    public static Hooks getInstancia() {
        if (instancia == null) {
            instancia = new Hooks();
        }
        return instancia;
    }











    }




