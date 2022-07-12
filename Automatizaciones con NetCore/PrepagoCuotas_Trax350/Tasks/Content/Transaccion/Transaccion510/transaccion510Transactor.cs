using OpenQA.Selenium;
using OpenQA.Selenium.Interactions;
using OpenQA.Selenium.Support.UI;
using PrepagoCuotas_Trax350.userInterfaces;
using PrepagoCuotas_Trax350.Util;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace PrepagoCuotas_Trax350.Tasks
{
    public class transaccion510Transactor
    {
        public void transacion(String pago, String tipoDoc, String moneda, String numDoc, String funcion)
        {
            transacion510UI tran510 = new transacion510UI();

            utilidad.comboBoxSelectText(tran510.cboTipoPago, pago);
            utilidad.tiempoEspera();

            utilidad.comboBoxSelectText(tran510.cboTipoDocumento, tipoDoc);
            utilidad.tiempoEspera();

            utilidad.comboBoxSelectText(tran510.cboTipoDocumento, tipoDoc);
            utilidad.tiempoEspera();
            utilidad.comboBoxExecuteEvent(tran510.cboTipoDocumento);
            utilidad.tiempoEspera();

            utilidad.comboBoxSelectText(tran510.cboMoneda, moneda);
            utilidad.tiempoEspera();
            utilidad.comboBoxExecuteEvent(tran510.cboMoneda);
            utilidad.tiempoEspera();

            tran510.txtNumDocumento.SendKeys(numDoc);
            Thread.Sleep(500);

            utilidad.comboBoxSelectText(tran510.cboFuncion, funcion);
            utilidad.tiempoEspera();
            utilidad.comboBoxExecuteEvent(tran510.cboFuncion);
            utilidad.tiempoEspera();

            variables.mensajeWeb = "Ingresamos los siguiente valores Tipo Pago: " + pago + "Tipo Documento: " + tipoDoc + "Moneda: " + moneda + "Numero Documento: " + numDoc + "Funcion: " + funcion;
            
        }
    }
}
