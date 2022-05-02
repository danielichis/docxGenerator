package tools.mainframe.helpers;
import tools.mainframe.Hooks;
import java.io.IOException;

public class Thread3270 implements Runnable {
    private StringBuilder value;
    @Override
    public void run() {
        StringBuilder cadena = new StringBuilder();
        try { while (Hooks.lectura.available() == 0) { }
        while (Hooks.lectura.available() > 0) { cadena.append((char) Hooks.lectura.read()); }
        } catch (IOException ex) { cadena = null; } finally { value = cadena; }
    }

    public StringBuilder leerPantallad() {
        return value;
    }


}
