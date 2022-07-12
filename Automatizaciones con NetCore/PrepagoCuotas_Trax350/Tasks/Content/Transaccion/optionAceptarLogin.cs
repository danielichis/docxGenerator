using OpenQA.Selenium;
using PrepagoCuotas_Trax350.userInterfaces;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PrepagoCuotas_Trax350.Tasks
{
    public class optionAceptarLogin
    {
        public void btnAceptar()
        {
            optionAceptarLoginUI option = new optionAceptarLoginUI();
            option.btnAceptar.Click();
        }
    }
}
