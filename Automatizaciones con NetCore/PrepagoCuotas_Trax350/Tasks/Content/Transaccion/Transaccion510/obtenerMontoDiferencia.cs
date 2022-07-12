using OpenQA.Selenium;
using PrepagoCuotas_Trax350.userInterfaces;
using PrepagoCuotas_Trax350.userInterfaces.Content.Login;
using PrepagoCuotas_Trax350.Util;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace PrepagoCuotas_Trax350.Tasks.Content.Transaccion.Transaccion510
{
    public class obtenerMontoDiferencia
    {
        public void importeDiferencia()
        {
            transacion510UI transacion = new transacion510UI();
            transacion.txtImporteDiferencia.Click();
            Thread.Sleep(3000);
            var val=transacion.txtImporteDiferencia;

            var value = val.GetAttribute("value");
            Console.WriteLine("valor montoval:" + value);

            Console.WriteLine("monto_solo:" + value.Substring(value.IndexOf("S/") + 2, value.Length - 4).Trim());
            variables.montodiferencia= Convert.ToDouble(value.Substring(value.IndexOf("S/") + 2, value.Length - 4).Trim());
            Console.WriteLine("valor monto" + transacion.txtImporteDiferencia.ToString());
        }
    }
}
