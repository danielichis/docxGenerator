using OpenQA.Selenium;
using PrepagoCuotas_Trax350.Util;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PrepagoCuotas_Trax350.userInterfaces
{
    public class loginTransactorUI
    {
        public IWebElement txtPsw => variables.driver.FindElement(By.Id("Password"));
        public IWebElement chkTienda => variables.driver.FindElement(By.Id("FLAPROFI"));
        public IWebElement btnAceptar => variables.driver.FindElement(By.Id("okBtn"));


    }

    
}
