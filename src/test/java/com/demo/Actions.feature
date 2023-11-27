Feature: sample karate test script

  Scenario: get all users and then get the first user by id
    Given def color = 'red '
    And def num = 5
    Then assert color + num == 'red 5'
    * print 'it successfull'
    * def text = 'hello <foo> world'
    * replace text.foo = 'bar'
    * match text == 'hello bar world'