Feature: sample karate test script

  Background:
    * url baseURl
    #* def userDetails = call read('classpath:com/demo/features/createUser.feature')
    * def userDetails = callonce read('classpath:com/demo/features/createUser.feature')

  Scenario: get users and then get the first user by id

    Given path mainURl,userDetails.userID
    * header Authorization = 'Bearer '+authToken
    When method get
    Then status 200

  Scenario: get users and then get the first user by id

    Given path mainURl,userDetails.userID
    * header Authorization = 'Bearer '+authToken
    When method get
    Then status 200