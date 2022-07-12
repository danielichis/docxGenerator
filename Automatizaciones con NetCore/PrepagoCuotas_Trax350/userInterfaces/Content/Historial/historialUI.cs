using OpenQA.Selenium;
using PrepagoCuotas_Trax350.Util;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PrepagoCuotas_Trax350.userInterfaces
{
    public class historialUI
    {

        public IWebElement listResultado => variables.driver.FindElement(By.Id("txnList"));
        public IWebElement lblDocumento => variables.driver.FindElement(By.Id("NUDOCTXN"));
        public IWebElement lblDatoMedio1 => variables.driver.FindElement(By.Id("DELINMED05"));


    }

    
}
