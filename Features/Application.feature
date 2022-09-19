#Author: bharath.nittech@gmail.com (Bharath)
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: Parabank Login Feature
  I want to use this feature file to validate application login functionality , forgotpassword and registration features

  Background: Launch the application
    Given Launch the parabank application with "https://parabank.parasoft.com/parabank/index.htm"

  @Smoke
  Scenario: Verify Application Title
    Then Application title should be "ParaBank | Welcome | Online Banking"

  @Smoke
  Scenario: Verify Application Caption
    Then Application caption should be "Experience the difference"

  @Sanity @Regression
  Scenario Outline: Verify Application Login
    When I Eneter <Username> and <Password>
    And I Clicked on Login button
    Then Account overview page should be displayed

    Examples: 
      | Username       | Password |
      | bharathnittech | demo     |
      | Abc1           | abc12345 |
      | XYZ            | xyz123   |

  @Sanity
  Scenario: Verify Registration Page
    When I clicked on Registration link in the loginpage
    Then Registration page should be launched

  @Sanity
  Scenario: Verify Reset Password Page
    When I clicked on Forgot password link in the loginpage
    Then Forgot Password page should be launched
