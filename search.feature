Feature: Search
#This is how background can be used to eliminate duplicate steps

  Background:
  User navigates to Amazon
  Given I am on Amazon home page

#Scenario with AND
  Scenario: 
    When I enter search text as "jeans"
    And I click search button
    Then I should see "jeans" in the search results

