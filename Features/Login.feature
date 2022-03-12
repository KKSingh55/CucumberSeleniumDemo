Feature: Login

Background:

Given User Launch Chrome browser
When User opens URL "https://admin-demo.nopcommerce.com/login"
And Users enters Email as "admin@yourstore.com" and password as "admin"
Then Click on Login
Then page Title should be "Dashboard / nopCommerce administration"

@smoke
Scenario: Successful Login with valid credentials

When User click on Log out link
Then Page title should be "Your store. Login"
And close browser


Scenario Outline: login Data driven
When User click on Log out link
Then Page title should be "Your store. Login"
And close browser

Examples:
|Email                 |  Password|
|admin@yourstore.com   |   admin  |
|admin1@yourstore.com  |   admin123|
|admin1345@yourstore.com| admin13223|


