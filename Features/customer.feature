Feature:Customer


Background:

Given User Launch Chrome browser
When User opens URL "https://admin-demo.nopcommerce.com/login"
And Users enters Email as "admin@yourstore.com" and password as "admin"
And Click on Login
Then User can view Dashboard


@smoke
Scenario: Add new Customer

When user click on customer menu
And click on customer menu item 
And click on Add new button
Then User can view Add new customer page
And User enter customer info
And click on save button 
Then User can view confirmation message "The new customer has been added successfully."
And close browser


@regression
Scenario: Searching new customer by EmailID


When user click on customer menu
And click on customer menu item
And Enter customer Email
When click on search button 
Then User should found in the search table 
And close browsers









