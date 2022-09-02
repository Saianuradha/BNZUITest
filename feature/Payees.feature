Feature: Test Scenarios for Payee
Background: 
 Given I launch bnz home page
 When I click on MenuButton
 When I click on Payee option

Scenario: Verify user is navigated to Payee Page from navigation Menu
    Then Payees page is loaded
    
   
Scenario Outline: Verify user can add new payee in the payeepage
When I click add payee
And I enter payee details < name > & < account > 
And I click on Add button
Then I see "Payee is Added" message.

Examples: 
|name|account| 
|Anu|01-1234-1231234-000|

@run
Scenario Outline: Verify Payee name is a mandatory field
When I click add payee
And I click on Add button
And I see the validation message
And I enter payee details < name > & < account > 
Then I verify errors are gone 

Examples: 
|name|account|
|Anu|0112341231234000| 







     
      