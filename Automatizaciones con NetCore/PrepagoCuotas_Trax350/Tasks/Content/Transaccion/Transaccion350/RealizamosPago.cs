using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using PrepagoCuotas_Trax350.userInterfaces.Content.Transaccion.Transaccion350;

namespace PrepagoCuotas_Trax350.Tasks.Content.Transaccion.Transaccion350
{
    public class RealizamosPago
    {
        public void PagoRealizado()
        {
            transaccion350UI tran350 = new transaccion350UI();
            var val = tran350.txtImporte;
            var value = val.GetAttribute("value");
            Console.WriteLine("valor montoval:" + value);
            double montoImporte = Convert.ToDouble(value.Substring(value.IndexOf("S/") + 2, value.Length - 4).Trim());
            

            var val1 = tran350.txtITF;
            var value1 = val1.GetAttribute("value");
            Console.WriteLine("valor montoval:" + value1);
            double montoITF = Convert.ToDouble(value1.Substring(value1.IndexOf("S/") + 2, value1.Length - 4).Trim());
            
            double Suma = montoImporte + montoITF;
            tran350.txtPago.SendKeys(Suma + 1 + ".00");


            
        }
    }
}
