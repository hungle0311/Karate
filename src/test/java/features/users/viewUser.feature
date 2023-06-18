@apiTest
Feature: View User details

  Background:
    * def requestData = read ('classpath:resources/requests/createUser.json')
    * def responseData = read ('classpath:resources/responses/viewUser.json')
    * def dataFile = read ('classpath:resources/dataFiles/users.csv')

  @viewUser
  Scenario: get all users
    Given url baseUrl
    And path 'users'
    When method get
    Then status 200
    And match response == '#[10]'
    And match $ == '#[10]'
    # Verify each item of the array, they should be matched with the response schema
    And  match each response contains deep responseData.userDetail
    And match $.[0].id == 1
    # Get value of properties using jsonPath
    # Karate.jsonPath(doc, jsonPathExpression)
    * def company = karate.jsonPath(response, "$[?(@.id == 3)].company)")
    And print company

  @viewUser
  Scenario Outline: get user with Scenario Outline
    Given url baseUrl
    Given path 'users', <id>
    When method get
    Then status 200
    # Verify the response contains the piece of data
    And match $ contains deep {"company":{"name":<name>},"company":{"name":<company>}}
    And match $ contains {id:"#notnull"}

    Examples:
      | id |name|company|
      | 1  |Bret|Romaguera-Crona|
      | 2  |Antonette|Deckow-Crist|
      | 7  |Elwyn.Skiles|Johns Group|
      | 9  |Delphine|Yost and Sons|

  @viewUser
  Scenario Outline: get user by id <id> from external file CSV
    Given url baseUrl
    Given path 'users', <id>
    When method get
    Then status 200

    Examples:
      |read ('classpath:resources/dataFiles/users.csv')|

  @viewUser
  Scenario: get user by calling the other feature
    Given def createdUser = call read("createUserWithVariables.feature") {name:"GFT"}
    And print "CustomerId--",createdUser.response.name

