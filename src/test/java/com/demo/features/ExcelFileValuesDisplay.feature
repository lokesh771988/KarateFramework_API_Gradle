Feature: Excel Files Values display

  Background:
    * def jsonFiles = Java.type('com.demo.utill.ExcelFileReading')

  Scenario: excel values
    * def json =  jsonFiles.jsonValue("Sheet1","Sheet2","TC01")
    * print json