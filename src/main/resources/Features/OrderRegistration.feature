Feature: Order registration

  Scenario: Register a new order
    When user navigates to the LUMA page
    And user clicks on the Consent button
    Then the page with the title 'Home Page' should be displayed
    When the user clicks on the Sign In link
    Then the page with the title 'Customer Login' should be displayed
    When the user clicks on the 'Create an Account' button
    When the user enters valid account details
    And submits the registration form
    Then the page with the title 'My Account' should be displayed
    When user navigates to the LUMA page
       Then the page with the title 'Home Page' should be displayed
    When user select the product with the name 'Hero Hoodie', size 'M', color 'Black'
    And   clicks on the Add to cart button
    Then a success message should be displayed

