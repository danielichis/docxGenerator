using OpenQA.Selenium;
using PrepagoCuotas_Trax350.userInterfaces.Content.Login;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using PrepagoCuotas_Trax350.Util;
using PPrepagoCuotas_Trax350.userInterfaces.Content.Login;

namespace PrepagoCuotas_Trax350.Tasks.Content.Transaccion.Transaccion510
{
    public class seleccionarCuotasTransactor
    {
        public void cboSelectCuotas()
        {
            selectCuotasTransactorUI aceptarDatos = new selectCuotasTransactorUI();
            aceptarDatos.cboSelectCuotas.Click();
        }

    }
}
