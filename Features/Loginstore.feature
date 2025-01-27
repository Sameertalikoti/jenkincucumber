Feature: Login
@sanity 
Scenario: Successful Login With Valid Credentials
	Given User Launch Chrome Broswer
	When user Opens URL "https://admin-demo.nopcommerce.com/login"
	And User enters Email "admin@yourstore.com" and Password "admin"
	And Click on Login button
	Then Page title should be "Just a moment..."
	And Close Browser
 
 @regression
Scenario Outline: Successful Login With Valid Credentials
	Given User Launch Chrome Broswer
	When user Opens URL "https://admin-demo.nopcommerce.com/login"
	And User enters Email "<email>" and Password "<password>"
	And Click on Login button
	Then Page title should be "Just a moment..."
	And Close Browser	
	
	Examples:
	|email|password|
	|admin@yourstore.com|admin|
	|@yourstore.com|admin|