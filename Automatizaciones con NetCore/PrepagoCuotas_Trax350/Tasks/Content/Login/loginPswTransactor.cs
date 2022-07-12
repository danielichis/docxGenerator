using OpenQA.Selenium;
using OpenQA.Selenium.Support.UI;
using PrepagoCuotas_Trax350.userInterfaces;
using PrepagoCuotas_Trax350.Util;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PrepagoCuotas_Trax350.Tasks
{
    public class loginPswTransactor
    {
        public void ingresarPsw(string psw)
        {
            WebDriverWait wait = new WebDriverWait(variables.driver, TimeSpan.FromSeconds(30));
            wait.Until(x => x.SwitchTo().DefaultContent());
            wait.Until(x => x.SwitchTo().Frame("thisApp"));
            wait.Until(x => x.SwitchTo().Frame("mainFrame"));
            loginTransactorUI login = new loginTransactorUI();
            login.txtPsw.SendKeys(psw);

        }
    }
}
