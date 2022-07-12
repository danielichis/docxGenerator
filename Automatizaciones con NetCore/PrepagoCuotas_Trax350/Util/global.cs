using OpenQA.Selenium;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PrepagoCuotas_Trax350.Util
{
    class global
    {
        public double montoCics;
        public double montoTransactor;

        public String fechaInicio;
        public String fechaLlegada;
        public double montodiferencia;
        public double montoFeature;
        public String documento;
        public String datoMedio1;

        public String canal;
        public String evidencia;
        public String pantallaCics;
        public String estadoCics;
        public String mensajeCics;
        public String rutaEvidencia;
        public List<string> cantidadEvidencia;
        public String tag;
        public String directorioProyecto;
        public IWebDriver driver;

    }

    static class variables
    {
        public static double montoCics;
        public static double montoTransactor;

        public static String fechaInicio;
        public static String fechaLlegada;
        public static double montodiferencia;
        public static double montoFeature;
        public static String documento;
        public static String datoMedio1;

        public static String canal;
        public static String evidencia;
        public static String pantallaCics;
        public static String estadoCics;
        public static String mensajeCics;
        public static String mensajeWeb;
        public static String rutaEvidencia;
        public static List<string> cantidadEvidencia;
        public static String tag;
        public static String directorioProyecto;
        public static IWebDriver driver;
    }
}