
@tag
Feature: Test Scenarios for Payee
Background: 
 Given I launch bnz home page
 When I click on MenuButton
 When I click on Payee option

Scenario: Verify user is navigated to Payee Page from navigation Menu
    Then Payees page is loaded
    
    
Scenario: Verify user can add new payee in the payeepage

#
  #@tag2
  #Scenario Outline: Title of your scenario outline
    #Given I want to write a step with <name>
    #When I check for the <value> in step
    #Then I verify the <status> in step
#
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
