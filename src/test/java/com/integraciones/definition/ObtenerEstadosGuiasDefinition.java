package com.integraciones.definition;

import com.integraciones.steps.ObtenerEstadosGuiasSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class ObtenerEstadosGuiasDefinition {
    @Steps
    ObtenerEstadosGuiasSteps estadosGuiasSteps;

    @Given("^el cliente realiza la configuracion del metodo ObtenerEstadosGuias$")
    public void configurarEstadosGuias() {
        estadosGuiasSteps.configurarEstadosGuias();
    }

    @When("^consume el metodo Get llamado \"([^\"]*)\"$")
    public void consumirEstadoGuias(String metodoObtenerEstadosGuias) {
        estadosGuiasSteps.consumirEstadoGuias(metodoObtenerEstadosGuias);
    }

    @Then("puede ver los estados logisticos de las guias$")
    public void obtenerEstadoGuias() {
        estadosGuiasSteps.obtenerEstadoGuias();
    }
}
