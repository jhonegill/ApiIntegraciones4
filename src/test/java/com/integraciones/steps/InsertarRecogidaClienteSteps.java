package com.integraciones.steps;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static com.integraciones.steps.InsertarAdmisionClienteSteps.listaPreenvios;
import static com.integraciones.steps.InsertarAdmisionClienteSteps.numeroPreenvioResponse;
import static io.restassured.RestAssured.given;
import static io.restassured.path.json.JsonPath.from;


public class InsertarRecogidaClienteSteps {
    String listaNumPreenvios = numeroPreenvioResponse;
    String Prueba = String.valueOf(listaPreenvios);
    RequestSpecification requestRecogida = given();
    Response responseRecogida;

    public void configurarRecogida(String usuario, String token, String idClienteCredito, String idSucursalCliente) {


        LocalDate hoy = LocalDate.now();
        LocalTime hora = LocalTime.now();
        hoy = hoy.plusDays(1);
        hora = hora.plusHours(1);
        LocalDateTime fechaCreacionResponse = LocalDateTime.of(hoy, hora);
        System.out.println("///////////////////////");
        System.out.println(fechaCreacionResponse);

        requestRecogida.contentType(ContentType.JSON).log().all()
                .header("x-app-signature", "" + usuario + "")
                .header("x-app-security_token", "" + token + "")
                .header("Content-Type", "application/json")
                .body("    {\n" +
                        "        \"IdClienteCredito\":" + idClienteCredito + ",\n" +
                        "        \"IdSucursalCliente\": " + idSucursalCliente + ",\n" +
                        "        \"listaNumPreenvios\": " + "" + this.Prueba + "" + ",\n" +
                        "        \"fechaRecogida\": \"" + "" + fechaCreacionResponse + "" + "\"\n" +
                        "    }");
    }
    public void consumirRecogidaCliente(String metodoRecogidas) {
        String baseUri = "https://apitesting.interrapidisimo.co";
        String path = "/ApiVentaCredito010/api/Recogida";
        responseRecogida = requestRecogida.when().post("" + baseUri + path + "/" + metodoRecogidas + "/");
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

        PrintWriter recogidasCsv = null;
        try {
            File csvFile = new File("C:\\Users\\jhonegill\\Desktop\\Nueva carpeta\\Recogidas.csv");
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
