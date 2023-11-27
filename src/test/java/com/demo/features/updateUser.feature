Feature: sample karate test script

  Background:
    * url baseURl
    * def jsonFiles = Java.type('com.demo.utill.UntillMethods')
    * def now = function(){ return java.lang.System.currentTimeMillis() }

  Scenario: create user and then get the first user by id
    Given path mainURl+'/801'
    * def json = jsonFiles.jsonFile("updateUser.js")
    * def name = 'Test-' + now()
    * replace json.userName = name
    And request json
    * def headValues = { Authorization: 'Bearer 7232803c821bc49a0bd5c56d7df39c5289168e323fb17c5b6b1597d8941e33ef', Content-Type: 'application/json' }
    * headers headValues
    When method patch
    Then status 200
    And match response.email contains name
    And match response.name == name
    And match response.gender != 'inactive'
