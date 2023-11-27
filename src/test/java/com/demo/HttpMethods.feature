Feature: sample karate test script

  Background:
    * url 'https://gorest.co.in'

  Scenario: get all users and then get the first user by id
    Given path '/public/v2/users'
    When method get
    Then assert responseStatus == 200 || responseStatus == 201
    #And def json = { "id": 2536,  "name": "Akula Dhawan",  "email": "dhawan_akula@harris.info",  "gender": "male",  "status": "active"}
    #And match $ contains json
    * def contentType = responseHeaders['Content-Type'][0]
    And match contentType == "application/json; charset=utf-8"
    And match responseCookies == null
    * print "responseTime :: "+responseTime
    * print "responseType :: "+responseType
    #And match responseTime == 500
    * def data = { foo: [1, 2, 3] }
    * match data.foo contains only [3, 2, 1]
    * match data.foo contains any [9, 2, 8]
    * def foo = { bar: 1, baz: 'hello', ban: 'world' }
    * match foo !contains { bar: 2 }
    * def text = 'hello <foo> world'
    * replace text.foo = 'bar'
    * match text == 'hello bar world'