using OpenQA.Selenium;
using PrepagoCuotas_Trax350.userInterfaces;
using PrepagoCuotas_Trax350.Util;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PrepagoCuotas_Trax350.Tasks
{
    public class loginComenzarTransactor
    {
        public void btnComenzar()
        {
            comenzarTransactorUI inico = new comenzarTransactorUI();
              //inico.btnComenzar.Click();

            utilidad.ExecuteClic(inico.btnComenzar);
            variables.mensajeWeb = "Hacer clic en el boton Comenzar";
        }
    }
}
