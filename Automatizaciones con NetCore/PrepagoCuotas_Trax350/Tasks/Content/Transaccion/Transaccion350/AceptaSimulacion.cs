using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using PrepagoCuotas_Trax350.userInterfaces.Content.Transaccion.Transaccion350;
using PrepagoCuotas_Trax350.Util;

namespace PrepagoCuotas_Trax350.Tasks.Content.Transaccion.Transaccion350
{
   public class AceptaSimulacion
    {
        public void AceptoSimulacion (string CARGO, string MONEDA)
        {
            transaccion350UI tran350 = new transaccion350UI();
            utilidad.tiempoEspera();
            utilidad.comboBoxSelectText(tran350.cbcargo, CARGO);
            utilidad.tiempoEspera();
            utilidad.comboBoxSelectText(tran350.cbmoneda, MONEDA);
        }

    }
}
