@integraciones

Feature: Validar El Consumo De Las APIS De Venta Credito

  @metodoInsertarAdmisionCliente
  Scenario Outline: Creacion de Pre Envios|
    Given el cliente configura el  usuario "<usuario>", token "<token>", idServicio "<idServicio>", idTipoEntrega "<idTipoEntrega>", valorDeclarado "<valorDeclarado>", aplicaContrapago "<aplicaContrapago>", diceContener "<diceContener>", peso "<peso>", idTipoEnvio "<idTipoEnvio>", numeroPieza "<numeroPieza>", idFormaPago "<idFormaPago>", descripcionTipoEntrega "<descripcionTipoEntrega>", observaciones "<observaciones>",largo "<largo>",ancho "<ancho>",alto "<alto>",nombreTipoEnvio "<nombreTipoEnvio>",codigoConvenio "<codigoConvenio>",idSucursal "<idSucursal>",idCliente "<idCliente>",remitente "<remitente>",idDestinatario "<idDestinatario>",tipoDocumento "<tipoDocumento>",numeroDocumento "<numeroDocumento>",nombre "<nombre>",primerApellido "<primerApellido>",segundoApellido "<segundoApellido>",telefono "<telefono>",direccion "<direccion>",correo "<correo>",idLocalidad "<idLocalidad>",idRemitente "<idRemitente>",convenioDestinatario "<convenioDestinatario>",codigoConvenioDestinatario "<codigoConvenioDestinatario>",notificacion "<notificacion>",numerodeFolios "<numerodeFolios>",codigoRapiRadicado "<codigoRapiRadicado>",idClienteCredito "<idClienteCredito>",codigoConvenioRemitente"<codigoConvenioRemitente>
    When consume el metodo Post que permite "<metodoPreenvios>","<cantidadPreenvios>"
    Then  puede ver el id y el numero de pre envio

    Examples:
      | metodoPreenvios  | cantidadPreenvios | idServicio | idTipoEntrega | valorDeclarado | aplicaContrapago | diceContener                 | peso | idTipoEnvio | numeroPieza | idFormaPago | descripcionTipoEntrega | observaciones      | largo | ancho | alto | nombreTipoEnvio | codigoConvenio | idSucursal | idCliente | remitente | idDestinatario | tipoDocumento | numeroDocumento | nombre | primerApellido | segundoApellido   | telefono | direccion         | correo                        | idLocalidad | idRemitente | convenioDestinatario | codigoConvenioDestinatario | notificacion | numerodeFolios | codigoRapiRadicado | idClienteCredito | codigoConvenioRemitente | usuario       | token                                                                                                                                                                                                                                                                   |
      | InsertarAdmision | 1                 | 3          | 1             | 150000         | false            | Prueba API Insertar Admision | 3    | 1           | 1           | 2           |                        | API Cliente Prueba | 10    | 10    | 10   | Sobre Carta     | 0              | 0          | 0         | null      | 0              | CC            | 900460915       | Sergio | Chiquillo      | API Venta Credito | 5605000  | Carrera 2#calle 4 | destinatario@correoprueba.com | 66001000    | 0           | 0                    | 0                          | null         | 7              | 25541545           | 996             | 10553                   | userCopidrogaspruebasPRUE    |bearer 1aaCeHNgpuCU-3sQ8oaNDL7frGBxd7lh6IyJh-eGS9HfN48coZVueh9gLh9ffAUx7GrBvuC823tma2rZlTPKpzUtj9rZBeOCWbTEadRENduskbUzieNDy-sMzPoWih_jnkX1Tl0XFT8ZLPdT8KLBgH96dQsIPl2mIyodA4V72JHBNqhHCplePmptMQ9heG4LBHNq0AoCZKV2Wmc5gHuC_der75zJzTmOS6xAiMk2l4TziRWqwZkYRt2JKU3dqLGd|
      | InsertarAdmision | 1                 | 3          | 1             | 170000         | false             | Prueba API Insertar Admision | 3    | 1           | 1           | 2           |                        | API Cliente Prueba | 10    | 10    | 10   | Sobre Carta     | 0              | 0          | 0         | null      | 0              | CC            | 900460915       | Sergio | Chiquillo      | API Venta Credito | 5605000  | Carrera 2#calle 4 | destinatario@correoprueba.com | 66001000    | 0           | 0                    | 0                          | null         | 7              | 25541545           | 996             | 10553                   | userCopidrogaspruebasPRUE |bearer 1aaCeHNgpuCU-3sQ8oaNDL7frGBxd7lh6IyJh-eGS9HfN48coZVueh9gLh9ffAUx7GrBvuC823tma2rZlTPKpzUtj9rZBeOCWbTEadRENduskbUzieNDy-sMzPoWih_jnkX1Tl0XFT8ZLPdT8KLBgH96dQsIPl2mIyodA4V72JHBNqhHCplePmptMQ9heG4LBHNq0AoCZKV2Wmc5gHuC_der75zJzTmOS6xAiMk2l4TziRWqwZkYRt2JKU3dqLGd|


  @metodoInsertarRecogidaCliente
  Scenario Outline: Creacion de Recogidas
    Given el cliente configura el "<usuario>", token "<token>", idClienteCredito "<idClienteCredito>" y idSucursalCliente "<idSucursalCliente>"
    When consume el metodo Post llamado "<metodoRecogidas>"
    Then  puede generar el id de la recogida

    Examples:
      | metodoRecogidas         | idClienteCredito | idSucursalCliente | usuario    | token                                                                                                                                                                                                                                              |
      | InsertarRecogidaCliente | 996             | 10553              | userCopidrogaspruebasPRUE |bearer 1aaCeHNgpuCU-3sQ8oaNDL7frGBxd7lh6IyJh-eGS9HfN48coZVueh9gLh9ffAUx7GrBvuC823tma2rZlTPKpzUtj9rZBeOCWbTEadRENduskbUzieNDy-sMzPoWih_jnkX1Tl0XFT8ZLPdT8KLBgH96dQsIPl2mIyodA4V72JHBNqhHCplePmptMQ9heG4LBHNq0AoCZKV2Wmc5gHuC_der75zJzTmOS6xAiMk2l4TziRWqwZkYRt2JKU3dqLGd|
  @metodoObtenerEstadosGuias
  Scenario: Obtener estado de las guias
    Given el cliente realiza la configuracion del metodo ObtenerEstadosGuias
    When consume el metodo Get llamado "ObtenerEstadosGuias"
    Then puede ver los estados logisticos de las guias


  @metodoObtenerPdfPreGuia
  Scenario Outline: Obtener el formato de Pre envios para su impersion uno a uno
    Given el cliente configura el usuario "<usuario>", token "<token>"
    When consume el metodo Get "<metodoPdfGuia>"
    Then  puede ver el formato uno a uno
    Examples:
      | metodoPdfGuia           | usuario    | token |
      | ObtenerBase64PdfPreGuia | userCopidrogaspruebasPRUE | bearer 1aaCeHNgpuCU-3sQ8oaNDL7frGBxd7lh6IyJh-eGS9HfN48coZVueh9gLh9ffAUx7GrBvuC823tma2rZlTPKpzUtj9rZBeOCWbTEadRENduskbUzieNDy-sMzPoWih_jnkX1Tl0XFT8ZLPdT8KLBgH96dQsIPl2mIyodA4V72JHBNqhHCplePmptMQ9heG4LBHNq0AoCZKV2Wmc5gHuC_der75zJzTmOS6xAiMk2l4TziRWqwZkYRt2JKU3dqLGd   |


  @metodoObtenerPdfPreGuiaLote
  Scenario Outline: Obtener el formato de Pre envios para su impersion por lotes
    Given el cliente configura el usuario "<usuario>", token "<token>",idCliente"<idCliente>", idSucursal"<idSucursal>", porRangoFecha"<porRangoFecha>",fechaInicio"<fechaInicio>",fechaFinal"<fechaFinal>",formato"<formato>"
    When consume el metodo Post para "<metodoPdfGuiaLote>"
    Then  puede ver el formato del pre envio por lote
    Examples:
      | metodoPdfGuiaLote        | idCliente | idSucursal | porRangoFecha | fechaInicio                      | fechaFinal                       | formato | usuario    | token |
      | ObtenerBase64PdfPreguias | 996      | 10553       | false         | 2022-08-29T08:31:46.166778-05:00 | 2022-08-29T08:31:46.166778-05:00 | 1       | userCopidrogaspruebasPRUE |bearer 1aaCeHNgpuCU-3sQ8oaNDL7frGBxd7lh6IyJh-eGS9HfN48coZVueh9gLh9ffAUx7GrBvuC823tma2rZlTPKpzUtj9rZBeOCWbTEadRENduskbUzieNDy-sMzPoWih_jnkX1Tl0XFT8ZLPdT8KLBgH96dQsIPl2mIyodA4V72JHBNqhHCplePmptMQ9heG4LBHNq0AoCZKV2Wmc5gHuC_der75zJzTmOS6xAiMk2l4TziRWqwZkYRt2JKU3dqLGd|


  @metodoResultadoListaCotizar
  Scenario Outline: Resultado de lista a cotizar de los Clientes
    Given el Usuario realiza la configuracion del metodo ResultadoListaCotizar
    When consume el metodo Get "<metodoResultadoListaCotizar>" con los paramteros idCLiente "<idCLiente>",idLocalidadOrigen"<idLocalidadOrigen>",idLocalidadDestino"<idLocalidadDestino>",peso"<peso>",valorDeclarado"<valorDeclarado>",idTipoEntrega"<idTipoEntrega>",fecha"<fecha>"
    Then  puede ver la lista de cotizacion de los clientes

    Examples:
      | metodoResultadoListaCotizar | idCLiente | idLocalidadOrigen | idLocalidadDestino | peso | valorDeclarado | idTipoEntrega | fecha      |
      | ResultadoListaCotizar       | 996      | 11001000          | 05001000           | 3    | 150000         | 1             | 25-08-2022 |


  @metodoEstadoGuiasCliente
  Scenario Outline: Consulta Estado Guias Cliente
    Given el cliente configura el usuario "<usuario>", token "<token>" y idCliente "<idCliente>"
    When consume el metodo Post "<metodoEstadoGuias>"
    Then obtiene el estado logistico de las guias

    Examples:
      | metodoEstadoGuias            | idCliente | usuario    | token |
      | ConsultarEstadosGuiasCliente | 996      | userCopidrogaspruebasPRUE |bearer 1aaCeHNgpuCU-3sQ8oaNDL7frGBxd7lh6IyJh-eGS9HfN48coZVueh9gLh9ffAUx7GrBvuC823tma2rZlTPKpzUtj9rZBeOCWbTEadRENduskbUzieNDy-sMzPoWih_jnkX1Tl0XFT8ZLPdT8KLBgH96dQsIPl2mIyodA4V72JHBNqhHCplePmptMQ9heG4LBHNq0AoCZKV2Wmc5gHuC_der75zJzTmOS6xAiMk2l4TziRWqwZkYRt2JKU3dqLGd|
