using OpenQA.Selenium;
using PrepagoCuotas_Trax350.userInterfaces;
using PrepagoCuotas_Trax350.Util;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PrepagoCuotas_Trax350.Tasks.Content.Transaccion.Transaccion510
{
    public class datosAceptarTransactor
    {
        public void btnAceptar()
        {
            loginTransactorUI aceptarDatos = new loginTransactorUI();
            aceptarDatos.btnAceptar.Click();
            variables.mensajeWeb = "Continuamos el flujo con la información enviada";
        }
    }
}
