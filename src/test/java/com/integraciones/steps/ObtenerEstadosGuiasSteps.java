package com.integraciones.steps;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static net.serenitybdd.rest.RestRequests.when;
import static net.serenitybdd.rest.SerenityRest.then;
import static org.hamcrest.Matchers.notNullValue;

public class ObtenerEstadosGuiasSteps {

    public void configurarEstadosGuias() {
        given().log().all().contentType(ContentType.JSON);
    }

    public void consumirEstadoGuias(String metodoObtenerEstadosGuias) {
        String baseUri = "https://apitesting.interrapidisimo.co";
        String path = "/ApiVentaCredito010/api/Admision";
        when().get("" + baseUri + path + "/" + metodoObtenerEstadosGuias + "/");
    }

    public void obtenerEstadoGuias() {
        then().log().all()
                .statusCode(200)
                .body("esG_IdEstadoGuia", notNullValue());
    }
}