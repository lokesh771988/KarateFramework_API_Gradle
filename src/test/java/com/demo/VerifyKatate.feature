Feature: sample karate test script

  Background:
    * url baseURl

  Scenario: get all users and then get the first user by id
    Given path mainURl
    When method get
    Then status 200
    * print "user is able to verify status"