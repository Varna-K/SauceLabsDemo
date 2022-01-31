@SauceLabs_demo_scenarios
Feature: Checkout Scenarios for Sauce Labs

  Background: Logged in user on Saucelabs
   Given I visit SauceLabs page
    When I login as a registered user
    
  @SimpleCheckout
  Scenario: Scenario1_Select and checkout   
    And I add the "Sauce Labs Bolt T-Shirt" to the inventory
    And I add the "Sauce Labs Onesie" to the inventory
    Then I confirm the cart contents
    When I proceed to checkout
    Then I should see checkout completion page
    
  @RemoveAndCheckout
   Scenario: Scenario2_Remove and checkout   
    And I add the "Sauce Labs Bolt T-Shirt" to the inventory
    And I add the "Sauce Labs Bike Light" to the inventory
    Then I confirm the cart contents
    Then I remove "Sauce Labs Bike Light" from the cart
    Then I add the "Sauce Labs Backpack" to the inventory
    Then I confirm the cart contents
    When I proceed to checkout
    Then I should see checkout completion page
    
   @SelectLowestPriceAndCheckout
   Scenario: Scenario3_Select Lowest Price and Checkout  
  	And I select 2 lowest priced products
    Then I confirm the cart contents
    When I proceed to checkout
    Then I should see checkout completion page
    
