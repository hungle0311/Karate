@apiTest
Feature: Get the JWT token

  Background: Login and get the token
    Given url 'https://restful-booker.herokuapp.com/auth'
    And headers {Accept:'application/json', Content-Type:'application/json'}
    And request {username: #(username), password: #(password)}
    When method post
    Then status 200
    And def authToken = response.token
    And print "Token:",authToken

  @authentication
  Scenario: Update a booking
    Given url 'https://restful-booker.herokuapp.com/booking/10770'
    And request {"firstname" : "James","lastname" : "Brown"}
    And headers {Content-Type:'application/json'}
    And headers {Accept:'application/json', Cookie:'#("token=" + authToken)'}
    When method patch
    Then status 200
    And print "Book has been updated:", response
