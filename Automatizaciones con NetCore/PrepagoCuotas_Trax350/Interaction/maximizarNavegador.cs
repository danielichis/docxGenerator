using OpenQA.Selenium;
using PrepagoCuotas_Trax350.Util;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PrepagoCuotas_Trax350.Tasks
{
    public class maximizarNavegador
    {
        public void maximizarWeb()
        {
            var window = variables.driver.Manage().Window;
            window.Maximize();
        }
    }
}
