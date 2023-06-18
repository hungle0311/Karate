@apiTest
Feature: JavaScript

  Scenario: Execute javaScript fucntion

    * def getRandomValue = function() {return Math.floor((100) * Math.random());}
    Then print getRandomValue()
