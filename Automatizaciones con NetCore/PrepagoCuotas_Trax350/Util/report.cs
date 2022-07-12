using AventStack.ExtentReports;
using AventStack.ExtentReports.Gherkin.Model;
using AventStack.ExtentReports.Reporter;
using NUnit.Framework;
using OpenQA.Selenium;
using PrepagoCuotas_Trax350.StepsDefinition;
using PrepagoCuotas_Trax350.Util;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Reflection;
using System.Text;
using System.Threading.Tasks;
using TechTalk.SpecFlow;

namespace PrepagoCuotas_Trax350
{
    [Binding]
    public class report : TechTalk.SpecFlow.Steps
    {
        public static ExtentTest _feature;
        public static ExtentTest _scenario;
        public static ExtentReports _extent;
        public static ExtentHtmlReporter _reporte;
        public static config valores = new config();

        [BeforeTestRun]
        public static void InitializeReport()
        {
            utilidad util = new utilidad();
            String html = util.directorioPrincipal() + "/lib/";
            _reporte = new ExtentHtmlReporter(@html);

            _extent = new ExtentReports();
            _extent.AttachReporter(_reporte);
            _extent.AddSystemInfo("Navegador", valores.navegador);
            _extent.AddSystemInfo("S.O", "Windows");
            _extent.AddSystemInfo("Aplicativo", valores.aplicativo);
        }

        [BeforeFeature]
        public static void BeforeFeature(FeatureContext featurecontext)
        {
            _feature = _extent.CreateTest(new GherkinKeyword("Feature"), featurecontext.FeatureInfo.Title);
            _feature.AssignAuthor(valores.responsable);
            Console.WriteLine("variable report tag:"+ variables.tag);
            _feature.AssignCategory("PPA WEB");
        }
        [BeforeScenario]
        public static void BeforeScenario()
        {
            utilidad util = new utilidad();
            config variable = new config();
            _scenario = _feature.CreateNode(new GherkinKeyword("Scenario"), ScenarioContext.Current.ScenarioInfo.Title);

            util.escribirLogPerzonalizado("Scenario: " + ScenarioContext.Current.ScenarioInfo.Title);
            var dhhde = ScenarioContext.Current.ScenarioInfo.Tags;
            Console.WriteLine("gherkin BeforeScenario step:" + dhhde);

        }
       
        public void evidenciaStep(List<string> valor)
        {
            var stepType = ScenarioStepContext.Current.StepInfo.StepDefinitionType.ToString();
            switch (valor.Count())
            {
                case 0:
                    Console.WriteLine("valores evidenciaStep:" + valor[0]);
                    byte[] imageArrayCics00 = System.IO.File.ReadAllBytes(valor[0]);
                    string base64ImageRepresentationCics00 = Convert.ToBase64String(imageArrayCics00);

                    _scenario.CreateNode(new GherkinKeyword(stepType), ScenarioStepContext.Current.StepInfo.Text).Pass("Passed").AddScreenCaptureFromBase64String(base64ImageRepresentationCics00);

                    Console.WriteLine("case 1");
                    break;
                case 1:
                    Console.WriteLine("valores evidenciaStep:" + valor[0]);
                    byte[] imageArrayCics10 = System.IO.File.ReadAllBytes(valor[0]);
                    string base64ImageRepresentationCics10 = Convert.ToBase64String(imageArrayCics10);
                    byte[] imageArrayCics11 = System.IO.File.ReadAllBytes(valor[1]);
                    string base64ImageRepresentationCics11 = Convert.ToBase64String(imageArrayCics11);

                    _scenario.CreateNode(new GherkinKeyword(stepType), ScenarioStepContext.Current.StepInfo.Text).Pass("Passed").AddScreenCaptureFromBase64String(base64ImageRepresentationCics10).AddScreenCaptureFromBase64String(base64ImageRepresentationCics11);

                    Console.WriteLine("case 2");
                    break;
                case 2:
                    Console.WriteLine("valores evidenciaStep:" + valor[0]);
                    byte[] imageArrayCics20 = System.IO.File.ReadAllBytes(valor[0]);
                    string base64ImageRepresentationCics20 = Convert.ToBase64String(imageArrayCics20);
                    byte[] imageArrayCics21 = System.IO.File.ReadAllBytes(valor[1]);
                    string base64ImageRepresentationCics21 = Convert.ToBase64String(imageArrayCics21);
                    byte[] imageArrayCics22 = System.IO.File.ReadAllBytes(valor[2]);
                    string base64ImageRepresentationCics22 = Convert.ToBase64String(imageArrayCics22);

                    _scenario.CreateNode(new GherkinKeyword(stepType), ScenarioStepContext.Current.StepInfo.Text).Pass("Passed").AddScreenCaptureFromBase64String(base64ImageRepresentationCics20).AddScreenCaptureFromBase64String(base64ImageRepresentationCics21).AddScreenCaptureFromBase64String(base64ImageRepresentationCics22);

                    Console.WriteLine("case 3");
                    break;

            }

        }

        [AfterStep]
        public void InsertReportingSteps(ScenarioContext sc)
        {
            var stepType = ScenarioStepContext.Current.StepInfo.StepDefinitionType.ToString();
            var stepTypeContext = ScenarioStepContext.Current.StepInfo.Text;
            var featuress = FeatureContext.Current.FeatureInfo.Title;
            var featuretags = FeatureContext.Current.FeatureInfo.Tags;
            var ScenarioName = Scenario.GherkinName.ToString();
            var ScenarioNam = ScenarioContext.Current.ScenarioInfo.Title;
            var dhhde = ScenarioContext.ScenarioInfo.Tags;
           
            PropertyInfo pInfo = typeof(ScenarioContext).GetProperty("ScenarioExecutionStatus", BindingFlags.Instance | BindingFlags.Public);
            MethodInfo getter = pInfo.GetGetMethod(nonPublic: true);
            object TestResult = getter.Invoke(sc, null);

            /*Console.WriteLine("gherkin this.rutaEvidencia:" + this.rutaEvidencia);
            Console.WriteLine("gherkin web.evidencia url:" + web.evidencia);
            Console.WriteLine("gherkin evidencia url:" + evidenciaBe.evidencia);
            Console.WriteLine("gherkin ret:" + ret);*/
            //Console.WriteLine("gherkin ScenarioExecutionStatus estado:" + sc.ScenarioExecutionStatus.ToString());


            String evidencia = variables.rutaEvidencia;
            String estado = variables.estadoCics;
            String mensaje = variables.mensajeCics;
            Console.WriteLine("prueba eviendica variables.rutaEvidencia imagen:" + variables.rutaEvidencia);
            if (sc.TestError == null)
            {
                if (variables.canal == "Cics")
                {
                    byte[] imageArrayCics = System.IO.File.ReadAllBytes(evidencia);
                    string base64ImageRepresentationCics = Convert.ToBase64String(imageArrayCics);
                    
                    if (estado == "fail")
                    {
                        _scenario.CreateNode(new GherkinKeyword(stepType), ScenarioStepContext.Current.StepInfo.Text).Fail(mensaje).AddScreenCaptureFromBase64String(base64ImageRepresentationCics);

                        utilidad util = new utilidad();
                        util.escribirLog();
                    }
                    else
                    {
                        if (variables.cantidadEvidencia!=null)
                        {
                            evidenciaStep(variables.cantidadEvidencia);
                        }
                        else { 
                            _scenario.CreateNode(new GherkinKeyword(stepType), ScenarioStepContext.Current.StepInfo.Text).Pass("Passed").AddScreenCaptureFromBase64String(base64ImageRepresentationCics);
                        }
                    }
                } else if (variables.canal == "Web")
                {
                    Console.WriteLine("prueba eviendica ruta imagen" + evidencia);
                    if ((evidencia != "") | (evidencia.Length! > 1))
                    {

                        byte[] imageArray = System.IO.File.ReadAllBytes(evidencia);
                        string base64ImageRepresentation = Convert.ToBase64String(imageArray);

                        //_scenario.CreateNode(new GherkinKeyword(stepType), ScenarioStepContext.Current.StepInfo.Text).Pass("Passed").AddScreenCaptureFromPath(evidencia);

                        _scenario.CreateNode(new GherkinKeyword(stepType), ScenarioStepContext.Current.StepInfo.Text).Pass("Passed").AddScreenCaptureFromBase64String(base64ImageRepresentation);

                    }
                    else
                    {
                        _scenario.CreateNode(new GherkinKeyword(stepType), ScenarioStepContext.Current.StepInfo.Text).Pass("Passed");
                    }
                }

            }
            if (sc.TestError != null)
            {

                utilidad reporte = new utilidad();
                reporte.capturaWeb();

                byte[] imageArrayCics = System.IO.File.ReadAllBytes(variables.rutaEvidencia);
                string base64ImageRepresentationCics = Convert.ToBase64String(imageArrayCics);

                Console.WriteLine("valor de report" + sc.TestError.Message.Length);
                if (sc.TestError.Message.Length>0)
                {
                    Console.WriteLine("valor de if" + sc.TestError.Message);
                    utilidad util = new utilidad();
                    util.escribirLogPerzonalizado(sc.TestError.Message+" en el step "+ ScenarioStepContext.Current.StepInfo.Text);
                }
                if (stepType == "Given")
                    _scenario.CreateNode<Given>(ScenarioStepContext.Current.StepInfo.Text).Fail(sc.TestError.Message).AddScreenCaptureFromBase64String(base64ImageRepresentationCics);
                if (stepType == "When")
                    _scenario.CreateNode<When>(ScenarioStepContext.Current.StepInfo.Text).Fail(sc.TestError.Message).AddScreenCaptureFromBase64String(base64ImageRepresentationCics);
                if (stepType == "Then")
                    _scenario.CreateNode<Then>(ScenarioStepContext.Current.StepInfo.Text).Fail(sc.TestError.Message).AddScreenCaptureFromBase64String(base64ImageRepresentationCics);
                if (stepType == "And")
                    _scenario.CreateNode<And>(ScenarioStepContext.Current.StepInfo.Text).Fail(sc.TestError.Message).AddScreenCaptureFromBase64String(base64ImageRepresentationCics);
            }
        }

        [AfterTestRun]
        public static void TearDownReport()
        {
            _extent.Flush();
            //String val = util.directorioPrincipal() + "/Screenshot/";
            //String val = @"C:\Users\xt8785\Downloads\PagoRecaudacion\ProyectNetCore\ProyectFeature\ProyectFeature\Screenshot\";

            utilidad util = new utilidad();
            System.IO.Directory.Delete(util.directorioPrincipal() + "/Screenshot/", true);

            variables.driver.Quit();
            variables.driver.Dispose();
            variables.driver = null;
        }

    }
}

