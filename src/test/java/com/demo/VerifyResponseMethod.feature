Feature: sample karate test script

  Background:
    * url baseURl
    * def jsonFiles = Java.type('com.demo.utill.UntillMethods')
    * print "Displaying ::: "+jsonFiles.jsonFile("\\src\\test\\resources\\JsonFiles\\","CreateUser.xml")
    * def requestXMLBody = karate.readAsString('classpath:CreateUser1.xml')

  #Scenario: get all users and then get the first user by id
   # Given path '/public/v2/users'
    #When method get
    #Then status 200
    #And match $  contains { "id": 2549, "name": "Anilabh Saini","email": "saini_anilabh@hudson.info","gender": "female","status": "inactive"}
    #And print "responseCookies ::: "+responseCookies
    # And match responseCookies == null
    # * def contentType = responseHeaders['Content-Type'][0]
    # And match contentType != "application/json; charset=utf-8"

  Scenario: get all users and then get the first user by id
    Given path mainURl
    And request requestXMLBody
    When method post
    Then status 401