package com.integraciones.steps;

import io.restassured.http.ContentType;

import static net.serenitybdd.rest.SerenityRest.*;
import static org.hamcrest.Matchers.notNullValue;

public class ResultadoListaCotizarSteps {

    public void configurarResultadoListaCotizar() {
        given().log().all().contentType(ContentType.JSON);
    }

    public void consumirResultadoListaCotizar(String resultadoListaCotizar, String idCLiente, String idLocalidadOrigen, String idLocalidadDestino, String peso, String valorDeclarado, String idTipoEntrega, String fecha) {
        String baseUri = "https://apitesting.interrapidisimo.co";
        String path = "/ApiServInter010/api/CotizadorCliente";
        when().get("" + baseUri + path + "/" + resultadoListaCotizar + "/" + idCLiente + "/" + idLocalidadOrigen + "/" + idLocalidadDestino + "/" + peso + "/" + valorDeclarado + "/" + idTipoEntrega + "/" + fecha + "");
    }

    public void resultadoListaCotizar() {
        then().log().all()
                .statusCode(200)
                .body("IdServicio", notNullValue());
    }
}