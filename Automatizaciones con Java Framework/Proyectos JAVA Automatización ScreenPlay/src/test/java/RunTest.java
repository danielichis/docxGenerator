import cucumber.api.CucumberOptions;

import cucumber.api.junit.Cucumber;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/feature/"},
        junit={"--step-notifications"},
        glue = {"Interbank.com.pe.stepdefinition"},
        //tags = {"@PagoMinimoSolesTrad, @PagoMinimoSolesNoTrad, @PagoMinimoDolares, @PagoFullSolesTrad, @PagoFullSolesNoTrad, @PagoFullDolarTrad, @PagoMenorMinSolesTrad, @PagoMenorMinSolesNoTrad, @PagoMenorMinDolar, @PagoMayorFullSolesTrad, @PagoMayorFullSolesNoTrad, @PagoMayorFullDolar, @PagoEntreMinFullSolesTrad, @PagoEntreMinFullSolesNoTrad, @PagoEntreMinFullDolar, @PagoMinSolesFullDolar, @PagoMinDolarFullSoles"},
        //tags = {"@MantenimientoMorosoSoles, @ConsumoMantenimiento"},
        //tags = {"@PagoMinimoSolesTrad ,@ConsumoMantenimiento"},
        tags = {"@PagoMinimoSolesTrad ,@PagoMinimoDolares, @PagoFullSolesTrad, @PagoFullDolarTrad, @PagoMenorMinSolesTrad, @PagoMenorMinDolar, @PagoMayorFullSolesTrad, @PagoMayorFullDolar"},
        plugin = {"pretty",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json" }
        )
public class RunTest {

}
