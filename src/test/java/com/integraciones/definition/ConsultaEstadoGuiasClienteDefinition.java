package com.integraciones.definition;

import com.integraciones.steps.ConsultarEstadoGuiasClienteSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class ConsultaEstadoGuiasClienteDefinition {

    @Steps
    ConsultarEstadoGuiasClienteSteps consultaEstadoGuiaStep;

    @Given("^el cliente configura el usuario \"([^\"]*)\", token \"([^\"]*)\" y idCliente \"([^\"]*)\"$")
    public void configurarEstadoGuiasCLientes(String usuario, String token, String idCliente) {
        consultaEstadoGuiaStep.configurarEstadoGuiasCLientes(usuario, token, idCliente);
    }

    @When("^consume el metodo Post \"([^\"]*)\"$")
    public void consumirEstadoGuiasClientes(String metodoEstadoGuias) {
        consultaEstadoGuiaStep.consumirEstadoGuiasClientes(metodoEstadoGuias);
    }

    @Then("^obtiene el estado logistico de las guias$")
    public void estadoGuiasClientes() {
        consultaEstadoGuiaStep.estadoGuiasClientes();
    }
}
