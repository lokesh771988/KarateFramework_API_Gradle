Feature: Testing Java Funcation Call

  Scenario:
    * def adder = function(a, b){ return a + b }
    * assert adder(1, 2) == 3

    * def greeter = function(title, name) { return 'hello ' + title + ' ' + name }
    * assert greeter('Mr.', 'Bob') == 'hello Mr. Bob'