@etsy
Feature: Etsy search functionality

  Scenario: Search result title verification
    Given user is on Etsy home page
    When user enters "silk scarf" into search box
    And clicks enter
    Then user should see "Silk scarf - Etsy" in title
