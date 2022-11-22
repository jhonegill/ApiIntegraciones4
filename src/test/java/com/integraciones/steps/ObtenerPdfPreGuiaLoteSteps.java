package com.integraciones.steps;

import com.integraciones.ConfVariables;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Base64;
import static com.integraciones.steps.InsertarAdmisionClienteSteps.listaPreenvios;
import static io.restassured.path.json.JsonPath.from;
import net.serenitybdd.rest.SerenityRest;

public class ObtenerPdfPreGuiaLoteSteps {

    String Preenvios = String.valueOf(listaPreenvios);
    RequestSpecification requestFormatoGuiaLote = SerenityRest.given();
    Response responseFormatoGuiaLote;

    public void configurarFormatoGuiaLote() {
        requestFormatoGuiaLote.log().all().contentType(ContentType.JSON)
                .header("x-app-signature", ConfVariables.getUsuario())
                .header("x-app-security_token", ConfVariables.getToken())
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "    \"IdCliente\": " + Integer.parseInt(ConfVariables.getIdClienteCredito()) + ",\n" +
                        "    \"IdSucursal\": " + Integer.parseInt(ConfVariables.getCodigoConvenioRemitente()) + ",\n" +
                        "    \"PorRangoFecha\": " + ConfVariables.getRangoFecha() + ",\n" +
                        "    \"LtsPreGuias\": " + "" + this.Preenvios + "" + ",\n" +
                        "    \"FechaInicio\": \"" + ConfVariables.getFechaInicio() + "\",\n" +
                        "    \"FechaFinal\": \"" + ConfVariables.getFechaFinal() + "\",\n" +
                        "    \"Formato\": " + ConfVariables.getFormato() + "\n" +
                        "}");
    }
    public void consumirPdfPreGuiaLote() {
        String baseUri = ConfVariables.getHost();
        String path = ConfVariables.getPaths();
        responseFormatoGuiaLote = requestFormatoGuiaLote.when().post("" + baseUri + path + "/" + ConfVariables.getMetodoPdfGuiaLote() + "/");
    }
    public void obtenerPdfPreGuiaLote() {
        try {
            responseFormatoGuiaLote.then().log().all().statusCode(200);
            String datosPreenvio = responseFormatoGuiaLote.then()
                    .statusCode(200)
                    .extract().body().asString();
            from(datosPreenvio).toString();
            System.out.println(datosPreenvio);
            String idRecogidaResponse = from(datosPreenvio).getString("pdfGuias");
            byte[] decodedBytes = Base64.getDecoder().decode(idRecogidaResponse);
            //File file = new File("C:\\Users\\jhonegill\\Desktop\\Nueva carpeta\\newfile.pdf");;
            File file = new File("PDF lotes.pdf");
            FileOutputStream fop = new FileOutputStream(file);
            fop.write(decodedBytes);
            fop.flush();
            fop.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}