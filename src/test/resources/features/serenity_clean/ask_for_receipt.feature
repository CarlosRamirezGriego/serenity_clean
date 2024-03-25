Feature: Ask for a receipt


  Scenario: Order several items
    Given the Products have the following Prices
    | Product             | Price |
    | regular cappuccino  | 1.90  |
    | large cappuccino    | 2.25  |
    | muffin              | 1.25  |
    Given Cathy has ordered
    | Quantity  | Product           |
    | 1         | large cappuccino  |
    | 2         | muffin            |
    When she asks for a receipt
    Then she should receive a receipt totalling:
    | Subtotal  | Service fee | Total |
    | 4.75      | 0.18        | 4.93  |

