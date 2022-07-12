using OpenQA.Selenium;
using PrepagoCuotas_Trax350.Util;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PrepagoCuotas_Trax350.userInterfaces
{
    public class transacion510UI
    {

        public IWebElement cboTipoPago => variables.driver.FindElement(By.Id("idCOTIPPAG"));
        public IWebElement cboItemTipoPago => variables.driver.FindElement(By.XPath("//select[@id, 'idCOTIPPAG']//option[text()='PAGO']"));
        public IWebElement cboItemTipoPagoLiquidacion => variables.driver.FindElement(By.XPath("//select[contains(@name, 'COTIPPAG')]//option[text()='PAGO CON NRO. PRE-LIQUIDACION']"));
        
        public IWebElement cboTipoDocumento => variables.driver.FindElement(By.Id("idCOTIPDOC"));
        public IWebElement cboMoneda => variables.driver.FindElement(By.Id("idCOMON"));
        public IWebElement txtNumDocumento => variables.driver.FindElement(By.Id("idNUDOC"));
        public IWebElement cboFuncion => variables.driver.FindElement(By.Id("idCOTIPFUN"));

        public IWebElement rbMedio => variables.driver.FindElement(By.Id("idCOMEDM1"));
        public IWebElement txtImporteDiferencia => variables.driver.FindElement(By.Id("IMTXNDIF"));

    }

    
}
