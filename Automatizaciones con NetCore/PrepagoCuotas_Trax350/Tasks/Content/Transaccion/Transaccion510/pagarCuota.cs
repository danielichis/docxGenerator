using OpenQA.Selenium;
using PrepagoCuotas_Trax350.userInterfaces.Content.Login;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using PrepagoCuotas_Trax350.Util;

namespace PrepagoCuotas_Trax350.Tasks.Content.Transaccion.Transaccion510
{
    public class pagarCuota
    {

        public void ingresarMonto(string monto)
        {
            pagarCuotaTransactorUI cuota = new pagarCuotaTransactorUI();
            cuota.txtMontoCuotas.SendKeys(monto);

            variables.montoFeature = Convert.ToDouble(monto);
            variables.mensajeWeb = "Ingresamos el monto " + monto + " a pagar";
        }
    }
}
