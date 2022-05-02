package tools.mainframe;

import java.io.IOException;

public class helperMainframe {



    protected static final String PF= "PF";
    protected static final String PA= "PA";
    protected static final String DOWN= "DOWN";
    protected static final String UP= "UP";
    protected static final String RIGHT= "RIGHT";
    protected static final String LEFT= "LEFT";
    protected static final String HOME= "HOME";
    protected static final String INSERT= "INSERT";
    protected static final String CLEAR= "CLEAR";
    protected static final String ENTER = "ENTER";
    protected static final String ASCII = "ascii";
    protected static final String PASTECLIPBOARD = "PASTE";
    protected static final String QUITWS3270 = "QUIT";
    protected static final String RESETLOCKEDKEYBOARD="RESET";
    protected static final String DELETELASTCHARACTER="ERASE";

    public boolean waitText(String text, Integer milis) throws InterruptedException {
        System.out.println("Esperando elemento");
        boolean encontrado=false;
        Integer cont=0;
        String getText= "";

        while (!encontrado){
            Thread.sleep(1);
            cont+=1;
            limpiarConcatenacion();
            ascii();
            if(milis<cont){
                break;
            }
            getText= leerPantalla().toString();
            encontrado = getText.toLowerCase().contains(text.toLowerCase());
        }
        if (encontrado){
            System.out.println("\""+text+"\"" +" -" +" Elemento encontrado"+ "-Tiempo respuesta " + cont +" milisegundos" );
        }else {
            System.out.println("\""+text+"\"" +" -" +" Elemento no encontrado"+ "- Tiempo respuesta " + cont +" milisegundos" );
        }
        return encontrado;
    }

    public StringBuilder leerPantalla() {
            Integer i = 0;
            StringBuilder cadena = new StringBuilder();
            try {
                while (hooks.lectura.available() == 0 && i++ < 1000) {
                    Thread.sleep(1);
                }
                if (i>900){
                    System.out.println("NO CARGA SERVICIO");

                }
                while (hooks.lectura.available() > 0) {
                    cadena.append((char) hooks.lectura.read());
                }

            } catch (IOException ex) {
                cadena = null;
            } finally {
                return cadena;
            }
        }




    public void takeEvidence(){
        limpiarConcatenacion();
        ascii();
        String getText= leerPantalla().toString();
        hooks.getEvidence(getText);
    }

    public void limpiarConcatenacion(){
        hooks.teclado.flush();
    }

    public void writeConsoleComand(String cadena) {
        insertCommandandNoWaitresult(cadena);
    }

    public void writeTextIntoConsole(String cadena){
        writeConsoleComand("String \""+cadena.trim()+"\"");
    }


    public void tab(){
        insertCommandandNoWaitresult("TAB");
    }


    public void ascii() {
        insertCommandandNoWaitresult(ASCII);
    }

    public void pf (int Number) {
        insertCommandandNoWaitresult(PF+"("+Number+")");
        }

    public void pa (int Number) {
        insertCommandandNoWaitresult(PA +"("+Number+")");
    }

    public void down () {
        insertCommandandNoWaitresult(DOWN);
    }

    public void up () {
        insertCommandandNoWaitresult(UP);
    }

    public void right () {
        insertCommandandNoWaitresult(RIGHT);
    }

    public void left () {
        insertCommandandNoWaitresult(LEFT);
    }

    public void home () {
        insertCommandandNoWaitresult(HOME);
    }

    public void insert () {
        insertCommandandNoWaitresult(INSERT);
    }

    public void deleteLstCharacter(){
        insertCommandandNoWaitresult(DELETELASTCHARACTER);
    }

    public void clear () {
        insertCommandandNoWaitresult(CLEAR);
    }

    public boolean waitText(String text, Integer seconts,String command) throws InterruptedException {
        System.out.println("Esperando elemento");
        boolean encontrado=false;
        Integer cont=0;
        String getText= "";

        while (!encontrado && seconts>cont){

            Thread.sleep(1);
            cont+=1;

            limpiarConcatenacion();
            ascii();
            insertCommandandNoWaitresult(command);


            limpiarConcatenacion();
            ascii();
            getText= leerPantalla().toString();
            encontrado = getText.toLowerCase().contains(text.toLowerCase());



        }
        if (encontrado){
            System.out.println("\""+text+"\"" +" -" +" Elemento encontrado"+ "-Tiempo respuesta " + cont +" milisegundos" );
        }else {
            System.out.println("\""+text+"\"" +" -" +" Elemento no encontrado"+ "- Tiempo respuesta " + cont +" milisegundos" );
        }
        return encontrado;
    }


    public  boolean getResult(String cadena){
        boolean result= false;
        cadena += "\n";
        limpiarConcatenacion();
        ascii();
        hooks.teclado.write(cadena);
        hooks.teclado.flush();
        String readScreen=leerPantalla().toString().toLowerCase();
        result=readScreen.toLowerCase().contains("ok");
        return result;
    }
    public void insertComandandWaitResult(String cadena, int Time) throws InterruptedException {
        int i=0;

        while(!getResult(cadena) && i++<Time){
            Thread.sleep(1000);
        }


    }

    public void insertCommandandNoWaitresult(String cadena) {
        cadena += "\n";
        hooks.teclado.write(cadena);
        hooks.teclado.flush();
    }



    public void enter () {
        insertCommandandNoWaitresult(ENTER);
    }

    public void pasteclipboard(){
        insertCommandandNoWaitresult(PASTECLIPBOARD);
    }

    public void quitws3270(){
        insertCommandandNoWaitresult(QUITWS3270);
    }
    public void resetlockedkeyboard(){
        insertCommandandNoWaitresult(RESETLOCKEDKEYBOARD);
    }






}
