
package com.integraciones.definition;

import com.integraciones.steps.InsertarAdmisionClienteSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class InsertarAdmisionClienteDefinition {

    @Steps
    InsertarAdmisionClienteSteps preEnviosSteps;


    @Given("^registro de datos cliente credito y destinatario$")
    public void registroDeDatosClienteCreditoYDestinatario() {preEnviosSteps.configurarInsertarAdmision();}
    @When("^consume de servicio InsertarAdmision$")
    public void consumeDeServicioInsertarAdmision() {
        preEnviosSteps.consumirInsertarAdmision();
    }
    @Then("^generacion de numero de preenvio$")
    public void generacion_de_numero_de_preenvio() {
        preEnviosSteps.numerosDePreenvios();
    }

}