package com.integraciones.definition;

import com.integraciones.steps.ResultadoListaCotizarSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class ResultadoListaCotizarDefinition {
    @Steps
    ResultadoListaCotizarSteps listaCotizarSteps;

    @Given("^el Usuario realiza la configuracion del metodo ResultadoListaCotizar$")
    public void configurarResultadoListaCotizar() {listaCotizarSteps.configurarResultadoListaCotizar();}
    @When("^consume el metodo ResultadoListaCotizar$")
    public void consumeElMetodoResultadoListaCotizar() {listaCotizarSteps.consumirResultadoListaCotizar();}
    @Then("^evienciar  la lista de cotizacion de los clientes$")
    public void evienciarLaListaDeCotizacionDeLosClientes() {listaCotizarSteps.resultadoListaCotizar();}
}
