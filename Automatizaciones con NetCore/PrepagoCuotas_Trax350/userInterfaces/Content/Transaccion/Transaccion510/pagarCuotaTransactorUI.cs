using OpenQA.Selenium;
using PrepagoCuotas_Trax350.Util;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PrepagoCuotas_Trax350.userInterfaces.Content.Login
{
    public class pagarCuotaTransactorUI
    {
        public IWebElement txtMontoCuotas => variables.driver.FindElement(By.Id("IMPAGM1"));
    }
}
