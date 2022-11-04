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
    public void configurarResultadoListaCotizar() {
        listaCotizarSteps.configurarResultadoListaCotizar();
    }

    @When("^consume el metodo Get \"([^\"]*)\" con los paramteros idCLiente \"([^\"]*)\",idLocalidadOrigen\"([^\"]*)\",idLocalidadDestino\"([^\"]*)\",peso\"([^\"]*)\",valorDeclarado\"([^\"]*)\",idTipoEntrega\"([^\"]*)\",fecha\"([^\"]*)\"$")
    public void consumirResultadoListaCotizar(String resultadoListaCotizar, String idCLiente, String idLocalidadOrigen, String idLocalidadDestino, String peso, String valorDeclarado, String idTipoEntrega, String fecha) {
        listaCotizarSteps.consumirResultadoListaCotizar(resultadoListaCotizar, idCLiente, idLocalidadOrigen, idLocalidadDestino, peso, valorDeclarado, idTipoEntrega, fecha);
    }

    @Then("^puede ver la lista de cotizacion de los clientes$")
    public void resultadoListaCotizar() {
        listaCotizarSteps.resultadoListaCotizar();
    }
}
