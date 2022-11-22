package com.integraciones.steps;

import com.integraciones.ConfVariables;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Base64;
import static com.integraciones.steps.InsertarAdmisionClienteSteps.numeroPreenvioResponse;
import static io.restassured.path.json.JsonPath.from;


public class ObtenerPdfPreGuiaSteps {
    String numeroGuia = numeroPreenvioResponse;
    RequestSpecification requestFormatoGuia = SerenityRest.given();
    Response responseFormatoGuia;

    public void configurarPdfPreGuiar() {
        requestFormatoGuia.contentType(ContentType.JSON).log().all()
                .header("x-app-signature", ConfVariables.getUsuario())
                .header("x-app-security_token", ConfVariables.getToken());
    }
    public void obtenerPdfPreGuia() {
        String baseUri = ConfVariables.getHost();
        String path = ConfVariables.getPaths();
        responseFormatoGuia = requestFormatoGuia.when().get("" + baseUri + path + "/" + ConfVariables.getMetodoPdfGuia() + "/" + numeroGuia);
    }
    public void formatoPdfUnoAuno() {
        try {
            responseFormatoGuia.then().log().all().statusCode(200);
            String datosPreenvio = responseFormatoGuia.then()
                    .statusCode(200)
                    .extract().body().asString().replace("\"","").replace("\"","");
            from(datosPreenvio).toString();
            System.out.println(datosPreenvio);
            byte[] decodedBytes = Base64.getDecoder().decode(datosPreenvio);
            //File file = new File("C:\\Users\\jhonegill\\Desktop\\Nueva carpeta\\newfile.pdf");;
            File file = new File("PDF uno a uno.pdf");;
            FileOutputStream fop = new FileOutputStream(file);
            fop.write(decodedBytes);
            fop.flush();
            fop.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}