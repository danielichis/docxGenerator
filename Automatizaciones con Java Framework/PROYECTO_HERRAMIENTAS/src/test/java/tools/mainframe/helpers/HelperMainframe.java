package tools.mainframe.helpers;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import tools.mainframe.Hooks;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

public class HelperMainframe {
    protected static final String PF = "PF";
    protected static final String PA = "PA";
    protected static final String DOWN = "DOWN";
    protected static final String UP = "UP";
    protected static final String RIGHT = "RIGHT";
    protected static final String LEFT = "LEFT";
    protected static final String HOME = "HOME";
    protected static final String INSERT = "INSERT";
    protected static final String CLEAR = "CLEAR";
    protected static final String ENTER = "ENTER";
    protected static final String ASCII = "ascii";
    protected static final String PASTECLIPBOARD = "PASTE";
    protected static final String QUITWS3270 = "QUIT";
    protected static final String RESETLOCKEDKEYBOARD = "RESET";
    protected static final String DELETELASTCHARACTER = "ERASE";

    public boolean waitText(String text, Integer millis) throws InterruptedException {
        System.out.println("Esperando elemento");
        boolean encontrado = false;
        String getText = "";
        Instant start = Instant.now();
        while (!encontrado) {
            limpiarConcatenacion();
            ascii();
            Thread3270 Thread3270 = new Thread3270();
            Thread thread = new Thread(Thread3270);
            thread.start();
            thread.join(2000);
            thread.interrupt();
            try {
                StringBuilder cadena = Thread3270.leerPantallad();
                getText = cadena.toString();
            } catch (Exception e) {
                getText = "";
            }

            encontrado = getText.toLowerCase().contains(text.toLowerCase());
            Instant end = Instant.now();
            Duration timeElapsed = Duration.between(start, end);
            if (timeElapsed.toMillis() >= millis || encontrado) {
                break;
            }
        }
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        if (encontrado) {
            if (!text.toLowerCase().equals("ok")){
                System.out.println("\"" + text + "\"" + " -" + " Elemento encontrado" + "-Tiempo respuesta " + timeElapsed.toMillis() + " milisegundos");
            }
        } else {
            System.out.println("\"" + text + "\"" + " -" + " Elemento no encontrado" + "- Tiempo respuesta " + timeElapsed.toMillis() + " milisegundos");
        }
        return encontrado;
    }

    public boolean waitText(String[] list, Integer millis) throws InterruptedException {
        System.out.println("Esperando elemento");
        boolean encontrado = false;
        String getText = "";
        Instant start = Instant.now();
        String Keyword="";
        while (!encontrado) {
            limpiarConcatenacion();
            ascii();

            Thread3270 Thread3270 = new Thread3270();
            Thread thread = new Thread(Thread3270);
            thread.start();
            thread.join(2000);
            thread.interrupt();
            try {
                StringBuilder cadena = Thread3270.leerPantallad();
                getText = cadena.toString();
            } catch (Exception e) {
                getText = "";
            }

            for (String e:list){
                if (getText.toLowerCase().contains(e.toLowerCase())){
                    Keyword=e;
                    encontrado =true;
                }
            }
            Instant end = Instant.now();
            Duration timeElapsed = Duration.between(start, end);
            if (timeElapsed.toMillis() >= millis || encontrado) {
                break;
            }
        }
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        if (encontrado) {
            System.out.println("\"" + Keyword + "\"" + " -" + " Elemento encontrado" + "-Tiempo respuesta " + timeElapsed.toMillis() + " milisegundos");
        } else {
            System.out.println("Elementos no encontrado \"" +String.join(" - ",list)  +  "\" Tiempo respuesta " + timeElapsed.toMillis() + " milisegundos");
        }
        return encontrado;
    }


    public boolean waitCommandResult(Integer millis) throws InterruptedException {
        boolean encontrado = false;
        String getText = "";
        Instant start = Instant.now();
        while (!encontrado) {
            limpiarConcatenacion();
            Thread3270 Thread3270 = new Thread3270();
            Thread thread = new Thread(Thread3270);
            thread.start();
            thread.join(2000);
            thread.interrupt();
            try {
                StringBuilder cadena = Thread3270.leerPantallad();
                getText = cadena.toString();
            } catch (Exception e) {
                getText = "";
            }
            encontrado = getText.toLowerCase().contains("ok".toLowerCase());
            Instant end = Instant.now();
            Duration timeElapsed = Duration.between(start, end);
            if (timeElapsed.toMillis() >= millis || encontrado) {
                break;
            }
        }
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        if (encontrado==false){
            System.out.println("Error en recibir respuesta emulador - tiempo verificación-> "+timeElapsed.toMillis() + " ms");
        }else{
            System.out.println("Respuesta EMULADOR - tiempo verificación->  "+timeElapsed.toMillis() + " ms");
        }
        return encontrado;
    }

    public String leerPantalla() throws InterruptedException {
        System.out.println("Obteniendo pantalla");
        boolean encontrado = false;
        String getText = "";
        Instant start = Instant.now();
        StringBuilder cadena = null;
        limpiarConcatenacion();
        ascii();
        Thread3270 Thread3270 = new Thread3270();
        Thread thread = new Thread(Thread3270);
        thread.start();
        thread.join(15000);
        thread.interrupt();
        try {
            cadena = Thread3270.leerPantallad();
//            getText = leerPantalla().toString();
//            encontrado = getText.toLowerCase().contains(text.toLowerCase());
            getText = cadena.toString();
        } catch (Exception e) {
            getText = "";
        }


        return getText;
    }







//    public StringBuilder leerPantalla() throws InterruptedException {
//        limpiarConcatenacion();
//        ascii();
//
//
//        int cont=100;
//        int i=0;
//        StringBuilder cadena=null;
//        while ((cadena==null && i++<=cont)){
//            thread3270 Thread3270 = new thread3270();
//            Thread thread = new Thread(Thread3270);
//            thread.start();
////            thread.join();
//            Thread.sleep(100);
//            thread.interrupt();
//            cadena=Thread3270.leerPantallad();
//
//            System.out.println(i);
//
//        }
//
//        System.out.println(cadena );
//    }


    public StringBuilder leerPantalla2() {
        StringBuilder cadena = new StringBuilder();
        Instant start = Instant.now();
        boolean isOnTime = true;
        try {

            while (Hooks.lectura.available() == 0) {
            }

            while (Hooks.lectura.available() > 0) {
                cadena.append((char) Hooks.lectura.read());
            }


        } catch (IOException ex) {
            cadena = null;
        } finally {
            return cadena;
        }
    }


    public void takeEvidence() throws InterruptedException {
        limpiarConcatenacion();
        String getText = leerPantalla().toString();
        Hooks.setEvidence(getText);
    }

    public JSONObject getAttributesFromJson(String jsonPath) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONArray jsonParse = (JSONArray) parser.parse(new FileReader(jsonPath));
        JSONObject getData = (JSONObject) jsonParse.get(0);
        return getData;
    }


    public void limpiarConcatenacion() {
        Hooks.teclado.flush();
    }

    public void writeConsoleComand(String cadena) {
        insertCommandandNoWaitresult(cadena);
    }

    public void writeTextIntoConsole(String cadena) {
        writeConsoleComand("String \"" + cadena.trim() + "\"");
    }

    public void space() {
        writeConsoleComand("String \" \"");
    }

    public void tab() {
        insertCommandandNoWaitresult("TAB");
    }


    public void ascii() {
        insertCommandandNoWaitresult(ASCII);
    }

    public void pf(int Number) {
        insertCommandandNoWaitresult(PF + "(" + Number + ")");
    }

    public void pa(int Number) {
        insertCommandandNoWaitresult(PA + "(" + Number + ")");
    }

    public void down() {
        insertCommandandNoWaitresult(DOWN);
    }

    public void up() {
        insertCommandandNoWaitresult(UP);
    }

    public void right() {
        insertCommandandNoWaitresult(RIGHT);
    }

    public void left() {
        insertCommandandNoWaitresult(LEFT);
    }

    public void home() {
        insertCommandandNoWaitresult(HOME);
    }

    public void insert() {
        insertCommandandNoWaitresult(INSERT);
    }

    public void deleteLstCharacter() {
        insertCommandandNoWaitresult(DELETELASTCHARACTER);
    }

    public void clear() {
        insertCommandandNoWaitresult(CLEAR);
    }

//    public boolean waitText(String text, Integer seconts, String command) throws InterruptedException {
//        System.out.println("Esperando elemento");
//        boolean encontrado = false;
//        Integer cont = 0;
//        String getText = "";
//        Instant start = Instant.now();
//        while (!encontrado && seconts > cont) {
//
//            Thread.sleep(1);
//            cont += 1;
//
//            limpiarConcatenacion();
//            ascii();
//            insertCommandandNoWaitresult(command);
//
//
//            limpiarConcatenacion();
//            ascii();
//            getText = leerPantalla2(start).toString();
//            encontrado = getText.toLowerCase().contains(text.toLowerCase());
//
//
//        }
//        if (encontrado) {
//            System.out.println("\"" + text + "\"" + " -" + " Elemento encontrado" + "-Tiempo respuesta " + cont + " milisegundos");
//        } else {
//            System.out.println("\"" + text + "\"" + " -" + " Elemento no encontrado" + "- Tiempo respuesta " + cont + " milisegundos");
//        }
//        return encontrado;
//    }


    public boolean getResult(String cadena) throws InterruptedException {
        boolean result = false;
        cadena += "\n";
        limpiarConcatenacion();
        ascii();
        Hooks.teclado.write(cadena);
        Hooks.teclado.flush();
        String readScreen = leerPantalla().toString().toLowerCase();
        result = readScreen.toLowerCase().contains("ok");
        return result;
    }

    public void insertComandandWaitResult(String cadena, int Time) throws InterruptedException {
        int i = 0;

        while (!getResult(cadena) && i++ < Time) {
            Thread.sleep(1000);
        }


    }

    public void insertCommandandNoWaitresult(String cadena) {
        cadena += "\n";
        Hooks.teclado.write(cadena);
        Hooks.teclado.flush();
    }


    public void enter() {
        insertCommandandNoWaitresult(ENTER);
    }

    public void pasteclipboard() {
        insertCommandandNoWaitresult(PASTECLIPBOARD);
    }

    public void quitws3270() {
        insertCommandandNoWaitresult(QUITWS3270);
    }

    public void resetlockedkeyboard() {
        insertCommandandNoWaitresult(RESETLOCKEDKEYBOARD);
    }


}
