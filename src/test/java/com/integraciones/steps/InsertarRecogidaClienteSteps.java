package com.integraciones.steps;

import com.integraciones.ConfVariables;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.core.Serenity;
import java.io.File;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import net.serenitybdd.rest.SerenityRest;
import static com.integraciones.steps.InsertarAdmisionClienteSteps.listaPreenvios;
import static io.restassured.RestAssured.given;
import static io.restassured.path.json.JsonPath.from;

public class InsertarRecogidaClienteSteps {
   // String listaNumPreenvios = numeroPreenvioResponse;
    String Preenvios = String.valueOf(listaPreenvios);
    RequestSpecification requestRecogida = SerenityRest.given();
    Response responseRecogida;

    public void configurarRecogida() {

        LocalDate hoy = LocalDate.now();
        LocalTime hora = LocalTime.now();
        hora = hora.plusHours(1);
        LocalDateTime fechaCreacionResponse = LocalDateTime.of(hoy,hora);

        requestRecogida.contentType(ContentType.JSON).log().all()
                .header("x-app-signature", "" + ConfVariables.getUsuario() + "")
                .header("x-app-security_token", "" + ConfVariables.getToken() + "")
                .header("Content-Type", "application/json")
                .body("    {\n" +
                        "        \"IdClienteCredito\":" + Integer.parseInt(ConfVariables.getIdClienteCredito()) + ",\n" +
                        "        \"IdSucursalCliente\": " + Integer.parseInt(ConfVariables.getCodigoConvenioRemitente()) + ",\n" +
                        "        \"listaNumPreenvios\": " + "" + this.Preenvios + "" + ",\n" +
                        "        \"fechaRecogida\": \"" + "" + fechaCreacionResponse + "" + "\"\n" +
                        "    }");
    }
    public void consumirRecogidaCliente() {
        String baseUri = ConfVariables.getHost();
        String path = ConfVariables.getPathRecogidas();
        responseRecogida = requestRecogida.when().post("" + baseUri + path + "/" + ConfVariables.getMetodoRecogidas() + "/");
    }
    public void generarRecogidas() {

        responseRecogida.body().print();
        String datosRecogida = responseRecogida.then()
                .statusCode(200)
                .extract().body().asString();
        from(datosRecogida);

        String mensajePreenviosAsociados;
        String preenviosAsociados;
        String mensajePreenviosNoIncluidos;
        String preenviosNoIncluidos;
        String idRecogidaResponse = from(datosRecogida).getString("idRecogida");
        mensajePreenviosAsociados = from(datosRecogida).getString("mensajePreenviosAsociados");
        preenviosAsociados = from(datosRecogida).getString("preenviosAsociados").toString().replace("[", "").replace("]", "").replace(",", "\n");
        mensajePreenviosNoIncluidos = from(datosRecogida).getString("mensajePreenviosNoIncluidos");
        preenviosNoIncluidos = from(datosRecogida).getString("preenviosNoIncluidos").toString().replace("[", "").replace("]", "").replace(",", "");
      Serenity.recordReportData().withTitle("Id Recogida:")
        .andContents("Id recogida: " + idRecogidaResponse +"\n"+ "Preenvios asociados:" +"\n"+ preenviosAsociados);
        PrintWriter recogidasCsv = null;
        try {
            File csvFile = new File("Recogidas.csv");
           // File csvFile = new File("C:\\Users\\jhonegill\\Desktop\\Nueva carpeta\\Recogidas.csv");
            recogidasCsv = new PrintWriter(csvFile);
            recogidasCsv.println(idRecogidaResponse);
            recogidasCsv.println(mensajePreenviosAsociados);
            recogidasCsv.println(preenviosAsociados);
            recogidasCsv.println(mensajePreenviosNoIncluidos);
            recogidasCsv.println(preenviosNoIncluidos);

        } catch (Exception e) {
        } finally {
            if (recogidasCsv != null) {
                recogidasCsv.close();
            }
        }
    }
}
