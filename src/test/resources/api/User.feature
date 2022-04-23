Feature: User
  As an admin
  I want to get detail user
  So that I can update the user data

  Scenario: GET - As admin I have be able to get detail user
    Given I set Api endpoints
    When I send GET HTTP request
    Then I receive valid HTTP response code 200
    And I receive valid data for detail user

  Scenario: POST - As admin I have be able to create new user
    Given I set Api endpoints
    When I send POST HTTP request
    Then I receive valid HTTP response code 201
    And I receive valid data for new user

  Scenario: PUT - As admin i have be able to update existing user
    Given I set Api endpoints
    When I send PUT HTTP request
    Then I receive valid HTTP response code 200
    And I receive valid data for updated user

  Scenario: DELETE - As admin i have be able to delete existing user
    Given I set Api endpoints
    When I send DELETE HTTP request
    Then I receive valid HTTP response code 204