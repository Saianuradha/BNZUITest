#Author: saianuradha24@gmail.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: Test Scenarios for Payment

  Background: 
    Given I launch bnz home page second
    When I click on MenuButton second

  @run
  Scenario Outline: Navigate to Payments Page
    When I Navigate to PaymentsPage
    And I click on <From Account>
    And I click on <To Account>
    And I enter amount "<value>"
    And I click on Transer button
    And I see Success message
    Then I verify Transaction

    Examples: 
      | From Account | To Account | value |
      | Everyday     | Bills      |   500 |
      | Everyday     | Bills      |   200.50 |
      | Everyday     | Bills      |   400 |

