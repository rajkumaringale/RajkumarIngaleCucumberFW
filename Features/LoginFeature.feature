Feature: Login
  @sanity 
  Scenario: Successful Login with Valid Credentials
    Given User Launch Chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on Login button
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User click on Logout button
    Then Page Title should be "Your store. Login"
    And Close browser
    
  @regression
  Scenario Outline:  Successful Login with Valid Credentials DDT
  Given User Launch Chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "<email>" and Password as "<password>"
    And Click on Login button
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User click on Logout button
    Then Page Title should be "Your store. Login"
    And Close browser
    
    Examples: 
    |email| password|
    |admin@yourstore.com|admin|
    |test@yourstore.com|admin|
              