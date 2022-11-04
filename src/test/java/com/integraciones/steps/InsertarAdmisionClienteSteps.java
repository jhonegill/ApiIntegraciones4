package com.integraciones.steps;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

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

    // public static String fechaCreacionResponse;

    public void configurarInsertarAdmision(String usuario, String token, String idServicio,
                                           String idTipoEntrega, String valorDeclarado, String aplicaContrapago,
                                           String diceContener, String peso, String idTipoEnvio, String numeroPieza,
                                           String idFormaPago, String descripcionTipoEntrega, String observaciones,
                                           String largo, String ancho, String alto, String nombreTipoEnvio, String codigoConvenio,
                                           String idSucursal, String idCliente, String remitente, String idDestinatario,
                                           String tipoDocumento, String numeroDocumento, String nombre, String primerApellido,
                                           String segundoApellido, String telefono, String direccion, String correo, String idLocalidad,
                                           String idRemitente, String convenioDestinatario, String codigoConvenioDestinatario, String notificacion,
                                           String numerodeFolios, String codigoRapiRadicado, String idClienteCredito, String codigoConvenioRemitente) {

        requestPreenvios = null;
        requestPreenvios = given().contentType(ContentType.JSON).log().all()
                .header("x-app-signature", usuario)
                .header("x-app-security_token", token)
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "    \"idServicio\": " + idServicio + ", //Mensajeria (Icontroller - Servicio_TAR)\n" +
                        "    \"idTipoEntrega\": " + idTipoEntrega + ", //Entrega en Direccion (Icontroller - TipoEntrega_MEN)\n" +
                        "    \"valorDeclarado\": " + valorDeclarado + ",\n" +
                        "      \"AplicaContrapago\": " + aplicaContrapago + ",\n" +
                        "    \"diceContener\": " + '"' + diceContener + '"' + ",\n" +
                        "    \"peso\": " + peso + ",\n" +
                        "    \"idTipoEnvio\": " + idTipoEnvio + ", //Sobre Carta (Icontroller - TipoEnvio_TAR)\n" +
                        "    \"numeroPieza\": " + numeroPieza + ",\n" +
                        "    \"idFormaPago\": " + idFormaPago + ", //Crédito (Icontroller - FormasPago_TAR)\n" +
                        "    \"descripcionTipoEntrega\": " + descripcionTipoEntrega + ",\n" +
                        "    \"observaciones\": " + '"' + observaciones + '"' + ",\n" +
                        "    \"largo\": " + largo + ",\n" +
                        "    \"ancho\": " + ancho + ",\n" +
                        "    \"alto\": " + alto + ",\n" +
                        "    \"nombreTipoEnvio\": " + '"' + nombreTipoEnvio + '"' + ", //Sobre Carta (Icontroller - TipoEnvio_TAR)\n" +
                        "    \"codigoConvenio\": " + codigoConvenio + ",\n" +
                        "    \"idSucursal\": " + idSucursal + ",\n" +
                        "    \"idCliente\": " + idCliente + ",\n" +
                        "    \"remitente\": " + remitente + ",\n" +
                        "    \"destinatario\": {\n" +
                        "        \"idDestinatario\": " + idDestinatario + ",\n" +
                        "        \"tipoDocumento\": " + '"' + tipoDocumento + '"' + ",\n" +
                        "        \"numeroDocumento\": " + numeroDocumento + ",\n" +
                        "        \"nombre\": " + '"' + nombre + '"' + ",\n" +
                        "        \"primerApellido\": " + '"' + primerApellido + '"' + ",\n" +
                        "        \"segundoApellido\": " + '"' + segundoApellido + '"' + ",\n" +
                        "        \"telefono\": " + telefono + ",\n" +
                        "        \"direccion\": " + '"' + direccion + '"' + ",\n" +
                        "        \"correo\": " + '"' + correo + '"' + ",\n" +
                        "        \"idLocalidad\": " + idLocalidad + ",\n" +
                        "        \"idRemitente\": " + idRemitente + ",\n" +
                        "        \"convenioDestinatario\": " + convenioDestinatario + ",\n" +
                        "        \"codigoConvenio\": " + codigoConvenioDestinatario + "\n" +
                        "    },\n" +
                        "    \"notificacion\": " + notificacion + ",\n" +
                        "    \"rapiradicado\": {\n" +
                        "        \"numerodeFolios\": " + numerodeFolios + ",\n" +
                        "        \"codigoRapiRadicado\": " + codigoRapiRadicado + "\n" +
                        "    },\n" +
                        "    \"idClienteCredito\": " + idClienteCredito + ", //DIRECTV COLOMBIA LTDA (Icontroller - ClienteCredito_CLI)\n" +
                        "    \"codigoConvenioRemitente\": " + codigoConvenioRemitente + " //DIRECTV COLOMBIA LTDA -BODEGA / BOGOTA (Icontroller - Sucursal_CLI)\n" +
                        "}");
    }
    public void consumirInsertarAdmision(String metodoPreenvios, int cantidadPreenvios) {
        String baseUri = "https://apitesting.interrapidisimo.co";
        String path = "/ApiVentaCredito010/api/Admision";
        for (int i = 1; i <= cantidadPreenvios; i++) {

            responsePreenvios = requestPreenvios.when().post("" + baseUri + path + "/" + metodoPreenvios + "/");
            this.numerosDePreenvios();
            listaPreenvios.add(numeroPreenvioResponse);
        }
    }
    public void numerosDePreenvios() {
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxx");

        String listaDePreenvios = listaPreenvios.toString().replace("[", "").replace("]", "").replace(",", "\n");
        System.out.println( listaDePreenvios);

        String datosPreenvio = responsePreenvios.then()
                .statusCode(200)
                .extract().body().asString();
        from(datosPreenvio);
        //    String idPreenvioResponse = from(datosPreenvio).getString("idPreenvio");
        numeroPreenvioResponse = from(datosPreenvio).getString("numeroPreenvio");

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