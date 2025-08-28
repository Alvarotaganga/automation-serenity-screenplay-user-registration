Feature: Registro de usuario en Automation Exercise
  Como nuevo visitante
  Quiero registrarme en la página
  Para poder crear una cuenta y usar sus servicios

  @crear_usuario
  Scenario Outline: Crear un nuevo usuario exitosamente
    Given que el usuario abre la página de Automation Exercise
    When el usuario se registra en la página con los datos:
      | nombre    | <nombre>   |
      | email     | <email>    |
      | password  | <password> |
      | firstname | <firstname>|
      | lastname  | <lastname> |
      | address   | <address>  |
      | state     | <state>    |
      | city      | <city>     |
      | zipcode   | <zipcode>  |
      | phone     | <phone>    |
      | genero    | <genero>   |
      | dia       | <dia>      |
      | mes       | <mes>      |
      | ano       | <ano>      |
    Then debería ver un mensaje de confirmación de cuenta creada

    Examples:
      | nombre  | email              | password | firstname | lastname | address       | state     | city     | zipcode | phone        | genero   | dia |   mes    |  ano  |
      | Alvaro  | alvarope@tessestet.com    | 12345   | Alvaro    | Perez    | Calle 123     | Antioquia | Medellin | 05001   | 3001234567  | Mr     | 18  | January   | 1990 |
      | Camila  | camilaro@tessestet.com    | abcde   | Camila    | Rojas    | Carrera 45 #2 | Cundin.   | Bogotá   | 11001   | 3119876543  | Mrs    | 4   | October   | 1985 |
