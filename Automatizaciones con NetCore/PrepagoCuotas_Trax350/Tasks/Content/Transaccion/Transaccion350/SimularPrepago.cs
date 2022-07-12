using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using OpenQA.Selenium;
using PrepagoCuotas_Trax350.userInterfaces.Content.Transaccion.Transaccion350;
using PrepagoCuotas_Trax350.Util;

namespace PrepagoCuotas_Trax350.Tasks.Content.Transaccion.Transaccion350
{
   public class SimularPrepago
    {
        public void SimulaPrepago(string TIPOPAGO, string NUMCUOTA)
        {
            transaccion350UI tran350 = new transaccion350UI();
            utilidad.tiempoEspera();
            utilidad.tiempoEspera();
            utilidad.comboBoxSelectText(tran350.cbmetpago, TIPOPAGO);
            utilidad.tiempoEspera();
            utilidad.virtualKeyboardOptionEnter();
            utilidad.tiempoEspera();
            utilidad.tiempoEspera();
            tran350.txtNroCuota.SendKeys(NUMCUOTA);
        }
    }
}
