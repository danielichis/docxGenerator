using OpenQA.Selenium;
using PrepagoCuotas_Trax350.userInterfaces;
using PrepagoCuotas_Trax350.Util;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PrepagoCuotas_Trax350.Tasks
{
    public class loginAceptarTransactor
    {
        public void btnAceptar()
        {
            loginTransactorUI login = new loginTransactorUI();
            login.btnAceptar.SendKeys(Keys.Enter);
            variables.mensajeWeb = "Iniciamos simulacion en la Pagina de Transactor";
        }
    }
}
