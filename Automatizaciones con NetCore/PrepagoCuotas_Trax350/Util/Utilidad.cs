using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Threading.Tasks;

using System.Management.Automation;
using System.Diagnostics;
using System.Drawing;
using System.Threading;
using OpenQA.Selenium.IE;
using OpenQA.Selenium;
using WindowsInput;
using OpenQA.Selenium.Support.UI;
using WindowsInput.Native;

namespace PrepagoCuotas_Trax350.Util
{
    public class utilidad
    {
        static int valor = 1;


        public utilidad()
        {
        }

        public static void esperarElement(IWebElement element, TimeSpan timeSeconts)
        {
            WebDriverWait wait = new WebDriverWait(variables.driver, timeSeconts);
            wait.Until(ElementNotVisibleException => element);
        }
        public static void ExecuteClic(IWebElement element)
        {
            IJavaScriptExecutor jse = (IJavaScriptExecutor)variables.driver;
            jse.ExecuteScript("arguments[0].onclick();", element);
        }

        public static void comboBoxSelectText(IWebElement element, String valor)
        {
            IJavaScriptExecutor jse = (IJavaScriptExecutor)variables.driver;
            jse.ExecuteScript("var select = arguments[0];  for (var i = 0; i < select.options.length; i++) { if (select.options[i].text == arguments[1]) { select.options[i].selected = true; } }", element, valor);
        }
        public static void comboBoxExecuteEvent(IWebElement element)
        {
            IJavaScriptExecutor jse = (IJavaScriptExecutor)variables.driver;
            jse.ExecuteScript("arguments[0].onchange();", element);
        }

        public static void virtualKeyboardSendKeys(String valor)
        {
            InputSimulator sim = new InputSimulator();
            sim.Keyboard.TextEntry(valor);
        }

        public static void virtualKeyboardOptionEnter()
        {
            InputSimulator sim = new InputSimulator();
            // sim.Keyboard.KeyPress(WindowsInput.Native.VirtualKeyCode.ENTER);
            //sim.Keyboard.ModifiedKeyStroke(WindowsInput.Native.VirtualKeyCode.MENU,WindowsInput.Native.VirtualKeyCode.LMENU);
            //sim.Keyboard.ModifiedKeyStroke(VirtualKeyCode.MENU, VirtualKeyCode.VK_L);
            sim.Keyboard.KeyPress(VirtualKeyCode.TAB);
            sim.Keyboard.KeyPress(VirtualKeyCode.TAB);
            sim.Keyboard.KeyPress(VirtualKeyCode.SPACE);
        }

        public static void virtualKeyboardOptionAceptarV()
        {
            InputSimulator sim = new InputSimulator();
            sim.Keyboard.KeyPress(VirtualKeyCode.RETURN);
        }

        public static string horaHistorial()
        {
            return DateTime.Now.Hour + ":" + DateTime.Now.Minute;
        }
        public void aceptarAlerta()
        {
            IAlert alerta = variables.driver.SwitchTo().Alert();
            utilidad.tiempoEspera();
            alerta.Accept();
        }

        public static List<String> arregloEvidencia(String ruta)
        {
            List<string> elementos = new List<string>();
            elementos.Add(ruta);
            variables.cantidadEvidencia = elementos;
            return elementos;
        }
        public void configSteps(String plataforma)
        {
            variables.canal = plataforma;
            if (variables.driver == null & plataforma == "Web")
            {
                variables.driver = new InternetExplorerDriver();
            }
            variables.rutaEvidencia = "";
            variables.estadoCics = "";
            variables.mensajeCics = "";
            variables.mensajeWeb = "";
        }
        public void cerrarDriver()
        {
            variables.driver.Quit();
            variables.driver.Dispose();
            variables.driver = null;
        }

        public static String cadena()
        {
            String val = "000" + valor + "\\";
            valor = valor + 1;
            String resultado = "";
            if (val.Length <= 5)
            {
                resultado = val.Replace("000", "00");
            }
            return resultado;
        }

        public void escribirLog()
        {
            config variable = new config();
            System.IO.Directory.CreateDirectory(directorioPrincipal() + "\\historial\\" + calcularFecha() + "\\");
            StreamWriter file = new StreamWriter(directorioPrincipal() + "\\historial\\" + calcularFecha() + "\\" + calcularFecha() + variable.nombreLog + ".txt", true);

            if (variables.mensajeCics != "")
            {
                file.WriteLine(calcularFechaHora() + variables.mensajeCics);
            }
            if (variables.mensajeWeb != "")
            {
                file.WriteLine(calcularFechaHora() + variables.mensajeWeb);
            }
            file.Close();
        }
        public void escribirLogPerzonalizado(String mensaje)
        {
            config variable = new config();
            System.IO.Directory.CreateDirectory(directorioPrincipal() + "\\historial\\" + calcularFecha() + "\\");
            StreamWriter file = new StreamWriter(directorioPrincipal() + "\\historial\\" + calcularFecha() + "\\" + calcularFecha() + variable.nombreLog + ".txt", true);
            file.WriteLine(calcularFechaHora() + mensaje);

            file.Close();
        }

        public static void escribirArchivo(String rutaCompleta, String nombreArchivo, String texto)
        {

            StreamWriter file = new StreamWriter(rutaCompleta + "\\" + nombreArchivo + ".txt", true);
            file.WriteLine(texto);
            file.Close();
        }
        public String creardirectorioPrincipal()
        {
            /*var CurrentDirectory = Directory.GetCurrentDirectory();
            var pro = CurrentDirectory.Substring(0, CurrentDirectory.IndexOf("\\bi"));
            Console.WriteLine("directorio pro:" + pro);*/

            var directorioEvidencia = directorioPrincipal() + "\\Screenshot\\" + DateTime.Now.Day + DateTime.Now.Month + DateTime.Now.Year + DateTime.Now.Hour + DateTime.Now.Minute + DateTime.Now.Second + "\\";
            Directory.CreateDirectory(directorioEvidencia);
            Console.WriteLine("directoriodirectorioEvidencia:" + directorioEvidencia);
            return directorioEvidencia;
        }

        public static String calcularFechaHora()
        {
            String dia = DateTime.Now.Day + "";
            String mes = DateTime.Now.Month + "";

            String hora = DateTime.Now.Hour + "";
            String minuto = DateTime.Now.Minute + "";
            String segundo = DateTime.Now.Second + "";

            String diaReal = "";
            String mesReal = "";

            String horaReal = "";
            String minutoReal = "";
            String segundoReal = "";

            if (dia.Length == 1)
            {
                diaReal = "0" + dia;
            }
            if (mes.Length == 1)
            {
                mesReal = "0" + mes;
            }

            horaReal = hora;
            minutoReal = minuto;
            segundoReal = segundo;

            if (hora.Length == 1)
            {
                horaReal = "0" + hora;
            }
            if (minuto.Length == 1)
            {
                minutoReal = "0" + minuto;
            }
            if (segundo.Length == 1)
            {
                segundoReal = "0" + segundo;
            }

            return diaReal + mesReal + DateTime.Now.Year + "-" + horaReal + ":" + minutoReal + ":" + segundoReal + " ";
        }
        public static String calcularFecha()
        {
            String dia = DateTime.Now.Day + "";
            String mes = DateTime.Now.Month + "";

            String diaReal = "";
            String mesReal = "";

            diaReal = dia;
            mesReal = mes;

            if (dia.Length == 1)
            {
                diaReal = "0" + dia;
            }
            if (mes.Length == 1)
            {
                mesReal = "0" + mes;
            }

            return diaReal + mesReal + DateTime.Now.Year;
        }

        public String crearEvide(String crearDirectorio)
        {
            var directorioEvidencia = crearDirectorio + cadena();
            Directory.CreateDirectory(directorioEvidencia);
            Console.WriteLine("directorio crearEvide:" + directorioEvidencia);
            return directorioEvidencia;
        }
        public string directorioPrincipal()
        {
            var CurrentDirectory = Directory.GetCurrentDirectory();
            var pro = CurrentDirectory.Substring(0, CurrentDirectory.IndexOf("\\bi"));
            Console.WriteLine("directorio pro:" + pro);

            return pro;

        }
        public void capturaWeb()
        {

            var ubicacionExe = directorioPrincipal() + "\\lib\\Captura_Screen.exe";

            Console.WriteLine("directorio ubicacionExe:" + ubicacionExe);
            var ps = PowerShell.Create();
            Console.WriteLine("ubicacionexe:" + ubicacionExe);
            String evidenci = variables.evidencia + "" + DateTime.Now.Day + DateTime.Now.Month + DateTime.Now.Year + "_" + DateTime.Now.Hour + DateTime.Now.Minute + DateTime.Now.Second + DateTime.Now.Millisecond;
            ps.AddScript("cmd.exe /C " + ubicacionExe + " " + evidenci).Invoke();
            variables.rutaEvidencia = evidenci + ".jpg";
            Console.WriteLine("directorio capturaWeb:" + variables.rutaEvidencia);
        }

        public static void tiempoEspera()
        {
            Thread.Sleep(1000);
        }

      //  public void Redraw()
      //  {
      //      Thread.Sleep(2000);
      //      Console.WriteLine("ejemplo prueba:" + variables.TN3270.CurrentScreenXML.Dump());
      //      variables.pantallaCics = variables.TN3270.CurrentScreenXML.Dump();
      //  }

        //public void capturaCICS()
        //{

          //  string text = variables.pantallaCics;
            //create new image
            //Bitmap bitmap = new Bitmap(1, 1);
            //Properties string to draw
            //Font font = new Font("Arial", 25, FontStyle.Regular, GraphicsUnit.Pixel);
            //Font font = new Font(FontFamily.GenericMonospace, 25, FontStyle.Regular, GraphicsUnit.Pixel);
            //Graphics graphics = Graphics.FromImage(bitmap);
            //properties new image
            //int width = (int)graphics.MeasureString(text, font).Width;
            //int height = (int)graphics.MeasureString(text, font).Height;
            //bitmap = new Bitmap(bitmap, new Size(width, height));
            //add text to image
            //graphics = Graphics.FromImage(bitmap);
            //graphics.Clear(Color.White);
            //graphics.SmoothingMode = SmoothingMode.AntiAlias;
            //graphics.TextRenderingHint = TextRenderingHint.AntiAlias;
            //graphics.DrawString(text, font, new SolidBrush(Color.Black), 0, 0);
            //execute pending graphics
            //graphics.Flush();
            //release resources used by graphics
            //graphics.Dispose();
            //variables.rutaEvidencia = variables.evidencia + "" + DateTime.Now.Day + DateTime.Now.Month + DateTime.Now.Year + "_" + DateTime.Now.Hour + DateTime.Now.Minute + DateTime.Now.Second + DateTime.Now.Millisecond + ".jpg";
            //save the image
            //bitmap.Save(variables.rutaEvidencia, System.Drawing.Imaging.ImageFormat.Jpeg);
            //do something with image

        //}

    }
}
