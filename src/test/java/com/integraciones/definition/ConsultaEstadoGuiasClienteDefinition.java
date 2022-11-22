package com.integraciones.definition;

import com.integraciones.steps.ConsultarEstadoGuiasClienteSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class ConsultaEstadoGuiasClienteDefinition {

    @Steps
    ConsultarEstadoGuiasClienteSteps consultaEstadoGuiaStep;

    @Given("^el cliente configura el usuario$")
    public void elClienteConfiguraElUsuario() {consultaEstadoGuiaStep.configurarEstadoGuiasCLientes();}
    @When("^consume el metodo Post ConsultarEstadosGuiasCliente$")
    public void consumeElMetodoPostConsultarEstadosGuiasCliente() {consultaEstadoGuiaStep.consumirEstadoGuiasClientes();
    }
    @Then("^obtiene el estado logistico de las guias$")
    public void estadoGuiasClientes() {consultaEstadoGuiaStep.estadoGuiasClientes();}
}
