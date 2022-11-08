package com.integraciones.steps;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class ConsultarEstadoGuiasClienteSteps {
    String numeroGuias = "[240000000032, 240000000146]";
    RequestSpecification requestEstadosGuias = given();
    Response responseEstadosGuias;


    public void configurarEstadoGuiasCLientes(String usuario, String token, String idCliente) {
        requestEstadosGuias.log().all().contentType(ContentType.JSON)
                .header("x-app-signature", usuario)
                .header("x-app-security_token", token)
                .header("Content-Type", "application/json")
                .body("    {\n" +
                        "    \"idCliente\":" + idCliente + ",\n" +
                        "    \"numeroGuias\":" + this.numeroGuias + "" +
                        "}");
    }

    public void consumirEstadoGuiasClientes(String metodoConsumirEstadoGuias) {
        String baseUri = "https://apitesting.interrapidisimo.co";
        String path = "/ApiVentaCredito010/api/ClientesCredito";
        responseEstadosGuias = requestEstadosGuias.when().post("" + baseUri + path + "/" + metodoConsumirEstadoGuias + "/");
    }

    public void estadoGuiasClientes() {
        responseEstadosGuias.then().log().all().statusCode(200);
    }
}