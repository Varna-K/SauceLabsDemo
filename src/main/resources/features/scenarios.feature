@SauceLabs_demo_scenarios
Feature: Checkout Scenarios for Sauce Labs

  Background: Logged in user on Saucelabs
   Given I visit SauceLabs page
    When I login as a registered user
    
  @SimpleCheckout
  Scenario: Scenario1_Select and checkout 
  	And I add the products to inventory
  	|Sauce Labs Bolt T-Shirt|Sauce Labs Onesie|
    Then I confirm the cart contents
    When I proceed to checkout
    Then I should see checkout completion page
    
  @RemoveAndCheckout
   Scenario: Scenario2_Remove and checkout   
   	And I add the products to inventory
  	|Sauce Labs Bolt T-Shirt|Sauce Labs Bike Light|
    Then I confirm the cart contents
    Then I remove the product from the cart
    |Sauce Labs Bike Light|
    And I add the products to inventory
  	|Sauce Labs Backpack|    
    Then I confirm the cart contents
    When I proceed to checkout
    Then I should see checkout completion page
    
   @SelectLowestPriceAndCheckout
   Scenario: Scenario3_Select Lowest Price and Checkout  
  	And I select 2 lowest priced products
    Then I confirm the cart contents
    When I proceed to checkout
    Then I should see checkout completion page

