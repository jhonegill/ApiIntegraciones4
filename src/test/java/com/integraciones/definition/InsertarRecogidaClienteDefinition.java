package com.integraciones.definition;

import com.integraciones.steps.InsertarRecogidaClienteSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class InsertarRecogidaClienteDefinition {

    @Steps
    InsertarRecogidaClienteSteps recogidaSteps;

    @Given("^registro de datos cliente credito y de preenvio\\(s\\) a recoger$")
    public void registroDeDatosClienteCreditoYDePreenvioSARecoger() {
        recogidaSteps.configurarRecogida();
    }
    @When("^consume el metodo  llamado InsertarRecogidaCliente$")
    public void consumeElMetodoLlamadoInsertarRecogidaCliente() {
        recogidaSteps.consumirRecogidaCliente();
    }
    @Then("^generacion de numero de recogida$")
    public void generacionDeNumeroDeRecogida() {
        recogidaSteps.generarRecogidas();
    }
}
