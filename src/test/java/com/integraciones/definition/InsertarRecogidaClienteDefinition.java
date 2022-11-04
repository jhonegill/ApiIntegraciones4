package com.integraciones.definition;

import com.integraciones.steps.InsertarRecogidaClienteSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class InsertarRecogidaClienteDefinition {

    @Steps
    InsertarRecogidaClienteSteps recogidaSteps;

    @Given("^el cliente configura el \"([^\"]*)\", token \"([^\"]*)\", idClienteCredito \"([^\"]*)\" y idSucursalCliente \"([^\"]*)\"$")
    public void configurarRecogida(String usuario, String token, String idClienteCredito, String idSucursalCliente)   {
        recogidaSteps.configurarRecogida(usuario, token, idClienteCredito, idSucursalCliente);
    }

    @When("^consume el metodo Post llamado \"([^\"]*)\"$")
    public void consumirRecogidaCliente(String metodoRecogidas ) {
        recogidaSteps.consumirRecogidaCliente(metodoRecogidas);
    }

    @Then("^puede generar el id de la recogida$")
    public void generarRecogidas() {
        recogidaSteps.generarRecogidas();
    }
}
