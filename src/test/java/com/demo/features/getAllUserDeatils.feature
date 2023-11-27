@report=true
Feature: sample karate test script

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
    #* match response[0].name == 'Trilokesh Deshpande III'
    #* match response[0].gender == 'female'
    #* match response[4].status != 'active'
    #* match response[0].email contains 'deshpande'