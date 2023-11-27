Feature: adding conditional Loops

  Background:
    * url baseURl

  Scenario: create user and then get the first user by id
    Given path mainURl
    * param page = '1'
    * def multiP = { page:'1',name:'lokesh'}
    * params multiP
    * def headValues = { Content-Type: 'application/json' }
    * headers headValues
    When method get
    Then assert responseStatus == 200
    * if (responseStatus == 200) karate.call('getAllUserDeatils.feature')