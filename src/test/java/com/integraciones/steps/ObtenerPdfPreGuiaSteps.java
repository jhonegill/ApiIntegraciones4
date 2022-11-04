package com.integraciones.steps;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static com.integraciones.steps.InsertarAdmisionClienteSteps.numeroPreenvioResponse;
import static io.restassured.RestAssured.given;

public class ObtenerPdfPreGuiaSteps {
    String numeroGuia = numeroPreenvioResponse;
    RequestSpecification requestFormatoGuia = given();
    Response responseFormatoGuia;


    public void configurarPdfPreGuiar(String usuario, String token) {
        requestFormatoGuia.contentType(ContentType.JSON).log().all()
                .header("x-app-signature", usuario)
                .header("x-app-security_token", token);
    }

    public void obtenerPdfPreGuia(String metodoPdfGuia) {
        String baseUri = "https://apitesting.interrapidisimo.co";
        String path = "/ApiVentaCredito010/api/Admision";
        responseFormatoGuia = requestFormatoGuia.when().get("" + baseUri + path + "/" + metodoPdfGuia + "/" + numeroGuia);
    }

    public void formatoPdfUnoAuno() {
        responseFormatoGuia.then().log().all().statusCode(200);
    }
}