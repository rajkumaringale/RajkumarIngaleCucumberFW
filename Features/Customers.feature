Feature: Customers
Background:  Common steps for all scenarios
    Given User Launch Chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on Login button
    Then User can View Dashboard
  @sanity
  Scenario: Add New Customer
    When User Click on Customers Menu
    And Click on Customers Menu Item
    And Click on Add new button
    Then User can view Add new customer page
    When User enter customer info
    And Click on save button
    Then User can view confirmation Message "The new customer has been added successfully"
    And Close browser
   
    @regression
    Scenario: Search customer by Email
    
    When User Click on Customers Menu
    And Click on Customers Menu Item
    And Enter customer Email
    When Click on search button
    Then User should found Email in the search table
    And Close browser
    
    @regression
    Scenario: Search Customer by Name
    
    When User Click on Customers Menu
    And Click on Customers Menu Item
    And Enter customer Firstname
    And Enter customer Lastname
    When Click on search button 
    Then User should found Name in the Search table
    And Close browser
    