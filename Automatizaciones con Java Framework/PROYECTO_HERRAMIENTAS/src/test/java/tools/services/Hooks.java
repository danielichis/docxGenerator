package tools.services;
import tools.SessionManager;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Hooks extends SessionManager {
    private static Hooks instancia = null;
    public static void setEvidence(String text) {
        SessionManager.scenario = SessionManager.obternerSesion("scenario");
        SessionManager.scenario.write(text);
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


    public static String mapToString(HashMap<String, String> detalles){
        String mapAsString = detalles.keySet().stream()
                .map(key -> key + "->" + detalles.get(key))
                .collect(Collectors.joining("\n"));
        return mapAsString;
    }

    public static void saveIntoLog(String log){

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




