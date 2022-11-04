package com.integraciones.definition;

import com.integraciones.steps.ObtenerPdfPreGuiaSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class ObtenerPdfPreGuiaDefinition {
    @Steps
    ObtenerPdfPreGuiaSteps pdfGuiasSteps;

    @Given("^el cliente configura el usuario \"([^\"]*)\", token \"([^\"]*)\"$")
    public void configurarPdfPreGuiar(String usuario, String token) {
        pdfGuiasSteps.configurarPdfPreGuiar(usuario, token);
    }

    @When("^consume el metodo Get \"([^\"]*)\"$")
    public void obtenerPdfPreGuia(String metodoPdfGuia) {
        pdfGuiasSteps.obtenerPdfPreGuia(metodoPdfGuia);
    }

    @Then("^puede ver el formato uno a uno$")
    public void formatoPdfUnoAuno() {
        pdfGuiasSteps.formatoPdfUnoAuno();
    }

}
