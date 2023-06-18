@apiTest
Feature: Create Users with variable from the other feature file

  Background:
    * def URL  = createUserUrl

  Scenario: Create Users with variable from the other feature file

    Given url URL
    And request {"name": #(name),"username": "testuser","email": "test@user.com","address": {"street": "Has No Name","suite": "Apt. 123","city": "Electri","zipcode": "54321-6789"}}
    # And header Authorization = 'DoZSsCCiTFEx8jIm67F4mM7RWh_NLEVd'
    And header Accept = 'application/json'
    When method post
    Then status 201
    And match response.id ==  '#number'

