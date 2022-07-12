using OpenQA.Selenium;
using PrepagoCuotas_Trax350.Util;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PPrepagoCuotas_Trax350.userInterfaces.Content.Login
{
    public class selectCuotasTransactorUI
    {
        public IWebElement cboSelectCuotas => variables.driver.FindElement(By.Id("rbSel_0"));
    }
}
