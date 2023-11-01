Feature: GitHub Repository Search and Navigation

  Scenario Outline: Search for a Repository and navigate to the About page as a guest user
    Given User visit on the Github site
    When User search for "<searchTerm>" from the landing page
    Then User verify with "<searchResult>"
    When User click on the About button in the landing page footer
    Then  User verify the About page
    Examples:
      | searchTerm         | searchResult            |
      | create-react-app | facebook/create-react-app |