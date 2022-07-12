using OpenQA.Selenium;
using OpenQA.Selenium.Support.UI;
using PrepagoCuotas_Trax350.userInterfaces;
using PrepagoCuotas_Trax350.Util;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace PrepagoCuotas_Trax350.Tasks
{
    public class transaccionTransactor
    {
        public void transacion(string numTransacion)
        {

            transacionUI transaccion = new transacionUI();
            Thread.Sleep(2000);
            transaccion.txtTransaccion.SendKeys(numTransacion);
            transaccion.txtTransaccion.Click();
            Thread.Sleep(2000);
            transaccion.txtTransaccion.SendKeys(Keys.Enter);
            variables.mensajeWeb = "Ingresamos a la transaccion "+ numTransacion;
        }
    }
}
