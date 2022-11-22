@integraciones

Feature: Validar El Consumo De Las APIS De Venta Credito


  @metodoInsertarAdmisionCliente
  Scenario:  Creacion de Pre Envios
    Given registro de datos cliente credito y destinatario
    When  consume de servicio InsertarAdmision
    Then  generacion de numero de preenvio

  @metodoInsertarRecogidaCliente
  Scenario: Creacion de Recogidas
    Given registro de datos cliente credito y de preenvio(s) a recoger
    When consume el metodo  llamado InsertarRecogidaCliente
    Then generacion de numero de recogida


  @metodoObtenerEstadosGuias
  Scenario: Obtener estado de las guias
    Given el cliente realiza consulta  de estados de las Guias
    When consume el metodo llamado ObtenerEstadosGuias
    Then evienciar  los estados logisticos de las guias

  @metodoObtenerPdfPreGuia
  Scenario: Obtener el formato de Pre envios para su impresion uno a uno
    Given registro de datos cliente credito
    When consume el metodo ObtenerBasePdfPreGuia
    Then  evienciar  el formato etiqueta uno a uno


  @metodoObtenerPdfPreGuiaLote
  Scenario: Obtener el formato de Pre envios para su imprersion por lotes
    Given registro de datos cliente credito y preenvios a consultar
    When consume el metodo  ObtenerBasePdfPreGuias
    Then  evienciar  el formato etiqueta por lote


  @metodoResultadoListaCotizar
  Scenario: Resultado de lista a cotizar de los Clientes
    Given el Usuario realiza la configuracion del metodo ResultadoListaCotizar
    When consume el metodo ResultadoListaCotizar
    Then  evienciar  la lista de cotizacion de los clientes


  @metodoEstadoGuiasCliente
  Scenario: Consulta Estado Guias Cliente
    Given el cliente configura el usuario
    When consume el metodo Post ConsultarEstadosGuiasCliente
    Then obtiene el estado logistico de las guias



