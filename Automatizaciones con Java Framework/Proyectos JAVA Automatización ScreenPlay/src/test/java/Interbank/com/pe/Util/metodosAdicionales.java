package Interbank.com.pe.Util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Date;
import java.util.Locale;

public class metodosAdicionales {

    DecimalFormat df = new DecimalFormat("#.00");
    String dayOfWeek;

    public String menorMin(String a){
        double mMin = Double.parseDouble(a)/2;
        return df.format(mMin);
    }

    public String mayorFull(String a, String b){
        if(a == b) {
            double mFull = Double.parseDouble(a) + 10;
            return df.format(mFull);
        } else if (a.equals("0.00")) {
            double mFull = Double.parseDouble(b) + 10;
            return df.format(mFull);
        } else{
            double mFull = Double.parseDouble(a) + Double.parseDouble(b);
            return df.format(mFull);
        }
    }

    public String mayorMinmenorFull(String a, String b){
        double mMinmFull = Math.random()*(Double.parseDouble(b)-Double.parseDouble(a))+Double.parseDouble(a);
        return df.format(mMinmFull);
    }

    public String truncarPAN(String a){
        String pan = "";
        if(a.length() == 16 ){
            pan = a.substring(0,6) + "******" + a.substring(12) +"\n";
        }else if(a.length() == 15 ){
            pan = a.substring(0,6) + "*****" + a.substring(11) +"\n";
        } else{
            System.out.println("PAN erroneo" + "\n");
        }
        return pan;
    }

    public boolean obtenerDia(String dia){
        LocalDate today = LocalDate.now();
        dayOfWeek = today.getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("es", "ES"));

        if (dia.equals(dayOfWeek.toLowerCase())){
            return true;
        } else {
            return false;
        }
    }

    public boolean obtenerFecha(String dia) {
        String fecha = "";

        SimpleDateFormat format= new SimpleDateFormat("yyyyMMdd");
        Date date = new Date(System.currentTimeMillis());
        fecha = format.format(date);

        if (fecha.equals(dia)){
            return true;
        } else {
            return false;
        }
    }

    public String getResultado(String trama){
        return trama.substring(0, 2800);
    }

}
