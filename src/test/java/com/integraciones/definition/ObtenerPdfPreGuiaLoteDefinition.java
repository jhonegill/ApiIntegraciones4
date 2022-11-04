package com.integraciones.definition;

import com.integraciones.steps.ObtenerPdfPreGuiaLoteSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class ObtenerPdfPreGuiaLoteDefinition {
    @Steps
    ObtenerPdfPreGuiaLoteSteps pdfGuiasLoteSteps;

    @Given("^el cliente configura el usuario \"([^\"]*)\", token \"([^\"]*)\",idCliente\"([^\"]*)\", idSucursal\"([^\"]*)\", porRangoFecha\"([^\"]*)\",fechaInicio\"([^\"]*)\",fechaFinal\"([^\"]*)\",formato\"([^\"]*)\"$")
    public void configurarformatoGuiaLote(String usuario, String token, String idCliente, String idSucursal, String porRangoFecha, String fechaInicio, String fechaFinal, String formato) {
        pdfGuiasLoteSteps.configurarFormatoGuiaLote(usuario, token, idCliente, idSucursal, porRangoFecha, fechaInicio, fechaFinal, formato);
    }

    @When("^consume el metodo Post para \"([^\"]*)\"$")
    public void consumirPdfPreGuiaLote(String metodoPdfGuiaLote) {
        pdfGuiasLoteSteps.consumirPdfPreGuiaLote(metodoPdfGuiaLote);
    }

    @Then("^puede ver el formato del pre envio por lote$")
    public void obtenerPdfPreGuiaLote() {
        pdfGuiasLoteSteps.obtenerPdfPreGuiaLote();
    }
}
