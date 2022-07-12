using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using OpenQA.Selenium;
using PrepagoCuotas_Trax350.Util;

namespace PrepagoCuotas_Trax350.userInterfaces.Content.Transaccion.Transaccion350
{
    public class transaccion350UI
    {
        public IWebElement txtNumTC => variables.driver.FindElement(By.Id("NUTAR"));
        public IWebElement cbproducto => variables.driver.FindElement(By.Id("idCOPRD"));
        public IWebElement cbmetpago => variables.driver.FindElement(By.Id("idCOTIPPAG"));
        public IWebElement checksimu => variables.driver.FindElement(By.Id("idFLFRMIMP"));
        public IWebElement txtNroCuota => variables.driver.FindElement(By.Id("idNUCUO01"));
        public IWebElement cbcargo => variables.driver.FindElement(By.Id("idCOMEDM1"));
        public IWebElement cbmoneda => variables.driver.FindElement(By.Id("idCOMONPAGM1"));
        public IWebElement txtImporte => variables.driver.FindElement(By.Id("IMTXN"));
        public IWebElement txtITF => variables.driver.FindElement(By.Id("IMITFREF"));
        public IWebElement txtPago => variables.driver.FindElement(By.Id("IMPAGM1"));

    }
}
