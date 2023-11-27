Feature: sample karate test script

  Background:
    * url baseURl

  Scenario: get all users and then get the first user by id
    * print "My ID ::: "+id
    * def myId = id
    Given path mainURl,myId
    * header Authorization = 'Bearer '+authToken
    When method get
    Then status 200