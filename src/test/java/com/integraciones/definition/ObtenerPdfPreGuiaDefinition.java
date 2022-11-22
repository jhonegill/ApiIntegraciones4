package com.integraciones.definition;

import com.integraciones.steps.ObtenerPdfPreGuiaSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class ObtenerPdfPreGuiaDefinition {
    @Steps
    ObtenerPdfPreGuiaSteps pdfGuiasSteps;

    @Given("^registro de datos cliente credito$")
    public void registroDeDatosClienteCredito() {pdfGuiasSteps.configurarPdfPreGuiar();}
    @When("^consume el metodo ObtenerBasePdfPreGuia$")
    public void consumeElMetodoObtenerBasePdfPreGuia() {pdfGuiasSteps.obtenerPdfPreGuia();}
    @Then("^evienciar  el formato etiqueta uno a uno$")
    public void evienciarElFormatoEtiquetaUnoAUno() {pdfGuiasSteps.formatoPdfUnoAuno();
        }
}
