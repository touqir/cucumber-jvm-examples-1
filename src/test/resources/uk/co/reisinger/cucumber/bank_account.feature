# https://github.com/cucumber/cucumber/wiki/_pages

# https://github.com/cucumber/cucumber/wiki/Feature-Introduction
Feature: Bank Account deposit and withdrawal
  This feature proves that the bank account shows
  the correct balance after deposit and/or withdrawal

  Scenario: Make deposit
    Given bank account with balance 0 pence
    When I deposit 1000 pence
    Then the balance should be 1000 pence

  # https://github.com/cucumber/cucumber/wiki/Scenario-Outlines
  Scenario Outline: Multiple transactions
    Given bank account with the following transactions:
      | type | pence |
      | +    | 10000 |
      | -    | 5000  |
      | -    | 5000  |
    When I make <deposit>
    And  make <withdrawal>
    Then the balance should be <balance> pence

  Examples: Transactions
    | deposit | withdrawal | balance |
    | 500     | 0          | 500     |
    | 500     | 200        | 300     |
    | 100     | 50         | 50      |
