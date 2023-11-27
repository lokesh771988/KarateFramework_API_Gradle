Feature: sample karate test script


  Scenario: create user and then get the first user by id
    * def doWork =
  """
  function(arg) {
    var JavaDemo = Java.type('com.demo.utill.UntillMethods');
    var jd = new JavaDemo();
    return jd.doWork(arg);
  }
  """
# in this case the solitary 'call' argument is of type string
    * def result = call doWork 'world'
    * match result == { someKey: 'hello world' }