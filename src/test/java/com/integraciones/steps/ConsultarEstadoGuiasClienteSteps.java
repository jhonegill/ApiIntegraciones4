package com.integraciones.steps;

import com.integraciones.ConfVariables;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;

public class ConsultarEstadoGuiasClienteSteps {
    String numeroGuias = ConfVariables.getNumeroGuia1();
    RequestSpecification requestEstadosGuias = SerenityRest.given();
    Response responseEstadosGuias;
    public void configurarEstadoGuiasCLientes() {
        requestEstadosGuias.log().all().contentType(ContentType.JSON)
                .header("x-app-signature", ConfVariables.getUsuario())
                .header("x-app-security_token", ConfVariables.getToken())
                .header("Content-Type", "application/json")
                .body("    {\n" +
                        "    \"idCliente\":" + ConfVariables.getIdClienteCredito() + ",\n" +
                        "    \"numeroGuias\":" + this.numeroGuias + "" +
                        "}");
    }
    public void consumirEstadoGuiasClientes() {
        String baseUri = ConfVariables.getHost();
        String path = ConfVariables.getPathClienteCredito();
        responseEstadosGuias = requestEstadosGuias.when().post("" + baseUri + path + "/" + ConfVariables.getMetodoEtadoGuias() + "/");
    }
    public void estadoGuiasClientes() {
        responseEstadosGuias.then().log().all().statusCode(200);
    }
}