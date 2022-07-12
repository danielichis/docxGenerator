using OpenQA.Selenium;
using PrepagoCuotas_Trax350.Util;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PrepagoCuotas_Trax350.userInterfaces
{
    public class transacionUI
    {
        public IWebElement txtTransaccion => variables.driver.FindElement(By.Id("txnID"));
        public IWebElement menuOperacion=> variables.driver.FindElement(By.Id("txnID"));
        public IWebElement menuEnvio => variables.driver.FindElement(By.Id("txnID"));
        public IWebElement menuAutorizar => variables.driver.FindElement(By.Id("txnID"));
        public IWebElement menuConsulta => variables.driver.FindElement(By.Id("txnID"));


    }

    
}
