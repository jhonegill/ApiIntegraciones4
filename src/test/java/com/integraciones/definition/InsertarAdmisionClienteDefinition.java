
package com.integraciones.definition;

import com.integraciones.steps.InsertarAdmisionClienteSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class InsertarAdmisionClienteDefinition {

    @Steps
    InsertarAdmisionClienteSteps preEnviosSteps;

    @Given("^registro de datos cliente credito y destinatario  \"([^\"]*)\", token \"([^\"]*)\", idServicio \"([^\"]*)\", idTipoEntrega \"([^\"]*)\", valorDeclarado \"([^\"]*)\", aplicaContrapago \"([^\"]*)\", diceContener \"([^\"]*)\", peso \"([^\"]*)\", idTipoEnvio \"([^\"]*)\", numeroPieza \"([^\"]*)\", idFormaPago \"([^\"]*)\", descripcionTipoEntrega \"([^\"]*)\", observaciones \"([^\"]*)\",largo \"([^\"]*)\",ancho \"([^\"]*)\",alto \"([^\"]*)\",nombreTipoEnvio \"([^\"]*)\",codigoConvenio \"([^\"]*)\",idSucursal \"([^\"]*)\",idCliente \"([^\"]*)\",remitente \"([^\"]*)\",idDestinatario \"([^\"]*)\",tipoDocumento \"([^\"]*)\",numeroDocumento \"([^\"]*)\",nombre \"([^\"]*)\",primerApellido \"([^\"]*)\",segundoApellido \"([^\"]*)\",telefono \"([^\"]*)\",direccion \"([^\"]*)\",correo \"([^\"]*)\",idLocalidad \"([^\"]*)\",idRemitente \"([^\"]*)\",convenioDestinatario \"([^\"]*)\",codigoConvenioDestinatario \"([^\"]*)\",notificacion \"([^\"]*)\",numerodeFolios \"([^\"]*)\",codigoRapiRadicado \"([^\"]*)\",idClienteCredito \"([^\"]*)\",codigoConvenioRemitente\"(\\d+)$")
    public void registro_de_datos_cliente_credito_y_destinatario_token_idServicio_idTipoEntrega_valorDeclarado_aplicaContrapago_diceContener_peso_idTipoEnvio_numeroPieza_idFormaPago_descripcionTipoEntrega_observaciones_largo_ancho_alto_nombreTipoEnvio_codigoConvenio_idSucursal_idCliente_remitente_idDestinatario_tipoDocumento_numeroDocumento_nombre_primerApellido_segundoApellido_telefono_direccion_correo_idLocalidad_idRemitente_convenioDestinatario_codigoConvenioDestinatario_notificacion_numerodeFolios_codigoRapiRadicado_idClienteCredito_codigoConvenioRemitente(String usuario, String token, String idServicio, String idTipoEntrega, String valorDeclarado, String aplicaContrapago, String diceContener, String peso, String idTipoEnvio, String numeroPieza, String idFormaPago, String descripcionTipoEntrega, String observaciones, String largo, String ancho, String alto, String nombreTipoEnvio, String codigoConvenio, String idSucursal, String idCliente, String remitente, String idDestinatario, String tipoDocumento, String numeroDocumento, String nombre, String primerApellido, String segundoApellido, String telefono, String direccion, String correo, String idLocalidad, String idRemitente, String convenioDestinatario, String codigoConvenioDestinatario, String notificacion, String numerodeFolios, String codigoRapiRadicado, String idClienteCredito, String codigoConvenioRemitente) {
        preEnviosSteps.configurarInsertarAdmision(usuario, token, idServicio, idTipoEntrega, valorDeclarado, aplicaContrapago, diceContener, peso, idTipoEnvio, numeroPieza, idFormaPago, descripcionTipoEntrega, observaciones, largo, ancho, alto, nombreTipoEnvio, codigoConvenio, idSucursal, idCliente, remitente, idDestinatario, tipoDocumento, numeroDocumento, nombre, primerApellido, segundoApellido, telefono, direccion, correo, idLocalidad, idRemitente, convenioDestinatario, codigoConvenioDestinatario, notificacion, numerodeFolios, codigoRapiRadicado, idClienteCredito, codigoConvenioRemitente);
    }
    @When("^consume de servicio InsertarAdmision \"([^\"]*)\",\"([^\"]*)\"$")
    public void consume_de_servicio_InsertarAdmision(String metodoPreenvios, int cantidadPreenvios) {
        preEnviosSteps.consumirInsertarAdmision(metodoPreenvios, cantidadPreenvios);
    }
    @Then("^generacion de numero de preenvio$")
    public void generacion_de_numero_de_preenvio() {
        preEnviosSteps.numerosDePreenvios();
    }
}