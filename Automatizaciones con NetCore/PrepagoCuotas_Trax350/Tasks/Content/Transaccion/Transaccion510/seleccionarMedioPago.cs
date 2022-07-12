using OpenQA.Selenium;
using PrepagoCuotas_Trax350.userInterfaces;
using PrepagoCuotas_Trax350.Util;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace PrepagoCuotas_Trax350.Tasks.Content.Transaccion.Transaccion510
{
    public class seleccionarMedioPago
    {
        public void transaccion(String medio)
        {
            IJavaScriptExecutor jse = (IJavaScriptExecutor) variables.driver;
            transacion510UI tran510 = new transacion510UI();
            jse.ExecuteScript("var select = arguments[0];  for (var i = 0; i < select.options.length; i++) { if (select.options[i].text == arguments[1]) { select.options[i].selected = true; } }", tran510.rbMedio, medio);
            utilidad.tiempoEspera();

            variables.mensajeWeb = "Selecionamos el medio de pago " + medio;
            
        }
    }
}
