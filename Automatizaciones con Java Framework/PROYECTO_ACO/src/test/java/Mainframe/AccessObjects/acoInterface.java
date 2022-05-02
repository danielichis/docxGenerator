package Mainframe.AccessObjects;

import org.junit.Assert;
import tools.mainframe.helperMainframe;
import tools.mainframe.hooks;

import java.util.ArrayList;
import java.util.List;

public class acoInterface extends helperMainframe {
    hooks HooksMainframe = new hooks();

    public static final String TRANSACCIONESPROCESADASEMISOR = "01";
    public static final String TRANSACCIONESPROCESADASADQUIRIENTE = "02";
    public static final String RELACIONDEPROCESOSENCONTROVERSIAS = "03";
    public static final String MANTENIMIENTODETRANSACCIONESAVENCER = "04";
    public static final String MANTENIMIENTODETRANSACCIONESCIERREDECASOS = "05";
    public static final String TRATAMIENTODEERRORESINCOMINGNSAT = "06";
    public static final String TRATAMIENTODEINCIDENCIASADQUIRIENTEEMISOR = "07";
    public static final String TRANSACCIONESDELDIAENCONTROVERSIAS = "08";
    public static final String RELACIONDECOMISIONESDEBITO = "09";
    public static final String MANTENIMIENTOINCIDENCIASCONTROVERSIAS = "10";
    public static final String RELACIONDERECLAMOSCRM = "11";
    public static final String TRANSACCIONESASIGNADASAUNRECLAMO = "12";
    public static final String RELACIONDEABONOCARGOPROCESADO = "13";
    public static final String TRATAMIENTODEMENSAJEDEFRAUDES = "14";
    public static final String MANTENIMIENTODEPARAMETROS = "15";
    public static final String ATENCIONDERECLAMOS = "16";


    public void ingresoALaAplicacionDentroDelSISTEMAADMINISTRADORDECONTROVERSIAS(String aplicacion) throws InterruptedException {
        boolean flag = false;
        waitText(aplicacion, 3000);
        switch (aplicacion.replace(" ", "")) {
            case "TRANSACCIONESPROCESADASEMISOR":
                writeTextIntoConsole(TRANSACCIONESPROCESADASEMISOR);
                waitText("INGRESE OPCIóN: " + TRANSACCIONESPROCESADASEMISOR, 3000);
                enter();

        }

        flag = waitText("RELACION DE TRANSACCIONES EMISOR", 3000);
        takeEvidence();
        if (flag == false) {
            leerPantalla().toString();
        }
        Assert.assertTrue(flag);


    }

    public void realizoLaConsultaDeLaTarjeta(String tarjeta) throws InterruptedException {
        boolean flag = false;
        waitText("RELACION DE TRANSACCIONES EMISOR", 3000);
        writeTextIntoConsole(tarjeta);
        enter();
        flag = waitText(" NºTARJETA: " + tarjeta.substring(0, 3), 3000);
        takeEvidence();
        if (flag == false) {
            leerPantalla().toString();
        }

        Assert.assertTrue(flag);

    }

    public void realizoLaControversiaDeLaTransaccionConMonto(String codigoTransaccion, String monto) throws InterruptedException {

        int actualOption = 0;
        int actualPage=0;
        int paginasValidadas=0;
        boolean found=false;


        List<String> listaTransacciones=new ArrayList<>();


        //validar si el monto esta duplicado
        int cantidadRepeticiones = String.join(",", listaTransacciones).split(monto).length;
        listaTransacciones= getTransacciones();


        if (codigoTransaccion.equals("")) {
            //SELECIONARA EL PRIMERO QUE ENCUENTRE, NO VALIDARA TRANSACCIONES DUPLICADAS
            while (found==false){
             //iterar transacciones
            for (String operaciones : listaTransacciones) {
                if (operaciones.substring(41, 52).trim().equals(monto.trim())) {
                    pf(10);
                    realizaraltadeControversia();
                    found=true;
                    break;
                }else {
                    down();
                }
            }
                //pasar a siguiente pagina
                if (found==false){
                    pf(8);
                    paginasValidadas+=1;
                    boolean validarPage=waitText("ULTIMA PAGINA",500);
                    if (listaTransacciones.containsAll( getTransacciones()) && validarPage ){
                        System.out.println("No se encuentra dicho monto - paginas validadas:"+paginasValidadas);
                        found=true;
                        Assert.fail();
                    }else {
                        listaTransacciones= getTransacciones();
                    }
                }
            }

        } else {

            //ITERARA HASTA ENCONTRAR LA TRANSACCION Y CODIGO CORRECTO
            while (found==false){

            for (String operaciones : listaTransacciones) {

                if (operaciones.substring(41, 52).trim().equals(monto.trim())) {
                    boolean validaringreso=false;
                    int timeout=0;
                    while (validaringreso==false && timeout<3){
                        pf(10);
                        Thread.sleep(1000);
                        timeout+=1;
                        validaringreso=waitText("Cod.Trans.:",100);
                    }
                    System.out.println("Ingreso a detalle en "+ timeout);
                    if (validaringreso==false){
                        System.out.println("no se puede ingresar a detalle transaccion, timeout");
                        ascii();
                        System.out.println("error ->"+ leerPantalla().toString()+"<- error");
                        Assert.fail();
                    }
                    ascii();
                    String getpantalla=leerPantalla().toString();


                    if (getpantalla.contains(codigoTransaccion.trim())){
                        realizaraltadeControversia();
                        found=true;
                        break;
                    }else {
                        pf(3);
                        waitText("SEC ESTABLECIMIENTO ",3000);
                        down();
                    }

                }else {
                    down();
                }
            }

            //pasar a siguiente pagina
            if (found==false){
                pf(8);
                paginasValidadas+=1;
                boolean validarPage=waitText("ULTIMA PAGINA",800);
                if (listaTransacciones.containsAll( getTransacciones()) && validarPage){
                    System.out.println("No se encuentra dicho monto - paginas validadas:"+paginasValidadas);
                    found=true;
                    Assert.fail();
                }else {
                    listaTransacciones= getTransacciones();
                }
            }

            }





        }





    }

    public void realizaraltadeControversia() throws InterruptedException {

        //ALTA ADICIONAL
        pf(10);
        boolean procesoencontroversia=waitText("ALTA NO PROCEDE POR TENER PROCESO EN CONTROVERSIA PENDIENTE",3000);
        takeEvidence();
        if (procesoencontroversia){
            ascii();
            System.out.println("Transaccion ya en tramite");
            System.out.println(leerPantalla().toString());
            Assert.fail();
        }










    }

    public  List<String> getTransacciones(){
        ascii();
        String pantalla = leerPantalla().toString();

        String filtro1 = pantalla.substring(pantalla.indexOf("  SEC ESTABLECIMIENTO         FECHA TRAN."));

        String separador = "*-----------------------------------------------------------------------------*";
        String filtro2 = filtro1.substring(filtro1.indexOf(separador) + separador.length());

        List<String> listaTransacciones = new ArrayList<String>();
        for (String e : filtro2.substring(0, filtro2.indexOf(separador)).split("data:")) {
            if (e.trim().length() > 3) {
                listaTransacciones.add(e.trim());
            }
        }
        return  listaTransacciones;

    }


    public void ingresoElCodigoReclamoConCodigoTransaccionCodigoRazonRzMsgFrauYMsjTexto(String codigoreclamo, String codigotransaccion, String codigorazon,String indDoc, String codigofraude, String mensaje) throws InterruptedException {
        boolean reclamopreviamenteNorevisado=waitText("PRESIONE PF10 PARA ASIGNAR RECLAMO",2000);
        boolean transaccionyaentramite=false;
        if (reclamopreviamenteNorevisado==false){
             transaccionyaentramite=waitText("TRANSAC.ORIGEN YA FIGURA EN MODULO DE TRANSACCIONES DEL DIA",4000);
        }

        if (transaccionyaentramite){
            ascii();
            System.out.println("Transaccion ya en tramite");
            System.out.println(leerPantalla().toString());

            takeEvidence();

            Assert.fail();
        }
        if (reclamopreviamenteNorevisado==true){

            writeTextIntoConsole(codigoreclamo);
            waitText("RECLAMO: "+codigoreclamo,30);
            pf(10);
            enter();
        }
        boolean ismastercard= waitText("MASTERCARD",800);

        boolean reclamoestado1= waitText("E1 En Tram",800);

        if (reclamoestado1){

            if (ismastercard){
                writeTextIntoConsole(codigotransaccion);
                waitText("COD.TRAN.: "+codigotransaccion,30);
                if (codigotransaccion.length()<3){
                    tab();
                }
                writeTextIntoConsole(codigorazon);
                waitText("COD.RAZ: "+codigorazon,30);
                if (codigorazon.length()<4){
                    tab();
                }

                writeTextIntoConsole(indDoc);
                waitText("IND.DOC. "+indDoc,30);
                if (indDoc.length()<2){
                    tab();
                }
                tab();

                writeTextIntoConsole(codigofraude);
                waitText("FRAU: "+codigofraude,30);
                if (codigofraude.length()<3){
                    tab();
                }
                tab();
                tab();
                tab();
                tab();
                writeTextIntoConsole(mensaje);
                waitText("MSG.TEXTO : "+mensaje,30);

            }else {
                boolean isLocal=waitText("FEC.REC:",1000);

                if (!isLocal){


                writeTextIntoConsole(codigotransaccion);
                waitText("COD.TRAN.: "+codigotransaccion,30);
                if (codigotransaccion.length()<3){
                    tab();
                }
                writeTextIntoConsole(codigorazon);
                waitText("COD.RAZ: "+codigorazon,30);
                if (codigorazon.length()<4){
                    tab();
                }
                tab();
                writeTextIntoConsole(codigofraude);
                waitText(codigofraude,30);
                if (codigofraude.length()<3){
                    tab();
                }
                writeTextIntoConsole(mensaje);
                waitText(mensaje,30);

            }else {
                    //internacional

                    writeTextIntoConsole(codigotransaccion);
                    waitText("COD.TRAN.: "+codigotransaccion,30);
                    if (codigotransaccion.length()<3){
                        tab();
                    }
                    writeTextIntoConsole(codigorazon);
                    waitText("COD.RAZ: "+codigorazon,30);
                    if (codigorazon.length()<4){
                        tab();
                    }
                    tab();

                    writeTextIntoConsole(codigofraude);
                    waitText(codigofraude,30);
                    if (codigofraude.length()<3){
                        tab();
                    }
                    tab();
                    tab();
                    tab();
                    tab();
                    writeTextIntoConsole(mensaje);
                    waitText("MSG.TEXTO : "+mensaje,30);

                }






            }


        }


        takeEvidence();




    }

    public void validoLaAltaDeLaControversia() throws InterruptedException {

        //INGRESAR
        pf(2);
        boolean flagvalidarIngresoCorrecto= waitText("VALIDACION CORRECTA, PUEDE INGRESAR",3000);
        if (flagvalidarIngresoCorrecto==true){
            //CONFIRMAR
            pf(2);
            boolean flagFlujoTerminado= waitText("REGISTRO INGRESADO SATISFACTORIAMENTE",3000);
            if (flagFlujoTerminado==false){
                ascii();
                takeEvidence();
                System.out.println("FAIL FLOW");
                Assert.fail();
            }else {
                takeEvidence();
                System.out.println("CORRECT FLOW");
            }
        }else {
            ascii();
            System.out.println("LOG ERROR");
            takeEvidence();
            Assert.fail();
        }



    }
}

