Feature: Testing of the Logging Application
  // in this case we change additional step and create one long step with 2 parameters - so they will be passed to the method as regular experession

  Scenario: Successful login to the app Using DataTables APPROACH 2
    Given Customer is on official app web
    When Customer enters correct login credentials2
      | login      | password |
      | mngr312054 | yjabYvA  |
    And Customer clicks Login button
    Then Customer is successfully Logged in to the application
    
    
      Scenario Outline: Transformation construct used for Login to the page
    Given Customer is on official app web
    When Customer enters correct login & <password>
     
    And Customers login is the prefix for "email" domain
    And Numbers of characters in the correct <password> length
    And Customer clicks Login button
    Then Customer is successfully Logged in to the application
    
    Examples:
     | login      | password | email 			|
     | mngr322726 | ratahYn  | mngr312054	|