using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using PrepagoCuotas_Trax350.Util;

namespace PrepagoCuotas_Trax350.Tasks
{
    public class PagTransactor
    {
        public void abrirWeb(String url)
        {
            variables.driver.Navigate()
               .GoToUrl(url);
            variables.mensajeWeb = "se pudo abrir la pagina";

        }
    }
}
