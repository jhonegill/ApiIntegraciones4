package com.integraciones.definition;

import com.integraciones.steps.ObtenerPdfPreGuiaLoteSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class ObtenerPdfPreGuiaLoteDefinition {
    @Steps
    ObtenerPdfPreGuiaLoteSteps pdfGuiasLoteSteps;
    @Given("^registro de datos cliente credito y preenvios a consultar$")
    public void registroDeDatosClienteCreditoYPreenviosAConsultar() {pdfGuiasLoteSteps.configurarFormatoGuiaLote();
    }
    @When("^consume el metodo  ObtenerBasePdfPreGuias$")
    public void consumeElMetodoObtenerBasePdfPreGuias() { pdfGuiasLoteSteps.consumirPdfPreGuiaLote();}
    @Then("^evienciar  el formato etiqueta por lote$")
    public void evienciarElFormatoEtiquetaPorLote() {pdfGuiasLoteSteps.obtenerPdfPreGuiaLote();}
}
