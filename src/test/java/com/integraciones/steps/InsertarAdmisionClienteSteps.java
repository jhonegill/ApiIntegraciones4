package com.integraciones.steps;

import com.integraciones.ConfVariables;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static io.restassured.path.json.JsonPath.from;


public class InsertarAdmisionClienteSteps {
    RequestSpecification requestPreenvios;
    Response responsePreenvios;
    public static String numeroPreenvioResponse;
    public static ArrayList<String> listaPreenvios = new ArrayList<String>();
    public void configurarInsertarAdmision() {

        requestPreenvios = SerenityRest.given().contentType(ContentType.JSON).log().all()
                .header("x-app-signature", ConfVariables.getUsuario())
                .header("x-app-security_token", ConfVariables.getToken())
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "    \"idServicio\": " + Integer.parseInt(ConfVariables.getIdServicio()) + ", //Mensajeria (Icontroller - Servicio_TAR)\n" +
                        "    \"idTipoEntrega\": " + Integer.parseInt(ConfVariables.getIdtipoEntrega()) + ", //Entrega en Direccion (Icontroller - TipoEntrega_MEN)\n" +
                        "    \"valorDeclarado\": " + Integer.parseInt(ConfVariables.getValorDeclarado()) + ",\n" +
                        "      \"AplicaContrapago\": " + ConfVariables.getAplicaContrapago() + ",\n" +
                        "    \"diceContener\": " + '"' + ConfVariables.getDiceContener() + '"' + ",\n" +
                        "    \"peso\": " + ConfVariables.getPeso() + ",\n" +
                        "    \"idTipoEnvio\": " + ConfVariables.getIdTipoEnvio() + ", //Sobre Carta (Icontroller - TipoEnvio_TAR)\n" +
                        "    \"numeroPieza\": " + ConfVariables.getNumeroPieza() + ",\n" +
                        "    \"idFormaPago\": " + ConfVariables.getIdFormaPago() + ", //Crédito (Icontroller - FormasPago_TAR)\n" +
                        "    \"descripcionTipoEntrega\": " + ConfVariables.getDescripcionTipoEntrega() + ",\n" +
                        "    \"observaciones\": " + '"' + ConfVariables.getObservaciones() + '"' + ",\n" +
                        "    \"largo\": " + Integer.parseInt(ConfVariables.getLargo()) + ",\n" +
                        "    \"ancho\": " + Integer.parseInt(ConfVariables.getAncho()) + ",\n" +
                        "    \"alto\": " + Integer.parseInt(ConfVariables.getAlto()) + ",\n" +
                        "    \"nombreTipoEnvio\": " + '"' + ConfVariables.getNombreTipoEnvio() + '"' + ", //Sobre Carta (Icontroller - TipoEnvio_TAR)\n" +
                        "    \"codigoConvenio\": " + Integer.parseInt(ConfVariables.getCodigoConvenio()) + ",\n" +
                        "    \"idSucursal\": " + Integer.parseInt(ConfVariables.getIdSucursal()) + ",\n" +
                        "    \"idCliente\": " + Integer.parseInt(ConfVariables.getIdCliente()) + ",\n" +
                        "    \"remitente\": " + ConfVariables.getRemitente() + ",\n" +
                        "    \"destinatario\": {\n" +
                        "        \"idDestinatario\": " + Integer.parseInt(ConfVariables.getIdDestinatario())  + ",\n" +
                        "        \"tipoDocumento\": " + '"' + ConfVariables.getTipoDocumento()  + '"' + ",\n" +
                        "        \"numeroDocumento\": " + Integer.parseInt(ConfVariables.getNumeroDocumento())  + ",\n" +
                        "        \"nombre\": " + '"' + ConfVariables.getNombre() + '"' + ",\n" +
                        "        \"primerApellido\": " + '"' + ConfVariables.getPrimerApellido() + '"' + ",\n" +
                        "        \"segundoApellido\": " + '"' + ConfVariables.getSegundoApellido() + '"' + ",\n" +
                        "        \"telefono\": " + Integer.parseInt(ConfVariables.getTelefono()) + ",\n" +
                        "        \"direccion\": " + '"' + ConfVariables.getDireccion() + '"' + ",\n" +
                        "        \"correo\": " + '"' + ConfVariables.getCorreo() + '"' + ",\n" +
                        "        \"idLocalidad\": " + Integer.parseInt(ConfVariables.getIdLocalidad()) + ",\n" +
                        "        \"idRemitente\": " + Integer.parseInt(ConfVariables.getIdRemitente()) + ",\n" +
                        "        \"convenioDestinatario\": " + Integer.parseInt(ConfVariables.getCodigoConvenioDestinatario()) + ",\n" +
                        "        \"codigoConvenio\": " + Integer.parseInt(ConfVariables.getCodigoConvenio()) + "\n" +
                        "    },\n" +
                        "    \"notificacion\": " + ConfVariables.getNotificacion() + ",\n" +
                        "    \"rapiradicado\": {\n" +
                        "        \"numerodeFolios\": " + Integer.parseInt(ConfVariables.getNumeroFolios()) + ",\n" +
                        "        \"codigoRapiRadicado\": " + Integer.parseInt(ConfVariables.getCodigoRapiRadicado()) + "\n" +
                        "    },\n" +
                        "    \"idClienteCredito\": " + Integer.parseInt(ConfVariables.getIdClienteCredito()) + ", \n" +
                        "    \"codigoConvenioRemitente\": " + Integer.parseInt(ConfVariables.getCodigoConvenioRemitente()) + "\n" +
                        "}");
    }
    public void consumirInsertarAdmision() {
        String baseUri = ConfVariables.getHost();
        String path = ConfVariables.getPaths();
        for (int i = 1; i <= Integer.parseInt(ConfVariables.getCantidadPreenvios()); i++) {

            responsePreenvios = requestPreenvios.given().when().post("" + baseUri + path + "/" + ConfVariables.getInsertarAdmision() + "/");
            this.numerosDePreenvios();
            listaPreenvios.add(numeroPreenvioResponse);
        }
    }
    public void numerosDePreenvios() {
        String listaDePreenvios = listaPreenvios.toString().replace("[", "").replace("]", "").replace(",", "\n");
        String datosPreenvio = responsePreenvios.then().log().all()
                .statusCode(200)
                .extract().body().asString();
        from(datosPreenvio);
        numeroPreenvioResponse = from(datosPreenvio).getString("numeroPreenvio");
      Serenity.recordReportData().withTitle("Preenvios generados " + listaDePreenvios)
                .andContents("Preenvios: " +"\n"+ listaDePreenvios);
        PrintWriter preenviosCsv = null;
        try {
            File csvFile = new File("Preenvios.csv");
            preenviosCsv = new PrintWriter(csvFile);
            preenviosCsv.println(listaDePreenvios);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (preenviosCsv != null) {
                preenviosCsv.close();
            }
        }
    }
}