using OpenQA.Selenium;
using OpenQA.Selenium.Interactions;
using OpenQA.Selenium.Support.UI;
using PrepagoCuotas_Trax350.userInterfaces;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using PrepagoCuotas_Trax350.Util;
using System.Threading;
using System.Threading.Tasks;
using WindowsInput;

namespace PrepagoCuotas_Trax350.Tasks
{
    public class transaccionHistorial
    {
        public void historialTransacion()
        {
            InputSimulator sim = new InputSimulator();

            Thread.Sleep(9000);
            sim.Keyboard.KeyPress(WindowsInput.Native.VirtualKeyCode.F3);
            Thread.Sleep(9000);
            
            historialUI historia = new historialUI();
            SelectElement selectElementTipoPago = new SelectElement(historia.listResultado);

            IList<IWebElement> elementCount = selectElementTipoPago.Options;
            int iSize = elementCount.Count;

            Console.WriteLine("cantidad de elementos:" + iSize);
            DateTime fechaInicio = new DateTime();
            DateTime fechaHistoriaInicio = new DateTime();
            TimeSpan diferenciaHoras = new TimeSpan();

            for (int i = 0; i < iSize; i++)
            {
                String sValue = elementCount.ElementAt(i).Text;
                Console.WriteLine("lista historial:" + sValue);

                if (sValue.Contains("*")& sValue.Substring(10, 1).Contains("2"))
                {
                    int numLong = sValue.Length;
                    int numValor = sValue.IndexOf("S/");
                    int resultado = numLong - numValor;

                    Console.WriteLine("item1:" + numLong);
                    Console.WriteLine("item2:" + numValor);
                    Console.WriteLine("resultado:" + resultado);

                    Console.WriteLine("item de historial:" + sValue);
                    Console.WriteLine("Hora String" + sValue.Substring(0, 3));
                    Console.WriteLine("minuto String:" + sValue.Substring(3, 2));
                    Console.WriteLine("sec:" + sValue.Substring(10, 1));
                    Console.WriteLine("tienda:" + sValue.Substring(6, 3));
                    Console.WriteLine("estado:" + sValue.Substring(12, 7));
                    Console.WriteLine("monto:" + sValue.Substring(sValue.IndexOf("S/")+2, resultado-4));
                    
                    //Console.WriteLine("valor a aceptar:" + sValue.Substring(0, 3)+ sValue.Substring(3, 2)+" "+ sValue.Substring(6, 3)+ " " + sValue.Substring(10, 1)+"  "+ sValue.Substring(12, 7)+ "  .          " + sValue.Substring(sValue.IndexOf("S/"), resultado));
                    
                    fechaHistoriaInicio = DateTime.Parse(sValue.Substring(0, 3) + sValue.Substring(3, 2));
                    //variables.fechaInicio = utilidad.horaHistorial();
                    fechaInicio = DateTime.Parse(variables.fechaInicio);

                    Console.WriteLine("fechaHistoriaInicio:" + fechaHistoriaInicio);
                    Console.WriteLine("fechaInicio:" + fechaInicio);
                    diferenciaHoras = fechaHistoriaInicio - fechaInicio;
                    double minutos = diferenciaHoras.TotalMinutes;
                    Console.WriteLine("diferencia horas:" + diferenciaHoras);
                    Console.WriteLine("diferencia minutos:" + minutos);

                    /*
                    Console.WriteLine("inicia IJavaScriptExecutor");
                    IJavaScriptExecutor jse = (IJavaScriptExecutor)variables.driver;
                    jse.ExecuteScript("var select = arguments[0]; select.value=arguments[1]", historia.listResultado, i);
                    Thread.Sleep(500);
                    jse.ExecuteScript("arguments[0].onchange();", historia.listResultado);
                    Console.WriteLine("termino IJavaScriptExecutor");
                    return;*/


                    if (minutos <= 0 & minutos >=-4)
                    {
                        double montoHistorial = Convert.ToDouble(sValue.Substring(sValue.IndexOf("S/") + 2, resultado - 4));
                        variables.montoTransactor = montoHistorial;
                        double montoRealHistorial = montoHistorial + variables.montodiferencia;
                        Console.WriteLine("montoHistorial:" + montoHistorial);
                        Console.WriteLine("montoRealHistorial:" + montoRealHistorial);

                        Console.WriteLine("variables.montoFeature:" + variables.montoFeature);

                        
                        if (variables.montoFeature.Equals(montoRealHistorial))
                        {
                            Console.WriteLine("ingreso IF");
                            Console.WriteLine("inicia IJavaScriptExecutor");
                            IJavaScriptExecutor jse = (IJavaScriptExecutor)variables.driver;
                            jse.ExecuteScript("var select = arguments[0]; select.value=arguments[1]", historia.listResultado, i);
                            Thread.Sleep(500);
                            jse.ExecuteScript("arguments[0].onchange();", historia.listResultado);
                            Console.WriteLine("termino IJavaScriptExecutor");
                            variables.mensajeWeb = "Identificamos la transacción que se realizo";
                            return;
                        }
                    }
                    else
                    {
                        Console.WriteLine("else diferencia minutos:" + minutos);
                    }

                }
                
                Console.WriteLine("item for:" + i);
                Thread.Sleep(3000);
            }

            Thread.Sleep(5000);
        }
    }
}
