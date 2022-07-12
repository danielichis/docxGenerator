using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using PrepagoCuotas_Trax350.userInterfaces.Content.Transaccion.Transaccion350;
using PrepagoCuotas_Trax350.Util;

namespace PrepagoCuotas_Trax350.Tasks.Content.Transaccion.Transaccion350
{
    public class Transaccion350Transactor
    {
    public void IngresaTC (string NUMTARJETA)
        {
            transaccion350UI tran350 = new transaccion350UI();
            tran350.txtNumTC.SendKeys(NUMTARJETA);
            Thread.Sleep(500);
        }
    }
}