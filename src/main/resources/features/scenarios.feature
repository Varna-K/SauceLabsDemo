@SauceLabs_demo_scenarios
Feature: Checkout Scenarios for Sauce Labs

  Background: Logged in user on Saucelabs
   Given I visit SauceLabs page
    When I login as a registered user
    
  @SimpleCheckout
  Scenario: Scenario1_Select and checkout   
    And I select the "Sauce Labs Bolt T-Shirt" from the inventory
    And I select the "Sauce Labs Onesie" from the inventory
    When I proceed to checkout
    Then I confirm the cart contents
    Then I should see checkout completion page
    
  @RemoveAndCheckout
   Scenario: Scenario2_Remove and checkout   
    And I select the "Sauce Labs Bolt T-Shirt" from the inventory
    And I select the "Sauce Labs Bike Light" from the inventory
    Then I confirm the cart contents
    Then I remove "Sauce Labs Bike Light" from the cart
    Then I select the "Sauce Labs Backpack" from the inventory
    Then I confirm the cart contents
    When I proceed to checkout
    Then I should see checkout completion page
    
   @SelectLowestPriceAndCheckout
   Scenario: Scenario3_Select Lowest Price and Checkout  
  	And I select 2 lowest priced products
    Then I confirm the cart contents
    When I proceed to checkout
    Then I should see checkout completion page
    
