package com.integraciones.steps;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static com.integraciones.steps.InsertarAdmisionClienteSteps.numeroPreenvioResponse;
import static io.restassured.RestAssured.given;

public class ObtenerPdfPreGuiaLoteSteps {
    String ltsPreGuias = numeroPreenvioResponse;
    RequestSpecification requestFormatoGuiaLote = given();
    Response responseFormatoGuiaLote;


    public void configurarFormatoGuiaLote(String usuario, String token, String idCliente, String idSucursal, String porRangoFecha, String fechaInicio, String fechaFinal, String formato) {
        requestFormatoGuiaLote.log().all().contentType(ContentType.JSON)
                .header("x-app-signature", usuario)
                .header("x-app-security_token", token)
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "    \"IdCliente\": " + idCliente + ",\n" +
                        "    \"IdSucursal\": " + idSucursal + ",\n" +
                        "    \"PorRangoFecha\": " + porRangoFecha + ",\n" +
                        "    \"LtsPreGuias\": [" + ltsPreGuias + "],\n" +
                        "    \"FechaInicio\": \"" + fechaInicio + "\",\n" +
                        "    \"FechaFinal\": \"" + fechaFinal + "\",\n" +
                        "    \"Formato\": " + formato + "\n" +
                        "}");
    }

    public void consumirPdfPreGuiaLote(String metodoPdfGuiaLote) {
        String baseUri = "https://apitesting.interrapidisimo.co";
        String path = "/ApiVentaCredito010/api/Admision";
        responseFormatoGuiaLote = requestFormatoGuiaLote.when().post("" + baseUri + path + "/" + metodoPdfGuiaLote + "/");
    }

    public void obtenerPdfPreGuiaLote() {
        responseFormatoGuiaLote.then().log().all().statusCode(200);
    }
}