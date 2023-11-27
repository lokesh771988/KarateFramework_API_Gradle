Feature: scanarios outline Testing

  Background:
    * url 'https://gorest.co.in'

  Scenario Outline: given circuit name, validate country
    Given path '/public/v2/users',id
    * header Authorization = 'Bearer '+authToken
    When method get
    Then status 200

    Examples:
      | id   |
      | 108  |