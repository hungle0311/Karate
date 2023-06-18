@apiTest
Feature: Create Users

  Background:
    * def URL  = createUserUrl
    * def requestData = read ('classpath:resources/requests/createUser.json')
    * def responseData = read ('classpath:resources/responses/createUser.json')
    * def name = "ARB"
    * def hardcodedRequestData =
    """
    {
    "name": "Test User",
    "username": "testuser",
    "email": "test@user.com",
    "address": {
      "street": "Has No Name",
      "suite": "Apt. 123",
      "city": "Electri",
      "zipcode": "54321-6789"
    }
  }
    """

  @createUser
  Scenario: create a user with hardcoded request data
    Given url URL
    And request requestData.createUser
    # And header Authorization = 'DoZSsCCiTFEx8jIm67F4mM7RWh_NLEVd'
    And header Accept = 'application/json'
    When method post
    Then status 201
    And match response.id ==  '#number'

  @createUser
  Scenario: create a user with embedded expression
    Given url URL
    And request {"name": #(name),"username": "testuser","email": "test@user.com","address": {"street": "Has No Name","suite": "Apt. 123","city": "Electri","zipcode": "54321-6789"}}
    # And header Authorization = 'DoZSsCCiTFEx8jIm67F4mM7RWh_NLEVd'
    And header Accept = 'application/json'
    When method post
    Then status 201
    And match response.id ==  '#number'

