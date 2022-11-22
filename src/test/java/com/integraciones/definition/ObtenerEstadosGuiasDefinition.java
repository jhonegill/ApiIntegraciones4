package com.integraciones.definition;

import com.integraciones.steps.ObtenerEstadosGuiasSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class ObtenerEstadosGuiasDefinition {
    @Steps
    ObtenerEstadosGuiasSteps estadosGuiasSteps;

    @Given("^el cliente realiza consulta  de estados de las Guias$")
    public void elClienteRealizaConsultaDeEstadosDeLasGuias() {estadosGuiasSteps.configurarEstadosGuias();}
    @When("^consume el metodo llamado ObtenerEstadosGuias$")
    public void consumeElMetodoLlamadoObtenerEstadosGuias() {
        estadosGuiasSteps.consumirEstadoGuias();
    }
    @Then("^evienciar  los estados logisticos de las guias$")
    public void evienciarLosEstadosLogisticosDeLasGuias() {
        estadosGuiasSteps.obtenerEstadoGuias();
    }


}
