Feature: Validating Sprint module
Scenario: Creating a sprint with valid data 
Given Open the Browser and launch the application	
When enter the homepage
And click on Add Sprint
And enter valid data
And click on save
Then close the Browser

Scenario: Creating a sprint with invalid data
Given Open the Browser and launch the application	
When enter the homepage
And click on Add Sprint
And enter invalid data
And click on save
Then close the Browser