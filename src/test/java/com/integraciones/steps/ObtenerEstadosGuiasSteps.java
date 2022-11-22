package com.integraciones.steps;

import com.integraciones.ConfVariables;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class ObtenerEstadosGuiasSteps {

    public void configurarEstadosGuias() {
        SerenityRest.given().log().all().contentType(ContentType.JSON);
    }
    public void consumirEstadoGuias() {
        String baseUri = ConfVariables.getHost();
        String path = ConfVariables.getPaths();
        SerenityRest.given().log().all().when().get("" + baseUri + path + "/" + ConfVariables.getObtenerEstadosGuias() + "/");
    }
    public void obtenerEstadoGuias() {
        given().then().log().all()
                .statusCode(200)
                .body("esG_IdEstadoGuia", notNullValue());
    }
}