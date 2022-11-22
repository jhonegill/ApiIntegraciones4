package com.integraciones;

import java.util.Optional;

public class ConfVariables {

    public static String getHost() {
        return Optional.ofNullable(System.getenv("host"))
                .orElse((String) ApplicationProperties.getInstance().get("host"));

    }

    public static String getPaths() {
        return Optional.ofNullable(System.getenv("paths"))
                .orElse((String) ApplicationProperties.getInstance().get("paths"));
    }

    public static String getInsertarAdmision() {
        return Optional.ofNullable(System.getenv("metodopreenvios"))
                .orElse((String) ApplicationProperties.getInstance().get("metodopreenvios"));
    }

    public static String getCantidadPreenvios() {
        return Optional.ofNullable(System.getenv("cantidadpreenvios"))
                .orElse((String) ApplicationProperties.getInstance().get("cantidadpreenvios"));
    }

    public static String getIdServicio() {
        return Optional.ofNullable(System.getenv("idservicio"))
                .orElse((String) ApplicationProperties.getInstance().get("idservicio"));
    }

    public static String getIdtipoEntrega() {
        return Optional.ofNullable(System.getenv("idtipoentrega"))
                .orElse((String) ApplicationProperties.getInstance().get("idtipoentrega"));
    }

    public static String getValorDeclarado() {
        return Optional.ofNullable(System.getenv("valordeclarado"))
                .orElse((String) ApplicationProperties.getInstance().get("valordeclarado"));
    }

    public static String getAplicaContrapago() {
        return Optional.ofNullable(System.getenv("aplicacontrapago"))
                .orElse((String) ApplicationProperties.getInstance().get("aplicacontrapago"));
    }

    public static String getDiceContener() {
        return Optional.ofNullable(System.getenv("dicecontener"))
                .orElse((String) ApplicationProperties.getInstance().get("dicecontener"));
    }

    public static String getIdTipoEnvio() {
        return Optional.ofNullable(System.getenv("idtipoenvio"))
                .orElse((String) ApplicationProperties.getInstance().get("idtipoenvio"));
    }

    public static String getNumeroPieza() {
        return Optional.ofNullable(System.getenv("numeropieza"))
                .orElse((String) ApplicationProperties.getInstance().get("numeropieza"));

    }

    public static String getPeso() {
        return Optional.ofNullable(System.getenv("peso"))
                .orElse((String) ApplicationProperties.getInstance().get("peso"));
    }

    public static String getIdFormaPago() {
        return Optional.ofNullable(System.getenv("idformapago"))
                .orElse((String) ApplicationProperties.getInstance().get("idformapago"));
    }

    public static String getDescripcionTipoEntrega() {
        return Optional.ofNullable(System.getenv("descripciontipoentrega"))
                .orElse((String) ApplicationProperties.getInstance().get("descripciontipoentrega"));
    }

    public static String getObservaciones() {
        return Optional.ofNullable(System.getenv("observaciones"))
                .orElse((String) ApplicationProperties.getInstance().get("observaciones"));
    }

    public static String getLargo() {
        return Optional.ofNullable(System.getenv("largo"))
                .orElse((String) ApplicationProperties.getInstance().get("largo"));
    }

    public static String getAncho() {
        return Optional.ofNullable(System.getenv("ancho"))
                .orElse((String) ApplicationProperties.getInstance().get("ancho"));
    }

    public static String getAlto() {
        return Optional.ofNullable(System.getenv("alto"))
                .orElse((String) ApplicationProperties.getInstance().get("alto"));
    }

    public static String getNombreTipoEnvio() {
        return Optional.ofNullable(System.getenv("nombretipoenvio"))
                .orElse((String) ApplicationProperties.getInstance().get("nombretipoenvio"));
    }

    public static String getCodigoConvenio() {
        return Optional.ofNullable(System.getenv("codigoconvenio"))
                .orElse((String) ApplicationProperties.getInstance().get("codigoconvenio"));
    }

    public static String getIdSucursal() {
        return Optional.ofNullable(System.getenv("idsucursal"))
                .orElse((String) ApplicationProperties.getInstance().get("idsucursal"));
    }

    public static String getIdCliente() {
        return Optional.ofNullable(System.getenv("idcliente"))
                .orElse((String) ApplicationProperties.getInstance().get("idcliente"));
    }

    public static String getRemitente() {
        return Optional.ofNullable(System.getenv("remitente"))
                .orElse((String) ApplicationProperties.getInstance().get("remitente"));
    }

    public static String getIdDestinatario() {
        return Optional.ofNullable(System.getenv("iddestinatario"))
                .orElse((String) ApplicationProperties.getInstance().get("iddestinatario"));
    }

    public static String getTipoDocumento() {
        return Optional.ofNullable(System.getenv("tipodocumento"))
                .orElse((String) ApplicationProperties.getInstance().get("tipodocumento"));
    }

    public static String getNumeroDocumento() {
        return Optional.ofNullable(System.getenv("numerodocumento"))
                .orElse((String) ApplicationProperties.getInstance().get("numerodocumento"));
    }

    public static String getNombre() {
        return Optional.ofNullable(System.getenv("nombre"))
                .orElse((String) ApplicationProperties.getInstance().get("nombre"));
    }

    public static String getPrimerApellido() {
        return Optional.ofNullable(System.getenv("primerapellido"))
                .orElse((String) ApplicationProperties.getInstance().get("primerapellido"));
    }

    public static String getSegundoApellido() {
        return Optional.ofNullable(System.getenv("segundoapellido"))
                .orElse((String) ApplicationProperties.getInstance().get("segundoapellido"));
    }

    public static String getTelefono() {
        return Optional.ofNullable(System.getenv("telefono"))
                .orElse((String) ApplicationProperties.getInstance().get("telefono"));
    }

    public static String getDireccion() {
        return Optional.ofNullable(System.getenv("direccion"))
                .orElse((String) ApplicationProperties.getInstance().get("direccion"));
    }

    public static String getCorreo() {
        return Optional.ofNullable(System.getenv("correo"))
                .orElse((String) ApplicationProperties.getInstance().get("correo"));
    }

    public static String getIdLocalidad() {
        return Optional.ofNullable(System.getenv("idlocalidad"))
                .orElse((String) ApplicationProperties.getInstance().get("idlocalidad"));
    }

    public static String getIdRemitente() {
        return Optional.ofNullable(System.getenv("idremitente"))
                .orElse((String) ApplicationProperties.getInstance().get("idremitente"));
    }

    public static String getConvenioDestinatario() {
        return Optional.ofNullable(System.getenv("conveniodestinatario"))
                .orElse((String) ApplicationProperties.getInstance().get("conveniodestinatario"));
    }

    public static String getNotificacion() {
        return Optional.ofNullable(System.getenv("notificacion"))
                .orElse((String) ApplicationProperties.getInstance().get("notificacion"));
    }

    public static String getNumeroFolios() {
        return Optional.ofNullable(System.getenv("numerodefolios"))
                .orElse((String) ApplicationProperties.getInstance().get("numerodefolios"));
    }

    public static String getCodigoRapiRadicado() {
        return Optional.ofNullable(System.getenv("codigorapiradicado"))
                .orElse((String) ApplicationProperties.getInstance().get("codigorapiradicado"));
    }

    public static String getIdClienteCredito() {
        return Optional.ofNullable(System.getenv("idclientecredito"))
                .orElse((String) ApplicationProperties.getInstance().get("idclientecredito"));
    }

    public static String getCodigoConvenioRemitente() {
        return Optional.ofNullable(System.getenv("codigoconvenioremitente"))
                .orElse((String) ApplicationProperties.getInstance().get("codigoconvenioremitente"));
    }

    public static String getCodigoConvenioDestinatario() {
        return Optional.ofNullable(System.getenv("codigoconveniodestinatario"))
                .orElse((String) ApplicationProperties.getInstance().get("codigoconveniodestinatario"));
    }

    public static String getUsuario() {
        return Optional.ofNullable(System.getenv("usuario"))
                .orElse((String) ApplicationProperties.getInstance().get("usuario"));
    }

    public static String getToken() {
        return Optional.ofNullable(System.getenv("token"))
                .orElse((String) ApplicationProperties.getInstance().get("token"));
    }

    public static String getMetodoRecogidas() {
        return Optional.ofNullable(System.getenv("metodorecogidas"))
                .orElse((String) ApplicationProperties.getInstance().get("metodorecogidas"));
    }

    public static String getObtenerEstadosGuias() {
        return Optional.ofNullable(System.getenv("obtenerestadosguias"))
                .orElse((String) ApplicationProperties.getInstance().get("obtenerestadosguias"));
    }

    public static String getMetodoPdfGuia() {
        return Optional.ofNullable(System.getenv("metodopdfguia"))
                .orElse((String) ApplicationProperties.getInstance().get("metodopdfguia"));
    }

    public static String getMetodoPdfGuiaLote() {
        return Optional.ofNullable(System.getenv("metodopdfguialote"))
                .orElse((String) ApplicationProperties.getInstance().get("metodopdfguialote"));
    }

    public static String getRangoFecha() {
        return Optional.ofNullable(System.getenv("porrangofecha"))
                .orElse((String) ApplicationProperties.getInstance().get("porrangofecha"));
    }

    public static String getFechaInicio() {
        return Optional.ofNullable(System.getenv("fechainicio"))
                .orElse((String) ApplicationProperties.getInstance().get("fechainicio"));
    }

    public static String getFechaFinal() {
        return Optional.ofNullable(System.getenv("fechafinal"))
                .orElse((String) ApplicationProperties.getInstance().get("fechafinal"));
    }

    public static String getFormato() {
        return Optional.ofNullable(System.getenv("formato"))
                .orElse((String) ApplicationProperties.getInstance().get("formato"));
    }

    public static String getPathsCotizador() {
        return Optional.ofNullable(System.getenv("pathscotizador"))
                .orElse((String) ApplicationProperties.getInstance().get("pathscotizador"));
    }

    public static String getMetodoResultadoListaCotizar() {
        return Optional.ofNullable(System.getenv("metodoresultadolistacotizar"))
                .orElse((String) ApplicationProperties.getInstance().get("metodoresultadolistacotizar"));
    }

    public static String geIdLocalidadOrigen() {
        return Optional.ofNullable(System.getenv("idlocalidadorigen"))
                .orElse((String) ApplicationProperties.getInstance().get("idlocalidadorigen"));
    }

    public static String geIdLocalidadDestino() {
        return Optional.ofNullable(System.getenv("idlocalidaddestino"))
                .orElse((String) ApplicationProperties.getInstance().get("idlocalidaddestino"));
    }

    public static String getIFecha() {
        return Optional.ofNullable(System.getenv("fecha"))
                .orElse((String) ApplicationProperties.getInstance().get("fecha"));
    }

    public static String getPathRecogidas() {
        return Optional.ofNullable(System.getenv("pathrecogidas"))
                .orElse((String) ApplicationProperties.getInstance().get("pathrecogidas"));
    }
    public static String getNumeroGuia1() {
        return Optional.ofNullable(System.getenv("numeroguia1"))
                .orElse((String) ApplicationProperties.getInstance().get("numeroguia1"));
    }
    public static String getPathClienteCredito() {
        return Optional.ofNullable(System.getenv("pathclientecredito"))
                .orElse((String) ApplicationProperties.getInstance().get("pathclientecredito"));
    }
    public static String getMetodoEtadoGuias() {
        return Optional.ofNullable(System.getenv("metodoetadoguias"))
                .orElse((String) ApplicationProperties.getInstance().get("metodoetadoguias"));
    }
}



