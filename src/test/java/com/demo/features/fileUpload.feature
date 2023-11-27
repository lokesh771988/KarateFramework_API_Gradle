Feature: Upload File

  Background:
    * url fileBaseUrl
    * def jsonFiles = Java.type('com.demo.utill.UntillMethods')
    * def image = read(jsonFiles.getFile('apache-tomcat.jpg'))
    * def pdf = read(jsonFiles.getFile('Email Outbound Design Notes.pdf'))


  Scenario: upload Files like word excel PDF and Image Files
    Given path fileEndUrl
    #And multipart file file = { value: '#(pdf)', filename: 'myFile', contentType: 'image/jpeg'}
    #And multipart file file = { value: '#(pdf)', filename: 'myFile', contentType: 'application/pdf'}
    And multipart field image = read('Testing.xlsx')
    And header Content-Type = 'multipart/related'
    When method post
    Then status 200