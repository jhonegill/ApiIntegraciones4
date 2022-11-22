package com.integraciones.steps;

import com.integraciones.ConfVariables;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;

import static net.serenitybdd.rest.SerenityRest.*;
import static org.hamcrest.Matchers.notNullValue;

public class ResultadoListaCotizarSteps {

    public void configurarResultadoListaCotizar() {
        SerenityRest.given().log().all().contentType(ContentType.JSON);
    }
    public void consumirResultadoListaCotizar() {
        given().log().all().when().get("" + ConfVariables.getHost() + ConfVariables.getPathsCotizador()
                + "/" + ConfVariables.getMetodoResultadoListaCotizar()
                + "/" + Integer.parseInt(ConfVariables.getIdClienteCredito()) + "/"
                + Integer.parseInt(ConfVariables.geIdLocalidadOrigen())
                + "/" + Integer.parseInt(ConfVariables.geIdLocalidadDestino()) + "/" + ConfVariables.getPeso()
                + "/" + Integer.parseInt(ConfVariables.getValorDeclarado()) + "/"
                + Integer.parseInt(ConfVariables.getIdtipoEntrega()) + "/" + ConfVariables.getIFecha() + "");
    }
    public void resultadoListaCotizar() {
        then().log().all()
                .statusCode(200)
                .body("IdServicio", notNullValue());
    }
}