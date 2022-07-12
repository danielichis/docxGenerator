using OpenQA.Selenium;
using PrepagoCuotas_Trax350.userInterfaces;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PrepagoCuotas_Trax350.Tasks
{
    public class loginTiendaTransactor
    {
        public void chkTienda()
        {
            loginTransactorUI login = new loginTransactorUI();
            login.chkTienda.Click();
        }
    }
}
