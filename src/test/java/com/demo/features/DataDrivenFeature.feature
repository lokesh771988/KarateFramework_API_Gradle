Feature: sample karate test script

  Scenario: convert array of primitives into array of objects
   * table cats
    | id   |
    | 108  |
  * def result = call read('getUserDetails.feature') cats
  * def created = $result[*].response
  * match created[*].id contains [108]
    * match created[*].name contains [108]