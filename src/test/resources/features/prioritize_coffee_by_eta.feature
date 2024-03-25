Feature: Prioritising orders

  Scenario Outline: Prioritise orders according to client ETA
    Given Cathy has ordered a Regular espresso
    And Cathy is <ETA> minutes away
    When Barry reviews the pending orders
    Then Barry should know that the coffee priority is <Urgency>
    Examples:
      | Rule                      | ETA | Urgency |
      | More than 10 minutes away | 12  | Low     |
      | Between 5 and 10 minutes  | 7   | Normal  |
      | Less than 5 minutes away  | 3   | Urgent  |
