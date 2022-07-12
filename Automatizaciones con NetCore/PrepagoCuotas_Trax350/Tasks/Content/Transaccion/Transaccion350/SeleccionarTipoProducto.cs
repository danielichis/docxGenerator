using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using OpenQA.Selenium;
using PrepagoCuotas_Trax350.userInterfaces.Content.Transaccion.Transaccion350;
using PrepagoCuotas_Trax350.Util;

namespace PrepagoCuotas_Trax350.Tasks.Content.Transaccion.Transaccion350
{
    public class SeleccionarTipoProducto
    {
        public void SelecProd (string PRODUCTO)
        {
            transaccion350UI tran350 = new transaccion350UI();
            utilidad.comboBoxSelectText(tran350.cbproducto, PRODUCTO);
            utilidad.tiempoEspera();
            tran350.cbproducto.SendKeys(Keys.Enter);
        }

    }
}
