using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using PrepagoCuotas_Trax350.userInterfaces;
using PrepagoCuotas_Trax350.Util;

namespace PrepagoCuotas_Trax350.Tasks.Content.Transaccion.Transaccion350
{
   public class AceptarTransactor
    {
        public void btnAceptar()
        {
            loginTransactorUI aceptarDato = new loginTransactorUI();
            aceptarDato.btnAceptar.Click();
            variables.mensajeWeb = "Continuamos el flujo con la información enviada";
        }
    }
}
