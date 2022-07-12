using BoDi;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.IE;
using PrepagoCuotas_Trax350.Util;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using TechTalk.SpecFlow;

namespace ProyectFeature.hook
{
    [Binding]
    public class runnerTest
    {
        
        public IWebDriver driver;
        public String evidencia;
        public String directorio;

        //private string prueba = @"C:\Users\xt8785\Downloads\PagoRecaudacion\ProyectNetCore\Git\ati-iyd\ProyectFeature\ProyectFeature\driver";
            
        [BeforeScenario]
        public void BeforeScenario()
        {
            utilidad util = new utilidad();
            directorio = util.creardirectorioPrincipal();
            evidencia = util.crearEvide(directorio);
            
            //Environment.SetEnvironmentVariable("no_proxy", "localhost");
            if (variables.driver == null)
            {
                variables.driver = new InternetExplorerDriver();
                variables.evidencia = evidencia;
                variables.tag = "prueba";
            }
        }


    }
}
