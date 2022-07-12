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
    public class obtenerInformacionHistorial
    {
        public void datosInfo()
        {
            Thread.Sleep(7000);
            historialUI historial = new historialUI();


            var valDocumentos = historial.lblDocumento.Text;
            variables.documento = valDocumentos;
            Console.WriteLine("valor datosInfo lblDocumentotext:" + valDocumentos);

            var valDatoMedio1 = historial.lblDatoMedio1.Text;
            variables.datoMedio1 = valDatoMedio1;
            Console.WriteLine("valor datosInfo valDatoMedio1:" + valDatoMedio1);

            variables.mensajeWeb = "Guardamos los valores de Documento " + valDocumentos + " Dato Medio1 " + valDatoMedio1;
            //Console.WriteLine("monto_solo:" + value.Substring(value.IndexOf("S/") + 2, value.Length - 4).Trim());
            //variables.montodiferencia= Convert.ToDouble(value.Substring(value.IndexOf("S/") + 2, value.Length - 4).Trim());

        }
    }
}
