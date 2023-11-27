Feature: sample karate test script

  Background:
    * url baseURl

  Scenario: get all users and then get the first user by id
    Given path mainURl+'/7'
    * header Authorization = 'Bearer 7232803c821bc49a0bd5c56d7df39c5289168e323fb17c5b6b1597d8941e33ef'
    When method delete
    Then status 404
    And match response.message == 'Resource not found'