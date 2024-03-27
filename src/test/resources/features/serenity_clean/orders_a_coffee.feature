Feature: Order a coffee

  In order to save time when I pick up my morning coffee
  As a coffee lover
  I want to be able to order my coffee in advance

  Scenario: Buyer orders a coffee when they are close to the coffee shop
    Given Cathy is 1 meter from the coffee shop
    When Cathy orders a Large cappuccino
    Then Barry should receive an order
    And Barry should know that the coffee priority is Urgent


  Scenario: Buyer orders a coffee when they are not so close to the coffee shop
    Given Cathy is 250 meters from the coffee shop
    When Cathy orders a Large cappuccino
    Then Barry should receive an order
    And Barry should know that the coffee priority is Normal


  Scenario: Buyer orders a coffee when they are far from the coffee shop
    Given Cathy is 550 meters from the coffee shop
    When Cathy orders a Large cappuccino
    Then Barry should receive an order
    And Barry should know that the coffee priority is Low