using OpenQA.Selenium;
using PrepagoCuotas_Trax350.Util;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PrepagoCuotas_Trax350.userInterfaces
{
    public class comenzarTransactorUI
    {
        public IWebElement btnComenzar => variables.driver.FindElement(By.Id("startBtn"));


    }

    
}
